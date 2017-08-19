package com.hurenjieee.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.dao.TestDao;
import com.hurenjieee.entity.TestEntity;

@Service("testService")
public class TestService {

    @Resource
   TestDao mapper;
    
    public TestDao getMapper(){
        return mapper;
    }

    /****************增加开始**********************/

    /**
     * @Description: 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:58:48
     * @param TestEntity
     * @return
     */
    public Integer insertSelective(TestEntity TestEntity){
        return getMapper().insertSelective(TestEntity);
    }

    /**
     * @Description: 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午10:36:27
     * @param baseTestEntity
     * @return
     */
    public Integer insert(TestEntity TestEntity){
        return getMapper().insert(TestEntity);
    }

    /****************增加开始**********************/

    /****************更新开始**********************/

    /**
     * @Description: 根据主键更新属性不为null的值
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:17
     * @param TestEntity
     * @return
     */
    public Integer updateByKeySelective(TestEntity TestEntity){
        return getMapper().updateByPrimaryKeySelective(TestEntity);
    }

    /**
     * @Description: 根据主键更新实体全部字段，null值会被更新
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:08:45
     * @param TestEntity
     * @return
     */
    public Integer updateByKey(TestEntity TestEntity){
        return getMapper().updateByPrimaryKey(TestEntity);
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
     * @param TestEntity
     * @return
     */
    public Integer delete(TestEntity TestEntity){
        return getMapper().delete(TestEntity);
    }

    /****************删除结束**********************/

    /****************查找结束**********************/

    /**
     * @Description: 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:23:28
     * @param TestEntity
     * @return
     */
    public TestEntity selectOne(TestEntity TestEntity) throws Exception{
        return (TestEntity) getMapper().selectOne(TestEntity);
    }

    /**
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:24:16
     * @param TestEntity
     * @return
     * @throws Exception
     */
    public TestEntity selectByKey(TestEntity TestEntity) throws Exception{
        return (TestEntity) getMapper().selectByPrimaryKey(TestEntity);
    }

    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:22:21
     * @param TestEntity
     * @return
     */
    public List<TestEntity> select(TestEntity TestEntity){
        return getMapper().select(TestEntity);
    }

    /**
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     * @Author: JackKuang
     * @Since: 2017年8月17日下午11:57:12
     * @param TestEntity
     * @return
     */
    public Integer selectCount(TestEntity TestEntity){
        return getMapper().selectCount(TestEntity);
    }

    /****************查找结束**********************/

    /****************分页查找结束**********************/

    public PageInfo<TestEntity> selectPage(TestEntity TestEntity){
        List<TestEntity> list = getMapper().select(TestEntity);
        PageInfo<TestEntity> pageInfo = new PageInfo<TestEntity>(list);
        return pageInfo;
    }

    /****************分页查找结束**********************/
}
