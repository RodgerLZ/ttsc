package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbItemCat;

public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    List<TbItemCat> selectAll();

    int updateByPrimaryKey(TbItemCat record);

    List<TbItemCat> selectByParentId(Long parentId);
}