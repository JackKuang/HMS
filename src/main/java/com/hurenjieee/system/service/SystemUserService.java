package com.hurenjieee.system.service;


import java.util.Date;
import java.util.Set;

import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemUser;


/**
 * @Description: 用户
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:54:54  
 */
public interface SystemUserService extends BaseService<SystemUser>{
    
    /**
     * 根据userId获取倒用户
     * 
     * @Description: 根据userId获取倒用户
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:04:39
     * @param userId
     * @return
     */
    public SystemUser getUserByUserId(String userId);
    
    /**
     * 根据userId获取角色
     * 
     * @Description: 根据userId获取角色
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:30:51
     * @param userId
     * @return
     */
    public Set<String> listRolesCode(String userId);
    
    /**
     * 根据userId获取权限
     * 
     * @Description: 根据userId获取权限
     * @Author: JackKuang
     * @Since: 2017年10月5日下午10:31:31
     * @param userId
     * @return
     */
    public Set<String> listPermissionsCode(String userId);

    /**
     * 插入判断ID是否已经存在
     * 
     * @Description: 插入判断ID是否已经存在
     * @Author: JackKuang
     * @Since: 2018年2月7日下午2:09:28
     * @param systemUser
     * @return
     * @throws Exception
     */
    public Integer insertUser(SystemUser systemUser) throws Exception;

    /**
     * 更新密码
     * 
     * @Description: 更新密码
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:39:07
     * @param userUuid
     * @param oldPwd
     * @param newPwd
     * @return
     * @throws ServiceException
     */
    public Integer updatePwd(String userUuid,String oldPwd,String newPwd) throws ServiceException;

    /**
     * 根据userUuid获取到上一次登陆时间
     * 
     * @Description: 根据userUuid获取到上一次登陆时间
     * @Author: JackKuang
     * @Since: 2018年3月6日下午10:00:30
     * @param userUuid
     * @return
     */
    public Date getLastLoginByUuid(String userUuid);
    
}
