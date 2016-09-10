/// <reference path="../../jquery-1.10.2.min.js" />
$(document).ready(function () {
    //商品编码获取焦点
    $("#txtGoodsName").focus();

    if($("#txtCode").val()==''){
    	$("#txtGoodsCode").val($.getgoodscode());
    }else{
    	$('#txtGoodsCode').val($("#txtCode").val());
    }
    
    
    
    
    
    
    
    $("#txtGoodsCode").bind("click",ckselect);
    function ckselect(){
    	$("#txtGoodsCode").select();
    }

    //    $("#chkAutoGoodsCode").attr("checked", true);

    //确定按钮响应事件
    $("#btnGoodsSave").bind("click", BtnGoodsSave);

    //重置按钮响应事件
    $("#btnGoodsReset").bind("click", BtnGoodsReset);

    //提成类型改变响应事件
    $("#sltCommissionType").bind("change", SetspCommission);

    //绑定商品类别
    $("#sltShopList").bind("change", SetGoodsClass);

    //根据礼品名称自动生成礼品简码
    var PinYinCheck;
    $("#txtGoodsName").keyup(function () {
        clearTimeout(PinYinCheck);
        PinYinCheck = setTimeout("getPYCode(document.getElementById('txtGoodsName').value, 'txtGoodsNameCode')", 500);
    });
    if ($("#txtGoodsID").val() != "") {
        $("#lblAutoGoodsCode").css("display", "none");
    }
    else {
        $("#lblAutoGoodsCode").css("display", "");
    }

    //服务项目

    $("#chkService").bind("click", ServiceGoods);
    ServiceGoods();


    $("#txtGoodsPrice").bind("keyup", function () {
        if (!$(this).val().isFloatPositive()) {
            art.dialog({
                              title: '系统提示',                             
                              content: ("零售单价输入错误！请重新输入"),                              
                              lock: true
                          });
            return false;
        }
    }).focus(function () {
        this.style.imeMode = 'disabled';
    });   
});

//选择所有店铺
function SelectAllShop(){
    $("#chkSyncPartialShop").attr("checked", false);
}

//选择同步的店铺
function SelectPartailShop() {
    $("#chkSyncOtherShop").attr("checked", false);
    if($("#chkSyncPartialShop").attr("checked")==true){
        var dialogSelectShop = art.dialog({
            title: '选择同步到哪些店铺',
            content: document.getElementById('divSyncShopSelectPanel'),
            id: 'divSyncShopSelectPanel',
            lock: true
        });

        $("#btnShareShopOK").bind("click",function(){
            dialogSelectShop.close();
        });
    }
}

//服务项目
function ServiceGoods() {
    if ($("#chkService").attr("checked")) {
        if ($("#txtGoodsID").val() == "") { $("#txtCommissionNumber").val("0"); }
       // $('#txtGoodsBidPrice').css("background-color", "#eee");
       // $('#txtGoodsBidPrice').attr("readonly", true);
        if($('#txtGoodsBidPrice').val()==''){
        	$('#txtGoodsBidPrice').val(0);
        }
        $("#chkService").val(1);
    }
    else {
    	 $("#chkService").val(0);
      //  $('#txtGoodsBidPrice').css("background-color", "");
       // $('#txtGoodsBidPrice').attr("readonly", false);
       
    }
    SetspCommission();
}

 

//提成类型改变响应事件
function SetspCommission() {
    var k = $("#sltCommissionType").val();
    switch (k) {
        case "0":
            if ($("#txtGoodsID").val() == "") { $("#txtCommissionNumber").attr("disabled", "disabled").val("0"); }
            $("#txtCommissionNumber").attr("title", "不启用提成模式。")
            break;
        case "1":
            if ($("#txtGoodsID").val() == "") { $("#txtCommissionNumber").attr("disabled", "").val("0"); }
            $("#txtCommissionNumber").attr("title", "通过商品的单价按照固定的比例提成，不考虑商品折后价格。")
            break;
        case "2":
            if ($("#txtGoodsID").val() == "") { $("#txtCommissionNumber").attr("disabled", "").val("0"); }
            $("#txtCommissionNumber").attr("title", "通过商品的单价按照固定的金额提成，不考虑商品折后价格。")

    }
}

function SetGoodsClass() {
    $("#txtShopID").val($("#sltShopList").val());
    doAjax(
        "../",
        "GetGoodsClassList",
        { "ShopID": $("#sltShopList").val() },
        "json",
         function (json) {
             switch (json) {
                 case -1:
                     art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("暂无类别信息，请先从商品分类中添加类别！"),
                              close: function () { $("#sltGoodsClass").empty(); },
                              lock: true
                          });
                     break;
                 case -3:
                     art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("系统错误 请与系统管理员联系！"),
                              lock: true
                          });
                     break;
                 default:
                     $("#sltGoodsClass").empty();
                     $("#sltGoodsClass").append("<option value=''>===== 请选择 =====</option>");
                     for (var i = 0; i < json.length; i++) {
                         $("#sltGoodsClass").append("<option value='" + json[i].ClassID + "'>" + json[i].ClassName + "</option>");
                     }
                     break;
             }
         })
}

