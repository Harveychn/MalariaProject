package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.user.pojo.CareerAnalyzeRe;
import com.zxh.ssm.module.user.pojo.AnalyzeVo;
import com.zxh.ssm.module.user.pojo.SexAnalyzeRe;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
public interface AnalyzeMapper {

    List<CareerAnalyzeRe> analyzeByCareer(AnalyzeVo analyzeVo)throws Exception;

    List<SexAnalyzeRe> analyzeBySex(AnalyzeVo analyzeVo)throws Exception;

    int analyzeByAgeGroup(AnalyzeVo analyzeVo)throws Exception;
}
