package com.zxh.ssm.module.user.service;

import com.zxh.ssm.module.user.pojo.ErrorWeatherInfor;
import com.zxh.ssm.module.user.pojo.UploadDBMessage;
import com.zxh.ssm.module.whole.pojo.WeatherData;

/**
 * Created by 郑晓辉 on 2016/10/12.
 */
public interface UploadToWeatherService {
    UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> saveDataToWeather(String path) throws Exception;
}
