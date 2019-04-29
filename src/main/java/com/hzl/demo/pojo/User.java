package com.hzl.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @Auther:
 * @Date: 2018/12/20 21:15
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-12-20-21-15
 */

public class User {
    @NotBlank(message = "姓名不允许为空！")
    private String username;
    @NotNull(message = "password not null")
    private String password;
    private Date birthday;
    @Min(value = 18,message = "未成年人不可以添加！")
    private Integer age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double income;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss ",locale="zh",timezone = "GMT+8")

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", income=" + income +
                '}';
    }
}
