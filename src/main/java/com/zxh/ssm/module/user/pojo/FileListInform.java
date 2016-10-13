package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
public class FileListInform {
    private boolean isNoError;
    private boolean isFileTypeError;
    private boolean isError;
    private String filePath;

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
