package com.hurenjieee.system.service;


import java.util.Set;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemPermission;
import com.hurenjieee.system.entity.SystemRole;
import com.hurenjieee.system.entity.SystemUser;

public interface SystemUserService extends BaseService<SystemUser>{
    
    /**
     * @Description: 根据userId获取倒用户
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:04:39
     * @param username
     * @return
     */
    public SystemUser getUserByUserId(String userId);
    
    /**
     * @Description: 根据userId获取角色
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:30:51
     * @param userId
     * @return
     */
    public Set<String> listRolesCode(String userId);
    
    /**
     * @Description: 根据userId获取权限
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:31:31
     * @param userId
     * @return
     */
    public Set<String> listPermissionsCode(String userId);

    /**
     * @Description: 插入判断ID是否已经存在
     * @Author: JackKuang
     * @Since: 2018年2月7日下午2:09:28
     * @param systemUser
     * @return
     * @throws Exception
     */
    public Integer insertUser(SystemUser systemUser) throws Exception;
    
}
