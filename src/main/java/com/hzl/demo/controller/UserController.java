package com.hzl.demo.controller;

import com.hzl.demo.pojo.Result;
import com.hzl.demo.pojo.User;
import com.hzl.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.Date;

/**
 * @Auther:
 * @Date: 2018/12/20 21:26
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-12-20-21-26
 */
@RestController
public class UserController {
    private final static Logger log= LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/getUser")
    //注：使用Springmvc时，用Controller+@ResponseBody的形式
    public User getUser(){
        User user=new User();
        user.setUsername("张三");
        user.setPassword("1234");
        user.setBirthday(new Date());
        user.setAge(23);
        log.info("执行完成！");
        return user;
    }
    @RequestMapping("/addUser")
    //绑定错误信息，并返回object
    public Result<User> addUser(@Valid  User user, BindingResult bindingResult){

        //有错误信息就返回code为1的对象
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());

            return ResultUtil.fail(1,bindingResult.getFieldError().getDefaultMessage());
        }
        User user1=new User();
        user1.setAge(user.getAge());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setIncome(user.getIncome());
        user1.setBirthday(user.getBirthday());
        System.out.println(user);

        return ResultUtil.success(user1);
    }
}
