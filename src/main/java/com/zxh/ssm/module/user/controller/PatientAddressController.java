package com.zxh.ssm.module.user.controller;

import com.zxh.ssm.module.user.pojo.PatientAddress;
import com.zxh.ssm.module.user.pojo.PatientAddressExample;
import com.zxh.ssm.module.user.service.PatientAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/9/28.
 */
@Controller
@RequestMapping("/PatientAddressController")
public class PatientAddressController {

    @Resource
    private PatientAddressService patientAddressService;

    @RequestMapping("/testController")
    public ModelAndView testController(String id,String status){
        ModelAndView modelAndView =new ModelAndView();
        System.out.println(" id  :" + id + "\n status :" + status);
        PatientAddressExample patientAddressExample = new PatientAddressExample();
        patientAddressExample.createCriteria().andPaaddressLike("云南省保山市腾冲县%").andCardidBetween(4952200,4952687);

//        model.addAttribute("patientAddress",patientAddressService.getByPojoExample(patientAddressExample));
        modelAndView.addObject("patientAddress",patientAddressService.getByPojoExample(patientAddressExample));
        modelAndView.setViewName("patientAddrTest");
//        return "patientAddrTest";
        return modelAndView;
    }

    @RequestMapping("/testControllerJson")
    public @ResponseBody List<PatientAddress> testControllerJson(String id,String status){
        PatientAddressExample patientAddressExample = new PatientAddressExample();
        patientAddressExample.createCriteria().andPaaddressLike("云南省保山市腾冲县%").andCardidBetween(4952200,4952687);
        List<PatientAddress> responseList =new ArrayList<PatientAddress>();
        responseList = patientAddressService.getByPojoExample(patientAddressExample);
        return responseList;
    }
}
