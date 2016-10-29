package com.zxh.ssm.module.download.mapper;

import com.zxh.ssm.module.whole.pojo.FourLevelLinkage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/16.
 */
public interface DistrictInformationMapper {
    List<FourLevelLinkage> selectProvinces() throws Exception;

    List<FourLevelLinkage> selectCities(@Param("upId") int upId) throws Exception;

    List<FourLevelLinkage> selectCounties(@Param("upId") int upId) throws Exception;

    List<FourLevelLinkage> selectVillages(@Param("upId") int upId) throws Exception;
}
