package com.work.springboot03.dao;

import com.work.springboot03.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有用户以及对应的角色
    public List<User> getAllUserAndRole(@Param("start") Integer start,
                                        @Param("pageSize") Integer pageSize,
                                        @Param("name") String name);


    //用户登录
    public User login(User user);

    //查询总记录数
    public int selectCount(String name);

}