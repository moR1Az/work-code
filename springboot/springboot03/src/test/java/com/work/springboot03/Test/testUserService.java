package com.work.springboot03.Test;

import com.work.springboot03.pojo.User;
import com.work.springboot03.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testUserService {

    @Test
    public void testHello(){
        System.out.println("hello, world");
    }

    @Autowired(required = false)
    private UserService service;

    @Test
    public void testGetAllUserAndRole(){
        List<User> list=service.getAllUserAndRole(1,3,"n");
        for (User u:list){
            System.out.println(u);
        }
    }

    @Test
    public void testLogin(){
        User user=new User();
        user.setUName("G2");
        user.setUPassword("g2");

        User user1=service.login(user);
        System.out.println("user1:"+user1);

    }

    //查询总记录数
    @Test
    public void testCount(){
        int totalCount=service.selectCount("y");
        System.out.println("totalCount:"+totalCount);
    }

}
