package com.ylyb.blog.myservice.impl;

import com.ylyb.blog.myservice.UserService;
import com.ylyb.blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class MyUserServiceImpl implements UserService {
    @Autowired
    private UserServiceImpl userService;


    @Override
    public int userLogin() {

        return 0;
    }
}
