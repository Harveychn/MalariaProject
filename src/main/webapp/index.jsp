<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <title>首页</title>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=fKhoym1WRjv6As8wpebyVtndCGnDWZuU"></script>
    <style type="text/css">
        ul, li {
            list-style: none;
            margin: 0;
            padding: 0;
            float: left;
        }

        html {
            height: 100%
        }

        body {
            height: 100%;
            margin: 20px 20px;
            padding: 0px;
            font-family: "微软雅黑";
        }

        #container {
            height: 100%;
            width: 100%;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div id="container"></div>
</body>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("container");
    var point = new BMap.Point(116.331398, 39.897445);
    map.centerAndZoom(point, 12);

    function myFun(result) {
        var cityName = result.name;
        map.setCenter(cityName);
        console.log(cityName);
    }
    var myCity = new BMap.LocalCity();
    myCity.get(myFun);
</script>
</html>