package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbOrder;

public interface TbOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(TbOrder record);

    TbOrder selectByPrimaryKey(String orderId);

    List<TbOrder> selectAll();

    int updateByPrimaryKey(TbOrder record);
}