//保存按钮响应事件
function BtnGoodsSave() {
    var strErrorMsg = "";
    var strGoodCode = $.trim($("#txtGoodsCode").val());
    if (strGoodCode == "") {
        strErrorMsg += "<li>必须输入商品编码;</li>";
    }
    else {
        if (!/\d+/.test(strGoodCode)) {
            strErrorMsg += "<li>商品编码是由数字组成的一个字符串;</li>";
        }
    }
    if (strGoodCode.length < 5) {
        strErrorMsg += "<li>商品编码最小长度为5位最长为25位;</li>";
    }
    var strGoodsName = $.trim($("#txtGoodsName").val());
    if (strGoodsName.IsEmpty()) {
        strErrorMsg += "<li>必须输入商品名称;</li>";
    }
    var strGoodsNameCode = $.trim($("#txtGoodsNameCode").val());
    if (strGoodsNameCode.IsEmpty()) {
        strErrorMsg += "<li>必须输入商品简码（商品简码是为了方便您搜索商品而设置的）;</li>";
    }
    if ($("#sltShopList").val() == "") {
        strErrorMsg += "<li>必须选择商品所属店铺;</li>";
    }
    if ($("#sltGoodsClass").find("option:selected").attr("parent")) {
        strErrorMsg += "<li>商品类别不能为父类;</li>";
    }
    if ($("#sltGoodsClass").val() == "") {
        strErrorMsg += "<li>必须选择商品类别;</li>";
    }
    var strGoodsUnit = $.trim($("#sltjldw").val());
    if (strGoodsUnit.IsEmpty()) {
        strErrorMsg += "<li>必须输入商品单位;</li>";
    }
    var decCommissionNumber = $("#txtCommissionNumber").val();
    var intCommissionType = $("#sltCommissionType").val();

    if (decCommissionNumber.IsEmpty()) {
        strErrorMsg += "<li>必须输入提成金额，默认为0;</li>";
    }
    else {
        switch (intCommissionType) {
            case "0":
                if (decCommissionNumber != 0) {
                    strErrorMsg += "<li>必须选择提成方式;</li>";
                }
                break;
            case "1":
                if (!decCommissionNumber.IsDecimal() || decCommissionNumber.ToFloat() > 1 || decCommissionNumber.ToFloat() < 0) {
                    strErrorMsg += "<li>提成比例输入错误，必须为0-1之间的小数，例如0.1表示按照商品单价提成10%，0表示没有提成；</li>";
                }
                break;
            case "2":
                if (!decCommissionNumber.IsNumber() || decCommissionNumber.ToFloat() < 0) {
                    strErrorMsg += "<li>提成金额输入错误，提成金额必须为数字，例如10表示按照商品单价提成10元，0表示没有提成;</li>";
                }
                break;
        }
    }

    var decGoodsPrice = $.trim($("#txtGoodsPrice").val());
    if (!decGoodsPrice.isFloatPositive()) {
        strErrorMsg += "<li>必须输入正确的零售单价 最小值0 最大值 9999999.99;</li>";
    }
    var GoodsBidPrice = $.trim($("#txtGoodsBidPrice").val());
    if (!GoodsBidPrice.isFloatPositive()) {
        strErrorMsg += "<li>必须输入正确的参考进价 最小值0 最大值 9999999.99;</li>";
    }
    var intPoint = $.trim($("#txtGoodsPoint").val());
    if (!intPoint.IsEmpty() && !intPoint.IsNumber()) {
        strErrorMsg += "<li>积分数量只能为数字;</li>";
    }
    if (intPoint < 0) {
        strErrorMsg += "<li>积分数量必须大于0;</li>";
    }
    var strGoodsSalePercet = $.trim($("#txtGoodsSalePercent").val());
    if (strGoodsSalePercet == "") {
        strErrorMsg += "<li>必须输入商品特价折扣;默认为0</li>";
    }
    else {
        if (!strGoodsSalePercet.IsDecimal() || strGoodsSalePercet.ToFloat() > 1 || strGoodsSalePercet.ToFloat() < 0) {
            strErrorMsg += "<li>特价折扣输入错误，必须为0-1之间的小数，例如0.1表示商品特价折扣为0.1，商品折后价格为商品单价*特价折扣，0表示没有特价折扣；</li>";
        }
    }
    var strGoodsMinPercent = $.trim($("#txtGoodsMinPercent").val());
    if (strGoodsMinPercent == "") {
        strErrorMsg += "<li>必须输入商品最低折扣;默认为0</li>";
    }
    else {
        if (!strGoodsMinPercent.IsDecimal() || strGoodsMinPercent.ToFloat() > 1 || strGoodsMinPercent.ToFloat() < 0) {
            strErrorMsg += "<li>最低折扣输入错误，必须为0-1之间的小数，例如0.1表示商品最低折扣为0.1，商品折后价格为商品单价*最低折扣，0表示没有最低折扣；</li>";
        }
    }
    if ((strGoodsMinPercent.ToFloat() > 0 && strGoodsMinPercent.ToFloat() < 1) && (strGoodsSalePercet.ToFloat() > 0 && strGoodsSalePercet.ToFloat() < 1)) {
        strErrorMsg += "一种商品只能允许一种折扣方式，请重新输入";
    }
    var strGoodsRemark = $.trim($("#txtGoodsRemark").val());
    if (strGoodsRemark != "" && strGoodsRemark.length>=50) {
        strErrorMsg += "<li>商品简介的字数不可以超过50个</li>";
    }
    //检测自定义属性是否允许为空
    $("*[id^=Goods_Custom_]").each(function (index) {
        var field = $(this).attr("id").replace("Goods_Custom_", "");
        var txt = $("#Goods_Custom_T_" + field).html();
        if ($(this).attr("isnull") == "False" && $(this).val() == "") {
            strErrorMsg += "<li>自定义属性“" + txt + "”为必填字段，不能留空；</li>";
        }
        if ($(this).attr("isNull") == "False" && $(this).attr("isSelect") == "true" && $(this).val() == "无") {
            strErrorMsg += "<li>自定义属性“" + txt + "”请选择;</li>";
        }
    });


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
    
    

    //去掉提成类型的使能属性
    $('#sltCommissionType').removeAttr("disabled");
    $('#txtCommissionNumber').removeAttr("disabled");
    art.dialog({
        title: '系统提示',
        content: "将" + ($('#txtGoodsID').val() == "" ? "增加" : "编辑") + "商品 [" + $.trim($("#txtGoodsName").val()) + "]。\n确定操作吗？",
        lock: true,
        ok: function () {
        	
            this.close();
            //            this.lock();
            //doAjax("StockManager/",
        //"GoodsAddAndEdit.do",
     
        $.post(project_name+"StockManager/GoodsAddAndEdit.do",
        $("#frmGoodsAdd").serialize(),
       
         function (json) {
        	
        	
             switch (json) {
                 case -1:
                     art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("此商品编码已经在系统中存在，请重新输入商品编码，然后重试！"),
                              lock: true
                          });
                     break;
                 case -2:
                     art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("系统错误 请与系统管理员联系！"),
                              lock: true
                          });
                     break;
                 case 0:
                     art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("系统异常，未保存数据，请再次点击保存！"),
                              lock: true
                          });
                     break;
                 default:
                     art.dialog
                            ({
                                title: '系统提示',
                                time: 0.5,
                                content: '保存成功！',
                                close: function () {
                                	
                                    if ($('#txtGoodsID').val() == "") {
                                        location.href = location.href;
                                    }
                                    else {
                                        location.href = "GoodsList.do?PID=62";
                                    }
                                },
                                lock: true
                            });
                     break;
             }
         });
        },
        cancelVal: '取消',
        cancel: true
    });

}

