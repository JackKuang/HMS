package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Set;

import com.hurenjieee.system.entity.SystemUser;
import tk.mybatis.mapper.common.Mapper;

public interface SystemUserDao extends Mapper<SystemUser> {
    
    public SystemUser getUserByUserId(String userId);
    
    public Set<String> listRolesCode(String userId);
    
    public Set<String> listPermissionsCode(String userId);

    public List<SystemUser> selectPage(SystemUser systemUser);

    public Integer selectCountByUserId(String userId);
    
}