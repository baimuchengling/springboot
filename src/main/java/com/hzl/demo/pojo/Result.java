package com.hzl.demo.pojo;

/**
 * @Auther:
 * @Date: 2018/12/29 20:33
 * @Description:
 *//*
 * @program: springboot
 * @description: 结果返回对象
 * @author:
 * @create: 2018-12-29-20-33
 */

public class Result<T> {
    //错误代码
    private Integer code;
    //错误消息
    private String msg;
    //具体对象类容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
