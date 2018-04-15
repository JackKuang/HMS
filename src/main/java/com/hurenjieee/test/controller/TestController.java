package com.hurenjieee.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hurenjieee.test.entity.TestEntity;
import com.hurenjieee.test.service.TestService;


/**
 * @Description: 测试Controller
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:06:45  
 */
@Controller("testController")
@Scope("prototype")
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("index2.action")
    @ResponseBody
    public PageInfo<TestEntity> getlistChinese(Model model){
        TestEntity testEntity = new TestEntity();
        PageHelper.startPage(2,100);
        PageInfo<TestEntity> page = testService.selectPage(testEntity);
        return page;
    }

    @RequestMapping("index.action")
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "index";
    }
}