package com.hurenjieee.system.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hurenjieee.core.constant.WebConstant;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemPermissionService;

@Controller("systemPermissionController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemPermissionController {
    
    @Autowired
    SystemPermissionService systemPermissionService;
    
    @RequestMapping("permission")
    public String index(Model model,HttpSession session){
        return "system/permission_index";
    }
    
    @RequestMapping("testJson")
    @ResponseBody
    public List list(HttpSession session) throws Exception {
        SystemUser systemUser = (SystemUser) session.getAttribute(WebConstant.HTTP_SESSION_SYSTEM_USER);
        List list = systemPermissionService.listPermissionsByUserId(systemUser.getUserId());
        return list;
     }

}
