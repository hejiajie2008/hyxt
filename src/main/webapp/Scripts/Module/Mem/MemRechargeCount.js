﻿var pageSize = 10;
var currentPage = 1;
var chkNoMember = false;
var GoodsList = new Array();
var levelPoint, levelPercent;
var totalNumber = 0, totalPoint = 0, totalMoney = 0, totalDiscount = 0;

/**************************************************************************************************
*页面加载函数
***************************************************************************************************/
$(document).ready(function () {
    //获取商品列表
    GetServiceList();
    
    //消费时间
    $('#txtOrderTime').bind("focus", function () {
        WdatePicker({ skin: 'ext', dateFmt: 'yyyy-MM-dd HH:mm', maxDate: '%y-%M-%d %H:%m:%s', isShowClear: false, readOnly: true });
        $("#txtMemCountRemark").focus();
    });

    if ($("#MemCard").val() != null) {
        $("#txtFindMember").val($("#MemCard").val());
    }

    //按“回车键”响应查询
    $("#txtGoodsCode").keypress(function (e) {
        var keyAscii = window.event ? e.keyCode : e.which;
        if (keyAscii == 13) { GetServiceList(); }
    });

    //“搜索”按钮响应函数
    $("#btnServiceSearch").bind("click", btnServiceSearch);

    //“马上充次”按钮响应函数
    $("#btnMemCountSave").bind("click", btnMemCountSave);
    $("#findTable").removeAttr("style");
    $("#findTable").css("width", "100%");
    $("#tdMemCount").css("vertical-align", "top")
    $("#tbTop").css("width", "100%");
    $("#tbBody").css("width", "100%");
    $("#txtOrderTime").val($.getnowtime());
});

/****************************************************************************************************
*搜索按钮响应函数
*****************************************************************************************************/
function btnServiceSearch() {
    GetServiceList();
}

/****************************************************************************************************
*“马上充次”按钮响应函数
*****************************************************************************************************/
function btnMemCountSave() {
    var strOrderCode = $("#spOrderAccount").html();
    var chkAllowPwd = $("#chkAllowPwd").attr("checked");

    var strErrorMsg = "";
    if ($.isEmptyObject(global_mem) && (chkNoMember == false)) {
        strErrorMsg += "<li>请选择会员！</li>";
    }

    //    if (totalDiscount == 0) {
    //        strErrorMsg += "<li>请选择服务项目！</li>";
    //    }
    if (GoodsList.length == 0) {
        strErrorMsg += "<li>请选择服务项目！</li>";
    }

    if (strErrorMsg != "") {
        strErrorMsg = "<div>操作出现以下错误，请核查后重试！</div><ul>" + strErrorMsg + "</ul>";
        art.dialog({
            title: '系统提示',
            icon: 'error', //图标
            content: strErrorMsg,
            lock: true
        });
        return false;
    }

    if (GoodsList.length > 0 && totalDiscount == 0) {
        var parameter = new Array();
        //parameter.push({ "payType": "MemCount", "IsCard": false, "IsCash": false, "IsBink": false, "CardMoney": 0, "CashMoney": 0, "CouponMoney": 0, "BinkMoney": 0, "DiscountMoney": 0, "ChangeMoney": 0 });
        parameter.push({ "payType": "MemCount", "IsCard": false, "IsCash": false, "IsBink": false, "CardMoney": 0, "CashMoney": 0, "CouponMoney": 0, "BinkMoney": 0, "DiscountMoney": 0, "ChangeMoney": 0 });
        ExpenseOK(parameter);
        return;
    }
    ShowPay("MemCount", global_mem.memmoney, totalDiscount, strOrderCode, chkAllowPwd);
}

