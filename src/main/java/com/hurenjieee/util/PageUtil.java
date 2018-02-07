package com.hurenjieee.util;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.system.entity.SystemUser;

public class PageUtil {

    public static PageResult generatePage(PageInfo pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setData(pageInfo.getList());
        pageResult.setCount(pageInfo.getTotal());
        pageResult.setCode(0);
        pageResult.setMsg("");
        return pageResult;
    }

}
