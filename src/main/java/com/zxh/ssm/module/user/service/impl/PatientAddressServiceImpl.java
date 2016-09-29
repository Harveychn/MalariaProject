package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.user.mapper.PatientAddressMapper;
import com.zxh.ssm.module.user.pojo.PatientAddress;
import com.zxh.ssm.module.user.pojo.PatientAddressExample;
import com.zxh.ssm.module.user.service.PatientAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/9/28.
 */
@Service
public class PatientAddressServiceImpl implements PatientAddressService {
    @Resource
    private PatientAddressMapper patientAddressMapper;
    @Override
    public List<PatientAddress> getByPojoExample(){
        PatientAddressExample patientAddressExample = new PatientAddressExample();
        patientAddressExample.createCriteria().andPaaddressLike("云南省保山市腾冲县%").andCardidBetween(4952200,4952687);
        return patientAddressMapper.selectByExample(patientAddressExample);
    }
}
