package com.atguigu.gmall.service;



import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    UmsMember getUserById(String id);

    List<UmsMemberReceiveAddress> getUserAddressById(String id);
}
