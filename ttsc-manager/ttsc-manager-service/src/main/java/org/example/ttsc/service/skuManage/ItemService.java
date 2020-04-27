package org.example.ttsc.service.skuManage;

import org.example.ttsc.entity.TbItem;

import java.util.List;

public interface ItemService {

    List<TbItem> getItemList(Integer pageNum,Integer pageSize);
}
