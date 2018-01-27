package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Map;

import com.hurenjieee.system.entity.SystemPermission;
import tk.mybatis.mapper.common.Mapper;

public interface SystemPermissionDao extends Mapper<SystemPermission> {

    List<Map<String,Object>> listPermissionsByUserUuid(String userUuid);    

    List<Map<String,Object>> listAllPermissions();

    void deleteRolePermissionByPermission(String uuid);

    Integer selectSonNumByParUuid(String uuid);    
}