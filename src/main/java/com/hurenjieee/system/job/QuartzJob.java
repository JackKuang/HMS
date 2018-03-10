package com.hurenjieee.system.job;

import org.springframework.beans.factory.annotation.Autowired;

import com.hurenjieee.core.util.SpringContextUtil;
import com.hurenjieee.system.entity.SystemJob;
import com.hurenjieee.system.service.SystemJobService;

public class QuartzJob {

    public void update(){
        //只能通过Spring上下获取到对象
        SystemJobService systemJobService = SpringContextUtil.getBean("systemJobService");
        systemJobService.updateTran();
    }
    
    public void testB(){
        System.out.println("测试一下");
    }
    
    class MyThead extends Thread{
        @Override
        public void run(){
            for(int i=0; i <10; i++){ 
                System.out.printf("%s: %d\n", this.getName(), i); 
                // i能被4整除时，休眠100毫秒
            }
        }
        
    }
}
