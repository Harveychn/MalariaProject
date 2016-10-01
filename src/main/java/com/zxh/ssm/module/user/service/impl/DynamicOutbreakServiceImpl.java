package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.user.mapper.DynamicOutbreakMapper;
import com.zxh.ssm.module.user.pojo.DynamicOutbreakVo;
import com.zxh.ssm.module.user.service.DynamicOutbreakService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
@Service
public class DynamicOutbreakServiceImpl implements DynamicOutbreakService{
    @Resource
    private DynamicOutbreakMapper dynamicOutbreakMapper;
    @Override
    public List<String> findAddressList(DynamicOutbreakVo dynamicOutbreakVo) throws Exception {
        return dynamicOutbreakMapper.selectAddressByYearMonth(dynamicOutbreakVo);
    }
}
