package org.example.ttsc.service;

import org.example.ttsc.pojo.EUTreeNode;

import java.util.List;

public interface ItemCatService {

    List<EUTreeNode> getItemCatList(long parentId);
}
