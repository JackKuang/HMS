package com.hurenjieee.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @Description: SpringContextUtil Spring上下文工具类
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:17:33  
 */
@Component  
public class SpringContextUtil implements ApplicationContextAware {  
  
    /** 
     * @Fields: applicationContext : Spring应用上下文环境  
     */ 
    private static ApplicationContext applicationContext; 
  
    /**
     * @Description: 通过传递applicationContext参数初始化成员变量applicationContext 
     * @Author: JackKuang
     * @Since: 2018年4月15日下午4:17:54
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        SpringContextUtil.applicationContext = applicationContext;  
    }    
    
    public static ApplicationContext getApplicationContext() {  
        return applicationContext;  
    }  

    @SuppressWarnings("unchecked")  
    public static <T> T getBean(String name) throws BeansException {  
        return (T) applicationContext.getBean(name);  
    }  
  
}  