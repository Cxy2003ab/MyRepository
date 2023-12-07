package com.example;

import com.example.Mapper.EmpMapper;
import com.example.Pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Resource
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        empMapper.delete(17);
    }

    @Test
    public void testInsert() {
        //创建员工对象
        Emp emp = new Emp();
        emp.setUsername("tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
        System.out.println(emp.getDeptId());
    }

    /**
     * 修改员工信息
     */
        @Test
        public void testUpdate(){
            //要修改的员工信息
            //要修改的员工信息
            Emp emp = new Emp();
            emp.setId(20);
            emp.setUsername("Tom222");
            //调用方法，修改员工数据
            //empMapper.update(emp);
            empMapper.update2(emp);
        }

    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(1);
        System.out.println(emp);
    }
    @Test
    public void testSelectIf(){
//        List<Emp> list = empMapper.list("张",(short)1,LocalDate.of(2010,01,01),LocalDate.of(2020,01,01));
        List<Emp> list = empMapper.list(null,(short)1,null,null);
        System.out.println(list);
    }
    }


