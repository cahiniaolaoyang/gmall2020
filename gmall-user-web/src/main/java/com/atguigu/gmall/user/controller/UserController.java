package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.beans.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Reference
    UserService userService;


    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello dubbo";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> user=userService.getAllUser();
        return user;
    }

    @RequestMapping("getUserById")
    @ResponseBody
    public UmsMember getUserById(String id){
        UmsMember user=userService.getUserById(id);
        return user;
    }

    @RequestMapping("getUserAddressById")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getUserAddressById(String id){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses=userService.getUserAddressById(id);
        return umsMemberReceiveAddresses;
    }

}
