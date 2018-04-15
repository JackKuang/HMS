package com.hurenjieee.system.dao;

import java.util.List;

import com.hurenjieee.system.entity.SystemJobLog;

import tk.mybatis.mapper.common.Mapper;


/**
 * @Description: 定时任务日志
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:08:34  
 */
public interface SystemJobLogDao extends Mapper<SystemJobLog> {

    /**
     * 根据时间查询定时任务日志
     * 
     * @Description: 根据时间查询定时任务日志
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:08:36
     * @param systemJobLog
     * @return
     */
    List<SystemJobLog> selectPageByDate(SystemJobLog systemJobLog);
    
}