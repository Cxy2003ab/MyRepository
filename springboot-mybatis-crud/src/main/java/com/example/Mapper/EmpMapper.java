package com.example.Mapper;

import com.example.Pojo.Emp;

import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 删除操作，根据ID删除数据
     * delete
     */
    @Delete("delete from mybatis.emp where id = #{id}")
    public void delete(Integer id);

    /**
     * Insert新增员工操作
     * @param emp
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")//获得返回的主键
    @Insert("insert into mybatis.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    /**
     * update更新员工
     * @param emp
     */
    @Update("update mybatis.emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate},dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    /**
     * select查询员工
     */
    //实体类和字段名不一致时
    //方案二
//    @Results({
//            @Result(column = "dept_id",property = "deptId"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from mybatis.emp where id=#{id}")
    public Emp getById(Integer id);
    /**
     * 条件查询员工信息
     * - 姓名：要求支持模糊匹配like '%张%'
     * - 性别：要求精确匹配
     * - 入职时间：要求进行范围查询
     * - 根据最后修改时间进行降序排序
     */
//    @Select("select *from mybatis.emp where name like '%${name}%' and gender = #{gender} and entrydate between " +
//            "#{begin} and #{end} order by update_time desc ")
    //方法二，字符串的拼接方法contact方法
 /*   @Select("select *from mybatis.emp where name like concat('%',#{name},'%') and gender = #{gender} and entrydate between " +
            "#{begin} and #{end} order by update_time desc ")*/
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 动态更新员工
     * @param emp
     */

    public void update2(Emp emp);
}
