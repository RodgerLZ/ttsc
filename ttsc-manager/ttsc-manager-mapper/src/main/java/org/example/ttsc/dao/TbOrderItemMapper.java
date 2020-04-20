package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbOrderItem;

public interface TbOrderItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(String id);

    List<TbOrderItem> selectAll();

    int updateByPrimaryKey(TbOrderItem record);
}