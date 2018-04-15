package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hurenjieee.system.entity.SystemPermission;
import tk.mybatis.mapper.common.Mapper;


/**
 * @Description: 权限
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:09:06  
 */
public interface SystemPermissionDao extends Mapper<SystemPermission> {

    /**
     * 获取到某个用户的权限
     * 
     * @Description: 获取到某个用户的权限
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:09:07
     * @param userUuid
     * @return
     */
    List<Map<String,Object>> listPermissionsByUserUuid(String userUuid);    

    /**
     * 获取到全部的权限（admin）
     * 
     * @Description: 获取到全部的权限（admin）
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:09:09
     * @return
     */
    List<Map<String,Object>> listAllPermissions();

    /**
     * 删除用户的权限
     * 
     * @Description: 删除用户的权限
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:09:12
     * @param uuid
     */
    void deleteRolePermissionByPermission(String uuid);

    /**
     * 查询子节点
     * 
     * @Description: 查询子节点
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:09:14
     * @param uuid
     * @return
     */
    Integer selectSonNumByParUuid(String uuid);

    /**
     * 获取管理权限
     * 
     * @Description: 获取管理权限
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:09:16
     * @param roleUuid
     * @param adminUuid
     * @return
     */
    List<Map<String, Object>> listAllPermissionsByUserUuid(@Param("roleUuid")String roleUuid,@Param("adminUuid")String adminUuid);

    /**
     * 获取到所有可管理权限
     * 
     * @Description: 获取到所有可管理权限
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:09:19
     * @param roleUuid
     * @return
     */
    List<Map<String, Object>> listAllPermissionsByAdmin(String roleUuid);    
}