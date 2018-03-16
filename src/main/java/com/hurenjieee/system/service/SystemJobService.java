package com.hurenjieee.system.service;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemJob;

public interface SystemJobService extends BaseService<SystemJob>{

    /**
     * @Description: 启用任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:04:45
     * @param systemJob
     * @return
     */
    Integer startJob(SystemJob systemJob);

    /**
     * @Description: 禁用任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:05:04
     * @param systemJob
     * @return
     */
    Integer stopJob(SystemJob systemJob);

    /**
     * @Description: 立即启动一次任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:07:09
     * @param systemJob
     * @return
     */
    void startJobOnce(SystemJob systemJob);
    
    
    /**
     * @Description: 测试回滚
     * @Author: JackKuang
     * @Since: 2018年3月10日下午2:36:44
     */
    void updateTran();

}
