
// 百度地图API功能
var map = new BMap.Map("l-map");
map.centerAndZoom(new BMap.Point(117.269945,31.86713), 13);
map.enableScrollWheelZoom(true);
var index = 0;
//创建地址解析器
var myGeo = new BMap.Geocoder();
var adds = [
    "包河区金寨路1号（金寨路与望江西路交叉口）",
    "庐阳区凤台路209号（凤台路与蒙城北路交叉口）",
    "蜀山区金寨路217号(近安医附院公交车站)",
    "蜀山区梅山路10号(近安徽饭店) ",
    "蜀山区 长丰南路159号铜锣湾广场312室",
    "合肥市寿春路93号钱柜星乐町KTV（逍遥津公园对面）",
    "庐阳区长江中路177号",
    "新站区胜利路89"
];
function bdGEO(){
    var add = adds[index];
    geocodeSearch(add);
    index++;
}
function geocodeSearch(add){
    if(index < adds.length){
        setTimeout(window.bdGEO,400);
    }
    myGeo.getPoint(add, function(point){
        if (point) {
            // document.getElementById("result").innerHTML +=  index + "、" + add + ":" + point.lng + "," + point.lat + "</br>";
            var address = new BMap.Point(point.lng, point.lat);
            // addMarker(address,new BMap.Label(index+":"+add,{offset:new BMap.Size(20,-10)}));
        }
    }, "合肥市");
}
// 编写自定义函数,创建标注
// function addMarker(point,label){
//     var marker = new BMap.Marker(point);
//     map.addOverlay(marker);
//     marker.setLabel(label);
// }