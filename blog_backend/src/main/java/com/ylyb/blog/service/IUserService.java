package com.ylyb.blog.service;

import com.ylyb.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-07-26
 */
public interface IUserService extends IService<User> {


    public int userLogin(String username, String password);

    public boolean userRegister(String username, String password);
}
