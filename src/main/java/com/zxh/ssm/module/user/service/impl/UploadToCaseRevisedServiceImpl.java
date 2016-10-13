package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.user.mapper.CaseRevisedInformationMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToCaseRevisedService;
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
public class UploadToCaseRevisedServiceImpl implements UploadToCaseRevisedService {
    @Resource
    private CaseRevisedInformationMapper caseRevisedInformationMapper;

    private RowDataSorted<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<ErrorCaseRevisedInfor<String>> errorCaseRevisedInfors = new ArrayList<>();
        List<CaseRevisedInformation> caseRevisedInformations = new ArrayList<>();
        ErrorCaseRevisedInfor<String> errorCaseRevisedInfor = null;
        CaseRevisedInformation caseRevisedInformation = null;
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
                        caseRevisedInformation = new CaseRevisedInformation();
                        errorCaseRevisedInfor = new ErrorCaseRevisedInfor<>();
                        HSSFCell year = hssfRow.getCell(0);
                        HSSFCell cardId = hssfRow.getCell(1);
                        HSSFCell diseasePreRevised = hssfRow.getCell(2);
                        HSSFCell revisedReportDate = hssfRow.getCell(3);
                        HSSFCell revisedFinalJudgDate = hssfRow.getCell(4);
                        HSSFCell finalJudgDeathDate = hssfRow.getCell(5);
                        HSSFCell reviseUser = hssfRow.getCell(6);
                        HSSFCell reviseUserUnit = hssfRow.getCell(7);
                        HSSFCell delDate = hssfRow.getCell(8);
                        HSSFCell delUser = hssfRow.getCell(9);
                        HSSFCell delUserUnit = hssfRow.getCell(10);
                        HSSFCell delReason = hssfRow.getCell(11);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                caseRevisedInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                caseRevisedInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(diseasePreRevised).equals(".")) {
                                    caseRevisedInformation.setDiseaseprerevised(excelValue.getValue(diseasePreRevised));
                                }
                                if (!excelValue.getValue(revisedReportDate).equals(".")) {
                                    caseRevisedInformation.setRevisedreportdate(excelValue.getValue(revisedReportDate));
                                }
                                if (!excelValue.getValue(revisedFinalJudgDate).equals(".")) {
                                    caseRevisedInformation.setRevisedfinaljudgdate(excelValue.getValue(revisedFinalJudgDate));
                                }
                                if (!excelValue.getValue(finalJudgDeathDate).equals(".")) {
                                    caseRevisedInformation.setFinaljudgdeathdate(excelValue.getValue(finalJudgDeathDate));
                                }
                                if (!excelValue.getValue(reviseUser).equals(".")) {
                                    caseRevisedInformation.setReviseuser(excelValue.getValue(reviseUser));
                                }
                                if (!excelValue.getValue(reviseUserUnit).equals(".")) {
                                    caseRevisedInformation.setReviseuserunit(excelValue.getValue(reviseUserUnit));
                                }
                                if (!excelValue.getValue(delDate).equals(".")) {
                                    caseRevisedInformation.setDeldate(excelValue.getValue(delDate));
                                }
                                if (!excelValue.getValue(delUser).equals(".")) {
                                    caseRevisedInformation.setDeluser(excelValue.getValue(delUser));
                                }
                                if (!excelValue.getValue(delUserUnit).equals(".")) {
                                    caseRevisedInformation.setDeluserunit(excelValue.getValue(delUserUnit));
                                }
                                if (!excelValue.getValue(delReason).equals(".")) {
                                    caseRevisedInformation.setDelreason(excelValue.getValue(delReason));
                                }
                                caseRevisedInformations.add(caseRevisedInformation);
                                continue;
                            }

                        } catch (Exception e) {
                            System.out.println("读取case_revised_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCaseRevisedInfor.setYear(excelValue.getValue(year));
                            errorCaseRevisedInfor.setCardID(excelValue.getValue(cardId));
                            errorCaseRevisedInfor.setDiseasePreRevised(excelValue.getValue(diseasePreRevised));
                            errorCaseRevisedInfor.setRevisedReportDate(excelValue.getValue(revisedReportDate));
                            errorCaseRevisedInfor.setRevisedFinalJudgDate(excelValue.getValue(revisedFinalJudgDate));
                            errorCaseRevisedInfor.setFinalJudgDeathDate(excelValue.getValue(finalJudgDeathDate));
                            errorCaseRevisedInfor.setReviseUser(excelValue.getValue(reviseUser));
                            errorCaseRevisedInfor.setReviseUserUnit(excelValue.getValue(reviseUserUnit));
                            errorCaseRevisedInfor.setDelDate(excelValue.getValue(delDate));
                            errorCaseRevisedInfor.setDelUser(excelValue.getValue(delUser));
                            errorCaseRevisedInfor.setDelUserUnit(excelValue.getValue(delUserUnit));
                            errorCaseRevisedInfor.setDelReason(excelValue.getValue(delReason));
                            errorCaseRevisedInfors.add(errorCaseRevisedInfor);
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
                        caseRevisedInformation = new CaseRevisedInformation();
                        errorCaseRevisedInfor = new ErrorCaseRevisedInfor<>();
                        XSSFCell year = xssfRow.getCell(0);
                        XSSFCell cardId = xssfRow.getCell(1);
                        XSSFCell diseasePreRevised = xssfRow.getCell(2);
                        XSSFCell revisedReportDate = xssfRow.getCell(3);
                        XSSFCell revisedFinalJudgDate = xssfRow.getCell(4);
                        XSSFCell finalJudgDeathDate = xssfRow.getCell(5);
                        XSSFCell reviseUser = xssfRow.getCell(6);
                        XSSFCell reviseUserUnit = xssfRow.getCell(7);
                        XSSFCell delDate = xssfRow.getCell(8);
                        XSSFCell delUser = xssfRow.getCell(9);
                        XSSFCell delUserUnit = xssfRow.getCell(10);
                        XSSFCell delReason = xssfRow.getCell(11);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                caseRevisedInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                caseRevisedInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(diseasePreRevised).equals(".")) {
                                    caseRevisedInformation.setDiseaseprerevised(excelValue.getValue(diseasePreRevised));
                                }
                                if (!excelValue.getValue(revisedReportDate).equals(".")) {
                                    caseRevisedInformation.setRevisedreportdate(excelValue.getValue(revisedReportDate));
                                }
                                if (!excelValue.getValue(revisedFinalJudgDate).equals(".")) {
                                    caseRevisedInformation.setRevisedfinaljudgdate(excelValue.getValue(revisedFinalJudgDate));
                                }
                                if (!excelValue.getValue(finalJudgDeathDate).equals(".")) {
                                    caseRevisedInformation.setFinaljudgdeathdate(excelValue.getValue(finalJudgDeathDate));
                                }
                                if (!excelValue.getValue(reviseUser).equals(".")) {
                                    caseRevisedInformation.setReviseuser(excelValue.getValue(reviseUser));
                                }
                                if (!excelValue.getValue(reviseUserUnit).equals(".")) {
                                    caseRevisedInformation.setReviseuserunit(excelValue.getValue(reviseUserUnit));
                                }
                                if (!excelValue.getValue(delDate).equals(".")) {
                                    caseRevisedInformation.setDeldate(excelValue.getValue(delDate));
                                }
                                if (!excelValue.getValue(delUser).equals(".")) {
                                    caseRevisedInformation.setDeluser(excelValue.getValue(delUser));
                                }
                                if (!excelValue.getValue(delReason).equals(".")) {
                                    caseRevisedInformation.setDelreason(excelValue.getValue(delReason));
                                }
                                if (!excelValue.getValue(delUserUnit).equals(".")) {
                                    caseRevisedInformation.setDeluserunit(excelValue.getValue(delUserUnit));
                                }
                                caseRevisedInformations.add(caseRevisedInformation);
                                continue;
                            }

                        } catch (Exception e) {
                            System.out.println("读取case_revised_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCaseRevisedInfor.setYear(excelValue.getValue(year));
                            errorCaseRevisedInfor.setCardID(excelValue.getValue(cardId));
                            errorCaseRevisedInfor.setDiseasePreRevised(excelValue.getValue(diseasePreRevised));
                            errorCaseRevisedInfor.setRevisedReportDate(excelValue.getValue(revisedReportDate));
                            errorCaseRevisedInfor.setRevisedFinalJudgDate(excelValue.getValue(revisedFinalJudgDate));
                            errorCaseRevisedInfor.setFinalJudgDeathDate(excelValue.getValue(finalJudgDeathDate));
                            errorCaseRevisedInfor.setReviseUser(excelValue.getValue(reviseUser));
                            errorCaseRevisedInfor.setReviseUserUnit(excelValue.getValue(reviseUserUnit));
                            errorCaseRevisedInfor.setDelDate(excelValue.getValue(delDate));
                            errorCaseRevisedInfor.setDelUser(excelValue.getValue(delUser));
                            errorCaseRevisedInfor.setDelReason(excelValue.getValue(delReason));
                            errorCaseRevisedInfor.setDelUserUnit(excelValue.getValue(delUserUnit));
                            errorCaseRevisedInfors.add(errorCaseRevisedInfor);
                            continue;
                        }
                    }
                }
            }
        }
        RowDataSorted<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> rowDataSorted
                = new RowDataSorted<>();
        rowDataSorted.setErrorReadingList(errorCaseRevisedInfors);
        rowDataSorted.setKeyNotNullList(caseRevisedInformations);
        return rowDataSorted;
    }

    public UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> saveToCaseRevisedInfor(String path) throws Exception {
        RowDataSorted<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> rowDataSorted
                = getExcelData(path);
        List<ErrorCaseRevisedInfor<String>> errorReadingList = rowDataSorted.getErrorReadingList();
        List<CaseRevisedInformation> excelRows = rowDataSorted.getKeyNotNullList();
        List<CaseRevisedInformation> errorOperatingList = new ArrayList<>();
        List<CaseRevisedInformation> insertList = new ArrayList<>();
        List<CaseRevisedInformation> updateList = new ArrayList<>();
        CaseRevisedInformationKey caseRevisedInformationKey = new CaseRevisedInformationKey();
        CaseRevisedInformation rowData = null;
        for (int i = 0; i < excelRows.size(); i++) {
            rowData = excelRows.get(i);
            caseRevisedInformationKey.setYear(rowData.getYear());
            caseRevisedInformationKey.setCardid(rowData.getCardid());
            if (caseRevisedInformationMapper.selectByPrimaryKey(caseRevisedInformationKey) != null) {
                updateList.add(rowData);
                continue;
            }
            insertList.add(rowData);
            continue;
        }
        int insertNum = 0;
        for (int i = 0; i < insertList.size(); i++) {
            CaseRevisedInformation current = insertList.get(i);
            try {
                if (caseRevisedInformationMapper.insert(current) == 1) {
                    insertNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("case_revised_information插入数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("case_revised_information插入数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        int updateNum = 0;
        for (int i = 0; i < updateList.size(); i++) {
            CaseRevisedInformation current = new CaseRevisedInformation();
            try {
                if (caseRevisedInformationMapper.updateByPrimaryKey(current) == 1) {
                    updateNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("case_revised_information更新数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("case_revised_information更新数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> uploadDBMessage
                = new UploadDBMessage<>();
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        uploadDBMessage.setErrorReadingList(errorReadingList);
        uploadDBMessage.setSuccessInsertNum(insertNum);
        uploadDBMessage.setSuccessUpdateNum(updateNum);
        return uploadDBMessage;
    }
}
