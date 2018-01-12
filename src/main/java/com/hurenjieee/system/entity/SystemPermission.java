package com.hurenjieee.system.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hurenjieee.core.entity.BaseEntity;

@Table(name = "system_permission")
public class SystemPermission extends BaseEntity{
    @Id
    private String uuid;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "permission_code")
    private String permissionCode;

    @Column(name = "permission_style")
    private String permissionStyle;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_url")
    private String permissionUrl;

    @Column(name = "permission_par_code")
    private String permissionParCode;

    @Column(name = "permission_state")
    private Integer permissionState;

    @Column(name = "permission_order")
    private Integer permissionOrder;

    @Column(name = "permission_desc")
    private String permissionDesc;

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
     * @return permission_code
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * @param permissionCode
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * @return permission_style
     */
    public String getPermissionStyle() {
        return permissionStyle;
    }

    /**
     * @param permissionStyle
     */
    public void setPermissionStyle(String permissionStyle) {
        this.permissionStyle = permissionStyle;
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
     * @return permission_par_code
     */
    public String getPermissionParCode() {
        return permissionParCode;
    }

    /**
     * @param permissionParCode
     */
    public void setPermissionParCode(String permissionParCode) {
        this.permissionParCode = permissionParCode;
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
}