package com.hurenjieee.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;

@Controller("loginController")
@Scope("prototype")
public class LoginController {
    
    @Autowired
    SystemUserService systemUserService;
    
    public void login(Model model,String userName,String password){
        try {
            SystemUser s = new SystemUser();
            s = systemUserService.selectOne(s);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }

}
