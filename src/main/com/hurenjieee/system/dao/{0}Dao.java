package com.hurenjieee.system.dao;

import com.hurenjieee.system.entity.TestEntity;
import com.hurenjieee.system.entity.TestEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface {0}Dao extends Mapper<TestEntity> {
    long countByExample(TestEntityExample example);

    int deleteByExample(TestEntityExample example);

    List<TestEntity> selectByExample(TestEntityExample example);

    int updateByExampleSelective(@Param("record") TestEntity record, @Param("example") TestEntityExample example);

    int updateByExample(@Param("record") TestEntity record, @Param("example") TestEntityExample example);
}