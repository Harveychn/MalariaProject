<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>数据下载</title>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${webRoot}/css/myCss/chartChoose.css" rel="stylesheet" type="text/css"/>
    <link href="${webRoot}/css/animate.css" rel="stylesheet" type="text/css"/>
    <script src="${webRoot}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${webRoot}/js/myJs/chartsChoose.js" type="text/javascript"></script>
    <script  src="${webRoot}/js/plugins/baiduApi/echarts.js" type="text/javascript"></script>
    <style>
        body {
            background-color: white;
        }

        button {
            margin: 10px;
            float: right;
        }

        .btnContainer {
            width: 90%;
            height: auto;
            /*border: 2px solid black;*/
            top: 30px;
            left: 0;
            right: 0;
            margin: auto;
            position: absolute;
        }

        .category {

        }
    </style>
</head>
<body>
<!--<div class="btnContainer">-->
<!--<div class="category">-->
<!--<button type="button" class="btn btn-primary animated swing">年龄</button>-->
<!--<button type="button" class="btn btn-primary animated swing">性别</button>-->
<!--<button type="button" class="btn btn-primary animated swing">职业</button>-->
<!--</div>-->
<!--</div>-->
<div class="container">
    <div id="rowContainer" align="center">
        <div id="diseaseDiv" class="myCol1 animated lightSpeedIn" ondblclick="handleClick1();">
            <div id="sexDiv" style="height: 100%;"></div>
        </div>
        <div id="weatherDiv" class="myCol2 animated lightSpeedIn" ondblclick="handleClick2();">
            <div id="ageDiv" style="height: 100%;"></div>
        </div>
        <div id="stationDiv" class="myCol3 animated lightSpeedIn" ondblclick="handleClick3();">
            <div id="careerDiv" style="height: 100%;"></div>
        </div>
    </div>
</div>
</body>
<script src="${webRoot}/js/plugins/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var sexChart = echarts.init(document.getElementById('sexDiv'));
    var ageChart = echarts.init(document.getElementById('ageDiv'));
    var careerChart = echarts.init(document.getElementById('careerDiv'));
    // 指定图表的配置项和数据
    var sexOption = {
        title: {
            text: '性别比例',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男', '女']
        },
        series: [
            {
                name: '详细数据',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: 335, name: '男'},
                    {value: 310, name: '女'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    var ageOption = {
        title: {
            text: '年龄组比例',
//            subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['0-19岁', '20-29岁', '30-39岁', '40-49岁', '50-59岁','60-69岁','70-79岁','80-89岁','90-100岁']
        },
        series: [
            {
                name: '详细数据',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: 335, name: '0-19岁'},
                    {value: 310, name: '20-29岁'},
                    {value: 234, name: '30-39岁'},
                    {value: 135, name: '40-49岁'},
                    {value: 1548, name: '50-59岁'},
                    {value: 135, name: '60-69岁'},
                    {value: 135, name: '70-79岁'},
                    {value: 135, name: '80-89岁'},
                    {value: 135, name: '90-100岁'},
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    var careerOption = {
        title: {
            text: '职业比例',
//            subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['农民', '工人', '联盟广告', '视频广告', '搜索引擎']
        },
        series: [
            {
                name: '详细数据',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: 335, name: '农民'},
                    {value: 310, name: '工人'},
                    {value: 234, name: '联盟广告'},
                    {value: 135, name: '视频广告'},
                    {value: 1548, name: '搜索引擎'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    sexChart.setOption(sexOption);
    careerChart.setOption(careerOption);
    ageChart.setOption(ageOption);
</script>

</html>
