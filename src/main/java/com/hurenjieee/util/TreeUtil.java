package com.hurenjieee.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeUtil {

    public static List<Map> listToTree(List<Map> maps,String code,String parCode,String order){
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
        Collections.sort(result,new Comparator<Map>() {

            @Override
            public int compare(Map o1,Map o2){
                try {
                    Map map1 = (Map)o1;
                    Map map2 = (Map)o2;
                    Integer order1 = (Integer) map1.get(order);
                    Integer order2 = (Integer) map2.get(order);
                    return order1 - order2;
                } catch (Exception e) {
                    return 0;
                }
            }});
        
        return result;
    }

}
