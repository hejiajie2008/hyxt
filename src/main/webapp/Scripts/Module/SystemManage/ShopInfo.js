$(document).ready(function () {

    if ($("#hidWeiXin").val() == "2") {

        $(".weiXin").hide();
    }
    $("#btnSearch").bind("click",base_search);
    
    


    if ($("#txtSearch").val() != '') {
        $("#lblsearch").hide();
    }
    
    $("#txtSearch").keydown(function () {
    	
        $("#lblsearch").hide();
        
    }).focusout(function () {
        var value = $(this).val().replace(/(^\s*)|(\s*$)/, "");
        if ('' == value) {
            $("#lblsearch").show();
        }
    });
    $("#rdisnotlms").attr("checked", "checked");
    $("#rbbzfs").attr("checked", "checked");
    $("#rdbzxf").attr("checked", "checked");

    //是否启用商盟版功能
    if ($("#union").val() == "False" || $("#union").val() == "") {
        $(".tdZoom").removeAttr("class");
        $(".top").css("display", "none");
    }

    if (parseInt($("#hdShopID").val()) == 1) {
        $("#sltShopList").val("0");
        $("#sltShopList").attr("disabled", "");
    }
    else {
        $("#sltShopList").val($("#hdShopID").val());
        $("#sltShopList").attr("disabled", "disabled");
    }
    //"保存"按钮响应函数
    $("#btnShopSave").bind("click", ShopSave);

    //"重置"按钮响应函数
    $("#btnShopReset").bind("click", ShopReset);

    //"新增"按钮响应函数
    $("#btnShopAdd").bind("click", btnShopAdd);

    //店铺积分变动
    $("#btSavePoint").bind("click", btSavePoint);

    //店铺短信变动
    $("#btSaveSms").bind("click", btSaveSms);

    //店铺购卡
    $("#btSaveCardLog").bind("click", btSaveCardLog);

    //是否启用购卡功能
    var temp = $("#txtIsSendCard").val();
    if (temp == "0" || $.trim(temp) == "") {
        $(".sendcard").css("display", "none");
        $("#btnShopBuyCard").css("display", "none");
        $("a[id$=hySendCard]").css("display", "none");
    }
    //是否启用店铺结算功能
    temp = $.trim($("#txtIsSettlement").val());
    if (temp == "0" || temp == "") {
        $("#btnSettlement").css("display", "none");
        $("#txtSettlementInterval").val("65535");
        $("#txtShopProportion").val("0");
        $("#trSettlement").css("display", "none");
        $(".settlement").css("display", "none");
    }
    //是否启用联盟商短信管理功能
    temp = $("#txtSmsManage").val();
    if (temp == "0" || $.trim(temp) == "") {
        $(".smsmanage").css("display", "none");
        $("#btnMsgRecord").css("display", "none");
        $(".tSms").css("display", "none");
        $("#trShopSms").css("display", "none");
    }
    //是否启用联盟商积分管理功能
    temp = $("#txtPointManage").val();
    if (temp == "0" || $.trim(temp) == "") {
        $(".pointmanage").css("display", "none");
        $("#btnPointRecord").css("display", "none");
        $(".tPoint").css("display", "none");
        $("#trShopPoint").css("display", "none");
    }

    $("#btnSettlement").click(function () {
        location.href = "ShopSettlement.aspx?PID=135";
    });

    $("#btnMsgRecord").click(function () {
        location.href = "ShopSmsTransfer.aspx?PID=137";
    });

    $("#btnPointRecord").click(function () {
        location.href = "ShopPointTransfer.aspx?PID=136";
    });

    $("#btnShopBuyCard").click(function () {
        location.href = "ShopSendCard.aspx?PID=134";
    });

    $("#rdislms").bind("click", btnChangeAlliance);
    $("#rdisnotlms").bind("click", btnChangeAlliance);


    $(".tdZoom").bind("click", SubShopProcess);



    //动态加载 伸缩图标
    var $tdZooms = $(".tdZoom");
    $.each($tdZooms, function () {
        if ($(this).attr("union") == "True") {
            var $img = $("<img alt='' class='top' src='../images/ico/plus.gif' />");
            $(this).prepend($img);
            $(this).attr("style", "text-align:left");
        }
    });
});

