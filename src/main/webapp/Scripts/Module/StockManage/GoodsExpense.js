/*************************************************************************************************************
商品消费页面JS处理
**************************************************************************************************************/
var expenseTab;
var pageSize = 10;
var currentPage = 1;
var key = "", keyBarCode = "";       //搜索的值
var totalNumber = 0, totalPoint = 0, totalMoney = 0, totalDiscount = 0, totalStaffMoney = 0; //汇总数据初始化
var GoodsList = new Array();
var levelPoint, levelPercent;       //会员消费兑换积分比例 会员等级比例
var type = 0;       //判断是计次消费还是普通消费
var staff;      //是否启动员工提成
var staffType;  //提成类型 按商品还是按员工
var isChangeStaff = 0; //是否为整单提成
var staffPercent = 0; //选择整单提成时员工的提成比例
var isEmptyBillsExpense = false;
var order = 0;
$(document).ready(function () {
    //判断是否启用员工提成
    staff = $("#chkStaff").attr("checked");
    if (!staff) {
        $("#tdStaff").css("display", "none");
        $("#tddStaff").css("display", "none");
        $("#thStaff").css("display", "none");
    }
    else {
        $("#tdStaff").css("display", "");
        $("#tddStaff").css("display", "");
        $("#thStaff").css("display", "");
    }
    staffType = $("#txtStaffType").val();
    //普通商品
    GoodsProductList();
    //搜索按钮响应的事件
    $("#btnGoodsSearch").bind("click", btnGoodsSearch);
   
    $('#txtExpenseTime').val($.getnowdate());
    //消费时间绑定日期控件
    $('#txtExpenseTime').bind("focus click", function () {
        WdatePicker({ skin: 'ext', dateFmt: 'yyyy-MM-dd HH:mm', maxDate: '%y-%M-%d %H:%m:%s', isShowClear: false, readOnly: true });
    });
    
    //选择散客响应的事件
    $("#chkNoMember").bind("click", ClkchkNoMember);
    //结算按钮响应的事件
    $("#btnExpenseSave").bind("click", ExpenseSave);
    //挂单按钮响应的事件
    $("#btnEntryOrder").bind("click", btnEntryOrder);

    //根据是否启动员工提成 来显示或隐藏员工下拉框
    if (!staff) {
        $("#sltStaff").attr("disabled", "disabled");
    }
    else {
        $("#sltStaff").attr("disabled", "");
        //下拉框选择响应事件     
        $("#sltStaff").bind("change", changeAllStaff);
    }
    $("#findTable").removeAttr("style");
    $("#findTable").css("width", "100%");
    $("#tbTop").css("width", "100%");
    $("#tbBody").css("width", "100%");

    if ($("#MemCard").val() != null && $("#MemCard").val() != "0") {
        $("#txtFindMember").val($("#MemCard").val());
    }
    else {
        $("#chkNoMember").attr("checked", "checked");
        chkNoMember = true;
        isEmptyBillsExpense = true;
        order = $("#txtOrderID").val();
        GetExpenseDetail(order);
    }

    $("#txtGoodsExpenseCode").keyup(function (e) {
        var keyAscii = window.event ? e.keyCode : e.which;
        if (keyAscii == 13 && $.trim($("#txtGoodsExpenseCode").val()) != "") {
            keyBarCode = $("#txtGoodsExpenseCode").val();
            SelectGoodsByBarCode();
        }
    });
});

//尝试读取挂单信息
function GetExpenseDetail(orderID) {
    doAjax(
        "../",
        "GetOrderEmptyBills",
        { "orderID": orderID },
        "json",
        function (json) {
            if (json != null) {
                $.each(json, function (index, item) {
                    var obj = {}
                    obj["orderdetailpoint"] = item.orderdetailpoint;
                    obj["orderdetaildiscountprice"] = item.orderdetaildiscountprice;
                    obj["orderdetailnumber"] = item.orderdetailnumber;
                    obj["commissiontype"] = item.commissiontype;
                    obj["commissionnumber"] = item.commissionnumber;
                    obj["expstaffmoney"] = 0;
                    obj["expstaffname"] = 0;
                    obj["expstaffpercent"] = 0;
                    obj["goodstype"] = item.goodstype;
                    obj["price"] = item.price;
                    obj["goodsid"] = item.goodsid;
                    obj["goodscode"] = item.goodscode;
                    obj["name"] = item.name;
                    obj["number"] = item.number;
                    obj["point"] = item.point;
                    obj["expdiscount"] = item.classdiscountpercent == "" ? "1.00" : item.classdiscountpercent;
                    obj["exppointdiscount"] = item.classpointpercent == "" ? "9999999999" : item.classpointpercent;
                    obj["orderdetailid"] = item.orderdetailid;
                    obj["oldnum"] = parseInt(item.orderdetailnumber) + parseInt(item.number);
                    GoodsList.push(obj);
                });
                ExGoodsBindList();
            }
        }
     );
}

//扫描枪快速定位
function SelectGoodsByBarCode() {
    if ($("#chkNoMember").attr("checked")) {
        isShanKe = true;
    }
    else {
        if ($.isEmptyObject(global_mem)) {
            art.dialog({
                icon: 'error', //图标
                content: '请先选择会员!',
                lock: true
            });
            $("#txtFindMember").select();
            $("#txtGoodsExpenseCode").val("");
            return false;
        }
    }
    doAjax(
        "../",
        "GetGoodsList",
            {
                "size": 1,
                "index": 1,
                "key": keyBarCode,
                "shopID": $("#ShopID").val(),
                "bolGoodsExpense": true,
                "ClassID": "",
                "IsCheckStock": false, //是否检查库存；库存要大于0
                "MemLevelID": global_mem.memlevelid == undefined ? -1 : global_mem.memlevelid
            },
        "json",
        function (json) {
            if (json != null) {
                //                var goodsDiscount = calculate(json.List[0]); //获得商品的折扣率
                //                var goodsDiscountPrcie = accMul(json.List[0].Price, goodsDiscount).toFixed(2); //计算商品的折后金额
                //                var pointDiscount = pointCalculate(json.List[0]); //计算商品的积分比例
                var goodsDiscount = json.List[0].goodsdiscount;
                
                var goodsDiscountPrcie = json.List[0].discountprice;
                var pointDiscount = json.List[0].pointdiscount;
                
                ExSelectGoods(json.List[0].goodsid, 0, goodsDiscount, pointDiscount);
            }
            $("#txtGoodsExpenseCode").select();
            $("#RechargeCount_BarCode").select();
        }
     );
}

