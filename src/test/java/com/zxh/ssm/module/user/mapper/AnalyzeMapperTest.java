package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.user.pojo.AgeGroupAnalyzeRe;
import com.zxh.ssm.module.user.pojo.AnalyzeVo;
import com.zxh.ssm.module.user.pojo.CareerAnalyzeRe;
import com.zxh.ssm.module.user.pojo.SexAnalyzeRe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.annotation.Resources;

import java.util.ArrayList;
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
//        analyzeVo.setEndYear(2011);
        analyzeVo.setProvince("云南");
        List<CareerAnalyzeRe> careerAnalyzeReList = analyzeMapper.analyzeByCareer(analyzeVo);
        for (CareerAnalyzeRe result : careerAnalyzeReList) {
            System.out.println(result.getCareerCategory() + " : " + result.getPatientNum());
        }
        System.out.println("===Over===");
    }

    @Test
    public void analyzeBySex() throws Exception {
        AnalyzeVo analyzeVo = new AnalyzeVo();
        analyzeVo.setBeginYear(2005);
//        analyzeVo.setEndYear(2011);
        analyzeVo.setProvince("");
        List<SexAnalyzeRe> sexAnalyzeReList = analyzeMapper.analyzeBySex(analyzeVo);
        for (SexAnalyzeRe result : sexAnalyzeReList) {
            System.out.println(result.getSex() + " : " + result.getPatientNum());
        }
    }

    @Test
    public void analyzeByAgeGroup() throws Exception {
        AnalyzeVo analyzeVo = new AnalyzeVo();
        analyzeVo.setProvince("云南");
        analyzeVo.setBeginYear(2005);
        analyzeVo.setEndYear(2011);
        List<Integer> ageGroupPop = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            analyzeVo.setVirtualAgeDownLimit(i*10);
            ageGroupPop.add(i,analyzeMapper.analyzeByAgeGroup(analyzeVo));
        }
        AgeGroupAnalyzeRe ageGroupAnalyzeRe = new AgeGroupAnalyzeRe();
        ageGroupAnalyzeRe.setAgeGroup0_9Pop(ageGroupPop.get(0));
        ageGroupAnalyzeRe.setAgeGroup10_19Pop(ageGroupPop.get(1));
        ageGroupAnalyzeRe.setAgeGroup20_29Pop(ageGroupPop.get(2));
        ageGroupAnalyzeRe.setAgeGroup30_39Pop(ageGroupPop.get(3));
        ageGroupAnalyzeRe.setAgeGroup40_49Pop(ageGroupPop.get(4));
        ageGroupAnalyzeRe.setAgeGroup50_59Pop(ageGroupPop.get(5));
        ageGroupAnalyzeRe.setAgeGroup60_69Pop(ageGroupPop.get(6));
        ageGroupAnalyzeRe.setAgeGroup70_79Pop(ageGroupPop.get(7));
        ageGroupAnalyzeRe.setAgeGroup80_89Pop(ageGroupPop.get(8));
        ageGroupAnalyzeRe.setAgeGroup90_99Pop(ageGroupPop.get(9));
        System.out.println(ageGroupAnalyzeRe.getAgeGroup0_9Pop()+" "+ageGroupAnalyzeRe.getAgeGroup10_19Pop());
    }

}