package com.hurenjieee.system.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.system.entity.SystemPermission;
import com.hurenjieee.system.service.SystemPermissionService;
import com.hurenjieee.system.util.AuthorizationUtil;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.AjaxMessageUtils;

@Controller("systemPermissionController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemPermissionController {

    @Autowired
    SystemPermissionService systemPermissionService;

    // ----------特殊接口开始----------

    /**
     * @Description: List类型（菜单列表）,adminUuid管理下userUuid的菜单
     * @Author: JackKuang
     * @Since: 2018年2月7日下午1:42:11
     * @param session
     * @param roleUuid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "rolsPermissions",method = RequestMethod.GET)
    @ResponseBody
    public List listAllPermissionsByUserUuid(HttpSession session,String roleUuid) throws Exception{
        List list = systemPermissionService.listAllPermissionsByUserUuid(roleUuid,AuthorizationUtil.getLoginUserUuid());
        return list;
    }

    /**
     * @Description: List类型（菜单列表）
     * @Author: JackKuang
     * @Since: 2018年2月7日下午1:42:06
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "permissions",method = RequestMethod.GET)
    @ResponseBody
    public List list(HttpSession session) throws Exception{
        List list = systemPermissionService.listPermissionsByUserUuid(AuthorizationUtil.getLoginUserUuid());
        return list;
    }
    

    /**
     * @Description: List类型（菜单列表）（适应三版首页）
     * @Author: JackKuang
     * @Since: 2018年2月7日下午1:42:06
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "permissionsIndex",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> listIndex(HttpSession session) throws Exception{
        List<Map<String,Object>> list = systemPermissionService.listPermissionsForByUserUuid(AuthorizationUtil.getLoginUserUuid());
        return list;
    }

    // ----------特殊接口结束----------

    // ----------通用接口开始----------
    @RequestMapping("permissionIndex")
    public String index(Model model,HttpSession session){
        return "system/permission/permissionIndex";
    }
    
    @RequestMapping(value = "permissions/{uuid}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMessage list(@PathVariable String uuid) throws Exception{
        try {
            SystemPermission systemPermission = new SystemPermission();
            systemPermission.setUuid(uuid);
            systemPermission = systemPermissionService.selectByKey(systemPermission);
            return AjaxMessageUtils.getSuccessObj(systemPermission);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxMessageUtils.getExceptionMsg();
        }
    }

    @RequestMapping(value = "permissions",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage save(SystemPermission systemPermission){
        try {
            if (systemPermission.getPermissionState() == null)
                systemPermission.setPermissionState(0);
            Integer num = systemPermissionService.insertSelective(systemPermission);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("新增成功");
            } else {
                return AjaxMessageUtils.getFailMsg("新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "permissions/{uuid}",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxMessage update(SystemPermission systemPermission,@PathVariable String uuid){
        try {
            if (systemPermission.getPermissionState() == null)
                systemPermission.setPermissionState(0);
            systemPermission.setUuid(uuid);
            Integer num = systemPermissionService.updateByKeySelective(systemPermission);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("修改成功");
            } else {
                return AjaxMessageUtils.getFailMsg("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "permissions/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxMessage delete(@PathVariable String uuid){
        try {
            Integer num = systemPermissionService.deletePermission(uuid);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("删除成功");
            } else {
                return AjaxMessageUtils.getFailMsg("删除失败");
            }
        } catch (ServiceException se) {
            return AjaxMessageUtils.getFailMsgFromException(se);
        } catch (Exception e) {
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    // ----------通用接口开始----------
}
