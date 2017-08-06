import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hurenjieee.entity.TestEntity;
import com.hurenjieee.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MybatisTest {
    @Resource
    TestService testService;
    
    @Test
    public void insert(){
        TestEntity testEntity = new TestEntity();
        for(int i = 0; i<1000;i++){
            System.out.println(i);
            testEntity.setId(i);
            testEntity.setName("zhang"+i);
            testEntity.setDate(new Date());
            testService.insert(testEntity);
        }
    }

    @Test
    public void select(){
        TestEntity testEntity = new TestEntity();
        //testEntity.setPageNum(2);
        //testEntity.setPageSize(100);
        
      
        PageHelper.startPage(2,100);
        List<TestEntity> list = testService.select(testEntity);
        for(TestEntity t:list){
            System.out.println(t.getId());
        }
    }
    
}
