package com.hurenjieee.system.service.impl;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.quartz.QuartManager;
import com.hurenjieee.core.quartz.QuartzJobFactory;
import com.hurenjieee.core.quartz.QuartzJobFactoryDisallowConcurrentExecution;
import com.hurenjieee.core.quartz.ScheduleJob;
import com.hurenjieee.core.quartz.TaskUtils;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemJobDao;
import com.hurenjieee.system.entity.SystemJob;
import com.hurenjieee.system.service.SystemJobService;

import tk.mybatis.mapper.common.Mapper;

@Service("systemJobService")
public class SystemJobServiceImpl extends BaseServiceImpl<SystemJob> implements SystemJobService {

    @Autowired
    SystemJobDao systemJobDao;

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public Mapper<SystemJob> getMapper(){
        return systemJobDao;
    }

    @Override
    public Integer startJob(SystemJob systemJob){
        systemJob = systemJobDao.selectByPrimaryKey(systemJob.getUuid());
        Class cls;
        if (ScheduleJob.CONCURRENT_IS.equals(systemJob.getJobConcurrent())) {
            cls = QuartzJobFactory.class;
        } else {
            cls = QuartzJobFactoryDisallowConcurrentExecution.class;
        }
        QuartManager.addJob(systemJob.getJobName(),cls,systemJob.getJobCron(),systemJob.generateScheduleJob());
        systemJob.setJobStatus("1");
        return systemJobDao.updateByPrimaryKeySelective(systemJob);
    }

    @Override
    public Integer stopJob(SystemJob systemJob){
        systemJob = systemJobDao.selectByPrimaryKey(systemJob.getUuid());
        QuartManager.removeJob(systemJob.getJobName());
        systemJob.setJobStatus("0");
        return systemJobDao.updateByPrimaryKeySelective(systemJob);
    }

    @Override
    public void startJobOnce(SystemJob systemJob){
        systemJob = systemJobDao.selectByPrimaryKey(systemJob.getUuid());
        TaskUtils.invokMethod(systemJob.generateScheduleJob());
    }

}
