package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.annotation.InjectionType;
import com.hurenjieee.core.entity.BaseEntity;


/**
 * @Description: 角色权限关联
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:28:29  
 */
@Table(name = "system_role_permission")
public class SystemRolePermission extends BaseEntity{

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

    @Column(name = "role_uuid")
    private String roleUuid;

    @Column(name = "permission_uuid")
    private String permissionUuid;

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

    /**
     * @return permission_uuid
     */
    public String getPermissionUuid() {
        return permissionUuid;
    }

    /**
     * @param permissionUuid
     */
    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid;
    }
}