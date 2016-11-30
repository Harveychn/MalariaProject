package com.zxh.ssm.module.login.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by R丶sJournal on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(userMapper.selectByPrimaryKey("958844609@qq.com"));
    }

}