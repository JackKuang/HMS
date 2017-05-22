package com.hurenjieee.dao;

import com.hurenjieee.entity.TestEntity;

public interface TestDao {
    int insert(TestEntity testEntity);
    int delete(TestEntity testEntity);
    int select(TestEntity testEntity);
    int update(TestEntity testEntity);
}
