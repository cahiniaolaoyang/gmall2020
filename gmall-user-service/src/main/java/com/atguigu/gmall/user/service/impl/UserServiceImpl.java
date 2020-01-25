package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.beans.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> user=userMapper.getAllUser();
        return user;
    }

    @Override
    public UmsMember getUserById(String id) {
        UmsMember user=new UmsMember();
        user.setId(id);
        UmsMember user2= userMapper.selectOne(user);
        return user2;
    }

    @Override
    public List<UmsMemberReceiveAddress> getUserAddressById(String id) {
        //泛型
        Example e=new Example(UmsMemberReceiveAddress.class);
        //Example 规则查询
        e.createCriteria().andEqualTo("memberId",id);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses =userAddressMapper.selectByExample(e);
        return umsMemberReceiveAddresses;
    }


}
