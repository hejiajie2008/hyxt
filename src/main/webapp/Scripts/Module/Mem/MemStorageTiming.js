var myProjectdata;
$(document).ready(function () {
    //是否散客
    var chkNoMember;
    //没有查询会员时 所有控件禁用
    if ($.isEmptyObject(global_mem)) {
        $("#txtExpMoney").attr("disabled", "disabled");
        $("#txtDiscountMoney").attr("disabled", "disabled");
        $("#txtExpPoint").attr("disabled", "disabled");
        $("#txtRechargeTime").attr("disabled", "disabled");
        $("#txtExpRemark").attr("disabled", "disabled");
        
    }
    
    $("#lblOrderCreateTime").text($.getnowtime());

    if ($("#MemCard").val() != null) {
        if ($("#MemCard").val() != "0") {
            $("#txtFindMember").val($("#MemCard").val());
        }
        else {
            $("#chkNoMember").attr("checked", "checked");
        }
    }

    //如果没有启用打印小票，隐藏打印小票选择框
    if (!$("#chkPrint").attr("checked")) {
        $("#lblIsPrint").css("display", "none");
    }

    //重置按钮响应函数
    $("#btnExpenseReset").bind("click", BtnExpenseReset);

    //保存按钮响应函数
    $("#btnExpSave").bind("click", btnExpSave);

    //输入消费金额得到折后金额和积分
    $("#txtExpMoney").bind("keyup", DiscountMoney);

    //只输入折后金额得到积分
    $("#txtDiscountMoney").bind("keyup", DiscountPoint);
    //输入积分触发的事件
    $("#txtExpPoint").bind("keyup", ExpPoint);

    $("#txtRechargeTime").bind("keyup", RechargeTime);
    //选择服务项目
    $("#btnChooseProject").bind("click", ChooseProject);
});

var pageSize = 8;
var currentPage = 1;
var ProjectSearch;
function ChooseProject() {
	
    doAjax("MemExpense/",
           "GetPrjectByPage.do",
           {
               "pageSize": pageSize,
               "page": currentPage,
               "projectname": $("#txtProjectName").val(),
               "memid": global_mem.memid
           },
           "json",
           function (json) {
        	  
               CreateProjectList(json.rows);
               MyCreateProjectPager(json.total);
               $("#txtProjectName").focus();
               ProjectSearch = art.dialog({
                   title: '选择计时服务',
                   content: document.getElementById('TimingProjectList'),
                   id: 'TimingProjectList',
                   lock: true
               });
           }
    );
}
function MyCreateProjectPager(resCount) {
    var page = new CommonPager(
        "ProjectList",
        pageSize,
        resCount,
        currentPage,
        function (p) {
            currentPage = parseInt(p);
            ChooseProject();
        }
    );
    page.ShowSimple();
}

function CreateProjectList(obj) {
    var html = ''
    if (obj.length > 0) {
        $.each(obj, function (index, item) {
            html += "<tr class=\"td\" ondblclick=\"javascript:QuickProject(\'" + item.projectrulesid + "','" + item.projectname + "','" + item.projectid + "','" + item.allcount + "\');\">"
                 + '<td style=" width:60px;">' + item.projectname + '</td>'
                   + '<td style=" width:60px;">' + item.allcount + '</td>'
                 + '<td style=" width:60px;">' + item.rulesname + '</td>'
                 + '<td style=" width:160px;">' + item.rulesremark + '</td>'
                 + '</tr>';


        });
    }
    else {
        html += '<td style="height:50px; line-height:50px;background-color:#fff;text-align:center;" colspan="4">未找到符合此条件的数据！请重试！</td>';
    }
    $("#tbProject").html(html);
}

function QuickProject(RulesID, ProjectName, ProjectID, time) {
    $("#txtProjectName").val("");
    ProjectSearch.close();
    doAjax("MemExpense/",
           "GetRules.do",
           {
               "rulesid": RulesID
           },
           "json",
           function (jsons) {
        	   var json=jsons[0];
               $("#txtProjectID").val(ProjectID);
               $("#lbProjectDescription").html("计时服务名称：" + ProjectName + "  规则描述：" + json.rulesremark + "  剩余时长：" + time);
               notforbidden();
               myProjectdata = json;
           }

    );
}

