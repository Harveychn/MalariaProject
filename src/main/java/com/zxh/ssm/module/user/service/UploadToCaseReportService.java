package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.user.pojo.CaseReportInformation;
import com.zxh.ssm.module.user.pojo.ErrorCaseReportInfor;
import com.zxh.ssm.module.user.pojo.UploadDBMessage;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public interface UploadToCaseReportService {
    UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> saveToCaseReportInfor(String path) throws Exception;
}
