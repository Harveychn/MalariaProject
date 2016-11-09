package com.zxh.ssm.module.download.controller;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by R丶sJournal on 2016/11/4.
 */


@Controller
@RequestMapping("/DownloadExcelDemo")
public class DownloadExcelDemoController {
    /**
     * 疟疾数据模板下载
     *
     * @param requests
     * @return
     * @throws Exception
     */
    @RequestMapping("/diseaseDemo")
    public
    @ResponseBody
    int diseaseDemo(HttpServletRequest requests) throws Exception {
        return 1;
    }

    /**
     * 气候数据模板下载
     *
     * @param requests
     * @return
     * @throws Exception
     */
    @RequestMapping("/weatherDemo")
    public
    @ResponseBody
    int weatherDemo(HttpServletRequest requests) throws Exception {
        return 1;
    }

    /**
     * 观测站数据模板下载
     *
     * @param requests
     * @return
     * @throws Exception
     */
    @RequestMapping("/stationDemo")
    public
    @ResponseBody
    int stationDemo(HttpServletRequest requests) throws Exception {
        return 1;
    }

    /**
     * 生成ExcelDemo文件
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping("/downloadExcelDemo")
    public void downLoadExcelDemo(HttpServletResponse response) throws Exception {
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=download");
            HSSFWorkbook workbook = new HSSFWorkbook();
            String fileName ="疟疾数据模板";
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
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
            ServletOutputStream out = response.getOutputStream();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
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