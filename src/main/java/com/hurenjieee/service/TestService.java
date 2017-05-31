package com.hurenjieee.service;

import java.util.List;

import com.hurenjieee.entity.TestEntity;

public interface TestService {
    public Integer insert(TestEntity testEntity);
    public List<TestEntity> select(TestEntity testEntity);
}
