package com.hurenjieee.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hurenjieee.entity.TestEntity;

import tk.mybatis.mapper.common.Mapper;


@Component
public interface TestDao extends Mapper<TestEntity> {

    int insert(TestEntity testEntity);

    int delete(TestEntity testEntity);

    List<TestEntity> select(TestEntity testEntity);

    int update(TestEntity testEntity);
}
