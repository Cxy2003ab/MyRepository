package com.itheima;

import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopQuickstartApplicationTests {

    @Autowired
    private DeptService deptService;

    @Test
    public void testAopDelete() {
        deptService.delete(10);
    }
    @Test
    public void testAopList(){
        deptService.list();
    }
    @Test
    public void testGetById(){
        Dept dept = deptService.getById(1);
        System.out.println(dept);
    }

}
