package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.whole.pojo.CaseRevisedInformation;
import com.zxh.ssm.module.user.pojo.ErrorCaseRevisedInfor;
import com.zxh.ssm.module.user.pojo.UploadDBMessage;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public interface UploadToCaseRevisedService {
    UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> saveToCaseRevisedInfor(String path) throws Exception;
}
