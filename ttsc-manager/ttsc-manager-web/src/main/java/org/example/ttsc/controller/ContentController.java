package org.example.ttsc.controller;

import org.example.ttsc.entity.TbContent;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.TaotaoResult;
import org.example.ttsc.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Resource
    private ContentService contentService;

    @ResponseBody
    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public EUDataGridResult queryList(@RequestParam Long categoryId,@RequestParam Integer page,@RequestParam Integer rows) {
        return contentService.queryList(categoryId, page, rows);
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public TaotaoResult saveContent(TbContent tbContent) {
        return contentService.saveContent(tbContent);
    }
}