function pageHeight() {
    if ($.browser.msie) {
        return document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight :
document.body.clientHeight;
    } else {
        return self.innerHeight;
    }
};
/****************************************************************************************************
*下拉框改变响应事件
*****************************************************************************************************/
function changeAllStaff() {
    if ($("#sltStaff").val() != "") {
         
        //整单提成
        isChangeStaff = 1;
        staffPercent = $("#sltStaff").find("option:selected").attr("ClassPercent");
        // $("select[name='sltStaff']").find("option[value='" + $("#sltStaff").val() + "']").attr("selected", true);
         $("select[id ^=staff]").each(function () {
             $(this).attr("value", $("#sltStaff").val().toString()).trigger("change");
                //$(this).attr("disabled", "disabled");
            });
    }
    else {
        isChangeStaff = 0;
        $("#lblStaffMoney").val("0"); 
    }
//    ExGoodsBindList();

    ExGoodsBindTotal();
}
/****************************************************************************************************
*搜索按钮响应事件
*****************************************************************************************************/
function btnGoodsSearch() {
    key = $("#txtGoodsCode").val()
    currentPage = 1;
    GoodsProductList();
}

/****************************************************************************************************
*输入商品名称或简码后  回车响应事件
*****************************************************************************************************/
function getKey() {
    if (event.keyCode == 13) {
        key = $("#txtGoodsCode").val()
        currentPage = 1;
        GoodsProductList();
    }
}

/****************************************************************************************************
*获取商品
*****************************************************************************************************/
function GoodsProductList() {
	
    doAjax(
           "StockManager/",
           "GetGoodsList.do",
           {
               "pageSize": pageSize,
               "page": currentPage,
               "key": key,
               "shopid": $("#ShopID").val(),
               "bolgoodsexpense": 0,
               "goodsclassid": "",
               "ischeckstock": 1, //是否检查库存；库存要大于0
               "memlevelid": global_mem.memlevelid == undefined ? -1 : global_mem.memlevelid
           },
           "json",
           function (json) {
        	   
               CreateGoodsProductTable(json.rows);
               CreateGoodsProductPager(json.total);
           });
}
/****************************************************************************************************
*创建表格
*****************************************************************************************************/
function CreateGoodsProductTable(obj) {
    var html = '';
    if (obj.length > 0) {
        $.each(obj, function (index, item) {
            //var goodsDiscount = item.goodsdiscount;
        	var goodsDiscount = item.goodsdiscount;
        
            var goodsDiscountPrcie = item.discountprice;
           
            var pointDiscount = item.pointdiscount;
            
           
            //            var goodsDiscount = calculate(item); //获得商品的折扣率
            //            var goodsDiscountPrcie = accMul(item.price, goodsDiscount).toFixed(2); //计算商品的折后金额
            //            var pointDiscount = pointCalculate(item); //计算商品的积分比例
            html += "<tr class=\"td\" onclick=\"javascript:ExSelectGoods(" + item.goodsid + "," + 0 + "," + goodsDiscount + "," + pointDiscount + ");\">"
            if (item.goodstype == 0) {
                html += '<td style="text-align: left">' + item.name + '</td>'
            }
            else {
                html += '<td style="text-align: left;color:red" >' + item.name + '</td>'
            }
            html += '<td style="text-align: right"><b>' + parseFloat(item.price).toFixed(2) + '</b></td>'
                 + '<td style="text-align: right">' + item.goodsnumber + '</td>'
            //            if (item.point != -1) {
            //                html += '<td>' + item.point + '</td>'
            //            }
            //            else {
            //                html += '<td>不积分</td>'
            //            }
            html += '<td style="text-align: right">' + goodsDiscountPrcie + '</td>';
            html += '</tr>';
        });
    }
    else {
        html += '<td style="height:50px; line-height:50px;padding-left:20px; background-color:#fff;" colspan="5">未找到符合此条件的数据！请重试！</td>';
    }

    $("#tbGoodsProduct").html(html);
}
/****************************************************************************************************
*根据商品类型ID获取名称
*****************************************************************************************************/
function GetGoodsType(goodsType) {
    var strGoorsType;
    if (goodsType == 0) {
        strGoorsType = "普通商品";
    }
    else {
        strGoorsType = "服务商品";
    }
    return strGoorsType;
}

/****************************************************************************************************
*分页
*****************************************************************************************************/
function CreateGoodsProductPager(resCount) {
    var page = new CommonPager(
        "GoodsProductPage",
        pageSize,
        resCount,
        currentPage,
        function (p) {
            currentPage = parseInt(p);
            GoodsProductList();
        }
    );
    page.ShowSimple();
}

/****************************************************************************************************
*将左边列表中的数据放到右边列表中
*****************************************************************************************************/
var chkNoMember;
//选择商品，加入到消费购物车
function ExSelectGoods(goodsID, type, index, pointDiscount) {
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
               "StockManager/",
               "GetGoodsInfo.do",
               {
                   "goodsid": goodsID,
                   "memlevelid": global_mem.memlevelid == undefined ? -1 : global_mem.memlevelid
               },
               "json",
               function (json) {
            	
                   ExSelectGoodsOK(json, type, index, pointDiscount);
               });
}

