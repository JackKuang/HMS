package com.hurenjieee.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
import com.hurenjieee.system.entity.SystemJob;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemJobService;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.AjaxMessageUtils;
import com.hurenjieee.util.PageResult;
import com.hurenjieee.util.PageUtil;

@Controller("systemJobController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemJobController {

    @Autowired
    SystemJobService systemJobService;

    // ----------特殊接口开始----------
    /**
     * @Description: 启用任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:05:53
     * @param systemJob
     * @return
     */
    @RequestMapping(value = "startJob",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage startJob(SystemJob systemJob){
        try {
            Integer num = systemJobService.startJob(systemJob);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("启用成功");
            } else {
                return AjaxMessageUtils.getFailMsg("启用失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }
    
    /**
     * @Description: 禁用任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:05:41
     * @param systemJob
     * @return
     */
    @RequestMapping(value = "stopJob",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage stopJob(SystemJob systemJob){
        try {
            Integer num = systemJobService.stopJob(systemJob);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("禁用成功");
            } else {
                return AjaxMessageUtils.getFailMsg("禁用失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    /**
     * @Description: 立即启动一次任务调度
     * @Author: JackKuang
     * @Since: 2018年3月9日下午3:05:53
     * @param systemJob
     * @return
     */
    @RequestMapping(value = "startJobOnce",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage startJobNow(SystemJob systemJob){
        try {
            systemJobService.startJobOnce(systemJob);
            return AjaxMessageUtils.getSuccessMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }
    
    
    
    // ----------特殊接口结束----------
    
    // ----------通用接口开始----------
    @RequestMapping("jobIndex")
    public String index(Model model,HttpSession session){
        return "system/job/jobIndex";
    }

    @RequestMapping(value = "jobs",method = RequestMethod.GET)
    @ResponseBody
    public PageResult<SystemUser> list(SystemJob systemJob,HttpServletRequest request){
        try {
            PageHelper.startPage(request);
            PageInfo<SystemJob> pageInfo = systemJobService.selectPage(systemJob);
            return PageUtil.generatePage(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "jobs",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage insert(SystemJob systemJob){
        try {
            if(!StringUtils.isNotBlank(systemJob.getJobConcurrent())){
                systemJob.setJobConcurrent("0");
            }
            Integer num = systemJobService.insertSelective(systemJob);
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

    @RequestMapping(value = "jobs/{uuid}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMessage selectOne(@PathVariable String uuid){
        try {
            SystemJob systemJob = new SystemJob();
            systemJob.setUuid(uuid);
            systemJob = systemJobService.selectByKey(systemJob);
            if (systemJob != null) {
                return new AjaxMessage(true,"SUCCESS",systemJob);
            } else {
                return AjaxMessageUtils.getFailMsg("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "jobs/{uuid}",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxMessage update(SystemJob systemJob,@PathVariable String uuid){
        try {
            systemJob.setUuid(uuid);
            if(!StringUtils.isNotBlank(systemJob.getJobConcurrent())){
                systemJob.setJobConcurrent("0");
            }
            Integer num = systemJobService.updateByKeySelective(systemJob);
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

    @RequestMapping(value = "jobs/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxMessage delete(@PathVariable String uuid){
        try {
            Integer num = systemJobService.deleteByKey(uuid);
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
