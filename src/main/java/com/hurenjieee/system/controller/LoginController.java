package com.hurenjieee.system.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;
import com.hurenjieee.util.RSAUtil;
import com.hurenjieee.util.StringUtil;

@Controller("loginController")
@Scope("prototype")
@RequestMapping("/system")
public class LoginController {
    
    @Autowired
    SystemUserService systemUserService;
    
    /**
     * @Description: 登录
     * @Author: JackKuang
     * @Since: 2017年10月3日下午9:40:55
     * @param model
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(Model model,String username,String password,HttpSession session){
        try {
            SystemUser s = new SystemUser();
            //获取密钥
            String privateKey = (String)session.getAttribute("privateKey");
            String passwordHashed = RSAUtil.decrypt(privateKey,password);
            
            Subject subject = SecurityUtils.getSubject() ;
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            
            
/*            try {
                subject.login(token);
                return "admin" ;
            }catch (Exception e){
                //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//                e.printStackTrace();
                model.addAttribute("error","用户名或密码错误") ;
                return "../../login" ;
            }
*/
            
            s.setUserId(username);
            s.setUserPassword(passwordHashed);
            SystemUser s2 = systemUserService.select(s).get(0);
            if(s2!=null)
                return "index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "system/login";
    }
    
    /**
     * @Description: 预登录
     * @Author: JackKuang
     * @Since: 2017年10月3日下午9:41:09
     * @param model
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/preLogin")
    public ModelAndView preLogin(Model model,String username,String password,HttpSession session){
        ModelAndView mv = new ModelAndView("system/login");
        //获取公钥密钥
        Map<String, String> data = RSAUtil.generateKeyPair();
        String privateKey = StringUtil.getStringNoBlank(data.get("privateKey").trim());
        String publicKey = StringUtil.getStringNoBlank(data.get("publicKey").trim());
        mv.addObject("publicKey",publicKey);
        session.setAttribute("privateKey",privateKey);
        System.out.println(RSAUtil.encrypt(publicKey,"123456"));
        session.setAttribute("publicKey",publicKey);
        return mv;
    }

}
