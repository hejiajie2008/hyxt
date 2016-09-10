$(document).ready(function () {
    $("#btnGiftClassSave").bind("click", btnGiftClassSave);
})

function GiftClassAdd(classID) {
    $("#sltGiftClass").attr('readonly', false);
    $("#sltGiftClass").attr("disabled", "");
    art.dialog({
        title: '礼品分类新增',
        content: document.getElementById('divGiftClassAddOreEdit'),
        id: 'divGiftClassAddOreEdit',
        lock: true,
        close: function () { btnCustomReset(); }
    });
    $("#txtClassName").focus();
    $("#txtClassID").val("");
    $("#txtClassName").val("");
    $("#sltGiftClass").attr('readonly', true);
    //加载礼品分类列表
    Ajaxgift();
}
//分类编辑
function GiftClassEdit(ClassID) {
    art.dialog({
        lock: true,
        title: '礼品分类编辑',
        content: document.getElementById('divGiftClassAddOreEdit'),
        id: 'divGiftClassAddOreEdit',
        close: function () { btnCustomReset(); }
    });
    $("#txtClassName").focus();
    doAjax("../",
       "GetGiftClassModel",
       {
           "ClassID": ClassID
       },
       "json",
       function (json) {
           switch (json) {
               case "0":
                   art.dialog
                          ({
                              title: '系统提示',
                              content: ("系统异常，未保存数据，请再次点击保存！"),
                              lock: true
                          });
                   break;
               case "-1":
                   art.dialog
                          ({
                              title: '系统提示',
                              content: ("未找到此分类，请刷新重试！"),
                              lock: true
                          });
                   break;
               case "-2":
                   art.dialog
                          ({
                              title: '系统提示',
                              content: ("未找到此父分类，请刷新重试！"),
                              lock: true
                          });
                   break;
               case "-3":
                   art.dialog
                          ({
                              title: '系统提示',
                              content: ("系统错误 请与系统管理员联系！"),
                              lock: true
                          });
                   break;
               default:
                   $("#sltGiftClass").val(json.ClassModel.GiftParentID);
                   $("#txtClassID").val(json.ClassModel.GiftClassID);
                   $("#txtClassName").val(json.ClassModel.GiftClassName);
                   $("#txtGiftClassRemark").val(json.ClassModel.GiftClassRemark);
                   $("#sltGiftClass").attr('readonly', true);
                   $("#sltGiftClass").attr("disabled", "disabled");
                   $("#txtParentID").val(json.ClassModel.GiftParentID);
                   break;
           }
       }
)
}
//分类删除
function GiftClassDel(ClassName, ClassID) {
    $("#txtClassName").focus();
    art.dialog({
        title: '礼品分类删除',
        lock: true,
        content: '确定要删除该分类吗? 此操作不可恢复',
        ok: function () {
            this.close();
            doAjax("../",
             'GiftClassDel', { "ClassID": ClassID }, "json",
                 function (json) {
                     switch (json) {
                         case 0:
                             art.dialog
                                   ({
                                       title: '系统提示',
                                       content: ("系统异常 分类未能删除，请重试！"),
                                       lock: true
                                   });
                             break;
                         case -3:
                             art.dialog
                                   ({
                                       title: '系统提示',
                                       content: ("系统错误 请与系统管理员联系！"),
                                       lock: true
                                   });
                             break;
                         case -2:
                             art.dialog
                                   ({
                                       title: '系统提示',
                                       content: ("此分类在礼品中存在记录,不能删除！"),
                                       lock: true
                                   });
                             break;
                         default:
                             art.dialog
                                   ({
                                       time: 1,
                                       content: '删除成功！',
                                       close: function () { location.href = "SetGiftLevel.aspx?PID=88"; }
                                   });
                             break;
                     }
                 });

            return false;
        },
        cancelVal: '取消',
        cancel: true //为true等价于function(){}
    });
    return false;
}

//新增分类保存
function btnGiftClassSave() {
    $("#txtClassName").focus();
    var strErrorMsg = "";
    if ($("#txtClassName").val() == "") {
        strErrorMsg += "类别名称不能为空;";
    }
    var type = $("#txtClassID").val() != "" && $("#txtClassID").val() != "undefined" ? "GiftClassEdit.do" : "GiftClassAdd.do";
    if (strErrorMsg != "") {
        strErrorMsg = "<div>操作出现以下错误，请核查后重试！</div><ul>" + strErrorMsg + "</ul>";
        //var throughBox = art.dialog.through;
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
        content: "将" + (type == "GiftClassAdd.do" ? "增加" : "修改") + "分类 [" + $.trim($("#txtClassName").val()) + "]。\n确定操作吗？",
        lock: true,
        ok: function () {
            this.close();
            doAjax("../PointManage/",
         type,
        {
            "giftclassid": $.trim($("#txtClassID").val()),
            "giftparentid": $.trim($("#sltGiftClass").val()),
            "giftclassname": $.trim($("#txtClassName").val()),
            "giftclassremark": $.trim($("#txtGiftClassRemark").val())
        },
        "json",
         function (json) {
             switch (json) {
                 case 0:
                     art.dialog
                          ({
                              title: '系统提示',
                              content: ("系统异常，未保存数据，请再次点击保存！"),
                              lock: true
                          });
                     break;
                 case -3:
                     art.dialog
                          ({
                              title: '系统提示',
                              content: ("系统错误 请与系统管理员联系！"),
                              lock: true
                          });
                     break;
                 case -1:
                     art.dialog
                          ({
                              title: '系统提示',
                              content: ("此类别已经在系统中存在，请重新输入，然后重试！"),
                              lock: true
                          });
                     break;
                 default:
                     art.dialog
                            ({
                                time: 0.5,
                                content: '商品分类保存成功！',
                                close: function () { location.href = "SetGiftLevel.do"; }
                            });
                     break;
             }
         });
        },
        cancelVal: '取消',
        cancel: true
    });
}

function btnCustomReset() {
    $("#txtParentID").val(0);
    $("#sltGiftClass").val("0");
    $("#txtClassName").val("");
    $("#txtClassID").val("");
    $("#txtGiftClassRemark").val("");
}
/****************分类列表******************/
function  Ajaxgift(){
$.ajax({
        url: "getGiftCategory.do",
        type: "get",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
        cache:false,
        success: function (data) {
         datas = eval(data);
         //alert(datas.regions);
         $.each(datas.gift, function (i, obj) {
         $("#sltGiftClass").html('<option value="' + obj.id + '">' + obj.name + '</option>');
         });  
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest);
            alert(textStatus);
            alert(errorThrown);
        }
    });
}