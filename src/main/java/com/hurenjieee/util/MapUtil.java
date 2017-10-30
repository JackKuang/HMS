package com.hurenjieee.util;

import java.util.Map;
import java.util.TreeMap;

public class MapUtil {
    
    /**
     * @Description: Map处理返回结果集
     * @Author: JackKuang
     * @Since: 2017年10月30日下午11:29:34
     * @param result
     * @param message
     * @return
     */
    public static Map<String, Object> getResult(boolean result,String message){
        Map<String, Object> map = new TreeMap<String,Object>();
        map.put("result",result);
        map.put("message",message);
        return map;
    }

}
