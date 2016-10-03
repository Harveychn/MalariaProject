package com.zxh.ssm.module.user.controller;

import com.zxh.ssm.module.user.pojo.DynamicOutbreakRe;
import com.zxh.ssm.module.user.pojo.DynamicOutbreakVo;
import com.zxh.ssm.module.user.service.DynamicOutbreakService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import javax.annotation.Resource;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
@Controller
@RequestMapping("/DynamicOutbreak")
public class DynamicOutbreakController {

    @Resource
    private DynamicOutbreakService dynamicOutbreakService;

    @RequestMapping("/subModule1")
    public
    @ResponseBody
    List<DynamicOutbreakRe> subModule1(DynamicOutbreakVo dynamicOutbreakVo) throws Exception {
        System.out.println(" dynamicOutbreakVo.year :" + dynamicOutbreakVo.getYear() +
                "\ndynamicOutbreakVo.month :" + dynamicOutbreakVo.getMonth() +
                "\ndynamicOutbreakVo.province : " + dynamicOutbreakVo.getProvince());
        List<DynamicOutbreakRe> address = dynamicOutbreakService.findAddressList(dynamicOutbreakVo);
        System.out.println(" address List : " + address);
        return address;
    }

}
