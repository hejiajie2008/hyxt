/*************************************************************************************************************
商品入库页面JS处理
**************************************************************************************************************/
var pageSize = 10;
var currentPage = 1;
var key = "", keyBarCode = "";       //搜索的值
var GoodsList = new Array();
var totalNumber = 0, totalMoney = 0

$(document).ready(function () {
	
    $("#txtCode").focus().select();
    GoodsProductList();
    //消费时间绑定日期控件
    $('#txtCreteTime').bind("focus click", function () {
        WdatePicker({ skin: 'ext', maxDate: '%y-%M-%d', isShowClear: true, readOnly: true });
//        WdatePicker({ skin: 'ext', dateFmt: 'yyyy-MM-dd HH:mm', maxDate: '%y-%M-%d %H:%m:%s', isShowClear: false, readOnly: true });
    });
    
    
    $('#txtCreteTime').val($.getnowdate());
    //搜索按钮响应的事件
    $("#btnGoodsSearch").bind("click", btnGoodsSearch);
    //下拉框改变事件
    $("#sltShop").bind("change", changeShop);
    //马上入库按钮响应事件
    $("#btnGoodsSave").bind("click", GoodsIn);

    $("#txtCode").keyup(function (e) {	
        var keyAscii = window.event ? e.keyCode : e.which;
        if (keyAscii == 13 && $.trim($("#txtCode").val()) != "") {
            keyBarCode = $("#txtCode").val();
            SelectGoodsByBarCode();
        }
    });
})



function SelectGoodsByBarCode() {
    doAjax(
        "../",
        "GetGoodsByCodeDelServe",
        { "barCode": keyBarCode },
        "json",
        function (json) {
            if (json != null) {
                SelectGoodsOK(json);
            }
            $("#txtCode").select();
            $("#RechargeCount_BarCode").select();
        }
     );
}


/****************************************************************************************************
*输入商品名称或简码后  回车响应事件
*****************************************************************************************************/
function getKey() {
    if (event.keyCode == 13) {
        key = $("#txtGoodsCode").val()
        GoodsProductList();
    }
}

/****************************************************************************************************
*搜索按钮响应事件
*****************************************************************************************************/
function btnGoodsSearch() {
    key = $("#txtGoodsCode").val()
    GoodsProductList();
}
/****************************************************************************************************
*下拉框改变事件
*****************************************************************************************************/
function changeShop() {
    var newGoodsList = new Array();
    GoodsList = newGoodsList;
    $("#txtCode").val("");
    $("#Expense_Text_BarCode").val("");
    GoodsProductList();
    BindGoodsList();

}

/****************************************************************************************************
*获取商品
*****************************************************************************************************/
function GoodsProductList() {
	
    doAjax("StockManager/",
           "GetGoodsList.do",
           {
               "pageSize": pageSize,
               "page": currentPage,
               "key": key,
               "shopid": 1,//$("#sltShop").val()
               "bolgoodsexpense": 0,
               "goodsclassid": "",
               "ischeckstock": 0//是否检查库存；
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
    var html = ''
    if (obj.length > 0) {
        $.each(obj, function (index, item) {
            html += "<tr class=\"td\" onclick=\"javascript:SelectGoods(" + item.goodsid + ");\">"
                 + '<td style="text-align: left">' + item.name + '</td>'
                 + '<td>' + item.goodscode + '</td>'
                 + '<td style="text-align: right">' + parseFloat(item.goodsbidprice).toFixed(2) + '</td>'
                 + '<td style="text-align: right">' + item.goodsnumber + '</td>'
                 + '</tr>';
        });
    }
    else {
        html += '<tr><td style="height:50px; line-height:50px;padding-left:20px; background-color:#fff;" colspan="5">未找到符合此条件的数据！请重试！</td></tr>';
    }

    $("#tbGoodsProduct").html(html);
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
    //    page.Show();
}

// 选择商品,加入到入库清单
function SelectGoods(goodsID) {
	
    doAjax("StockManager/",
          "GetGoodsNumber.do",
          {
              "goodsid": goodsID,
              "usershopid": $("#sltShop").val()
          },
          "json",
          function (json) {
        	  
              SelectGoodsOK(json.rows);
          });
}
// 选择好商品，加入到已选商品列表
function SelectGoodsOK(json) {
    var index = -1;
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == json[0].goodsid) {
            index = i;
        }
    }
    if (index == -1) {
        json[0]["goodsnumber"] = 1;
        json[0]["goodsinprice"] = json[0].goodsbidprice;
        json[0]["totalmoney"] = accMul(json[0].goodsbidprice, json[0]["goodsnumber"]);
        GoodsList.push(json[0])
    }
    else {
        var currentNum = parseInt(GoodsList[index].goodsnumber) + 1;
        //var currentMoney = 0;
        var currentTotalMoney = 0;
        //currentMoney = Math.round(accMul(GoodsList[index].GoodsBidPrice, currentNum), 2);
        currentTotalMoney = parseFloat(accMul(GoodsList[index].goodsbidprice, currentNum)).toFixed(2);
        GoodsList[index].goodsnumber = currentNum;
        //GoodsList[index].goodsinprice = currentMoney;
        GoodsList[index].totalmoney = currentTotalMoney;
    }
    BindGoodsList();
}

