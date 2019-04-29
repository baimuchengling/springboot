package com.hzl.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:
 * @Date: 2018/12/28 22:46
 * @Description:
 *//*
 * @program: springboot
 * @description: aop,在执行方法前后拦截请求
 * @author:
 * @create: 2018-12-28-22-46
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    //封装该段代码
    //@Pointcut("execution(public * com.hzl.demo.controller..*(..))")
    @Pointcut("execution(public * com.hzl.demo.controller..*.*(..) )")
    //具体到某个类市用：@Pointcut("execution(public * com.hzl.demo.controller.UserController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("在所有controller中方法执行前先运行该方法");
        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter(){
        logger.info("在所有controller中方法执行后再运行该方法");
    }

    //方法执行完后返回一个object
    @AfterReturning(returning = "object" ,pointcut = "log()")
    public void doAfterReturning(Object object){

        logger.info("response={}",object.toString());
    }
}
