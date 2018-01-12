package com.hurenjieee.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @Description: 自动注入注解，操作数据库insert和update时实现
 * @Author: JackKuang
 * @Since: 2018年1月12日下午6:08:36  
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME )
public @interface AutoInjection {
    InjectionType type();
}
