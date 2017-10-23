package com.hurenjieee.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemRoleDao;
import com.hurenjieee.system.entity.SystemRole;
import com.hurenjieee.system.service.SystemRoleService;

import tk.mybatis.mapper.common.Mapper;


@Service("systemRoleService")
public class SystemRoleServiceImpl extends BaseServiceImpl<SystemRole> implements SystemRoleService {

    @Autowired
    SystemRoleDao systemRoleDao;
    
    @Override
    public Mapper<SystemRole> getMapper(){
        return systemRoleDao;
    }


}
