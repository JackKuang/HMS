package com.hurenjieee.system.service;


import java.util.Date;
import java.util.Set;

import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.core.service.BaseService;
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

    /**
     * @Description: 更新密码
     * @Author: JackKuang
     * @Since: 2018年3月6日下午4:54:33
     * @param userUuid 用户uuid
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @return
     */
    public Integer updatePwd(String userUuid,String oldPwd,String newPwd) throws ServiceException;

    /**
     * @Description: 根据userUuid获取到上一次登陆时间
     * @Author: JackKuang
     * @Since: 2018年3月6日下午10:00:30
     * @param userUuid
     * @return
     */
    public Date getLastLoginByUuid(String userUuid);
    
}
