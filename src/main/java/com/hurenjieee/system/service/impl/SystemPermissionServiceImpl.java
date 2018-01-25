package com.hurenjieee.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemPermissionDao;
import com.hurenjieee.system.entity.SystemPermission;
import com.hurenjieee.system.service.SystemPermissionService;
import com.hurenjieee.util.TreeUtil;

import tk.mybatis.mapper.common.Mapper;


@Service("systemPermissionService")
public class SystemPermissionServiceImpl extends BaseServiceImpl<SystemPermission> implements SystemPermissionService {

    @Autowired
    SystemPermissionDao systemPermissionDao;
    
    @Override
    public Mapper<SystemPermission> getMapper(){
        return systemPermissionDao;
    }

    @Override
    public List<Map> listPermissionsMenuByUserUuid(String userUuid){
        List<Map> permissions = systemPermissionDao.listPermissionsByUserUuid(userUuid);
        return TreeUtil.listToTree(permissions,"permissionCode","permissionParCode","permissionOrder");
    }

    @Override
    public List<Map> listPermissionsByUserUuid(String userUuid){
        List<Map> permissions;
        if(userUuid != null && "admin".equals(userUuid))
            permissions = systemPermissionDao.listAllPermissions();
        else
            permissions = systemPermissionDao.listPermissionsByUserUuid(userUuid);
        return permissions;
    }

    @Override
    public void deleteRolePermissionByPermission(String uuid){
        systemPermissionDao.deleteRolePermissionByPermission(uuid);
    }

    @Override
    public Integer selectSonNumByParUuid(String uuid){
        return systemPermissionDao.selectSonNumByParUuid(uuid);
    }


}
