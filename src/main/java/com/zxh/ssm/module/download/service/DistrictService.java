package com.zxh.ssm.module.download.service;

import com.zxh.ssm.module.whole.pojo.FourLevelLinkage;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/16.
 */
public interface DistrictService {
    List<FourLevelLinkage> getProvinces() throws Exception;
    List<FourLevelLinkage> getCities(int upId) throws Exception;
    List<FourLevelLinkage> getCounties(int upId) throws  Exception;
    List<FourLevelLinkage> getVillages(int upId) throws Exception;
}
