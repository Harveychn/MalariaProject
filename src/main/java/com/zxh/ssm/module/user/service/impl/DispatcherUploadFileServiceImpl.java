package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.user.service.DispatcherUploadFileService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/10.
 */
@Service
public class DispatcherUploadFileServiceImpl implements DispatcherUploadFileService {
    public int getDestination(String filePath) throws Exception {
        int caseNum = 0;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            HSSFSheet hssfSheet = workbook.getSheetAt(0);
            //第一行
            HSSFRow hssfRow = hssfSheet.getRow(0);
            List<String> fieldNames = new ArrayList<>();
            //循环第一行单元格,每一个单元格的值保存到list中
            for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
                String cellValue = hssfRow.getCell(i).getStringCellValue().trim();
                fieldNames.add(i, cellValue);
            }
            caseNum = getSortedNum(fieldNames);
        } else if (filePath.endsWith(".xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet xssfSheet = workbook.getSheetAt(0);
            XSSFRow xssfRow = xssfSheet.getRow(0);
            List<String> fieldNames = new ArrayList<>();
            for (int i = 0; i < xssfRow.getLastCellNum(); i++) {
                String cellValue = xssfRow.getCell(i).getStringCellValue().trim();
                fieldNames.add(i, cellValue);
            }
            caseNum = getSortedNum(fieldNames);
        }
        return caseNum;
    }

    /**
     * 约定
     * 0:card_information
     * 1:上传数据到patient_information
     * 2:上传数据到patient_cases_information
     * 3:case_report_information
     * 4:case_revised_information
     * 5:case_judgement_information
     * 6:weather_data
     * 7:meteorological_station_information
     *
     * @param fieldNames
     * @return
     */
    private int getSortedNum(List<String> fieldNames) throws Exception {
        if (fieldNames.size() == 4) {
            if (fieldNames.get(0).trim().equals("数据信息年份")
                    && fieldNames.get(1).trim().equals("卡片ID")
                    && fieldNames.get(2).trim().equals("卡片编号")
                    && fieldNames.get(3).trim().equals("卡片状态")) {
                return 0;
            }
        }
        if (fieldNames.size() == 12) {
            if (fieldNames.get(0).trim().equals("数据信息年份")
                    && fieldNames.get(1).trim().equals("卡片ID")
                    && fieldNames.get(2).trim().equals("患者姓名")
                    && fieldNames.get(3).trim().equals("性别")
                    && fieldNames.get(4).trim().equals("职业")
                    && fieldNames.get(5).trim().equals("出生日期")
                    && fieldNames.get(6).trim().equals("年龄")
                    && fieldNames.get(7).trim().equals("患者工作单位")
                    && fieldNames.get(8).trim().equals("联系电话")
                    && fieldNames.get(9).trim().equals("病人属于")
                    && fieldNames.get(10).trim().equals("现住详细地址")
                    && fieldNames.get(11).trim().equals("现住地址国标")
                    ) {
                return 1;
            }
            if (fieldNames.get(0).trim().equals("数据信息年份")
                    && fieldNames.get(1).trim().equals("卡片ID")
                    && fieldNames.get(2).trim().equals("订正前病种")
                    && fieldNames.get(3).trim().equals("订正报告时间")
                    && fieldNames.get(4).trim().equals("订正终审时间")
                    && fieldNames.get(5).trim().equals("终审死亡时间")
                    && fieldNames.get(6).trim().equals("订正用户")
                    && fieldNames.get(7).trim().equals("订正用户所属单位")
                    && fieldNames.get(8).trim().equals("删除时间")
                    && fieldNames.get(9).trim().equals("删除用户")
                    && fieldNames.get(10).trim().equals("删除用户所属单位")
                    && fieldNames.get(11).trim().equals("删除原因")
                    ) {
                return 4;
            }
        }
        if (fieldNames.size() == 11) {
            if (fieldNames.get(0).trim().equals("数据信息年份")
                    && fieldNames.get(1).trim().equals("卡片ID")
                    && fieldNames.get(2).trim().equals("病例分类")
                    && fieldNames.get(3).trim().equals("病例分类2")
                    && fieldNames.get(4).trim().equals("发病日期")
                    && fieldNames.get(5).trim().equals("诊断时间")
                    && fieldNames.get(6).trim().equals("死亡日期")
                    && fieldNames.get(7).trim().equals("疾病名称")
                    && fieldNames.get(8).trim().equals("填卡医生")
                    && fieldNames.get(9).trim().equals("医生填卡日期")
                    && fieldNames.get(10).trim().equals("备注")) {
                return 2;
            }
            if (fieldNames.get(0).trim().equals("区站号")
                    && fieldNames.get(1).trim().equals("台站名称")
                    && fieldNames.get(2).trim().equals("省份")
                    && fieldNames.get(3).trim().equals("纬度(度分)")
                    && fieldNames.get(4).trim().equals("经度(度分)")
                    && fieldNames.get(5).trim().equals("海拔高度(0.1米)")
                    && fieldNames.get(6).trim().equals("开始年份")
                    && fieldNames.get(7).trim().equals("开始月份")
                    && fieldNames.get(8).trim().equals("截止年份")
                    && fieldNames.get(9).trim().equals("截止月份")
                    && fieldNames.get(10).trim().equals("缺测情况")) {
                return 7;
            }
        }
        if (fieldNames.size() == 8) {
            if (fieldNames.get(0).trim().equals("数据信息年份")
                    && fieldNames.get(1).trim().equals("卡片ID")
                    && fieldNames.get(2).trim().equals("报告单位地区编码")
                    && fieldNames.get(3).trim().equals("报告单位")
                    && fieldNames.get(4).trim().equals("单位类型")
                    && fieldNames.get(5).trim().equals("报告卡录入时间")
                    && fieldNames.get(6).trim().equals("录卡用户")
                    && fieldNames.get(7).trim().equals("录卡用户所属单位")) {
                return 3;
            }
        }
        if (fieldNames.size() == 6) {
            if (fieldNames.get(0).trim().equals("数据信息年份")
                    && fieldNames.get(1).trim().equals("卡片ID")
                    && fieldNames.get(2).trim().equals("省市审核时间")
                    && fieldNames.get(3).trim().equals("县区审核时间")
                    && fieldNames.get(4).trim().equals("地市审核时间")
                    && fieldNames.get(5).trim().equals("审核状态")) {
                return 5;
            }
        }
        if (fieldNames.size() == 20) {
            if (fieldNames.get(0).trim().equals("区站号")
                    && fieldNames.get(1).trim().equals("年")
                    && fieldNames.get(2).trim().equals("月")
                    && fieldNames.get(3).trim().equals("日")
                    && fieldNames.get(4).trim().equals("20-20时降水量")
                    && fieldNames.get(5).trim().equals("极大风速")
                    && fieldNames.get(6).trim().equals("极大风速的风向")
                    && fieldNames.get(7).trim().equals("平均本站气压")
                    && fieldNames.get(8).trim().equals("平均风速")
                    && fieldNames.get(9).trim().equals("平均气温")
                    && fieldNames.get(10).trim().equals("平均水汽压")
                    && fieldNames.get(11).trim().equals("平均相对湿度")
                    && fieldNames.get(12).trim().equals("日照时数")
                    && fieldNames.get(13).trim().equals("日最低本站气压")
                    && fieldNames.get(14).trim().equals("日最低气温")
                    && fieldNames.get(15).trim().equals("日最高本站气压")
                    && fieldNames.get(16).trim().equals("日最高气温")
                    && fieldNames.get(17).trim().equals("最大风速")
                    && fieldNames.get(18).trim().equals("最大风速的风向")
                    && fieldNames.get(19).trim().equals("最小相对湿度")
                    ) {
                return 6;
            }
        }
        return 120;
    }

}
