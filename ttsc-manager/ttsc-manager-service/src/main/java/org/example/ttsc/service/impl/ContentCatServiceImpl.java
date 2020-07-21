package org.example.ttsc.service.impl;

import org.example.ttsc.dao.TbContentCategoryMapper;
import org.example.ttsc.entity.TbContentCategory;
import org.example.ttsc.pojo.EUTreeNode;
import org.example.ttsc.pojo.TaotaoResult;
import org.example.ttsc.service.ContentCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentCatServiceImpl implements ContentCatService {

    @Resource
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EUTreeNode> getContentCatList(long parentId) {

        TbContentCategory queryParam = new TbContentCategory();
        queryParam.setParentId(parentId);
        List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectList(queryParam);

        return tbContentCategories
                .stream()
                .map(p -> new EUTreeNode(p.getId(), p.getName(), p.getIsParent()? "closed" : "open"))
                .collect(Collectors.toList());
    }

    @Override
    public TaotaoResult creatCategory(long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setName(name);
        tbContentCategory.setStatus(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setSortOrder(1);


        Date currentDate = new Date();
        tbContentCategory.setCreated(currentDate);
        tbContentCategory.setUpdated(currentDate);

        contentCategoryMapper.insert(tbContentCategory);

        // 修改父节点isParent属性
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if (!parent.getIsParent()) {
            parent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parent);
        }

        return TaotaoResult.ok(tbContentCategory);
    }

    @Override
    public TaotaoResult deleteCategory(Long parentId, Long id) {

        contentCategoryMapper.deleteByPrimaryKey(id);

        TbContentCategory queryParam = new TbContentCategory();
        queryParam.setParentId(parentId);
        List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectList(queryParam);

        if (tbContentCategories.size() == 0) {
            TbContentCategory tbContentCategory = new TbContentCategory();
            tbContentCategory.setId(parentId);
            tbContentCategory.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKey(tbContentCategory);
        }

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateCategory(Long id, String name) {

        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(id);
        tbContentCategory.setName(name);
        contentCategoryMapper.updateByPrimaryKey(tbContentCategory);

        return TaotaoResult.ok();
    }
}
