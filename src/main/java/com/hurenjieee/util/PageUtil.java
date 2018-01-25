package com.hurenjieee.util;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.system.entity.SystemUser;

public class PageUtil {
    
    public static PageResult generatePage(PageInfo pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setRows(pageInfo.getList());
        pageResult.setTotal(pageInfo.getTotal());
        return pageResult;
    }

}
