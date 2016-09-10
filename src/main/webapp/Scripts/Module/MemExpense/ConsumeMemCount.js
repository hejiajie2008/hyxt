/*************************************************************************************************************
计次消费页面JS处理
**************************************************************************************************************/
var pageSize = 10;
var currentPage = 1;
var key = "", keyBarCode = "";       //搜索的值
var totalNumber = 0, totalPoint = 0, totalMoney = 0, totalDiscount = 0, totalStaffMoney = 0; //汇总数据初始化
var GoodsList = new Array();
var type = 0;       //判断是计次消费还是普通消费
var isChangeStaff = 0; //是否为整单提成
var staffPercent = 0; //选择整单提成时员工的提成比例
var isEmptyBillsExpense = false;
var order = 0;
$(document).ready(function () {
    //页签 切换页签方法
    $("#liService").css("display", "none");
    //搜索按钮响应的事件
    $("#btnGoodsSearch").bind("click", btnGoodsSearch);
    //消费时间绑定日期控件
    $('#txtExpenseTime').bind("focus click", function () {
        WdatePicker({ skin: 'ext', dateFmt: 'yyyy-MM-dd HH:mm', maxDate: '%y-%M-%d %H:%m:%s', isShowClear: false, readOnly: true });
    });
    //结算按钮响应的事件
    $("#btnExpenseSave").bind("click", ExpenseSave);
    
    
    $("#txtExpenseTime").val($.getnowtime());

    //输入消费金额得到折后金额和积分
    //  $("#txtExpMoney").bind("keyup", DiscountMoney);

    $("#findTable").removeAttr("style");
    $("#findTable").css("width", "100%");
    $("#tdExpense").css("vertical-align", "top")
    $("#tbTop").css("width", "100%");
    $("#tbBody").css("width", "100%");
    if ($("#MemCard").val() != null && $("#MemCard").val() != "0") {
        $("#txtFindMember").val($("#MemCard").val());
    }
    else {
        $("#chkNoMember").attr("checked", "checked");
        var orderID = $("#txtOrderID").val();
        GetExpenseDetail(orderID);
    }
});

function pageHeight() {
    if ($.browser.msie) {
        return document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight :
document.body.clientHeight;
    } else {
        return self.innerHeight;
    }
};

/****************************************************************************************************
*输入商品名称或简码后  回车响应事件
*****************************************************************************************************/
function getKey() {
    if (event.keyCode == 13) {
        var strErrorMsg = "";
        if ($.isEmptyObject(global_mem)) {
            strErrorMsg += "<li>请先选择会员!</li>";
            art.dialog({
                title: '系统提示',
                content: strErrorMsg,   //弹出层显示文本
                icon: 'error', //图标
                lock: true//是否锁定背景
            });
            return false;
        }
        else {
            key = $("#txtGoodsCode").val()
            ServingProductList();
        }
    }
}

/****************************************************************************************************
*搜索按钮响应事件
*****************************************************************************************************/
function btnGoodsSearch() {
    var strErrorMsg = "";
    if ($.isEmptyObject(global_mem)) {
        strErrorMsg += "<li>请先选择会员!</li>";
        art.dialog({
            title: '系统提示',
            content: strErrorMsg,   //弹出层显示文本
            icon: 'error', //图标
            lock: true//是否锁定背景
        });
        return false;
    }
    else {
        key = $("#txtGoodsCode").val()
        ServingProductList();
    }
}

/****************************************************************************************************
*获取计次项目
*****************************************************************************************************/
function ServingProductList() {
	
    doAjax(
               "MemExpense",
               "/GetServingProductList.do",
               {
                   "pageSize": pageSize,
                   "page": currentPage,
                   "key": key,
                   "countdetailmemid": global_mem.memid
               },
               "json",
               function (json) {
            	   
                   CreateServingProductTable(json.rows);
                   CreateServingProductPager(json.total)
               });
}
/****************************************************************************************************
*创建计次项目表格
*****************************************************************************************************/
/**item.countdetailgoodsid **/
function CreateServingProductTable(obj) {
    var html = '';
    if (obj.length > 0) {
        $.each(obj, function (index, item) {
            var bg = index % 2 == 0 ? "#eee" : "#fff";
            html += "<tr class=\"td\" onclick=\"javascript:ExSelectGoods(" + item.goodsid + "," + 1 + "," + index + "," + item.number + ");\">"
                        + '<td style="text-align: left">' + item.name + '</td>'
                        + '<td style="text-align: left">' + item.unit + '</td>'
                        + '<td style="text-align: right"><span id="txtTotalCount' + index + '">' + item.number + '</span></td>'
                        + '</tr>';
        });
    }
    else {
        html += '<td style="height:50px; line-height:50px;padding-left:20px; background-color:#fff;" colspan="5">未找到符合此条件的数据！请重试！</td>';
    }

    $("#tbServingProduct").html(html);
}
/****************************************************************************************************
*创建分页
*****************************************************************************************************/
function CreateServingProductPager(resCount) {
    var page = new CommonPager(
            "ServingProductPage",
            pageSize,
            resCount,
            currentPage,
            function (p) {
                currentPage = parseInt(p);
                ServingProductList();
            }
        );
    page.ShowSimple();
}

