package com.hurenjieee.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemJobLogDao;
import com.hurenjieee.system.entity.SystemJobLog;
import com.hurenjieee.system.service.SystemJobLogService;

import tk.mybatis.mapper.common.Mapper;



/**
 * @Description: 定时任务日志
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:47:28  
 */
@Service("systemJobLogService")
public class SystemJobLogServiceImpl extends BaseServiceImpl<SystemJobLog> implements SystemJobLogService {

    @Autowired
    SystemJobLogDao systemJobLogDao;
    
    @Override
    public Mapper<SystemJobLog> getMapper(){
        return systemJobLogDao;
    }

    @Override
    public PageInfo<SystemJobLog> selectPage(SystemJobLog systemJobLog){
        List<SystemJobLog> list = systemJobLogDao.selectPageByDate(systemJobLog);
        PageInfo<SystemJobLog> pageInfo = new PageInfo<SystemJobLog>(list);
        return pageInfo;
    }

}
