package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.user.mapper.MeteorologicalStationInsformationMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToObserStaService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/12.
 */
@Service
public class UploadToObserStaServiceImpl implements UploadToObserStaService{
    @Resource
    private MeteorologicalStationInsformationMapper meteorologicalStationInsformationMapper;

    private RowDataSorted<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<ErrorObserStaInfor<String>> errorObserStaInfors = new ArrayList<>();
        List<MeteorologicalStationInsformation> meteorologicalStationInsformations = new ArrayList<>();
        MeteorologicalStationInsformation meteorologicalStationInsformation = null;
        ErrorObserStaInfor<String> errorObserStaInfor = null;
        InputStream inputStream = new FileInputStream(path);
        if (path.endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                for (int numRow = 1; numRow <= hssfSheet.getLastRowNum(); numRow++) {
                    HSSFRow hssfRow = hssfSheet.getRow(numRow);
                    if (hssfRow != null) {
                        errorObserStaInfor = new ErrorObserStaInfor<>();
                        meteorologicalStationInsformation = new MeteorologicalStationInsformation();
                        HSSFCell districtStationNum = hssfRow.getCell(0);
                        HSSFCell stationName = hssfRow.getCell(1);
                        HSSFCell provines = hssfRow.getCell(2);
                        HSSFCell lat = hssfRow.getCell(3);
                        HSSFCell lng = hssfRow.getCell(4);
                        HSSFCell altitude = hssfRow.getCell(5);
                        HSSFCell startYear = hssfRow.getCell(6);
                        HSSFCell startMonth = hssfRow.getCell(7);
                        HSSFCell endYear = hssfRow.getCell(8);
                        HSSFCell endMonth = hssfRow.getCell(9);
                        HSSFCell lackMeasurement = hssfRow.getCell(0);
                        try {
                            if (!excelValue.getValue(districtStationNum).equals(".")) {
                                meteorologicalStationInsformation.setDistrictstationnum(Integer.parseInt(excelValue.getValue(districtStationNum)));
                                meteorologicalStationInsformation.setStationname(excelValue.getValue(stationName));
                                meteorologicalStationInsformation.setProvinves(excelValue.getValue(provines));
                                if (!excelValue.getValue(lat).equals(".")) {
                                    meteorologicalStationInsformation.setLat(Integer.parseInt(excelValue.getValue(lat)));
                                }
                                if (!excelValue.getValue(lng).equals(".")) {
                                    meteorologicalStationInsformation.setLng(Integer.parseInt(excelValue.getValue(lng)));
                                }
                                if (!excelValue.getValue(altitude).equals(".")) {
                                    meteorologicalStationInsformation.setAltitude(Integer.parseInt(excelValue.getValue(altitude)));
                                }
                                if (!excelValue.getValue(startYear).equals(".")) {
                                    meteorologicalStationInsformation.setStartyear(Integer.parseInt(excelValue.getValue(startYear)));
                                }
                                if (!excelValue.getValue(startMonth).equals(".")) {
                                    meteorologicalStationInsformation.setStartmonth(Integer.parseInt(excelValue.getValue(startMonth)));
                                }
                                if (!excelValue.getValue(endYear).equals(".")) {
                                    meteorologicalStationInsformation.setEndyear(Integer.parseInt(excelValue.getValue(endYear)));
                                }
                                if (!excelValue.getValue(endMonth).equals(".")) {
                                    meteorologicalStationInsformation.setEndmonth(Integer.parseInt(excelValue.getValue(endMonth)));
                                }
                                if (!excelValue.getValue(lackMeasurement).equals(".")) {
                                    meteorologicalStationInsformation.setLackmeasurement(excelValue.getValue(lackMeasurement));
                                }
                                meteorologicalStationInsformations.add(meteorologicalStationInsformation);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("数据上传到meteorologicalStationInsformation时出现异常 信息：" + e.getMessage());
                            errorObserStaInfor.setDistrictStationNum(excelValue.getValue(districtStationNum));
                            errorObserStaInfor.setStationName(excelValue.getValue(stationName));
                            errorObserStaInfor.setProvinves(excelValue.getValue(provines));
                            errorObserStaInfor.setLat(excelValue.getValue(lat));
                            errorObserStaInfor.setLng(excelValue.getValue(lng));
                            errorObserStaInfor.setAltitude(excelValue.getValue(altitude));
                            errorObserStaInfor.setStartYear(excelValue.getValue(startYear));
                            errorObserStaInfor.setStartMonth(excelValue.getValue(startMonth));
                            errorObserStaInfor.setEndYear(excelValue.getValue(endYear));
                            errorObserStaInfor.setEndMonth(excelValue.getValue(endMonth));
                            errorObserStaInfor.setLackMeasurement(excelValue.getValue(lackMeasurement));
                            errorObserStaInfors.add(errorObserStaInfor);
                            continue;
                        }
                    }
                }
            }
        } else if (path.endsWith(".xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = workbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                for (int numRow = 1; numRow <= xssfSheet.getLastRowNum(); numRow++) {
                    XSSFRow xssfRow = xssfSheet.getRow(numRow);
                    if (xssfRow != null) {
                        errorObserStaInfor = new ErrorObserStaInfor<>();
                        meteorologicalStationInsformation = new MeteorologicalStationInsformation();
                        XSSFCell districtStationNum = xssfRow.getCell(0);
                        XSSFCell stationName = xssfRow.getCell(1);
                        XSSFCell provines = xssfRow.getCell(2);
                        XSSFCell lat = xssfRow.getCell(3);
                        XSSFCell lng = xssfRow.getCell(4);
                        XSSFCell altitude = xssfRow.getCell(5);
                        XSSFCell startYear = xssfRow.getCell(6);
                        XSSFCell startMonth = xssfRow.getCell(7);
                        XSSFCell endYear = xssfRow.getCell(8);
                        XSSFCell endMonth = xssfRow.getCell(9);
                        XSSFCell lackMeasurement = xssfRow.getCell(0);
                        try {
                            if (!excelValue.getValue(districtStationNum).equals(".")) {
                                meteorologicalStationInsformation.setDistrictstationnum(Integer.parseInt(excelValue.getValue(districtStationNum)));
                                meteorologicalStationInsformation.setStationname(excelValue.getValue(stationName));
                                meteorologicalStationInsformation.setProvinves(excelValue.getValue(provines));

                                meteorologicalStationInsformations.add(meteorologicalStationInsformation);
                                if (!excelValue.getValue(lat).equals(".")) {
                                    meteorologicalStationInsformation.setLat(Integer.parseInt(excelValue.getValue(lat)));
                                }
                                if (!excelValue.getValue(lng).equals(".")) {
                                    meteorologicalStationInsformation.setLng(Integer.parseInt(excelValue.getValue(lng)));
                                }
                                if (!excelValue.getValue(altitude).equals(".")) {
                                    meteorologicalStationInsformation.setAltitude(Integer.parseInt(excelValue.getValue(altitude)));
                                }
                                if (!excelValue.getValue(startYear).equals(".")) {
                                    meteorologicalStationInsformation.setStartyear(Integer.parseInt(excelValue.getValue(startYear)));
                                }
                                if (!excelValue.getValue(startMonth).equals(".")) {
                                    meteorologicalStationInsformation.setStartmonth(Integer.parseInt(excelValue.getValue(startMonth)));
                                }
                                if (!excelValue.getValue(endYear).equals(".")) {
                                    meteorologicalStationInsformation.setEndyear(Integer.parseInt(excelValue.getValue(endYear)));
                                }
                                if (!excelValue.getValue(endMonth).equals(".")) {
                                    meteorologicalStationInsformation.setEndmonth(Integer.parseInt(excelValue.getValue(endMonth)));
                                }
                                if (!excelValue.getValue(lackMeasurement).equals(".")) {
                                    meteorologicalStationInsformation.setLackmeasurement(excelValue.getValue(lackMeasurement));
                                }
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("数据上传到meteorologicalStationInsformation时出现异常 信息：" + e.getMessage());
                            errorObserStaInfor.setDistrictStationNum(excelValue.getValue(districtStationNum));
                            errorObserStaInfor.setLackMeasurement(excelValue.getValue(lackMeasurement));
                            errorObserStaInfor.setStationName(excelValue.getValue(stationName));
                            errorObserStaInfor.setProvinves(excelValue.getValue(provines));
                            errorObserStaInfor.setLat(excelValue.getValue(lat));
                            errorObserStaInfor.setLng(excelValue.getValue(lng));
                            errorObserStaInfor.setAltitude(excelValue.getValue(altitude));
                            errorObserStaInfor.setStartYear(excelValue.getValue(startYear));
                            errorObserStaInfor.setStartMonth(excelValue.getValue(startMonth));
                            errorObserStaInfor.setEndYear(excelValue.getValue(endYear));
                            errorObserStaInfor.setEndMonth(excelValue.getValue(endMonth));
                            errorObserStaInfors.add(errorObserStaInfor);
                            continue;
                        }
                    }
                }
            }
        }
        RowDataSorted<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> rowDataSorted
                = new RowDataSorted<>();
        rowDataSorted.setKeyNotNullList(meteorologicalStationInsformations);
        rowDataSorted.setErrorReadingList(errorObserStaInfors);
        return rowDataSorted;
    }

    public UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> saveDataToObserSta(String path) throws Exception {
        RowDataSorted<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> rowDataSorted
                = getExcelData(path);
        List<ErrorObserStaInfor<String>> errorReadingList = rowDataSorted.getErrorReadingList();
        List<MeteorologicalStationInsformation> errorOperatingList = new ArrayList<>();
        List<MeteorologicalStationInsformation> excelRows = rowDataSorted.getKeyNotNullList();
        List<MeteorologicalStationInsformation> insertList = new ArrayList<>();
        List<MeteorologicalStationInsformation> updateList = new ArrayList<>();
        MeteorologicalStationInsformation rowData = null;
        for (int i = 0; i < excelRows.size(); i++) {
            rowData = excelRows.get(i);
            int key = rowData.getDistrictstationnum();
            if (meteorologicalStationInsformationMapper.selectByPrimaryKey(key) != null) {
                updateList.add(rowData);
                continue;
            }
            insertList.add(rowData);
        }
        int insertNum = 0;
        for (int i = 0; i < insertList.size(); i++) {
            MeteorologicalStationInsformation current = insertList.get(i);
            try {
                if (meteorologicalStationInsformationMapper.insert(current) == 1) {
                    insertNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("meteorogicalStationInformation插入数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("meteorogicalStationInformation插入数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        int updateNum = 0;
        for (int i = 0; i < updateList.size(); i++) {
            MeteorologicalStationInsformation current = updateList.get(i);
            try {
                if (meteorologicalStationInsformationMapper.updateByPrimaryKey(current) == 1) {
                    updateNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("meteorogicalStationInformation更新数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("meteorogicalStationInformation更新数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> uploadDBMessage
                = new UploadDBMessage<>();
        uploadDBMessage.setErrorReadingList(errorReadingList);
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        uploadDBMessage.setSuccessInsertNum(insertNum);
        uploadDBMessage.setSuccessUpdateNum(updateNum);
        return uploadDBMessage;
    }
}
