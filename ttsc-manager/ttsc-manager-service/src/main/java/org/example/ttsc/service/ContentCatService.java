package org.example.ttsc.service;

import org.example.ttsc.pojo.EUTreeNode;
import org.example.ttsc.pojo.TaotaoResult;

import java.util.List;

public interface ContentCatService {

    List<EUTreeNode> getContentCatList(long parentId);

    TaotaoResult creatCategory(long parentId, String name);

    TaotaoResult deleteCategory(Long parentId, Long id);

    TaotaoResult updateCategory(Long id, String name);
}
