package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.user.pojo.DynamicOutbreakVo;
import com.zxh.ssm.module.user.pojo.PatientInformation;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
public interface DynamicOutbreakMapper {
//    List<DynamicOutbreakVo> selectAddressByYearMonth(DynamicOutbreakVo dynamicOutbreakVo) throws Exception;

    List<String> selectAddressByYearMonth(DynamicOutbreakVo dynamicOutbreakVo) throws Exception;

}
