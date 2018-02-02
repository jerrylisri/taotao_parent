package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataRsult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUIDataRsult getItemList(Integer page, Integer rows) {
        //分页查询
        PageHelper.startPage(page,rows);
        //创建example
//        TbItemExample example =new TbItemExample();

        //查询所有
        List<TbItem> tbItems = tbItemMapper.selectByExample(null);
        //构建分页对象
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItems);
        //创建EasyUIDataRsult
        EasyUIDataRsult rsult = new EasyUIDataRsult();
        rsult.setTotal(pageInfo.getTotal());
        rsult.setRows(pageInfo.getList());

        return rsult;
    }
}
