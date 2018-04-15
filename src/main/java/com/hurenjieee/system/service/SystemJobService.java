package com.hurenjieee.system.service;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemJob;


/**
 * @Description: 定时任务
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:54:30  
 */
public interface SystemJobService extends BaseService<SystemJob>{

    /**
     * 启用任务调度
     * 
     * @Description: 启用任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:04:45
     * @param systemJob
     * @return
     */
    Integer startJob(SystemJob systemJob);

    /**
     * 禁用任务调度
     * 
     * @Description: 禁用任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:05:04
     * @param systemJob
     * @return
     */
    Integer stopJob(SystemJob systemJob);

    /**
     * 立即启动一次任务调度
     * 
     * @Description: 立即启动一次任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:07:09
     * @param systemJob
     * @return
     */
    void startJobOnce(SystemJob systemJob);
    
    /**
     * 测试回滚
     * 
     * @Description: 测试回滚
     * @Author: JackKuang
     * @Since: 2018年3月10日下午2:36:44
     */
    void updateTran();

}
