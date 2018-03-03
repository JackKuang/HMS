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
     * @Description: List类型（菜单列表）,adminUuid管理下userUuid的菜单
     * @Author: JackKuang
     * @Since: 2018年1月18日下午8:14:02
     * @param userUuid
     * @return
     */
    public List<Map<String,Object>> listAllPermissionsByUserUuid(String roleUuid,String adminUuid);

    /**
     * @Description: 删除操作，删除前判断子节点存在否
     * @Author: JackKuang
     * @Since: 2018年2月7日下午2:02:31
     * @param uuid
     * @return
     * @throws Exception
     */
    public Integer deletePermission(String uuid) throws Exception;

    /**
     * @Description: List类型（菜单列表）（适应三版首页）
     * @Author: JackKuang
     * @Since: 2018年3月1日下午7:57:40
     * @param loginUserUuid
     * @return
     */
    public List<Map<String,Object>> listPermissionsForByUserUuid(String userUuid);
    
}
