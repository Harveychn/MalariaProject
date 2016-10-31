<%@ page import="java.util.List" %>
<%@ page import="com.zxh.ssm.module.user.pojo.UploadInform" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UploadSuccess</title>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <style>
        h3 {
            font-family: Arial;
            font-weight: bold;
        }

        .operatorLine {
            width: 90%;
            height: 2px;
            background: black;
            top: 20px;
            bottom: 20px;
            left: 0;
            right: 0;
            margin: 30px auto;
            position: relative;
        }

        .messageSpan {
            font-family: "Microsoft YaHei UI";
            font-size: 170%;
            color: #4a4a4a;
            margin: 20px 10%;
        }

        .tableDiv {
            width: 80%;
            height: auto;
            border-top: 1px solid grey;
            border-bottom: 1px solid grey;
            position: relative;
            top: 20px;
            bottom: 20px;
            left: 0;
            right: 0;
            margin: auto;
        }
    </style>
</head>
<body>
<c:if test="${result.size()>0}">
    <c:forEach items="${result}" var="current">
        <div class="operatorLine"></div>
        <h2 align="center">${current.fileName}</h2>
        <c:if test="${true==current.hasThisModule}">
            <c:if test="${true!=current.fileTypeError}">
                <c:if test="${true!=current.errorOccur}">
                    <c:if test="${null!=current.cardInform}">
                        <c:if test="${0<current.cardInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.cardInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.cardInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.cardInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.cardInform.errorOperatingList.size()}">
                            <div>操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.cardInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.cardnum}</td>
                                            <td>${record.cardstatus}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.cardInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.cardInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardID}</td>
                                            <td>${record.cardNum}</td>
                                            <td>${record.cardStatus}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${null!=current.caseReportInform}">
                        <c:if test="${0<current.caseReportInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.caseReportInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.caseReportInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.caseReportInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.caseReportInform.errorOperatingList.size()}">
                            <div class="messageSpan">操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.caseReportInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.reportunitareacode}</td>
                                            <td>${record.reportunit}</td>
                                            <td>${record.unittype}</td>
                                            <td>${record.reportinputdate}</td>
                                            <td>${record.inputuser}</td>
                                            <td>${record.inputuserunit}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.caseReportInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.caseReportInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardID}</td>
                                            <td>${record.reportUnitAreaCode}</td>
                                            <td>${record.reportUnit}</td>
                                            <td>${record.unitType}</td>
                                            <td>${record.reportInputDate}</td>
                                            <td>${record.inputUser}</td>
                                            <td>${record.inputUserUnit}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${null!=current.caseRevisedInform}">
                        <c:if test="${0<current.caseRevisedInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.caseRevisedInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.caseRevisedInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.caseRevisedInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.caseRevisedInform.errorOperatingList.size()}">
                            <div class="messageSpan">操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.caseRevisedInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.diseaseprerevised}</td>
                                            <td>${record.revisedreportdate}</td>
                                            <td>${record.revisedfinaljudgdate}</td>
                                            <td>${record.finaljudgdeathdate}</td>
                                            <td>${record.reviseuser}</td>
                                            <td>${record.reviseuserunit}</td>
                                            <td>${record.deldate}</td>
                                            <td>${record.deluser}</td>
                                            <td>${record.deluserunit}</td>
                                            <td>${record.delreason}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.caseRevisedInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.caseRevisedInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardID}</td>
                                            <td>${record.diseasePreRevised}</td>
                                            <td>${record.revisedReportDate}</td>
                                            <td>${record.revisedFinalJudgDate}</td>
                                            <td>${record.finalJudgDeathDate}</td>
                                            <td>${record.reviseUser}</td>
                                            <td>${record.reviseUserUnit}</td>
                                            <td>${record.delDate}</td>
                                            <td>${record.delUser}</td>
                                            <td>${record.delUserUnit}</td>
                                            <td>${record.delReason}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${null!=current.caseJudgeInform}">
                        <c:if test="${0<current.caseJudgeInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.caseJudgeInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.caseJudgeInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.caseJudgeInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.caseJudgeInform.errorOperatingList.size()}">
                            <div class="messageSpan">操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.caseJudgeInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.provincejudgdate}</td>
                                            <td>${record.countyjudgdate}</td>
                                            <td>${record.localjudgedate}</td>
                                            <td>${record.judgstatus}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.caseJudgeInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.caseJudgeInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardID}</td>
                                            <td>${record.provinceJudgDate}</td>
                                            <td>${record.countyJudgDate}</td>
                                            <td>${record.localJudgeDate}</td>
                                            <td>${record.judgStatus}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${null!=current.patientInform}">
                        <c:if test="${0<current.patientInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.patientInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.patientInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.patientInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.patientInform.errorOperatingList.size()}">
                            <div class="messageSpan">操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.patientInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.name}</td>
                                            <td>${record.sex}</td>
                                            <td>${record.career}</td>
                                            <td>${record.birthday}</td>
                                            <td>${record.age}</td>
                                            <td>${record.workunit}</td>
                                            <td>${record.tel}</td>
                                            <td>${record.belongs}</td>
                                            <td>${record.address}</td>
                                            <td>${record.addrnationid}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.patientInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.patientInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.name}</td>
                                            <td>${record.sex}</td>
                                            <td>${record.career}</td>
                                            <td>${record.birthday}</td>
                                            <td>${record.age}</td>
                                            <td>${record.workunit}</td>
                                            <td>${record.tel}</td>
                                            <td>${record.belongs}</td>
                                            <td>${record.address}</td>
                                            <td>${record.addrnationid}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${null!=current.patientCaseInform}">
                        <c:if test="${0<current.patientCaseInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.patientCaseInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.patientCaseInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.patientCaseInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.patientCaseInform.errorOperatingList.size()}">
                            <div class="messageSpan">操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.patientCaseInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.casecategory1}</td>
                                            <td>${record.casecategory2}</td>
                                            <td>${record.illdate}</td>
                                            <td>${record.confirmdate}</td>
                                            <td>${record.deathdate}</td>
                                            <td>${record.diseasename}</td>
                                            <td>${record.fillcarddoc}</td>
                                            <td>${record.fillcarddate}</td>
                                            <td>${record.notes}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.patientCaseInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.patientCaseInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.year}</td>
                                            <td>${record.cardid}</td>
                                            <td>${record.casecategory1}</td>
                                            <td>${record.casecategory2}</td>
                                            <td>${record.illdate}</td>
                                            <td>${record.confirmdate}</td>
                                            <td>${record.deathdate}</td>
                                            <td>${record.diseasename}</td>
                                            <td>${record.fillcarddoc}</td>
                                            <td>${record.fillcarddate}</td>
                                            <td>${record.notes}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${null!=current.weatherInform}">
                        <c:if test="${0<current.weatherInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.weatherInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.weatherInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.weatherInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.weatherInform.errorOperatingList.size()}">
                            <div class="messageSpan">操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.weatherInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.districtstationnum}</td>
                                            <td>${record.weatheryear}</td>
                                            <td>${record.weathermonth}</td>
                                            <td>${record.weatherday}</td>
                                            <td>${record.precipitation2020}</td>
                                            <td>${record.maximumwindspeed}</td>
                                            <td>${record.directionmaximumwindspeed}</td>
                                            <td>${record.avepressure}</td>
                                            <td>${record.avewindspeed}</td>
                                            <td>${record.avetemperature}</td>
                                            <td>${record.avevaporpressure}</td>
                                            <td>${record.averelativehumidity}</td>
                                            <td>${record.sunshinetime}</td>
                                            <td>${record.dailyminpressure}</td>
                                            <td>${record.dailymintemperature}</td>
                                            <td>${record.dailymaxpressure}</td>
                                            <td>${record.dailymaxtemperature}</td>
                                            <td>${record.maxwindspeed}</td>
                                            <td>${record.directionmaxwindspeed}</td>
                                            <td>${record.minrelativehumidity}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.weatherInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.weatherInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.districtStationNum}</td>
                                            <td>${record.weatherYear}</td>
                                            <td>${record.weatherMonth}</td>
                                            <td>${record.weatherDay}</td>
                                            <td>${record.precipitation2020}</td>
                                            <td>${record.maximumWindSpeed}</td>
                                            <td>${record.directionMaximumWindSpeed}</td>
                                            <td>${record.avePressure}</td>
                                            <td>${record.aveWindSpeed}</td>
                                            <td>${record.aveTemperature}</td>
                                            <td>${record.aveVaporPressure}</td>
                                            <td>${record.aveRelativeHumidity}</td>
                                            <td>${record.sunshineTime}</td>
                                            <td>${record.dailyMinPressure}</td>
                                            <td>${record.dailyMinTemperature}</td>
                                            <td>${record.dailyMaxPressure}</td>
                                            <td>${record.dailyMaxTemperature}</td>
                                            <td>${record.maxWindSpeed}</td>
                                            <td>${record.directionMaxWindSpeed}</td>
                                            <td>${record.minRelativeHumidity}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>

                    <c:if test="${null!=current.observeStaInform}">
                        <c:if test="${0<current.observeStaInform.successInsertNum}">
                            <div class="messageSpan">成功插入数据记录：${current.observeStaInform.successInsertNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.observeStaInform.successUpdateNum}">
                            <div class="messageSpan">成功更新数据记录：${current.observeStaInform.successUpdateNum} 条</div>
                        </c:if>
                        <c:if test="${0<current.observeStaInform.errorOperatingList.size()}">
                            <div class="messageSpan">操作时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.observeStaInform.errorOperatingList}" var="record">
                                        <tr>
                                            <td>${record.districtstationnum}</td>
                                            <td>${record.stationname}</td>
                                            <td>${record.provinves}</td>
                                            <td>${record.lat}</td>
                                            <td>${record.lng}</td>
                                            <td>${record.altitude}</td>
                                            <td>${record.startyear}</td>
                                            <td>${record.startmonth}</td>
                                            <td>${record.endyear}</td>
                                            <td>${record.endmonth}</td>
                                            <td>${record.lackmeasurement}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                        <c:if test="${0<current.observeStaInform.errorReadingList.size()}">
                            <div class="messageSpan">读取时错误记录详细信息:</div>
                            <div class="tableDiv">
                                <table>
                                    <c:forEach items="${current.observeStaInform.errorReadingList}" var="record">
                                        <tr>
                                            <td>${record.districtStationNum}</td>
                                            <td>${record.stationName}</td>
                                            <td>${record.provinves}</td>
                                            <td>${record.lat}</td>
                                            <td>${record.lng}</td>
                                            <td>${record.altitude}</td>
                                            <td>${record.startYear}</td>
                                            <td>${record.startMonth}</td>
                                            <td>${record.endYear}</td>
                                            <td>${record.endMonth}</td>
                                            <td>${record.lackMeasurement}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:if>
                    </c:if>
                </c:if>
                <c:if test="${true==current.errorOccur}">
                    <div class="messageSpan">文件上传出现错误，错误信息：${current.errorMessage}</div>
                </c:if>
            </c:if>
            <c:if test="${true==current.fileTypeError}">
                <div class="messageSpan">上传文件的类型有点问题，系统只允许Excel文件（后缀为 “.xls” 或 “.xlsx”）!</div>
            </c:if>
        </c:if>
        <c:if test="${true!=current.hasThisModule}">
            <div class="messageSpan">当前上传文件的模板有问题，请按照上传文件模板组织数据</div>
        </c:if>
    </c:forEach>
</c:if>
</body>
<script src="${webRoot}/js/jquery.min.js" type="text/javascript"></script>
<script>
    $(function () {
        $("table").addClass("table table-striped table-bordered table-hover table-condensed");
    });
</script>
</html>
