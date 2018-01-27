package com.hurenjieee.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.ast.Var;

@SuppressWarnings("unchecked")
public class TreeUtil {

    /**
     * @Description: list转Tree
     * @Author: JackKuang
     * @Since: 2018年1月26日下午12:14:42
     * @param maps
     * @param code code
     * @param parCode 父级code
     * @param order 排序字段
     * @return
     */
    public static List<Map<String, Object>> listToTree(List<Map<String, Object>> maps,String code,String parCode,String order){
        Long startTime = System.currentTimeMillis();
        // result 结果集
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        // List转Map临时存储
        Map<String, Object> map1 = new TreeMap<String, Object>();
        // 取出数据存入Map中
        for ( Map<String, Object> m : maps ) {
            if (m.get(code) != null) {
                map1.put((String) m.get(code),m);
            }
        }
        // 把子数据取出放入父级Map的List中
        for ( Map<String, Object> m : maps ) {
            if (StringUtils.isNotBlank((String) m.get(parCode))) {
                Map<String, Object> tempMap = (Map<String, Object>) map1.get((String) m.get(parCode));
                if (tempMap.containsKey("list")) {
                    List<Map<String, Object>> listMap = (List<Map<String, Object>>) tempMap.get("list");
                    listMap.add(m);
                } else {
                    List<Map<String, Object>> listMap = new ArrayList<>();
                    listMap.add(m);
                    tempMap.put("list",listMap);
                }
            }
        }

        // 取出所有父级Map中放入
        for ( String key : map1.keySet() ) {
            Map<String, Object> tempMap = (Map<String, Object>) map1.get(key);
            if (!StringUtils.isNotBlank((String) tempMap.get(parCode))) {
                result.add(tempMap);
            }
        }
        Collections.sort(result,new Comparator<Map<String, Object>>() {

            @Override
            public int compare(Map<String, Object> o1,Map<String, Object> o2){
                try {
                    Map<String, Object> map1 = (Map<String, Object>) o1;
                    Map<String, Object> map2 = (Map<String, Object>) o2;
                    Integer order1 = (Integer) map1.get(order);
                    Integer order2 = (Integer) map2.get(order);
                    return order1 - order2;
                } catch (Exception e) {
                    return 0;
                }
            }
        });
        System.out.println("排序执行了" + (System.currentTimeMillis() - startTime) + "ms;");
        return result;
    }

    /**
     * @Description: 复制对象
     * @Author: JackKuang
     * @Since: 2018年1月26日下午12:36:41
     * @param permissions
     * @param para 结合
     * @return
     */
    public static List<Map<String, Object>> treeToNodes(List<Map<String, Object>> permissions,Map<String, String> para){
        for ( Map.Entry<String, String> entry : para.entrySet() ) {
            for ( Map<String, Object> map : permissions ) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (map.containsKey(key)) {
                    Object object = map.get(key);
                    if(object instanceof List){
                        map.put(value,treeToNodes((List<Map<String, Object>>)object,para));
                    }else{
                        map.put(value,object);
                    }
                }
            }
        }
        return permissions;
    }

}
