package org.example.ttsc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.ttsc.dao.TbItemMapper;
import org.example.ttsc.entity.TbItem;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper itemMapper;

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
}
