package com.hurenjieee.core.exception;

/**
 * @Description: Service层处理抛出异常
 * @Author: JackKuang
 * @Since: 2018年2月7日下午1:50:19  
 */
public class ServiceException extends Exception {

    /** 
     * @Fields: serialVersionUID : TODO
     */
    private static final long serialVersionUID = 8393018130129571698L;

    /** 
     * @Fields: type : 类型
     */
    private String code;

    /** 
     * @Fields: msg : msg消息
     */
    private String msg;

    public ServiceException() {
        super();
    }

    public ServiceException(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
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

}
