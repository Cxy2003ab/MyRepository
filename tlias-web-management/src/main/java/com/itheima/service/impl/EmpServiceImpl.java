package com.itheima.service.impl;

import com.itheima.anno.Log;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender,  LocalDate begin, LocalDate end) {
        //1.获取总记录数
        long count = empMapper.count();
        //2.获取数据列表
        Integer start = (page-1) *pageSize;
        List<Emp> empList = empMapper.list(start,pageSize,name,gender,begin,end);
        PageBean pageBean = new PageBean(count,empList);
        return pageBean;
    }
    @Log
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
