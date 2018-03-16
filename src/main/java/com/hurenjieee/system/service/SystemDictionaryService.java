package com.hurenjieee.system.service;

import java.util.List;

import com.hurenjieee.core.service.BaseService;
import com.hurenjieee.system.entity.SystemDictionary;

public interface SystemDictionaryService extends BaseService<SystemDictionary> {

    /**
     * @Description: 获取数据字典（菜单列表）
     * @Author: JackKuang
     * @Since: 2018年3月16日上午11:16:38
     * @return
     */
    List listDictionary();

}
