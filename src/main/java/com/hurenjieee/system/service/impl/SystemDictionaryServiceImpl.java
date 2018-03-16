package com.hurenjieee.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.constant.SystemConst;
import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.system.dao.SystemDictionaryDao;
import com.hurenjieee.system.entity.SystemDictionary;
import com.hurenjieee.system.service.SystemDictionaryService;
import com.hurenjieee.util.TreeUtil;

import tk.mybatis.mapper.common.Mapper;

@Service("systemDictionaryService")
public class SystemDictionaryServiceImpl extends BaseServiceImpl<SystemDictionary> implements SystemDictionaryService{

    @Autowired
    SystemDictionaryDao systemDictionaryDao;
    
    @Override
    public Mapper<SystemDictionary> getMapper(){
        return systemDictionaryDao;
    }

    @Override
    public List listDictionary(){
        List<Map<String,Object>> dictionarys;
        dictionarys = systemDictionaryDao.listDictionary();
        dictionarys = TreeUtil.listToTree(dictionarys,"dictionaryUuid","dictionaryParUuid","dictionaryOrder");
        Map<String, String> para = new HashMap<>();
        para.put("dictionaryName","name");
        para.put("list","children");
        para.put("dictionaryUuid","id");
        dictionarys = TreeUtil.treeToNodes(dictionarys,para);
        return dictionarys;
    }

}
