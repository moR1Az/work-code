package com.work.springboot03.service.impl;

import com.work.springboot03.dao.UserMapper;
import com.work.springboot03.pojo.User;
import com.work.springboot03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired(required = false)
    private UserMapper mapper;

    @Override
    public List<User> getAllUserAndRole(Integer currentPage, Integer pageSize,String name) {
        int start=(currentPage-1)*pageSize;
        return mapper.getAllUserAndRole(start,pageSize,name);
    }

    public User login(User user){
        return mapper.login(user);
    }

    public int selectCount(String name){
        return mapper.selectCount(name);
    }
}
