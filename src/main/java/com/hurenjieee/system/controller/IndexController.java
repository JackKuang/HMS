package com.hurenjieee.system.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("indexController")
@Scope("prototype")
@RequestMapping("/system")
public class IndexController {

    @RequestMapping("index")
    public String login(Model model){
        return "system/index";
    }
}
