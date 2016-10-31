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
    <title>疟疾数据下载</title>
    <script src="${webRoot}/js/jquery.min.js" type="text/javascript"></script>
    <link href="${webRoot}/css/plugins/iCheck/flat/blue.css" rel="stylesheet"/>
    <script src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
    <link href="${webRoot}/css/myCss/download.css" rel="stylesheet"/>
</head>
<body>


<div class="container">
    <div align="center">
        <h2>疟疾数据下载</h2>
        <hr>
    </div>
    <div class="submitContainer">
        <button id="submitTerm" class="btn-primary" type="submit">开始下载</button>
    </div>
    <div class="addressContainer">
        <span class="fieldName">选择数据地区：</span>
        <select id='province'>
            <option>未选</option>
        </select>
        <select id='city'>
            <option>未选</option>
        </select>
        <select id='county'>
            <option>未选</option>
        </select>
        <select id="village">
            <option>未选</option>
        </select>
    </div>
    <div class="sexContainer">
        <div class="describe">
            <div>
                <span class="fieldName">请选择性别:</span>
                <label class="sexField"><input type="radio" name="iCheck" value="0"/><span class="sexSpan">全部</span>
                </label>
                <label class="sexField"><input type="radio" name="iCheck" value="1"/><span
                        class="sexSpan">男</span></label>
                <label class="sexField"><input type="radio" name="iCheck" value="2"/><span
                        class="sexSpan">女</span></label>
            </div>
        </div>
    </div>
    <div class="ageContainer">
        <div class="describe">
            <div>
                <span class="fieldName">请选择年龄区间:</span>
                <input id="minAge" type="number" class="form-control" min="1" max="100" placeholder="最小年龄"/>
                <input id="maxAge" type="number" class="form-control" min="1" max="100" placeholder="最大年龄"/>
            </div>
        </div>
    </div>
    <div class="timeContainer">
        <span class="fieldName">选择时间区间：</span>
        <input id="beginYear" type="number" class="form-control" min="1900" max="2099" placeholder="数据开始年份"/>
        <input id="endYear" type="number" class="form-control" min="1900" max="2099" placeholder="数据结束年份"/>
        <%--<input placeholder="开始日期" class="form-control layer-date" id="start">--%>
        <%--<input placeholder="结束日期" class="form-control layer-date" id="end">--%>
    </div>
    <hr>
    <div class="fieldContainer">
        <div class="describe">
            <div>
                <span class="fieldName">请选择将要下载的字段：</span>
                <button class="button" id="needNon">全不选</button>
                <button class="button" id="needAll">全选</button>
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
</body>

<!--Layer-->
<script src="${webRoot}/js/plugins/layer/layer.js" type="text/javascript"></script>
<script src="${webRoot}/js/myJs/downloadMalaria.js" type="text/javascript"></script>
<script src="${webRoot}/js/FourLevelLinkage.js" type="text/javascript"></script>
<%--<script src="${webRoot}/js/plugins/laydate/laydate.js" type="text/javascript"></script>--%>
<script>
    $(document).ready(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
    });
    //    //日期范围限制
    //    var start = {
    //        elem: '#start',
    //        format: 'YYYY',
    ////        min: laydate.now(), //设定最小日期为当前日期
    //        min: '2000-01-01 00:00:00',
    //        max: '2099-01-01 00:00:00', //最大日期
    //        istime: false,
    //        istoday: false,
    //        choose: function (datas) {
    //            end.min = datas; //开始日选好后，重置结束日的最小日期
    //            end.start = datas //将结束日的初始值设定为开始日
    //        }
    //    };
    //    var end = {
    //        elem: '#end',
    //        format: 'YYYY',
    //        min: laydate.now(),
    //        max: '2099-01-01 00:00:00',
    //        istime: false,
    //        istoday: false,
    //        choose: function (datas) {
    //            start.max = datas; //结束日选好后，重置开始日的最大日期
    //        }
    //    };
    //    laydate(start);
    //    laydate(end);
</script>
</html>
