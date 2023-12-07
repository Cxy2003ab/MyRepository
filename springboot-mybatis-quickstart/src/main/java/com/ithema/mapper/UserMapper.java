package com.ithema.mapper;

import com.ithema.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有用户数据
    @Select("select *from db02.user")
    public List<User> list();

}