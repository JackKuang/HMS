package com.hurenjieee.system.controller;

import java.util.List;
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

import com.hurenjieee.system.entity.SystemDictionary;
import com.hurenjieee.system.service.SystemDictionaryService;
import com.hurenjieee.util.AjaxMessage;
import com.hurenjieee.util.AjaxMessageUtils;

/**
 * @Description: 数据字典Controller
 * @Author: JackKuang
 * @Since: 2018年4月15日下午4:19:12  
 */
@Controller("systemDictionaryController")
@Scope("prototype")
@RequestMapping("/system")
public class SystemDictionaryController {

    @Autowired
    SystemDictionaryService systemDictionaryService;

    // ----------通用接口开始----------

    @RequestMapping("dictionaryIndex")
    public String index(Model model,HttpSession session){
        return "system/dictionary/dictionaryIndex";
    }

    @RequestMapping(value = "dictionarys",method = RequestMethod.GET)
    @ResponseBody

    public List<Map<String, Object>> list(HttpServletRequest request){
        try {
            List<Map<String, Object>> list = systemDictionaryService.listDictionary();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "dictionarys",method = RequestMethod.POST)
    @ResponseBody
    public AjaxMessage insert(SystemDictionary systemDictionary){
        try {
            if (systemDictionary.getDictionaryState() == null) {
                systemDictionary.setDictionaryState(0);
            }
            Integer num = systemDictionaryService.insertSelective(systemDictionary);
            if (num == 1) {
                return AjaxMessageUtils.getSuccessMsg("新增成功");
            } else {
                return AjaxMessageUtils.getFailMsg("新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "dictionarys/{uuid}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxMessage selectOne(@PathVariable String uuid){
        try {
            SystemDictionary systemDictionary = new SystemDictionary();
            systemDictionary.setUuid(uuid);
            systemDictionary = systemDictionaryService.selectByKey(systemDictionary);
            if (systemDictionary != null) {
                return new AjaxMessage(true,"SUCCESS",systemDictionary);
            } else {
                return AjaxMessageUtils.getFailMsg("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false,"WRONG","系统错误");
        }
    }

    @RequestMapping(value = "dictionarys/{uuid}",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxMessage update(SystemDictionary systemDictionary,@PathVariable String uuid){
        try {
            if (systemDictionary.getDictionaryState() == null) {
                systemDictionary.setDictionaryState(0);
            }
            systemDictionary.setUuid(uuid);
            Integer num = systemDictionaryService.updateByKeySelective(systemDictionary);
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

    @RequestMapping(value = "dictionarys/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxMessage delete(@PathVariable String uuid){
        try {
            Integer num = systemDictionaryService.deleteByKey(uuid);
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
