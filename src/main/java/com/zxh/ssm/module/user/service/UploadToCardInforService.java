package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.whole.pojo.CardInformation;
import com.zxh.ssm.module.user.pojo.ErrorCardInfor;
import com.zxh.ssm.module.user.pojo.UploadDBMessage;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public interface UploadToCardInforService {
    UploadDBMessage<ErrorCardInfor<String>, CardInformation> saveDataToCardInfor(String path) throws Exception;
}
