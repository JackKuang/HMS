package com.hurenjieee.system.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @Description: 根据Shiro获取到用户信息
 * @Author: JackKuang
 * @Since: 2018年1月12日下午8:58:44  
 */
public class AuthorizationUtil {

    /**
     * @Description: 获取到登陆用户的uuid
     * @Author: JackKuang
     * @Since: 2018年1月12日下午8:58:30
     * @return
     */
    public static String getLoginUserUuid(){
        String userUuid = "";
        try{
            Subject subject = SecurityUtils.getSubject();
            userUuid = subject.getPrincipal().toString();
        }catch(Exception e){
            userUuid = "ExceptionUser";
        }
        return userUuid;
    }
}
