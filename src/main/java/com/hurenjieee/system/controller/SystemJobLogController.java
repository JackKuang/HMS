package com.hurenjieee.system.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.system.entity.SystemJobLog;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemJobLogService;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.AjaxMessageUtils;
import com.hurenjieee.util.PageResult;
import com.hurenjieee.util.PageUtil;

@Controller("systemJobLogController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemJobLogController {

    @Autowired
    SystemJobLogService systemJobLogService;
    
    // ----------通用接口开始----------
    @RequestMapping("jobLogIndex")
    public String index(Model model,HttpSession session){
        return "system/jobLog/jobLogIndex";
    }

    @RequestMapping(value = "jobLogs",method = RequestMethod.GET)
    @ResponseBody
    public PageResult<SystemUser> list(SystemJobLog systemJobLog,HttpServletRequest request){
        try {
            PageHelper.startPage(request);
            PageInfo<SystemJobLog> pageInfo = systemJobLogService.selectPage(systemJobLog);
            return PageUtil.generatePage(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "jobLogs",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage insert(SystemJobLog systemJobLog){
        try {
            Integer num = systemJobLogService.insertSelective(systemJobLog);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("新增成功");
            } else {
                return AjaxMessageUtils.getFailMsg("新增失败");
            }
        /*} catch (ServiceException se) {
            return AjaxMessageUtils.getFailMsgFromException(se);*/
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "jobLogs/{uuid}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMessage selectOne(@PathVariable String uuid){
        try {
            SystemJobLog systemJobLog = new SystemJobLog();
            systemJobLog.setUuid(uuid);
            systemJobLog = systemJobLogService.selectByKey(systemJobLog);
            if (systemJobLog != null) {
                return new AjaxMessage(true,"SUCCESS",systemJobLog);
            } else {
                return AjaxMessageUtils.getFailMsg("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "jobLogs/{uuid}",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxMessage update(SystemJobLog systemJobLog,@PathVariable String uuid){
        try {
            systemJobLog.setUuid(uuid);
            Integer num = systemJobLogService.updateByKeySelective(systemJobLog);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("修改成功");
            } else {
                return AjaxMessageUtils.getFailMsg("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "jobLogs/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxMessage delete(@PathVariable String uuid){
        try {
            Integer num = systemJobLogService.deleteByKey(uuid);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("删除成功");
            } else {
                return AjaxMessageUtils.getFailMsg("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }
    // ----------通用接口结束----------
}
