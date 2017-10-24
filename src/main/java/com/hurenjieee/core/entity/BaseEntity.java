package com.hurenjieee.core.entity;

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
public interface BaseEntity{
    
    public Long getId();

    public void setId(Long id);

    public String getUuid();

    public void setUuid(String uuid);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public Date getUpdateDate();
    
    public void setUpdateDate(Date updateDate);
    
}
