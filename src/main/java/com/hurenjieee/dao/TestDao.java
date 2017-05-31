package com.hurenjieee.dao;

import java.util.List;

import com.hurenjieee.entity.TestEntity;

public interface TestDao {
    int insert(TestEntity testEntity);
    int delete(TestEntity testEntity);
    List<TestEntity> select(TestEntity testEntity);
    int update(TestEntity testEntity);
}
