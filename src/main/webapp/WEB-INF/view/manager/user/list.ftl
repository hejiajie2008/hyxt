<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>用户列表</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
		$('#rbac-user-dg').datagrid({
			url:'${ctx}/manager/queryUserPage.do',
			queryParams: {
				_: getRandomTime
			},
			method:'get',
			fit:true,
			pagination:true,
			striped:true,
			pageSize:10,
			toolbar:[
		    {text: '新增', iconCls: 'icon-add', handler: newUser},
		    {text: '编辑', iconCls: 'icon-edit', handler: editUser},
		    {text: '删除', iconCls: 'icon-remove', handler: deleteUser},
		    {text: '分配角色', iconCls: 'icon-edit', handler: editRoles},
			'-',
			{text: '帮助', iconCls: 'icon-help'}
		    ],
			columns:[[
				{field:'ck',checkbox:true},
				{field:'id',title:'用户Id',width:120,align:'center'},
				{field:'username',title:'用户名',width:150,align:'center'},
				{field:'locked',title:'是否锁定',width:150,align:'center',formatter:lockedFormat}
			]]
		});

		function lockedFormat(val){
			return val == false?"<font color='green'>可用</font>":"<font color='red'>锁定</font>";
		}
		
		 // 分配用户角色
		function editRoles(){
			var rows = $('#rbac-user-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-user-role-dlg').dialog({
					title: '分配角色',
					href: '${ctx}/manager/user_editRole.do',
					onLoad:function() {
						$('#rbac-user-editRole-form').form('load', rows[0]);
	            				$('#rbac-user-editRole-save-button').click(correlationRoles);
					}
				});
				$('#rbac-user-role-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function correlationRoles(){
			var role = $('#rbac-user-role-dg').datagrid('getSelections');
			var user = $('#rbac-user-dg').datagrid('getSelections');
			var roleIds = new Array();
			for (var i = 0; i < role.length; i++) {
				roleIds[i] = role[i].id;
			}
			$.post('${ctx}/manager/user_correlationRoles.do', {userId:user[0].id,roleIds:roleIds.join(',')}, function(result){
				
				if (!result.success) {
					$.messager.show({title: '错误提示',msg: result.message});
				} else {
				
					$.messager.show({title: '成功',msg: "保存成功!"});
					$('#rbac-user-role-dlg').dialog('close'); // close the dialog
				}
			});
		}

		function newUser() {
			$('#rbac-user-dlg').dialog({
				title: '创建用户',
				href: '${ctx}/manager/user_new.do',
				onLoad: function() {
					$('#rbac-user-new-ok-button').click(saveUser);
					$('#rbac-user-new-cancel-button').click(closeDialog);
				}
			});
		 	$('#rbac-user-dlg').dialog('open');
		}
		
		
		function editUser() {
			var rows = $('#rbac-user-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-user-dlg').dialog({
					title: '编辑用户',
					href: '${ctx}/manager/user_edit.do',
					onLoad:function() {
						$('#rbac-user-edit-form').form('load', rows[0]);
	            				$('#rbac-user-edit-ok-button').click(updateUser);
						$('#rbac-user-edit-cancel-button').click(closeDialog);
					}
				});
				$('#rbac-user-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function saveUser() {
			$('#rbac-user-new-form').form('submit', {
				url: '${ctx}/manager/user_create.do',
				success: function(result) {
				
				
					result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show({title: '错误提示',msg: result.message});
					} else {
						$('#rbac-user-dlg').dialog('close'); // close the dialog
						$('#rbac-user-dg').datagrid('reload'); // reload the User data
					}
				}
			});
		}
		
		function updateUser(){
		    $('#rbac-user-edit-form').form('submit', {
		    	url: '${ctx}/manager/user_update.do',
			success: function(result){
				result = eval('('+result+')');
				if (!result.success){
				    $.messager.show({title: '错误提示',msg: result.message});
				} else {
				    $('#rbac-user-dlg').dialog('close');      // close the dialog
				    $('#rbac-user-dg').datagrid('reload');    // reload the User data
				}
			    }
		    });
		}
		
		function deleteUser() {
			var rows = $('#rbac-user-dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('删除用户', '您要删除所选用户吗?', function(r){  
					if (r){
						var userIds = new Array();
						for (var i = 0; i < rows.length; i++) {
							userIds[i] = rows[i].id;
						}
						$.ajax({
							type: "post",
							url: "${ctx}/manager/user_delete.do",
							data: {userIds:userIds.join(',')},	
							success:function (data, textStatus) {
								$('#rbac-user-dg').datagrid('reload');
							},
							error: function(){
								$.messager.show({title: '错误提示',msg: "操作失败！"});
							}
						});
					}  
				    });
			} else {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			}
		}
		
		function closeDialog() {
			$('#rbac-user-dlg').dialog('close');
			$('#rbac-user-role-dlg').dialog('close');
		}
		
		$('#rbac-user-dg-query-ok-button').click(function() {
			$('#rbac-user-dg').datagrid('load', $('#rbac-user-query-form').serializeObject());
		});
		
		
		$('#rbac-user-dg-query-cancel-button').click(function() {
			$('#rbac-user-query-form').form('reset');
			$('#rbac-user-dg').datagrid('load', {});
		});
	});
	
</script>
<div class="easyui-layout" data-options="fit:true">
<div region="north" border="false" class="easyui-panel" title="" style="height: 0px; padding: 5px;">
<br>
	</div>
	<div region="center" border="false">
	    <table id="rbac-user-dg"></table>
	</div>
</div>
<div id="rbac-user-dlg" class="easyui-dialog" style="width:320px;height:250px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>
<div id="rbac-user-role-dlg" class="easyui-dialog" style="width:630px;height:450px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>
</body>
</html>
