package org.example.ttsc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.ttsc.dao.*;
import org.example.ttsc.entity.*;
import org.example.ttsc.pojo.CatParamDto;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.TaotaoResult;
import org.example.ttsc.service.ItemService;
import org.example.ttsc.utils.IDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper itemMapper;

    @Resource
    private TbItemDescMapper itemDescMapper;

    @Resource
    private TbItemParamMapper itemParamMapper;

    @Resource
    private TbItemCatMapper itemCatMapper;

    @Resource
    private TbItemParamItemMapper paramItemMapper;

    /**
     * 查询商品列表
     */
    @Override
    public EUDataGridResult getItemList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbItem> tbItems = itemMapper.selectAll();

        EUDataGridResult result = new EUDataGridResult();
        result.setRows(tbItems);

        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItems);
        result.setTotal(tbItemPageInfo.getTotal());
        return result;
    }

    /**
     * 新增商品接口
     */
    @Override
    @Transactional
    public TaotaoResult saveItem(TbItem tbItem, String desc, String itemParams) {

        long itemId = IDUtil.genItemId();
        Date date = new Date();

        tbItem.setId(itemId);
        // 默认商品状态为正常
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        itemMapper.insert(tbItem);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        itemDescMapper.insert(tbItemDesc);

        TaotaoResult res = saveItemParams(itemId, itemParams, date);
        if (!res.getStatus().equals(200)) {
            throw new RuntimeException();
        }

        return TaotaoResult.ok();
    }

    private TaotaoResult saveItemParams(long itemId, String itemParams, Date date) {
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(itemId);
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setCreated(date);
        tbItemParamItem.setUpdated(date);

        int res = paramItemMapper.insert(tbItemParamItem);

        if (res == 1) return TaotaoResult.ok();
        else return TaotaoResult.build(500, "插入商品规格参数失败");

    }

    @Override
    public TaotaoResult queryCatParam(Long itemCatId) {
        TbItemParam tbItemParam = itemParamMapper.selectByItemCatId(itemCatId);
        return TaotaoResult.ok(tbItemParam);
    }

    @Override
    public EUDataGridResult queryCatParamList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbItemParam> tbItemParams = itemParamMapper.selectAll();

        List<CatParamDto> res = tbItemParams
                .stream()
                .map(t -> new CatParamDto(t.getId(), t.getItemCatId(), getCatNameById(t.getItemCatId()), t.getCreated(), t.getUpdated(), t.getParamData()))
                .collect(Collectors.toList());

        EUDataGridResult result = new EUDataGridResult();
        result.setRows(res);

        PageInfo<TbItemParam> catParamPageInfo = new PageInfo<>(tbItemParams);
        result.setTotal(catParamPageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult saveCatParam(Long itemCatId, String paramData) {

        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(itemCatId);
        tbItemParam.setParamData(paramData);
        Date date = new Date();
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);

        itemParamMapper.insert(tbItemParam);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteCatParam(String idsString) {
        List<Long> ids = Arrays.stream(idsString.split(",")).map(Long::valueOf).collect(Collectors.toList());
        itemParamMapper.deleteByIds(ids);
        return TaotaoResult.ok();
    }

    private String getCatNameById(Long catId){
        TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(catId);
        return tbItemCat.getName();
    }

    public static void main(String[] args) {
        String s = "[{\"group\":\"dsddd\",\"params\":[\"sds\"]}]";
        String b = s.trim();
        System.out.println(b);
    }
}
