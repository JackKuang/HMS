package com.hurenjieee.util;


/**
 * @Description: Json处理返回结果
 * @Author: JackKuang
 * @Since: 2018年1月13日上午10:15:44  
 */
public class AjaxMessage {
    
    /** 
     * @Fields: success : 处理结果
     */ 
    private boolean success = false;
    /** 
     * @Fields: code : 消息码
     */ 
    private String code = null;
    /** 
     * @Fields: msg : 消息提示
     */ 
    private String msg = null;
    /** 
     * @Fields: obj : 返回的结果
     */ 
    private Object obj = null;

    public AjaxMessage() {
        super();
    }

    /**
     * Object 结果集
     * @param success
     * @param obj
     */
    public AjaxMessage(boolean success, String code, Object obj) {
        this.success = success;
        this.code = code;
        this.obj = obj;
        this.msg = "";
    }

    /**
     * 结果信息返回
     * @param success
     * @param code
     * @param msg
     */
    public AjaxMessage(boolean success, String code, String msg) {
        super();
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public Object getObj(){
        return obj;
    }

    public void setObj(Object obj){
        this.obj = obj;
    }

}
