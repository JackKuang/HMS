package com.hurenjieee.system.service.impl;

import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
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


/**
 * @Description: 定时任务
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:48:27  
 */
@Service("systemJobService")
public class SystemJobServiceImpl extends BaseServiceImpl<SystemJob> implements SystemJobService {

    @Autowired
    SystemJobDao systemJobDao;

    @Override
    public Mapper<SystemJob> getMapper(){
        return systemJobDao;
    }

    @Override
    public Integer startJob(SystemJob systemJob){
        systemJob = systemJobDao.selectByPrimaryKey(systemJob.getUuid());
        Class<? extends Job> cls;
        if (ScheduleJob.CONCURRENT_IS.equals(systemJob.getJobConcurrent())) {
            cls = QuartzJobFactory.class;
        } else {
            cls = QuartzJobFactoryDisallowConcurrentExecution.class;
        }
        QuartManager.addJob(systemJob.getJobName(),cls,systemJob.getJobCron(),systemJob.generateScheduleJob());
        systemJob.setJobStatus(1);
        return systemJobDao.updateByPrimaryKeySelective(systemJob);
    }

    @Override
    public Integer stopJob(SystemJob systemJob){
        systemJob = systemJobDao.selectByPrimaryKey(systemJob.getUuid());
        QuartManager.removeJob(systemJob.getJobName());
        systemJob.setJobStatus(0);
        return systemJobDao.updateByPrimaryKeySelective(systemJob);
    }

    @Override
    public void startJobOnce(SystemJob systemJob){
        systemJob = systemJobDao.selectByPrimaryKey(systemJob.getUuid());
        TaskUtils.invokMethod(systemJob.generateScheduleJob());
    }

    @Override
    public void updateTran(){
        SystemJob searchObj = new SystemJob();
        searchObj.setUuid("c0ef5ee3-22bc-11e8-9db2-a0c5892edc62");
        SystemJob systemJob = systemJobDao.selectOne(searchObj);
        systemJob.setJobDescription("测试一下");
        systemJobDao.updateByPrimaryKey(systemJob);
        int i = 1/0;
        System.out.println(i);
    }
}
