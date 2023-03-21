package com.work.springboot03.controller;

import com.work.springboot03.pojo.User;
import com.work.springboot03.service.UserService;
import com.work.springboot03.utils.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/index.html")
    public String toIndex(){
        System.out.println("-----index-----");
        return "index";
    }


    @RequestMapping("/login")
    public String login(User user,HttpSession session,HttpServletRequest request){
        System.out.println("-------login------");
        System.out.println("user:"+user);

        User user1=service.login(user);
        if (user1!=null){
            session.setAttribute("user1",user1);
            //重定向到查询
            return "redirect:/user/getAllUser";
        }else {//登录失败
            request.setAttribute("msg","username or password is incorrect");
            return "index";
        }

    }

    @RequestMapping("/getAllUser")
    public String getAllUser(@RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "3") Integer pageSize,
                             String name,
                             HttpServletRequest request){

        System.out.println("----getAllUser----");
        System.out.println("currentPage:"+currentPage);
        System.out.println("name:"+name);

        if ("".equals(name)){
            name=null;
        }
        //创建pages对象
        Pages pages=new Pages();
        pages.setCurrentPage(currentPage);
        pages.setPageSize(pageSize);

        int totalCount=service.selectCount(name);
        pages.setTotalCount(totalCount);

        //将模糊查询的关键字保存到request中
        request.setAttribute("moh",name);
        //将pages对象保存到request中
        request.setAttribute("pages",pages);

        List<User> list=service.getAllUserAndRole(currentPage, pageSize,name);

        request.setAttribute("list",list);

        return "query";

    }
}
