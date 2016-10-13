package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.user.pojo.ErrorPatientCaseInfor;
import com.zxh.ssm.module.user.pojo.PatientCasesInformation;
import com.zxh.ssm.module.user.pojo.UploadDBMessage;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public interface UploadToPCIService {
    UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> saveDataToPCI(String path) throws Exception;
}
