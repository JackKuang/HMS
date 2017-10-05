package com.hurenjieee.system.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.hurenjieee.core.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemUserDao;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;

@Service("systemUserService")
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUser,SystemUserDao> implements SystemUserService{
    
    @Override
    public SystemUser selectByUserId(String userId){
        return ((SystemUserDao)getMapper()).selectByUserId(userId);
    }

    @Override
    public Set<String> getRoles(String userId){
        return ((SystemUserDao)getMapper()).getRoles(userId);
    }

    @Override
    public Set<String> getPermissions(String userId){
        return ((SystemUserDao)getMapper()).getPermissions(userId);
    }
    
    
}
