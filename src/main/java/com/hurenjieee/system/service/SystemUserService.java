package com.hurenjieee.system.service;


import java.util.Set;

import com.hurenjieee.core.BaseService;
import com.hurenjieee.system.entity.SystemUser;

public interface SystemUserService extends BaseService<SystemUser>{
    
    /**
     * @Description: 根据userId获取倒用户
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:04:39
     * @param username
     * @return
     */
    public SystemUser selectByUserId(String userId);
    
    /**
     * @Description: 根据userId获取角色
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:30:51
     * @param userId
     * @return
     */
    public Set<String> getRoles(String userId);
    
    /**
     * @Description: 根据userId获取权限
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:31:31
     * @param userId
     * @return
     */
    public Set<String> getPermissions(String userId);
}
