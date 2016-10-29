package com.zxh.ssm.module.dynamicOutbreak.mapper;

import com.zxh.ssm.module.dynamicOutbreak.pojo.Pretreatment;
import com.zxh.ssm.module.whole.pojo.DiseaseOutbreak;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/19.
 */
public interface CountByAddressMapper {
    List<DiseaseOutbreak> selectCountByAddress(Pretreatment pretreatment) throws Exception;
}
