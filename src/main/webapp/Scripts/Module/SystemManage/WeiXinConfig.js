﻿$(document).ready(function () {

    showhide();
    $("#txtWeixXinType").bind("change", showhide);
    $("#txtWeiXinVerified").bind("change", showhide);
    $("#selPay").bind("change", showhide);


    //绑定随机生成的事件
    $("#btnCreateRandomToken").bind("click", function () {
        var token = RandomChar(12);
        $("#txtWeiXinToken").val(token).change();
    });
    $("#btnCreateRandomAESKey").bind("click", function () {
        var token = RandomChar(43);
        $("#txtEncodingAESKey").val(token).change();
    });
    //绑定更新token和AESKey的事件
    $("#txtWeiXinToken").bind("change", function () {
        $("#spanToken").html($("#txtWeiXinToken").val());
    });
    $("#txtEncodingAESKey").bind("change", function () {
        $("#spanEncodingAESKey").html($("#txtEncodingAESKey").val());
    });
    //第一步提交
    $("#Step1Next").bind("click", function () {
        var status = Step1Check();
        if (status) {
            if (UpdateWebchatConfig()) {
                $(".step1").hide("slow");
                $(".step2").show("slow");
            }
            else {
                art.dialog({
                    title: 'warning',
                    icon: 'error',
                    content: "系统异常，请联系管理员！",
                    lock: true
                });
            }
        }
    });
    //第二步提交
    $("#Step2Next").bind("click", function () {
        var status = Step2Check();
        if (status) {
            $(".step2").hide("slow");
            $(".step3").show("slow");
        }
    });
    //第三步提交
    $("#Step3Next").bind("click", function () {
        var status = Step3Check();
        if (status) {
            if (UpdateWebchatConfig()) {
                if ($("#txtWeixXinType").val() != "0" && $("#txtWeiXinVerified").val() == "0"){
                    //新加（同步微信菜单）
                    doAjax("../", "CreateMenu", { "CreateMenu": "CreateMenu" }, "text", function (text) {
                        if (text == "0") {
                            art.dialog
                                ({
                                    title: '系统提示',
                                    time: 4,
                                    content: ("系统异常，未保存数据，请再次点击保存！"),
                                    lock: true
                                });
                        } if (text == "3") {
                            art.dialog
                                    ({
                                        title: '系统提示',
                                        time: 4,
                                        content: ("获取 access_token 失败，请稍后重试！"),
                                        lock: true
                                    });
                        }
                    });
                }

                art.dialog({
                    title: '系统提示',
                    icon: 'succeed',
                    content: "微信参数设置成功！",
                    lock: true,
                    close: function () { location.href = "WeiXinRuleList.aspx?PID=98"; }
                });
            }
            else {
                art.dialog({
                    title: 'warning',
                    icon: 'error',
                    content: "微信参数设置提交出现错误！",
                    lock: true
                });
            }
        }
    });
});

function showDialog(weixinPhotoType) {
    $("#txtWeiXinPhoteType").val(weixinPhotoType);
    $("#weixinPhoto").attr("height", "160").attr("width", "320");
    $("#weixinphotoremark").html("相片支持大小为640*320");
    switch (weixinPhotoType) {
        case 1:
            $("#weixinPhoto").attr("src", "../Upload/WeiXin/Images/" + "bg.jpg" + "?" + GetGuid());
            strTitle = "上传图片 --- 背景图";
            break;
        case 2:
            $("#weixinPhoto").attr("src", "../Upload/WeiXin/Images/" + "wwz.jpg" + "?" + GetGuid());
            strTitle = "上传图片 --- 微网站";
            break;
        case 3:
            $("#weixinPhoto").attr("src", "../Upload/WeiXin/Images/" + "memCard.jpg" + "?" + GetGuid());
            strTitle = "上传图片 --- 会员卡";
            break;
        case 4:
            $("#weixinPhoto").attr("src", "../Upload/WeiXin/Images/" + "rcode.jpg" + "?" + GetGuid());
            $("#weixinPhoto").attr("height", "200").attr("width", "200");
            $("#weixinphotoremark").html("二维码支持大小为200*200");
            strTitle = "上传图片 --- 二维码";
            break;
        default:
            break;
    }

    art.dialog({
        title: strTitle,
        content: document.getElementById('tableWeiXin'),
        id: 'tableWeiXin',
        lock: true,
        close: function () { $("#weixinPhoto").attr("src", "../images/member/nophoto.gif"); }
    });
}

//获取随机字符串
function RandomChar(len) {
    var char = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefjhijklmnopqrstuvwxyz";
    var tmp = "";
    for (var i = 0; i < len; i++) {
        tmp += char.charAt(Math.ceil(Math.random() * (char.length - 1)));
    }
    return tmp;
}

