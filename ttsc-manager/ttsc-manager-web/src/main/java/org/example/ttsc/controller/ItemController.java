package org.example.ttsc.controller;

import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.EUTreeNode;
import org.example.ttsc.service.ItemCatService;
import org.example.ttsc.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @Resource
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public EUDataGridResult getItemList(@RequestParam Integer page, @RequestParam Integer rows) {
        return itemService.getItemList(page, rows);
    }

    @ResponseBody
    @RequestMapping(value = "/cat/list", method = RequestMethod.POST)
    public List<EUTreeNode> getItemCatList(Integer id) {
        if (id == null) {
            id = 0;
        }
        return itemCatService.getItemCatList(id);
    }

}