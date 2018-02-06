package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Map;

import com.hurenjieee.system.entity.SystemRolePermission;
import tk.mybatis.mapper.common.Mapper;

public interface SystemRolePermissionDao extends Mapper<SystemRolePermission> {

    List<Map> selectRoleByUserUuid(String userUuid);
    
}