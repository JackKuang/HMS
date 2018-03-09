package com.hurenjieee.system.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.hurenjieee.core.entity.BaseEntity;

@Table(name = "system_job_log")
public class SystemJobLog extends BaseEntity{

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "log_job_uuid")
    private String logJobUuid;

    /**
     * 任务名称
     */
    @Column(name = "log_job_name")
    private String logJobName;

    /**
     * 任务描述
     */
    @Column(name = "log_job_description")
    private String logJobDescription;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "log_start_date")
    private Date logStartDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "log_end_date")
    private Date logEndDate;

    @Column(name = "log_state")
    private String logState;

    @Column(name = "log_result")
    private String logResult;

    @Column(name = "log_message")
    private String logMessage;

    @Column(name = "log_time")
    private Long logTime;

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
     * 获取任务名称
     *
     * @return log_job_name - 任务名称
     */
    public String getLogJobName() {
        return logJobName;
    }

    /**
     * 设置任务名称
     *
     * @param logJobName 任务名称
     */
    public void setLogJobName(String logJobName) {
        this.logJobName = logJobName;
    }

    /**
     * 获取任务描述
     *
     * @return log_job_description - 任务描述
     */
    public String getLogJobDescription() {
        return logJobDescription;
    }

    /**
     * 设置任务描述
     *
     * @param logJobDescription 任务描述
     */
    public void setLogJobDescription(String logJobDescription) {
        this.logJobDescription = logJobDescription;
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
     * @return log_state
     */
    public String getLogState() {
        return logState;
    }

    /**
     * @param logState
     */
    public void setLogState(String logState) {
        this.logState = logState;
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
    public Long getLogTime() {
        return logTime;
    }

    /**
     * @param logTime
     */
    public void setLogTime(Long logTime) {
        this.logTime = logTime;
    }
}