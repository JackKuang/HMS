package com.hurenjieee.system.service;

import java.util.List;
import java.util.Map;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemDictionary;


/**
 * @Description: 数据字典
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:47:55  
 */
public interface SystemDictionaryService extends BaseService<SystemDictionary> {

    /**
     * 获取数据字典（菜单列表）
     * 
     * @Description: 获取数据字典（菜单列表）
     * @Author: JackKuang
     * @Since: 2018年3月16日上午11:16:38
     * @return 返回List
     */
    List<Map<String, Object>> listDictionary();

}
