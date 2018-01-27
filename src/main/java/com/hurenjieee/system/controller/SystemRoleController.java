package com.hurenjieee.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hurenjieee.system.entity.SystemRole;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemRoleService;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.AjaxMessageUtils;
import com.hurenjieee.util.PageResult;
import com.hurenjieee.util.PageUtil;

@Controller("systemRoleController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemRoleController {

    @Autowired
    SystemRoleService systemRoleService;

    @RequestMapping("roleIndex")
    public String index(Model model,HttpSession session){
        return "system/role/index";
    }

    @RequestMapping(value = "roles",method = RequestMethod.GET)
    @ResponseBody
    public PageResult<SystemRole> list(SystemRole systemRole){
        try {
            PageInfo<SystemRole> pageInfo = systemRoleService.selectPage(systemRole);
            return PageUtil.generatePage(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "roles",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage save(SystemRole systemRole){
        try {
            Integer num = systemRoleService.insertSelective(systemRole);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("新增成功");
            } else {
                return AjaxMessageUtils.getFailMsg("新增失败");
            }
        } catch (Exception e) {
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "roles/{uuid}",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage update(SystemRole systemRole,@PathVariable String uuid){
        try {
            systemRole.setUuid(uuid);
            Integer num = systemRoleService.updateByKeySelective(systemRole);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("修改成功");
            } else {
                return AjaxMessageUtils.getFailMsg("修改失败");
            }
        } catch (Exception e) {
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "roles/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxMessage delete(@PathVariable String uuid){
        try {
            Integer num = systemRoleService.deleteByKey(uuid);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("修改成功");
            } else {
                return AjaxMessageUtils.getFailMsg("修改失败");
            }
        } catch (Exception e) {
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

}