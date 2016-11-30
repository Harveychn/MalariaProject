package com.zxh.ssm.module.login.controller;


import com.zxh.ssm.module.login.pojo.CheckUser;
import com.zxh.ssm.module.login.pojo.User;
import com.zxh.ssm.module.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by R丶sJournal on 2016/11/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView userLogin(User user) throws Exception {
        boolean loginType = userService.checkLogin(user.getUseremail(),user.getUserpassword());
        ModelAndView modelAndView=new ModelAndView();
        if(loginType){
            modelAndView.addObject("user",user);
            modelAndView.setViewName("./adminMalaria");
            return modelAndView;
        }else{
            modelAndView.setViewName("error/404");
            return modelAndView;
        }
    }
    @RequestMapping("/register")
    public ModelAndView userRegister(CheckUser checkUser)throws Exception{
        boolean registerType=userService.checkRegister(checkUser.getUseremail());
        ModelAndView modelAndView=new ModelAndView();
        if(registerType){
            userService.saveRegister(checkUser);
            modelAndView.setViewName("../../login");
        }
        return modelAndView;
    }
}
