package com.hurenjieee.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;
import com.hurenjieee.util.RSAUtil;

@Controller("loginController")
@Scope("prototype")
@RequestMapping("/system")
public class LoginController {
    
    @Autowired
    SystemUserService systemUserService;
    
    @RequestMapping("login.action")
    public String login(Model model,String username,String password){
        try {
            SystemUser s = new SystemUser();
            s.setUserId(username);
            s.setUserPassword(password);
            s = systemUserService.selectOne(s);
            Map<String, String> data = RSAUtil.generateKeyPair();
            model.addAttribute("publicKey",data.get("publicKey"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "system/login";
    }
    @RequestMapping("/preLogin")
    public String preLogin(Model model,String username,String password){
        return "system/login";
    }

}
