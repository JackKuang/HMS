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
    
    /** 
     * @Fields: data : 结果集
     */ 
    private List<T> data;

    /** 
     * @Fields: count : 总数
     */ 
    private long count;

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

    public long getCount(){
        return count;
    }

    public void setCount(long count){
        this.count = count;
    }

}
