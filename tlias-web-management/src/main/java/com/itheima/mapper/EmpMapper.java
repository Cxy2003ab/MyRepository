package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 获取总记录数
     * @return
     */
    @Select("select count(*) from emp")
    public long count();

    /**
     * 分页查询，获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    //@Select("select * from emp limit #{start},#{pageSize}")
    //这里要增加where进行条件查询
    public List<Emp> list(Integer start, Integer pageSize,String name, Short gender, LocalDate begin,LocalDate end);

    /**
     * 批量删除员工的操作
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    //新增员工
   @Insert("insert into tlias.emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);
    @Select("select *from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    //根据用户名和密码查询员工信息
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from tlias.emp " +
            "where username=#{username} and password =#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据部门id来删除员工数据
     * @param deptId
     */
    @Delete("delete from tlias.emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
