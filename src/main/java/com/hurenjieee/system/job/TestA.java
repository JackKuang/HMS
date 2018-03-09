package com.hurenjieee.system.job;

import org.junit.Test;

public class TestA {
    @Test
    public void testA(){
        MyThead myThead = new MyThead();
        myThead.start();
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
