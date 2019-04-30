package com.hzl.demo.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
    /**
    *   该类是用于测试代码用的规范写法
    */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceDemo {
    @Resource
    TestService testService;

    @Test
    public void helloTest() {
        testService.hello();
        System.out.println("123");
    }

}
