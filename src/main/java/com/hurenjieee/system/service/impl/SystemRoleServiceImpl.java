package com.hurenjieee.system.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemRoleDao;
import com.hurenjieee.system.dao.SystemRolePermissionDao;
import com.hurenjieee.system.entity.SystemRole;
import com.hurenjieee.system.entity.SystemRolePermission;
import com.hurenjieee.system.service.SystemRoleService;

import tk.mybatis.mapper.common.Mapper;


@Service("systemRoleService")
public class SystemRoleServiceImpl extends BaseServiceImpl<SystemRole> implements SystemRoleService {

    @Autowired
    SystemRoleDao systemRoleDao;

    @Autowired
    SystemRolePermissionDao systemRolePermissionDao;
    
    @Override
    public Mapper<SystemRole> getMapper(){
        return systemRoleDao;
    }
    
    @Transactional
    @Override
    public Integer insertSelective(SystemRole systemRole){
        Integer result = getMapper().insertSelective(systemRole);
        if(result > 0){
            String permissions = systemRole.getPermissions();
            String roleUuid = systemRole.getUuid();
            //插入新增加的
            for(String permissionUuid : permissions.split(",")){
                if(StringUtils.isNotBlank(permissionUuid)){
                    SystemRolePermission systemRolePermission = new SystemRolePermission();
                    systemRolePermission.setPermissionUuid(permissionUuid);
                    systemRolePermission.setRoleUuid(roleUuid);
                    systemRolePermissionDao.insertSelective(systemRolePermission);
                }
            }
        }
        return result;
    }

    @Transactional
    @Override
    public Integer updateByKeySelective(SystemRole systemRole){
        Integer result = getMapper().updateByPrimaryKeySelective(systemRole);
        if(result > 0){
            //删除原来存在的
            String roleUuid = systemRole.getUuid();
            SystemRolePermission deleteObject = new SystemRolePermission();
            deleteObject.setRoleUuid(roleUuid);
            systemRolePermissionDao.delete(deleteObject);
            //插入新增加的
            String permissions = systemRole.getPermissions();
            for(String permissionUuid : permissions.split(",")){
                if(StringUtils.isNotBlank(permissionUuid)){
                    SystemRolePermission systemRolePermission = new SystemRolePermission();
                    systemRolePermission.setPermissionUuid(permissionUuid);
                    systemRolePermission.setRoleUuid(roleUuid);
                    systemRolePermissionDao.insertSelective(systemRolePermission);
                }
            }
        }
        return result;
    }

    @Override
    public List<Map> selectRoleByUserUuid(String userUuid){
        return systemRolePermissionDao.selectRoleByUserUuid(userUuid);
    }


}
