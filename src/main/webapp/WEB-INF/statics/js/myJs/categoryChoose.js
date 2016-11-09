/**
 * Created by 郑晓辉 on 2016/10/23.
 // */
function handleClick1() {
    var category = $("#disease").text();
    console.log(category);
    var url = "/DownloadDBData/fieldNameDownloadable.do?category=Disease";
    window.open(url, "_self");
    // window.open(url);
}
function handleClick2() {
    var category = $("#weather").text();
    console.log(category);
    var url = "/DownloadDBData/fieldNameDownloadable.do?category=Weather";
    window.open(url, "_self");
    // window.open(url);
}
function handleClick3() {
    var category = $("#station").text();
    console.log(category);
    var url = "/DownloadDBData/fieldNameDownloadable.do?category=Station";
    window.open(url, "_self");
    // window.open(url);
}
function downloadone() {
    var url = "/DownloadExcelDemo/diseaseDemo.do";
    window.open(url, "_self");
    // window.open(url);
}
function downloadtwo() {
    var url = "/DownloadExcelDemo/weatherDemo.do";
    window.open(url, "_self");
    // window.open(url);
}
function downloadthree() {
    var url = "/DownloadExcelDemo/stationDemo.do";
    window.open(url, "_self");
    // window.open(url);
}


