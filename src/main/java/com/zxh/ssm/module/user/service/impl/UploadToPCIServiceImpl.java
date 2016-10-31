package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.whole.mapper.PatientCasesInformationMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToPCIService;
import com.zxh.ssm.module.whole.pojo.PatientCasesInformation;
import com.zxh.ssm.module.whole.pojo.PatientCasesInformationKey;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/10.
 */
@Service
public class UploadToPCIServiceImpl implements UploadToPCIService {

    @Resource
    private PatientCasesInformationMapper patientCasesInformationMapper;

    private RowDataSorted<ErrorPatientCaseInfor<String>, PatientCasesInformation> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<PatientCasesInformation> patientCasesInformations = new ArrayList<>();
        List<ErrorPatientCaseInfor<String>> errorPatientCaseInfors = new ArrayList<>();
        PatientCasesInformation patientCasesInformation = null;
        ErrorPatientCaseInfor<String> errorPatientCaseInfor = null;
        InputStream is = new FileInputStream(path);
        if (path.endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                for (int numRow = 1; numRow <= hssfSheet.getLastRowNum(); numRow++) {
                    HSSFRow hssfRow = hssfSheet.getRow(numRow);
                    if (hssfRow != null) {
                        patientCasesInformation = new PatientCasesInformation();
                        errorPatientCaseInfor = new ErrorPatientCaseInfor<>();
                        HSSFCell year = hssfRow.getCell(0);
                        HSSFCell cardId = hssfRow.getCell(1);
                        HSSFCell caseCategory1 = hssfRow.getCell(2);
                        HSSFCell caseCategory2 = hssfRow.getCell(3);
                        HSSFCell illDate = hssfRow.getCell(4);
                        HSSFCell confirmDate = hssfRow.getCell(5);
                        HSSFCell deathDate = hssfRow.getCell(6);
                        HSSFCell diseaseName = hssfRow.getCell(7);
                        HSSFCell fillCardDoc = hssfRow.getCell(8);
                        HSSFCell fillCardDate = hssfRow.getCell(9);
                        HSSFCell notes = hssfRow.getCell(10);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                patientCasesInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                patientCasesInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(caseCategory1).equals(".")) {
                                    patientCasesInformation.setCasecategory1(excelValue.getValue(caseCategory1));
                                }
                                if (!excelValue.getValue(caseCategory2).equals(".")) {
                                    patientCasesInformation.setCasecategory2(excelValue.getValue(caseCategory2));
                                }
                                if (!excelValue.getValue(illDate).equals(".")) {
                                    patientCasesInformation.setIlldate(new SimpleDateFormat("yyyy-MM-dd").parse(excelValue.getValue(illDate)));
                                } else {
                                    patientCasesInformation.setIlldate(null);
                                }
                                if (!excelValue.getValue(confirmDate).equals(".")) {
                                    patientCasesInformation.setConfirmdate(excelValue.getValue(confirmDate));
                                }
                                if (!excelValue.getValue(deathDate).equals(".")) {
                                    patientCasesInformation.setDeathdate(excelValue.getValue(deathDate));
                                }
                                if (!excelValue.getValue(diseaseName).equals(".")) {
                                    patientCasesInformation.setDiseasename(excelValue.getValue(diseaseName));
                                }
                                if (!excelValue.getValue(fillCardDoc).equals(".")) {
                                    patientCasesInformation.setFillcarddoc(excelValue.getValue(fillCardDoc));
                                }
                                if (!excelValue.getValue(fillCardDate).equals(".")) {
                                    patientCasesInformation.setFillcarddate(new SimpleDateFormat("yyyy-MM-dd").parse(excelValue.getValue(fillCardDate)));
                                } else {
                                    patientCasesInformation.setFillcarddate(null);
                                }
                                if (!excelValue.getValue(notes).equals(".")) {
                                    patientCasesInformation.setNotes(excelValue.getValue(notes));
                                }
                                patientCasesInformations.add(patientCasesInformation);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("【！读取数据时出了异常】 message:" + e.getMessage());
                            errorPatientCaseInfor.setYear(excelValue.getValue(year));
                            errorPatientCaseInfor.setCardid(excelValue.getValue(cardId));
                            errorPatientCaseInfor.setCasecategory1(excelValue.getValue(caseCategory1));
                            errorPatientCaseInfor.setCasecategory2(excelValue.getValue(caseCategory2));
                            errorPatientCaseInfor.setIlldate(excelValue.getValue(illDate));
                            errorPatientCaseInfor.setConfirmdate(excelValue.getValue(confirmDate));
                            errorPatientCaseInfor.setDeathdate(excelValue.getValue(deathDate));
                            errorPatientCaseInfor.setDiseasename(excelValue.getValue(diseaseName));
                            errorPatientCaseInfor.setFillcarddoc(excelValue.getValue(fillCardDoc));
                            errorPatientCaseInfor.setFillcarddate(excelValue.getValue(fillCardDate));
                            errorPatientCaseInfor.setNotes(excelValue.getValue(notes));
                            errorPatientCaseInfors.add(errorPatientCaseInfor);
                            continue;
                        }
                    }
                    continue;
                }
            }
        } else if (path.endsWith(".xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = workbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                for (int numRow = 1; numRow <= xssfSheet.getLastRowNum(); numRow++) {
                    XSSFRow xssfRow = xssfSheet.getRow(numRow);
                    if (xssfRow != null) {
                        patientCasesInformation = new PatientCasesInformation();
                        errorPatientCaseInfor = new ErrorPatientCaseInfor<>();
                        XSSFCell year = xssfRow.getCell(0);
                        XSSFCell cardId = xssfRow.getCell(1);
                        XSSFCell caseCategory1 = xssfRow.getCell(2);
                        XSSFCell caseCategory2 = xssfRow.getCell(3);
                        XSSFCell illDate = xssfRow.getCell(4);
                        XSSFCell confirmDate = xssfRow.getCell(5);
                        XSSFCell deathDate = xssfRow.getCell(6);
                        XSSFCell diseaseName = xssfRow.getCell(7);
                        XSSFCell fillCardDoc = xssfRow.getCell(8);
                        XSSFCell fillCardDate = xssfRow.getCell(9);
                        XSSFCell notes = xssfRow.getCell(10);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                patientCasesInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                patientCasesInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(caseCategory1).equals(".")) {
                                    patientCasesInformation.setCasecategory1(excelValue.getValue(caseCategory1));
                                }
                                if (!excelValue.getValue(caseCategory2).equals(".")) {
                                    patientCasesInformation.setCasecategory2(excelValue.getValue(caseCategory2));
                                }
                                if (!excelValue.getValue(illDate).equals(".")) {
                                    patientCasesInformation.setIlldate(new SimpleDateFormat("yyyy-MM-dd").parse(excelValue.getValue(illDate)));
                                } else {
                                    patientCasesInformation.setIlldate(null);
                                }
                                if (!excelValue.getValue(confirmDate).equals(".")) {
                                    patientCasesInformation.setConfirmdate(excelValue.getValue(confirmDate));
                                }
                                if (!excelValue.getValue(deathDate).equals(".")) {
                                    patientCasesInformation.setDeathdate(excelValue.getValue(deathDate));
                                }
                                if (!excelValue.getValue(diseaseName).equals(".")) {
                                    patientCasesInformation.setDiseasename(excelValue.getValue(diseaseName));
                                }
                                if (!excelValue.getValue(fillCardDoc).equals(".")) {
                                    patientCasesInformation.setFillcarddoc(excelValue.getValue(fillCardDoc));
                                }
                                if (!excelValue.getValue(fillCardDate).equals(".")) {
                                    patientCasesInformation.setFillcarddate(new SimpleDateFormat("yyyy-MM-dd").parse(excelValue.getValue(fillCardDate)));
                                } else {
                                    patientCasesInformation.setFillcarddate(null);
                                }
                                if (!excelValue.getValue(notes).equals(".")) {
                                    patientCasesInformation.setNotes(excelValue.getValue(notes));
                                }
                                patientCasesInformations.add(patientCasesInformation);
                                patientCasesInformation = null;
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("【！读取数据时出了异常】 message:" + e.getMessage());
                            errorPatientCaseInfor.setYear(excelValue.getValue(year));
                            errorPatientCaseInfor.setCardid(excelValue.getValue(cardId));
                            errorPatientCaseInfor.setCasecategory1(excelValue.getValue(caseCategory1));
                            errorPatientCaseInfor.setCasecategory2(excelValue.getValue(caseCategory2));
                            errorPatientCaseInfor.setIlldate(excelValue.getValue(illDate));
                            errorPatientCaseInfor.setConfirmdate(excelValue.getValue(confirmDate));
                            errorPatientCaseInfor.setDeathdate(excelValue.getValue(deathDate));
                            errorPatientCaseInfor.setDiseasename(excelValue.getValue(diseaseName));
                            errorPatientCaseInfor.setFillcarddate(excelValue.getValue(fillCardDate));
                            errorPatientCaseInfor.setFillcarddoc(excelValue.getValue(fillCardDoc));
                            errorPatientCaseInfor.setNotes(excelValue.getValue(notes));
                            errorPatientCaseInfors.add(errorPatientCaseInfor);
                            errorPatientCaseInfor = null;
                            continue;
                        }
                    }
                    continue;
                }
            }
        }
        RowDataSorted<ErrorPatientCaseInfor<String>, PatientCasesInformation> rowDataSorted = new RowDataSorted<>();
        rowDataSorted.setKeyNotNullList(patientCasesInformations);
        rowDataSorted.setErrorReadingList(errorPatientCaseInfors);
        return rowDataSorted;
    }

    public UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> saveDataToPCI(String path) throws Exception {
        RowDataSorted<ErrorPatientCaseInfor<String>, PatientCasesInformation> rowDataSorted = getExcelData(path);
        List<PatientCasesInformation> excelDataList = rowDataSorted.getKeyNotNullList();
        List<ErrorPatientCaseInfor<String>> errorReadingList = rowDataSorted.getErrorReadingList();
        UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> uploadDBMessage = new UploadDBMessage<>();
        uploadDBMessage.setErrorReadingList(errorReadingList);
        PatientCasesInformation excelRowData = null;
        PatientCasesInformationKey patientCasesInformationKey = new PatientCasesInformationKey();
        List<PatientCasesInformation> updateDataList = new ArrayList<>();
        List<PatientCasesInformation> insertDataList = new ArrayList<>();
        List<PatientCasesInformation> errorOperatingList = new ArrayList<>();
        for (int index = 0; index < excelDataList.size(); index++) {
            excelRowData = excelDataList.get(index);
            if (null == excelRowData.getYear() || null == excelRowData.getCardid()) {
                continue;
            }
            patientCasesInformationKey.setYear(excelRowData.getYear());
            patientCasesInformationKey.setCardid(excelRowData.getCardid());
            if (patientCasesInformationMapper.selectByPrimaryKey(patientCasesInformationKey) != null) {
                updateDataList.add(excelRowData);
                continue;
            }
            insertDataList.add(excelRowData);
            continue;
        }
        int insertNum = 0;
        for (int index = 0; index < insertDataList.size(); index++) {
            PatientCasesInformation current = insertDataList.get(index);
            try {
                if (patientCasesInformationMapper.insert(current) == 1) {
                    insertNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("插入patient_cases_information时主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("插入patient_cases_information时出现异常 信息：" + e.getMessage());
                errorOperatingList.add(current);
            }
        }
        int updateNum = 0;
        for (int index = 0; index < updateDataList.size(); index++) {
            PatientCasesInformation current = updateDataList.get(index);
            try {
                if (patientCasesInformationMapper.updateByPrimaryKey(current) == 1) {
                    updateNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("更新patient_cases_information时主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("更新patient_cases_information时出现异常 信息：" + e.getMessage());
                errorOperatingList.add(current);
            }
        }
        uploadDBMessage.setSuccessInsertNum(insertNum);
        uploadDBMessage.setSuccessUpdateNum(updateNum);
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        return uploadDBMessage;
    }
}
