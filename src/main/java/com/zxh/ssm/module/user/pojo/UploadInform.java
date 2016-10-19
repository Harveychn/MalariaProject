package com.zxh.ssm.module.user.pojo;

import com.zxh.ssm.module.whole.pojo.*;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
public class UploadInform {
    private boolean isFileTypeError;
    private boolean isErrorOccur;
    private boolean isHasThisModule;
    private UploadDBMessage<ErrorCardInfor<String>, CardInformation> cardInform;
    private UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> patientInform;
    private UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> patientCaseInform;
    private UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> caseReportInform;
    private UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> caseRevisedInform;
    private UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> caseJudgeInform;
    private UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> weatherInform;
    private UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> observeStaInform;

    public UploadDBMessage<ErrorCardInfor<String>, CardInformation> getCardInform() {
        return cardInform;
    }

    public void setCardInform(UploadDBMessage<ErrorCardInfor<String>, CardInformation> cardInform) {
        this.cardInform = cardInform;
    }

    public UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> getCaseJudgeInform() {
        return caseJudgeInform;
    }

    public void setCaseJudgeInform(UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> caseJudgeInform) {
        this.caseJudgeInform = caseJudgeInform;
    }

    public UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> getCaseReportInform() {
        return caseReportInform;
    }

    public void setCaseReportInform(UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> caseReportInform) {
        this.caseReportInform = caseReportInform;
    }

    public UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> getCaseRevisedInform() {
        return caseRevisedInform;
    }

    public void setCaseRevisedInform(UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> caseRevisedInform) {
        this.caseRevisedInform = caseRevisedInform;
    }

    public boolean isErrorOccur() {
        return isErrorOccur;
    }

    public void setErrorOccur(boolean errorOccur) {
        isErrorOccur = errorOccur;
    }

    public boolean isFileTypeError() {
        return isFileTypeError;
    }

    public void setFileTypeError(boolean fileTypeError) {
        isFileTypeError = fileTypeError;
    }

    public boolean isHasThisModule() {
        return isHasThisModule;
    }

    public void setHasThisModule(boolean hasThisModule) {
        isHasThisModule = hasThisModule;
    }

    public UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> getObserveStaInform() {
        return observeStaInform;
    }

    public void setObserveStaInform(UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> observeStaInform) {
        this.observeStaInform = observeStaInform;
    }

    public UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> getPatientCaseInform() {
        return patientCaseInform;
    }

    public void setPatientCaseInform(UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> patientCaseInform) {
        this.patientCaseInform = patientCaseInform;
    }

    public UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> getPatientInform() {
        return patientInform;
    }

    public void setPatientInform(UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> patientInform) {
        this.patientInform = patientInform;
    }

    public UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> getWeatherInform() {
        return weatherInform;
    }

    public void setWeatherInform(UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> weatherInform) {
        this.weatherInform = weatherInform;
    }
}
