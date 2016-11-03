package com.zxh.ssm.module.user.controller;

import com.zxh.ssm.module.user.pojo.AgeGroupAnalyzeRe;
import com.zxh.ssm.module.user.pojo.AnalyzeVo;
import com.zxh.ssm.module.user.pojo.CareerAnalyzeRe;
import com.zxh.ssm.module.user.pojo.SexAnalyzeRe;
import com.zxh.ssm.module.user.service.AnalyzeService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
@Controller
@RequestMapping("/AnalyzeController")
public class AnalyzeController {
    @Resource
    private AnalyzeService analyzeService;

    @RequestMapping("/careerModule")
    public
    @ResponseBody
    List<CareerAnalyzeRe> careerModule(AnalyzeVo analyzeVo) throws Exception {
        return analyzeService.analyzeByCareer(analyzeVo);
    }

    @RequestMapping("/sexModule")
    public
    @ResponseBody
    List<SexAnalyzeRe> sexModule(AnalyzeVo analyzeVo) throws Exception {
        return analyzeService.analyzeBySex(analyzeVo);
    }

    @RequestMapping("/ageGroupModule")
    public
    @ResponseBody
    AgeGroupAnalyzeRe ageGroupModule(AnalyzeVo analyzeVo) throws Exception {
        return analyzeService.analyzeByAgeGroup(analyzeVo);
    }
}
