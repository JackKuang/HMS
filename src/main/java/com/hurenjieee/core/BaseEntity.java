package com.hurenjieee.core;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @Description: 基本类，所有子类继承此类
 * @Author: JackKuang
 * @Since: 2017年8月18日上午11:17:43  
 */
public class BaseEntity {

    private Long id;
    
    private String uuid;
    
    private String createTime;
    
    private String updateTime;

    @Id
    @Column(name = "id",unique = true,nullable = false)
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }


    @Column(name = "uuid ")
    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date",length = 19,insertable = false)
    public String getCreateTime(){
        return createTime;
    }

    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date",length = 19,insertable = false)
    public String getUpdateTime(){
        return updateTime;
    }

    public void setUpdateTime(String updateTime){
        this.updateTime = updateTime;
    }

}
