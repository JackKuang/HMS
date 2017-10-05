package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.BaseEntity;

@Table(name = "system_role_permission")
public class SystemRolePermission implements BaseEntity {
    @Id
    private Long id;

    private String uuid;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "role_uuid")
    private String roleUuid;

    @Column(name = "permission_uuid")
    private String permissionUuid;

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