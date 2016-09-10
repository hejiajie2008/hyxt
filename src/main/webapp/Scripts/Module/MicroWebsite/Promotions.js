$(function () {
    //BindNullList("gvPromotionsList");

    $("input[name='radCouponYesOrNo']:radio").bind("change", function () {
        $("#txtPromotionsStartTime,#txtPromotionsEndTime").val("");
    });

    $('#txtPromotionsEndTime').bind("focus", function () {
        WdatePicker({ skin: 'whyGreen', minDate: '#F{$dp.$D(\'txtPromotionsStartTime\')}', isShowClear: true, readOnly: true });

    });
    $('#txtPromotionsStartTime').bind("focus", function () {
        var EndTime = $dp.$('txtPromotionsEndTime');
        WdatePicker({ skin: 'whyGreen', minDate: '%y-%M-%d', isShowClear: true, readOnly: true, onpicked: function () { EndTime.focus(); } });
    });

    //新增活动
    $("#btnPromotionsAdd").bind("click", btnPromotionsAddClick);

    //保存
    $("#btnPromotionsSave").bind("click", btnPromotionsSaveClick);
})

//新增优惠活动
function btnPromotionsAddClick() {
    $("#txtType,#txtPromotionsTitle,#txtPromotionsStartTime,#txtPromotionsEndTime").val("");
    $("#sltPromotionsLevel").val("-1");
    $("#radPromotionsYes").attr("checked", true);

    artDialog({
        title: '新增活动',
        content: document.getElementById('PromotionsInfo'),
        id: 'PromotionsInfo',
        lock: true
    })
}

//保存
function btnPromotionsSaveClick() {
    var txtPromotionsTitle = $.trim($("#txtPromotionsTitle").val());
    var radPromotionsYes = $("#radPromotionsYes").attr("checked");
    var txtPromotionsStartTime = $.trim($("#txtPromotionsStartTime").val());
    var txtPromotionsEndTime = $.trim($("#txtPromotionsEndTime").val());
    var sltPromotionsLevel = $("#sltPromotionsLevel").val();
    var txtType = $("#txtType").val();
    var type = $("#txtType").val() == "" ? "AddPromotions" : "EditPromotions";

    var strErrorMsg = "";
    if (txtPromotionsTitle == "") { strErrorMsg += "<li>请填写优惠活动标题</li>"; }
    if (!radPromotionsYes && (txtPromotionsStartTime == "" || txtPromotionsEndTime == "")) { strErrorMsg += "<li>请选择正确的优惠活动日期</li>"; }

    if (strErrorMsg != "") {
        strErrorMsg = "<div>操作出现以下错误，请核查后重试！</div><ul>" + strErrorMsg + "</ul>";
        art.dialog({
            title: '系统提醒',
            icon: 'error', //图标
            content: strErrorMsg,
            lock: true
        });
        return false;
    }

    art.dialog({
        title: '系统提示',
        content: "将" + (type == "AddPromotions" ? "新增" : "修改") + "优惠活动。\n确定操作吗？",
        lock: true,
        ok: function () {
            doAjax("../", type, {
                "PromotionsID": txtType,
                "PromotionsTitle": txtPromotionsTitle,
                "PromotionsStart": txtPromotionsStartTime,
                "PromotionsEnd": txtPromotionsEndTime,
                "PromotionsMemLevel": sltPromotionsLevel,
                "PromotionsType": radPromotionsYes ? 0 : 1
            }, "text", function (text) {
                if (text == "0") {
                    art.dialog({
                        title: '系统提示',
                        time: 4,
                        content: ("系统异常，未保存数据，请再次点击保存！"),
                        lock: true
                    });
                } else {
                    art.dialog({
                        title: '系统提示',
                        time: 0.5,
                        content: '保存成功！',
                        close: function () { window.location = window.location; },
                        lock: true
                    });
                }
            })
        },
        cancelVal: '取消',
        cancel: true
    })
}


//删除
function btnPromotionsDel(PromotionsID, PromotionsTitle) {
    art.dialog({
        title: "系统提示",
        lock: true,
        content: '确定要删除优惠活动【' + PromotionsTitle + '】吗? 此操作不可恢复',
        ok: function () {
            this.lock();
            doAjax("../", "DelPromotions", { "PromotionsID": PromotionsID }, "text", function (text) {
                if (text == "0") {
                    art.dialog
                              ({
                                  title: '系统提示',
                                  time: 4,
                                  content: ("系统错误 请与系统管理员联系！"),
                                  lock: true
                              });
                } else {
                    art.dialog
                                ({
                                    title: '系统提示',
                                    time: 0.5,
                                    content: '删除成功！',
                                    close: function () { window.location = window.location; },
                                    lock: true
                                });
                }
            })
            return false;
        },
        cancelVal: '取消',
        cancel: true //为true等价于function(){}
    })
}

//编辑
function btnPromotionsEdit(PromotionsID, PromotionsTitle, PromotionsStart, PromotionsEnd, PromotionsMemLevel, PromotionsType) {
    $("#txtType").val(PromotionsID);
    $("#txtPromotionsTitle").val(PromotionsTitle);
    if (PromotionsType == 0) {
        $("#radPromotionsYes").attr("checked", true);
        $("#txtPromotionsStartTime").val("")
        $("#txtPromotionsEndTime").val("")
    } else {
        $("#radPromotionsNo").attr("checked", true);
        $("#txtPromotionsStartTime").val(PromotionsStart.substring(0, PromotionsStart.length - 8));
        $("#txtPromotionsEndTime").val(PromotionsEnd.substring(0, PromotionsEnd.length - 8));
    }
    $("#sltPromotionsLevel").val(PromotionsMemLevel);

    artDialog({
        title: '编辑活动',
        content: document.getElementById('PromotionsInfo'),
        id: 'PromotionsInfo',
        lock: true
    })
}