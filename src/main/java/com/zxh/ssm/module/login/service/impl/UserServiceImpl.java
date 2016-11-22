package com.zxh.ssm.module.login.service.impl;

import com.zxh.ssm.module.login.mapper.UserMapper;
import com.zxh.ssm.module.login.pojo.User;
import com.zxh.ssm.module.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by R丶sJournal on 2016/11/6.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    //登陆方法的实现，从jsp页面获取useremail与password
    public boolean login(String useremail,String password) throws Exception {
        User user=userMapper.selectByPrimaryKey(useremail);
        if(user!=null){
            if(user.getUserpassword().equals(password))
                return  true;
        }
                return false;
    }

}
