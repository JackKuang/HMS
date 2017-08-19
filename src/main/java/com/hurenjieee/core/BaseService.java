package com.hurenjieee.core;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.entity.TestEntity;

import tk.mybatis.mapper.common.Mapper;

@Service
public class BaseService<Entity, M extends Mapper> {

    @Resource
    M mapper;
    
    public M getMapper(){
        return mapper;
    }

    /****************增加开始**********************/

    /**
     * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:58:48
     * @param entity
     * @return
     */
    public Integer insertSelective(Entity entity){
        return getMapper().insertSelective(entity);
    }

    /**
     * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:36:27
     * @param baseEntity
     * @return
     */
    public Integer insert(Entity entity){
        return getMapper().insert(entity);
    }

    /****************增加开始**********************/

    /****************更新开始**********************/

    /**
     * @Description: 根据主键更新属性不为null的值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:17
     * @param entity
     * @return
     */
    public Integer updateByKeySelective(Entity entity){
        return getMapper().updateByPrimaryKeySelective(entity);
    }

    /**
     * @Description: 根据主键更新实体全部字段，null值会被更新
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:45
     * @param entity
     * @return
     */
    public Integer updateByKey(Entity entity){
        return getMapper().updateByPrimaryKey(entity);
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
    public Integer deleteByKey(Long id){
        return getMapper().deleteByPrimaryKey(id);
    }

    /**
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:17:18
     * @param entity
     * @return
     */
    public Integer delete(Entity entity){
        return getMapper().delete(entity);
    }

    /****************删除结束**********************/

    /****************查找结束**********************/

    /**
     * @Description: 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:23:28
     * @param entity
     * @return
     */
    public Entity selectOne(Entity entity) throws Exception{
        return (Entity) getMapper().selectOne(entity);
    }

    /**
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:24:16
     * @param entity
     * @return
     * @throws Exception
     */
    public Entity selectByKey(Entity entity) throws Exception{
        return (Entity) getMapper().selectByPrimaryKey(entity);
    }

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:22:21
     * @param entity
     * @return
     */
    public List<Entity> select(Entity entity){
        return getMapper().select(entity);
    }

    /**
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:57:12
     * @param entity
     * @return
     */
    public Integer selectCount(Entity entity){
        return getMapper().selectCount(entity);
    }

    /****************查找结束**********************/

    /****************分页查找结束**********************/

    public PageInfo<Entity> selectPage(Entity entity){
        List<Entity> list = getMapper().select(entity);
        PageInfo<Entity> pageInfo = new PageInfo<Entity>(list);
        return pageInfo;
    }

    /****************分页查找结束**********************/
}
