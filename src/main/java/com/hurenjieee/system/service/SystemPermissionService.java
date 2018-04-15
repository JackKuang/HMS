package com.hurenjieee.system.service;

import java.util.List;
import java.util.Map;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemPermission;

/**
 * @Description: 权限
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:54:38  
 */
public interface SystemPermissionService extends BaseService<SystemPermission> {

    /**
     * 树形菜单（菜单显示）
     * 
     * @Description: 树形菜单（菜单显示）
     * @Author: JackKuang
     * @Since: 2018年1月18日下午8:13:52
     * @param userUuid
     * @return
     */
    public List<Map<String,Object>> listPermissionsMenuByUserUuid(String userUuid);

    /**
     * List类型（菜单列表）
     * 
     * @Description: List类型（菜单列表）
     * @Author: JackKuang
     * @Since: 2018年1月18日下午8:14:02
     * @param userUuid
     * @return
     */
    public List<Map<String,Object>> listPermissionsByUserUuid(String userUuid);
    
    /**
     * List类型（菜单列表）,adminUuid管理下userUuid的菜单
     * 
     * @Description: List类型（菜单列表）,adminUuid管理下userUuid的菜单
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:38:32
     * @param roleUuid
     * @param adminUuid
     * @return
     */
    public List<Map<String,Object>> listAllPermissionsByUserUuid(String roleUuid,String adminUuid);

    /**
     * 删除操作，删除前判断子节点存在否
     * 
     * @Description: 删除操作，删除前判断子节点存在否
     * @Author: JackKuang
     * @Since: 2018年2月7日下午2:02:31
     * @param uuid
     * @return
     * @throws Exception
     */
    public Integer deletePermission(String uuid) throws Exception;

    /**
     * List类型（菜单列表）（适应三版首页）
     * 
     * @Description: List类型（菜单列表）（适应三版首页）
     * @Author: JackKuang
     * @Since: 2018年3月1日下午7:57:40
     * @param userUuid
     * @return
     */
    public List<Map<String,Object>> listPermissionsForByUserUuid(String userUuid);
    
}
