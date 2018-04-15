package com.hurenjieee.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.constant.HttpConst;
import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemUserDao;
import com.hurenjieee.system.dao.SystemUserRoleDao;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.entity.SystemUserRole;
import com.hurenjieee.system.service.SystemUserService;

import tk.mybatis.mapper.common.Mapper;


/**
 * @Description: 用户
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:53:23  
 */
@Service("systemUserService")
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUser> implements SystemUserService{

    private static String SPLITE_FLAG = ",";
    
    @Autowired
    SystemUserDao systemUserDao;
    
    @Autowired
    SystemUserRoleDao systemUserRoleDao;
    
    @Override
    public Mapper<SystemUser> getMapper(){
        return systemUserDao;
    }
    
    @Override
    public SystemUser getUserByUserId(String userId){
        return systemUserDao.getUserByUserId(userId);
    }

    /**
     * @Description: Shiro接口调用
     * @Author: JackKuang
     * @Since: 2018年2月6日下午3:17:08
     * @param userId
     * @return
     */
    @Override
    public Set<String> listRolesCode(String userId){
        return systemUserDao.listRolesCode(userId);
    }

    /**
     * @Description: Shiro接口调用
     * @Author: JackKuang
     * @Since: 2018年2月6日下午3:17:27
     * @param userId
     * @return
     */
    @Override
    public Set<String> listPermissionsCode(String userId){
        return systemUserDao.listPermissionsCode(userId);
    }

    /**
     * @Description: 分页查询
     * @Author: JackKuang
     * @Since: 2018年2月6日下午5:22:27
     * @param systemUser
     * @return
     */
    @Override
    public PageInfo<SystemUser> selectPage(SystemUser systemUser){
        List<SystemUser> list = systemUserDao.selectPage(systemUser);
        PageInfo<SystemUser> pageInfo = new PageInfo<SystemUser>(list);
        return pageInfo;
    }

    @Override
    public Integer insertUser(SystemUser systemUser) throws Exception{
        Integer idCount = systemUserDao.selectCountByUserId(systemUser.getUserId());
        if(idCount > 0){
            throw new ServiceException(HttpConst.HTTP_RESPONSE_FAIL,"当前用户Id已存在，不可重复");
        }
        Integer result = systemUserDao.insertSelective(systemUser);
        if(result > 0){
            //add
            String userUuid = systemUser.getUuid();
            String userRoles = systemUser.getUserRoles();
            for(String roleUuid : userRoles.split(SPLITE_FLAG)){
                if(StringUtils.isNotBlank(roleUuid)){
                    SystemUserRole systemUserRole = new SystemUserRole();
                    systemUserRole.setUserUuid(userUuid);
                    systemUserRole.setRoleUuid(roleUuid);
                    systemUserRoleDao.insertSelective(systemUserRole);
                }
            }
        }
        return result;
    }
    
    @Override
    public Integer updateByKeySelective(SystemUser systemUser){
        Integer result = systemUserDao.updateByPrimaryKeySelective(systemUser);
        if(result > 0){
            //delete
            String userUuid = systemUser.getUuid();
            SystemUserRole deleteObject = new SystemUserRole();
            deleteObject.setUserUuid(userUuid);
            systemUserRoleDao.delete(deleteObject);
            //add
            String userRoles = systemUser.getUserRoles();
            for(String roleUuid : userRoles.split(SPLITE_FLAG)){
                if(StringUtils.isNotBlank(roleUuid)){
                    SystemUserRole systemUserRole = new SystemUserRole();
                    systemUserRole.setUserUuid(userUuid);
                    systemUserRole.setRoleUuid(roleUuid);
                    systemUserRoleDao.insertSelective(systemUserRole);
                }
            }
        }
        return result;
    }

    @Override
    public Integer updatePwd(String userUuid,String oldPwd,String newPwd) throws ServiceException{
        if(!StringUtils.isNotBlank(oldPwd)){
            throw new ServiceException(HttpConst.HTTP_RESPONSE_FAIL,"原密码错误！");
        }
        if(!StringUtils.isNotEmpty(newPwd)){
            throw new ServiceException(HttpConst.HTTP_RESPONSE_FAIL,"新密码不能为空！");
        }
        SystemUser record = new SystemUser();
        record.setUuid(userUuid);
        record.setUserPassword(oldPwd);
        Integer count = systemUserDao.selectCount(record);
        if(count == 0 ){
            throw new ServiceException(HttpConst.HTTP_RESPONSE_FAIL,"原密码错误！");
        }
        record.setUserPassword(newPwd);
        Integer result = systemUserDao.updateByPrimaryKeySelective(record);
        return result;
    }

    @Override
    public Date getLastLoginByUuid(String userUuid){
        SystemUser systemUser = systemUserDao.selectByPrimaryKey(userUuid);
        Date result = systemUser.getUserLastLogin();
        SystemUser updateObject = new SystemUser();
        updateObject.setUuid(userUuid);
        updateObject.setUserLastLogin(new Date());
        systemUserDao.updateByPrimaryKeySelective(updateObject);
        return result;
    }
    
}
