package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j//记录操作日志
@Component
@Aspect//切面类
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired(required = false)
    private OperateLogMapper operateLogMapper;
    @Around("@annotation(com.itheima.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {//调用原始目标方法运行
        //操作人 (获取请求头中的jwt令牌，解析令牌)
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer)claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();
        //操作方法参数

        Object[] args = joinPoint.getArgs();
        String methodParam = Arrays.toString(args);
        //调用原始方法
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //方法返回值
        String returnValue = JSONObject.toJSONString(result);
        //操作耗时
        long costTime = end - begin;

        //记录操作日志
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParam,returnValue,costTime);
        operateLogMapper.insert(operateLog);
        return result;
    }
}
