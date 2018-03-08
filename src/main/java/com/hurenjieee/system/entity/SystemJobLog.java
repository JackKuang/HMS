package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.annotation.InjectionType;
import com.hurenjieee.core.entity.BaseEntity;

@Table(name = "system_job_log")
public class SystemJobLog extends BaseEntity{

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

    /** 
     * @Fields: logJobUuid : jobUuid
     */ 
    @Column(name = "log_job_uuid")
    private String logJobUuid;

    /** 
     * @Fields: logStartDate : 开始时间
     */ 
    @Column(name = "log_start_date")
    private Date logStartDate;

    /** 
     * @Fields: logEndDate : 结束时间
     */ 
    @Column(name = "log_end_date")
    private Date logEndDate;

    /** 
     * @Fields: logResult : 结果
     */ 
    @Column(name = "log_result")
    private String logResult;

    /** 
     * @Fields: logMessage : 信息
     */ 
    @Column(name = "log_message")
    private String logMessage;

    /** 
     * @Fields: logTime : 运行时间
     */ 
    @Column(name = "log_time")
    private Integer logTime;

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
     * @return log_job_uuid
     */
    public String getLogJobUuid() {
        return logJobUuid;
    }

    /**
     * @param logJobUuid
     */
    public void setLogJobUuid(String logJobUuid) {
        this.logJobUuid = logJobUuid;
    }

    /**
     * @return log_start_date
     */
    public Date getLogStartDate() {
        return logStartDate;
    }

    /**
     * @param logStartDate
     */
    public void setLogStartDate(Date logStartDate) {
        this.logStartDate = logStartDate;
    }

    /**
     * @return log_end_date
     */
    public Date getLogEndDate() {
        return logEndDate;
    }

    /**
     * @param logEndDate
     */
    public void setLogEndDate(Date logEndDate) {
        this.logEndDate = logEndDate;
    }

    /**
     * @return log_result
     */
    public String getLogResult() {
        return logResult;
    }

    /**
     * @param logResult
     */
    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    /**
     * @return log_message
     */
    public String getLogMessage() {
        return logMessage;
    }

    /**
     * @param logMessage
     */
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    /**
     * @return log_time
     */
    public Integer getLogTime() {
        return logTime;
    }

    /**
     * @param logTime
     */
    public void setLogTime(Integer logTime) {
        this.logTime = logTime;
    }
}