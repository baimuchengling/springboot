package com.hzl.demo.service;

import org.springframework.stereotype.Component;

/**
 * @Auther: zhilin
 * @Date: 2018/11/29 22:46
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author: zhilin
 * @create: 2018-11-29-22-46
 */
@Component
public class TestService {
    public String hello(){
        String result="我是返回的结果！";
        //这块用来写业务代码
        System.out.println("测试 "+result);
        return result;
    }
}
