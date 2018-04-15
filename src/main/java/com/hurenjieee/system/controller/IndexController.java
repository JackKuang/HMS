package com.hurenjieee.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hurenjieee.core.constant.SystemConst;
import com.hurenjieee.system.service.SystemPermissionService;
import com.hurenjieee.system.service.SystemUserService;
import com.hurenjieee.system.util.AuthorizationUtil;


/**
 * @Description: 首页Controller
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:18:38  
 */
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
        /*String userUuid = AuthorizationUtil.getLoginUserUuid();
        List list = systemPermissionService.listPermissionsMenuByUserUuid(userUuid);
        model.addAttribute("permissionList",list);*/
        boolean isNull = session.getAttribute(SystemConst.USER_LAST_LOGIN_TIME) == null;
        if(isNull){
            session.setAttribute(SystemConst.USER_LAST_LOGIN_TIME,systemUserService.getLastLoginByUuid(AuthorizationUtil.getLoginUserUuid()));
        }
        return "system/index";
    }
    

    @RequestMapping("main")
    public String main(Model model,HttpSession session){
        return "system/main";
    }
}
