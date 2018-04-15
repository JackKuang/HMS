package com.hurenjieee.system.service;

import java.util.List;
import java.util.Map;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemRole;


/**
 * @Description: 角色
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:54:45  
 */
public interface SystemRoleService extends BaseService<SystemRole>{

    /**
     * 查找某个用户的角色
     * 
     * @Description: 查找某个用户的角色
     * @Author: JackKuang
     * @Since: 2018年2月6日下午8:26:27
     * @param userUuid
     * @return
     */
    List<Map<String,Object>> selectRoleByUserUuid(String userUuid);

}