/***************************************************************************************************
    点击父级店铺时   显示或隐藏其所属的子店铺    
****************************************************************************************************/
function SubShopProcess() {
    if ($(this).attr("showAlready") == 0) {
        //子店铺列表未显示时的操作
        var $trTop = $(this).parent();
        var $img = $(this).children("img");
        $(this).attr("showAlready", "1");
        //获取父店铺的序号  用来拼子店铺的序号
         var num = $(this).children().last().text();
         //获得该店铺id   根据id查询子店铺列表       为什么通过客户端ID读不到值？？
        var shopid = $(this).attr("shopId");
        //判断tr是否有该自定义属性
        var $temp = $(this).parent().attr("sub");

        doAjax("../", "GetSubShopList",
                { "ShopID": shopid },
                "json",
                function (data) {
                    var i = data.length;
                    //根据返回的json数据生成表格  然后追加到当前行的下面  每行加个自定义属性sub  方便移除      
                    $.each(data, function () {
                        if (typeof ($temp) == "undefined") {
                            var $tr = $("<tr class='td' sub='" + shopid + "'></tr>");
                        }
                        else {
                            var $tr = $("<tr class='td' sub='" + $temp + "-" + shopid + "'></tr>");
                        }
                        //子店铺序号 1-2   2-2 这个样子   NND  倒序的怎么弄 2-2  2-1  
                        var $td = $("<td style='text-align: right'></td>");
                        var $label = $("<label>" + num + "." + i + "</label>")
                        //判断子店铺下是否还有子店铺
                        if (this.HasChildShop == 1) {
                            var $img1 = $("<img alt='' class='top' src='../images/ico/plus.gif'/>");
                            $td.append($img1);
                            $td.attr("showAlready", "0");
                            $td.attr("shopId", this.ShopID);
                            $td.attr("class", "tdZoom");
                        }
                        $td.append($label);
                        $tr.append($td);
                        $td = $("<td style='text-align: left'>" + this.ShopName + "</td>");
                        $tr.append($td);
                        $td = $("<td>" + this.ShopContactMan + "</td>");
                        $tr.append($td);
                        $td = $("<td>" + this.ShopTelephone + "</td>");
                        $tr.append($td);
                        $td = $("<td style='text-align: left; padding-left: 4px;'>" + this.ShopAddress + "</td>");
                        $tr.append($td);
                        if ($("#txtIsSettlement").val() != "0" && $("#txtIsSettlement").val() != "") {
                            $td = $("<td style='text-align: left; padding-left: 4px;'>" + this.SettlementInterval + "</td>");
                            $tr.append($td);
                            $td = $("<td style='text-align: left; padding-left: 4px;'>" + this.ShopProportion + "</td>");
                            $tr.append($td);
                        }
                        if (this.ShopState == "True") {
                            $td = $("<td>是</td>");
                        } else {
                            $td = $("<td>否</td>");
                        }
                        $tr.append($td);
                        if ($("#txtPointManage").val() != "0" && $("#txtPointManage").val() != "") {
                            $td = $("<td style='text-align: left; padding-left: 4px;'>" + this.PointCount + "</td>");
                            $tr.append($td);
                        }
                        if ($("#txtSmsManage").val() != 0 && $("#txtSmsManage").val() != "") {
                            $td = $("<td style='text-align: left; padding-left: 4px;'>" + this.SmsCount + "</td>");
                            $tr.append($td);
                        }
                        $td = $("<td class='listtd' style='width: 200px;'></td>");
                        $tr.append($td);
                        var $label = $("<asp:Label ID='lblShopID' runat='server' Text='" + this.ShopID + "' Visible='false'></asp:Label>");
                        $td.append($label);
                        var $a = $("<a href='#' onclick=' ShopEdit(\"" + this.ShopName + "\",\"" + this.ShopID + "\") ' id='hyShopEdit' runat='server'> <img src='../images/Gift/eit.png' alt='编辑' title='编辑' /></a> '");
                        $td.append($a);
                        $a = $("<a href='ShopAuthority.aspx?PID=38&SID=" + this.ShopID + "' id='hyAuthority' runat='server'> <img src='../images/Gift/system.png' alt='权限设定' title='权限设定' /></a> '");
                        $td.append($a);
                        if ($("#txtIsSendCard").val() != "0" && $.trim($("#txtIsSendCard").val()) != "") {
                            $a = $("<a href='#' id='hySendCard' runat='server' onclick=' btnShopBuyCards(\"" + this.ShopName + "\",\"" + this.ShopID + "\")'> <img src='../images/ico/privilege.png' alt='购卡' title='购卡' /></a> '");
                            $td.append($a);
                        }
                        if ($("#txtPointManage").val() != "0" && $.trim($("#txtPointManage").val()) != "") {
                            $a = $("<a href='#' id='hyShopPointEdit' runat='server' onclick=' ShopEditPoint(\"" + this.ShopName + "\",\"" + this.ShopID + "\")'> &nbsp;<img src='../images/ico/point.png' alt='积分管理' title='积分管理' /></a> '");
                            $td.append($a);
                        }
                        if ($("#txtSmsManage").val() != "0" && $.trim($("#txtSmsManage").val()) != "") {
                            $a = $("<a href='#' id='hyShopSmsEdit' runat='server' onclick=' ShopEditSms(\"" + this.ShopName + "\",\"" + this.ShopID + "\")'> &nbsp;<img src='../images/ico/mobile.png' alt='短信管理' title='短信管理' /></a> '");
                            $td.append($a);
                        }
                        
                        var $a = $("<a href='#' onclick='ForeverTicketUrl(" + this.ShopID + ")' >二维码</a>");
                        $td.append($a);

                        //人才啊   这种拼法
                        $trTop.after($tr);
                        i--;
                    });
                    //改图标
                    $img.attr("src", "../images/ico/minus.gif");
                    //绑定点击事件
                    $(".tdZoom").bind("click", SubShopProcess);
                });
    }
    else {
        //子店铺列表已显示时的移除操作
        if (typeof ($(this).parent().attr("sub")) == "undefined") {
            $(this).parent().nextAll("[sub ^=" + $(this).attr("shopId") + "]").remove();
        }
        else {
            $(this).parent().nextAll("[sub ^= '" + $(this).parent().attr("sub") + "-']").remove();
        }
        $(this).children("img").attr("src", "../images/ico/plus.gif");
        $(this).attr("showAlready", "0");
    }
}


