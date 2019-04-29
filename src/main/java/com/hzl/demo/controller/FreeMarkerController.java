package com.hzl.demo.controller;

import com.hzl.demo.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:
 * @Date: 2018/12/20 23:54
 * @Description:
 *//*
 * @program: springboot
 * @description:zhge
 * @author:
 * @create: 2018-12-20-23-54
 */
@Controller
@RequestMapping("ftl")
public class FreeMarkerController {
    @Autowired
    private Resource resouce;

    @RequestMapping("getCenter")   //url:localhost:8080/ftl/getCenter
    public String getCenter(){

        return "freemarker/centers/center";
    }
    @RequestMapping("/index")       ////url:localhost:8080/ftl/index

    public String index(ModelMap modelMap){
        System.out.println(123);
        modelMap.addAttribute("reresouces",resouce);
        return "freemarker/index";
    }
}
