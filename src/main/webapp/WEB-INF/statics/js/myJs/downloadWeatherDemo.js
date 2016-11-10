/**
 * Created by R丶sJournal on 2016/11/6.
 */
/**
 * Created by R丶sJournal on 2016/11/6.
 */
$('#needAll').on('click', function (event) {
    $('input#fields').iCheck('check');
});
$('#needNon').on('click', function (event) {
    $('input#fields').iCheck('uncheck');
});
$('#submitWeather').on('click', function (event) {
    var loading = layer.load(0, {
        shade:[0.8,'white']
    });
    $.ajax({
        url: "/DownloadDBData/weatherDemo.do",
        type: "post",
        traditional: true,
        success: function (data) {
            // console.log("OK :" + data);
            layer.close(loading);
            window.open("/DownloadExcelDemo/downLoadExcelDemo.do", "_self");
        },
        error: function () {
            console.error("'/DownloadExcelDemo/weatherDemo.do' Error");
            window.open("/error/500.jsp", "_self");
        }
    });
});