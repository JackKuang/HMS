package com.hurenjieee.core.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;


/**
 * @Description: 自定义shrio域
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:08:44  
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private SystemUserService systemUserService;

    /**
     * @Description: 为当前登陆成功的用户授予权限和角色，已经登陆成功了
     * @Author: JackKuang
     * @Since: 2018年4月15日下午4:09:46
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        // 获取用户Id
        String userId = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(systemUserService.listRolesCode(userId));
        authorizationInfo.setStringPermissions(systemUserService.listPermissionsCode(userId));
        return authorizationInfo;
    }

    /**
     * @Description: 验证当前登录的用户，获取认证信息
     * @Author: JackKuang
     * @Since: 2018年4月15日下午4:10:07
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        // 获取用户名
        String userId = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        SystemUser systemUser = systemUserService.getUserByUserId(userId);
        if (systemUser != null) {
            /*
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute(SystemConst.USER_LAST_LOGIN_TIME,systemUserService.getLastLoginByUuid(systemUser.getUuid()));
            */
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(systemUser.getUuid(),systemUser.getUserPassword(),"myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}