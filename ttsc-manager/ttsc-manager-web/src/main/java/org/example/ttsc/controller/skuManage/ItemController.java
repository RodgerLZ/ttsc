package org.example.ttsc.controller.skuManage;

import org.example.ttsc.entity.TbItem;
import org.example.ttsc.service.skuManage.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<TbItem> getItemList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return itemService.getItemList(pageNum, pageSize);
    }
}