function ForeverTicketUrl(shopid) {
    doAjax("../",
     'ForeverTicketUrl',
      { "shopid": shopid },
       "json",
        function (json) {
            $("#tdForeverTicketUrl").html(json);
            art.dialog({
                lock: true,
                title: '店铺二维码',
                content: document.getElementById('divForeverTicketUrl'),
                id: 'divForeverTicketUrl',
                close: function () {
                    $("#tdForeverTicketUrl").html("");
                }
            });
        });
}

/*----------------------------------------------------------------------------------------------
   如果选择了非联盟商   新增店铺就是某个联盟商的子店铺   下拉框可用 
-------------------------------------------------------------------------------------------------*/
function btnChangeAlliance() {
    if ($("#rdislms").attr("checked")) {
        $("#sltShopList").attr("disabled", "disabled");
        $("#sltShopList").val("0");
    }
    else {
        $("#sltShopList").attr("disabled", "");
    }
}

/*****************************************************************************************************
*保存按钮响应函数
*****************************************************************************************************/
function ShopSave() {
    var strErrorMsg = "";
    var type = ($("#txtShopID").val() == "") ? "ShopAdd" : "ShopEdit";
    var telephone = $.trim($("#txtShopTelephone").val());
    if ($.trim($("#txtShopName").val()) == "") strErrorMsg += "<li>店铺名称不能为空;</li>";
    if ($.trim($("#txtShopContactMan").val()) == "") strErrorMsg += "<li>店铺联系人不能为空;</li>";
    if (telephone != "" && !telephone.IsNumber()) strErrorMsg += "<li>联系电话只能为数字且不能为空;</li>"    
    if ($("#chkSMS").attr("checked") && $("#txtShopSmsName").val() == "") {
        strErrorMsg += "<li>服务参数已启动短信功能，短信后缀名不能为空;</li>"
    }    
    if ($("#union").val() == "True" && $("#txtIsSettlement").val() == "1") {
        if ($.trim($("#txtSettlementInterval").val()) == "") strErrorMsg += "<li>店铺结算周期不能为空</li>";
        if (!/^[-]?\d+$/.test($.trim($("#txtSettlementInterval").val())) || $.trim($("#txtSettlementInterval").val()) <= 0) strErrorMsg += "<li>店铺结算周期只能为正整数</li>";
        if ($.trim($("#txtShopProportion").val()) == "") strErrorMsg += "<li>提成比例不能为空</li>";
        if ($.trim($("#txtShopProportion").val()) != 0 && $.trim($("#txtShopProportion").val()) != 1 && !/^0\.\d*[0-9]$/.test($.trim($("#txtShopProportion").val()))) strErrorMsg += "<li>提成比例只能为0到1之间的数字</li>";
//        if ($("#rdisnotlms").attr("checked") && $("#sltShopList").val() == "0") {
//            strErrorMsg += "<li>请选择所属联盟商;</li>";
//        } 
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
        title: '系统提示',
        content: "将要" + (type == "ShopAdd" ? "增加" : "编辑") + "店铺 [" + $.trim($("#txtShopName").val()) + "]，\n确定操作吗？" + (type == "ShopAdd" ? "(店铺增加成功，则不可删除，请仔细核对信息)" : ""),
        lock: true,
        ok: function () {
            this.close();
            //            this.lock();
            doAjax("SystemManager/",
         type+".do",
        {
            "shopid": $.trim($("#txtShopID").val()),
            "shopname": $.trim($("#txtShopName").val()),
            "shopcontactman": $.trim($("#txtShopContactMan").val()),
            "shoptelephone": $.trim($("#txtShopTelephone").val()),
            //"shopAreaID": $("#sltShopAreaID").val(),
            "shopaddress": $("#txtShopAddress").val(),
            "shopremark": $("#txtShopRemark").val(),
            "shopprinttitle": $("#txtShopPrintTitle").val(),
            "shopprintfoot": $("#txtShopPrintFoot").val(),
            "shopsmsname": $("#txtShopSmsName").val(),
            "settlementinterval": $.trim($("#txtSettlementInterval").val()),
            "shopproportion": $.trim($("#txtShopProportion").val()),
            "isallianceprogram": $("input[name='isLms']:checked").val()?1:0,
            "fathershopid": $("#sltShopList").val()==null?"":$("#sltShopList").val(),
            "pointtype": $("input[name='PointType']:checked").val()?1:0,
            "smstype": $("input[name='SmsType']:checked").val()?1:0,
            "shopstate": $("input[name='radChooseYesOrNo']:checked").val()
        },
        "json",
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
                 case -3:
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
                              content: ("操作员不允许锁定当前正在操作的店铺！"),
                              lock: true
                          });
                     break;
                 case -1:
                     art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("此店铺已经在系统中存在，请重新输入店铺，然后重试！"),
                              lock: true
                          });
                     break;
                 case -5:
                     art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("积分不足时或短信不足时权限设置无效，请重新选择！"),
                              lock: true
                          });
                     break;
                 default:
                     art.dialog
                            ({
                                title: '系统提示',
                                time: 0.5,
                                content: '保存成功！',
                                close: function () { location.href = window.location.reload(); },
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

/*****************************************************************************************************
*重置按钮响应函数
*****************************************************************************************************/
function ShopReset() {
    if ($("#ShopAddOrEdit").val() == 0) {
        $("#txtShopName").val("");
        $("#txtShopID").val("");
        $("#txtShopContactMan").val("");
        $("#txtShopTelephone").val("");
        $("#txtShopSmsName").val("");
        $("#txtShopPrintTitle").val("");
        $("#txtShopPrintFoot").val("");
        $("#radChooseNo").attr("checked", true);
        $("#txtShopAddress").val("");
        $("#txtShopRemark").val("");
        $("#txtShopProportion").val("");
        $("#txtSettlementInterval").val("");
        $("#rdisnotlms").attr("checked", "checked");
        if (parseInt($("#hdShopID").val()) == 1) {
            $("#sltShopList").val("0");
        }
        else {
            $("#sltShopList").val($("#hdShopID").val());
            $("#sltShopList").attr("disabled", "true");
        }
    }
    else if ($("#ShopAddOrEdit").val() == 1) {
        ShopEdit($("#txtShopName").val(), $("#txtShopID").val());
    }
}

/*****************************************************************************************************
*新增按钮响应函数
*****************************************************************************************************/
function btnShopAdd() {
    $("#radChooseNo").attr("checked", true);
    if (parseInt($("#hdShopID").val()) == 1) {
        $("#sltShopList").val("0");
        $("#sltShopList").attr("disabled", "");
    }
    else {
        $("#rdislms").attr("disabled", "disabled");
        $("#rdisnotlms").attr("disabled", "disabled");
        $("#sltShopList").val($("#hdShopID").val());
        $("#sltShopList").attr("disabled", "disabled");
    }
    art.dialog({
        title: '店铺新增',
        content: document.getElementById('ShopInfo'),
        id: 'ShopInfo',
        lock: true,
        close: function () {
            ShopReset(); 
         }
    });
    $("#ShopAddOrEdit").val(0);
    $("#txtShopName").focus();
}

/*****************************************************************************************************
*编辑按钮响应函数
*****************************************************************************************************/
function ShopEdit(shopname, shopid) {
    $("#ShopAddOrEdit").val(1);
    $("#sltShopList").attr("disabled", "disabled");
    $("#rdislms").attr("disabled", "disabled");
    $("#rdisnotlms").attr("disabled", "disabled");
    art.dialog({
        lock: true,
        title: '店铺编辑',
        content: document.getElementById('ShopInfo'),
        id: 'ShopInfo',
        close: function () {
            $("#ShopAddOrEdit").val(0); ShopReset();
            $("#sltShopList").attr("disabled", "");
            $("#rdislms").attr("disabled", "");
            $("#rdisnotlms").attr("disabled", "");
            $("#sltShopList").val(0);
        }
    });
    doAjax("SystemManager/",
             'GetShopInfo.do', { "shopid": shopid }, "json",
                 function (json) {
            	
                     $("#txtShopName").val(json.shopname);
                     $("#txtShopID").val(json.shopid);
                     $("#txtShopContactMan").val(json.shopcontactman);
                     $("#txtShopTelephone").val(json.shoptelephone);
                     $("#txtShopPrintTitle").val(json.shopprinttitle);
                     $("#txtShopPrintFoot").val(json.shopprintfoot);
                     $("#txtShopSmsName").val(json.shopsmsname);
                     $("#txtShopRemark").val(json.shopremark);
                     $("#txtSettlementInterval").val(json.settlementinterval);
                     $("#txtShopAddress").val(json.shopaddress);
                     $("#txtShopProportion").val(parseFloat(json.shopproportion).toFixed(2));
                     if (json.shopstate == 1) {
                         $("#radChooseYes").attr("checked", true);
                     }
                     else {
                         $("#radChooseNo").attr("checked", true);
                     }
                     if (json.isallianceprogram == 1) {
                         $("#rdislms").attr("checked", "checked");
                         $("#sltShopList").val("0");
                     }
                     else {
                         $("#rdisnotlms").attr("checked", "checked");
                         $("#sltShopList").val(json.fathershopid.toString());
                     }
                     switch (json.pointtype.toString()) {
                         case "1":
                             $("#rdbzxf").attr("checked", true);
                             break;
                         case "2":
                             $("#rdjfgl").attr("checked", true);
                             break;
                         case "3":
                             $("#rdtz").attr("checked", true);
                             break;
                         default:
                             $("#rdjfgl").attr("checked", true);
                             break;
                     }
                     switch (json.smstype.toString()) {
                         case "1":
                             $("#rbbzfs").attr("checked", true);
                             break;
                         case "2":
                             $("#rbkytz").attr("checked", true);
                             break;
                         default:
                             $("#rbbzfs").attr("checked", true);
                             break;
                     }
                 });
}


/*****************************************************************************************************
*店铺短信管理
*****************************************************************************************************/
function ShopEditSms(shopname, shopid) {
    $("#txtSmsShopName").html(shopname);
    art.dialog({
        lock: true,
        title: '店铺短信管理',
        content: document.getElementById('ShopSms'),
        id: 'ShopSms',
        close: function () { }
    });
    doAjax("../",
             'GetShopInfo', { "shopID": shopid }, "json",
                 function (json) {
                     $("#hdSmsShopID").val(json.ShopID);
                     $("#txtSmsNumber").html(json.SmsCount);
                 });
    $("#txtSmsCount").focus();
    $("#txtSmsCount").val("");
}
function btSaveSms() {
    if (!isIntPositive($("#txtSmsCount").val())) {
        art.dialog
            ({
                time: 4,
                title: '系统提醒',
                content: '请输入正确的短信数量！',
                lock: true
            });
        $("#txtSmsCount").focus();
        return;
    }
    else {
        doAjax("../",
             'SetShopSms',
             {
                 "shopID": $("#hdSmsShopID").val(),
                 "count": $("#txtSmsCount").val(),
                 "type": $('input[name="radSmsType"]:checked').val()
             },
              "json",
            function (json) {
                switch (json) {
                    case 0:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("系统异常 未保存，请重试！"),
                                lock: true
                            });
                        break;
                    case 1:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("该店铺拥有的短信量不足，不能扣除！"),
                                lock: true
                            });
                        break;
                    case -5:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("联盟商短信不足，无法增加该数量的短信！"),
                                lock: true
                            });
                        break;
                    default:
                        art.dialog
                            ({
                                title: '系统提示',
                                time: 1,
                                content: '保存成功！',
                                close: function () { location.href = "ShopList.aspx?PID=31"; },
                                lock: true
                            });
                        break;
                }
            });
    }
}

