package com.zxh.ssm.module.download.service.impl;

import com.zxh.ssm.module.download.mapper.DistrictInformationMapper;
import com.zxh.ssm.module.download.pojo.FourLevelLinkage;
import com.zxh.ssm.module.download.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/16.
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictInformationMapper districtInformationMapper;

    public List<FourLevelLinkage> getProvinces() throws Exception {
        return districtInformationMapper.selectProvinces();
    }

    public List<FourLevelLinkage> getCities(int upId) throws Exception {
        return districtInformationMapper.selectCities(upId);
    }

    public List<FourLevelLinkage> getCounties(int upId) throws Exception {
        return districtInformationMapper.selectCounties(upId);
    }

    public List<FourLevelLinkage> getVillages(int upId) throws Exception {
        return districtInformationMapper.selectVillages(upId);
    }
}
