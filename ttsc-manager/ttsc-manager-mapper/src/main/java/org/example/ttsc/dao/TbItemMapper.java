package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbItem;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    List<TbItem> selectAll();

    int updateByPrimaryKey(TbItem record);
}