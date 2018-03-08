package com.hurenjieee.system.dao;

import java.util.List;

import com.hurenjieee.system.entity.SystemJobLog;

import tk.mybatis.mapper.common.Mapper;

public interface SystemJobLogDao extends Mapper<SystemJobLog> {

    List<SystemJobLog> selectPageByDate(SystemJobLog systemJobLog);
    
}