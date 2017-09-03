package com.hurenjieee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.dao.TestDao;
import com.hurenjieee.entity.TestEntity;
import com.hurenjieee.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{

    @Resource
    TestDao mapper;

    public TestDao getMapper(){
        return mapper;
    }
    
    public void setMapper(TestDao mapper){
        this.mapper = mapper;
    }

    /****************增加开始**********************/

    /**
     * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:58:48
     * @param t
     * @return
     */
    @Override
    public Integer insertSelective(TestEntity t){
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
    public Integer insert(TestEntity t){
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
    public Integer updateByKeySelective(TestEntity t){
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
    public Integer updateByKey(TestEntity t){
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
    public Integer deleteByKey(Long id){
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
    public Integer delete(TestEntity t){
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
    public TestEntity selectOne(TestEntity t) throws Exception{
        return (TestEntity) getMapper().selectOne(t);
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
    public TestEntity selectByKey(TestEntity t) throws Exception{
        return (TestEntity) getMapper().selectByPrimaryKey(t);
    }

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号 
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:22:21
     * @param t
     * @return
     */
    @Override
    public List<TestEntity> select(TestEntity t){
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
    public Integer selectCount(TestEntity t){
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
    public PageInfo<TestEntity> selectPage(TestEntity t){
        List<TestEntity> list = getMapper().select(t);
        PageInfo<TestEntity> pageInfo = new PageInfo<TestEntity>(list);
        return pageInfo;
    }

    /****************分页查找结束**********************/
}
