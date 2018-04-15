package com.hurenjieee.system.job;

/**
 * @Description: 定时任务计划，写在这个抵挡
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:44:00  
 */
public class QuartzJob {

    public void update(){
        //只能通过Spring上下获取到对象
        //SystemJobService systemJobService = SpringContextUtil.getBean("systemJobService");
        System.out.println("123");
    }

}
