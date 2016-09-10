// 页面加载时执行
$(document).ready(function () {
    //保存按钮响应函数
    $("#btnShopAuthority").bind("click", ShopAuthority);

    //取消按钮响应函数
    $("#btnShopReset").bind("click", ShopReset);
});

/**************************************************************
 *保存按钮响应函数,设置店铺权限
 **************************************************************/
function ShopAuthority() {
    var checkList = $("#tbChick input:checkbox");
    var list = "";
    var fydata="";
    for (var i = 1; i < checkList.length; i++) {
        if ($(checkList[i]).attr("checked")) {
            list += $(checkList[i]).val() + ",";
        }
        fydata+=$(checkList[i]).val() + ",";
    }
    doAjax("SystemManager/",
           "saveShopAuthority.do",
           { "shopid": $("#ShopID").val(), "listck": list ,
    		"fydata":fydata,
    		"data":$("#mydata").val()
    		
           },
           "json",
           function (json) {
               switch (json) {
                   case 0:
                       art.dialog.alert("系统异常，未保存数据，请再次点击保存！");
                       break;
                   case 1:
                       art.dialog
                            ({
                                time: 2,
                                content: '保存成功！',
                                close: function () { location.href = project_name+"/SystemManager/ShopList.do?PID=31"; }
                            });
                       break;
                   case 2:
                       art.dialog.alert("系统错误 请与系统管理员联系！");
                       break;
               }
           });
 }

/***********************************************************************
 *取消按钮响应函数
 ***********************************************************************/
 function ShopReset() {
     window.location.href = project_name+'/SystemManager/ShopList.do?PID=31';
 }

// /*********************************************************************
//  *全选
//  *********************************************************************/
// function SelectAll() {
//     $(".chk").each(function () {        //遍历html中class为chk的复选框标签  
//         $(this).attr("checked", true);
//     });
// }    