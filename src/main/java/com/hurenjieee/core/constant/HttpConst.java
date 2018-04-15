package com.hurenjieee.core.constant;



/**
 * @Description: Http请求返回类型
 * @Author: JackKuang
 * @Since: 2018年4月15日下午3:53:34  
 */
public class HttpConst {
    //-----------请求接受开始-----------
    
    /** 
     * @Fields: HTTP_REQUEST_GET : GET请求
     */ 
    public static String HTTP_REQUEST_GET = "GET";
    
    /** 
     * @Fields: HTTP_REQUEST_POST : POST 请求
     */ 
    public static String HTTP_REQUEST_POST = "POST";
    //-----------请求接受结束-----------
    
    //-----------请求返回开始-----------
    
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
    

    //-----------请求返回结束-----------
}