/*************************************************************************
*输入消费金额得到折后金额和积分
*************************************************************************/
function DiscountMoney() {
    var dclExpMoney = $("#txtExpMoney").val();
    if (dclExpMoney.IsDecimal()) {
        //        if ($("#chkNoMember").attr("checked")) {
        //            levelPercent = 1;
        //            pointPercent = 1;
        //        }
        //        else {
        //            var levelPercent = (global_mem.LevelDiscountPercent != 0) ? global_mem.LevelDiscountPercent : 0;
        //            var pointPercent = (global_mem.LevelPointPercent != 0 || global_mem.LevelPointPercent != undefined) ? global_mem.LevelPointPercent : 0;
        //        }

        //        if (levelPercent != 0) {
        //            $("#txtDiscountMoney").val(parseFloat(accMul(parseFloat($(this).val()), levelPercent)).toFixed(2));
        //        }
        //        else {
        //            $("#txtDiscountMoney").val($(this).val());
        //        }

        //        if (pointPercent != 0) {
        //            if (!$("#chkNoMember").attr("checked")) {
        //                $("#txtExpPoint").val(Math.floor(accMul(parseFloat($("#txtDiscountMoney").val()), pointPercent)));
        //            }
        //        }
        //        if ($.trim($("#txtExpMoney").val()) == "") {
        //            $("#txtExpMoney").val("0");
        //            $("#txtDiscountMoney").val("0");
        //            $("#txtExpPoint").val("0");
        //        }
    }
    else {
        $("#txtExpMoney").val("");
        $("#txtDiscountMoney").val("0");
        $("#txtExpPoint").val("0");
    }
}

//修改冲值时间
function RechargeTime() {
    if (!($("#txtRechargeTime").val()).IsNumber()) {
        $("#txtRechargeTime").val("0");
    }
    var rechargetime = parseInt($("#txtRechargeTime").val());
    var money = 0;
    var RulesInterval = myProjectdata.rulesinterval;
    var RulesUnitPrice = myProjectdata.rulesunitprice;
    var RulesExceedTime = myProjectdata.rulesexceedtime;
    var Expencount = parseInt(rechargetime / RulesInterval);
    var SurplusTime = rechargetime % RulesInterval;
    if (SurplusTime >= RulesExceedTime) {
        Expencount += 1;
    }
    money = parseFloat(Expencount * RulesUnitPrice).toFixed(2);
    $("#txtExpMoney").val(money);
    $("#txtDiscountMoney").val(money);
}
/*************************************************************************
*只输入折后金额得到积分
*************************************************************************/
function DiscountPoint() {
    var dclDiscount = $("#txtDiscountMoney").val();
    if (dclDiscount.IsDecimal()) {
        //        if (!$("#chkNoMember").attr("checked")) {
        //            var pointPercent = (global_mem.LevelPointPercent != 0 || global_mem.LevelPointPercent != undefined) ? global_mem.LevelPointPercent : 0;
        //            var levelPercent = (global_mem.LevelDiscountPercent != 0) ? global_mem.LevelDiscountPercent : 0;
        //            if (pointPercent != 0) {
        //                $("#txtExpPoint").val(Math.floor(accMul(parseFloat($("#txtDiscountMoney").val()), pointPercent)));
        //            }
        //            if (levelPercent != 0) {
        //                $('#txtExpMoney').val(parseFloat(accDiv($('#txtDiscountMoney').val(), levelPercent)).toFixed(2));
        //            }
        //            if ($.trim($("#txtDiscountMoney").val()) == "") {
        //                $("#txtExpPoint").val("0");
        //            }
        //        }
    }
    else {
        $("#txtExpMoney").val("");
        $("#txtDiscountMoney").val("0");
        $("#txtExpPoint").val("0");
    }
}

function ExpPoint() {
    var point = $("#txtExpPoint").val();
    if (!point.IsNumber()) {
        $("#txtExpPoint").val("0");
    }
}