/*************************************************************************
*保存消费数据响应函数
*************************************************************************/
function ExpenseOK(parameter) {
    var strOrderCode = $("#spOrderAccount").html();
    var strOrderTime = $("#txtOrderTime").val();
    var bolSms = $("#chkSMS").attr("checked");
    var strRemark = $("#tdRemark").val();

    //获取打印的份数
    var PointNum = $("#PointNum").val();
    $.ajax({
        type:'POST',
        url:project_name+'Member/saveMemCount.do',
        dataType:"json",      
        contentType:"application/json",   
        data:JSON.stringify({
        	"countmemid": global_mem.memid,
            "counttotalmoney": totalMoney,
            "countdiscountmoney": totalDiscount,
            "countpoint": totalPoint,
            "countcreatetime": strOrderTime,
             //"countpaytype": payType,
            "detail": parameter,
            "details": GoodsList,
            "countaccount": strOrderCode,
            "countremark": strRemark
            //"IsSMS": bolSms,
            //"Data": GoodsList,
            //"DataCount": GoodsList.length
        }),
        success:function(json){	
		        	switch (json.result) {
		            case 0:
		                art.dialog
		                      ({
		                          title: '系统提示',
		                          time: 4,
		                          content: ("系统异常，未保存数据，请再次点击马上充次！"),
		                          lock: true
		                      });
		                break;
		            case -1:
		                art.dialog
		                      ({
		                          title: '系统提示',
		                          time: 4,
		                          content: ("系统错误 请与系统管理员联系！"),
		                          lock: true
		                      });
		                break;
		            case -2:
		                art.dialog
		                   ({
		                       title: '系统提示',
		                       time: 4,
		                       content: ("充次成功！短信余额不足，不能发送短信，请充值短信！"),
		                       close: function () {
		                           Print_MemCount($("#lblOrderUSer").html(), $("#lblPrintTitle").html(), $("#lblPrintFoot").html(), GoodsList, parameter, $("#chkPrint").attr("checked"), PointNum);
		                       },
		                       lock: true
		                   });
		                break;
		            case -5:
		                art.dialog
		                   ({
		                       title: '系统提示',
		                       time: 4,
		                       content: ("发送短信失败,本店拥有的短信量不足请与总店联系！"),
		                       lock: true
		                   });
		                break;
		            case -6:
		                art.dialog
		                   ({
		                       title: '系统提示',
		                       time: 4,
		                       content: ("本店积分不足无法消费，请与总店联系！"),
		                       lock: true
		                   });
		                break;
		            default:
		                art.dialog
		                     ({
		                         title: '系统提示',
		                         time: 2,
		                         content: '充次成功！' + json.strUpdateMemLevel,
		                         close: function () {
		                             Print_MemCount($("#lblOrderUSer").html(), $("#lblPrintTitle").html(), $("#lblPrintFoot").html(), GoodsList, parameter, $("#chkPrint").attr("checked"), PointNum);
		                         },
		                         lock: true
		                     });
		                break;
		        		}
        			}
	      		}	
        );
    
}

/****************************************************************************************************
*获取服务商品数据
*****************************************************************************************************/
function GetServiceList() {
    doAjax(
               "Member/",
               "GetServiceList.do",
               {
                   "pageSize": pageSize,
                   "page": currentPage,
                   "key": $("#txtGoodsCode").val(),
                   "createshopid": $("#ShopID").val(),
                   "memlevelid": global_mem.memlevelid == undefined ? -1 : global_mem.memlevelid
               },
               "json",
               function (json) {
                   CreateServingTable(json.rows);
                   CreateServingPager(json.total);
               });
}

/****************************************************************************************************
*创建服务类商品表格
*****************************************************************************************************/
function CreateServingTable(obj) {
    var html = '';
    if (obj.length > 0) {
        $.each(obj, function (index, item) {
            //            var goodsDiscount = calculate(item); //获得商品的折扣率
            //            var goodsDiscountPrcie = accMul(item.Price, goodsDiscount).toFixed(2); //计算商品的折后金额
            //            var pointDiscount = pointCalculate(item); //计算商品的积分比例
            var goodsDiscount = item.goodsdiscount;
            var goodsDiscountPrcie = item.discountprice;
            var pointDiscount = item.pointdiscount;
          
            var bg = index % 2 == 0 ? "#eee" : "#fff";
            html += "<tr class=\"td\" onclick=\"javascript:ExpenseSelectGoods(" + item.goodsid + "," + 0 + "," + goodsDiscount + "," + pointDiscount + ");\">"
                        + '<td style="text-align: left">' + item.name + '</td>'
            
            
                        + '<td style="text-align: right"><b>' + parseFloat(item.price).toFixed(2) + '</b></td>';
            html += '<td style="text-align: right">' + goodsDiscountPrcie + '</td>';
            
            
            //            if (item.Point != -1) {
            //                html += '<td class="repeterTdRight">' + Math.floor(item.Point, 1) + '</td>';

            //            }
            //            else {
            //                html += '<td class="repeterTdRight">不积分</td>';
            //            }
            
            html += '<td style="display:none">' + item.commissionnumber + '</td>'
                + '</tr>';
        });
    }
    else {
        html += '<td style="height:50px; line-height:50px;padding-left:20px; background-color:#fff;" colspan="5">未找到符合此条件的数据！请重试！</td>';
    }
    $("#tbServing").html(html);
}

