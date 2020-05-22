package org.example.ttsc.service.impl;

import org.example.ttsc.dao.TbItemCatMapper;
import org.example.ttsc.entity.TbItemCat;
import org.example.ttsc.pojo.EUTreeNode;
import org.example.ttsc.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EUTreeNode> getItemCatList(long parentId) {

        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByParentId(parentId);

        return tbItemCats.stream()
                .map(p -> new EUTreeNode(p.getId(), p.getName(), p.getIsParent() ? "closed" : "open"))
                .collect(Collectors.toList());
    }
}