function ExSelectGoodsOK(json, type, line, pointDiscount) {
    var index = -1;
   
    if (type == 0) {
        for (var i = 0; i < GoodsList.length; i++) {
            if (GoodsList[i].goodsid == json[0].goodsid && GoodsList[i].orderdetailnumber > 0) {
                index = i;
            }
        }
    }
    else {
        for (var i = 0; i < GoodsList.length; i++) {
            if (GoodsList[i].goodsid == json[0].goodsid && GoodsList[i].orderdetailnumber < 0) {
                index = i;
            }
        }
    }
   
    //这是某件商品第一次被选中销售时
    if (index == -1) {
        //如果为商品消费
        if (type == 0) {
        	
        	
            if (json[0]["goodstype"] == 0 && json[0]["number"] == 0) {
                var strErrorMsg = "";
                strErrorMsg += "<li>你选择的商品超过了该商品的库存最大值！</li>";
                art.dialog({
                    title: '系统提示',
                    icon: 'error', //图标
                    content: strErrorMsg,
                    lock: true
                });
                return false;
            }
            json[0]["expdiscount"] = line;

            json[0]["exppointdiscount"] = pointDiscount;
            
            if (json[0].goodstype == 0) {
            	
                if (parseFloat(json[0].number) < (1.00)) {
                    json[0]["orderdetailnumber"] = parseFloat(_sys_check.defval);
                } else {
                    json[0]["orderdetailnumber"] = 1;
                }
            } else {
                json[0]["orderdetailnumber"] = 1;
            }
            
            if (chkNoMember)//散客消费
            {
                json[0]["orderdetailpoint"] = 0; //散客消费不计积分
                json[0]["orderdetaildiscountprice"] = accMul(accMul(json[0]["expdiscount"], json[0].price), json[0]["orderdetailnumber"]);
            }
            else {
            	
            	
                json[0]["orderdetaildiscountprice"] = accMul(accMul(json[0]["expdiscount"], json[0].price), json[0]["orderdetailnumber"]);
                
            	
                //如果商品设置了积分，按照商品积分计算
                if (Math.floor(json[0].point) > 0){
                    json[0]["orderdetailpoint"] = Math.floor(json[0].point);
                }
                else{
                	
                    json[0]["orderdetailpoint"] = Math.floor(accDiv(json[0]["orderdetaildiscountprice"], json[0]["exppointdiscount"]));
                }
                
                
            }
            
            
        }
        
//        //会员计次项目
//        else {
//            json[0]["price"] = 0;
//            if ($("#txtTotalCount" + line).text() == "0") {
//                var strErrorMsg = "";
//                strErrorMsg += "<li>你选择的次数超过了剩余次数的最大值！</li>";
//                art.dialog({
//                    title: '系统提示',
//                    icon: 'error', //图标
//                    content: strErrorMsg,
//                    lock: true
//                });
//                return false;
//            }
//            json[0]["orderdetailnumber"] = -1;
//            json[0]["orderdetailpoint"] = 0;
//            json[0]["orderdetaildiscountprice"] = 0;
//            json[0]["commissiontype"] = json[0].commissiontype;
//            json[0]["commissionnumber"] = json[0].commissionnumber;
//        }
        //提成金额
       
       
 


        if (staff && staffType == "0") {
            //按商品类型
            switch (json[0].commissiontype) {
                case "0":
                    json[0]["expstaffmoney"] = 0;
                    break;
                case "1":
                    json[0]["expstaffmoney"] = json[0]["orderdetaildiscountprice"] * json[0].commissionnumber;
                    break;
                default:
                    json[0]["expstaffmoney"] = json[0].commissionnumber;
                    break;
            }
        }
        //按员工提成比例
        else if (staff && staffType == "1") {
            switch (json[0]["goodstype"]) {
                case "0":
                    json[0]["expstaffmoney"] = 0;
                    break;
                case "1":
                    //json[0]["expstaffmoney"] = json[0].commissionnumber;
                    json[0]["expstaffmoney"] = json[0].CommissionNumber;
                    break;
            }
        }
        else if (!staff) {
            json[0]["expstaffmoney"] = 0;
        }
        
        json[0]["expstaffname"] = 0;
        json[0]["expstaffpercent"] = 0;
        if ($("#sltStaff").val() != "") {
            json[0]["expstaffname"] = $("#sltStaff").val();
            json[0]["expstaffpercent"] = $("#sltStaff").find("option:selected").attr("ClassPercent");
            json[0]["expstaffmoney"] = json[0]["orderdetaildiscountprice"] * json[0]["expstaffpercent"];
        }
        json[0]["orderdetailid"] = 0;
        GoodsList.push(json[0]);
    }
    else {
        if (type == 0) {
            //当前消费数量
            var currentNum = parseInt(GoodsList[index].orderdetailnumber) + 1;
            var Number;
            if (isEmptyBillsExpense) {
                Number = GoodsList[index].oldnum;
            }
            else {
                Number = parseInt(GoodsList[index].number);
            }
            if (GoodsList[index].goodstype == 0 && currentNum > Number) {
                var strErrorMsg = "";
                strErrorMsg += "<li>你选择的商品超过了该商品的库存最大值！</li>";
                art.dialog({
                    title: '系统提示',
                    icon: 'error', //图标
                    content: strErrorMsg,
                    lock: true
                });
                return false;
            }
            //如果是散客
            if (chkNoMember) {
                var currentPoint = 0;
                var currentMoney = accMul(accMul(GoodsList[index]["price"], line), currentNum);
            }
            else {
                if (GoodsList[index]["expdiscount"] != "0" && GoodsList[index]["exppointdiscount"] != "0") {
                    var currentMoney = accMul(accMul(GoodsList[index]["price"], GoodsList[index]["expdiscount"]), currentNum);
                }
                else {
                    var currentMoney = accMul(accMul(GoodsList[index]["price"], line), currentNum);
                }
                //如果商品设置了积分，按照商品积分计算
                if (Math.floor(GoodsList[index].point) > 0) {
                    currentPoint = Math.floor(accMul(GoodsList[index].point, currentNum));
                }
                else {
                    currentPoint = Math.floor(accDiv(currentMoney, GoodsList[index]["exppointdiscount"]));
                }
            }
            GoodsList[index].orderdetailpoint = currentPoint;
            GoodsList[index].orderdetaildiscountprice = currentMoney;
            
            GoodsList[index].orderdetailnumber = currentNum;
        }
        else {
            var currentNum = parseInt(GoodsList[index].orderdetailnumber) - 1;
            if (Math.abs(currentNum) > $("#txtTotalCount" + line).text()) {
                var strErrorMsg = "";
                strErrorMsg += "<li>你输入的次数超过了剩余次数的最大值！</li>";
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
            GoodsList[index].orderdetailpoint = currentPoint;
            
            GoodsList[index].orderdetaildiscountprice = currentMoney;
            GoodsList[index].orderdetailnumber = currentNum;
        }
        //重新计算提成
        if (staff && staffType == "False") {
            //按商品类型
            switch (GoodsList[index].commissiontype) {
                case "0":
                    GoodsList[index].expstaffmoney = 0;
                    break;
                case "1":
                    GoodsList[index].expstaffmoney = accMul(GoodsList[index].orderdetaildiscountprice, GoodsList[index].commissionnumber);
                    break;
                default:
                    GoodsList[index].expstaffmoney = Math.abs(accMul(GoodsList[index].commissionnumber, GoodsList[index].orderdetailnumber));
                    break;
            }
        }
        //按员工提成比例
        else if (staff && staffType == "True") {
            switch (GoodsList[index].goodstype) {
                case "0":
                    GoodsList[index].expstaffmoney = 0;
                    break;
                case "1":
                    GoodsList[index].expstaffmoney = Math.abs(accMul(GoodsList[index].commissionnumber, GoodsList[index].orderdetailnumber));
                    break;
            }
        }
        else if (!staff) {
            GoodsList[index].expstaffmoney = 0;
        }
        if ($("#sltStaff").val() != "") {
            GoodsList[index].expstaffname = $("#sltStaff").val();
            //            GoodsList[index].["ExpStaffPercent"] = $("#sltStaff").find("option:selected").attr("ClassPercent");
            GoodsList[index].expstaffmoney = accMul(GoodsList[index].orderdetaildiscountprice, GoodsList[index].expstaffpercent);
        }
    }
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
        var html = '<tr class="td" >';
        
        if (GoodsList[i].goodstype == 1) {
            html += '<td style="color:#ff4800;text-align: left">' + GoodsList[i].name + '</td>'
        }
        else {
            html += '<td style="text-align: left">' + GoodsList[i].name + '</td>'
        }
        if (GoodsList[i].orderdetailnumber > 0) {
            html += '<td><input id="txtPrice' + GoodsList[i].goodsid + '"  type="text" class="border_radius common_ServiceButton border_radius2" style="text-align: right" value="' + parseFloat(GoodsList[i].price).toFixed(2) + '" onkeyup="javascript:ExUpdatePrice(' + GoodsList[i].goodsid + ',' + 0 + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtNumber' + GoodsList[i].goodsid + '" type="text" class="border_radius common_ServiceButton border_radius3" style="text-align: right" value="' + GoodsList[i].orderdetailnumber + '" onkeyup="javascript:ExUpdateNumber(' + GoodsList[i].goodsid + ',' + 0 + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtDiscountPrice' + GoodsList[i].goodsid + '" type="text" class="border_radius common_ServiceButton border_radius2" style="text-align: right" value="' + parseFloat(GoodsList[i].orderdetaildiscountprice).toFixed(2) + '" onkeyup="javascript:ExUpdateDiscountPrice(' + GoodsList[i].goodsid + ',' + 0 + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtPoint' + GoodsList[i].goodsid + '" type="text" class="border_radius common_ServiceButton border_radius3" style="text-align: right" value="' + GoodsList[i].orderdetailpoint + '" onkeyup="javascript:ExUpdatePoint(' + GoodsList[i].goodsid + ',' + 0 + ');" onclick=\"javascript:this.select();\"/></td>'
            //员工下拉框
            + '<td id="td' + i + '"></td>';
           
            html += '<td class=\"listtd\" style=\"width: 30px;\"><a href="javascript:void(0);" onclick="javascript:ExDeleteItem(' + GoodsList[i].goodsid + ',' + GoodsList[i].orderdetailnumber + ');"><img src=\"../images/Gift/del.png\" alt=\"删除此项\" title=\"删除此项\" /></a></td>'
        }
        else {
            //html += '<td style="color:#ff4800">会员计次</td>'
            html += '<td><input id="txtServicePrice' + GoodsList[i].goodsid + '" type="text" disabled="disabled"  class="border_radius common_ServiceButton border_radius2"  value="' + GoodsList[i].price + '" onkeyup="javascript:ExUpdatePrice(' + GoodsList[i].goodsid + ',' + 1 + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtServiceNumber' + GoodsList[i].goodsid + '" disabled="disabled" type="text" class="border_radius common_ServiceButton border_radius3"  value="' + GoodsList[i].orderdetailnumber + '" onkeyup="javascript:ExUpdateNumber(' + GoodsList[i].goodsid + ',' + 1 + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtServiceDiscountPrice' + GoodsList[i].goodsid + '" disabled="disabled" type="text" class="border_radius common_ServiceButton border_radius2"  value="' + GoodsList[i].orderdetaildiscountprice + '" onkeyup="javascript:ExUpdateDiscountPrice(' + GoodsList[i].goodsid + ',' + 1 + ');" onclick=\"javascript:this.select();\"/></td>'
            + '<td><input id="txtServicePoint' + GoodsList[i].goodsid + '" disabled="disabled" type="text" class="border_radius common_ServiceButton border_radius3"  value="' + GoodsList[i].orderdetailpoint + '" onkeyup="javascript:ExUpdatePoint(' + GoodsList[i].goodsid + ',' + 1 + ');" onclick=\"javascript:this.select();\"/></td>'
            //员工下拉框
            + '<td id="td' + i + '"></td>'
            
            html += '<td class=\"listtd\" style=\"width: 30px;\"><a href="javascript:void(0);" onclick="javascript:ExDeleteItem(' + GoodsList[i].goodsid + ',' + GoodsList[i].orderdetailnumber + ');"><img src=\"../images/Gift/del.png\" alt=\"删除此项\" title=\"删除此项\" /></a></td>'
        }
        html += '</tr>';

        $("#tbOrderTable").append(html);
        //克隆下拉框
        var sltStaff = $("#sltStaff");
        var cSltStaff = sltStaff.clone();
        //改变克隆下拉框的ID 一个控件只能有一个唯一的ID
        cSltStaff.attr("id", "staff" + i);
        //将克隆的下拉框追加到<td>里
        $("#td" + i).append(cSltStaff);
        //克隆的下拉框绑定事件 foo为数据参数
        $("#staff" + i).bind("change", { foo: i }, changeStaff);
        //没有启动提成 下拉框禁用
        if (!staff) {
            //            $("#td" + i).attr("disabled", "disabled");
            $("#td" + i).css("display", "none");
        }
        else {
            //$("#td" + i).attr("disabled", "disabled");
            $("#td" + i).css("display", "");
            if ($("#sltStaff").val().toString() != "") {
                $("select[id ^=staff]").each(function () {
                    $(this).attr("value", $("#sltStaff").val().toString());
                    $(this).attr("disabled", "disabled");
                });
            }
            else {
                $("select[id ^=staff]").each(function () {
                    $(this).attr("disabled", "");
                });
            }
             $("#staff" + i).val(GoodsList[i].expstaffname);
//            //如果选择整单提成 克隆的控件全部禁用
//            if (isChangeStaff == 1) {
//                $("#td" + i).attr("disabled", "disabled");
//                //$("#staff" + i).val(GoodsList[i].expstaffname);
//                $("#staff" + i).attr("disabled", "disabled");
//            }
//            else {
//                //$("#td" + i).attr("disabled", "disabled");
//                $("#td" + i).attr("disabled", "");
//                //$("#staff" + i).attr("value", "");
//                $("#staff" + i).attr("disabled", "");
//            }
        }
    }

    html = '<tr id="tdExpenseTotal"><td colspan="8" style="height:30px; line-height:30px; background-color:#ddeeff;padding:0px 5px 0px 5px;"></td></tr>';

    $("#tbOrderTable").append(html);
    ExGoodsBindTotal();
}
//选择员工 改变提成
function changeStaff(event) {
    //重新计算提成
    var obj = event.data.foo;
    
        if (staff && staffType == "False") {
            //按商品类型
            switch (GoodsList[obj].commissiontype) {
                case "0": //不提成
                    GoodsList[obj].expstaffmoney = 0;
                    break;
                case "1": //按商品比例
                    GoodsList[obj].expstaffmoney = accMul(GoodsList[obj].orderdetaildiscountprice, GoodsList[obj].commissionnumber);
                    break;
                default: //按商品固定金额
                    GoodsList[obj].expstaffmoney = accMul(GoodsList[obj].commissionnumber, GoodsList[obj].orderdetailnumber);
                    break;
            }
        }
        //按员工提成比例 
        else if (staff && staffType == "True") {
            var staffPercent = $("#staff" + obj).find("option:selected").attr("ClassPercent");
            //        switch (GoodsList[obj].goodstype) {
            //            case "0":
            //                GoodsList[obj].ExpStaffMoney = accMul(GoodsList[obj].orderdetaildiscountprice, staffPercent);
            //                break;
            //            case "1":
            //                GoodsList[obj].ExpStaffMoney = Math.abs(accMul(GoodsList[obj].CommissionNumber, GoodsList[obj].ExpNum));
            //                break;
            //        }
            GoodsList[obj].expstaffmoney = accMul(GoodsList[obj].orderdetaildiscountprice, staffPercent);
            GoodsList[obj].expstaffpercent = staffPercent;
        }
        else if (!staff) {
            GoodsList[obj].expstaffmoney = 0;
        }
        GoodsList[obj].expstaffname = $("#staff" + obj).val();
        ExGoodsBindTotal();
     
}

/****************************************************************************************************
*绑定消费合计
*****************************************************************************************************/
function ExGoodsBindTotal() {
    totalNumber = totalPoint = totalMoney = totalDiscount = totalStaffMoney = 0;
    for (var i = 0; i < GoodsList.length; i++) {
        totalNumber = accAdd(totalNumber, Math.abs(GoodsList[i].orderdetailnumber));

        totalMoney = accAdd(totalMoney, accMul(parseFloat(GoodsList[i].price), parseFloat(GoodsList[i].orderdetailnumber)));

        totalDiscount = accAdd(parseFloat(totalDiscount), parseFloat(GoodsList[i].orderdetaildiscountprice));
        if (chkNoMember) {
            totalPoint = 0;
        }
        else {
            totalPoint = accAdd(totalPoint, GoodsList[i].orderdetailpoint);
        }
        //totalStaffMoney = accAdd(totalStaffMoney, GoodsList[i].expstaffmoney);
    }


    //    var temp = 0;
    //    for (var i = 0; i < GoodsList.length; i++) {
    //        if (Math.floor(GoodsList[i].orderdetaildiscountprice) != GoodsList[i].orderdetailpoint) {
    //            temp += 1;
    //        }
    //    }
    //    if (temp == 0) {
    //        totalPoint = Math.floor(totalDiscount);
    //    }

    totalStaffMoney = GetAllStaff();
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
//得到提成总金额 整单重新计算
function GetAllStaff() {
    var dclTotalStaffMoney = 0;
    for (var i = 0; i < GoodsList.length; i++) {
        //如果启动提成
        if (staff) {
            //按照员工比例
            if (staffType == "True") {
//                if ($("#sltStaff").val() == "") {
//                    if (GoodsList[i].goodstype == "1") {
//                        dclTotalStaffMoney = accAdd(dclTotalStaffMoney, Math.abs(accMul(GoodsList[i].commissionnumber, GoodsList[i].orderdetailnumber)));
//                    }
//                    else {
//                        dclTotalStaffMoney = accAdd(dclTotalStaffMoney, accMul(GoodsList[i].orderdetaildiscountprice, GoodsList[i].expstaffpercent));
//                    }
//                }
//                else {
//                    if (GoodsList[i].goodstype == "1") {
//                        dclTotalStaffMoney = accAdd(dclTotalStaffMoney, Math.abs(accMul(GoodsList[i].commissionnumber, GoodsList[i].orderdetailnumber)));
//                    }
//                    else {
//                        dclTotalStaffMoney = accAdd(dclTotalStaffMoney, accMul(GoodsList[i].orderdetaildiscountprice, staffPercent));
//                        GoodsList[i].expstaffmoney = accMul(GoodsList[i].orderdetaildiscountprice, staffPercent);
//                    }
                //                }
                GoodsList[i].expstaffmoney = accMul(GoodsList[i].orderdetaildiscountprice, GoodsList[i].expstaffpercent)
                dclTotalStaffMoney = accAdd(dclTotalStaffMoney, GoodsList[i].expstaffmoney);
            }
            //按照商品提成类型
            if ($("#staff" + i).val() != "") {
                if (staffType == "False") {
                    switch (GoodsList[i].commissiontype) {
                        case "0":
                            GoodsList[i].expstaffmoney = 0;
                            break;
                        case "1":
                            GoodsList[i].expstaffmoney = accMul(GoodsList[i].orderdetaildiscountprice, GoodsList[i].commissionnumber);
                            break;
                        default:
                            GoodsList[i].expstaffmoney = Math.abs(accMul(GoodsList[i].commissionnumber, GoodsList[i].orderdetailnumber));
                            break;
                    }
                    dclTotalStaffMoney = accAdd(dclTotalStaffMoney, GoodsList[i].expstaffmoney);
                }
                if ($("#sltStaff").val() != "") {
                    GoodsList[i].expstaffname = $("#sltStaff").val();
                }
            }
        }
        //不启动提成
        else {
            dclTotalStaffMoney = 0;
        }
    }
    return dclTotalStaffMoney;
}

/****************************************************************************************************
*更改单价 重新计算合计
*****************************************************************************************************/
function ExUpdatePrice(goodsID, type) {
    var decPrice = 0;
    if (type == 0) {
        decPrice = $("#txtPrice" + goodsID).val();
        //    var index = -1;
    }
    else {
        decPrice = $("#txtServicePrice" + goodsID).val();
    }
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == goodsID && GoodsList[i].orderdetailnumber > 0) {
            //            index = i;
            if (parseInt(decPrice) < 0) {
                art.dialog({
                    icon: 'error', //图标
                    content: '商品单价不能小于零',
                    lock: true
                });
                decPrice = GoodsList[i].price;
            }
            GoodsList[i].price = decPrice;
            break;
        }
    }
    if (chkNoMember)//散客消费
    {
        GoodsList[i].orderdetailpoint = 0;
        //GoodsList[i].orderdetaildiscountprice = accMul(decPrice, GoodsList[i].orderdetailnumber);
        GoodsList[i].orderdetaildiscountprice = accMul(accMul(decPrice, GoodsList[i].expdiscount), GoodsList[i].orderdetailnumber);
    }
    else {
    	
        GoodsList[i].orderdetaildiscountprice = parseFloat(accMul(accMul(decPrice, GoodsList[i].expdiscount), GoodsList[i].orderdetailnumber)).toFixed(2);
        // GoodsList[i].orderdetailpoint = Math.floor(accDiv(GoodsList[i].orderdetaildiscountprice, GoodsList[i]["exppointdiscount"]));
        if (Math.floor(GoodsList[i].point) > 0) {
            GoodsList[i].orderdetailpoint = Math.floor(accMul(GoodsList[i].point, GoodsList[i].orderdetailnumber));
        }
        else {
            GoodsList[i].orderdetailpoint = Math.floor(accDiv(GoodsList[i].orderdetaildiscountprice, GoodsList[i]["exppointdiscount"]));
        }
    }
    //    //重新计算提成
    //    GetStaffMoney(i);
    //    GoodsList[i].expstaffmoney = accMul(GoodsList[i].orderdetailnumber, GoodsList[i].staffmoney);
    if (type == 0) {
        $("#txtPrice" + goodsID).val(decPrice);
        $("#txtDiscountPrice" + goodsID).val(GoodsList[i].orderdetaildiscountprice);
        $("#txtPoint" + goodsID).val(GoodsList[i].orderdetailpoint);
        ExUpdatePoint(goodsID, type);
    }
    ExGoodsBindTotal();
}
/****************************************************************************************************
*更改数量 重新计算合计
*****************************************************************************************************/
function ExUpdateNumber(goodsID, type) {
    var intNumber = parseFloat((type == 0) ? sys_num_checked.product_num($.trim($("#txtNumber" + goodsID).val())) : $("#txtServiceNumber" + goodsID).val());
    var oldval = (type == 0) ? $.trim($("#txtNumber" + goodsID).val()) : $("#txtServiceNumber" + goodsID).val();
    if (intNumber == "" || intNumber == "0") {
        intNumber = "0";
    }
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == goodsID && GoodsList[i].orderdetailnumber >= 0) {
            if (GoodsList[i].goodstype == 0) {
                var Number;
                if (isEmptyBillsExpense) {
                    Number = GoodsList[i].oldnum;
                }
                else {
                    Number = parseFloat(sys_num_checked.product_num(GoodsList[i].number));
                }
                if (parseFloat(intNumber) > Number) {
                    var strErrorMsg = "";
                    strErrorMsg += "<li>你选择的商品超过了该商品的库存最大值！</li>";
                    art.dialog({
                        title: '系统提示',
                        icon: 'error', //图标
                        content: strErrorMsg,
                        lock: true,
                        colse: function () { $("#txtNumber" + goodsID).val(Number); }
                    });
                    $("#txtNumber" + goodsID).val(GoodsList[i].orderdetailnumber);
                    return false;
                }
                var tempval = sys_num_checked.product_num($("#txtNumber" + goodsID).val());
                if (!sys_num_checked.product_num_check(tempval)) {
                    art.dialog({
                        title: '系统提示',
                        icon: 'error', //图标
                        content: '购买商品的数量输入错误,请重新输入',
                        lock: true,
                        colse: function () { $("#txtNumber" + goodsID).val(GoodsList[i].orderdetailnumber); }
                    });
                    $("#txtNumber" + goodsID).val(GoodsList[i].orderdetailnumber);
                    return false;
                }
                if (chkNoMember) { //散客消费
                    GoodsList[i].orderdetailpoint = 0;
                    GoodsList[i].orderdetaildiscountprice = accMul(accMul(GoodsList[i].price, GoodsList[i].expdiscount), intNumber);
                }
                else {
                	
                    GoodsList[i].orderdetaildiscountprice = parseFloat(accMul(accMul(GoodsList[i].price, intNumber), GoodsList[i].expdiscount)).toFixed(2);
                    if (Math.floor(GoodsList[i].point) > 0) {
                        GoodsList[i].orderdetailpoint = Math.floor(accMul(GoodsList[i].point, GoodsList[i].orderdetailnumber));
                    }
                    else {
                        GoodsList[i].orderdetailpoint = Math.floor(accDiv(GoodsList[i].orderdetaildiscountprice, GoodsList[i]["exppointdiscount"]));
                    }
                }
                //重新计算提成
                GetStaffMoney(i);
                if (oldval != GoodsList[i].orderdetailnumber.toString()) {
                    $("#txtNumber" + goodsID).val(oldval);
                } else {
                    $("#txtNumber" + goodsID).val(GoodsList[i].orderdetailnumber);
                }
                $("#txtDiscountPrice" + goodsID).val(GoodsList[i].orderdetaildiscountprice);
                $("#txtPoint" + goodsID).val(GoodsList[i].orderdetailpoint);               
            }
            else {
                if (!(/^\d+$/).test(intNumber)) {
                    $("#txtNumber" + goodsID).val(GoodsList[i].orderdetailnumber);
                    art.dialog({
                        title: '系统提示',
                        icon: 'error', //图标
                        content: '购买商品的计次数量输入错误,请重新输入',
                        lock: true
                    });
                    return;
                }
            }
            GoodsList[i].orderdetailnumber = intNumber;
            break;
        }
    }
    if (chkNoMember) { //散客消费
        GoodsList[i].orderdetailpoint = 0;
        //GoodsList[i].orderdetaildiscountprice = accMul(GoodsList[i].price, intNumber);
        GoodsList[i].orderdetaildiscountprice = accMul(accMul(GoodsList[i].price, GoodsList[i].expdiscount), intNumber);
    }
    else {
        GoodsList[i].orderdetaildiscountprice = parseFloat(accMul(accMul(GoodsList[i].price, intNumber), GoodsList[i].expdiscount)).toFixed(2);
        if (Math.floor(GoodsList[i].point) > 0) {
            GoodsList[i].orderdetailpoint = Math.floor(accMul(GoodsList[i].point, GoodsList[i].orderdetailnumber));
        }
        else {
            GoodsList[i].orderdetailpoint = Math.floor(accDiv(GoodsList[i].orderdetaildiscountprice, GoodsList[i]["exppointdiscount"]));
        }
    }
    //重新计算提成
    GetStaffMoney(i);
    if (oldval != GoodsList[i].orderdetailnumber.toString()) {
        $("#txtNumber" + goodsID).val(oldval);
    } else {
        $("#txtNumber" + goodsID).val(GoodsList[i].orderdetailnumber);
    }
    $("#txtDiscountPrice" + goodsID).val(GoodsList[i].orderdetaildiscountprice);
    $("#txtPoint" + goodsID).val(GoodsList[i].orderdetailpoint);
    ExUpdatePoint(goodsID, type);
    ExGoodsBindTotal();
}
/****************************************************************************************************
*更改折后价 重新计算合计
*****************************************************************************************************/
function ExUpdateDiscountPrice(goodsID, type) {
    var decDiscountPrice = (type == 0) ? $("#txtDiscountPrice" + goodsID).val() : $("#txtServiceDiscountPrice" + goodsID).val();
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == goodsID && GoodsList[i].orderdetailnumber > 0) {
            GoodsList[i].orderdetaildiscountprice = decDiscountPrice;
            break;
        }
    }
    //散客消费
    if (chkNoMember) {
        GoodsList[i].orderdetailpoint = 0;
        GoodsList[i].orderdetaildiscountprice = decDiscountPrice;
    }
    else {
        GoodsList[i].orderdetaildiscountprice = decDiscountPrice;
        if (Math.floor(GoodsList[i].point) > 0) {
            GoodsList[i].orderdetailpoint = Math.floor(accMul(GoodsList[i].point, GoodsList[i].orderdetailnumber));
        }
        else {
            GoodsList[i].orderdetailpoint = Math.floor(accDiv(GoodsList[i].orderdetaildiscountprice, GoodsList[i]["exppointdiscount"]));
        }
    }
    //    //重新计算提成
    //    GetStaffMoney(i);
    $("#txtPoint" + goodsID).val(GoodsList[i].orderdetailpoint);
    $("#txtDiscountPrice" + goodsID).val(GoodsList[i].orderdetaildiscountprice);
    ExUpdatePoint(goodsID, type);    
    ExGoodsBindTotal();
}
/****************************************************************************************************
*更改积分 重新计算合计
*****************************************************************************************************/
function ExUpdatePoint(goodsID, type) {
    var intPoint = (type == 0) ? $("#txtPoint" + goodsID).val() : $("#txtServicePoint" + goodsID).val();
    chkNoMember = $("#chkNoMember").attr("checked");
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == goodsID && GoodsList[i].orderdetailnumber > 0) {
            if (chkNoMember) {
                GoodsList[i].orderdetailpoint = 0;
            }
            else {
                if (levelPoint == 0) {
                    GoodsList[i].orderdetailpoint = 0;
                }
                else {
                    GoodsList[i].orderdetailpoint = intPoint;
                }
            }
            break;
        }
    }
    $("#txtPoint" + goodsID).val(GoodsList[i].orderdetailpoint);  
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
            if (GoodsList[i].orderdetailnumber != goodsNumber) {
                newGoodsList.push(GoodsList[i]);
            }
        }
    }
    GoodsList = newGoodsList;
    ExGoodsBindList();
}

