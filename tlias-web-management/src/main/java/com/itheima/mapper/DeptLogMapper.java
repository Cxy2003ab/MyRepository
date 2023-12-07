package com.itheima.mapper;

import com.itheima.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper//交给Ioc容器
public interface DeptLogMapper {
    @Insert("insert into tlias.dept_log (create_time, description) VALUES (#{createTime},#{description})")
    void insert(DeptLog log);
}
