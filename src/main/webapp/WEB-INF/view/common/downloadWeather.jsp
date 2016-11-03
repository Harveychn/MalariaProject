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
    <title>气候数据下载</title>
    <script src="${webRoot}/js/jquery.min.js" type="text/javascript"></script>
    <link href="${webRoot}/css/plugins/iCheck/flat/blue.css" rel="stylesheet"/>
    <link href="${webRoot}/css/style.css" rel="stylesheet"/>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
    <link href="${webRoot}/css/myCss/download.css" rel="stylesheet"/>
    <style>
        .partDivide {
            width: 100%;
            height: auto;
            float: left;
            margin-bottom: 10px;
        }

        select {
            float: left;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
            color: #555;
            display: block;
            font-size: 14px;
            height: 34px;
            line-height: 1.42857;
            padding: 6px 12px;
            transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
            width: 20%;
        }
    </style>
</head>
<body>


<div class="container">
    <div align="center">
        <h2>气候数据下载</h2>
        <hr>
    </div>
    <div class="partDivide">
        <button id="submitTerm" class="btn btn-primary pull-right" type="submit">开始下载</button>
    </div>
    <div class="partDivide">
        <div class="form-group">
            <label class="fieldName">选择时间区间：</label>
            <input id="beginYear" class="form-control" type="number" min="1900" max="2099" placeholder="数据开始年份"/>
            <input id="endYear" class="form-control" type="number" min="1900" max="2099" placeholder="数据结束年份"/>
        </div>
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
<script src="${webRoot}/js/myJs/downloadWeather.js" type="text/javascript"></script>
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
