package org.example.ttsc.service;

import org.example.ttsc.entity.TbItem;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.TaotaoResult;

public interface ItemService {

    EUDataGridResult getItemList(Integer pageNum, Integer pageSize);

    TaotaoResult saveItem(TbItem tbItem, String desc);
}
