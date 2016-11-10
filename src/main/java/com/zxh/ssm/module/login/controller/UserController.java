package com.zxh.ssm.module.login.controller;

import com.zxh.ssm.module.login.pojo.User;
import com.zxh.ssm.module.login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by R丶sJournal on 2016/11/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(User user, Model model) throws Exception {
        User User= userService.checkLogin(user.getUserPassword(), user.getUserName());
        if(User!=null){
            model.addAttribute(User);
            return "login";
        }
        return "404";
    }
}
