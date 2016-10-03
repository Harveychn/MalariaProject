package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.user.pojo.AnalyzeVo;
import com.zxh.ssm.module.user.pojo.CareerAnalyzeRe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class AnalyzeMapperTest {

    @Resource
    private AnalyzeMapper analyzeMapper;

    @Test
    public void analyzeByCareer() throws Exception {
        AnalyzeVo analyzeVo = new AnalyzeVo();
        analyzeVo.setBeginYear(2005);
        analyzeVo.setEndYear(2011);
        analyzeVo.setProvince("云南");
        List<CareerAnalyzeRe> careerAnalyzeReList = analyzeMapper.analyzeByCareer(analyzeVo);
        for (CareerAnalyzeRe result: careerAnalyzeReList) {
            System.out.println(result.getCareerCategory()+" : "+result.getPatientNum());
        }
        System.out.println("===Over===");
    }

}