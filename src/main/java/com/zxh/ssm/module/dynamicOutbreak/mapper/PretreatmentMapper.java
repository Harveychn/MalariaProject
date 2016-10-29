package com.zxh.ssm.module.dynamicOutbreak.mapper;

import com.zxh.ssm.module.dynamicOutbreak.pojo.Pretreatment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/20.
 */
public interface PretreatmentMapper {
    List<Pretreatment> selectStandardPosition(@Param("province") String province) throws Exception;

    List<String> selectDisProvinces()throws Exception;
}
