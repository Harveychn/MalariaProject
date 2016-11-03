<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/10/12
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String webRoot = "http://" + request.getServerName() + ":" + request.getServerPort();
%>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>文件上传</title>
    <meta name="keywords" content="响应式后台">

    <link href="${webRoot}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="${webRoot}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css?v=4.1.0" rel="stylesheet">
    <style>
        #message {
            font-family: "Microsoft YaHei UI";
            font-size: 300%;
            filter: none;
            height: 123px;
            left: 50%;
            margin-left: -214px;
            margin-top: -61.5px;
            opacity: 1;
            position: absolute;
            top: 50%;
            transition: opacity 0.3s ease-in-out 0s;
            width: 428px;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form id="my-awesome-dropzone" class="dropzone"
                          action="/UploadFile/UploadToDB" method="post"
                          enctype="multipart/form-data">
                        <div class="dropzone-previews">
                            <%--<div id="preview-template" style="display: none;">--%>
                            <%--<div class="data-dz-errormessage">--%>
                            <%--&lt;%&ndash;<div class="dz-error-message"></div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--</div>--%>
                        </div>
                        <button type="submit" class="btn btn-primary pull-right">提交</button>
                        <div class="dz-message" id="message">
                            拖拽文件至此<br>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            或点击选择文件
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- 全局js -->
<script src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
<script src="${webRoot}/js/bootstrap.min.js?v=3.3.6"></script>

<!--Layer-->
<script src="${webRoot}/js/plugins/layer/layer.js" type="text/javascript"></script>
<!-- DROPZONE -->
<script src="${webRoot}/js/plugins/dropzone/dropzone.js"></script>


<script>
    $(document).ready(function () {
        Dropzone.options.myAwesomeDropzone = {

            autoProcessQueue: false,
            uploadMultiple: true,
            parallelUploads: 100,
            maxFiles: 100,
            maxFileSize: 1,
            paramName: "files",
            method: "post",
            addRemoveLinks:true,
            // Dropzone settings
            init: function () {
                var myDropzone = this;
                var uploading = null;

                this.element.querySelector("button[type=submit]").addEventListener("click", function (e) {
                    e.preventDefault();
                    e.stopPropagation();
                    myDropzone.processQueue();
//                    uploading = layer.load(0, {time: 10 * 1000});
                });
                this.on("sendingmultiple", function () {
                    console.log("sendingmultiple");
                    uploading = layer.load(0, {
                        shade:[0.8,'white']
                    });
                });
                this.on("successmultiple", function (files, response) {
                    layer.close(uploading);

                    var index = layer.open({
                        type: 2,
                        title:'服务器处理数据结果',
                        content: '/UploadFile/displayUploadInform',
                        area: ['90%', '90%'],
                        maxmin: true,
                        closeBtn:1
                    });
                    layer.full(index);

                    console.log("successmultiple");
                });
                this.on("errormultiple", function (files, response) {
                    layer.close(uploading);
                    $('.dz-error-message').html("<span data-dz-errormessage='" + "'>上传失败</span>");
                    console.log("errormultiple");
                });
            }

        }

    });
</script>

</body>

</html>
