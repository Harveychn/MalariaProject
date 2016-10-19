package com.zxh.ssm.module.download.mapper;

import com.zxh.ssm.module.whole.pojo.FourLevelLinkage;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/16.
 */
public interface DistrictInformationMapper {
    List<FourLevelLinkage> selectProvinces() throws Exception;

    List<FourLevelLinkage> selectCities(int upId) throws Exception;

    List<FourLevelLinkage> selectCounties(int upId) throws Exception;

    List<FourLevelLinkage> selectVillages(int upId) throws Exception;
}
