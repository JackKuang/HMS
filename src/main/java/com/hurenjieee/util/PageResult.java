package com.hurenjieee.util;

import java.util.List;

/**
 * @Description: 整合分页功能给前端分页
 * @Author: JackKuang
 * @Since: 2018年1月25日下午12:51:42 
 * @param <T> 
 */
public class PageResult<T> {

    // 结果集
    private List<T> rows;

    // 总数
    private long total;

    public List<T> getRows(){
        return rows;
    }
    
    public void setRows(List<T> rows){
        this.rows = rows;
    }

    public long getTotal(){
        return total;
    }

    public void setTotal(long total){
        this.total = total;
    }

}
