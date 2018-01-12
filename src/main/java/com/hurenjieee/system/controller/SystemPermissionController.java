package com.hurenjieee.system.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hurenjieee.system.entity.SystemPermission;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemPermissionService;
import com.hurenjieee.system.util.AuthorizationUtil;
import com.hurenjieee.util.MapUtil;

@Controller("systemPermissionController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemPermissionController {
    
    @Autowired
    SystemPermissionService systemPermissionService;
    
    @RequestMapping("permissionIndex")
    public String index(Model model,HttpSession session){
        return "system/permission_index";
    }
    
    @RequestMapping(value="permissions",method=RequestMethod.GET)
    @ResponseBody
    public List list(HttpSession session) throws Exception {
        List list = systemPermissionService.listPermissionsByUserId(AuthorizationUtil.getLoginUserUuid());
        return list;
    }
    
    @RequestMapping(value="permissions",method=RequestMethod.POST)
    @ResponseBody
    public Map add(SystemPermission systemPermission){
        try {
            Integer num = systemPermissionService.insertSelective(systemPermission);
            if(num==1){
                return MapUtil.getResult(true,"添加成功！");
            }else {
                return MapUtil.getResult(false,"添加失败！");
            }
        } catch (Exception e) {
            return MapUtil.getResult(false,"系统出错！");
        }
    }
    
    @RequestMapping(value="permissions/${uuid}",method=RequestMethod.PUT)
    @ResponseBody
    public Map update(SystemPermission systemPermission,@PathVariable String uuid){
        try {
            systemPermission.setUuid(uuid);
            Integer num = systemPermissionService.updateByKeySelective(systemPermission);
            if(num==1){
                return MapUtil.getResult(true,"修改成功！");
            }else {
                return MapUtil.getResult(false,"修改失败！");
            }
        } catch (Exception e) {
            return MapUtil.getResult(false,"系统出错！");
        }
    }

   /* @RequestMapping(value="permissions/${uuid}",method=RequestMethod.DELETE)
    @ResponseBody
    public Map delete(@PathVariable String uuid){
        try {
            Integer num = systemPermissionService.deleteByKey(uuid);
            if(num==1){
                return MapUtil.getResult(true,"删除成功！");
            }else {
                return MapUtil.getResult(false,"删除失败！");
            }
        } catch (Exception e) {
            return MapUtil.getResult(false,"系统出错！");
        }
    }
*/
}
