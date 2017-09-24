package com.hurenjieee.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.ibatis.annotations.Options;

/**
 * @Description: 基本类，所有子类继承此类
 * @Author: JackKuang
 * @Since: 2017年8月18日上午11:17:43  
 */
public class BaseEntity{

    @Column(name = "id",unique = true,nullable = false)
    private Long   id;

    @Id
    @Column(name = "uuid")
    private String uuid;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date",length = 19) 
    private Date   createDate;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date",length = 19)
    private Date   updateDate;
    
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
