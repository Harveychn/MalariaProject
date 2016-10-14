package com.zxh.ssm.module.download.service.impl;

import com.zxh.ssm.module.download.mapper.CategoryFieldsMapper;
import com.zxh.ssm.module.download.mapper.IndicatorByFieldsMapper;
import com.zxh.ssm.module.download.pojo.CategoryFieldsRe;
import com.zxh.ssm.module.download.pojo.DownloadParamVo;
import com.zxh.ssm.module.download.pojo.GetDownData;
import com.zxh.ssm.module.download.service.DownloadDBDataService;
import com.zxh.ssm.module.user.mapper.IndicatorMapper;
import com.zxh.ssm.module.user.pojo.Indicator;
import com.zxh.ssm.module.user.pojo.IndicatorExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
@Service
public class DownloadDBDataServiceImpl implements DownloadDBDataService {
    @Resource
    private CategoryFieldsMapper categoryFieldsMapper;
    @Resource
    private IndicatorByFieldsMapper indicatorByFieldsMapper;

    public List<CategoryFieldsRe> getFieldsNameDownload(String category) throws Exception {
        return categoryFieldsMapper.selectCategoryFields(category);
    }

    public void getDownloadData(DownloadParamVo downloadParamVo) throws Exception {
        GetDownData paramsClass = new GetDownData();
        paramsClass.setIndicators(getIndicators(downloadParamVo));
        paramsClass.setBeginYear(downloadParamVo.getBeginYear());
        paramsClass.setEndYear(downloadParamVo.getEndYear());
        paramsClass.setMinAge(downloadParamVo.getMinAge());
        paramsClass.setMaxAge(downloadParamVo.getMaxAge());
        paramsClass.setLocation(downloadParamVo.getLocation());
        paramsClass.setSex(downloadParamVo.getSex());

    }

    private List<Indicator> getIndicators(DownloadParamVo downloadParamVo) throws Exception {
        List<String> selectedFields = downloadParamVo.getSelectedName();
        List<Indicator> indicators = indicatorByFieldsMapper.selectIndicatorByFields(selectedFields);


        for (int i = 0; i < indicators.size(); i++) {
            Indicator current = indicators.get(i);
        }

        return indicators;
    }

}
