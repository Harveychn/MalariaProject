package com.zxh.ssm.module.dynamicOutbreak.service.impl;

import com.zxh.ssm.module.whole.mapper.StandardPositionMapper;
import com.zxh.ssm.module.whole.pojo.StandardPosition;
import com.zxh.ssm.module.whole.pojo.StandardPositionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/19.
 */
@Service
public class DynamicBreakServiceImpl {

    @Resource
    private StandardPositionMapper standardPositionMapper;

    public List<StandardPosition> getStdPosition(String province) throws Exception {
        StandardPositionExample standardPositionExample = new StandardPositionExample();
        standardPositionExample.createCriteria().andProvinceNameLike(province);
        List<StandardPosition> positions = standardPositionMapper.selectByExample(standardPositionExample);
        return positions;
    }
}
