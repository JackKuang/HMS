package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.BaseEntity;

@Table(name = "system_permission")
public class SystemPermission implements BaseEntity{
    @Id
    private Long id;

    private String uuid;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "permission_code")
    private String permissionCode;
    
    @Column(name = "permission_style")
    private Integer permissionStyle;

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

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return permission_style
     */
    public Integer getPermissionStyle(){
        return permissionStyle;
    }


    /**
     * @param permissionStyle
     */
    public void setPermissionStyle(Integer permissionStyle){
        this.permissionStyle = permissionStyle;
    }
    
    
}