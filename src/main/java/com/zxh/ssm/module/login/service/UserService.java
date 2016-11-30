package com.zxh.ssm.module.login.service;


import com.zxh.ssm.module.login.pojo.CheckUser;

/**
 * Created by R丶sJournal on 2016/11/6.
 */
public interface UserService {
     public boolean checkLogin(String useremail,String password) throws Exception;
     public boolean checkRegister(String useremail) throws Exception;
     public void saveRegister(CheckUser checkUser)throws Exception;
}
