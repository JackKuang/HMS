package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hurenjieee.system.entity.SystemPermission;
import tk.mybatis.mapper.common.Mapper;

public interface SystemPermissionDao extends Mapper<SystemPermission> {

    List<Map<String,Object>> listPermissionsByUserUuid(String userUuid);    

    List<Map<String,Object>> listAllPermissions();

    void deleteRolePermissionByPermission(String uuid);

    Integer selectSonNumByParUuid(String uuid);

    List<Map<String, Object>> listAllPermissionsByUserUuid(@Param("roleUuid")String roleUuid,@Param("adminUuid")String adminUuid);

    List<Map<String, Object>> listAllPermissionsByAdmin(String roleUuid);    
}