/*****************************************************************************************************
*店铺积分管理
*****************************************************************************************************/
function ShopEditPoint(shopname, shopid) {
    $("#txtShopPointName").html(shopname);
    art.dialog({
        lock: true,
        title: '店铺积分管理',
        content: document.getElementById('ShopPoint'),
        id: 'ShopPoint',
        close: function () { }
    });
    doAjax("../",
             'GetShopInfo', { "shopID": shopid }, "json",
                 function (json) {
                     $("#hdPointShopID").val(json.ShopID);
                     $("#txtShopPointNumber").html(json.PointCount);
                 });
    $("#txtcount").focus();
    $("#txtcount").val("");
}
function btSavePoint() {
    if (!isIntPositive($("#txtcount").val())) {
        art.dialog
            ({
                time: 4,
                title: '系统提醒',
                content: '请输入正确的积分数量！',
                lock: true
            });
        $("#txtcount").focus();
        return;
    }
    else {
        doAjax("../",
             'SetShopPonit',
             {
                 "shopID": $("#hdPointShopID").val(),
                 "count": $("#txtcount").val(),
                 "type": $('input[name="radPointType"]:checked').val()
             },
              "json",
            function (json) {
                switch (json) {
                    case 0:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("系统异常 未保存，请重试！"),
                                lock: true
                            });
                        break;
                    case 1:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("该店铺拥有的积分不足，不能扣除！"),
                                lock: true
                            });
                        break;
                    case -5:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("联盟商积分不足，无法增加该数量的积分！"),
                                lock: true
                            });
                        break;
                    default:
                        art.dialog
                            ({
                                title: '系统提示',
                                time: 2,
                                content: '保存成功！',
                                close: function () { location.href = "ShopList.aspx?PID=31"; },
                                lock: true
                            });
                        break;
                }
            });
    }
    }

