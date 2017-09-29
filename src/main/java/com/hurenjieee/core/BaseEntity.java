package com.hurenjieee.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Description: 基本类，所有子类继承此类
 * @Author: JackKuang
 * @Since: 2017年8月18日上午11:17:43  
 */
public class BaseEntity{
    
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "`uuid`")
    private String uuid;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`update_date`")
    private Date updateDate;
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public Date getCreateDate(){
        return createDate;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public Date getUpdateDate(){
        return updateDate;
    }

    
    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }
    
}
