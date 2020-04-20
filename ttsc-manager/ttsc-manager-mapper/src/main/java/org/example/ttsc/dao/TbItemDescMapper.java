package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbItemDesc;

public interface TbItemDescMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(TbItemDesc record);

    TbItemDesc selectByPrimaryKey(Long itemId);

    List<TbItemDesc> selectAll();

    int updateByPrimaryKey(TbItemDesc record);
}