/******************************************************************************************************
店铺购卡
******************************************************************************************************/
function btnShopBuyCards(shopname, shopid) {
    $("#lblShopName").html(shopname);
    art.dialog({
        title: '店铺购卡',
        content: document.getElementById('ShopBuyCard'),
        id: 'ShopBuyCardID',
        lock: true,
        close: function () { } //ShopReset();
    });
    doAjax("../",
             'GetShopInfo', { "shopID": shopid }, "json",
                 function (json) {
                     $("#hdCardShopID").val(json.ShopID);
                 });
}
function btSaveCardLog() {
    var strErrorMsg = "";
    if ($("#txtStartCardNumber").val() == "") {
        strErrorMsg += "<li>请输入卡片起始号;</li>";
    }
    if ($("#txtEndCardNumber").val() == "") {
        strErrorMsg += "<li>请输入卡片截止号;</li>";
    }
    if (!isIntPositive($("#txtStartCardNumber").val())) {
        strErrorMsg += "<li>卡片起始号只能输入数字;</li>";
    }
    else {
        if ($("#txtStartCardNumber").val().toString().length < 4 || $("#txtStartCardNumber").val().toString().length > 19) {
            strErrorMsg += "<li>卡片起始号必须是4~19位;</li>";
        }
    }
    if (!isIntPositive($("#txtEndCardNumber").val())) {
        strErrorMsg += "<li>卡片截止号只能输入数字;</li>";
    }
    else {
        if ($("#txtEndCardNumber").val().toString().length < 4 || $("#txtEndCardNumber").val().toString().length > 19) {
            strErrorMsg += "<li>卡片截止号必须是4~19位;</li>"
        }
    }
    if ($("#txtStartCardNumber").val().toString().length != $("#txtEndCardNumber").val().toString().length) {
        strErrorMsg += "<li>卡片起始号和卡片截止号长度必须一致;</li>"
    }
    if ($("#txtStartCardNumber").val().toString() > $("#txtEndCardNumber").val().toString()) {
        strErrorMsg += "<li>截止号必须大于起始号;</li>"
    }
    if ($("#txtBuyCardMoney").val() != "") {
        if (!$("#txtBuyCardMoney").val().IsDecimal()) {
            strErrorMsg += "<li>购卡总金额输入格式错误;</li>"
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
    doAjax("../",
             'ShopBuyCard.do',
             {
                 "shopid": $("#hdCardShopID").val(),
                 "startcardnumber": $("#txtStartCardNumber").val(),
                 "EndCardNumber": $("#txtEndCardNumber").val(),
                 "BuyCardMoney": $("#txtBuyCardMoney").val(),
                 "Remark": $("#txtRemark").val()
             },
              "json",
            function (json) {
                switch (json) {
                    case 0:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("系统异常 未保存，请重试！"),
                                lock: true
                            });
                        break;
                    case -1:
                        art.dialog
                            ({
                                time: 4,
                                title: '系统提示',
                                content: ("卡号重复，请检查之后重新输入！"),
                                lock: true
                            });
                        break;
                    default:
                        art.dialog
                            ({
                                title: '系统提示',
                                time: 1,
                                content: '保存成功！',
                                close: function () {
                                    //location.href = "ShopSendCard.aspx?PID=134";
                                    window.location.reload();
                                },
                                lock: true
                            });
                        break;
                }
            });
}

