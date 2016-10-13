package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.user.pojo.CaseJudgmentInformation;
import com.zxh.ssm.module.user.pojo.ErrorCaseJudgInfor;
import com.zxh.ssm.module.user.pojo.UploadDBMessage;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public interface UploadToCaseJudgService {
    UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> saveToCaseJudgInfor(String path) throws Exception;
}
