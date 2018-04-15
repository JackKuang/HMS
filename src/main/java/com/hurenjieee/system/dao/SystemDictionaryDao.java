package com.hurenjieee.system.dao;

import java.util.List;
import java.util.Map;

import com.hurenjieee.system.entity.SystemDictionary;
import tk.mybatis.mapper.common.Mapper;


/**
 * @Description: 数据字典
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:07:43  
 */
public interface SystemDictionaryDao extends Mapper<SystemDictionary> {

    /**
     * 获取List数据字典
     * 
     * @Description: 获取List数据字典
     * @Author: JackKuang
     * @Since: 2018年4月15日下午5:07:37
     * @return
     */
    List<Map<String, Object>> listDictionary();
    
}