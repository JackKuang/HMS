package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.entity.BaseEntity;

@Table(name = "system_user")
public class SystemUser implements BaseEntity {
    @Id
    private Long id;

    private String uuid;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_telephone")
    private String userTelephone;

    @Column(name = "user_sex")
    private Integer userSex;

    @Column(name = "user_role_uuid")
    private String userRoleUuid;

    @Column(name = "user_is_defalut_role")
    private Boolean userIsDefalutRole;

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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_telephone
     */
    public String getUserTelephone() {
        return userTelephone;
    }

    /**
     * @param userTelephone
     */
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    /**
     * @return user_sex
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * @param userSex
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * @return user_role_uuid
     */
    public String getUserRoleUuid() {
        return userRoleUuid;
    }

    /**
     * @param userRoleUuid
     */
    public void setUserRoleUuid(String userRoleUuid) {
        this.userRoleUuid = userRoleUuid;
    }

    /**
     * @return user_is_defalut_role
     */
    public Boolean getUserIsDefalutRole() {
        return userIsDefalutRole;
    }

    /**
     * @param userIsDefalutRole
     */
    public void setUserIsDefalutRole(Boolean userIsDefalutRole) {
        this.userIsDefalutRole = userIsDefalutRole;
    }
}