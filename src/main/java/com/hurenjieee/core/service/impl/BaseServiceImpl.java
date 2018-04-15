package com.hurenjieee.core.service.impl;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.entity.BaseEntity;
import com.hurenjieee.core.service.BaseService;

/**
 * @Description: 通用Service实现类
 * @Author: JackKuang
 * @Since: 2017年8月18日上午11:23:46 
 * @param <T>
 * @param <M> 
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    /**
     * 配置默认Dao层，主要用于Service默认方法调用
     * @Description:配置默认Dao层，主要用于Service默认方法调用
     * @Author: JackKuang
     * @Since: 2018年4月15日下午4:11:28
     * @return
     */
    public abstract Mapper<T> getMapper();

    /****************增加开始**********************/

    /**
     * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:58:48
     * @param t
     * @return
     */
    @Override
    public Integer insertSelective(T t){
        return getMapper().insertSelective(t);
    }

    /**
     * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:36:27
     * @param baseT
     * @return
     */
    @Override
    public Integer insert(T t){
        return getMapper().insert(t);
    }

    /****************增加开始**********************/

    /****************更新开始**********************/

    /**
     * @Description: 根据主键更新属性不为null的值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:17
     * @param t
     * @return
     */
    @Override
    public Integer updateByKeySelective(T t){
        return getMapper().updateByPrimaryKeySelective(t);
    }

    /**
     * @Description: 根据主键更新实体全部字段，null值会被更新
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:45
     * @param t
     * @return
     */
    @Override
    public Integer updateByKey(T t){
        return getMapper().updateByPrimaryKey(t);
    }

    /****************更新结束**********************/

    /****************删除开始**********************/

    /**
     * @Description: 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:10:56
     * @param id
     * @return
     */
    @Override
    public Integer deleteByKey(String id){
        return getMapper().deleteByPrimaryKey(id);
    }

    /**
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:17:18
     * @param t
     * @return
     */
    @Override
    public Integer delete(T t){
        return getMapper().delete(t);
    }

    /****************删除结束**********************/

    /****************查找结束**********************/

    /**
     * @Description: 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:23:28
     * @param t
     * @return
     */
    @Override
    public T selectOne(T t) throws Exception{
        return (T) getMapper().selectOne(t);
    }

    /**
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:24:16
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public T selectByKey(T t) throws Exception{
        return (T) getMapper().selectByPrimaryKey(t);
    }

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号 
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:22:21
     * @param t
     * @return
     */
    @Override
    public List<T> select(T t){
        return getMapper().select(t);
    }

    /**
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     * @Author: JackKuang 
     * @Since: 2017年8月17日下午11:57:12
     * @param t
     * @return
     */
    @Override
    public Integer selectCount(T t){
        return getMapper().selectCount(t);
    }

    /****************查找结束**********************/

    /****************分页查找结束**********************/

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号——》分页
     * @Author: JackKuang
     * @Since: 2017年8月18日上午9:54:35
     * @param t
     * @return
     */
    @Override
    public PageInfo<T> selectPage(T t){
        List<T> list = getMapper().select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }

    /****************分页查找结束**********************/
}
