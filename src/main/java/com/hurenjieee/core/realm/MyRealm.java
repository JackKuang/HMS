package com.hurenjieee.core.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private SystemUserService systemUserService;

    // 为当前登陆成功的用户授予权限和角色，已经登陆成功了
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        String userId = (String) principals.getPrimaryPrincipal(); // 获取用户Id
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(systemUserService.listRolesCode(userId));
        authorizationInfo.setStringPermissions(systemUserService.listPermissionsCode(userId));
        return authorizationInfo;
    }

    // 验证当前登录的用户，获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        String userId = (String) token.getPrincipal(); // 获取用户名
        System.out.println(token.getCredentials());
        SystemUser systemUser = systemUserService.getUserByUserId(userId);
        if (systemUser != null) {
            Subject subject = SecurityUtils.getSubject();
            // Session session = subject.getSession();
            // session.setAttribute(WebConstant.HTTP_SESSION_SYSTEM_USER,systemUser);
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(systemUser.getUuid(),systemUser.getUserPassword(),"myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}