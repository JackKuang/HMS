package com.hurenjieee.system.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.service.impl.BaseServiceImpl;
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
    public SystemUser getUserByUserId(String userId){
        return ((SystemUserDao)getMapper()).getUserByUserId(userId);
    }

    @Override
    public Set<String> listRolesCode(String userId){
        return ((SystemUserDao)getMapper()).listRolesCode(userId);
    }

    @Override
    public Set<String> listPermissionsCode(String userId){
        return ((SystemUserDao)getMapper()).listPermissionsCode(userId);
    }
    
}
