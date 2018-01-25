package com.hurenjieee.util;

import com.hurenjieee.core.constant.SystemConst;

/**
 * @Description: Json处理返回结果工具类
 * @Author: JackKuang
 * @Since: 2018年1月13日上午10:15:44  
 */
public class AjaxMessageUtils {

    /**
     * @Description: 返回正确信息
     * @Author: JackKuang
     * @Since: 2018年1月22日下午8:03:28
     * @param msg
     * @return
     */
    public static AjaxMessage getSuccessMsg(String msg){
        return new AjaxMessage(true,SystemConst.HTTP_RESPONSE_SUCCESS,msg);
    }
    
    /**
     * @Description: 返回错误信息
     * @Author: JackKuang
     * @Since: 2018年1月22日下午8:03:13
     * @param msg
     * @return
     */
    public static AjaxMessage getFailMsg(String msg){
        return new AjaxMessage(true,SystemConst.HTTP_RESPONSE_FAIL,msg);
    }

    /**
     * @Description: 返回异常信息
     * @Author: JackKuang
     * @Since: 2018年1月22日下午8:03:13
     * @param msg
     * @return
     */
    public static AjaxMessage getExceptionMsg(){
        return new AjaxMessage(true,SystemConst.HTTP_RESPONSE_WRONG,"系统出错，联系管理员");
    }

    /**
     * @Description: 返回正确错误结果
     * @Author: JackKuang
     * @Since: 2018年1月22日下午8:02:23
     * @param obj
     * @return
     */
    public static AjaxMessage getSuccessObj(Object obj){
        return new AjaxMessage(true,SystemConst.HTTP_RESPONSE_SUCCESS,obj);
    }
    
    
    
}
