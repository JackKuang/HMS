package com.hurenjieee.system.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework. web.bind.annotation.RequestMapping;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemPermissionService;

@Controller("indexController")
@Scope("prototype")
@RequestMapping("/system")
public class IndexController {

    @Autowired
    SystemPermissionService systemPermissionService;

    @RequestMapping("index")
    public String login(Model model,HttpSession session){
        SystemUser systemUser = (SystemUser)session.getAttribute("systemUser");
        List list = systemPermissionService.getPermission("admin");
        model.addAttribute("permissionList",list);
        return "system/index";
    }
}
