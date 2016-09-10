$(document).ready(function () {


    $.getJSON("util/getline.do",function(result){
			
						 $('#container').highcharts({
					        title: {
					            text: result.title,
					            x: -20 //center
					        },
					        subtitle: {
					            text: result.subtitle,
					            x: -20
					        },
					        xAxis: {
					            categories:result.xAxis
					        },
					        yAxis: {
					            title: {
					                text: result.yAxis
					            },
					            plotLines: [{
					                value: 0,
					                width: 1,
					                color: '#808080'
					            }]
					        },
					        tooltip: {
					            valueSuffix: result.valueSuffix
					        },
					        legend: {
					            layout: 'vertical',
					            align: 'right',
					            verticalAlign: 'middle',
					            borderWidth: 0
					        },
					        series: [{
					            name: '流量指数',
					            data: result.data
					        }]
					    });
					    
					     
				
			});

/**
    var exchangeTab = new CommonTab("RemindTab", "", function (index) {

        if (index == 0) {
        }
        else if (index == 1) {
        }
        else if (index == 2) {
        }
    });
    
   
   // bindchart($("#txtMemStartTime").val(), $("#txtMemEndTime").val());
    //绑定空列表
    BindNullList("gvMemBirthday");
    BindNullList("gvdMemPontReset");
    BindNullList("gvCustomRemind");
    BindNullList("gvMemPastTime");
    BindNullList("gvGoods");
    
    **/
});

function NoticeShow(noticeID) {
    art.dialog.data('noticeid', noticeID);
    art.dialog.open('SystemManager/SysNoticeShow.do?sysnoticeid=' + noticeID, { id: "topCaller", title: '系统公告详情', lock: false,background:'#452'}, false);
}

function bindchart(starttime, endtime) {
    doAjax(
                "../",
                "GetMemChartIndex",
                {
                    "StartTime": starttime,
                    "EndTime": endtime,
                    "ShopID": $("#sltShop").val()
                },
                "json",
                function (json) {
                    if (json != "") {
                        var Interval = json.Interval.toString().split(",");
                        var arrayObj = json.Mydata.toString().split(",");
                        var Mydata = strtoint(arrayObj);
                        var series = [{ name: '新增人数', data: Mydata}];
                        ChartData('line', '', '', Interval, series);
                    }
                });
}

function ChartData(SeriesType, mytitle, myunit, myInterval, mySeries) {
    $('#container').highcharts = new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            plotBackgroundColor: "#fff",
            plotBorderWidth: null,
            defaultSeriesType: SeriesType,
            borderWidth:0
        },
        title: {
            text: mytitle

        },
        legend: {
            enabled: false,
            borderWidth: 0
        },
        xAxis: {//X轴数据
            labels: {
                align: 'right',
                style: { font: 'normal 13px 宋体' }
            },
            categories: myInterval
        },
        yAxis: {//Y轴显示文字
            title: {
                text: myunit
            }
        },
        series: mySeries
    });
}