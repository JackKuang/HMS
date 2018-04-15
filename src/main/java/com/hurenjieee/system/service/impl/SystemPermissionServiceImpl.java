package com.hurenjieee.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.constant.HttpConst;
import com.hurenjieee.core.constant.SystemConst;
import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemPermissionDao;
import com.hurenjieee.system.entity.SystemPermission;
import com.hurenjieee.system.service.SystemPermissionService;
import com.hurenjieee.util.TreeUtil;

import tk.mybatis.mapper.common.Mapper;


/**
 * @Description: 权限
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:49:42  
 */
@Service("systemPermissionService")
public class SystemPermissionServiceImpl extends BaseServiceImpl<SystemPermission> implements SystemPermissionService {

    @Autowired
    SystemPermissionDao systemPermissionDao;

    @Override
    public Mapper<SystemPermission> getMapper(){
        return systemPermissionDao;
    }

    @Override
    public List<Map<String, Object>> listPermissionsMenuByUserUuid(String userUuid){
        List<Map<String, Object>> permissions = systemPermissionDao.listPermissionsByUserUuid(userUuid);
        return TreeUtil.listToTree(permissions,"permissionUuid","permissionParUuid","permissionOrder");
    }

    @Override
    public List<Map<String, Object>> listPermissionsByUserUuid(String userUuid){
        List<Map<String, Object>> permissions;
        if (SystemConst.SYSTEM_ADMIN_UUID.equals(userUuid)) {
            permissions = systemPermissionDao.listAllPermissions();
        } else {
            permissions = systemPermissionDao.listPermissionsByUserUuid(userUuid);
        }
        permissions = TreeUtil.listToTree(permissions,"permissionUuid","permissionParUuid","permissionOrder");
        Map<String, String> para = new HashMap<>(3);
        para.put("permissionName","name");
        para.put("list","children");
        para.put("permissionUuid","id");
        permissions = TreeUtil.treeToNodes(permissions,para);
        return permissions;
    }

    @Override
    public List<Map<String, Object>> listAllPermissionsByUserUuid(String roleUuid,String adminUuid){
        List<Map<String, Object>> permissions;
        if (SystemConst.SYSTEM_ADMIN_UUID.equals(adminUuid)) {
            permissions = systemPermissionDao.listAllPermissionsByAdmin(roleUuid);
        } else {
            permissions = systemPermissionDao.listAllPermissionsByUserUuid(roleUuid,SystemConst.SYSTEM_ADMIN_UUID);
        }
        permissions = TreeUtil.listToTree(permissions,"permissionUuid","permissionParUuid","permissionOrder");
        Map<String, String> para = new HashMap<>(3);
        para.put("permissionName","name");
        para.put("list","children");
        para.put("permissionUuid","id");
        permissions = TreeUtil.treeToNodes(permissions,para);
        return permissions;
    }

    @Override
    public Integer deletePermission(String id) throws Exception{
        Integer sonNum = systemPermissionDao.selectSonNumByParUuid(id);
        if (sonNum > 0) {
            throw new ServiceException(HttpConst.HTTP_RESPONSE_FAIL,"当前节点存在子节点，无法删除");
        }
        Integer result = systemPermissionDao.deleteByPrimaryKey(id);
        if (result > 0) {
            systemPermissionDao.deleteRolePermissionByPermission(id);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> listPermissionsForByUserUuid(String userUuid){
        List<Map<String, Object>> permissions;
        permissions = systemPermissionDao.listPermissionsByUserUuid(userUuid);
        permissions = TreeUtil.listToTree(permissions,"permissionUuid","permissionParUuid","permissionOrder");
        Map<String, String> para = new HashMap<>(4);
        para.put("permissionName","title");
        para.put("permissionStyle","icon");
        para.put("permissionUrl","href");
        para.put("list","children");
        permissions = TreeUtil.treeToNodes(permissions,para);
        return permissions;
    }

}
