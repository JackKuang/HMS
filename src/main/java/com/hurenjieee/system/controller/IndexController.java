package com.hurenjieee.system.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hurenjieee.system.service.SystemPermissionService;
import com.hurenjieee.system.service.SystemUserService;
import com.hurenjieee.system.util.AuthorizationUtil;

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
        /*
         * Subject subject = SecurityUtils.getSubject();
         * SystemUser systemUser;
         * if(subject.isRemembered()){
         * String userId = subject.getPrincipal().toString();
         * systemUser = systemUserService.getUserByUserId(userId);
         * session.setAttribute(WebConstant.HTTP_SESSION_SYSTEM_USER,systemUser);
         * }else{
         * systemUser = (SystemUser) session.getAttribute(WebConstant.HTTP_SESSION_SYSTEM_USER);
         * }
         * List list = systemPermissionService.listPermissionsMenuByUserId(systemUser.getUserId());
         */
        String userUuid = AuthorizationUtil.getLoginUserUuid();
        List list = systemPermissionService.listPermissionsMenuByUserUuid(userUuid);
        model.addAttribute("permissionList",list);
        return "system/index";
    }
}
