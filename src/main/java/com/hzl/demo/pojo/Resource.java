package com.hzl.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther:
 * @Date: 2018/12/20 22:17
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-12-20-22-17
 */
@Configuration  //注解为一个配置文件
@ConfigurationProperties(prefix = "com.hzl.opensource") //配置文件的前缀
@PropertySource("classpath:resources.properties") //配置文件的路径
public class Resource {
    private String name;
    private String user;
    private String place;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