/****************************************************************************************************
*将选择好的产品绑定到右侧列表中
*****************************************************************************************************/
function BindGoodsList() {
    $("#tbOrderTable").html("");
    for (var i = 0; i < GoodsList.length; i++) {
        var html = '<tr class="td" >'
                 + '<td style="text-align: left">' + GoodsList[i].name + '</td>'
                 + '<td><input id="txtBidPrice' + GoodsList[i].goodsid + '"  type="text" class="border_radius common_ServiceButton border_radius2" style="text-align: right" value="' + parseFloat(GoodsList[i].goodsinprice).toFixed(2) + '" onkeyup="javascript:GoodsUpdate(' + GoodsList[i].goodsid + ');" onclick=\"javascript:this.select();\"/></td>'
                 + '<td><input id="txtNumber' + GoodsList[i].goodsid + '" type="text" class="border_radius common_ServiceButton border_radius2" style="text-align: right" value="' + GoodsList[i].goodsnumber + '" onkeyup="javascript:GoodsUpdate(' + GoodsList[i].goodsid + ');" onclick=\"javascript:this.select();\"/></td>'
                 + '<td style="text-align: right"><span id="spPrice' + GoodsList[i].goodsid + '" class="integral" >' + parseFloat(GoodsList[i].totalmoney).toFixed(2) + '</span></td>'
        html += '<td class=\"listtd\" style=\"width: 30px;\"><a href="javascript:void(0);" onclick="javascript:GoodsDeleteItem(' + GoodsList[i].goodsid + ');"><img src=\"../images/Gift/del.png\" alt=\"删除此项\" title=\"删除此项\" /></a></td>'
        html += '</tr>';
        $("#tbOrderTable").append(html);
    }
    // html = '<tr id="tdTotal"><td colspan="5" style="height:30px; line-height:30px; background-color:#ddeeff;padding:0px 5px 0px 5px;"></td></tr>';
    //    $("#tbOrderTable").append(html);
    GoodsBindTotal();
}
/****************************************************************************************************
*绑定入库合计
*****************************************************************************************************/
function GoodsBindTotal() {
    totalMoney = totalNumber = 0;
    for (var i = 0; i < GoodsList.length; i++) {
        totalNumber = accAdd(totalNumber, GoodsList[i].goodsnumber);
        totalMoney = accAdd(totalMoney, parseFloat(accMul(GoodsList[i].goodsinprice, GoodsList[i].goodsnumber)).toFixed(2));
    }
    if (GoodsList.length != 0) {
        var strTotalhtml = "";
        
        $("#lblTotalNumber").html(totalNumber);
        $("#lblTotalMoney").html(totalMoney);
        //        strTotalhtml += '<td><span style="width:70px;color:red;" >入库合计</span></td><td colspan="2">商品总数量:<span style="width:70px;color:red;font-weight:bold;font-size:20px;" >' + totalNumber + '</span></td><td colspan="2">入库总额:￥<span style="width:70px;color:red;font-weight:bold;font-size:20px;" >' + totalMoney + '</span></td>';
        //        $("#tdTotal").html(strTotalhtml);
    }
    else {
        $("#lblTotalNumber").html("0");
        $("#lblTotalMoney").html("0");
        $("#tbOrderTable").html('<tr><td colspan="5" style="height:30px; line-height:30px;padding:0px 5px 0px 5px;">请点击左侧商品列表，选择需要入库的商品！</td></tr>');
    }
}
/****************************************************************************************************
*更改入库价格和数量 重新计算合计
*****************************************************************************************************/
function GoodsUpdate(goodsid) {
    var dclPrice = $("#txtBidPrice" + goodsid).val();
    var intnumber = sys_num_checked.product_num($.trim($("#txtNumber" + goodsid).val()));   
    if (!sys_num_checked.product_num_check(intnumber)) {
        art.dialog({
            title: '系统提示',
            icon: 'error', //图标
            content: '入库数量输入有误！',
            lock: true
        });
        intnumber = 1;
        $("#txtNumber" + goodsid).val(1);
        $("#spPrice" + goodsid).html(accMul(dclPrice, 1));
    }
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid == goodsid) {
            GoodsList[i].goodsinprice = dclPrice;
            GoodsList[i].goodsnumber = intnumber;
            break;
        }
    }
    GoodsList[i].totalmoney = parseFloat(accMul(GoodsList[i].goodsinprice, intnumber)).toFixed(2);
    $("#spPrice" + goodsid).html(GoodsList[i].totalmoney);
    GoodsBindTotal();
}
/****************************************************************************************************
*删除商品 重新计算合计
*****************************************************************************************************/
function GoodsDeleteItem(goodsid) {
    var newGoodsList = new Array();
    for (var i = 0; i < GoodsList.length; i++) {
        if (GoodsList[i].goodsid != goodsid) {
            newGoodsList.push(GoodsList[i]);
        }
    }
    GoodsList = newGoodsList;
    BindGoodsList();
}
/****************************************************************************************************
*马上入库按钮响应事件
*****************************************************************************************************/
function GoodsIn() {
    if (GoodsList.length == 0) {
        art.dialog({
            title: '系统提示',
            icon: 'error', //图标
            content: '请在左侧列表中选择要入库的商品！',
            lock: true
        });
        return false;
    }


    //获取打印的份数
    var PointNum = $("#PointNum").val();

    var strAccount = $("#spGoodsAccounte").html();
    
  
    
    $.ajax({
        type:'POST',
        url:project_name+'StockManager/saveGoodsIn.do',
        dataType:"json",      
        contentType:"application/json",   
        data:JSON.stringify({
            "goodsaccount": strAccount,
            "details": GoodsList,
            "goodsnumber": GoodsList.length,
            "shopid": $("#sltShop").val(),
            "remark": $("#txtExRemark").val(),
            "createtime": $("#txtCreteTime").val(),
            "print": $("#chkPrint").attr("checked"),
            "totalprice": totalMoney
        }),
        success:function(json){		
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
            default:
                art.dialog
                      ({
                          title: '系统提示',
                          time: 0.5,
                          content: '商品入库成功！',
                          close: function () { 
                          	PrintGoodsIn($("#lblUSer").html(), $("#sltShop").find("option:selected").text(), GoodsList, $("#chkPrint").attr("checked"), PointNum); 
                          
                          },
                          lock: true
                      });
                break;
        }
	 }
   });
    /**
    doAjax(
            "StockManager/",
            "saveGoodsIn.do",
		   {
               "goodsaccount": strAccount,
               "details": GoodsList_new,
               "goodsnumber": GoodsList.length,
               "shopid": $("#sltShop").val(),
               "remark": $("#txtExRemark").val(),
               "createtime": $("#txtCreteTime").val(),
               "print": $("#chkPrint").attr("checked"),
               "totalprice": totalMoney
           },
           "json",
		   function(json){
	   
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
               default:
                   art.dialog
                         ({
                             title: '系统提示',
                             time: 0.5,
                             content: '商品入库成功！',
                             close: function () { 
                             	//PrintGoodsIn($("#lblUSer").html(), $("#sltShop").find("option:selected").text(), GoodsList, $("#chkPrint").attr("checked"), PointNum); 
                             	alert("UU");
                             },
                             lock: true
                         });
                   break;
           }
   });
   **/
  
    
}