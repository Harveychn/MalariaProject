package com.zxh.ssm.module.download.mapper;

import com.zxh.ssm.module.download.pojo.SQLQuery;
import com.zxh.ssm.module.whole.pojo.Indicator;

import java.util.List;
import java.util.Map;

/**
 * Created by 郑晓辉 on 2016/10/14.
 */
public interface IndicatorByFieldsMapper {
    List<Indicator> selectIndicatorByFields(List<String> displayFields) throws Exception;

    List<String> selectBelongTables() throws Exception;

    List<Map<String,Object>> selectData(SQLQuery sqlQuery)throws Exception;
}
