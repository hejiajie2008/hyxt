var chkNoMember = false;
var strDiscountMoney = 0;
var strOrderAccount = "";
var dclActualTotal = 0;
var IsShowPay = true;
var parameter = new Array();
var strOrderType = "";
$(document).ready(function () {
	
	chkNoMember = $("#chkNoMember").attr("checked");
    //密码回车响应事件
    $("#txtPwd").keypress(function (e) {
        var keyAscii = window.event ? e.keyCode : e.which;
        if (keyAscii == 13)
            CheckPwd();
    });
    //输入优惠券回车事件
    $("#txtCoupon").keypress(function (e) {
        var keyAscii = window.event ? e.keyCode : e.which;
        if (keyAscii == 13) {
            if ($.trim($("#txtCoupon").val()) == "") {
                $("#spCoupanResult").html("");
                //初始化数据
                InitData(global_mem.MemMoney, strDiscountMoney, strOrderAccount);
                return;
            }
            else {
                BindCoupon();
            }
        }
    });

    //密码确定按钮响应事件
    $("#btnCheckPwd").bind("click", CheckPwd);
    //结算响应事件
    $("#btnPayChange").bind("click", btnPayChange);
    $("#btnCancel").bind("click", btnCancel);
    // 数据输入验证，并计算找零
    $("#txtByCardMoney").bind("keyup", UnionMoney);
    $("#txtByCashMoney").bind("keyup", UnionMoney);
    $("#txtByBankMoney").bind("keyup", UnionMoney);

    $("#ucPay_chkCard").bind("click", ChkCard);
    $("#ucPay_chkCash").bind("click", ChkCash);
    $("#ucPay_chkBink").bind("click", ChkBink);
});
//弹出密码验证
function ShowPwd(orderType, OrderAccount, DiscountMoney, IsShow) {
    art.dialog({
        title: '密码验证',
        content: document.getElementById('tbCheckPwd'),
        id: 'tbCheckPwd',
        lock: true,
        init: function () {
            $('#txtPwd').focus().select();
        }
    });
    IsShowPay = IsShow;
}
var isAllowPwd;
//弹出支付界面
function ShowPay(orderType, memMoney, DiscountMoney, OrderAccount, chkAllowPwd) {
    isAllowPwd = chkAllowPwd;
    $("#btnPayChange").attr("disabled", "");
    art.dialog({
        height: 350,
        width: 380,
        title: '付费找零',
        content: document.getElementById('tbPay'),
        id: 'tbPay',
        lock: true,
        close: function () { InitData(memMoney, DiscountMoney, OrderAccount); }
    });
    strOrderType = orderType;
    strDiscountMoney = DiscountMoney;
    strOrderAccount = OrderAccount;
    
    InitData(memMoney, DiscountMoney, OrderAccount);
}

function ChkCard() {
	
    if ($("#ucPay_chkCard").attr("checked")) {
    	
        $("#txtByCardMoney").attr("disabled", "");
        var ChangeMoney = parseFloat($("#txtChangeMoney").val()) ? parseFloat($("#txtChangeMoney").val()) : 0//找零金额
        if (ChangeMoney > 0) {//找零金额为负才赋值
            $("#txtByCardMoney").val("0");
        } else {
            $("#txtByCardMoney").val(global_mem.memmoney.ToFloat() < Math.abs(ChangeMoney) ? global_mem.memmoney : Math.abs(ChangeMoney));
        }
        UnionMoney();
    }
    else {
        $("#txtByCardMoney").attr("disabled", "disabled");
        $("#txtByCardMoney").val("0.00");
        UnionMoney();
    }
}

