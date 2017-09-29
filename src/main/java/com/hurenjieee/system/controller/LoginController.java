package com.hurenjieee.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;

@Controller("loginController")
@Scope("prototype")
public class LoginController {
    
    @Autowired
    SystemUserService systemUserService;
    
    @RequestMapping("/login.action")
    public String login(Model model,String username,String password){
        try {
            SystemUser s = new SystemUser();
            s.setUserId(username);
            s.setUserPassword(password);
            s = systemUserService.selectOne(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}
