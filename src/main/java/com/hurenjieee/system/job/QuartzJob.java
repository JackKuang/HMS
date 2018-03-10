package com.hurenjieee.system.job;


import com.hurenjieee.core.util.SpringContextUtil;
import com.hurenjieee.system.service.SystemJobService;

public class QuartzJob {

    public void update(){
        //只能通过Spring上下获取到对象
        SystemJobService systemJobService = SpringContextUtil.getBean("systemJobService");
        
    }

}
