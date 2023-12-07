package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
@Slf4j
public class TimeAspect {

    @Around("com.itheima.aop.Myspect.pt()")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
            //记录方法执行开始时间
            long begin = System.currentTimeMillis();

            //执行原始方法
            Object result = pjp.proceed();

            //记录方法执行结束时间
            long end = System.currentTimeMillis();

            //计算方法执行耗时
            log.info(pjp.getSignature()+"执行耗时: {}毫秒",end-begin);

            return result;
        }
    }

