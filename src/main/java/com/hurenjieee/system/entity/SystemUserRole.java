package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.entity.BaseEntity;


/**
 * @Description: 用户角色关联
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:28:44  
 */
@Table(name = "system_user_role")
public class SystemUserRole extends BaseEntity{

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "role_uuid")
    private String roleUuid;

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
     * @return user_uuid
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * @param userUuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * @return role_uuid
     */
    public String getRoleUuid() {
        return roleUuid;
    }

    /**
     * @param roleUuid
     */
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }
}