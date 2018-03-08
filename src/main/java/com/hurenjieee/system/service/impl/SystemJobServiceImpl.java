package com.hurenjieee.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemJobDao;
import com.hurenjieee.system.entity.SystemJob;
import com.hurenjieee.system.service.SystemJobService;

import tk.mybatis.mapper.common.Mapper;


@Service("systemJobServiceImpl")
public class SystemJobServiceImpl extends BaseServiceImpl<SystemJob> implements SystemJobService {

    @Autowired
    SystemJobDao systemJobDao;
    
    @Override
    public Mapper<SystemJob> getMapper(){
        return systemJobDao;
    }


}
