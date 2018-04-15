package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Set;

import com.hurenjieee.system.entity.SystemUser;
import tk.mybatis.mapper.common.Mapper;


/**
 * @Description: 用户
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:12:35  
 */
public interface SystemUserDao extends Mapper<SystemUser> {
    
    /**
     * 查询用户
     * 
     * @Description: 查询用户
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:12:40
     * @param userId
     * @return
     */
    public SystemUser getUserByUserId(String userId);
    
    /**
     * 查询用户角色（Shiro）
     * 
     * @Description: 查询用户角色（Shiro）
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:12:54
     * @param userId
     * @return
     */
    public Set<String> listRolesCode(String userId);
    
    /**
     * 查询用户权限（Shiro）
     * 
     * @Description: 查询用户权限（Shiro）
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:13:25
     * @param userId
     * @return
     */
    public Set<String> listPermissionsCode(String userId);

    /**
     * 查询用户（分页）
     * 
     * @Description: 查询用户（分页）
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:13:45
     * @param systemUser
     * @return
     */
    public List<SystemUser> selectPage(SystemUser systemUser);

    /**
     * 插入前userId判断重复统计
     * 
     * @Description: 插入前userId判断重复统计
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:14:02
     * @param userId
     * @return
     */
    public Integer selectCountByUserId(String userId);
    
}