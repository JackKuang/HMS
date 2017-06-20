package com.hurenjieee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hurenjieee.dao.TestDao;
import com.hurenjieee.entity.TestEntity;
import com.hurenjieee.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Resource
    TestDao testDao;
    
    public Integer insert(TestEntity testEntity){
        return testDao.insertSelective(testEntity);
    }

    @Override
    public List<TestEntity> select(TestEntity testEntity){
        // TODO Auto-generated method stub
        return testDao.select(testEntity);
    }
}
