package com.zxh.ssm.module.user.controller;

import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.*;
import com.zxh.ssm.module.whole.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/4.
 */
@Controller
@RequestMapping("/UploadFile")
public class UploadFileController {

    @Resource
    private DispatcherUploadFileService dispatcherUploadFileService;
    @Resource
    private UploadToCardInforService uploadToCardInforService;
    @Resource
    private UploadToPIService uploadToPIService;
    @Resource
    private UploadToPCIService uploadToPCIService;
    @Resource
    private UploadToCaseReportService uploadToCaseReportService;
    @Resource
    private UploadToCaseRevisedService uploadToCaseRevisedService;
    @Resource
    private UploadToCaseJudgService uploadToCaseJudgService;
    @Resource
    private UploadToWeatherService uploadToWeatherService;
    @Resource
    private UploadToObserStaService uploadToObserStaService;

    private List<UploadInform> result;

    @RequestMapping("/displayUploadInform")
    public ModelAndView displayUploadInform() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/uploadInform");
        modelAndView.addObject("result", this.result);
        return modelAndView;
    }

    /**
     * 上传文件
     * /*
     * 0:card_information
     * 1:patient_information
     * 2:patient_cases_information
     * 3:case_report_information
     * 4:case_revised_information
     * 5:case_judgement_information
     * 6:weather_data
     * 7:meteorological_station_information
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/UploadToDB", method = RequestMethod.POST)
    public
    @ResponseBody
    List<UploadInform> UploadToDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<FileListInform> filesInform = getUploadFilePath(request, response);
        List<UploadInform> uploadInforms = new ArrayList<>();
        UploadInform uploadInform = null;
        for (int i = 0; i < filesInform.size(); i++) {
            uploadInform = new UploadInform();
            FileListInform current = filesInform.get(i);
            uploadInform.setFileName(current.getFileName());
            if (current.isError()) {
                if (current.isFileTypeError()) {
                    uploadInform.setFileTypeError(true);
                    uploadInforms.add(i, uploadInform);
                    continue;
                }
                uploadInform.setErrorOccur(true);
                uploadInform.setErrorMessage(current.getErrorMessage());
                uploadInforms.add(i, uploadInform);
                continue;
            }
            //通过上传到服务器的文件路径，读取文件信息，操作数据
            String filePath = current.getFilePath();
            //根据第一行字段来判断文件数据应该上传到那一个表
            switch (dispatcherUploadFileService.getDestination(filePath)) {
                case 0:
                    UploadDBMessage<ErrorCardInfor<String>, CardInformation> uploadDBMessage0
                            = uploadToCardInforService.saveDataToCardInfor(filePath);
                    uploadInform.setCardInform(uploadDBMessage0);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                case 1:
                    UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> uploadDBMessage1
                            = uploadToPIService.saveDataToPatientInformation(filePath);
                    uploadInform.setPatientInform(uploadDBMessage1);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                case 2:
                    UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> uploadDBMessage2
                            = uploadToPCIService.saveDataToPCI(filePath);
                    uploadInform.setPatientCaseInform(uploadDBMessage2);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                case 3:
                    UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> uploadDBMessage3
                            = uploadToCaseReportService.saveToCaseReportInfor(filePath);
                    uploadInform.setCaseReportInform(uploadDBMessage3);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                case 4:
                    UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> uploadDBMessage4
                            = uploadToCaseRevisedService.saveToCaseRevisedInfor(filePath);
                    uploadInform.setCaseRevisedInform(uploadDBMessage4);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                case 5:
                    UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> uploadDBMessage5
                            = uploadToCaseJudgService.saveToCaseJudgInfor(filePath);
                    uploadInform.setCaseJudgeInform(uploadDBMessage5);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                case 6:
                    UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> uploadDBMessage6
                            = uploadToWeatherService.saveDataToWeather(filePath);
                    uploadInform.setWeatherInform(uploadDBMessage6);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                case 7:
                    UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> uploadDBMessage7
                            = uploadToObserStaService.saveDataToObserSta(filePath);
                    uploadInform.setObserveStaInform(uploadDBMessage7);
                    uploadInform.setHasThisModule(true);
                    uploadInforms.add(i, uploadInform);
                    break;
                default:
                    uploadInform.setHasThisModule(false);
                    uploadInforms.add(i, uploadInform);
                    break;
            }
        }
        this.result = uploadInforms;
        return uploadInforms;
    }

    /**
     * 返回上传多个文件的初步处理结果
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private List<FileListInform> getUploadFilePath(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = mr.getFiles("files[]");
        List<FileListInform> fileInformList = new ArrayList<>();
        FileListInform fileInform = null;
        for (int i = 0; i < fileList.size(); i++) {
            fileInform = new FileListInform();
            MultipartFile currentFile = fileList.get(i);
            String fileOriginName = currentFile.getOriginalFilename();
            fileInform.setFileName(fileOriginName);
            //文件类型校验
            if (!checkFile(fileOriginName)) {
                fileInform.setFileTypeError(true);
                fileInformList.set(i, fileInform);
                continue;
            }
            SimpleDateFormat folderSdf = new SimpleDateFormat("yyyy-MM-dd");
            String folderPath = "E:/创新实践/uploadFiles/excels" + "/" + folderSdf.format(new Date());
            File fileFolder = new File(folderPath);

            SimpleDateFormat fileSdf = new SimpleDateFormat("yyyyMMddhhmmss");
            String currentDate = fileSdf.format(new Date());
            String filePath = folderPath + "/" + currentDate + "-" + fileOriginName;
            File file = new File(filePath);
            //文件目录不存在则创建目录
            if (!fileFolder.exists()) {
                fileFolder.mkdir();
            }
            try {
                currentFile.transferTo(file);
            } catch (IOException e) {
                System.out.println("【！文件输入输出流出现问题】 message:" + e.getMessage());
                fileInform.setError(true);
                fileInform.setErrorMessage(e.getMessage());
                fileInformList.add(i, fileInform);
                continue;
            } catch (IllegalStateException e) {
                System.out.println("【！IllegalStateException】 message:" + e.getMessage());
                fileInform.setError(true);
                fileInform.setErrorMessage(e.getMessage());
                fileInformList.add(i, fileInform);
                continue;
            }
            fileInform.setNoError(true);
            fileInform.setFilePath(filePath);
            fileInformList.add(i, fileInform);
        }
        return fileInformList;
    }

    /**
     * 上传文件类型校验
     * true表示文件格式允许
     *
     * @param fileName 文件OriginName
     * @return
     */
    private boolean checkFile(String fileName) {
        boolean flag = false;
        String suffixList = "xls,xlsx";
        //获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

        if (suffixList.contains(suffix.trim().toLowerCase())) {
            flag = true;
        }
        return flag;
    }

}
