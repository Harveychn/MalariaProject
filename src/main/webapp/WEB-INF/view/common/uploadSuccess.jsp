<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zxh.ssm.module.user.pojo.*" %>
<%@ page import="com.zxh.ssm.module.whole.pojo.MeteorologicalStationInsformation" %><%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/10/6
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UploadSuccess</title>
</head>
<body>
<h3 align="center">文件上传成功</h3>

<%--<%--%>
<%--UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> uploadDBMessage1--%>
<%--= (UploadDBMessage<ErrorPatientInformation<String>, PatientInformation>) request.getAttribute("uploadDBMessage1");--%>
<%--int successInsertNum1 = uploadDBMessage1.getSuccessInsertNum();--%>
<%--int successUpdateNum1 = uploadDBMessage1.getSuccessUpdateNum();--%>
<%--List<ErrorPatientInformation<String>> errorReadingList1 = uploadDBMessage1.getErrorReadingList();--%>
<%--List<PatientInformation> errorOperatingList1 = uploadDBMessage1.getErrorOperatingList();--%>
<%--%>--%>
<%--<div>--%>
<%--<h3>uploadDBMessage1</h3>--%>
<%--<h2>成功插入记录数:<%=successInsertNum1%>--%>
<%--</h2>--%>
<%--<h2>成功更新记录数:<%=successUpdateNum1%>--%>
<%--</h2>--%>
<%--<h2>读取时异常记录数:<%=errorReadingList1.size()%>--%>
<%--</h2>--%>
<%--<h2>操作时异常记录数：<%=errorOperatingList1.size()%>--%>
<%--</h2>--%>
<%--</div>--%>
<%--<hr/>--%>
<%--<c:if test="<%=errorOperatingList1.size()>=0%>">--%>
<%--<div align="center">--%>
<%--<h3>patient_information读取时异常记录信息:</h3>--%>
<%--<table border="2px solid black">--%>
<%--<c:forEach items="<%=errorReadingList1%>" var="ErrorPatientInformation">--%>
<%--<tr>--%>
<%--<td>${ErrorPatientInformation.year}</td>--%>
<%--<td>${ErrorPatientInformation.cardid}</td>--%>
<%--<td>${ErrorPatientInformation.name}</td>--%>
<%--<td>${ErrorPatientInformation.sex}</td>--%>
<%--<td>${ErrorPatientInformation.birthday}</td>--%>
<%--<td>${ErrorPatientInformation.age}</td>--%>
<%--<td>${ErrorPatientInformation.workunit}</td>--%>
<%--<td>${ErrorPatientInformation.tel}</td>--%>
<%--<td>${ErrorPatientInformation.belongs}</td>--%>
<%--<td>${ErrorPatientInformation.address}</td>--%>
<%--<td>${ErrorPatientInformation.career}</td>--%>
<%--<td>${ErrorPatientInformation.addrnationid}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</div>--%>
<%--</c:if>--%>

<%
    UploadDBMessage<ErrorObserStaInfor<String>,MeteorologicalStationInsformation> uploadDBMessage2
            = (UploadDBMessage<ErrorObserStaInfor<String>,MeteorologicalStationInsformation>) request.getAttribute("uploadDBMessage7");
    int successInsertNum2 = uploadDBMessage2.getSuccessInsertNum();
    int successUpdateNum2 = uploadDBMessage2.getSuccessUpdateNum();
    List<ErrorObserStaInfor<String>> errorReadingList2 = uploadDBMessage2.getErrorReadingList();
    List<MeteorologicalStationInsformation> errorOperatingList2 = uploadDBMessage2.getErrorOperatingList();

%>
<div>
    <h3>uploadDBMessage2</h3>
    <h2>成功插入记录数:<%=successInsertNum2%>
    </h2>
    <h2>成功更新记录数:<%=successUpdateNum2%>
    </h2>
    <h2>读取时异常记录数:<%=errorReadingList2.size()%>
    </h2>
    <h2>操作时异常记录数：<%=errorOperatingList2.size()%>
    </h2>
</div>
<c:if test="<%=errorOperatingList2.size()<=0%>">
    <div align="center">
        <table border="2px solid black">
            <c:forEach items="<%=errorOperatingList2%>" var="ErrorPatientCaseInfor">
                <tr>
                    <td>${ErrorPatientCaseInfor.year}</td>
                    <td>${ErrorPatientCaseInfor.cardid}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>


</body>
</html>
