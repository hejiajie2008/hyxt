<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色列表</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
		$('#rbac-role-dg').datagrid({
			url:'${ctx}/manager/queryRolePage.do',
			queryParams: {
				_: getRandomTime
			},
			method:'get',
			fit:true,
			pagination:true,
			striped:true,
			pageSize:10,
			toolbar:[
			{text: '新增', iconCls: 'icon-add', handler: newRole},
			{text: '编辑', iconCls: 'icon-edit', handler: editRole},
			{text: '删除', iconCls: 'icon-remove', handler: deleteRole},
			{text: '分配权限', iconCls: 'icon-edit', handler: editPermission},
			'-',
			{text: '帮助', iconCls: 'icon-help'}
		    ],
			columns:[[
				{field:'ck',checkbox:true},
				{field:'id',title:'角色Id',width:120,align:'center'},
				{field:'role',title:'角色标识',width:150,align:'center'},
				{field:'description',title:'角色描述',width:150,align:'center'},
				{field:'available',title:'是否可用',width:150,align:'center',formatter:availableFormat}
			]]
		});
		 
		var url;

		function availableFormat(val){
			return val == true?"<font color='green'>可用</font>":"<font color='red'>不可用</font>";
		}

		 // 分配角色权限
		function editPermission(){
			var rows = $('#rbac-role-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-role-permission-dlg').dialog({
					title: '分配权限',
					href: '${ctx}/manager/role_editPermission.do',
					onLoad:function() {
						$('#rbac-role-editPermission-form').form('load', rows[0]);
	            				$('#rbac-role-editPermission-save-button').click(correlationPermissions);
					}
				});
				$('#rbac-role-permission-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function correlationPermissions(){
			var permission = $('#rbac-role-permission-dg').datagrid('getSelections');
			var role = $('#rbac-role-dg').datagrid('getSelections');
			var permissionIds = new Array();
			for (var i = 0; i < permission.length; i++) {
				permissionIds[i] = permission[i].id;
			}
			$.post('${ctx}/manager/role_correlationPermissions.do', {roleId:role[0].id,permissionIds:permissionIds.join(',')}, function(result){
				
				
				if (!result.success) {
					$.messager.show({title: '错误提示',msg: result.message});
				} else {
					$('#rbac-role-permission-dlg').dialog('close'); // close the dialog
				}
			});
		}
		 
		function newRole() {
			$('#rbac-role-dlg').dialog({
				title: '创建角色',
				href: '${ctx}/manager/role_new.do',
				onLoad: function() {
					$('#rbac-role-new-ok-button').click(saveRole);
					$('#rbac-role-new-cancel-button').click(closeDialog);
				}
			});
		 	$('#rbac-role-dlg').dialog('open');
		}
		
		
		function editRole() {
			var rows = $('#rbac-role-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-role-dlg').dialog({
					title: '编辑角色',
					href: '${ctx}/manager/role_edit.do',
					onLoad:function() {
						$('#rbac-role-edit-form').form('load', rows[0]);
	            				$('#rbac-role-edit-ok-button').click(updateRole);
						$('#rbac-role-edit-cancel-button').click(closeDialog);
					}
				});
				$('#rbac-role-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function saveRole() {
			$('#rbac-role-new-form').form('submit', {
				url: '${ctx}/manager/role_create.do',
				success: function(result) {
					result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show({title: '错误提示',msg: result.message});
					} else {
						$('#rbac-role-dlg').dialog('close'); // close the dialog
						$('#rbac-role-dg').datagrid('reload'); // reload the Role data
					}
				}
			});
		}
		
		function updateRole(){
		    $('#rbac-role-edit-form').form('submit', {
		    	url: '${ctx}/manager/role_update.do',
	            success: function(result){
	                result = eval('('+result+')');
	                if (!result.success){
	                    $.messager.show({title: '错误提示',msg: result.message});
	                } else {
	                    $('#rbac-role-dlg').dialog('close');      // close the dialog
	                    $('#rbac-role-dg').datagrid('reload');    // reload the Role data
	                }
	            }
		    });
		}
		
		function deleteRole() {
			var rows = $('#rbac-role-dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('删除角色', '您要删除所选角色吗?', function(r){  
					if (r){
						var roleIds = new Array();
						for (var i = 0; i < rows.length; i++) {
							roleIds[i] = rows[i].id;
						}
						$.ajax({
							type: "post",
							url: "${ctx}/manager/role_delete.do",
							data: {roleIds:roleIds.join(',')},	
							success:function (data, textStatus) {
								$('#rbac-role-dg').datagrid('reload');
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
			$('#rbac-role-dlg').dialog('close');
		}
		
		$('#rbac-role-dg-query-ok-button').click(function() {
			$('#rbac-role-dg').datagrid('load', $('#rbac-role-query-form').serializeObject());
		});
		
		
		$('#rbac-role-dg-query-cancel-button').click(function() {
			$('#rbac-role-query-form').form('reset');
			$('#rbac-role-dg').datagrid('load', {});
		});
	});
	
</script>
<div class="easyui-layout" data-options="fit:true">
<div region="north" border="false" class="easyui-panel" title="" style="height: 0px; padding: 5px;">
<br>
	</div>
	<div region="center" border="false">
	    <table id="rbac-role-dg"></table>
	</div>
</div>
<div id="rbac-role-dlg" class="easyui-dialog" style="width:320px;height:250px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>
<div id="rbac-role-permission-dlg" class="easyui-dialog" style="width:630px;height:450px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>
</body>
</html>
