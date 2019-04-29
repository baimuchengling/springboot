package com.hzl.demo.utils;

import com.hzl.demo.pojo.Result;

/**
 * @Auther:
 * @Date: 2018/12/29 21:31
 * @Description:
 *//*
 * @program: springboot
 * @description:
 * @author:
 * @create: 2018-12-29-21-31
 */

public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("执行成功！");
        result.setData(object);
        return result;
    }

    public static Result fail(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
