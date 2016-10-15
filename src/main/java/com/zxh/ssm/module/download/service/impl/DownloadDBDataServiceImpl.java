package com.zxh.ssm.module.download.service.impl;

import com.zxh.ssm.module.download.mapper.CategoryFieldsMapper;
import com.zxh.ssm.module.download.mapper.IndicatorByFieldsMapper;
import com.zxh.ssm.module.download.pojo.*;
import com.zxh.ssm.module.download.service.DownloadDBDataService;
import com.zxh.ssm.module.user.mapper.IndicatorMapper;
import com.zxh.ssm.module.user.pojo.Indicator;
import com.zxh.ssm.module.user.pojo.IndicatorExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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

    }

    private List<Map<String, List<String>>> getIndicators(DownloadParamVo downloadParamVo) throws Exception {
        //用户选择的中文字段
        List<String> selectedDisplayFields = downloadParamVo.getSelectedName();
        List<Indicator> indicators = indicatorByFieldsMapper.selectIndicatorByFields(selectedDisplayFields);
        Set<String> selectFieldSet = new HashSet<>();
        Set<String> fromTableSet = new HashSet<>();
        Set<String> tableSet = new HashSet<>();
        Set<String> whereSet = new HashSet<>();
        //patient_information表必有
        tableSet.add("patient_information");
        for (int i = 0; i < indicators.size(); i++) {
            Indicator current = indicators.get(i);
            selectFieldSet.add(" " + current.getTablealias() + "." + current.getFieldname() + " AS " + current.getDisplayname());
            fromTableSet.add(" " + current.getBelongtable() + " " + current.getTablealias());
            if (!tableSet.contains(current.getBelongtable())) {
                tableSet.add(current.getBelongtable());
                //多表连接条件
                whereSet.add(" AND pi.year=" + current.getTablealias() + ".year" + " AND pi.cardID=" + current.getTablealias() + ".cardID ");
            }
        }
        //筛选条件
        if (tableSet.contains("patient_information")) {
            //时间区间
            if (0 != downloadParamVo.getBeginYear() && 0 != downloadParamVo.getEndYear()) {
                whereSet.add(" AND pi.year BETWEEN " + downloadParamVo.getBeginYear() + " AND " + downloadParamVo.getEndYear());
            }
            //性别   0表示全部性别 1表示男 2表示女
            if (0 != downloadParamVo.getSex()) {
                if (1 == downloadParamVo.getSex()) {
                    whereSet.add(" AND pi.sex = '男' ");
                } else if (2 == downloadParamVo.getSex()) {
                    whereSet.add(" AND pi.sex = '女' ");
                }
            }
            //年龄
            if (0 != downloadParamVo.getMinAge() && 0 != downloadParamVo.getMaxAge()) {
                whereSet.add(" AND (pi.year-YEAR(pi.birthday)+1) BETWEEN " + downloadParamVo.getMinAge() + " AND " + downloadParamVo.getMaxAge());
            }
            //地区 (应该区分为省市区镇乡)
            if (null != downloadParamVo.getLocation()) {
                whereSet.add(" AND ");
            }
        }

        StringBuilder selectBuilder = new StringBuilder();
        for (Iterator<String> it = selectFieldSet.iterator(); it.hasNext(); ) {
            selectBuilder.append(it.next());
            if (it.hasNext()) {
                selectBuilder.append(",");
            }
        }
        StringBuilder fromBuilder = new StringBuilder();
        for (Iterator<String> it = fromTableSet.iterator(); it.hasNext(); ) {
            fromBuilder.append(it.next());
            if (it.hasNext()) {
                fromBuilder.append(",");
            }
        }

        StringBuilder whereBuilder = new StringBuilder();
        for (Iterator<String> it = whereSet.iterator(); it.hasNext(); ) {
            whereBuilder.append(it.next());
            if (it.hasNext()) {
                whereBuilder.append(" ");
            }
        }
        SQLQuery sqlQuery = new SQLQuery();
        sqlQuery.setSelect(selectBuilder.toString());
        sqlQuery.setFrom(fromBuilder.toString());
        sqlQuery.setWhere(whereBuilder.toString());
        List<Map<String, List<String>>> resultMapList = indicatorByFieldsMapper.selectData(sqlQuery);
        return resultMapList;
    }

}