/****************************************************************************************************
*创建分页
*****************************************************************************************************/
function CreateServingPager(resCount) {
    var page = new CommonPager(
            "ServingPage",
            pageSize,
            resCount,
            currentPage,
            function (p) {
                currentPage = parseInt(p);
                GetServiceList();
            }
        );
    page.ShowSimple();
}

/****************************************************************************************************
*将左边列表中的数据放到右边列表中
*****************************************************************************************************/
function ExpenseSelectGoods(intGoodsID, type, index, pointDiscount) {
    var strErrorMsg = "";
    if ($.isEmptyObject(global_mem)) {
        strErrorMsg += "<li>请先选择会员,再进行下一步操作!</li>";
        art.dialog({
            title: '系统提示',
            icon: 'error', //图标
            content: strErrorMsg,
            lock: true
        });
        return false;
    }
    
    doAjax(
               "Member/",
               "GetGoodsInfo.do",
               {
                   "goodsid": intGoodsID,
                   "memlevelid": global_mem.memlevelid == undefined ? -1 : global_mem.memlevelid
               },
               "json",
               function (json) {
            	  
                   SetGoodsInfo(json, type, index, pointDiscount);
               });
}

/****************************************************************************************************
*设置选定商品的相应信息
*****************************************************************************************************/
function SetGoodsInfo(json, type, line, pointDiscount) {
    var index = -1;
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == json[0].goodsid) {
            index = i;
        }
    }
    //这是某件商品第一次被选中销售时
    if (index == -1) {
        json[0]["expdiscount"] = line;
        json[0]["exppointdiscount"] = pointDiscount;
        json[0]["expnum"] = 1;
        json[0]["expmoney"] = parseFloat(accMul(json[0]["expdiscount"], json[0].price)).toFixed(2);
        
        //        switch (json[0].Point) {
        //            //不积分                                                                                                                                
        //            case "-1":
        //                json[0]["ExpPoint"] = 0;
        //                break;
        //            case "0":
        //                if (levelPoint == 0) {
        //                    json[0]["ExpPoint"] = 0;
        //                }
        //                else {
        //                    json[0]["ExpPoint"] = Math.floor(accDiv(accMul(json[0].Price, levelPercent), levelPoint));
        //                }
        //                break;
        //            default:
        //                json[0]["ExpPoint"] = json[0].Point;
        //        }
        json[0]["exppoint"] = Math.floor(accDiv(json[0]["expmoney"], json[0]["exppointdiscount"]));
        json[0]["commissiontype"] = json[0].commissiontype;
        json[0]["commissionnumber"] = json[0].commissionnumber;
        GoodsList.push(json[0]);
       
    }
    else {
        //当前消费数量
        var currentNum = parseInt(GoodsList[index].expnum) + 1;
        var currentMoney = accMul(accMul(GoodsList[index]["price"], GoodsList[index]["expdiscount"]), currentNum);
        //        switch (GoodsList[index].Point) {
        //            //不积分                                                                                                                                  
        //            case "-1":
        //                currentPoint = 0;
        //                break;
        //            case "0":
        //                if (levelPoint == 0) {
        //                    currentPoint = 0;
        //                }
        //                else {
        //                    currentPoint = Math.floor(accDiv(accMul(accMul(GoodsList[index].Price, levelPercent), currentNum), levelPoint));
        //                }
        //                break;
        //            default:
        //                currentPoint = Math.floor(accMul(GoodsList[index].Point, currentNum), 1);
        //        }
        //        var goodsPointDiscount = parseFloat(GoodsList[index]["ExpPointDiscount"]);
        //        currentPoint = getPoint(GoodsList[index]["ExpPointDiscount"], GoodsList[index].Point, currentMoney, currentNum);
        if (Math.floor(GoodsList[index].point) > 0) {
            currentPoint = Math.floor(accMul(GoodsList[index].point, currentNum));
        }
        else {
            currentPoint = Math.floor(accDiv(currentMoney, GoodsList[index]["exppointdiscount"]));
        }
        GoodsList[index].exppoint = currentPoint;
        GoodsList[index].expmoney = currentMoney;
        GoodsList[index].expnum = currentNum;
    }
    ExpenseGoodsBindList();
}
/****************************************************************************************************
*将选择好的产品绑定到右侧列表中
*****************************************************************************************************/
function ExpenseGoodsBindList() {
    $("#tbOrderTable").html("");
    for (var i = 0; i < GoodsList.length; i++) {
        var strHtml = '<tr class="td" >'
            + '<td>' + GoodsList[i].name + '</td>'
            + '<td>' + parseFloat(GoodsList[i].price).toFixed(2) + '</td>'
            + '<td><input id="txtNumber' + GoodsList[i].goodsid + '" type="text" maxlength="5" style="text-align: right" class="border_radius common_ServiceButton border_radius2" value="' + GoodsList[i].expnum + '" onkeyup="javascript:ExUpdateNumber(' + GoodsList[i].goodsid + ',' + parseFloat(GoodsList[i].price).toFixed(2) + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtDiscountPrice' + GoodsList[i].goodsid + '" type="text" maxlength="6" style="text-align: right" class="border_radius common_ServiceButton border_radius3" value="' + parseFloat(GoodsList[i].expmoney).toFixed(2) + '" onkeyup="javascript:ExUpdateDiscountPrice(' + GoodsList[i].goodsid + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtPoint' + GoodsList[i].goodsid + '" type="text" maxlength="6" style="text-align: right" class="border_radius common_ServiceButton border_radius2" value="' + Math.floor(GoodsList[i].exppoint) + '" onkeyup="javascript:ExUpdatePoint(' + GoodsList[i].goodsid + ');" onclick=\"javascript:this.select();\"/></td>'
            + '  <td class=\"listtd\" style=\"width: 30px;\"><a href="javascript:void(0);" onclick="javascript:ExDeleteItem(' + GoodsList[i].goodsid + ');"><img src=\"../images/Gift/del.png\" alt=\"删除此项\" title=\"删除此项\" /></a></td>'
            + '</tr>';
        $("#tbOrderTable").append(strHtml);
    }
    strHtml = '<tr id="trTotal"><td colspan="6"></td></tr>';
    $("#tbOrderTable").append(strHtml);
    ExpenseGoodsBindTotal();
}
/****************************************************************************************************
*绑定消费合计
*****************************************************************************************************/
function ExpenseGoodsBindTotal() {
    var strHtml;
    totalNumber = 0, totalPoint = 0; totalMoney = 0; totalDiscount = 0;
  
    if (GoodsList.length > 0) {
        for (var i = 0; i < GoodsList.length; i++) {
            totalNumber = accAdd(totalNumber, GoodsList[i].expnum);
            totalMoney = accAdd(totalMoney, accMul(GoodsList[i].price, GoodsList[i].expnum));
            totalDiscount = accAdd(totalDiscount, GoodsList[i].expmoney);
            totalPoint = accAdd(totalPoint, GoodsList[i].exppoint);
        }   
        $("#lblTotalNumber").html(totalNumber);
        $("#lblTotalMoney").html(totalMoney);
        $("#lblTotalPoint").html(totalPoint);

        $("#lblTotalDiscountMoney").html(totalDiscount);
    }
    else {
        strHtml = '<td colspan="6" style="height: 25px; text-align: center; line-height: 25px; background-color: #FFF;">'
                 + '请点击左侧服务列表，选择需要服务的项目！</td>';
        $("#tbOrderTable").html(strHtml);
        
        
        $("#lblTotalNumber").html(totalNumber);
        $("#lblTotalMoney").html(totalMoney);
        $("#lblTotalPoint").html(totalPoint);

        $("#lblTotalDiscountMoney").html(totalDiscount);
    }

}

/****************************************************************************************************
*更改数量 重新计算合计
*****************************************************************************************************/
function ExUpdateNumber(intGoodsID, dclGoodsPrice) {  
    var intNumber = $("#txtNumber" + intGoodsID).val();
    if (!intNumber.IsNumber()) {
        art.dialog({
            title: '系统提示',
            icon: 'error', //图标
            content: '购买商品的数量只能为数字且大于0,请重新输入',
            lock: true
        });
        intNumber = 1;
    }

    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == intGoodsID) {
            GoodsList[i].expnum = intNumber;
            GoodsList[i].expmoney = parseFloat(accMul(accMul(GoodsList[i].price, intNumber), GoodsList[i].expdiscount)).toFixed(2);
            GoodsList[i].exppoint = Math.floor(accDiv(GoodsList[i].expmoney, GoodsList[i]["exppointdiscount"]));
        
            break;
        }

    }

    $("#txtNumber" + intGoodsID).val(intNumber);
    $("#txtPoint" + intGoodsID).val(GoodsList[i].exppoint);
    $("#txtDiscountPrice" + intGoodsID).val(GoodsList[i].expmoney);
    ExpenseGoodsBindTotal();
}
/****************************************************************************************************
*更改积分 重新计算合计
*****************************************************************************************************/
function ExUpdatePoint(intGoodsID) {
    var intPoint = $("#txtPoint" + intGoodsID).val();
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == intGoodsID) {
            GoodsList[i].exppoint = intPoint;
            break;
        }
    }

    $("#txtPoint" + intGoodsID).val(GoodsList[i].exppoint);
    ExpenseGoodsBindTotal();
}
/****************************************************************************************************
*更改折后价 重新计算合计
*****************************************************************************************************/
function ExUpdateDiscountPrice(intGoodsID) {
    var decDiscountPrice = $("#txtDiscountPrice" + intGoodsID).val();
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == intGoodsID) {
            GoodsList[i].expmoney = decDiscountPrice;
            //            if (levelPoint == 0) {
            //                GoodsList[i].ExpPoint = 0;
            //            }
            //            else {
            //                GoodsList[i].ExpPoint = Math.floor(accMul(GoodsList[i].ExpMoney, levelPoint));
            //            }
            break;
        }
    }
    GoodsList[i].expmoney = decDiscountPrice;
    GoodsList[i].exppoint = Math.floor(accDiv(GoodsList[i].expmoney, GoodsList[i]["exppointdiscount"]));
    $("#txtPoint" + intGoodsID).val(GoodsList[i].exppoint);
    $("#txtDiscountPrice" + intGoodsID).val(GoodsList[i].expmoney);
    ExpenseGoodsBindTotal();
}

