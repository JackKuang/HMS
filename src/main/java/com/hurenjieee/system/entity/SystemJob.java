package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.annotation.InjectionType;
import com.hurenjieee.core.entity.BaseEntity;

@Table(name = "system_job")
public class SystemJob extends BaseEntity{

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
    @Column(name = "udpate_date")
    private Date udpateDate;

    /**
     * 任务名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 任务描述
     */
    @Column(name = "job_description")
    private String jobDescription;

    /**
     * Cron表达式
     */
    @Column(name = "job_cron")
    private String jobCron;

    /**
     * 包名+类名
     */
    @Column(name = "job_bean_class")
    private String jobBeanClass;

    /**
     * 方法名
     */
    @Column(name = "job_method")
    private String jobMethod;

    @Column(name = "job_concurrent")
    private Integer jobConcurrent;

    /**
     * 任务状态
     */
    @Column(name = "job_status")
    private Integer jobStatus;

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
     * @return udpate_date
     */
    public Date getUdpateDate() {
        return udpateDate;
    }

    /**
     * @param udpateDate
     */
    public void setUdpateDate(Date udpateDate) {
        this.udpateDate = udpateDate;
    }

    /**
     * 获取任务名称
     *
     * @return job_name - 任务名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置任务名称
     *
     * @param jobName 任务名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取任务描述
     *
     * @return job_description - 任务描述
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * 设置任务描述
     *
     * @param jobDescription 任务描述
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * 获取Cron表达式
     *
     * @return job_cron - Cron表达式
     */
    public String getJobCron() {
        return jobCron;
    }

    /**
     * 设置Cron表达式
     *
     * @param jobCron Cron表达式
     */
    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    /**
     * 获取包名+类名
     *
     * @return job_bean_class - 包名+类名
     */
    public String getJobBeanClass() {
        return jobBeanClass;
    }

    /**
     * 设置包名+类名
     *
     * @param jobBeanClass 包名+类名
     */
    public void setJobBeanClass(String jobBeanClass) {
        this.jobBeanClass = jobBeanClass;
    }

    /**
     * 获取方法名
     *
     * @return job_method - 方法名
     */
    public String getJobMethod() {
        return jobMethod;
    }

    /**
     * 设置方法名
     *
     * @param jobMethod 方法名
     */
    public void setJobMethod(String jobMethod) {
        this.jobMethod = jobMethod;
    }

    /**
     * @return job_concurrent
     */
    public Integer getJobConcurrent() {
        return jobConcurrent;
    }

    /**
     * @param jobConcurrent
     */
    public void setJobConcurrent(Integer jobConcurrent) {
        this.jobConcurrent = jobConcurrent;
    }

    /**
     * 获取任务状态
     *
     * @return job_status - 任务状态
     */
    public Integer getJobStatus() {
        return jobStatus;
    }

    /**
     * 设置任务状态
     *
     * @param jobStatus 任务状态
     */
    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }
}