package org.example.ttsc.controller;

import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public EUDataGridResult getItemList(@RequestParam Integer page, @RequestParam Integer rows) {
        return itemService.getItemList(page, rows);
    }
}