package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect2 {
   //两种类型的连接点 一中是围绕Around 的ProceedingJoinPoint 另一种是JoinPoint
    @Pointcut("execution(* com.itheima.service.DeptService.*(..))")
    private void pt(){}


    //前置通知
    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + " MyAspect2 -> before ...");
    }

    //后置通知
    @Before("pt()")
    public void after(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + " MyAspect2 -> after ...");
    }
    //环绕通知
    @Around("pt()")
        public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("MyAspect2 around before");

        //获取目标类名
        String name = joinPoint.getTarget().getClass().getName();
        log.info("目标类名：{}",name);

        //目标方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法名：{}",methodName);

        //获取方法执行时需要的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法参数：{}", Arrays.toString(args));

        //执行原始方法
        Object returnValue = joinPoint.proceed();

        return returnValue;
    }
}
