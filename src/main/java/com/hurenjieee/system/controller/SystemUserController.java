package com.hurenjieee.system.controller;

import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hurenjieee.core.exception.ServiceException;
import com.hurenjieee.system.entity.SystemUser;
import com.hurenjieee.system.service.SystemUserService;
import com.hurenjieee.system.util.AuthorizationUtil;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.AjaxMessageUtils;
import com.hurenjieee.util.PageResult;
import com.hurenjieee.util.PageUtil;
import com.hurenjieee.util.RSAUtil;

@Controller("systemUserController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;
    // ----------特殊接口开始----------
    
    /**
     * @Description: 个人信息页面
     * @Author: JackKuang
     * @Since: 2018年3月4日下午3:25:18
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("userInfo")
    public String userInfo(Model model,HttpSession session){
        return "system/user/userInfo";
    }
    
    
    /**
     * @Description: 更新用户名密码页面
     * @Author: JackKuang
     * @Since: 2018年3月4日下午3:25:39
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("updatePwd")
    public ModelAndView updatePwd(Model model,HttpSession session){
        ModelAndView mv = new ModelAndView("system/user/updatePwd");
        // 配置RSA公钥密钥
        String publicKey = setKeyAttribute(session);
        mv.addObject("publicKey",publicKey);
        return mv;
    }

    @RequestMapping(value = "updatePwd",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage update(String oldPwd,String newPwd,HttpSession session){
        try {
           /* String userUuid = AuthorizationUtil.getLoginUserUuid();
            String privateKey = (String) session.getAttribute("privateKey");
            newPwd = RSAUtil.decrypt(privateKey,newPwd);
            oldPwd = RSAUtil.decrypt(privateKey,oldPwd);
            systemUserService.updatePwd(userUuid,oldPwd,newPwd);
            return AjaxMessageUtils.getSuccessMsg("修改成功");
        } catch (ServiceException se) {
            se.printStackTrace();
            String publicKey = setKeyAttribute(session);
            AjaxMessage result = AjaxMessageUtils.getFailMsgFromException(se);
            result.setObj(publicKey);
            return AjaxMessageUtils.getFailMsgFromException(se);*/
            return null;
        } catch (Exception e) {
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    /**
     * @Description: 把RSA公钥密钥放入session中，返回公钥publicKey
     * @Author: JackKuang
     * @Since: 2017年10月12日上午10:54:01
     * @param session
     * @return publicKey
     */
    private String setKeyAttribute(HttpSession session){
        Map<String, String> data = RSAUtil.generateKeyPair();
        String privateKey = data.get("privateKey");
        String publicKey = data.get("publicKey");
        session.setAttribute("privateKey",privateKey);
        session.setAttribute("publicKey",publicKey);
        return publicKey;
    }

    
    // ----------特殊接口结束----------
    
    // ----------通用接口开始----------
    @RequestMapping("userIndex")
    public String index(Model model,HttpSession session){
        return "system/user/userIndex";
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