//数据更改 重新计算提成
function GetStaffMoney(i) {
    //重新计算提成
    if (staff && staffType == "False") {
        //按商品类型
        switch (GoodsList[i].commissiontype) {
            case "0":
                GoodsList[i].expstaffmoney = 0;
                break;
            case "1":
                GoodsList[i].expstaffmoney = accMul(GoodsList[i].orderdetaildiscountprice, GoodsList[i].commissionnumber);
                break;
            default:
                GoodsList[i].expstaffmoney = Math.abs(accMul(GoodsList[i].commissionnumber, GoodsList[i].orderdetailnumber));
                break;
        }
    }
    //按员工提成比例
    else if (staff && staffType == "True") {
        switch (GoodsList[i].goodstype) {
            case "0":
                GoodsList[i].expstaffmoney = accMul(GoodsList[i].orderdetaildiscountprice, GoodsList[i].expstaffpercent);
                break;
            case "1":
                GoodsList[i].expstaffmoney = Math.abs(accMul(GoodsList[i].commissionnumber, GoodsList[i].orderdetailnumber));
        }
        //        GoodsList[i].expstaffmoney = accMul(GoodsList[i].orderdetaildiscountprice, GoodsList[i].expstaffpercent);
    }
    else if (!staff) {
        GoodsList[i].expstaffmoney = 0;
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
    GoodsProductList();

    ExGoodsBindList();
    $("#sltStaff").val("");
    //    if ($.isEmptyObject(global_mem)) {
    //        art.dialog({
    //            icon: 'error', //图标
    //            content: '请先选择会员!',
    //            lock: true
    //        });
    //    }

    //    if ($("#chkNoMember").attr("checked")) {
    //        $("#txtFindMember").attr("disabled", "disabled");
    //    }
    //    else {
    //        $("#txtFindMember").attr("disabled", "");
    //        $("#txtFindMember").focus();
    //    }

}
/****************************************************************************************************
*挂单按钮响应事件
*****************************************************************************************************/
function btnEntryOrder() {
    var strErrorMsg = "";
    var strOrderCode = $.trim($("#spOrderAccount").html());
    staff = $("#chkStaff").attr("checked");
    if (GoodsList.length == 0) {
        strErrorMsg += "<li>请在左侧列表中选择需要消费的商品！</li>";
    }
    var num = 0;
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].orderdetailnumber < 0) {
            num = parseFloat(_sys_check.defval);
        }
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
            parameter.push({ "payType": "EmptyBills", "IsCard": 0, "IsCash": 0, "IsBink": 0, "CardMoney": 0, "CashMoney": 0, "CouponMoney": 0, "BinkMoney": 0, "DiscountMoney": parseFloat(totalDiscount) });
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
	
    $("#tbOrderTable").find(".td").find("input[type=text]").each(function (i) { 
    	
    	if (i == 1) { 
    		
    		$(this).val(sys_num_checked.product_num($.trim($(this).val())));
    		}
    	});
    
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
        parameter.push({ "payType": "GoodsExpense", "IsCard": 0, "IsCash": 0, "IsBink": 0, "CardMoney": 0, "CashMoney": 0, "CouponMoney": 0, "BinkMoney": 0, "DiscountMoney": 0, "ChangeMoney": 0 });
        ExpenseOK(parameter);
        return;
    }
 
    ShowPay("GoodsExpense", global_mem.memmoney, totalDiscount, strOrderCode, chkAllowPwd);
}
function ExpenseOK(parameter) {
    //获取打印的份数
    var PointNum = $("#PointNum").val();
    var mid= chkNoMember ? "0" : global_mem.memid;
            
            $.ajax({
                type:'POST',
                url:project_name+'StockManager/saveGoodsExpense.do',
                dataType:"json",      
                contentType:"application/json",   
                data:JSON.stringify({
                "ordermemid": mid,
                //                "payType": payType,
                //                "cardPayMoney": cardPayMoney,
                //                "cashPayMoney": cashPayMoney,
                //                "couponPayMoney": couponPayMoney,
                "detail": parameter,
                "ordertotalmoney": totalMoney,
                //                "discountMoney": strDiscountMoney,
                "staffmoney": totalStaffMoney,
                "orderpoint": totalPoint,
                "number": totalNumber,
                "orderaccount": $.trim($("#spOrderAccount").html()),
                "orderremark": $("#txtExRemark").val(),
                "orderpoint": $("#chkPrint").attr("checked")?1:0,
                "sendsms": $("#chkSMS").attr("checked")?1:0,
                "staff": $("#chkStaff").attr("checked")?1:0,
                "details": GoodsList,
                //"count": GoodsList.length,
                "expensetime": $("#txtExpenseTime").val(),
                "staffname": $("#sltStaff").val(),
                "isemptybillsexpense": isEmptyBillsExpense,
                "orderid": order,
                "ordertype":2,
                "ismemcountexpense": 0
            }),
            success:function(json){	
                switch (json.result) {
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
                                  close: function () { PrintGoodsExpense($("#lblExpenseUSer").html(), global_mem, GoodsList, parameter, $("#chkPrint").attr("checked"), PointNum); }
                              });
                        break;
                    case -3:
                        art.dialog
                              ({
                                  title: '系统提示',
                                  time: 2,
                                  content: '挂单成功！',
                                  close: function () { location.href = window.location.reload(); }
                              });
                        break;
                    case -4:
                        art.dialog
                              ({
                                  title: '系统提示',
                                  time: 2,
                                  content: '请勿重复提交订单！',
                                  close: function () { location.href = window.location.reload(); }
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
                                  time: 2,
                                  content: ("本店积分不足无法消费，请与总店联系！"),
                                  close: function () { location.href = window.location.reload(); }
                              });
                        break;
                    default:
                        art.dialog
                                ({
                                    title: '系统提示',
                                    time: 2,
                                    content: '消费成功！' + json.strUpdateMemLevel,
                                    close: function () {
                                        PrintGoodsExpense($("#lblExpenseUSer").html(), global_mem, GoodsList, parameter, $("#chkPrint").attr("checked"), json.point);

                                    }
                                });
                        break;
                }
            }});
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
    $("#txtGoodsExpenseCode").focus().select();
    $("#liService").css("display", "");
    if (location.href.toLowerCase().indexOf("goodsexpense.jsp") != -1) {
        levelPercent = (global_mem.classdiscountpercent != 0) ? global_mem.classdiscountpercent : 0;
        levelPoint = (global_mem.classpointpercent != 0 || global_mem.classpointpercent != undefined) ? global_mem.classpointpercent : 0;

        //        levelPercent = (global_mem.LevelDiscountPercent != 0) ? global_mem.LevelDiscountPercent : 0;
        //        levelPoint = (global_mem.LevelPointPercent != 0 || global_mem.LevelPointPercent != "undefined") ? accMul(global_mem.LevelPointPercent, 100) : 0;
        ExSelectGoodsRefreshList();
        ExGoodsBindList();
        $("#sltStaff").val("");
    }
    GoodsProductList();
    var orderID = $("#txtOrderID").val();
    if (orderID != "") {
        isEmptyBillsExpense = true;
        GetExpenseDetail(orderID);
        order = orderID;
        $("#txtOrderID").val("");
    }
    return true;
}

//计算商品的折扣
function calculate(item) {
    var minPercent = parseFloat(item.minpercent).toFixed(2);
    var salePercet = parseFloat(item.salepercet).toFixed(2);
    var goodsDiscount = 1;
    //判断是否是会员 global_mem.MemLevelID==undefined表示非会员
    if (!global_mem.MemLevelID) {
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