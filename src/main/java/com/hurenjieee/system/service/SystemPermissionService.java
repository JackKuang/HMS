package com.hurenjieee.system.service;

import java.util.List;
import java.util.Map;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemPermission;

public interface SystemPermissionService extends BaseService<SystemPermission> {

    /**
     * @Description: 树形菜单（菜单显示）
     * @Author: JackKuang
     * @Since: 2018年1月18日下午8:13:52
     * @param userUuid
     * @return
     */
    public List<Map<String,Object>> listPermissionsMenuByUserUuid(String userUuid);

    /**
     * @Description: List类型（菜单列表）
     * @Author: JackKuang
     * @Since: 2018年1月18日下午8:14:02
     * @param userUuid
     * @return
     */
    public List<Map<String,Object>> listPermissionsByUserUuid(String userUuid);

    /**
     * @Description: 删除列表时需要删除角色权限关系
     * @Author: JackKuang
     * @Since: 2018年1月18日下午8:14:42
     * @param uuid
     */
    public void deleteRolePermissionByPermission(String uuid);

    /**
     * @Description: 删除前判断是否存在子节点
     * @Author: JackKuang
     * @Since: 2018年1月18日下午8:15:15
     * @param uuid
     * @return
     */
    public Integer selectSonNumByParUuid(String uuid);
    
}
