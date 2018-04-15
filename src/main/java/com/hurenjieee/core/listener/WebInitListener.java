package com.hurenjieee.core.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.Job;

import com.hurenjieee.core.quartz.QuartManager;
import com.hurenjieee.core.quartz.QuartzJobFactory;
import com.hurenjieee.core.quartz.QuartzJobFactoryDisallowConcurrentExecution;
import com.hurenjieee.core.quartz.ScheduleJob;
import com.hurenjieee.core.util.SpringContextUtil;
import com.hurenjieee.system.entity.SystemJob;
import com.hurenjieee.system.service.SystemJobService;

/**
 * @Description: 初始化监听器
 * @Author: JackKuang
 * @Since: 2018年3月9日下午11:46:51  
 */
public class WebInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        SystemJobService systemJobService = SpringContextUtil.getBean("systemJobService");
        SystemJob searchObj = new SystemJob();
        searchObj.setJobStatus(1);
        List<SystemJob> list = systemJobService.select(searchObj);
        for ( SystemJob systemJob : list ) {
            Class<? extends Job> cls;
            if (ScheduleJob.CONCURRENT_IS.equals(systemJob.getJobConcurrent())) {
                cls = QuartzJobFactory.class;
            } else {
                cls = QuartzJobFactoryDisallowConcurrentExecution.class;
            }
            QuartManager.addJob(systemJob.getJobName(),cls,systemJob.getJobCron(),systemJob.generateScheduleJob());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        QuartManager.shutdownJobs();
    }
}