/****************************************************************************************************
*删除一行 重新计算合计
*****************************************************************************************************/
function ExDeleteItem(intGoodsID) {
    var newGoodsList = new Array();
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid != intGoodsID) {
            newGoodsList.push(GoodsList[i]);
        }
    }
    GoodsList = newGoodsList;
    ExpenseGoodsBindList();
}

/****************************************************************************************************
*在选择好会员时可以执行回调函数
*****************************************************************************************************/
function FindMember_CallBack() {
    var strErrorMsg;
    if (global_mem.memstate != 0) {
        strErrorMsg = "当前会员卡处于锁定或者挂失状态，暂不允许进行充时。";
        art.dialog({
            title: '系统提示',
            content: strErrorMsg,   //弹出层显示文本
            icon: 'error', //图标
            lock: true//是否锁定背景
        });
        return false;
    }

    if (global_mem.memispast == "True") {
        strErrorMsg = "当前会员卡已过期，暂不允许进行消费。";
        art.dialog({
            title: '系统提示',
            content: strErrorMsg,   //弹出层显示文本
            icon: 'error', //图标
            lock: true//是否锁定背景
        });
        return false;
    }
    levelPercent = (global_mem.classdiscountpercent != 0) ? global_mem.classdiscountpercent : 0;
    levelPoint = (global_mem.classpointpercent != 0 || global_mem.classpointpercent != undefined) ? global_mem.classpointpercent : 0;

//    levelPercent = (global_mem.LevelDiscountPercent != 0) ? global_mem.LevelDiscountPercent : 0;
//    levelPoint = (global_mem.LevelPointPercent != 0 || global_mem.LevelPointPercent != "undefined") ? accMul(global_mem.LevelPointPercent, 100) : 0;
    GoodsList.splice(0, GoodsList.length);
    ExpenseGoodsBindList();
    $("#txtMemCountRemark").val("");
    $("#btnQueryMemCount").css("display", "");
    GetServiceList();
    return true;
}

