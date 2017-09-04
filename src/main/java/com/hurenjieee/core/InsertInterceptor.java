package com.hurenjieee.core;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;


@Intercepts({@Signature(
        type= Executor.class,
        method = "insert",
        args = {MappedStatement.class,Object.class})})
public class InsertInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation arg0) throws Throwable{
        return arg0.proceed();
    }

    @Override
    public Object plugin(Object arg0){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setProperties(Properties arg0){
        // TODO Auto-generated method stub

    }
    /*
     * @Override
     * public Object invoke(MethodInvocation arg0) throws Throwable{
     * // TODO Auto-generated method stub
     * Object[] args = arg0.getArguments();
     * BaseEntity entity = (BaseEntity)args[0];
     * entity.setUuid(UUID.randomUUID().toString());
     * entity.setCreateDate(new Date());
     * return null;
     * }
     */
}
