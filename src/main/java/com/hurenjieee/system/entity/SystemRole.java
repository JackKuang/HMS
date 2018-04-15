package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.annotation.InjectionType;
import com.hurenjieee.core.entity.BaseEntity;


/**
 * @Description: 角色
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:28:21  
 */
@Table(name = "system_role")
public class SystemRole extends BaseEntity {

    @AutoInjection(type = InjectionType.CREATE_USER)
    @Column(name = "create_user")
    private String createUser;

    @AutoInjection(type = InjectionType.CREATE_DATE)
    @Column(name = "create_date")
    private Date   createDate;

    @AutoInjection(type = InjectionType.UPDATE_USER)
    @Column(name = "update_user")
    private String updateUser;

    @AutoInjection(type = InjectionType.UPDATE_DATE)
    @Column(name = "update_date")
    private Date   updateDate;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_code")
    private String roleCode;

    /** 
     * @Fields: permissions : 传入权限String字符串","分割
     */
    @Transient
    private String permissions;

    /**
     * @return create_user
     */
    public String getCreateUser(){
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate(){
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser(){
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser){
        this.updateUser = updateUser;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate(){
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }

    /**
     * @return role_name
     */
    public String getRoleName(){
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    /**
     * @return role_code
     */
    public String getRoleCode(){
        return roleCode;
    }

    /**
     * @param roleCode
     */
    public void setRoleCode(String roleCode){
        this.roleCode = roleCode;
    }

    public String getPermissions(){
        return permissions;
    }

    public void setPermissions(String permissions){
        this.permissions = permissions;
    }

}