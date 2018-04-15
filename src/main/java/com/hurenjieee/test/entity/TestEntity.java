package com.hurenjieee.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.annotation.InjectionType;
import com.hurenjieee.core.entity.BaseEntity;


/**
 * @Description: 测试
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:20:11  
 */
@Table(name = "test_entity")
public class TestEntity extends BaseEntity{

    @AutoInjection(type = InjectionType.CREATE_USER)
    @Column(name = "create_user")
    private String createUser;

    @AutoInjection(type = InjectionType.CREATE_DATE)
    @Column(name = "create_date")
    private Date createDate;

    @AutoInjection(type = InjectionType.UPDATE_USER)
    @Column(name = "update_user")
    private String updateUser;

    @AutoInjection(type = InjectionType.UPDATE_DATE)
    @Column(name = "update_date")
    private Date updateDate;

    private String name;

    private Date date;

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}