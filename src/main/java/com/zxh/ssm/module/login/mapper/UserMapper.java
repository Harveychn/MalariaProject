package com.zxh.ssm.module.login.mapper;

import com.zxh.ssm.module.login.pojo.User;

/**
 * Created by R丶sJournal on 2016/11/6.
 */
public interface UserMapper {
    public User getUserByName(String username);
}
