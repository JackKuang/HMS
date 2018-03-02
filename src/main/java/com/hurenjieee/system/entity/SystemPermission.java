package com.hurenjieee.system.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.annotation.InjectionType;
import com.hurenjieee.core.entity.BaseEntity;

@Table(name = "system_permission")
public class SystemPermission extends BaseEntity{

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

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_url")
    private String permissionUrl;

    @Column(name = "permission_par_uuid")
    private String permissionParUuid;

    @Column(name = "permission_state")
    private Integer permissionState;

    @Column(name = "permission_order")
    private Integer permissionOrder;

    @Column(name = "permission_desc")
    private String permissionDesc;
    
    @Column(name = "permission_style")
    private String permissionStyle;
    

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
     * @return permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * @return permission_url
     */
    public String getPermissionUrl() {
        return permissionUrl;
    }

    /**
     * @param permissionUrl
     */
    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    /**
     * @return permission_par_uuid
     */
    public String getPermissionParUuid() {
        return permissionParUuid;
    }

    /**
     * @param permissionParUuid
     */
    public void setPermissionParUuid(String permissionParUuid) {
        this.permissionParUuid = permissionParUuid;
    }

    /**
     * @return permission_state
     */
    public Integer getPermissionState() {
        return permissionState;
    }

    /**
     * @param permissionState
     */
    public void setPermissionState(Integer permissionState) {
        this.permissionState = permissionState;
    }

    /**
     * @return permission_order
     */
    public Integer getPermissionOrder() {
        return permissionOrder;
    }

    /**
     * @param permissionOrder
     */
    public void setPermissionOrder(Integer permissionOrder) {
        this.permissionOrder = permissionOrder;
    }

    /**
     * @return permission_desc
     */
    public String getPermissionDesc() {
        return permissionDesc;
    }

    /**
     * @param permissionDesc
     */
    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }
    
    public String getPermissionStyle(){
        return permissionStyle;
    }
    
    public void setPermissionStyle(String permissionStyle){
        this.permissionStyle = permissionStyle;
    }
    
}