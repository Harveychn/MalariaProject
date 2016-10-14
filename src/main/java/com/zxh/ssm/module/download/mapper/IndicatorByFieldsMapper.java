package com.zxh.ssm.module.download.mapper;

import com.zxh.ssm.module.user.pojo.Indicator;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/14.
 */
public interface IndicatorByFieldsMapper {
    List<Indicator> selectIndicatorByFields(List<String> displayFields) throws Exception;
}