//function ShopDel(shopname,shopid) {
//    art.dialog({
//        title: '系统提示',
//        lock: true,
//        content: '确定要删除店铺【' + shopname + '】吗? 此操作不可恢复',
//        yesFn: function () {
//            this.close();
//            doAjax("../",
//             'ShopDel', { "shopID": shopid }, "json",
//                 function (json) {
//                     switch (json) {
//                         case 0:
//                             art.dialog
//                                   ({
//                                       title: '系统提示',
//                                       content: ("系统异常 记录未能删除，请重试！"),
//                                       lock: true
//                                   });
//                             break;
//                         case -3:
//                             art.dialog
//                                   ({
//                                       title: '系统提示',
//                                       content: ("系统错误 请与系统管理员联系！"),
//                                       lock: true
//                                   });
//                             break;
//                         case -2:
//                             art.dialog
//                                   ({
//                                       title: '系统提示',
//                                       content: ("此属性已经在系统中存在记录,不能删除！"),
//                                       lock: true
//                                   });
//                             break;
//                         default:
//                             art.dialog
//                                   ({
//                                       time: 1,
//                                       content: '删除成功！',
//                                       closeFn: function () { location.href = "CustomField.aspx?PID=34"; }
//                                   });
//                             break;
//                     }
//                 });
//            return false;
//        },
//        noText: '取消',
//        noFn: true //为true等价于function(){}
//    });
//    return false;
//}