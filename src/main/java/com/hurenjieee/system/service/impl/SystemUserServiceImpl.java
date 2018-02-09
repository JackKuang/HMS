package com.hurenjieee.system.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.constant.SystemConst;
import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemUserDao;
import com.hurenjieee.system.dao.SystemUserRoleDao;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.entity.SystemUserRole;
import com.hurenjieee.system.service.SystemUserService;

import tk.mybatis.mapper.common.Mapper;

@Service("systemUserService")
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUser> implements SystemUserService{
    
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
            throw new ServiceException(SystemConst.HTTP_RESPONSE_FAIL,"当前用户Id已存在，不可重复");
        }
        Integer result = systemUserDao.insertSelective(systemUser);
        if(result > 0){
            //add
            String userUuid = systemUser.getUuid();
            String userRoles = systemUser.getUserRoles();
            for(String roleUuid : userRoles.split(",")){
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
            for(String roleUuid : userRoles.split(",")){
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
    
    
    
    
}
