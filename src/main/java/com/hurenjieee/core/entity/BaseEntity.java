package com.hurenjieee.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @Description: 基本类，所有子类继承此类
 * @Author: JackKuang
 * @Since: 2017年8月18日上午11:17:43  
 */

@MappedSuperclass // JPA 基类的标识，继承此类会同时生成这几个字段
public class BaseEntity{

    @Id
    @Column(length = 32, nullable = false)
    @GeneratedValue(generator = "UUID") // 指定生成器名称 
    //
    private String uuid;
    
    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
}
