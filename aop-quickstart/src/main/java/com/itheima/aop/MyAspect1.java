package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect1 {
    //如果方法有异常，则要抛异常
    //@Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Pointcut("execution(void delete(java.lang.Integer))")
    //@Pointcut("execution(void com.itheima.service.DeptService.delete(java.lang.Integer))")
    //通配符 * 通配任意返回类型的表达式 ..（方法形参任意类型）
    //@Pointcut("execution(* com.itheima.service.DeptService.delete(java.lang.Integer))")
    //@Pointcut("execution(* com.*.service.DeptService.delete(java.lang.Integer))")
    //@Pointcut("execution(* com.itheima.service.DeptService.*(..))")//这个就是接口中的所有方法，方法形参也是任意的
    //两个其中一个运行都会执行before方法
    @Pointcut("execution(* com.itheima.service.DeptService.list(..)) || execution(* com.itheima.service.DeptService.delete(..))")
    private void pt(){}

    @Before("pt()")
        public void before(){
            log.info("before...");
    }

}
