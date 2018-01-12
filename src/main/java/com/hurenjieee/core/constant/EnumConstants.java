package com.hurenjieee.core.constant;



/**
 * @Description: 常量枚举类，把所有的常量统一用枚举类保存
 * @Author: JackKuang
 * @Since: 2018年1月12日下午8:42:05  
 */
public enum EnumConstants {

    /** 
     * @Fields: HTTP_SESSION_SYSTEM_USER : 定义在HttpSession中的当前登录人信息
     */ 
    HTTP_SESSION_SYSTEM_USER("systemUser");
    
    private String value;

    private EnumConstants(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    
    public void setValue(String value){
        this.value = value;
    }
    
}
