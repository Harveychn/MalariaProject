package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.user.pojo.AgeGroupAnalyzeRe;
import com.zxh.ssm.module.user.pojo.AnalyzeVo;
import com.zxh.ssm.module.user.pojo.CareerAnalyzeRe;
import com.zxh.ssm.module.user.pojo.SexAnalyzeRe;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
public interface AnalyzeService {
    List<CareerAnalyzeRe> analyzeByCareer(AnalyzeVo analyzeVo) throws Exception;

    List<SexAnalyzeRe> analyzeBySex(AnalyzeVo analyzeVo) throws Exception;

    AgeGroupAnalyzeRe analyzeByAgeGroup(AnalyzeVo analyzeVo) throws Exception;
}