/*************************************************************************
*保存按钮响应函数
*************************************************************************/
function btnExpSave() {
    chkNoMember = $("#chkNoMember").attr("checked");
    var chkAllowPwd = $("#chkAllowPwd").attr("checked");
    var strOrderAccount = $.trim($("#lblOrderAccount").html());
    var strExpMoney = $.trim($("#txtExpMoney").val()).ToFloat().toFixed(2);
    var strDiscountMoney = $.trim($("#txtDiscountMoney").val()).ToFloat().toFixed(2);
    var strRechargeTime = $("#txtRechargeTime").val();
    var ProjectID = $("#txtProjectID").val();
    var strErrorMsg = "";
    if ($.isEmptyObject(global_mem) && (chkNoMember == false)) {
        strErrorMsg += "<li>请先选择会员！</li>";
    }
    if (ProjectID == "") {
        strErrorMsg += "<li>请先选择计时服务！</li>";
    }
    if (strRechargeTime == "") {
        strErrorMsg += "<li>请输入充值时间！</li>";
    }
    else {
        if (!strRechargeTime.IsNumber()) {
            strErrorMsg += "<li>输入的充值时间格式错误！</li>";
        }
    }
    if (!strExpMoney.IsDecimal()) {
        strErrorMsg += "<li>输入金额格式不正确,请重新输入!</li>";
    }

    if ((strExpMoney == '' || strExpMoney <= 0)
             || (strDiscountMoney == '' || strDiscountMoney <= 0)) {
        strErrorMsg += "<li>请必须输入‘消费金额(原商品金额)’ 和 ‘折后金额(实际付款金额)’</li>";
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
    ShowPay("Expense", global_mem.memmoney, strDiscountMoney, strOrderAccount, chkAllowPwd);
}

/*************************************************************************
*保存消费数据响应函数
*************************************************************************/
function ExpenseOK(parameter) {

	
    //获取打印的份数
    var PointNum = $("#PointNum").val();

    
    $.ajax({
        type:'POST',
        url:project_name+'MemExpense/MemStorageTiming.do',
        dataType:"json",      
        contentType:"application/json",   
        data:JSON.stringify({
                   "storagetimingprojectid": $("#txtProjectID").val(),
                   "storageresiduetime": $("#txtRechargeTime").val(),
                   "storagetimingmemid": global_mem.memid,
                   "storagetimingtotalmoney": $.trim($("#txtExpMoney").val()),
                   "detail": parameter,
                   "storagetimingpoint": $.trim($("#txtExpPoint").val()),
                   "storagetimingaccount": $.trim($("#lblOrderAccount").html()),
                   "storagetimingremark": $("#txtExpRemark").val(),
                   //"sendSMS": $("#chkSMS").attr("checked"),
                   "countdiscountmoney": $.trim($("#txtDiscountMoney").val())
               }),
               success:function(json){
                   switch (json) {
                       case 0:
                           art.dialog
                                 ({
                                     title: '系统提示',
                                     time: 4,
                                     content: ("系统异常，未保存数据，请再次点击结算！"),
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
                                  content: ("充时成功！短信余额不足，不能发送短信，请充值短信！"),
                                  close: function () {
                                      Print_MemStorageExpense($("#lblOrderUSer").html(), global_mem, $("#chkPrint").attr("checked"), $("#txtRechargeTime").val(), PointNum);
                                  },
                                  lock: true
                              });
                           break;
                       default:
                           art.dialog
                                ({
                                    title: '系统提示',
                                    time: 2,
                                    content: '充时成功！' + (json.strupdatememlevel == undefined ? "" : json.strUpdateMemLevel),
                                    close: function () {
                                        Print_MemStorageExpense($("#lblOrderUSer").html(), global_mem, $("#chkPrint").attr("checked"), $("#txtRechargeTime").val(), PointNum);
                                    },
                                    lock: true
                                });
                           break;
                   }
               }});
}

/*******************************************************************************
*重置按钮响应函数
*******************************************************************************/
function BtnExpenseReset() {
    window.location.href = 'MemStorageExpense.aspx?PID=113';
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
    $("#txtProjectName").val("");
    $("#lbProjectDescription").html("");
    $("#txtProjectID").val("");    
    $("#txtExpMoney").val("").attr("disabled", "disabled");
    $("#txtDiscountMoney").val("").attr("disabled", "disabled");
    $("#txtExpPoint").val("").attr("disabled", "disabled");
    $("#txtRechargeTime").val("").attr("disabled", "disabled");
    //查找到会员后 所有控件解禁
    return true;
}

function notforbidden() {
    if (!$.isEmptyObject(global_mem) && $("#txtProjectID").val() != "") {
        $("#txtExpMoney").attr("disabled", "");
        $("#txtDiscountMoney").attr("disabled", "");
        $("#txtExpPoint").attr("disabled", "");
        $("#txtExpMoney").val("");
        $("#txtDiscountMoney").val("");
        $("#txtExpPoint").val("0");
        $("#txtRechargeTime").attr("disabled", "");
        $("#txtExpRemark").attr("disabled", "");
        $("#txtRechargeTime").focus();
    }
}

/****************************************************************************************************
*点散客选择框执行回调函数
*****************************************************************************************************/
function NoMember_CallBack(type) {
    $("#txtExpMoney").attr("disabled", "");
    $("#txtDiscountMoney").attr("disabled", "");
    $("#txtExpPoint").attr("disabled", "disabled");
    $("#txtExpRemark").attr("disabled", "");
    $("#txtExpMoney").focus();
    $("#txtExpMoney").val("");
    $("#txtDiscountMoney").val("");
    $("#txtExpPoint").val("0");
    if (type == 0) {
        $("#txtExpRemark").val("");
    }
    $("#txtRechargeTime").focus();
}