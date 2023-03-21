package com.work.springboot03.service;

import com.work.springboot03.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    public List<User> getAllUserAndRole(Integer currentPage,Integer pageSize,String name);

    //用户登录
    public User login(User user);

    //查询总记录数
    public int selectCount(String name);
}