function ChkCash() {
    if ($("#ucPay_chkCash").attr("checked")) {
        $("#txtByCashMoney").attr("disabled", "");
        $("#txtByCashMoney").focus().select();
        //        var ChangeMoney = parseFloat($("#txtChangeMoney").val()) ? parseFloat($("#txtChangeMoney").val()) : 0//找零金额
        //        $("#txtByCashMoney").val(ChangeMoney > 0 ? 0 : Math.abs(ChangeMoney));
        //        UnionMoney();
    }
    else {
        $("#txtByCashMoney").attr("disabled", "disabled");
        $("#txtByCashMoney").val("0.00");
        UnionMoney();
    }
}
function ChkBink() {
    if ($("#ucPay_chkBink").attr("checked")) {
        $("#txtByBankMoney").attr("disabled", "");
        $("#txtByBankMoney").focus().select();
        //        var ChangeMoney = parseFloat($("#txtChangeMoney").val()) ? parseFloat($("#txtChangeMoney").val()) : 0//找零金额
        //        $("#txtByBankMoney").val(ChangeMoney > 0 ? 0 : Math.abs(ChangeMoney));
        //        UnionMoney();
    }
    else {
        $("#txtByBankMoney").attr("disabled", "disabled");
        $("#txtByBankMoney").val("0.00");
        UnionMoney();
    }
}
//初始化数据
function InitData(memMoney, DiscountMoney, OrderAccount) {
	
    strDiscountMoney = DiscountMoney;
    strOrderAccount = OrderAccount;
   
    //显示订单号
    $("#spOrderCode").html(strOrderAccount);
    //账户余额
    $("#spMemMoney").html(memMoney);
    //应付金额
    $("#txtTotalMoney").val(strDiscountMoney);
    $("#txtByCashMoney").val("0.00");
    $("#txtByCashMoney").attr("disabled", "disabled")
    $("#txtByBankMoney").val("0.00");
    $("#txtByBankMoney").attr("disabled", "disabled");
    $("#ucPay_chkCard").attr("checked","checked");
   
    if (!chkNoMember) {
    	
        //解禁并将账户余额显示出来
        $("#ucPay_chkCard").attr("disabled", "");
        
        $("#txtByCardMoney").attr("disabled", "");
        $("#trIsNoMember").css("display", "");
       
     
        //如果会员的余额大于应付的金额
        if (strDiscountMoney <= memMoney && $("#ucPay_trByCard").css("display") != "none") {
            //            $("#ucPay_chkCard").attr("checked", true);
            //        $("#chkCash").attr("checked", false);
            $("#txtByCardMoney").val("0.00");
            $("#txtByCashMoney").val("0.00");
            $("#ucPay_chkCash").attr("checked", false);
            $("#txtByCashMoney").attr("disabled", "disabled");
        }
        else {
            //            $("#ucPay_chkCash").attr("checked", true);
            //            $("#txtByCashMoney").attr("disabled", "");
            //如果余额不等0时
            if (memMoney != 0) {
                //                $("#ucPay_chkCard").attr("checked", true);
                $("#txtByCardMoney").attr("disabled", "");
                $("#txtByCardMoney").val("0.00");
            }
            else {
                $("#ucPay_chkCard").attr("disabled", "disabled");
                $("#txtByCardMoney").attr("disabled", "disabled");
                $("#ucPay_chkCard").attr("checked", false);
                $("#txtByCardMoney").val("0.00");
            }
            //            if (memMoney != 0 && $("#ucPay_trByCard").css("display") != "none") {
            //                $("#ucPay_chkCard").attr("checked", true);
            //                $("#txtByCardMoney").attr("disabled", "");
            //                $("#txtByCardMoney").val(memMoney);
            //                var dclCashMoney = Number(strDiscountMoney) - Number(memMoney);
            //                $("#txtByCashMoney").val(dclCashMoney.toFixed(2));

            //            }
            //            else {
            //                $("#ucPay_chkCard").attr("disabled", "disabled");
            //                $("#txtByCardMoney").attr("disabled", "disabled");
            //                $("#ucPay_chkCard").attr("checked", false);
            //                $("#txtByCardMoney").val("0.00");
            //                $("#txtByCashMoney").val(strDiscountMoney);
            //            }
            //            if ($("#ucPay_trByCash").css("display") == "none") {
            //                $("#txtByCashMoney").val("0.00");
            //            }
        }
        
    }
    else {
        //散客没有账户余额，禁用，也不能实现余额支付
        $("#ucPay_chkCard").attr("disabled", "disabled");
        $("#ucPay_chkCard").attr("checked", false); 
        $("#txtByCardMoney").attr("disabled", "disabled");
        $('#txtByCashMoney').removeAttr("disabled");
        $("#ucPay_chkCash").attr("checked", true); 
        $("#trIsNoMember").css("display", "none");
        //        $("#ucPay_chkCash").attr("checked", true);
        $("#txtByCardMoney").val("0.00");
        //        if ($("#ucPay_trByCash").css("display") == "none") {
        //            $("#txtByCashMoney").val("0.00");
        //        }
        //        else {
        //            $("#txtByCashMoney").val(strDiscountMoney);
        //            $("#txtByCashMoney").attr("disabled", false);
        //        }
        $("#txtByCashMoney").val("0.00");
        $("#ucPay_trByCard").css("display", "none");
        
    }

    $("#txtCouponMoney").val("0.00");

    $("#spCoupanResult").html("输入优惠券号后请按Enter键确认");
    $("#txtCoupon").val("");
    //实际支付
    dclActualTotal = accAdd(accAdd(accAdd($("#txtByCardMoney").val().ToFloat(), $("#txtByCashMoney").val().ToFloat()), $("#txtCouponMoney").val()), $("#txtByBankMoney").val());
    $("#txtActualTotal").val(dclActualTotal.toFixed(2));

    $("#txtChangeMoney").val((Number(dclActualTotal) - Number(strDiscountMoney)).toFixed(2));

    $("#ucPay_chkBink").attr("checked", !$("#txtByBankMoney").attr("disabled"));

    //优惠券详情
    $("#spCouPon").html("");
    $("#spCouponTitle").html("");
    $("#spCouponType").html("");
    $("#spCouponNumber").html("");
    $("#spCouponDayNum").html("");
    $("#spCouponMinMoney").html("");
    $("#spConponSendTime").html("");
    $("#spConponSendMem").html("");
    $("#spCouponUseTime").html("");
    $("#spCouponAccount").html("");
    $("#spCouponTime").html("");
}
//验证密码事件
function CheckPwd() {
    $("#txtPwd").focus();
    var strPwd = $("#txtPwd").val();
    doAjax(
               "../",
               "MemCheckPwd",
               { "memID": global_mem.MemID, "memPassword": strPwd },
               "json",
               function (json) {
                   if (json > 0) {
                       if (IsShowPay) {
                           BindParameter();
                       }
                   }
                   else {
                       art.dialog({
                           title: '系统提示',
                           content: ("密码输入错误，请重试！"),
                           lock: true
                       });
                       $("#txtPwd").focus().select();
                   }
               });
}
//绑定优惠券的信息
function BindCoupon() {
	
    doAjax("../",
                   "GetCouponDetail",
                   { "CouPon": $.trim($("#txtCoupon").val()),
                       "MemID": global_mem.memid
                   },
                   "json",
                   function (json) {
                       if (json == null) {
                           //初始化数据
                           InitData(global_mem.memmoney, strDiscountMoney, strOrderAccount);
                           $("#spCoupanResult").html("没有该优惠券号,请输入正确优惠券号！");
                           return;
                       }
                       else {
                           //优惠券详情
                           $("#spCouPon").html(json.msgData[0].coupon);
                           $("#spCouponTitle").html(json.msgData[0].coupontitle);
                           if (json.msgData[0].coupontype == "0") {
                               $("#spCouponType").html("代金券");
                               $("#spCouponNumName").html("优惠金额：");
                           }
                           else {
                               $("#spCouponType").html("折扣券");
                               $("#spCouponNumName").html("折扣比例：");
                           }
                           $("#spCouponNumber").html(json.msgData[0].couponnumber);
                           $("#spCouponDayNum").html(json.msgData[0].coupondaynum);
                           $("#spCouponMinMoney").html(parseFloat(json.msgData[0].couponminmoney).toFixed(2));
                           $("#spConponSendTime").html(json.msgData[0].conponsendtime);
                           $("#spConponSendMem").html(json.msgData[0].memname);
                           $("#spCouponUseTime").html(json.msgData[0].conponusetime);
                           $("#spCouponAccount").html(json.msgData[0].couponorderaccount);
                           if (json.msgData[0].couponeffective == "0") {
                               $("#spCouponTime").html("永久有效！");
                           }
                           else {
                               $("#spCouponTime").html(json.msgData[0].couponstart.split(" ")[0] + "至" + json.msgData[0].couponend.split(" ")[0]);
                           }
                       }
                       if (global_mem.memid != json.msgData[0].couponmid) {
                           $("#spCoupanResult").html("优惠券只能本人使用" + ", <a href='javascript:GetCouponDetail()'>查看优惠券详情</a>");
                           return;
                       }

                       if (json.msgData[0].couponsy == "True") {
                           $("#spCoupanResult").html("该优惠券已经使用了" + ", <a href='javascript:GetCouponDetail()'>查看优惠券详情</a>");
                           return;
                       }

                       if (strDiscountMoney < parseFloat(json.msgData[0].couponminmoney)) {
                           $("#spCoupanResult").html("不能达到最低消费金额" + parseFloat(json.msgData[0].couponminmoney).toFixed(2) + "元" + ", <a href='javascript:GetCouponDetail()'>查看优惠券详情</a>");
                           return;
                       }
                       if (json.msgResult == "1") {
                           $("#spCoupanResult").html("该类型优惠券单日限用" + json.msgData[0].coupondaynum + "张" + ", <a href='javascript:GetCouponDetail()'>查看优惠券详情</a>");
                           return;
                       }

                       var dtNow = new Date();
                       var dtCouponStart = json.msgData[0].couponstart.replace(/-/g, '/');
                       dtCouponStart = new Date(dtCouponStart);
                       var dtCouponEnd = json.msgData[0].couponend.replace(/-/g, '/');
                       dtCouponEnd = new Date(dtCouponEnd);

                       if (dtNow < dtCouponStart || dtNow > dtCouponEnd) {
                           $("#spCoupanResult").html("该优惠券已过期" + ", <a href='javascript:GetCouponDetail()'>查看优惠券详情</a>");
                           return;
                       }
                       $("#spCoupanResult").html("优惠券名称：" + json.msgData[0].CouponTitle + ", <a id='a' href='javascript:GetCouponDetail()'>查看优惠券详情</a>");
                       var dclMoney = 0.00;
                       if (json.msgData[0].coupontype == "0") {
                           dclMoney = strDiscountMoney - parseFloat(json.msgData[0].CouponNumber);
                           $("#txtCouponMoney").val(json.msgData[0].CouponNumber);
                       }
                       else if (json.msgData[0].coupontype == "1") {
                           //var dclCouponMoney = accSub(strDiscountMoney, accMul(accDiv(json.msgData[0].CouponNumber, 100), strDiscountMoney));
                           var dclCouponMoney =  accMul(accDiv(json.msgData[0].CouponNumber, 100), strDiscountMoney);
                           //dclMoney = parseFloat(accMul(strDiscountMoney, accDiv(json.msgData[0].CouponNumber, 100))).toFixed(2);
                           dclMoney= parseFloat($("#txtTotalMoney").val()) - parseFloat(dclCouponMoney)
                           $("#txtCouponMoney").val(dclCouponMoney);
                       }

                       if (dclMoney <= global_mem.memmoney.ToFloat()) {
                           $("#txtByCardMoney").val(dclMoney);
                           $("#txtByCashMoney").val("0.00");
                           $("#ucPay_chkCash").attr("checked", false);
                           $("#txtByBankMoney").val("0.00");
                           $("#ucPay_chkBink").attr("checked", false);
                       }
                       else {
                           if (global_mem.memmoney != "0.00") {
                               $("#txtByCardMoney").val(global_mem.memmoney);
                               var dclCashMoney = parseFloat(dclMoney) - parseFloat(global_mem.MemMoney);
                               $("#txtByCashMoney").val(dclCashMoney.toFixed(2));
                               $("#ucPay_chkCash").attr("checked", true);
                               $("#txtByBankMoney").val("0.00");
                               $("#ucPay_chkBink").attr("checked", false);
                           }
                           else {
                               $("#txtByCashMoney").val(dclMoney);
                           }
                       }
                       dclActualTotal = accAdd(accAdd(accAdd($("#txtByCardMoney").val().ToFloat(), $("#txtByCashMoney").val().ToFloat()), $("#txtByBankMoney").val()), $("#txtCouponMoney").val());
                       $("#txtActualTotal").val(dclActualTotal.toFixed(2));
                       $("#txtChangeMoney").val("0.00");
                   });
}

