<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限列表</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
		$('#rbac-permission-dg').datagrid({
			url:'${ctx}/manager/queryPermissionPage.do',
			queryParams: {
				_: getRandomTime
			},
			method:'get',
			fit:true,
			pagination:true,
			striped:true,
			pageSize:10,
			toolbar:[
			{text: '新增', iconCls: 'icon-add', handler: newPermission},
			{text: '编辑', iconCls: 'icon-edit', handler: editPermission},
			{text: '删除', iconCls: 'icon-remove', handler: deletePermission},
			'-',
			{text: '帮助', iconCls: 'icon-help'}
		    ],
			columns:[[
				{field:'ck',checkbox:true},
				{field:'id',title:'权限Id',width:120,align:'center'},
				{field:'permission',title:'权限标识',width:150,align:'center'},
				{field:'description',title:'权限描述',width:150,align:'center'},
				{field:'srcType',title:'资源类型',width:150,align:'center',formatter:srcTypeFormat},
				{field:'available',title:'是否可用',width:150,align:'center',formatter:availableFormat}
			]]
		});
		 
		var url;

		function availableFormat(val){
			return val == true?"<font color='green'>可用</font>":"<font color='red'>不可用</font>";
		}
		
		function srcTypeFormat(val){
			return val == 0?"<font color='green'>菜单</font>":"<font color='red'>功能</font>";
		}
		 
		function newPermission() {
			$('#rbac-permission-dlg').dialog({
				title: '创建权限',
				href: '${ctx}/manager/permission_new.do',
				onLoad: function() {
					$('#rbac-permission-new-ok-button').click(savePermission);
					$('#rbac-permission-new-cancel-button').click(closeDialog);
				}
			});
		 	$('#rbac-permission-dlg').dialog('open');
		}
		
		
		function editPermission() {
			var rows = $('#rbac-permission-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-permission-dlg').dialog({
					title: '编辑权限',
					href: '${ctx}/manager/permission_edit.do',
					onLoad:function() {
						$('#rbac-permission-edit-form').form('load', rows[0]);
	            				$('#rbac-permission-edit-ok-button').click(updatePermission);
						$('#rbac-permission-edit-cancel-button').click(closeDialog);
					}
				});
				$('#rbac-permission-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function savePermission() {
			$('#rbac-permission-new-form').form('submit', {
				url: '${ctx}/manager/permission_create.do',
				success: function(result) {
					result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show({title: '错误提示',msg: result.message});
					} else {
						$('#rbac-permission-dlg').dialog('close'); // close the dialog
						$('#rbac-permission-dg').datagrid('reload'); // reload the Permission data
					}
				}
			});
		}
		
		function updatePermission(){
		    $('#rbac-permission-edit-form').form('submit', {
			url: '${ctx}/manager/permission_update.do',
			success: function(result){
				result = eval('('+result+')');
				if (!result.success){
				    $.messager.show({title: '错误提示',msg: result.message});
				} else {
				    $('#rbac-permission-dlg').dialog('close');      // close the dialog
				    $('#rbac-permission-dg').datagrid('reload');    // reload the Permission data
				}
			    }
		    });
		}
		
		function deletePermission() {
			var rows = $('#rbac-permission-dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('删除权限', '您要删除所选权限吗?', function(r){  
					if (r){
						var permissionIds = new Array();
						for (var i = 0; i < rows.length; i++) {
							permissionIds[i] = rows[i].id;
						}
						$.ajax({
							type: "post",
							url: "${ctx}/manager/permission_delete.do",
							data: {permissionIds:permissionIds.join(',')},	
							cache:false,
							success:function (data, textStatus) {
								$('#rbac-permission-dg').datagrid('reload');
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
			$('#rbac-permission-dlg').dialog('close');
		}
		
		$('#rbac-permission-dg-query-ok-button').click(function() {
			$('#rbac-permission-dg').datagrid('load', $('#rbac-permission-query-form').serializeObject());
		});
		
		
		$('#rbac-permission-dg-query-cancel-button').click(function() {
			$('#rbac-permission-query-form').form('reset');
			$('#rbac-permission-dg').datagrid('load', {});
		});
	});
	
</script>
<div class="easyui-layout" data-options="fit:true">
<div region="north" border="false" class="easyui-panel" title="" style="height: 0px; padding: 5px;">
<br>
	</div>
	<div region="center" border="false">
	    <table id="rbac-permission-dg"></table>
	</div>
</div>
<div id="rbac-permission-dlg" class="easyui-dialog" style="width:320px;height:300px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>
</body>
</html>
