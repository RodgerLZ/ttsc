package org.example.ttsc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.ttsc.dao.TbItemDescMapper;
import org.example.ttsc.dao.TbItemMapper;
import org.example.ttsc.entity.TbItem;
import org.example.ttsc.entity.TbItemDesc;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.TaotaoResult;
import org.example.ttsc.service.ItemService;
import org.example.ttsc.utils.IDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper itemMapper;

    @Resource
    private TbItemDescMapper itemDescMapper;

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

    @Override
    public TaotaoResult saveItem(TbItem tbItem, String desc) {

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

        return TaotaoResult.ok();
    }
}
