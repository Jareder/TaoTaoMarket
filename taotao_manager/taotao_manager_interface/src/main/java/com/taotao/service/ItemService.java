package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

public interface ItemService {

    /**
     * @param page 当前的页码
     * @param rows 每页显示的行数
     * @return
     */
    EasyUIDataGridResult getItemList(Integer page, Integer rows);

}