function UnionMoney() {
	
    if ($(this).val().isFloatPositive()) {
        var dclCarMoney = $("#txtByCardMoney").val().ToFloat();
        if (!chkNoMember) {
            if (dclCarMoney > global_mem.memmoney) {
                art.dialog({
                    title: '系统提示',
                    content: ("账户余额不足，请重新输入！"),
                    lock: true
                });
                $("#txtByCardMoney").select();
            }
        }
        //余额支付  如果手动输入的 金额大于应付金额  则将应付金额赋给文本框
        if (dclCarMoney > $("#txtTotalMoney").val().ToFloat()) {
            $("#txtByCardMoney").val($("#txtTotalMoney").val().ToFloat());
        }

        var dclTotal = accSub(strDiscountMoney, $("#txtCouponMoney").val());
        var dclPayTotal = accAdd(accAdd($("#txtByCardMoney").val().ToFloat(), $("#txtByCashMoney").val().ToFloat()), $("#txtByBankMoney").val().ToFloat());
        var dclChangeMoney = accSub(dclPayTotal, dclTotal);
        dclActualTotal = accAdd(accAdd($("#txtByCardMoney").val().ToFloat(), $("#txtByCashMoney").val().ToFloat()), $("#txtByBankMoney").val());
        $("#txtChangeMoney").val(dclChangeMoney.toFixed(2));
        $("#txtActualTotal").val(dclActualTotal.toFixed(2));
    }
    else {
        $("#txtChangeMoney").val("0.00");
        $("#txtActualTotal").val("0.00");
    }
}

