package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.user.mapper.AnalyzeMapper;
import com.zxh.ssm.module.user.pojo.AgeGroupAnalyzeRe;
import com.zxh.ssm.module.user.pojo.AnalyzeVo;
import com.zxh.ssm.module.user.pojo.CareerAnalyzeRe;
import com.zxh.ssm.module.user.pojo.SexAnalyzeRe;
import com.zxh.ssm.module.user.service.AnalyzeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
@Service
public class AnalyzeServiceImpl implements AnalyzeService {
    @Resource
    private AnalyzeMapper analyzeMapper;

    @Override
    public List<CareerAnalyzeRe> analyzeByCareer(AnalyzeVo analyzeVo) throws Exception {
        List<CareerAnalyzeRe> careerAnalyzeReList = analyzeMapper.analyzeByCareer(analyzeVo);
        for (int i = 0; i < careerAnalyzeReList.size(); i++) {
            CareerAnalyzeRe careerAnalyzeRe = careerAnalyzeReList.get(i);
            if (careerAnalyzeRe.getCareerCategory().equals("不详")) {
                careerAnalyzeReList.remove(careerAnalyzeRe);
            }
        }
        return careerAnalyzeReList;
    }

    @Override
    public List<SexAnalyzeRe> analyzeBySex(AnalyzeVo analyzeVo) throws Exception {
        List<SexAnalyzeRe> sexAnalyzeReList = analyzeMapper.analyzeBySex(analyzeVo);
        return sexAnalyzeReList;
    }

    @Override
    public AgeGroupAnalyzeRe analyzeByAgeGroup(AnalyzeVo analyzeVo) throws Exception {
        List<Integer> ageGroupPop = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            analyzeVo.setVirtualAgeDownLimit(i * 10);
            ageGroupPop.add(i, analyzeMapper.analyzeByAgeGroup(analyzeVo));
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
        return ageGroupAnalyzeRe;
    }

}
