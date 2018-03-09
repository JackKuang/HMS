package com.hurenjieee.core.quartz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.hurenjieee.core.util.SpringContextUtil;
import com.hurenjieee.system.entity.SystemJobLog;
import com.hurenjieee.system.service.SystemJobLogService;

public class TaskUtils {

    public final static Logger log = Logger.getLogger(TaskUtils.class);

    static SystemJobLogService systemJobLogService = SpringContextUtil.getBean("systemJobLogService");

    /** 
     * 通过反射调用scheduleJob中定义的方法 
     *  
     * @param scheduleJob 
     */
    public static void invokMethod(ScheduleJob scheduleJob){
        Object object = null;
        Class clazz = null;

        Long startTime;
        Long stopTime;
        SystemJobLog systemJobLog = new SystemJobLog();
        systemJobLog.setLogJobName(scheduleJob.getJobName());
        systemJobLog.setLogJobDescription(scheduleJob.getDescription());
        systemJobLog.setLogStartDate(new Date());
        startTime = System.currentTimeMillis();
        systemJobLog.setLogState("0");
        systemJobLogService.insertSelective(systemJobLog);
        systemJobLog.setLogState("1");
        systemJobLog.setLogResult("失败");

        // springId不为空先按springId查找bean
        if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
            object = SpringContextUtil.getBean(scheduleJob.getSpringId());
        } else if (StringUtils.isNotBlank(scheduleJob.getBeanClass())) {
            try {
                clazz = Class.forName(scheduleJob.getBeanClass());
                object = clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                systemJobLog.setLogMessage("请检查Beanclass是否配置正确。" + e.toString());
                stopTime = System.currentTimeMillis();
                systemJobLog.setLogTime(stopTime - startTime);
                systemJobLog.setLogEndDate(new Date());
                systemJobLogService.updateByKeySelective(systemJobLog);
                return;
            }
        }
        if (object == null) {
            systemJobLog.setLogMessage("请检查是否配置正确。" );
            stopTime = System.currentTimeMillis();
            systemJobLog.setLogTime(stopTime - startTime);
            systemJobLog.setLogEndDate(new Date());
            systemJobLogService.updateByKeySelective(systemJobLog);
            return;
        }
        clazz = object.getClass();
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
        } catch (NoSuchMethodException e) {
            systemJobLog.setLogMessage("请检查是否有这个方法。" + e.toString());
            stopTime = System.currentTimeMillis();
            systemJobLog.setLogTime(stopTime - startTime);
            systemJobLog.setLogEndDate(new Date());
            systemJobLogService.updateByKeySelective(systemJobLog);
            return;
        } catch (SecurityException e) {
            systemJobLog.setLogMessage("请检查是否有安全异常。" + e.toString());
            stopTime = System.currentTimeMillis();
            systemJobLog.setLogTime(stopTime - startTime);
            systemJobLog.setLogEndDate(new Date());
            systemJobLogService.updateByKeySelective(systemJobLog);
            return;
        }
        if (method != null) {
            try {
                method.invoke(object);
            } catch (IllegalAccessException e) {
                systemJobLog.setLogMessage("请检查是否有安全权限异常。" + e.toString());
                stopTime = System.currentTimeMillis();
                systemJobLog.setLogTime(stopTime - startTime);
                systemJobLog.setLogEndDate(new Date());
                systemJobLogService.updateByKeySelective(systemJobLog);
                return;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                systemJobLog.setLogMessage("请检查是否有非法数据异常。" + e.toString());
                stopTime = System.currentTimeMillis();
                systemJobLog.setLogTime(stopTime - startTime);
                systemJobLog.setLogEndDate(new Date());
                systemJobLogService.updateByKeySelective(systemJobLog);
                return;
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                systemJobLog.setLogMessage("请检查是否有调用方法或构造方法抛出异常。" + e.toString());
                stopTime = System.currentTimeMillis();
                systemJobLog.setLogTime(stopTime - startTime);
                systemJobLog.setLogEndDate(new Date());
                systemJobLogService.updateByKeySelective(systemJobLog);
                return;
            }
            systemJobLog.setLogMessage("运行成功！");
            stopTime = System.currentTimeMillis();
            systemJobLog.setLogTime(stopTime - startTime);
            systemJobLog.setLogEndDate(new Date());
            systemJobLog.setLogResult("成功");
            systemJobLogService.updateByKeySelective(systemJobLog);
            return;
        }
    }
}
