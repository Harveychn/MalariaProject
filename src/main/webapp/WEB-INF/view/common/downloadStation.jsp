<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/10/26
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>观测站数据下载</title>
    <script src="${webRoot}/js/jquery.min.js" type="text/javascript"></script>
    <link href="${webRoot}/css/plugins/iCheck/flat/blue.css" rel="stylesheet"/>
    <script src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
    <link href="${webRoot}/css/style.css" rel="stylesheet"/>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${webRoot}/css/myCss/download.css" rel="stylesheet"/>
    <style>
        .partDivide {
            width: 100%;
            height: auto;
            float: left;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>


<div class="container">
    <div align="center">
        <h2>观测站数据下载</h2>
    </div>
    <div class="partDivide">
        <button id="submitTerm" class="btn btn-primary pull-right" type="submit">开始下载</button>
    </div>
    <hr>
    <div class="partDivide">
        <div class="fieldContainer">
            <div class="describe">
                <div>
                    <span class="fieldName">请选择将要下载的字段：</span>
                    <button class="btn btn-default" id="needNon">全不选</button>
                    <button class="btn btn-default" id="needAll">全选</button>
                </div>
            </div>
            <c:forEach items="${categoryFieldsRes}" var="item">
                <label class="field">
                    <input type="checkbox" id="fields" name="selectedFields" value="${item.displayName}"/>
                    <label>${item.displayName}</label>
                </label>
            </c:forEach>
        </div>
    </div>
</div>
</body>

<!--Layer-->
<script src="${webRoot}/js/plugins/layer/layer.js" type="text/javascript"></script>
<script src="${webRoot}/js/myJs/downloadStation.js" type="text/javascript"></script>
<%--<script src="${webRoot}/js/FourLevelLinkage.js" type="text/javascript"></script>--%>
<script>
    $(document).ready(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
    });
</script>
</html>
