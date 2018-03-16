package com.hurenjieee.core.quartz;


import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/** 
 *  
 * @Description: 计划任务允许并发 
 * @author snailxr 
 * @date 2014年4月24日 下午5:05:47 
 */  
public class QuartzJobFactory implements Job { 
    public final Logger log = Logger.getLogger(this.getClass());  
  
    @Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {  
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");  
        TaskUtils.invokMethod(scheduleJob);  
        //保存记录到数据库
        System.out.println("QuartzJobFactory");
    }  
}  