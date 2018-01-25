package com.hurenjieee.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.ibatis.annotations.Insert;

/**
 * @Description: 基本类，所有子类继承此类
 * @Author: JackKuang
 * @Since: 2017年8月18日上午11:17:43  
 */

@MappedSuperclass // JPA 基类的标识，继承此类会同时生成这几个字段
public class BaseEntity {

    /** 
     * @Fields: uuid : uuid自动生成
     */
    @Id
    @Column(length = 32,nullable = false)
    @GeneratedValue(generator = "UUID") // 指定生成器名称
    private String uuid;

    /**
     * @param uuid
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /** 
     * @Fields: offset : 分页页码
     */
    @Transient
    private Integer pageNum;

    /** 
     * @Fields: pageSize : 分页大小
     */
    @Transient
    private Integer pageSize;
    
    /**
     * @return uuid
     */
    
    /** 
     * @Fields: offset : 分页页码
     */
    @Transient
    private Integer offset;

    /** 
     * @Fields: pageSize : 分页大小
     */
    @Transient
    private Integer limit;
    
    /**
     * @return uuid
     */
    
    public String getUuid(){
        return uuid;
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

    public Integer getOffset(){
        return offset;
    }

    public void setOffset(Integer offset){
        this.offset = offset;
        if(this.limit != null)
            //分页偏移量
            this.pageNum = offset/this.limit+1;
    }

    
    public Integer getLimit(){
        return limit;
    }

    
    public void setLimit(Integer limit){
        this.limit = limit;
        this.pageSize = limit;
        if(this.offset != null)
            //分页偏移量
            this.pageNum = offset/this.limit+1;
    }
    

}
