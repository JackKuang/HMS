package com.hurenjieee.core.interceptor;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.DateUtils;

import net.sf.json.JSONObject;

/**
 * @Description: 一个用户 相同url 同时提交 相同数据 验证 
 * 主要通过 session中保存到的url 和 请求参数。如果和上次相同，则是重复提交表单 
 * @Author: JackKuang
 * @Since: 2018年1月18日下午4:26:52  
 */
public class SameUrlDataInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
        //非GET请求判断是否存在重复表单提交。
        if (!"GET".equalsIgnoreCase(request.getMethod()) && repeatDataValidator(request)){// 如果重复相同数据
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSONObject.fromObject(new AjaxMessage(false,"RESUBMIT","重复提交")).toString());
            return false;
        }
        else{
            return true;
        }
    }
    
    /** 
     * 验证同一个url数据是否相同提交  ,相同返回true 
     * @param httpServletRequest 
     * @return 
     * @throws JsonProcessingException 
     */
    public boolean repeatDataValidator(HttpServletRequest httpServletRequest) throws JsonProcessingException{
        String params = JSONObject.fromObject(httpServletRequest.getParameterMap()).toString();
        String url = httpServletRequest.getRequestURI();
        Map<String, String> map = new HashMap<String, String>();
        map.put(url,params);
        String nowUrlParams = map.toString();//

        Object preUrlParams = httpServletRequest.getSession().getAttribute("repeatData");
        Date date = (Date)httpServletRequest.getSession().getAttribute("repeatTime");
        if (preUrlParams == null)// 如果上一个数据为null,表示还没有访问页面
        {
            httpServletRequest.getSession().setAttribute("repeatData",nowUrlParams);
            httpServletRequest.getSession().setAttribute("repeatTime",new Date());
            return false;
        } else// 否则，已经访问过页面
        {
            //所有请求必须在3s内完成
            //3秒内无法重复提交
            if (preUrlParams.toString().equals(nowUrlParams) && DateUtils.intevalBetweenDate(new Date(),date,Calendar.SECOND) < 3){
                return true;
            } else {
                // 如果上次 url+数据 和本次url加数据不同，则不是重复提交
                httpServletRequest.getSession().setAttribute("repeatData",nowUrlParams);
                httpServletRequest.getSession().setAttribute("repeatTime",new Date());
                return false;
            }

        }
    }

}