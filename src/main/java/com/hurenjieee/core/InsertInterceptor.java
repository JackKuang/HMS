package com.hurenjieee.core;

import java.util.Date;
import java.util.UUID;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class InsertInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable{
        // TODO Auto-generated method stub
        Object[] args = arg0.getArguments();
        BaseEntity entity = (BaseEntity)args[0];
        entity.setUuid(UUID.randomUUID().toString());
        entity.setCreateDate(new Date());
        return null;
    }


}
