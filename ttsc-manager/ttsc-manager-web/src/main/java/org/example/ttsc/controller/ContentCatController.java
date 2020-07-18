package org.example.ttsc.controller;

import org.example.ttsc.pojo.EUTreeNode;
import org.example.ttsc.pojo.TaotaoResult;
import org.example.ttsc.service.ContentCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ContentCatController {

    @Resource
    private ContentCatService contentCatService;

    @ResponseBody
    @RequestMapping(value = "/content/category/list", method = RequestMethod.GET)
    public List<EUTreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return contentCatService.getContentCatList(parentId);
    }

    @ResponseBody
    @RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
    public TaotaoResult creatCategory(Long parentId, String name) {
        return contentCatService.creatCategory(parentId, name);
    }
}
