package com.zxh.ssm.module.login.service.impl;

import com.zxh.ssm.module.login.pojo.User;
import com.zxh.ssm.module.login.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by R丶sJournal on 2016/11/6.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserService userService;

    /* 登陆验证 */
    public User checkLogin(String username, String password) {
        //根据用户名实例化用户对象
        User user = new User();
        if (user != null && user.getUserPassword()==password) {
            return user;
        }
        return null;
    }
}
