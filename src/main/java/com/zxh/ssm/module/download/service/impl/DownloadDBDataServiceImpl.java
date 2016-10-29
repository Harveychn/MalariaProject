package com.zxh.ssm.module.download.service.impl;

import com.zxh.ssm.module.download.mapper.CategoryFieldsMapper;
import com.zxh.ssm.module.download.mapper.IndicatorByFieldsMapper;
import com.zxh.ssm.module.download.pojo.*;
import com.zxh.ssm.module.download.service.DownloadDBDataService;
import com.zxh.ssm.module.whole.pojo.Indicator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

    /**
     * 根据数据类别获取展示的字段
     *
     * @param category
     * @return
     * @throws Exception
     */
    public List<CategoryFieldsRe> getFieldsNameDownload(String category) throws Exception {
        return categoryFieldsMapper.selectCategoryFields(category);
    }

    /**
     * 根据用户提交的筛选及选择的字段名来下载数据
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    public HSSFWorkbook downloadData(DownloadParamVo downloadParamVo) throws Exception {
        List<Map<String, Object>> totalData = new ArrayList<>();
        List<String> selectedFields = downloadParamVo.getSelectedName();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        if ("Disease".equals(downloadParamVo.getCategory().trim())) {
            totalData = getDiseaseIndicators(downloadParamVo);
        } else if ("Weather".equals(downloadParamVo.getCategory().trim())) {
            totalData = getWeatherIndicators(downloadParamVo);
        } else if ("Station".equals(downloadParamVo.getCategory().trim())) {
            totalData = getStationIndicators(downloadParamVo);
        }
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("下载数据");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCells[] = new HSSFCell[selectedFields.size()];
        //第一行，设置字段名
        for (int i = 0; i < selectedFields.size(); i++) {
            hssfCells[i] = hssfRow.createCell(i);
            hssfCells[i].setCellValue(selectedFields.get(i));
        }
        //第二行开始，设置每一行的数据
        for (int i = 0, rowNum = 1; i < totalData.size(); i++, rowNum++) {
            HSSFRow currentRow = hssfSheet.createRow(rowNum);
            HSSFCell cells[] = new HSSFCell[selectedFields.size()];
            Map<String, Object> currentData = totalData.get(i);
            //根据字段名来获取数据，并设置数据
            for (int cellNum = 0; cellNum < selectedFields.size(); cellNum++) {
                String currentKey = selectedFields.get(cellNum);
                cells[cellNum] = currentRow.createCell(cellNum);
                //单元格数据为空时，设置为“ ”
                if (null == currentData.get(currentKey)) {
                    cells[cellNum].setCellValue(" ");
                    continue;
                }
                cells[cellNum].setCellValue(currentData.get(currentKey).toString());
            }
        }
        return hssfWorkbook;

    }

    /**
     * 疟疾数据
     * 获取mysql中选择好的字段及筛选字段的数据
     * 同时可以做展示数据用
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getDiseaseIndicators(DownloadParamVo downloadParamVo) throws Exception {
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
            selectFieldSet.add(" " + current.getTablealias() + "." + current.getFieldname() + " AS '" + current.getDisplayname() + "'");
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
            //地区 (应该区分为四级 省、市、镇、村)
            if (null != downloadParamVo.getAddrLevel1()) {
                whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel1() + "%')");
                if (null != downloadParamVo.getAddrLevel2()) {
                    whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel2() + "%')");
                    if (null != downloadParamVo.getAddrLevel3()) {
                        whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel3() + "%')");
                        if (null != downloadParamVo.getAddrLevel4()) {
                            whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel4() + "%')");
                        }
                    }
                }
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
        List<Map<String, Object>> resultMapList = indicatorByFieldsMapper.selectData(sqlQuery);
        return resultMapList;
    }

    /**
     * 气候数据
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getWeatherIndicators(DownloadParamVo downloadParamVo) throws Exception {
        List<String> selectedDisplayFields = downloadParamVo.getSelectedName();
        List<Indicator> indicators = indicatorByFieldsMapper.selectIndicatorByFields(selectedDisplayFields);
        Set<String> selectFieldSet = new HashSet<>();
        Set<String> fromTableSet = new HashSet<>();
        Set<String> tableSet = new HashSet<>();
        Set<String> whereSet = new HashSet<>();
        for (int i = 0; i < indicators.size(); i++) {
            Indicator current = indicators.get(i);
            selectFieldSet.add(" " + current.getTablealias() + "." + current.getFieldname() + " AS '" + current.getDisplayname() + "'");
            fromTableSet.add(" " + current.getBelongtable() + " " + current.getTablealias());
            if (!tableSet.contains(current.getBelongtable())) {
                tableSet.add(current.getBelongtable());
            }
        }
        //筛选条件
        if (tableSet.contains("weather_data")) {
            if (0 != downloadParamVo.getBeginYear() && 0 != downloadParamVo.getEndYear()) {
                whereSet.add(" AND wd.weatherYear BETWEEN " + downloadParamVo.getBeginYear() + " AND " + downloadParamVo.getEndYear());
            }
            if (tableSet.contains("meteorological_station_insformation")) {
                whereSet.add(" AND wd.districtStationNum=msi.districtStationNum");
            }
        }
//        if (tableSet.contains("patient_information")) {
//            //时间区间
//            if (0 != downloadParamVo.getBeginYear() && 0 != downloadParamVo.getEndYear()) {
//                whereSet.add(" AND pi.year BETWEEN " + downloadParamVo.getBeginYear() + " AND " + downloadParamVo.getEndYear());
//            }
//            //地区 (应该区分为四级 省、市、镇、村)
//            if (null != downloadParamVo.getAddrLevel1()) {
//                whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel1() + "%')");
//                if (null != downloadParamVo.getAddrLevel2()) {
//                    whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel2() + "%')");
//                    if (null != downloadParamVo.getAddrLevel3()) {
//                        whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel3() + "%')");
//                        if (null != downloadParamVo.getAddrLevel4()) {
//                            whereSet.add(" AND (pi.address LIKE '%" + downloadParamVo.getAddrLevel4() + "%')");
//                        }
//                    }
//                }
//            }
//        }

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
        List<Map<String, Object>> resultMapList = indicatorByFieldsMapper.selectData(sqlQuery);
        return resultMapList;
    }

    /**
     * 观测站信息
     *
     * @param downloadParamVo
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getStationIndicators(DownloadParamVo downloadParamVo) throws Exception {
        List<String> selectedDisplayFields = downloadParamVo.getSelectedName();
        List<Indicator> indicators = indicatorByFieldsMapper.selectIndicatorByFields(selectedDisplayFields);
        Set<String> selectFieldSet = new HashSet<>();
        Set<String> fromTableSet = new HashSet<>();
        Set<String> whereSet = new HashSet<>();
        Set<String> tableSet = new HashSet<>();
        for (int i = 0; i < indicators.size(); i++) {
            Indicator current = indicators.get(i);
            fromTableSet.add(" " + current.getBelongtable() + " " + current.getTablealias());
            selectFieldSet.add(" " + current.getTablealias() + "." + current.getFieldname() + " AS '" + current.getDisplayname() + "'");
            if (!tableSet.contains(current.getBelongtable())) {
                tableSet.add(current.getBelongtable());
            }
        }
//        //筛选条件
//        if (tableSet.contains("meteorological_station_insformation")) {
//            if (0 != downloadParamVo.getBeginYear() && 0 != downloadParamVo.getEndYear()) {
//                whereSet.add(" AND wd.weatherYear BETWEEN " + downloadParamVo.getBeginYear() + " AND " + downloadParamVo.getEndYear());
//            }
//            if (tableSet.contains("meteorological_station_insformation")) {
//                whereSet.add(" AND wd.districtStationNum=msi.districtStationNum");
//            }
//        }
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
        try {
            sqlQuery.setSelect(selectBuilder.toString());
        } catch (Exception e) {
            System.out.println("selectBuilderException 信息：" + e.getMessage());
        }
        try {
            sqlQuery.setFrom(fromBuilder.toString());
        } catch (Exception e) {
            System.out.println("fromBuilder Exception 信息：" + e.getMessage());
        }
        try {
            sqlQuery.setWhere(whereBuilder.toString());
        } catch (Exception e) {
            System.out.println("whereBuilder Exception 信息：" + e.getMessage());
        }
        List<Map<String, Object>> resultMapList = indicatorByFieldsMapper.selectData(sqlQuery);
        return resultMapList;
    }
}
