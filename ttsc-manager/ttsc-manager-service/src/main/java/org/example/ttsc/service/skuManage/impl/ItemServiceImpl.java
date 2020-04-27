package org.example.ttsc.service.skuManage.impl;

import com.github.pagehelper.PageHelper;
import org.example.ttsc.dao.TbItemMapper;
import org.example.ttsc.entity.TbItem;
import org.example.ttsc.service.skuManage.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper itemMapper;

    @Override
    public List<TbItem> getItemList(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return itemMapper.selectAll();
    }
}
