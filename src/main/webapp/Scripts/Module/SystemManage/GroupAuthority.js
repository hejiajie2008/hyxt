$(document).ready(function () {
    $("#chkAll").bind("click", chkAll);
    $("#Invert").bind("click", Invert);
    $("#tbChick input[type='checkbox']").bind("click",chkk);
    
    function load(){
    	var inputList = $("#tbChick input[type='checkbox']");
    	 inputList.each(function(i,item){
         	
         	if(item.checked){
         		$(this).val(1);
         	}else{
         		$(this).val(0);
         	}
         });
    }
    load();
    function chkk(){
    	if(this.checked){
    		this.value=1;
    	}else{
    		this.value=0;
    	}
    }
    $("#btnAuthoritySave").bind("click",btnAuthoritySave);
    function btnAuthoritySave(){
    	$.post(project_name+"SystemManager/AuthoritySave.do",$("#frmGroupAuthority").serialize(),function(result){
    		 switch (result) {
			 
             case 1:
              art.dialog
                      ({
                          title: '系统提示',
                          time: 1,
                          content: ("角色成功！"),
                          lock: true,
                          close:function () {
                          	location.href=project_name+"/SystemManager/GroupAuthority.do?PID="+$.getpid()+"&Gid=0";
                          }
                      });
                 break;
                 case 2:
              art.dialog
                      ({
                          title: '系统提示',
                          time: 1,
                          content: ("角色修改成功！"),
                          lock: true,
                          close:function () {
                          	location.href=project_name+"/SystemManager/GroupAuthority.do?PID="+$.getpid()+"&groupid="+$("#txtGroupID").val()+"&parentgroupid="+$("#sltParentGroup").val();
                          	
                          	
                          }
                      });
                 break;
                 
                 
                 
             }
    	});
    	
    	
    	
    	
    	
    	
    }
})


function chkAll() {
    var inputList = $("#tbChick input[type='checkbox']");
    if ($("#chkAll").attr("checked") == true) {
        inputList.attr("checked", true);
    }
    else {
        inputList.attr("checked", false);
    }
}

function Invert() {
    $("#tbChick input[type='checkbox']").each(function () {
        $(this).attr("checked", !this.checked);
    })
}

function btnGroupDel(groupName, groupID) {
    art.dialog({
        title: '系统提示',
        lock: true,
        content: '确定要删除角色【' + groupName + '】吗? 此操作不可恢复',
        ok: function () {
            this.close();
            doAjax("SystemManager/",
             'GroupDel.do', { "groupid": groupID }, "json",
                 function (json) {
                     switch (json) {
                         case 0:
                             art.dialog
                                   ({
                                       title: '系统提示',
                                       content: ("系统异常 角色未能删除，请重试！"),
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
                                       content: ("此角色已经有用户在使用,不能删除！"),
                                       lock: true
                                   });
                             break;
                         default:
                             art.dialog
                                   ({
                                       time: 1,
                                       content: '删除成功！',
                                       close: function () { 
                                    	   
                                    	   
                                    	   location.href = project_name+"SystemManager/GroupList.do?PID="+$.getpid(); }
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

function changeParentGroupp() {
    var parentGroupId = $("#sltParentGroup").val();
    window.location.href = project_name+"SystemManager/GroupAuthority.do?PID="+$.getpid()
    +"&Gid=0&parentgroupid=" + parentGroupId;
}