package com.hurenjieee.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hurenjieee.entity.TestEntity;
import com.hurenjieee.service.TestService;

@Controller("testController")
@Scope("prototype")
@RequestMapping("test")
public class TestController {

    @Resource
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
        TestEntity testEntity = new TestEntity();
        PageHelper.startPage(2,100);
        PageInfo<TestEntity> page = testService.selectPage(testEntity);
        return "/index.jsp";
     }
}