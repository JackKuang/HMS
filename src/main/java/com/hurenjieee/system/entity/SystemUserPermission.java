package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.BaseEntity;

@Table(name = "system_user_permission")
public class SystemUserPermission implements BaseEntity {
    @Id
    private Long id;

    private String uuid;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "user_uuid")
    private String userUuid;

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