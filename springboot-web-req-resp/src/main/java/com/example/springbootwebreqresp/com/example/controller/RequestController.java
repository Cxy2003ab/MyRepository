package com.example.springbootwebreqresp.com.example.controller;

import com.example.springbootwebreqresp.com.example.controller.com.example.pojo.user;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class RequestController {

//    //原始方式
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        //获取请求参数
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name+":"+age);
//        return "OK";
//    }
//原始方式
//@RequestMapping("/simpleParam")
//请求参数名要一致
//public String simpleParam(String name,Integer age){
//        System.out.println(name+":"+age);
//        return "OK";
//    }
//RequestParam 默认是true，加上了这个注解必须要加请求参数
    public String simpleParam(@RequestParam(name="name") String username, Integer age){
        System.out.println(username+":"+age);
        return "OK";
    }

    // 简单实体对象
    @RequestMapping("/simplePojo")
    public String simplePojo(user us){
        System.out.println(us);
        return "ok";
    }
    //复杂实体对象
    @RequestMapping("/complexPojo")
    public String complexPojo(user us){
        System.out.println(us);
        return "ok";
    }
    //数组和集合
    //日期时间参数
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "ok";
    }

    //Json参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody user us){
        System.out.println(us);
        return "ok";
    }

    //路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }
}