/****************************************************************************************************
*将左边列表中的数据放到右边列表中
*****************************************************************************************************/
var chkNoMember;
//选择商品，加入到消费购物车
function ExSelectGoods(goodsID, type, index,  number) {
    chkNoMember = $("#chkNoMember").attr("checked");
    if (!chkNoMember && $.isEmptyObject(global_mem)) {
        art.dialog({
            icon: 'error', //图标
            content: '请先选择会员!',
            lock: true
        });
        return false;
    }
    doAjax(
               "MemExpense/",
               "GetGoodsInfo.do",
               {
                   "goodsid": goodsID,
                   "memlevelid": global_mem.memlevelid == undefined ? -1 : global_mem.memlevelid
               },
               "json",
               function (json) {
            	 
                   ExSelectGoodsOK(json, type, index,  number);
               });
}

function ExSelectGoodsOK(json, type, line,  number) {
    var index = -1;
    if (type == 0) {
        for (var i = 0; i < GoodsList.length; i++) {
            if (GoodsList[i].goodsid == json[0].goodsid && GoodsList[i].expnum > 0) {
                index = i;
            }
        }
    }
    else {
        for (var i = 0; i < GoodsList.length; i++) {
            if (GoodsList[i].goodsid == json[0].goodsid && GoodsList[i].expnum < 0) {
                index = i;
            }
        }
    }
    //这是某件商品第一次被选中销售时
    if (index == -1) {
    	
        json[0]["price"] = 0;
        if ($("#txtTotalCount" + line).text() == "0") {
            var strErrorMsg = "";
            strErrorMsg += "<li>已超所选项目剩余次数！</li>";
            art.dialog({
                title: '系统提示',
                icon: 'error', //图标
                content: strErrorMsg,
                lock: true
            });
            return false;
        }
        json[0]["expnum"] = -1;
        json[0]["exppoint"] = 0;
        json[0]["expmoney"] = 0;
        json[0]["commissiontype"] = json[0].commissiontype;
        json[0]["commissionnumber"] = json[0].commissionnumber;
        json[0]["orderdetailid"] = 0;
       
        GoodsList.push(json[0]);
    }
    else {
        var currentNum = parseInt(GoodsList[index].expnum) - 1;
        if (Math.abs(currentNum) > $("#txtTotalCount" + line).text()) {
            var strErrorMsg = "";
            strErrorMsg += "<li>已超所选项目剩余次数！</li>";
            art.dialog({
                title: '系统提示',
                icon: 'error', //图标
                content: strErrorMsg,
                lock: true
            });
            return false;
        }
        var currentPoint = 0;
        var currentMoney = 0;
        GoodsList[index].exppoint = currentPoint;
        GoodsList[index].expmoney = currentMoney;
        GoodsList[index].expnum = currentNum;
    }
    json[0]["number"] = number;
    ExGoodsBindList();
}
/****************************************************************************************************
* 切换用户时，刷新已选商品列表（相关价格需要重新计算过）
*****************************************************************************************************/
function ExSelectGoodsRefreshList() {
    var newGoodsList = new Array();
    GoodsList = newGoodsList;
    ExGoodsBindList();
}
/****************************************************************************************************
*将选择好的产品绑定到右侧列表中
*****************************************************************************************************/
function ExGoodsBindList() {
    $("#tbOrderTable").html("");
    for (var i = 0; i < GoodsList.length; i++) {
        var color = GoodsList[i].goodstype == "0" ? "Black" : "#ff4800";
        var html = '<tr class="td" >'
        if (GoodsList[i].goodstype == 1) {
            html += '<td style="color:#ff4800;text-align: left">' + GoodsList[i].name + '</td>'
        }
        else {
            html += '<td style="text-align: left">' + GoodsList[i].name + '</td>'
        }
        html += '<td><input id="txtServicePrice' + GoodsList[i].goodsid + '" type="text" disabled="disabled"  class="border_radius common_ServiceButton border_radius2"  value="' + GoodsList[i].price + '"/></td>'
            + '<td><input id="txtServiceNumber' + GoodsList[i].goodsid + '"  type="text" disabled="disabled" class="border_radius common_ServiceButton border_radius3"  value="' + GoodsList[i].expnum + '" ></td>'
            + '<td><input id="txtServiceDiscountPrice' + GoodsList[i].goodsid + '" disabled="disabled" type="text" class="border_radius common_ServiceButton border_radius2"  value="' + GoodsList[i].expmoney + '" /></td>'
            + '<td><input id="txtServicePoint' + GoodsList[i].goodsid + '" disabled="disabled" type="text" class="border_radius common_ServiceButton border_radius3"  value="' + GoodsList[i].exppoint + '"/></td>'
        html += '<td class=\"listtd\" style=\"width: 60px;\"><a href="javascript:void(0);" onclick="javascript:JianShaoItem(' + GoodsList[i].goodsid + ',' + GoodsList[i].expnum + ');"><img src=\"../images/Gift/abolish.png\" alt=\"减少数量\" title=\"减少数量\" /></a>  <a href="javascript:void(0);" onclick="javascript:ExDeleteItem(' + GoodsList[i].goodsid + ',' + GoodsList[i].expnum + ');"><img src=\"../images/Gift/del.png\" alt=\"删除此项\" title=\"删除此项\" /></a> </td>'
        html += '</tr>';

        $("#tbOrderTable").append(html);
    }

    html = '<tr id="tdExpenseTotal"><td colspan="8" style="height:30px; line-height:30px; background-color:#ddeeff;padding:0px 5px 0px 5px;"></td></tr>';

    $("#tbOrderTable").append(html);
    ExGoodsBindTotal();
}

