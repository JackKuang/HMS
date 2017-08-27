package com.hurenjieee.dao;

import org.springframework.stereotype.Repository;

import com.hurenjieee.entity.TestEntity;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TestDao extends Mapper<TestEntity> {

}
