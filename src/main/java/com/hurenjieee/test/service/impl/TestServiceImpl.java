package com.hurenjieee.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurenjieee.core.service.impl.BaseServiceImpl;
import com.hurenjieee.test.dao.TestDao;
import com.hurenjieee.test.entity.TestEntity;
import com.hurenjieee.test.service.TestService;

import tk.mybatis.mapper.common.Mapper;

@Service("testService")
public class TestServiceImpl extends BaseServiceImpl<TestEntity> implements TestService{

    @Autowired
    TestDao testdao;
    
    @Override
    public Mapper<TestEntity> getMapper(){
        // TODO Auto-generated method stub
        return testdao;
    }
    
}
