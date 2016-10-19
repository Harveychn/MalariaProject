package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.user.pojo.ErrorObserStaInfor;
import com.zxh.ssm.module.whole.pojo.MeteorologicalStationInsformation;
import com.zxh.ssm.module.user.pojo.UploadDBMessage;

/**
 * Created by 郑晓辉 on 2016/10/12.
 */
public interface UploadToObserStaService {
    UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> saveDataToObserSta(String path) throws Exception;
}
