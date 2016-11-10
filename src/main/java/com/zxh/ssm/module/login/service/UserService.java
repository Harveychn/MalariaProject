package com.zxh.ssm.module.login.service;

import com.zxh.ssm.module.login.pojo.User;

/**
 * Created by R丶sJournal on 2016/11/6.
 */
public interface UserService {
    // 通过用户名及密码核查用户登录
    public User checkLogin(String username,String password);
}
