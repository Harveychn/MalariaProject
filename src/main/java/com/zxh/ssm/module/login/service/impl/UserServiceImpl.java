package com.zxh.ssm.module.login.service.impl;

import com.zxh.ssm.module.login.mapper.CheckUserMapper;
import com.zxh.ssm.module.login.mapper.UserMapper;
import com.zxh.ssm.module.login.pojo.CheckUser;
import com.zxh.ssm.module.login.pojo.User;
import com.zxh.ssm.module.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by R丶sJournal on 2016/11/6.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    //登陆方法的实现，从jsp页面获取useremail与password
    public boolean checkLogin(String useremail,String password) throws Exception {
        User user=userMapper.selectByPrimaryKey(useremail);
        if(user!=null){
            if(user.getUserpassword().equals(password))
                return  true;
        }
                return false;
    }

    @Autowired
    CheckUserMapper checkUserMapper;
    //注册方法的实现，从jsp页面获取useremail
    public boolean checkRegister(String useremail)throws Exception{
        CheckUser checkUser=checkUserMapper.selectByPrimaryKeyInUser(useremail);
        if(checkUser==null)
            return true;
        else
            return false;
    }

    public void saveRegister(CheckUser checkUser)throws Exception{
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(date);
        Date d=df.parse(time);

        checkUser.setReviewstatus("未审核");
        checkUser.setPerissioninformation("未审核用户");
        checkUser.setJoindate(d);
        checkUserMapper.insert(checkUser);
    }
}
