package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.user.pojo.DynamicOutbreakVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class DynamicOutbreakMapperTest {

    @Resource
    private DynamicOutbreakMapper dynamicOutbreakMapper;

    @Test
    public void selectDynamicAddress() throws Exception {
        DynamicOutbreakVo dynamicOutbreakVo = new DynamicOutbreakVo();
        dynamicOutbreakVo.setYear(2005);
        dynamicOutbreakVo.setMonth(1);
//        List<DynamicOutbreakVo> result = dynamicOutbreakMapper.selectAddressByYearMonth(dynamicOutbreakVo);
        List<String> addresultList = dynamicOutbreakMapper.selectAddressByYearMonth(dynamicOutbreakVo);
        System.out.println("  ");
    }

}