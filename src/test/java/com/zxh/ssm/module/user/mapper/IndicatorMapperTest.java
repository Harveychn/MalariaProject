package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.user.pojo.IndicatorExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class IndicatorMapperTest {
    @Resource
    private IndicatorMapper indicatorMapper;
    @Test
    public void selectByExample() throws Exception {
        IndicatorExample indicatorExample = new IndicatorExample();
        indicatorExample.createCriteria().andDownableLessThanOrEqualTo(new Byte("0"));
        System.out.println(indicatorMapper.selectByExample(indicatorExample).size());
    }

}