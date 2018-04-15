package com.hurenjieee.system.job;

import org.apache.log4j.Logger;

/**
 * @Description: 定时任务计划，写在这个抵挡
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:44:00  
 */
public class QuartzJob {

    public final Logger logger = Logger.getLogger(QuartzJob.class);
    public void update(){
        //只能通过Spring上下获取到对象
        //SystemJobService systemJobService = SpringContextUtil.getBean("systemJobService");
        logger.debug("This is debug");
        logger.error("This is error");
        logger.warn("This is warn");
        logger.info("This is Info");
        
    }

}
