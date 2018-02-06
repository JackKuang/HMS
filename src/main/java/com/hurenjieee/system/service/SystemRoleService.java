package com.hurenjieee.system.service;

import java.util.List;
import java.util.Map;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemRole;

public interface SystemRoleService extends BaseService<SystemRole>{

    /**
     * @Description: 查找某个用户的角色
     * @Author: JackKuang
     * @Since: 2018年2月6日下午8:26:27
     * @param userUuid
     * @return
     */
    List<Map> selectRoleByUserUuid(String userUuid);

}