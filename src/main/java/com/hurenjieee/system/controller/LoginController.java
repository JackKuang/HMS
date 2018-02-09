
package com.hurenjieee.system.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
    public String login(Model model,String username,String password,boolean remember,HttpSession session){
        try {
            // 获取密钥
            String privateKey = (String) session.getAttribute("privateKey");
            //String passwordHashed = RSAUtil.decrypt(privateKey,password);
            String passwordHashed = password;
            Subject subject = SecurityUtils.getSubject();
            // 数据库保存SHA512加密后的数据，
            UsernamePasswordToken token = new UsernamePasswordToken(username,passwordHashed,remember);
            subject.login(token);
            // 登陆成功之后HttpSession中去除RSAkey
            session.removeAttribute("privateKey");
            session.removeAttribute("publicKey");
            return "redirect:/system/index";
        } catch (Exception e) {
            // 这里将异常打印关闭是因为如果登录失败的话会自动抛异常
            e.printStackTrace();
            model.addAttribute("error","用户名或密码错误！");
            // 配置RSA公钥密钥
            String publicKey = setKeyAttribute(session);
            model.addAttribute("publicKey",publicKey);
            return "system/login";
        }

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
        // 配置RSA公钥密钥
        String publicKey = setKeyAttribute(session);
        mv.addObject("publicKey",publicKey);
        return mv;
    }

    /**
     * @Description: 把RSA公钥密钥放入session中，返回公钥publicKey
     * @Author: JackKuang
     * @Since: 2017年10月12日上午10:54:01
     * @param session
     * @return publicKey
     */
    private String setKeyAttribute(HttpSession session){
        Map<String, String> data = RSAUtil.generateKeyPair();
        String privateKey = data.get("privateKey");
        String publicKey = data.get("publicKey");
        session.setAttribute("privateKey",privateKey);
        session.setAttribute("publicKey",publicKey);
        return publicKey;
    }

}
