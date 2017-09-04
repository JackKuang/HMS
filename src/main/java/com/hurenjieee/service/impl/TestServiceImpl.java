package com.hurenjieee.service.impl;

import org.springframework.stereotype.Service;

import com.hurenjieee.core.BaseServiceImpl;
import com.hurenjieee.dao.TestDao;
import com.hurenjieee.entity.TestEntity;
import com.hurenjieee.service.TestService;

@Service("testService")
public class TestServiceImpl extends BaseServiceImpl<TestEntity,TestDao> implements TestService{

}
