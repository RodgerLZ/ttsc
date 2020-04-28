package org.example.ttsc.service;

import org.example.ttsc.pojo.EUDataGridResult;

public interface ItemService {

    EUDataGridResult getItemList(Integer pageNum, Integer pageSize);
}
