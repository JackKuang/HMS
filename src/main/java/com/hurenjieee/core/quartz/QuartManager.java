package com.hurenjieee.core.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class QuartManager {

    private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = "MY_JOBGROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "MY_TRIGGERGROUP_NAME";

    /**
     * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名 
     * @Author: JackKuang
     * @Since: 2018年3月9日上午11:18:04
     * @param jobName
     * @param cls
     * @param time
     * @param scheduleJob
     */
    @SuppressWarnings("unchecked")
    public static void addJob(String jobName,Class cls,String time,ScheduleJob scheduleJob){
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            JobDetail job = JobBuilder.newJob(cls).withIdentity(jobName,JOB_GROUP_NAME).build();
            // 添加具体任务方法
            job.getJobDataMap().put("scheduleJob",scheduleJob);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
            // 按新的cronExpression表达式构建一个新的trigger
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName,TRIGGER_GROUP_NAME).withSchedule(scheduleBuilder).build();
            // 交给scheduler去调度
            sched.scheduleJob(job,trigger);
            // 启动
            if (!sched.isShutdown()) {
                sched.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)  
     * @Author: JackKuang
     * @Since: 2018年3月9日上午11:17:52
     * @param jobName
     * @param time
     */
    @SuppressWarnings("unchecked")
    public static void modifyJobTime(String jobName,String time){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName,TRIGGER_GROUP_NAME);

        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                // 按新的trigger重新设置job执行
                sched.rescheduleJob(triggerKey,trigger);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名) 
     * @Author: JackKuang
     * @Since: 2018年3月9日上午11:17:33
     * @param jobName
     */
    public static void removeJob(String jobName){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName,TRIGGER_GROUP_NAME);
        JobKey jobKey = JobKey.jobKey(jobName,JOB_GROUP_NAME);
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            Trigger trigger = (Trigger) sched.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            sched.pauseTrigger(triggerKey);
            ;// 停止触发器
            sched.unscheduleJob(triggerKey);// 移除触发器
            sched.deleteJob(jobKey);// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * @Description: 暂停一个任务(使用默认组名) 
     * @Author: JackKuang
     * @Since: 2018年3月9日上午11:17:07
     * @param jobName 任务名称
     */
    public static void pauseJob(String jobName) {  
        JobKey jobKey =JobKey.jobKey(jobName, JOB_GROUP_NAME);  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            sched.pauseJob(jobKey);  
        } catch (SchedulerException e) {  
            e.printStackTrace();  
        }  
    }
    
    /**  
     * @Description:启动所有定时任务  
     * @author qgw  
     * @date 2016年1月29日 下午2:21:16 ^_^ 
     */
    /*public static void startJobs(){
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            sched.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    *//** 
     * @Description 关闭所有定时任务  
     * @author qgw  
     * @date 2016年1月25日 下午2:26:54 ^_^ 
     *//*
    public static void shutdownJobs(){
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();
            if (!sched.isShutdown()) {
                sched.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
