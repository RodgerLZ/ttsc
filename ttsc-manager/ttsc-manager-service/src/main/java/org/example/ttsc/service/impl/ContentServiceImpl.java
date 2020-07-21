package org.example.ttsc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.ttsc.dao.TbContentMapper;
import org.example.ttsc.entity.TbContent;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.TaotaoResult;
import org.example.ttsc.service.ContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public EUDataGridResult queryList(Long categoryId, Integer page, Integer rows) {

        PageHelper.startPage(page, rows);
        TbContent tbContent = new TbContent();
        tbContent.setCategoryId(categoryId);
        List<TbContent> tbContents = tbContentMapper.selectList(tbContent);

        PageInfo<TbContent> pageInfo = new PageInfo<>(tbContents);
        EUDataGridResult result = new EUDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(tbContents);

        return result;
    }

    @Override
    public TaotaoResult saveContent(TbContent tbContent) {

        Date currDate = new Date();
        tbContent.setCreated(currDate);
        tbContent.setUpdated(currDate);
        tbContentMapper.insert(tbContent);

        return TaotaoResult.ok();
    }


}
