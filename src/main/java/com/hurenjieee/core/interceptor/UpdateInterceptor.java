package com.hurenjieee.core.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.entity.BaseEntity;
import com.hurenjieee.system.util.AuthorizationUtil;
import com.hurenjieee.util.ReflectUtil;

// Mybatis 只有update和query

@Intercepts({ @Signature(type = Executor.class,method = "update",args = { MappedStatement.class, Object.class }) })
public class UpdateInterceptor implements Interceptor {

    private Properties properties;

    @Override
    public Object intercept(Invocation arg0) throws Throwable{
        MappedStatement mappedStatement = (MappedStatement) arg0.getArgs()[0];
        String sqlId = mappedStatement.getId();
        //String namespace = sqlId.substring(0,sqlId.indexOf('.'));
        String methodNameModify = sqlId.substring(sqlId.lastIndexOf(".") + 1,sqlId.length()).toUpperCase();
        //Executor exe = (Executor) arg0.getTarget();
        String methodName = arg0.getMethod().getName();
        String userUuid =AuthorizationUtil.getLoginUserUuid();
        if (methodName.equals("update")) {
            Object parameter = arg0.getArgs()[1];
            if (parameter instanceof BaseEntity) {
                // (方法包含insert或save)insert，自动设置UUID和createDate
                if (methodNameModify.contains("INSERT") || methodNameModify.contains("SAVE")) {
                    // entity.setUuid(UUID.randomUUID().toString().replaceAll("-","").toUpperCase());
                    List<Field> list = Arrays.asList(parameter.getClass().getDeclaredFields());
                    for ( int i = 0 ; i < list.size() ; i++ ) {
                        Field field = list.get(i);
                        if (field.isAnnotationPresent(AutoInjection.class)) {// 是否使用AutoInjection注解
                            for ( Annotation anno : field.getDeclaredAnnotations() ) {// 获得所有的注解
                                if (anno.annotationType().equals(AutoInjection.class)) {// 找到自己的注解
                                    if (ReflectUtil.getGetMethod(parameter,field.getName()) == null) {// 当前非空时才会赋值
                                        switch (((AutoInjection) anno).type()) {
                                            case CREATE_USER:
                                                ReflectUtil.setValue(parameter,parameter.getClass(),field.getName(),String.class,userUuid);
                                                break;
                                            case CREATE_DATE:
                                                ReflectUtil.setValue(parameter,parameter.getClass(),field.getName(),Date.class,new Date());
                                                break;
                                            case UPDATE_USER:
                                                ReflectUtil.setValue(parameter,parameter.getClass(),field.getName(),String.class,userUuid);
                                                break;
                                            case UPDATE_DATE:
                                                ReflectUtil.setValue(parameter,parameter.getClass(),field.getName(),Date.class,new Date());
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                // (方法包含update)update，自动设置updatedate
                } else if (methodNameModify.contains("UPDATE")) {
                    List<Field> list = Arrays.asList(parameter.getClass().getDeclaredFields());
                    for ( int i = 0 ; i < list.size() ; i++ ) {
                        Field field = list.get(i);
                        if (field.isAnnotationPresent(AutoInjection.class)) {// 是否使用AutoInjection注解
                            for ( Annotation anno : field.getDeclaredAnnotations() ) {// 获得所有的注解
                                if (anno.annotationType().equals(AutoInjection.class)) {// 找到自己的注解
                                    if (ReflectUtil.getGetMethod(parameter,field.getName()) == null) {
                                        switch (((AutoInjection) anno).type()) {
                                            case UPDATE_USER:
                                                ReflectUtil.setValue(parameter,parameter.getClass(),field.getName(),String.class,userUuid);
                                                break;
                                            case UPDATE_DATE:
                                                ReflectUtil.setValue(parameter,parameter.getClass(),field.getName(),Date.class,new Date());
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return arg0.proceed();
    }

    @Override
    public Object plugin(Object arg0){
        return Plugin.wrap(arg0,this);
    }

    @Override
    public void setProperties(Properties arg0){
        this.properties = arg0;
    }
}
