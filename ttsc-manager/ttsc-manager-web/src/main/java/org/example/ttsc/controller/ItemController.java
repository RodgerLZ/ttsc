package org.example.ttsc.controller;

import org.example.ttsc.entity.TbItem;
import org.example.ttsc.pojo.EUDataGridResult;
import org.example.ttsc.pojo.EUTreeNode;
import org.example.ttsc.pojo.TaotaoResult;
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

    /**
     * 查询商品
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public EUDataGridResult getItemList(@RequestParam Integer page, @RequestParam Integer rows) {
        return itemService.getItemList(page, rows);
    }

    /**
     * 查询商品类目
     * @param id 父类id
     */
    @ResponseBody
    @RequestMapping(value = "/cat/list", method = RequestMethod.POST)
    public List<EUTreeNode> getItemCatList(Integer id) {
        if (id == null) {
            id = 0;
        }
        return itemCatService.getItemCatList(id);
    }

    /**
     * 新增商品接口
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public TaotaoResult saveItem(TbItem tbItem, String desc, String itemParams) {
        return itemService.saveItem(tbItem, desc, itemParams);
    }

    @ResponseBody
    @RequestMapping(value = "/param/list", method = RequestMethod.GET)
    public EUDataGridResult queryCatParamList(@RequestParam Integer page, @RequestParam Integer rows) {
        return itemService.queryCatParamList(page, rows);
    }

    /**
     * 查询商品类目对应的商品规格参数
     */
    @ResponseBody
    @RequestMapping(value = "/param/query/itemcatid/{itemCatId}", method = RequestMethod.GET)
    public TaotaoResult queryCatParam(@PathVariable Long itemCatId) {
        return itemService.queryCatParam(itemCatId);
    }

    /**
     * 保存规格参数模板
     */
    @ResponseBody
    @RequestMapping(value = "/param/save/{itemCatId}", method = RequestMethod.POST)
    public TaotaoResult saveCatParam(@PathVariable Long itemCatId, @RequestParam String paramData) {
        return itemService.saveCatParam(itemCatId, paramData);
    }

    /**
     * 删除规格参数模板（支持批量删除）
     */
    @ResponseBody
    @RequestMapping(value = "/param/delete", method = RequestMethod.POST)
    public TaotaoResult saveCatParam(@RequestParam String ids) {
        return itemService.deleteCatParam(ids);
    }
}