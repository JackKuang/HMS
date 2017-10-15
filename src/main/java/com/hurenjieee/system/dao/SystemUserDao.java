package com.hurenjieee.system.dao;

import java.util.Set;

import com.hurenjieee.system.entity.SystemUser;
import tk.mybatis.mapper.common.Mapper;

public interface SystemUserDao extends Mapper<SystemUser> {
    
    public SystemUser selectByUserId(String userId);
    
    public Set<String> getRoleCode(String userId);
    
    public Set<String> getPermissionCode(String userId);
    
}