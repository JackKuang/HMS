package com.hurenjieee.core.service;

import java.util.List;

import javax.persistence.Entity;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.entity.BaseEntity;

/**
 * @Description: 通用Service接口
 * @Author: JackKuang
 * @Since: 2017年8月18日上午11:23:14 
 * @param <Entity> 
 */
public interface BaseService<T extends BaseEntity> {

    /****************增加开始**********************/

    /**
     * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:58:48
     * @param entity
     * @return
     */
    public Integer insertSelective(T t);

    /**
     * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:36:27
     * @param baseEntity
     * @return
     */
    public Integer insert(T t);

    /****************增加开始**********************/

    /****************更新开始**********************/

    /**
     * @Description: 根据主键更新属性不为null的值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:17
     * @param entity
     * @return
     */
    public Integer updateByKeySelective(T t);

    /**
     * @Description: 根据主键更新实体全部字段，null值会被更新
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:45
     * @param entity
     * @return
     */
    public Integer updateByKey(T t);

    /****************更新结束**********************/

    /****************删除开始**********************/

    /**
     * @Description: 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:10:56
     * @param id
     * @return
     */
    public Integer deleteByKey(String id);

    /**
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:17:18
     * @param entity
     * @return
     */
    public Integer delete(T t);

    /****************删除结束**********************/

    /****************查找结束**********************/

    /**
     * @Description: 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:23:28
     * @param entity
     * @return
     */
    public T selectOne(T t) throws Exception;

    /**
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:24:16
     * @param entity
     * @return
     * @throws Exception
     */
    public T selectByKey(T t) throws Exception;

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号 
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:22:21
     * @param entity
     * @return
     */
    public List<T> select(T t);

    /**
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     * @Author: JackKuang 
     * @Since: 2017年8月17日下午11:57:12
     * @param entity
     * @return
     */
    public Integer selectCount(T t);

    /****************查找结束**********************/

    /****************分页查找结束**********************/

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号——》分页
     * @Author: JackKuang
     * @Since: 2017年8月18日上午9:54:35
     * @param entity
     * @return
     */
    public PageInfo<T> selectPage(T t);

    /****************分页查找结束**********************/
}