var cardPayMoney = 0, cashPayMoney = 0, couponPayMoney = 0, binkPayMoney = 0;
function btnPayChange() {
    cardPayMoney = 0;
    cashPayMoney = 0;
    couponPayMoney = 0;
    binkPayMoney = 0;
    
    $("#btnPayChange").attr("disabled", "disabled");
    if ($("#ucPay_chkCard").attr("checked") && !$("#ucPay_trByCard").attr("disabled")) {
        if ($("#txtByCardMoney").val().ToFloat() != 0) {
            cardPayMoney = $("#txtByCardMoney").val().ToFloat();
            if (cardPayMoney > global_mem.memmoney) {
                art.dialog({
                    title: '系统提示',
                    content: ("账户余额不足，无法完成支付！"),
                    lock: true
                });
                $("#txtByCardMoney").select();
                $("#btnPayChange").attr("disabled", "");
                return;
            }
        }
        else {
            art.dialog({
                title: '系统提示',
                content: ("已选择余额支付，请输入金额！"),
                lock: true
            });
            $("#txtByCardMoney").select();
            $("#btnPayChange").attr("disabled", "");
            return;
        }
    }

    if (chkNoMember && $("#ucPay_trByCash").css("display") == "none" && $("#ucPay_trByBink").css("display") == "none") {
        art.dialog({
            title: '系统提示',
            content: ("散客消费必须开启现金支付或者银联支付！"),
            lock: true
        });
        $("#btnPayChange").attr("disabled", "");
        return;
    }
    cashPayMoney = $("#txtByCashMoney").val().ToFloat();
    if ($("#ucPay_chkCash").attr("checked") && cashPayMoney == 0) {
        art.dialog({
            title: '系统提示',
            content: ("已选择现金支付，请输入金额！"),
            lock: true
        });
        $("#txtByCardMoney").select();
        $("#btnPayChange").attr("disabled", "");
        return;
    }
    binkPayMoney = $("#txtByBankMoney").val().ToFloat();
    if ($("#ucPay_chkBink").attr("checked") && binkPayMoney == 0) {
        art.dialog({
            title: '系统提示',
            content: ("已选择银联支付，请输入金额！"),
            lock: true
        });
        $("#txtByCardMoney").select();
        $("#btnPayChange").attr("disabled", "");
        return;
    }
    if (dclActualTotal < accSub(strDiscountMoney, $("#txtCouponMoney").val().ToFloat())) {
        art.dialog({
            title: '系统提示',
            content: ("支付金额不足，请重新填写！"),
            lock: true
        });
        $("#txtByCardMoney").select();
        $("#btnPayChange").attr("disabled", "");
        return;
    }
    if (!chkNoMember && isAllowPwd && cardPayMoney > 0) {
        ShowPwd("Expense", $.trim($("#lblOrderAccount").html()), strDiscountMoney, true);
    }
    else {
        BindParameter();
    }
    
};

function BindParameter() {
    if ($("#txtCouponMoney").val() != undefined) {
        couponPayMoney = $("#txtCouponMoney").val().ToFloat();
        if (couponPayMoney != 0) {
            doAjax(
                   "",
                   "UpdateCouponList.do",
                   {
                       "Coupon": $("#txtCoupon").val(),
                       "OrderAccount": strOrderAccount
                   },
                   "json",
                   function (json) {
                	   alert("Ok"+json);
                   });
        }
    }
    var changeMoney = $("#txtChangeMoney").val();
   
    parameter.push({ "payType": strOrderType, "IsCard": $("#ucPay_chkCard").attr("checked")?1:0, "IsCash": $("#ucPay_chkCash").attr("checked")?1:0, "IsBink": $("#ucPay_chkBink").attr("checked")?1:0, "CardMoney": cardPayMoney, "CashMoney": accSub(cashPayMoney, changeMoney), "CouponMoney": couponPayMoney, "BinkMoney": binkPayMoney, "DiscountMoney": parseFloat(strDiscountMoney), "ChangeMoney": $("#txtChangeMoney").val() });
    ExpenseOK(parameter);
}

function btnCancel() {
    var list = art.dialog.list;
    for (var i in list) {
        list[i].close();
    };
}