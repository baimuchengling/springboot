package com.hzl.demo.controller;

import com.hzl.demo.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:
 * @Date: 2018/12/20 22:23
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-12-20-22-23
 */
@RestController
public class ResourceController {
    @Autowired      //自动加载注解
    private Resource resouce;
    @RequestMapping("/getResource")
    public void getResource(){
        System.out.println("加载配置文件中的内容"+resouce.getName()+resouce.getPlace()+resouce.getUser());
        //return resouce;
    }

}
