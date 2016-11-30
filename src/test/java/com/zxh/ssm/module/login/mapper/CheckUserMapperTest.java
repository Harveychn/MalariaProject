package com.zxh.ssm.module.login.mapper;

import com.zxh.ssm.module.login.pojo.CheckUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by R丶sJournal on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class CheckUserMapperTest {

    @Resource
    CheckUserMapper checkUserMapper;

    @Test
    public void insert() throws Exception {
//        CheckUser checkUser=new CheckUser();
//        Date date=new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time=df.format(date);
//        Date d=df.parse(time);
//        System.out.println("time:"+d);
//        checkUser.setJoindate(d);
//        checkUser.setUseremail("11@qq.com");
//        checkUser.setReviewstatus("未审核");
//        checkUser.setPerissioninformation("未审核用户");
//        checkUser.setUserpassword("111");
//        checkUser.setUserphone("137");
//        checkUser.setUserrealname("wo");
//        checkUser.setUserunit("gongsi");
//        checkUser.setUsername("111");
//        checkUserMapper.insert(checkUser);
    }

}