package com.hurenjieee.core.constant;



/**
 * @Description: 常量枚举类，把所有的常量统一用枚举类保存
 * @Author: JackKuang
 * @Since: 2018年1月12日下午8:42:05  
 */

/**
 * @Description: TODO
 * @Author: JackKuang
 * @Since: 2018年1月22日下午6:47:49  
 */
public class SystemConst {

    /** 
     * @Fields: HTTP_SESSION_SYSTEM_USER : 定义在HttpSession中的当前登录人信息
     */ 
    public static String HTTP_SESSION_SYSTEM_USER = "SYSTEM_USER";
    
    /** 
     * @Fields: HTTP_REQUEST_SUCCESS : 请求成功
     */ 
    public static String HTTP_RESPONSE_SUCCESS = "SUCCESS";

    /** 
     * @Fields: HTTP_RESPONSE_FAIL : 请求失败
     */ 
    public static String HTTP_RESPONSE_FAIL = "FAIL";
    
    /** 
     * @Fields: HTTP_RESPONSE_RESUBMIT : 重复请求
     */ 
    public static String HTTP_RESPONSE_RESUBMIT = "RESUBMIT";
    
    /** 
     * @Fields: HTTP_RESPONSE_WRONG : 系统报错导致异常
     */ 
    public static final String HTTP_RESPONSE_WRONG = "WRONG";
       
}
