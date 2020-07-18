package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbContentCategory;

public interface TbContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    List<TbContentCategory> selectAll();

    int updateByPrimaryKey(TbContentCategory record);

    List<TbContentCategory> selectByParentId(Long parentId);
}