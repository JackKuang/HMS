package com.hurenjieee.system.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework. web.bind.annotation.RequestMapping;

import com.hurenjieee.core.constant.WebConstant;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemPermissionService;
import com.hurenjieee.system.service.SystemUserService;

@Controller("indexController")
@Scope("prototype")
@RequestMapping("/system")
public class IndexController {

    @Autowired
    SystemPermissionService systemPermissionService;
    
    @Autowired
    SystemUserService systemUserService;

    @RequestMapping("index")
    public String login(Model model,HttpSession session){
        Subject subject = SecurityUtils.getSubject(); 
        SystemUser systemUser;
        if(subject.isRemembered()){
            String userId = subject.getPrincipal().toString();
            systemUser = systemUserService.selectByUserId(userId);
            session.setAttribute(WebConstant.HTTP_SESSION_SYSTEM_USER,systemUser);
        }else{
            systemUser = (SystemUser) session.getAttribute(WebConstant.HTTP_SESSION_SYSTEM_USER);
        }
        List list = systemPermissionService.getPermission(systemUser.getUserId());
        model.addAttribute("permissionList",list);
        return "system/index";
    }
}
