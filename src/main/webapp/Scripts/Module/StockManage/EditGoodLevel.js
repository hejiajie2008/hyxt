$(document).ready(function () {

})

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
            lock: true,
        });

        $("#btnShareShopOK").bind("click",function(){
            dialogSelectShop.close();
        });
    }
}

//新增分类保存
function btnClassSave() {
    $("#txtClassName").focus();
    var strErrorMsg = "";
    
    if ($("#txtClassName").val() == "") {
        strErrorMsg += "类别名称不能为空;";
    }
    if ($("#sltShop").val() == "") {
        strErrorMsg += "所属店铺不能为空;";
    }
   
    $.each($("input[id^='txtDiscountPercent']"), function (i, item) {
   		var result=item.value;
        if (result.IsEmpty()) {
        	
            strErrorMsg += "<li>" + $("#levelname"+i).val() + "-必须输入等级所需积分;</li>";
        }
        else {
            if (!item.value.IsNumber() || parseInt(item.value) > 100 || parseInt(item.value) <= 0) {
                strErrorMsg += "<li>" + $("#levelname"+i).val() + "-等级折扣输入错误，必须为1-100之间的正整数</li>";
            }
        }
    });
    $.each($("input[id^='txtPointPercent']"), function (i, item) {
        if (item.value.IsEmpty()) {
            strErrorMsg += "<li>" + $("#levelname"+i).val() + "-必须输入等级折扣率;</li>";
        }
        else {
            if (!item.value.IsNumber() || parseInt(item.value) < 0) {
                strErrorMsg += "<li>" + $("#levelname"+i).val() + "-积分比率输入错误，必须为大于等于0的正整数;</li>";
            }
        }
    });
    
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
    return true;
}

function savegoodsclass(){

	if(btnClassSave()){
		$.post(project_name+"StockManager/saveGoodsLevel.do",$("#frmGoodsClass").serialize(),function(result){
			
			
			
			 switch (result) {
			 
                 case 1:
                  art.dialog
                          ({
                              title: '系统提示',
                              time: 1,
                              content: ("级别添加成功！"),
                              lock: true,
                              close:function () {
                              	location.href="/hyxt/StockManager/SetGoodsLevel.do";
                              }
                          });
                     break;
                     case 2:
                  art.dialog
                          ({
                              title: '系统提示',
                              time: 1,
                              content: ("级别修改成功！"),
                              lock: true,
                              close:function () {
                              	location.href="/hyxt/Member/memLevelList.do";
                              }
                          });
                     break;
                     
                     
                     
                 }
			
		});
	}
}