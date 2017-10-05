import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;
import com.hurenjieee.test.entity.TestEntity;
import com.hurenjieee.test.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MybatisTest {
   
    @Resource
    TestService testService;
    
    @Autowired
    SystemUserService systemUserService;
    
    @Test
    public void insert(){
        for(int i = 1000; i<2000;i++){
            TestEntity testEntity = new TestEntity();
            System.out.println(i);
            testEntity.setName("zhang"+i);
            testService.insertSelective(testEntity);
        }
    }

    @Test
    public void select(){
        TestEntity testEntity = new TestEntity();
        testEntity.setName("zhang1998");
        List<TestEntity> list = testService.select(testEntity);
        for(TestEntity t:list){
            System.out.println(t.getName());
        }
        try {
            System.out.println(testService.selectOne(testEntity).getName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testUuid(){
        System.out.println(UUID.randomUUID().toString().replace("-","").toUpperCase());
    }
    
    @Test
    public void update(){
        TestEntity testEntity = new TestEntity();
        testEntity.setName("li");
        testEntity.setUuid("A387CF5D5B88450081643712CE4C510D");
        testService.updateByKeySelective(testEntity);
    }
    
    
    @Test
    public void selectOne(){
        SystemUser systemUser = new SystemUser();
        systemUser.setUserId("admin");
        systemUser.setUserPassword("8ae4481e237793ddba7140c20be86e679826afce7412888c48198bb7a9a1a5857f2bca66830262e200467081f64db20080e3695987e6f5c29a88e6b445332e85");
        SystemUser systemUser2;
        
        try {
            systemUser2 = systemUserService.selectOne(systemUser);
            System.out.println(systemUser2.getUserName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    
    @Test
    public void selectByUsername(){
        SystemUser systemUser = systemUserService.selectByUserId("admin");
        System.out.println(systemUser.getUserPassword());
    }
}
