package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        // 设置分页的条件
        PageHelper.startPage(page, rows);
        // 执行查询,得到查询后的结果
        TbItemExample example = new TbItemExample();
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);
        // 封装分页的信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(pageInfo.getList());
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
