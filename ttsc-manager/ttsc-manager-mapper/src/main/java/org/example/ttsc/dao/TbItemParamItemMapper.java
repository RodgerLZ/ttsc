package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbItemParamItem;

public interface TbItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    TbItemParamItem selectByPrimaryKey(Long id);

    List<TbItemParamItem> selectAll();

    int updateByPrimaryKey(TbItemParamItem record);

    List<TbItemParamItem> selectList(TbItemParamItem record);
}