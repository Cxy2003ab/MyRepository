package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门的信息
     * @return
     */
    @Select("select *from tlias.dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from tlias.dept where id=#{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into tlias.dept(name, create_time, update_time) values (#{name},#{createTime}," +
            "#{updateTime})")
    void add(Dept dept);

    /**
     * 修改部门
     * @param dept
     */
    @Update("update tlias.dept set name =#{name},create_time=#{createTime} " +
            ",update_time=#{updateTime} where id = #{id}")
    void update(Dept dept);

    /**
     * 获取id
     * @param id
     * @return
     */
    @Select("select * from tlias.dept where id = #{id}")
    Dept getByid(Integer id);
}
