package com.taotao.controller;

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/item/cat/list")
    @ResponseBody
    /**
     * url:/item/cat/list
     * 参数:id
     * 返回值:json
     */
    public List<TreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        //引入服务

        //注入服务

        //调用服务
        List<TreeNode> itemCatListByParentIds = itemCatService.getItemCatListByParentId(parentId);

        return itemCatListByParentIds;

    }

}
