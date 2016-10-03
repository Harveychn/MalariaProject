package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.user.pojo.DynamicOutbreakRe;
import com.zxh.ssm.module.user.pojo.DynamicOutbreakVo;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
public interface DynamicOutbreakMapper {
    /**
     * 动态爆发
     * @param dynamicOutbreakVo 查询参数pojo
     * @return address，以及相同address的count
     * @throws Exception
     */
    List<DynamicOutbreakRe> selectAddressByYearMonth(DynamicOutbreakVo dynamicOutbreakVo) throws Exception;




}
