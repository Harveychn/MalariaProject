package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
public class FileListInform {
    //是否没有错
    private boolean isNoError;
    //是否文件类型错误
    private boolean isFileTypeError;
    //是否有错
    private boolean isError;
    private String errorMessage;
    //当前文件路径
    private String filePath;
    //当前文件名
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public boolean isFileTypeError() {
        return isFileTypeError;
    }

    public void setFileTypeError(boolean fileTypeError) {
        isFileTypeError = fileTypeError;
    }

    public boolean isNoError() {
        return isNoError;
    }

    public void setNoError(boolean noError) {
        isNoError = noError;
    }
}