//重置按钮响应事件
function BtnGoodsReset() {
    var strGoodsID = $('#txtGoodsID').val();
    if (strGoodsID != "") {
        doAjax(
        "../",
        "GetGoodsInfo",
        { "goodsID": $("#txtGoodsID").val() },
        "json",
        function (json) {
            $("#txtGoodsID").val(json[0].GoodsID);
            $("#txtCode").val(json[0].GoodsCode);
            $("#txtGoodsCode").val(json[0].GoodsCode);
            $("#txtGoodsName").val(json[0].Name);
            $("#txtGoodsNameCode").val(json[0].NameCode);
            $("#sltGoodsClass").val(json[0].GoodsClassID);
            $("#sltjldw").val(json[0].Unit);
            $("#sltCommissionType").val(json[0].CommissionType);
            $("#txtCommissionNumber").val(json[0].CommissionNumber);
            $("#txtGoodsPrice").val(parseFloat(json[0].Price).toFixed(2));
            $("#txtGoodsPoint").val(json[0].Point);
            $("#txtGoodsBidPrice").val(parseFloat(json[0].GoodsBidPrice).toFixed(2));
            $("#txtGoodsMinPercent").val(json[0].MinPercent);
            $("#txtGoodsRemark").val(json[0].GoodsRemark);
        });
    }
    else {
        $("#txtGoodsID").val("");
        $("#txtCode").val("");
        $("#txtGoodsCode").val("");
        $("#txtGoodsName").val("");
        $("#txtGoodsNameCode").val("");
        $("#sltGoodsClass").val("");
        $("#sltCommissionType").val("0");
        $("#txtCommissionNumber").val("0");
        $("#txtGoodsPrice").val("");
        $("#txtGoodsPoint").val("0");
        $("#txtGoodsBidPrice").val("");
        $("#txtGoodsMinPercent").val("0");
        $("#txtGoodsRemark").val("");
    }

}
