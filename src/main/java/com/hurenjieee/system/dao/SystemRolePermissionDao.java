package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Map;

import com.hurenjieee.system.entity.SystemRolePermission;
import tk.mybatis.mapper.common.Mapper;


/**
 * @Description: 角色权限关联
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:12:10  
 */
public interface SystemRolePermissionDao extends Mapper<SystemRolePermission> {

    /**
     * 查询角色属性
     * 
     * @Description: 查询角色属性
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:11:57
     * @param userUuid
     * @return
     */
    List<Map<String,Object>> selectRoleByUserUuid(String userUuid);
    
}