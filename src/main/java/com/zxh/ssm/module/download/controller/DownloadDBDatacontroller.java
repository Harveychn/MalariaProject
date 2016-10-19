package com.zxh.ssm.module.download.controller;

import com.zxh.ssm.module.download.pojo.CategoryFieldsRe;
import com.zxh.ssm.module.download.pojo.DownloadParamVo;
import com.zxh.ssm.module.download.service.DownloadDBDataService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
@Controller
@RequestMapping("/DownloadDBData")
public class DownloadDBDataController {
    @Resource
    private DownloadDBDataService downloadDBDataService;

    /**
     * 根据用户选择的数据类别，获取展示的字段名
     *
     * @param Category
     * @return
     * @throws Exception
     */
    @RequestMapping("/fieldNameDownloadable")
    public
    @ResponseBody
    List<CategoryFieldsRe> fieldNameDownloadable(@RequestParam(value = "dataCategory") String Category) throws Exception {

        List<CategoryFieldsRe> categoryFieldsRes = downloadDBDataService.getFieldsNameDownload(Category);
        if (categoryFieldsRes != null) {
            return categoryFieldsRes;
        }
        return null;
    }

    @RequestMapping("/downloadExcel")
    public void downLoadExcel(HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=test");

        List<String> displayFields = new ArrayList<String>();
        displayFields.add("职业");
        displayFields.add("病例分类1");
        displayFields.add("审核状态");
        displayFields.add("填卡医生");
        displayFields.add("疾病名称");
        displayFields.add("备注");
        displayFields.add("病人属于");
        displayFields.add("发病日期");
        displayFields.add("录卡用户");
        displayFields.add("性别");
        displayFields.add("数据信息年份");
        displayFields.add("现住详细地址");
        displayFields.add("现住地址国标");
        displayFields.add("年龄");
        displayFields.add("出生日期");
        //用户选择好的字段
        DownloadParamVo downloadParamVo = new DownloadParamVo();
        downloadParamVo.setBeginYear(2005);
        downloadParamVo.setEndYear(2005);
        downloadParamVo.setMinAge(10);
        downloadParamVo.setMaxAge(20);
        downloadParamVo.setAddrLevel1("云南省");
        downloadParamVo.setSex(2);
        downloadParamVo.setSelectedName(displayFields);

        HSSFWorkbook workbook = downloadDBDataService.downloadData(downloadParamVo);

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName = sdf.format(currentDate) + "疟疾数据";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook.write(os);
        } catch (IOException io) {
            System.out.println("workbook.write(os)出现IOException 信息：" + io.getMessage());
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return;
    }


}
//    FileOutputStream fos = null;
//try {
//        //将数据插入到excel表中
//        fos = new FileOutputStream(fileName);
//        workbook.write(fos);
//        //文件下载
//        File file = new File(fileName);
//        if (file.exists()) {
//        FileInputStream fis = new FileInputStream(file);
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        byte[] buffer = new byte[bis.available()];
//        fis.read(buffer);
//        //指定默认路径
//        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//        OutputStream os = response.getOutputStream();
//        os.write(buffer);
//        os.flush();
//        os.close();
//        bis.close();
//        file.delete();
//        }
//        } catch (Exception e) {
//        System.out.println("文件下载出现Exception 信息：" + e.getMessage());
//        }finally {
//        if(fos != null){
//        try {
//        fos.close();
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        }
//        }