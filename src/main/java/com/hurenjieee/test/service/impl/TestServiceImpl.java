package com.hurenjieee.test.service.impl;

import org.springframework.stereotype.Service;

import com.hurenjieee.core.BaseServiceImpl;
import com.hurenjieee.test.dao.TestDao;
import com.hurenjieee.test.entity.TestEntity;
import com.hurenjieee.test.service.TestService;

@Service("testService")
public class TestServiceImpl extends BaseServiceImpl<TestEntity,TestDao> implements TestService{

}
