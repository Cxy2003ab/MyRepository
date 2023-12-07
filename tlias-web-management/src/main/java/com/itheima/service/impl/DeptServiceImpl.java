package com.itheima.service.impl;

import com.itheima.anno.Log;
import com.itheima.mapper.DeptLogMapper;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.service.DeptService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class DeptServiceImpl implements DeptService{
    //由于service层没有select的方法，需要调用Mapper层的方法
    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Autowired(required = false)
    private EmpMapper empMapper;

    @Autowired(required = false)
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    //rollbackFor能判断是何种异常
    @Transactional//spring事务管理
    @Log
    @Override
    public void delete(Integer id) {
        try {
            //根据部门id删除部门
            deptMapper.deleteById(id);
            //根据id删除部门下的员工
            empMapper.deleteByDeptId(id);
        } finally {
            //不管有没有删除都要记录日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是"+id+"号部门");
            //执行其他操作
            deptLogService.insert(deptLog);//添加操作的日志进入数据库中
        }

    }
    @Log
    @Override
    public void add(Dept dept) {
        //补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    /**
     * 更新部门
     * @param dept
     */
   @Log
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    /**
     * 获取部门id
     * @param id
     * @return
     */
    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getByid(id);
        return dept;
    }
}
