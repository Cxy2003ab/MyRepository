package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //1.获取url
        String url = req.getRequestURI().toString();
        log.info("请求的url:{}",url);

        //2.判断请求路径是否有Login,如果有就放行
        if(url.contains("login")){
            log.info("登录操作，放行：...");
            return true;
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
            return false;
        }
        //5.解析令牌
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//解析失败
            e.printStackTrace();
            log.info("解析失败，返回未登录的错误信息");
            Result error = Result.error("NOT LOGIN");
            //将字符串转Json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }
        log.info("令牌合法，放行");
        return true;
    }

    @Override//Controller运行之后在运行的
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
