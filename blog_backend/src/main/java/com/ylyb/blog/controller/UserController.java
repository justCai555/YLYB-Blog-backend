package com.ylyb.blog.controller;


import com.ylyb.blog.service.impl.UserServiceImpl;
import com.ylyb.blog.utils.R;
import com.ylyb.blog.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-07-26
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    public String test(){
        return "this is a test";
    }

    @RequestMapping("/getDraft")
    public String getDraft(){
        return "draft";
    }

    @RequestMapping("/register")
    public R userRegister(@RequestBody Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username +" : " +password);
        return null;
    }

    @RequestMapping("/login")
    public R userLogin(@RequestBody Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username +" : " +password);
        int uid = userService.userLogin(username, password);
        if(uid>0){
            String token = TokenUtil.generateToken(Integer.toString(uid));
            return R.ok(Arrays.asList(uid, token));
        }else {
            return R.failed();
        }

    }
}

