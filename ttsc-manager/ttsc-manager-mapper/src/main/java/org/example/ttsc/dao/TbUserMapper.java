package org.example.ttsc.dao;

import java.util.List;
import org.example.ttsc.entity.TbUser;

public interface TbUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    List<TbUser> selectAll();

    int updateByPrimaryKey(TbUser record);

    List<TbUser> selectList(TbUser tbUser);
}