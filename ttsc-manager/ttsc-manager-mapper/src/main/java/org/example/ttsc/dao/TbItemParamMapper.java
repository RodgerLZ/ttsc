package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbItemParam;

public interface TbItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    TbItemParam selectByPrimaryKey(Long id);

    List<TbItemParam> selectAll();

    int updateByPrimaryKey(TbItemParam record);
}