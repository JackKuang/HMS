package com.hurenjieee.util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTool {

    /**
     * @Description: TODO
     * @Author: JackKuang
     * @Since: 2017年10月21日下午5:22:09
     * @param response
     * @param name cookie Name
     * @param value cookie Value
     * @param maxAge cookie 时间（以秒为单位）
     * 
     */
    public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * @Description: 根据name获取Cookie
     * @Author: JackKuang
     * @Since: 2017年10月21日下午5:23:25
     * @param request
     * @param name cookie Name
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * @Description: 将cookie封装到Map里面（非接口方法） 
     * @Author: JackKuang
     * @Since: 2017年10月21日下午5:24:29
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for ( Cookie cookie : cookies ) {
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }

    /**
     * @Description: 根据name获取value
     * @Author: JackKuang
     * @Since: 2017年10月21日下午5:23:25
     * @param request
     * @param name cookie Name
     * @return
     */
    public static String getValueByName(HttpServletRequest request,String name){
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie.getValue();
        } else {
            return null;
        }
    }

}