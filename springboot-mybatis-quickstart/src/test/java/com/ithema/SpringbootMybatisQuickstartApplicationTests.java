package com.ithema;

import com.ithema.mapper.UserMapper;
import com.ithema.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user ->
        {
            System.out.println(user);
        });
    }


}
