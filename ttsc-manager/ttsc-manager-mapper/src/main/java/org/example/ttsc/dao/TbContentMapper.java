package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbContent;

public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    List<TbContent> selectAll();

    int updateByPrimaryKey(TbContent record);

    List<TbContent> selectList(TbContent record);
}