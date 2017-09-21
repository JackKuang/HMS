package com.hurenjieee.core;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;


//Mybatis 只有update和query
@Intercepts({  
        @Signature(type = Executor.class, method = "update", args = {  
                MappedStatement.class, Object.class }) })  
public class InsertInterceptor implements Interceptor {
    
    private Properties properties;  
    
    @Override
    public Object intercept(Invocation arg0) throws Throwable{
        MappedStatement mappedStatement = (MappedStatement) arg0  
                .getArgs()[0];  
        String sqlId = mappedStatement.getId();  
        String namespace = sqlId.substring(0, sqlId.indexOf('.'));
        String methodNameModify = sqlId.substring(sqlId.lastIndexOf(".")+1,sqlId.length()).toUpperCase();  
        Executor exe = (Executor) arg0.getTarget();  
        String methodName = arg0.getMethod().getName();
        //i
        if(methodName.equals("update")){  
            Object parameter = arg0.getArgs()[1];  
            if(parameter instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) parameter;
                //insert，自动设置UUID
                //update，
                if(methodNameModify.contains("INSERT") || methodNameModify.contains("SAVE")) {
                    entity.setUuid(UUID.randomUUID().toString().replaceAll("-","").toUpperCase());
                    entity.setCreateDate(new Date());
                }else if(methodNameModify.contains("UPDATE")) {
                    entity.setUpdateDate(new Date());
                }
            }
        }  
        return arg0.proceed();  
    }

    @Override
    public Object plugin(Object arg0){
        return Plugin.wrap(arg0, this);  
    }

    @Override
    public void setProperties(Properties arg0){
        this.properties = arg0;  
    }
}
