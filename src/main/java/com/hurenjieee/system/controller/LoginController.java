package com.hurenjieee.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;

@Controller("loginController")
@Scope("prototype")
public class LoginController {
    
    @Autowired
    SystemUserService systemUserService;
    
    public void login(){
        try {
            String username;
            String password;
            SystemUser s = new SystemUser();
            s = systemUserService.selectOne(s);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }

}
