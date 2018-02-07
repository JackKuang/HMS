package com.hurenjieee.system.controller;

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
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.AjaxMessageUtils;
import com.hurenjieee.util.PageResult;
import com.hurenjieee.util.PageUtil;

@Controller("systemUserController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    // ----------通用接口开始----------
    @RequestMapping("userIndex")
    public String index(Model model,HttpSession session){
        return "system/user/index";
    }

    @RequestMapping(value = "users",method = RequestMethod.GET)
    @ResponseBody
    public PageResult<SystemUser> list(SystemUser systemUser,HttpServletRequest request){
        try {
            PageHelper.startPage(request);
            PageInfo<SystemUser> pageInfo = systemUserService.selectPage(systemUser);
            return PageUtil.generatePage(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "users",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage insert(SystemUser systemUser){
        try {
            Integer num = systemUserService.insertUser(systemUser);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("新增成功");
            } else {
                return AjaxMessageUtils.getFailMsg("新增失败");
            }
        } catch (ServiceException se) {
            return AjaxMessageUtils.getFailMsgFromException(se);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "users/{uuid}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMessage selectOne(@PathVariable String uuid){
        try {
            SystemUser systemUser = new SystemUser();
            systemUser.setUuid(uuid);
            systemUser = systemUserService.selectByKey(systemUser);
            if (systemUser != null) {
                return new AjaxMessage(true,"SUCCESS",systemUser);
            } else {
                return AjaxMessageUtils.getFailMsg("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "users/{uuid}",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxMessage update(SystemUser systemUser,@PathVariable String uuid){
        try {
            systemUser.setUuid(uuid);
            Integer num = systemUserService.updateByKeySelective(systemUser);
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

    @RequestMapping(value = "users/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxMessage delete(@PathVariable String uuid){
        try {
            Integer num = systemUserService.deleteByKey(uuid);
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