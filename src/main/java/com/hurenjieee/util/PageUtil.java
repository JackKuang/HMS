package com.hurenjieee.util;

import com.github.pagehelper.PageInfo;


/**
 * @Description: 适应前端页面分页工具
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:23:27  
 */
public class PageUtil {

    public static <T> PageResult<T> generatePage(PageInfo<T> pageInfo){
        PageResult<T> pageResult = new PageResult<T>();
        pageResult.setData(pageInfo.getList());
        pageResult.setCount(pageInfo.getTotal());
        pageResult.setCode(0);
        pageResult.setMsg("");
        return pageResult;
    }

}
