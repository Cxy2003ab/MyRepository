package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;


import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     *
     * @param page 多条员工信息
     * @param pageSize 总页码
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,
                  LocalDate end);

    /**
     * 员工的批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     */
    Emp getById(Integer id);

    /**
     * 修改员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