/****************************************************************************************************
*绑定消费合计
*****************************************************************************************************/
function ExGoodsBindTotal() {
    totalNumber = totalPoint = totalMoney = totalDiscount = totalStaffMoney = 0;
    for (var i = 0; i < GoodsList.length; i++) {
        totalNumber = accAdd(totalNumber, Math.abs(GoodsList[i].expnum));

        totalMoney = accAdd(totalMoney, accMul(GoodsList[i].price, GoodsList[i].expnum));

        totalDiscount = accAdd(totalDiscount, GoodsList[i].expmoney);
        if (chkNoMember) {
            totalPoint = 0;
        }
        else {
            totalPoint = accAdd(totalPoint, GoodsList[i].exppoint);
        }
    }
    totalPoint = Math.floor(totalPoint);
    if (GoodsList.length != 0) {
        var strTotalhtml = "";
        $("#lblTotalNumber").html(totalNumber);
        $("#lblTotalMoney").html(totalMoney);
        $("#lblTotalDiscountMoney").html(totalDiscount);
        $("#lblTotalPoint").html(totalPoint);
        $("#lblStaffMoney").html(totalStaffMoney);
    }
    else {
        $("#lblTotalNumber").html("0");
        $("#lblTotalMoney").html("0");
        $("#lblTotalDiscountMoney").html("0");
        $("#lblTotalPoint").html("0");
        $("#lblStaffMoney").html("0");
        $("#tbOrderTable").html('<td colspan="8" style="height:30px; line-height:30px;padding:0px 5px 0px 5px;">请点击左侧商品列表，选择需要消费的商品！</td>');
    }
}

