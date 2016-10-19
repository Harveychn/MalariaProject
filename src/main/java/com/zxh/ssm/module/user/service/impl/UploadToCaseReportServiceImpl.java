package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.whole.mapper.CaseReportInformationMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToCaseReportService;
import com.zxh.ssm.module.whole.pojo.CaseReportInformation;
import com.zxh.ssm.module.whole.pojo.CaseReportInformationKey;
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
public class UploadToCaseReportServiceImpl implements UploadToCaseReportService {
    @Resource
    private CaseReportInformationMapper caseReportInformationMapper;

    private RowDataSorted<ErrorCaseReportInfor<String>, CaseReportInformation> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<ErrorCaseReportInfor<String>> errorCaseReportInfors = new ArrayList<>();
        List<CaseReportInformation> caseReportInformations = new ArrayList<>();
        ErrorCaseReportInfor<String> errorCaseReportInfor = null;
        CaseReportInformation caseReportInformation = null;
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
                        caseReportInformation = new CaseReportInformation();
                        errorCaseReportInfor = new ErrorCaseReportInfor<>();
                        HSSFCell year = hssfRow.getCell(0);
                        HSSFCell cardId = hssfRow.getCell(1);
                        HSSFCell reportUnitAreaCode = hssfRow.getCell(2);
                        HSSFCell reportUnit = hssfRow.getCell(3);
                        HSSFCell unitType = hssfRow.getCell(4);
                        HSSFCell reportInputDate = hssfRow.getCell(5);
                        HSSFCell inputUser = hssfRow.getCell(6);
                        HSSFCell inputUserUnit = hssfRow.getCell(7);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                caseReportInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                caseReportInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(reportUnitAreaCode).equals(".")) {
                                    caseReportInformation.setReportunitareacode(Integer.parseInt(excelValue.getValue(reportUnitAreaCode)));
                                }
                                if (!excelValue.getValue(reportUnit).equals(".")) {
                                    caseReportInformation.setReportunit(excelValue.getValue(reportUnit));
                                }
                                if (!excelValue.getValue(unitType).equals(".")) {
                                    caseReportInformation.setUnittype(excelValue.getValue(unitType));
                                }
                                if (!excelValue.getValue(reportInputDate).equals(".")) {
                                    caseReportInformation.setReportinputdate(excelValue.getValue(reportInputDate));
                                }
                                if (!excelValue.getValue(inputUser).equals(".")) {
                                    caseReportInformation.setInputuser(excelValue.getValue(inputUser));
                                }
                                if (!excelValue.getValue(inputUserUnit).equals(".")) {
                                    caseReportInformation.setInputuserunit(excelValue.getValue(inputUserUnit));
                                }
                                caseReportInformations.add(caseReportInformation);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("读取case_report_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCaseReportInfor.setYear(excelValue.getValue(year));
                            errorCaseReportInfor.setCardID(excelValue.getValue(cardId));
                            errorCaseReportInfor.setReportUnitAreaCode(excelValue.getValue(reportUnitAreaCode));
                            errorCaseReportInfor.setReportUnit(excelValue.getValue(reportUnit));
                            errorCaseReportInfor.setUnitType(excelValue.getValue(unitType));
                            errorCaseReportInfor.setReportInputDate(excelValue.getValue(reportInputDate));
                            errorCaseReportInfor.setInputUser(excelValue.getValue(inputUser));
                            errorCaseReportInfor.setInputUserUnit(excelValue.getValue(inputUserUnit));
                            errorCaseReportInfors.add(errorCaseReportInfor);
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
                        caseReportInformation = new CaseReportInformation();
                        errorCaseReportInfor = new ErrorCaseReportInfor<>();
                        XSSFCell year = xssfRow.getCell(0);
                        XSSFCell cardId = xssfRow.getCell(1);
                        XSSFCell reportUnitAreaCode = xssfRow.getCell(2);
                        XSSFCell reportUnit = xssfRow.getCell(3);
                        XSSFCell unitType = xssfRow.getCell(4);
                        XSSFCell reportInputDate = xssfRow.getCell(5);
                        XSSFCell inputUser = xssfRow.getCell(6);
                        XSSFCell inputUserUnit = xssfRow.getCell(7);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                caseReportInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                caseReportInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(reportUnitAreaCode).equals(".")) {
                                    caseReportInformation.setReportunitareacode(Integer.parseInt(excelValue.getValue(reportUnitAreaCode)));
                                }
                                if (!excelValue.getValue(reportUnit).equals(".")) {
                                    caseReportInformation.setReportunit(excelValue.getValue(reportUnit));
                                }
                                if (!excelValue.getValue(unitType).equals(".")) {
                                    caseReportInformation.setUnittype(excelValue.getValue(unitType));
                                }
                                if (!excelValue.getValue(reportInputDate).equals(".")) {
                                    caseReportInformation.setReportinputdate(excelValue.getValue(reportInputDate));
                                }
                                if (!excelValue.getValue(inputUserUnit).equals(".")) {
                                    caseReportInformation.setInputuserunit(excelValue.getValue(inputUserUnit));
                                }
                                if (!excelValue.getValue(inputUser).equals(".")) {
                                    caseReportInformation.setInputuser(excelValue.getValue(inputUser));
                                }
                                caseReportInformations.add(caseReportInformation);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("读取case_report_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCaseReportInfor.setYear(excelValue.getValue(year));
                            errorCaseReportInfor.setCardID(excelValue.getValue(cardId));
                            errorCaseReportInfor.setReportUnitAreaCode(excelValue.getValue(reportUnitAreaCode));
                            errorCaseReportInfor.setReportUnit(excelValue.getValue(reportUnit));
                            errorCaseReportInfor.setUnitType(excelValue.getValue(unitType));
                            errorCaseReportInfor.setReportInputDate(excelValue.getValue(reportInputDate));
                            errorCaseReportInfor.setInputUserUnit(excelValue.getValue(inputUserUnit));
                            errorCaseReportInfor.setInputUser(excelValue.getValue(inputUser));
                            errorCaseReportInfors.add(errorCaseReportInfor);
                            continue;
                        }
                    }
                }
            }
        }
        RowDataSorted<ErrorCaseReportInfor<String>, CaseReportInformation> rowDataSorted
                = new RowDataSorted<>();
        rowDataSorted.setErrorReadingList(errorCaseReportInfors);
        rowDataSorted.setKeyNotNullList(caseReportInformations);
        return rowDataSorted;
    }

    public UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> saveToCaseReportInfor(String path) throws Exception {
        RowDataSorted<ErrorCaseReportInfor<String>, CaseReportInformation> rowDataSorted
                = getExcelData(path);
        List<CaseReportInformation> excelRows = rowDataSorted.getKeyNotNullList();
        List<CaseReportInformation> errorOperatingList = new ArrayList<>();
        List<CaseReportInformation> insertDataList = new ArrayList<>();
        List<CaseReportInformation> updateDataList = new ArrayList<>();
        CaseReportInformationKey caseReportInformationKey = new CaseReportInformationKey();
        CaseReportInformation rowData = null;
        for (int i = 0; i < excelRows.size(); i++) {
            rowData = excelRows.get(i);
            caseReportInformationKey.setYear(rowData.getYear());
            caseReportInformationKey.setCardid(rowData.getCardid());
            if (caseReportInformationMapper.selectByPrimaryKey(caseReportInformationKey) != null) {
                updateDataList.add(rowData);
                continue;
            }
            insertDataList.add(rowData);
            continue;
        }
        int insertNum = 0;
        for (int i = 0; i < insertDataList.size(); i++) {
            CaseReportInformation current = insertDataList.get(i);
            try {
                if (caseReportInformationMapper.insert(current) == 1) {
                    insertNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("case_report_information插入数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("case_report_information插入数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        int updateNum = 0;
        for (int i = 0; i < updateDataList.size(); i++) {
            CaseReportInformation current = updateDataList.get(i);
            try {
                if (caseReportInformationMapper.updateByPrimaryKey(current) == 1) {
                    updateNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("case_report_information更新数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("case_report_information更新数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> uploadDBMessage
                = new UploadDBMessage<>();
        uploadDBMessage.setErrorReadingList(rowDataSorted.getErrorReadingList());
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        uploadDBMessage.setSuccessInsertNum(insertNum);
        uploadDBMessage.setSuccessUpdateNum(updateNum);
        return uploadDBMessage;
    }
}
