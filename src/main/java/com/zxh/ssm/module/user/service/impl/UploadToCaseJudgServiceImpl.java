package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.whole.mapper.CaseJudgmentInformationMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToCaseJudgService;
import com.zxh.ssm.module.whole.pojo.CaseJudgmentInformation;
import com.zxh.ssm.module.whole.pojo.CaseJudgmentInformationKey;
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
 * Created by 郑晓辉 on 2016/10/11.
 */
@Service
public class UploadToCaseJudgServiceImpl implements UploadToCaseJudgService {
    @Resource
    private CaseJudgmentInformationMapper caseJudgmentInformationMapper;

    private RowDataSorted<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<ErrorCaseJudgInfor<String>> errorCaseJudgInfors = new ArrayList<>();
        List<CaseJudgmentInformation> caseJudgmentInformations = new ArrayList<>();
        ErrorCaseJudgInfor<String> errorCaseJudgInfor = null;
        CaseJudgmentInformation caseJudgmentInformation = null;
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
                        caseJudgmentInformation = new CaseJudgmentInformation();
                        errorCaseJudgInfor = new ErrorCaseJudgInfor<>();
                        HSSFCell year = hssfRow.getCell(0);
                        HSSFCell cardId = hssfRow.getCell(1);
                        HSSFCell provinceJudgDate = hssfRow.getCell(2);
                        HSSFCell countyJudgDate = hssfRow.getCell(3);
                        HSSFCell localJudgeDate = hssfRow.getCell(4);
                        HSSFCell judgStatus = hssfRow.getCell(5);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                caseJudgmentInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                caseJudgmentInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(provinceJudgDate).equals(".")) {
                                    caseJudgmentInformation.setProvincejudgdate(excelValue.getValue(provinceJudgDate));
                                }
                                if (!excelValue.getValue(countyJudgDate).equals(".")) {
                                    caseJudgmentInformation.setCountyjudgdate(excelValue.getValue(countyJudgDate));
                                }
                                if (!excelValue.getValue(localJudgeDate).equals(".")) {
                                    caseJudgmentInformation.setLocaljudgedate(excelValue.getValue(localJudgeDate));
                                }
                                if (!excelValue.getValue(judgStatus).equals(".")) {
                                    caseJudgmentInformation.setJudgstatus(excelValue.getValue(judgStatus));
                                }
                                caseJudgmentInformations.add(caseJudgmentInformation);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("读取case_judgement_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCaseJudgInfor.setYear(excelValue.getValue(year));
                            errorCaseJudgInfor.setCardID(excelValue.getValue(cardId));
                            errorCaseJudgInfor.setProvinceJudgDate(excelValue.getValue(provinceJudgDate));
                            errorCaseJudgInfor.setCountyJudgDate(excelValue.getValue(countyJudgDate));
                            errorCaseJudgInfor.setLocalJudgeDate(excelValue.getValue(localJudgeDate));
                            errorCaseJudgInfor.setJudgStatus(excelValue.getValue(judgStatus));
                            errorCaseJudgInfors.add(errorCaseJudgInfor);
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
                        caseJudgmentInformation = new CaseJudgmentInformation();
                        errorCaseJudgInfor = new ErrorCaseJudgInfor<>();
                        XSSFCell year = xssfRow.getCell(0);
                        XSSFCell cardId = xssfRow.getCell(1);
                        XSSFCell provinceJudgDate = xssfRow.getCell(2);
                        XSSFCell countyJudgDate = xssfRow.getCell(3);
                        XSSFCell localJudgeDate = xssfRow.getCell(4);
                        XSSFCell judgStatus = xssfRow.getCell(5);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                caseJudgmentInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                caseJudgmentInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(provinceJudgDate).equals(".")) {
                                    caseJudgmentInformation.setProvincejudgdate(excelValue.getValue(provinceJudgDate));
                                }
                                if (!excelValue.getValue(countyJudgDate).equals(".")) {
                                    caseJudgmentInformation.setCountyjudgdate(excelValue.getValue(countyJudgDate));
                                }
                                if (!excelValue.getValue(judgStatus).equals(".")) {
                                    caseJudgmentInformation.setJudgstatus(excelValue.getValue(judgStatus));
                                }
                                if (!excelValue.getValue(localJudgeDate).equals(".")) {
                                    caseJudgmentInformation.setLocaljudgedate(excelValue.getValue(localJudgeDate));
                                }
                                caseJudgmentInformations.add(caseJudgmentInformation);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("读取case_judgement_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCaseJudgInfor.setYear(excelValue.getValue(year));
                            errorCaseJudgInfor.setCardID(excelValue.getValue(cardId));
                            errorCaseJudgInfor.setProvinceJudgDate(excelValue.getValue(provinceJudgDate));
                            errorCaseJudgInfor.setCountyJudgDate(excelValue.getValue(countyJudgDate));
                            errorCaseJudgInfor.setJudgStatus(excelValue.getValue(judgStatus));
                            errorCaseJudgInfor.setLocalJudgeDate(excelValue.getValue(localJudgeDate));
                            errorCaseJudgInfors.add(errorCaseJudgInfor);
                            continue;
                        }
                    }
                }
            }
        }
        RowDataSorted<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> rowDataSorted
                = new RowDataSorted<>();
        rowDataSorted.setKeyNotNullList(caseJudgmentInformations);
        rowDataSorted.setErrorReadingList(errorCaseJudgInfors);
        return rowDataSorted;
    }

    public UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> saveToCaseJudgInfor(String path) throws Exception {
        RowDataSorted<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> rowDataSorted
                = getExcelData(path);
        List<ErrorCaseJudgInfor<String>> errorReadingList = rowDataSorted.getErrorReadingList();
        List<CaseJudgmentInformation> errorOperatingList = new ArrayList<>();
        List<CaseJudgmentInformation> excelRows = rowDataSorted.getKeyNotNullList();
        List<CaseJudgmentInformation> insertList = new ArrayList<>();
        List<CaseJudgmentInformation> updateList = new ArrayList<>();
        CaseJudgmentInformation rowData = null;
        CaseJudgmentInformationKey caseJudgmentInformationKey = new CaseJudgmentInformationKey();
        for (int i = 0; i < excelRows.size(); i++) {
            rowData = excelRows.get(i);
            if (null == rowData.getYear() || null == rowData.getCardid()){
                continue;
            }
            caseJudgmentInformationKey.setYear(rowData.getYear());
            caseJudgmentInformationKey.setCardid(rowData.getCardid());
            if (caseJudgmentInformationMapper.selectByPrimaryKey(caseJudgmentInformationKey) != null) {
                updateList.add(rowData);
                continue;
            }
            insertList.add(rowData);
            continue;
        }
        int insertNum = 0;
        for (int i = 0; i < insertList.size(); i++) {
            CaseJudgmentInformation current = insertList.get(i);
            try {
                if (caseJudgmentInformationMapper.insert(current) == 1) {
                    insertNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("case_judgement_information插入数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("case_judgement_information插入数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        int updateNum = 0;
        for (int i = 0; i < updateList.size(); i++) {
            CaseJudgmentInformation current = updateList.get(i);
            try {
                if (caseJudgmentInformationMapper.updateByPrimaryKey(current) == 1) {
                    updateNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("case_judgement_information更新数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("case_judgement_information更新数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> uploadDBMessage
                = new UploadDBMessage<>();
        uploadDBMessage.setErrorReadingList(errorReadingList);
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        uploadDBMessage.setSuccessInsertNum(insertNum);
        uploadDBMessage.setSuccessUpdateNum(updateNum);
        return uploadDBMessage;
    }
}
