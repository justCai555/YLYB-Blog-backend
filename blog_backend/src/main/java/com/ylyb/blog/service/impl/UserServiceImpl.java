package com.ylyb.blog.service.impl;

import com.ylyb.blog.entity.User;
import com.ylyb.blog.mapper.UserMapper;
import com.ylyb.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int userLogin(String username, String password) {
        Map map = new HashMap();
        map.put("username", username);
        map.put("password", password);
        ArrayList<User> user = (ArrayList<User>) userMapper.selectByMap(map);
        if(user != null){
            return user.get(0).getUid();
        }else {
            return -1;
        }
    }

    @Override
    public boolean userRegister(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int ret = userMapper.insert(user);
        if(ret > 0){
            return true;
        }else {
            return false;
        }
    }
}
