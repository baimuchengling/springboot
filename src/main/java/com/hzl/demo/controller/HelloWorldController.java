package com.hzl.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Auther:
 * @Date: 2018/11/29 20:47
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-11-29-20-47
 */
@RestController
public class HelloWorldController {
    //没有请求参数
    @RequestMapping(path={"/say"})
    public String say(){
        System.out.println("springboot搭建成功！");
        return "hello spring boot";
    }
    /*//有请求参数，形式：
    url传参，访问的路径类似这样：localhost:8080/getParamDemo1/1
            * 方法体中的参数要在前面加注释，@PathVariable，代表url中的参数*/
    @RequestMapping(path={"/SayGood/{id}"})
    public String sayGood(@PathVariable("id") int userid){
        System.out.println("请求参数为方式一："+userid);
        return "参数请求，方式一 "+userid;
    }
/*
    当然，你也可以通过这种传参方式：localhost:8080/sayBye?param=1或者直接表单提交参数
     * 当然，同时方法中参数声明的注释也要变成@RequestParam，代表请求参数，required属性说明了参数是否是必须的*/
    @RequestMapping(path={"/sayBye"})
    public String sayBye(@RequestParam(value="param",required = false) int param){
        System.out.println("请求参数f方式二为："+param);
        return "参数请求，方式二 "+param;
    }
    //处理不同请求方式的请求
    @RequestMapping(path={"/getType1"},method = RequestMethod.GET)
    public String getType1(@RequestParam(value = "param") int param){
        System.out.println("限定处理get请求的参数请求v "+param);
        return "处理get请求的参数请求 "+param;
    }

    @RequestMapping(path={"/getType2"},method = RequestMethod.POST)
    public String getType2(@RequestParam(value = "param") int param){
        System.out.println("限定处理get请求的参数请求 "+param);
        return "处理get请求的参数请求 "+param;
    }
}
