package org.example.ttsc.service;

import org.example.ttsc.entity.TbContent;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.TaotaoResult;

public interface ContentService {

    EUDataGridResult queryList(Long categoryId, Integer page, Integer rows);

    TaotaoResult saveContent(TbContent tbContent);
}
