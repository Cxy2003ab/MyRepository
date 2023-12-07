package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //1.获取url
        String url = req.getRequestURI().toString();
        log.info("请求的url:{}",url);

        //2.判断请求路径是否有Login,如果有就放行
        if(url.contains("login")){
            log.info("登录操作，放行：...");
            chain.doFilter(req,resp);
            return;
        }
        //3.拿token令牌
        String jwt = req.getHeader("token");

        //4.判断令牌是否存在
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //将字符串转Json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        //5.解析令牌
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//解析失败
            e.printStackTrace();
            log.info("解析失败，返回未登录的错误信息");
            Result error = Result.error("NOT_LOGIN");
            //将字符串转Json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        log.info("令牌合法，放行");
        chain.doFilter(req,resp);
    }

    }

