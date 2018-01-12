package com.hurenjieee.system.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.hurenjieee.system.entity.SystemUser;


/**
 * @Description: 更具Shiro获取到用户信息
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
      /*Subject subject = SecurityUtils.getSubject();
        String userUuid = subject.getPrincipal().toString();
        */
        String userUuid = "userId";
        return userUuid;
    }

}
