﻿$(document).ready(function () {
    $("#txtShop").val($("#HDsltshop").val());
});



/****************************************************************************************************
*挂单结算
*****************************************************************************************************/
var strOrderCode;
var dclTotalDiscount;
var intOrderId;
var strMemCard;
function SubmitEmptyBills(memCard, orderId, orderAccount, totalDiscount) {
	
    var chkAllowPwd = $("#chkAllowPwd").attr("checked");
    strMemCard = memCard;
    intOrderId = orderId;
    strOrderCode = orderAccount;
    dclTotalDiscount = totalDiscount;
    doAjax("Member/",
           "GetMem.do",
           { "memcard": strMemCard },
           "json",
           function (json) {
               global_mem = json[0];
               //是否启用密码验证
               chkNoMember=(global_mem == null);  
               
               ShowPay("GoodsEmptyBills", global_mem == null ? "0.00" : global_mem.memmoney, dclTotalDiscount, strOrderCode, chkAllowPwd);
           }
    )
}

function ExpenseOK(parameter) {
	
	
	$.ajax({
        type:'POST',
        url:project_name+'StockManager/EmptyBillsSubmit.do',
        dataType:"json",      
        contentType:"application/json",   
        data:JSON.stringify(
        {
            //            "payType": payType,
            //            "cardPayMoney": cardPayMoney,
            //            "cashPayMoney": cashPayMoney,
            "detail": parameter,
            "orderId": intOrderId,
            "orderaccount": strOrderCode,
            "orderdiscountmoney": dclTotalDiscount
        }),
        success:function (json) {
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
                              time: 4,
                              content: ("短信余额不足，不能发送短信，请充值短信！"),
                              lock: true
                          });
                          break; 
                case -6:
                    art.dialog
                          ({
                              title: '系统提示',
                              time: 4,
                              content: ("店铺积分不足无法消费，请与总店联系！"),
                              lock: true
                          });
                    break;
                default:
                    art.dialog
                          ({
                              title: '系统提示',
                              time: 0.5,
                              content: '挂单消费成功！'  +(json.strUpdateMemLevel == undefined ? "" : json.strUpdateMemLevel),
                              close: function () { window.location.href = project_name+"StockManager/RptEmptyBills.do"; },
                              lock: true
                          });
                    break;
            }
        }
	});
}


var intMemID;
function CancelEmptyBills(orderID, memID) {
	
    intOrderId = orderID;
    intMemID = memID;
    art.dialog
    ({
        title: '系统提示',
        content: '您确定要撤销挂单吗？此操作不可恢复，请慎重！',
        ok: function () {
            doAjax("StockManager/",
           "DeleteEmptyBills.do",
           {
               "orderid": intOrderId,
               "ordermemid": intMemID
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
                              time: 2,
                              content: '挂单撤销成功！' + (json.strUpdateMemLevel == undefined ? "" : json.strUpdateMemLevel),
                              close: function () { window.location.href = project_name+"StockManager/RptEmptyBills.do"; }
                          });
                       break;
               }
           }
    )
        },
        cancelVal: '取消',
        cancel: true
    });


}
 