/****************************************************************************************************
*更改数量 重新计算合计
*****************************************************************************************************/
function ExUpdateNumber(goodsID, type) {
    var intNumber = (type == 0) ? $("#txtNumber" + goodsID).val() : $("#txtServiceNumber" + goodsID).val();
    if (intNumber == "" || intNumber == "0") {
        intNumber = "1";
    }

    //    var index = -1;
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == goodsID && GoodsList[i].expnum > 0) {
            //            index = i;
            if (GoodsList[i].goodstype == 0) {
                var Number;
                if (isEmptyBillsExpense) {
                    Number = GoodsList[i].oldnum;
                }
                else {
                    Number = parseInt(GoodsList[i].number);
                }
                if (parseInt(intNumber) > Number) {
                    var strErrorMsg = "";
                    strErrorMsg += "<li>你选择的商品超过了该商品的库存最大值！</li>";
                    art.dialog({
                        title: '系统提示',
                        icon: 'error', //图标
                        content: strErrorMsg,
                        lock: true
                    });
                    $("#txtNumber" + goodsID).val(GoodsList[i].expnum);
                    return false;
                }
                if (!intNumber.IsNumber()) {
                    art.dialog({
                        title: '系统提示',
                        icon: 'error', //图标
                        content: '购买商品的数量只能为数字且大于0,请重新输入',
                        lock: true
                    });
                    intNumber = 1;
                    GoodsList[i].expnum = 1;
                    if (chkNoMember) { //散客消费
                        GoodsList[i].exppoint = 0;
                        //GoodsList[i].ExpMoney = accMul(GoodsList[i].Price, intNumber);
                        GoodsList[i].expmoney = accMul(accMul(GoodsList[i].price, GoodsList[i].expdiscount), intNumber);
                    }
                    else {
                        GoodsList[i].expmoney = parseFloat(accMul(accMul(GoodsList[i].price, intNumber), GoodsList[i].expdiscount)).toFixed(2);
                        GoodsList[i].exppoint = getPoint(GoodsList[i]["exppointdiscount"], GoodsList[i].point, GoodsList[i].expmoney, intNumber);
                    }
                    $("#txtNumber" + goodsID).val(intNumber);
                    $("#txtDiscountPrice" + goodsID).val(GoodsList[i].expmoney);
                    $("#txtPoint" + goodsID).val(GoodsList[i].exppoint);
                    ExGoodsBindTotal();
                    return false;

                }
            }
            GoodsList[i].expnum = intNumber;
            break;
        }
    }
    if (chkNoMember) { //散客消费
        GoodsList[i].exppoint = 0;
        //GoodsList[i].ExpMoney = accMul(GoodsList[i].Price, intNumber);
        GoodsList[i].expmoney = accMul(accMul(GoodsList[i].price, GoodsList[i].expdiscount), intNumber);
    }
    else {
        GoodsList[i].expmoney = parseFloat(accMul(accMul(GoodsList[i].price, intNumber), GoodsList[i].expdiscount)).toFixed(2);
        GoodsList[i].exppoint = getPoint(GoodsList[i]["exppointdiscount"], GoodsList[i].point, GoodsList[i].expmoney, intNumber);
    }
    $("#txtNumber" + goodsID).val(intNumber);
    $("#txtDiscountPrice" + goodsID).val(GoodsList[i].expmoney);
    $("#txtPoint" + goodsID).val(GoodsList[i].exppoint);
    ExGoodsBindTotal();
}
/****************************************************************************************************
*刪除单个产品
*****************************************************************************************************/
function ExDeleteItem(goodsID, goodsNumber) {
    var newGoodsList = new Array();
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid != goodsID) {
            newGoodsList.push(GoodsList[i]);
        }
        else {
            if (GoodsList[i].expnum != goodsNumber) {
                newGoodsList.push(GoodsList[i]);
            }
        }
    }
    GoodsList = newGoodsList;
    ExGoodsBindList();
}

/****************************************************************************************************
*减少单个产品的数量
*****************************************************************************************************/
function JianShaoItem(goodsID, goodsNumber) {
    //只有一个商品的时候  不可以减少
    if (goodsNumber != -1) {
        for (var i = 0; i < GoodsList.length; i++) {
            if (GoodsList[i].goodsid == goodsID) {
                if (GoodsList[i].expnum = goodsNumber) {
                    GoodsList[i].expnum += 1;
                }
            }
        }
        ExGoodsBindList();
    }
    else {
        art.dialog({
            title: '系统提示',
            icon: 'error', //图标
            content: "产品数量不可少于一件！",
            time: 3,
            lock: true
        });
    }
}

