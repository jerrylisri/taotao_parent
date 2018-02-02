package com.taotao.controller;


import com.taotao.common.pojo.EasyUIDataRsult;
import com.taotao.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataRsult getItemList(Integer page, Integer rows) {
        //1引入服务

        //2.注入服务

        //3.调用服务
        EasyUIDataRsult rsult = itemService.getItemList(page,rows);
        return rsult;

    }
}
