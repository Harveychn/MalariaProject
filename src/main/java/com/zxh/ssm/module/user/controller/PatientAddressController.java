package com.zxh.ssm.module.user.controller;

import com.zxh.ssm.module.user.service.PatientAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by 郑晓辉 on 2016/9/28.
 */
@Controller
@RequestMapping("/PatientAddressController")
public class PatientAddressController {
    @Resource
    private PatientAddressService patientAddressService;

    @RequestMapping("/testController")
    public ModelAndView testController(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientAddress",patientAddressService.getByPojoExample());
        return modelAndView;
    }
}
