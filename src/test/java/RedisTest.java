import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hurenjieee.entity.TestEntity;
import com.hurenjieee.util.RedisCacheUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RedisTest {

    @Autowired
    private RedisCacheUtil<TestEntity> redisCache;

    @Test
    public void testRedis(){
        TestEntity testEntity = new TestEntity();
        testEntity.setId(2);
        testEntity.setName("zhang");
        testEntity.setDate(new Date());
        //redisCache.setCacheObject("test",testEntity);
        TestEntity testEntity2 = redisCache.getCacheObject("test");
        testEntity2.getDate();
    }
}