/****************************************************************************************************
*选择散客是响应事件
*****************************************************************************************************/
function ClkchkNoMember() {
    var newGoodsList = new Array();
    GoodsList = newGoodsList;
    var clearglobal_mem = new Array();
    global_mem = clearglobal_mem;

    $("#tab0").click();
    ExGoodsBindList();
    $("#sltStaff").val("");

}
/****************************************************************************************************
*挂单按钮响应事件
*****************************************************************************************************/
function btnEntryOrder() {
    var strErrorMsg = "";
    var strOrderCode = $.trim($("#spOrderAccount").html());
    staff = $("#chkStaff").attr("checked");
    if ($.isEmptyObject(global_mem)) {
        strErrorMsg += "<li>散客不允许挂单，请先选择会员再进行挂单操作！</li>";
    }
    if (GoodsList.length == 0) {
        strErrorMsg += "<li>请在左侧列表中选择需要消费的商品！</li>";
    }
    var num = 0;
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].expnum < 0) {
            num = 1;
        }
    }
    if (num != 0) {
        strErrorMsg += "<li>消费商品中含有计次的服务类商品，不可挂单！</li>";
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

    art.dialog({
        content: '正在进行挂单操作，是否挂单？',
        ok: function () {
            var parameter = new Array();
            parameter.push({ "payType": "EmptyBills", "IsCard": false, "IsCash": false, "IsBink": false, "CardMoney": 0, "CashMoney": 0, "CouponMoney": 0, "BinkMoney": 0, "DiscountMoney": parseFloat(totalDiscount) });
            ExpenseOK(parameter);
        },
        cancelVal: '取消',
        cancel: true
    });
}
/****************************************************************************************************
*结算按钮响应事件
*****************************************************************************************************/
function ExpenseSave() {
    var strErrorMsg = "";
    var chkAllowPwd = $("#chkAllowPwd").attr("checked");
    chkNoMember = $("#chkNoMember").attr("checked");
    staff = $("#chkStaff").attr("checked");
    var strOrderCode = $.trim($("#spOrderAccount").html());
    if (GoodsList.length == 0) {
        strErrorMsg += "<li>请在左侧列表中选择需要消费的商品！</li>";
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
        parameter.push({ "payType": "CountExpense", "IsCard": 0, "IsCash": 0, "IsBink": 0, "CardMoney": 0, "CashMoney": 0, "CouponMoney": 0, "BinkMoney": 0, "DiscountMoney": 0, "ChangeMoney": 0 });
        ExpenseOK(parameter);
        return;
    }
    ShowPay("CountExpense", global_mem.memmoney, totalDiscount, strOrderCode, chkAllowPwd);
}

function ExpenseOK(parameter) {
    //获取打印份数
    var PointNum = $("#PointNum").val();
    $.ajax({
        type:'POST',
        url:project_name+'MemExpense/CountExpense.do',
        dataType:"json",      
        contentType:"application/json",   
        data:JSON.stringify({
                "ordermemid": chkNoMember ? "0" : global_mem.memid,
                 "detail": parameter,
                "ordertotalmoney": totalMoney,
                "staffmoney": totalStaffMoney,
                "orderpoint": totalPoint,
                "number": totalNumber,
                "orderaccount": $.trim($("#spOrderAccount").html()),
                "orderremark": $("#txtExRemark").val(),
               // "print": $("#chkPrint").attr("checked"),
                //"sendsms": $("#chkSMS").attr("checked"),
                "staff": $("#chkStaff").attr("checked"),
                "details": GoodsList,
                "count": GoodsList.length,
                "expensetime": $("#txtExpenseTime").val(),
                "staffName": $("#sltStaff").val(),
                "isemptybillsexpense": isEmptyBillsExpense,
                "orderid": order,
                "ismemcountexpense": 1
            }),
            success:
            function (json) {
                switch (json) {
                    case 0:
                        art.dialog
                                 ({
                                     title: '系统提示',
                                     time: 4,
                                     content: ("系统异常，未保存数据，请再次点击保存！"),
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
                                  time: 2,
                                  content: ("消费成功！短信余额不足，不能发送短信，请充值短信！"),
                                  close: function () { PrintMemCountExpense($("#lblExpenseUSer").html(), global_mem, GoodsList, parameter, $("#chkPrint").attr("checked"), PointNum); }
                              });
                        break;
                    case -3:
                        art.dialog
                              ({
                                  title: '系统提示',
                                  time: 2,
                                  content: '会员挂单成功！',
                                  close: function () { location.href = window.location.reload(); }
                              });
                        break;
                    default:
                        art.dialog
                                ({
                                    title: '系统提示',
                                    time: 2,
                                    content: '消费成功！' + json.strUpdateMemLevel,
                                    close: function () { PrintMemCountExpense($("#lblExpenseUSer").html(), global_mem, GoodsList, parameter, $("#chkPrint").attr("checked"), PointNum); }
                                });
                        break;
                }
            }
    });
}

/****************************************************************************************************
*在选择好会员时可以执行回调函数
*****************************************************************************************************/
function FindMember_CallBack() {
    var strErrorMsg;
    if (global_mem.memstate != 0) {
        strErrorMsg = "当前会员卡处于锁定或者挂失状态，暂不允许进行消费。";
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
    ServingProductList();
    return true;
}