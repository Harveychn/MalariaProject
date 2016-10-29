package com.zxh.ssm.module.preDeal.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxh.ssm.module.preDeal.service.PreDealService;
import com.zxh.ssm.module.whole.pojo.AddressGeocode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/23.
 */
@Controller
@RequestMapping(value = "/preDeal")
public class PreDealController {

    @Resource
    private PreDealService preDealService;

    @RequestMapping(value = "/addressToGeoCode.do")
    public
    @ResponseBody
    List<String> addressToGeoCode() throws Exception {
        List<String> addressList = preDealService.getAddressList();
        if (addressList.size() <= 0) {
            return null;
        }
        return addressList;
    }

    @RequestMapping(value = "/addsAndCodes.do", method = RequestMethod.POST)
    public
    @ResponseBody
    int addsAndCodes(HttpServletRequest request, @RequestBody String addsCodes) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, AddressGeocode.class);
        List<AddressGeocode> addsAndCodeList = objectMapper.readValue(addsCodes, javaType);
        for (AddressGeocode a : addsAndCodeList) {
            System.out.println(a.getAddress() + "||" + a.getLat() + "||" + a.getLng());
        }
        preDealService.saveAddsAndCodes(addsAndCodeList);
        return addsAndCodeList.size();
    }
}
