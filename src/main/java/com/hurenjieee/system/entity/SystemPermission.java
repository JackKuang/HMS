package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.BaseEntity;

@Table(name = "system_permission")
public class SystemPermission implements BaseEntity {
    @Id
    private Long id;

    private String uuid;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_code")
    private String permissionCode;

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
}