package com.hurenjieee.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeUtil {

    public static List<Map> listToTree(List<Map> maps,String code,String parCode){
        //result 结果集
        List<Map> result = new ArrayList<Map>();
        //List转Map临时存储
        Map<String,Object> map1 = new TreeMap<String,Object>();
        //取出数据存入Map中
        for(Map m:maps){
            if(m.get(code) != null){
                map1.put((String)m.get(code),m);
            }
        }
        //把子数据取出放入父级Map的List中
        for(Map m:maps){
            if(m.get(parCode) != null){
                Map tempMap = (Map) map1.get((String)m.get(parCode));
                if(tempMap.containsKey("list")){
                    List<Map> listMap = (List<Map>) tempMap.get("list");
                    listMap.add(m);
                }else{
                    List<Map> listMap = new ArrayList<>();
                    listMap.add(m);
                    tempMap.put("list",listMap);
                }
            }
        }
        //取出所有父级Map中放入
        for(String key:map1.keySet()){
            Map tempMap = (Map) map1.get(key);
            if(!tempMap.containsKey(parCode)){
                result.add(tempMap);
            }
        }
        return result;
    }

}