//第一步数据验证
function Step1Check() {
    var strErrorMsg = "";
    if ($("#txtWeixXinType").val() == "1" && $("#txtWeiXinVerified").val() == "1" && $("#selPay").val() == "1") {
        if ($.trim($("#txtMchId").val()) == "") {
            strErrorMsg += "<li>商户号不可以为空</li>";
        }
        if ($.trim($("#txtAPI").val()) == "") {
            strErrorMsg += "<li>API密钥不可以为空</li>";
        }
        var reg = /^[0-9]*[1-9][0-9]*$/;
        if (!reg.test($("#txtXiane").val())) {
            strErrorMsg += "<li>单笔最大限额必须为正整数</li>";
        }
    }
    if ($("#txtWeiXinToken").val() == "" || $("#txtWeiXinToken").val().length < 3 || $("#txtWeiXinToken").val().length > 32) {
        strErrorMsg += "<li>请根据提示填写正确的Token</li>";
    }
    if ($("#txtEncodingAESKey").val() == "" || $("#txtEncodingAESKey").val().length != 43) {
        strErrorMsg += "<li>请根据提示填写正确的EncodingAESKey</li>";
    }
    if ($("#txtWeiXinShopName").val() == "") {
        strErrorMsg += "<li>微信名称不可以为空</li>";
    }
    if ($("#txtWeiXinSalutatory").val() == "") {
        strErrorMsg += "<li>微信欢迎词不可以为空</li>";
    }
    if (strErrorMsg != "") {
        strErrorMsg = "<div>操作出现以下错误，请核查后重试！</div><ul>" + strErrorMsg + "</ul>";
        art.dialog({
            title: '系统提示',
            icon: 'error',
            content: strErrorMsg,
            lock: true
        });
        return false;
    }
    return true;
}

//第二步数据验证
function Step2Check() {
    var strErrorMsg = "";
    //若为服务号或已认证的订阅号，则验证微信appID和AppSecret
    if ($("#txtWeixXinType").val() == "1" || $("#txtWeiXinVerified").val() == "1") {
        if ($("#txtAppId").val() == "" || $("#txtAppId").val().length != 18) {
            strErrorMsg += "<li>请填写正确的AppId</li>";
        }

        if ($("#txtAppSecret").val() == "" || $("#txtAppSecret").val().length != 32) {
            strErrorMsg += "<li>请填写正确的AppSecret</li>";
        }

        doAjax(
            "../",
            'GetAccessToken',
            { "appId": $("#txtAppId").val(), "appSecret": $("#txtAppSecret").val() },
            "json",
            function (json) {
                if (json == "0") {
                    strErrorMsg += "<li>验证微信AppId和AppSecret失败，请检查并重新验证</li>";
                }
            },
            false
        );
    }
    
    if (strErrorMsg != "") {
        strErrorMsg = "<div>操作出现以下错误，请核查后重试！</div><ul>" + strErrorMsg + "</ul>";
        art.dialog({
            title: '系统提示',
            icon: 'error',
            content: strErrorMsg,
            lock: true,
            okValue:"确认",
            ok: function () {
                this.close();
            }
        });
        return false;
    }
    return true;
}

//第三步数据验证
function Step3Check() {
    var strErrorMsg = "";
    if ($("#txtSignInPoint").val() != "" && !$("#txtSignInPoint").val().IsDecimal()) {
        strErrorMsg += "<li>赠送积分数量请填入阿拉伯数字</li>";
    }
    if ($("#chkWeiXinSMSVcode").attr("checked") == true && SysParameter().sms == false ) {
        strErrorMsg += "<li>需要先开启系统通知短信，才可以开通微信短信验证功能</li>";
    }
    if (strErrorMsg != "") {
        strErrorMsg = "<div>操作出现以下错误，请核查后重试！</div><ul>" + strErrorMsg + "</ul>";
        art.dialog({
            title: '系统提示',
            icon: 'error',
            content: strErrorMsg,
            lock: true
        });
        return false;
    }
    return true;
}

//更新微信相关的参数设置
function UpdateWebchatConfig() {
    var updateSuccess = false;
    doAjax(
        "../",
        'UpdateWebchatConfig',
        {
            "WeiXinType": $("#txtWeixXinType").val(),
            "WeiXinVerified": $("#txtWeiXinVerified").val(),
            "WeiXinToken": $("#txtWeiXinToken").val(),
            "WeiXinEncodingAESKey": $("#txtEncodingAESKey").val(),
            "WeiXinShopName": $("#txtWeiXinShopName").val(),
            "WeiXinSalutatory": $("#txtWeiXinSalutatory").val(),
            "WeiXinAppID": $("#txtAppId").val(),
            "WeiXinAppSecret": $("#txtAppSecret").val(),
            "WeiXinSMSVcode": $("#chkWeiXinSMSVcode").attr("checked"),
            "SignInPoint": $("#txtSignInPoint").val() == "" ? 0 : $("#txtSignInPoint").val(),
            "Api": $("#txtAPI").val(),
            "MchId": $("#txtMchId").val(),
            "Pay": $("#selPay").val(),
            "Xiane": $("#txtXiane").val()
        },
        "json",
        function (json) {
            if (json == "1") {
                updateSuccess = true;
            }
            else {
                updateSuccess = false;
            }
        },
        false
    );
    return updateSuccess;
}



function showhide() {
    if ($("#txtWeixXinType").val() == "0") {
        $("#trMchId").hide();
        $("#trAPI").hide();
        $("#trPay").hide();
        $("#trtxtXiane").hide();
        return;
    }
    if ($("#txtWeiXinVerified").val() == "0") {
        $("#trMchId").hide();
        $("#trAPI").hide();
        $("#trPay").hide();
        $("#trtxtXiane").hide();
        return;
    }
    $("#trPay").show();
    if ($("#selPay").val() == "0") {
        $("#trMchId").hide();
        $("#trAPI").hide();
        $("#trtxtXiane").hide();
        return;
    }

    $("#trtxtXiane").show();
    $("#trMchId").show();
    $("#trAPI").show();
}