/***********************************************************
*查看已有充次项目
************************************************************/
function BtnQueryMemCount() {
    if ($.isEmptyObject(global_mem)) {
        art.dialog({
            title: "系统提示",
            content: "请先选择会员再查看已有充次项目！",
            icon: "error",
            lock: true
        });
        return false;
    }
    else {
        art.dialog.data('MemID', global_mem.memid);
        art.dialog.open('./Member/MemExistCount.aspx?PID=79&MemID=' + global_mem.memid, { title: '会员已有充次项目', lock: true }, false);
    }
}
//计算商品的折扣
function calculate(item) {
    var minPercent = parseFloat(item.minpercent).toFixed(2);
    var salePercet = parseFloat(item.salepercet).toFixed(2);
    var goodsDiscount = 1;
    //判断是否是会员 global_mem.MemLevelID==undefined表示非会员
    if (!global_mem.memlevelid) {
        if (minPercent == 0 && salePercet == 0) {
            goodsDiscount = 1;
        }
        else if (salePercet > 0) {
            goodsDiscount = salePercet;
        }
        else {//散客没有最低折扣
            goodsDiscount = 1;
        }
    } else {
        var classDiscountPercent = parseFloat(item.classdiscountpercent).toFixed(2);
        if (minPercent == 0 && salePercet == 0) {
            //按照商品分类折扣打折
            goodsDiscount = classDiscountPercent;
        } else if (minPercent > 0 && salePercet == 0) {
            //最低折扣与商品分类折扣对比 按照折扣高的打折
            goodsDiscount = minPercent > classDiscountPercent ? minPercent : classDiscountPercent;
        } else if (minPercent == 0 && salePercet > 0) {
            //特价折扣与商品分类折扣对比 按照折扣低的打折
            goodsDiscount = salePercet > classDiscountPercent ? classDiscountPercent : salePercet;
        } else {
            //当程序出现bug时让默认折扣为1
            goodsDiscount = 1;
        }
    }
    return goodsDiscount;
}
//计算商品的积分折扣
function pointCalculate(item) {
    var pointDiscount = 0;
    //判断是否是会员 global_mem.MemLevelID==undefined表示非会员
    if (!global_mem.memlevelid) {
        pointDiscount = 0;
    } else {
        var parms = parseInt(item.point);
        if (parms == -1) {
            //表示不积分
            pointDiscount = 0;
        } else if (parms == 0) {
            //按照商品分类积分比例积分
            pointDiscount = parseFloat(item.classpointpercent);
        } else if (parms > 0) {
            //按照商品拥有的积分计算
            pointDiscount = 2;
        } else {
            pointDiscount = 0;
        }
    }
    return pointDiscount;
}

//计算购买某种商品获得的积分
function getPoint(goodsPointDiscount, point, expMoney, expNum) {//积分比例 商品积分 折后总金额  购买数量
    var currentPoint = 0;
    var pointCalculate = parseFloat(goodsPointDiscount);
    if (pointCalculate == 2) {
        currentPoint = parseInt(accMul(point, expNum));
    } else if (pointCalculate == -1) {
        currentPoint = 0;
    } else {
        currentPoint = parseInt(accMul(expMoney, pointCalculate));
    }
    return currentPoint;
}