package com.hurenjieee.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hurenjieee.entity.TestEntity;

import tk.mybatis.mapper.common.Mapper;

@SuppressWarnings("unchecked")
public class BaseService<BaseEntity, M extends Mapper> {

    @Autowired
    M mapper;
    
    public M getMapper(){
        return mapper;
    }

    public Integer insert(BaseEntity baseEntity) {
       return getMapper().insert(baseEntity);
    }
    
    public Integer updateByPrimaryKey(BaseEntity baseEntity) {
       return getMapper().updateByPrimaryKey(baseEntity);
    }

    public List<BaseEntity> select(BaseEntity baseEntity){
        return getMapper().select(baseEntity);
    }
}
