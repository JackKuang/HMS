package com.hurenjieee.entity;

import java.io.Serializable;
import java.util.Date;

public class TestEntity implements Serializable{
    private Integer id;
    private String name;
    private Date date;
    private Integer pageNum;
    private Integer pageSize;
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Integer getPageNum(){
        return pageNum;
    }

    
    public void setPageNum(Integer pageNum){
        this.pageNum = pageNum;
    }

    
    public Integer getPageSize(){
        return pageSize;
    }

    
    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }
    
    
}
