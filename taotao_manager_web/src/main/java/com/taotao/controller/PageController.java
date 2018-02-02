package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){

        return "index";
    }

    @RequestMapping("/{page}")
    public String showItemListPage(@PathVariable String page){

        return page;
    }

   /* @RequestMapping("/item-add")
    public String addItemPage(){


        return "item-add";
    }*/
}
