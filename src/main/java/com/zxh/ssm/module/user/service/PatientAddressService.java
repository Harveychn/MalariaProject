package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.user.pojo.PatientAddress;
import com.zxh.ssm.module.user.pojo.PatientAddressExample;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/9/28.
 */
public interface PatientAddressService {
    List<PatientAddress> getByPojoExample(PatientAddressExample patientAddressExample);
}
