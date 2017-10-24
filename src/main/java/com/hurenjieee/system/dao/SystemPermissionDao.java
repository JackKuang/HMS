package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Map;

import com.hurenjieee.system.entity.SystemPermission;
import tk.mybatis.mapper.common.Mapper;

public interface SystemPermissionDao extends Mapper<SystemPermission> {

    List<Map> listPermissionsByUserId(String userId);    
}