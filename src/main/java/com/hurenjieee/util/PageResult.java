package com.hurenjieee.util;

import java.util.List;

/**
 * @Description: 整合分页功能给前端分页
 * @Author: JackKuang
 * @Since: 2018年1月25日下午12:51:42 
 * @param <T> 
 */
public class PageResult<T> {

    private Integer code;
    
    private String msg;
    // 结果集
    private List<T> data;

    // 总数
    private long total;
    
    
    public Integer getCode(){
        return code;
    }


    
    public void setCode(Integer code){
        this.code = code;
    }


    public String getMsg(){
        return msg;
    }

    
    public void setMsg(String msg){
        this.msg = msg;
    }

    
    public List<T> getData(){
        return data;
    }

    
    public void setData(List<T> data){
        this.data = data;
    }

    
    public long getTotal(){
        return total;
    }

    
    public void setTotal(long total){
        this.total = total;
    }

    
    
}
