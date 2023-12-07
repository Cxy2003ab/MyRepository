package com.itheima.service;

import com.itheima.pojo.Dept;


import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门数据
     */
     List<Dept> list();

    /**
     * 删除部门id
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);

    /**
     * 获取id
     * @param id
     * @return
     */
    Dept getById(Integer id);
}
