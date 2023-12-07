package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
//@Aspect
public class Myspect {
    //通知类型
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){//在原始方法运行之前
            log.info("before--");
    }
    @Around("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//原始方法运行前后都会
            log.info("before--");
            //调用原始方法
        Object result = proceedingJoinPoint.proceed();
            log.info("after--");
        return result;
    }
    @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void after(){
        log.info("after---");
    }
    @AfterReturning("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void afterReturning(){
        log.info("afterThrowing");
    }
    //异常通知（程序在出现异常的情况下，执行的后置通知）
    @AfterThrowing("execution(* com.itheima.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing ...");
    }
}
