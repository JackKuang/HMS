package com.hurenjieee.core.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    private String uuid;

    @Transient
    private Map<String, String> strMap;

    /**
     * @param uuid
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }
    
    /**
     * @return uuid
     */
    public String getUuid(){
        return uuid;
    }
    
    public Map<String, String> getStrMap(){
        return strMap;
    }
    
    public void setStrMap(Map<String, String> strMap){
        this.strMap = strMap;
    }
    
}
