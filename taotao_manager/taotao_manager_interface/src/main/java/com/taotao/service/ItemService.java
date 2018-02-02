package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataRsult;

public interface ItemService {

    public EasyUIDataRsult getItemList(Integer page,Integer rows);
}
