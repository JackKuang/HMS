package com.hurenjieee.system.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemUserDao;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;

import tk.mybatis.mapper.common.Mapper;

@Service("systemUserService")
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUser> implements SystemUserService{
    
    @Autowired
    SystemUserDao systemUserDao;
    
    @Override
    public Mapper<SystemUser> getMapper(){
        return systemUserDao;
    }
    
    @Override
    public SystemUser selectByUserId(String userId){
        return ((SystemUserDao)getMapper()).selectByUserId(userId);
    }

    @Override
    public Set<String> getRoleCode(String userId){
        return ((SystemUserDao)getMapper()).getRoleCode(userId);
    }

    @Override
    public Set<String> getPermissionCode(String userId){
        return ((SystemUserDao)getMapper()).getPermissionCode(userId);
    }
    
}
