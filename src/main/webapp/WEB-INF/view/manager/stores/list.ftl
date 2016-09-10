<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>门店信息列表</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
		$('#rbac-stores-dg').datagrid({
			url:'${ctx}/manager/queryStoresPage.do',
			fit:true,
			pagination:true,
			striped:true,
			pageSize:10,
			toolbar:[
		    {text: '新增', iconCls: 'icon-add', handler: newstores},
		    {text: '编辑', iconCls: 'icon-edit', handler: editstores},
		    {text: '删除', iconCls: 'icon-remove', handler: deletestores},
			'-',
			{text: '帮助', iconCls: 'icon-help'}
		    ],
			columns:[[
				{field:'ck',checkbox:true},
				{field:'id',title:'ID',width:120,align:'center'},
				{field:'name',title:'名称',width:120,align:'center'},
				{field:'address',title:'地址',width:200,align:'center'},
				{field:'phone',title:'电话',width:200,align:'center'},
				{field:'type',title:'类型',width:150,align:'center',formatter:lockedFormat},
				{field:'creator',title:'创建人',width:50,align:'center'},
				{field:'createtm',title:'创建时间',width:100,align:'center',formatter:formatDatebox},
				{field:'updator',title:'修改人',width:50,align:'center'},
				{field:'updatetm',title:'修改时间',width:100,align:'center' ,formatter:formatDatebox}
			]]
		});
		
		

		function lockedFormat(val){
			if(val==1){
				return "<font color='green'>芝麻开花</font>";
			}else{
				return "<font color='red'>警营厅</font>";
			}
		
			return val;
		}
		
		 // 分配用户角色
		function editRoles(){
			var rows = $('#rbac-stores-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-stores-role-dlg').dialog({
					title: '分配角色',
					href: '${ctx}/manager/stores_editRole.do',
					onLoad:function() {
						$('#rbac-stores-editRole-form').form('load', rows[0]);
	            				$('#rbac-stores-editRole-save-button').click(correlationRoles);
					}
				});
				$('#rbac-stores-role-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function correlationRoles(){
			var role = $('#rbac-stores-role-dg').datagrid('getSelections');
			var stores = $('#rbac-stores-dg').datagrid('getSelections');
			var roleIds = new Array();
			for (var i = 0; i < role.length; i++) {
				roleIds[i] = role[i].id;
			}
			$.post('${ctx}/manager/stores_correlationRoles.do', {storesId:stores[0].id,roleIds:roleIds.join(',')}, function(result){
				
				if (!result.success) {
					$.messager.show({title: '错误提示',msg: result.message});
				} else {
				
					$.messager.show({title: '成功',msg: "保存成功!"});
					$('#rbac-stores-role-dlg').dialog('close'); // close the dialog
				}
			});
		}

		function newstores() {
			$('#rbac-stores-dlg').dialog({
				title: '创建用户',
				href: '${ctx}/manager/stores_new.do',
				onLoad: function() {
					$('#rbac-stores-new-ok-button').click(savestores);
					$('#rbac-stores-new-cancel-button').click(closeDialog);
				}
			});
		 	$('#rbac-stores-dlg').dialog('open');
		}
		
		
		function editstores() {
			var rows = $('#rbac-stores-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-stores-dlg').dialog({
					title: '编辑用户',
					href: '${ctx}/manager/stores_edit.do',
					onLoad:function() {
						$('#rbac-stores-edit-form').form('load', rows[0]);
	            				$('#rbac-stores-edit-ok-button').click(updatestores);
						$('#rbac-stores-edit-cancel-button').click(closeDialog);
					}
				});
				$('#rbac-stores-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function savestores() {
			$('#rbac-stores-new-form').form('submit', {
				url: '${ctx}/manager/stores_create.do',
				success: function(result) {
				
				
					result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show({title: '错误提示',msg: result.message});
					} else {
						$('#rbac-stores-dlg').dialog('close'); // close the dialog
						$('#rbac-stores-dg').datagrid('reload'); // reload the stores data
					}
				}
			});
		}
		
		function updatestores(){
		    $('#rbac-stores-edit-form').form('submit', {
		    	url: '${ctx}/manager/stores_update.do',
			success: function(result){
				result = eval('('+result+')');
				if (!result.success){
				    $.messager.show({title: '错误提示',msg: result.message});
				} else {
				    $('#rbac-stores-dlg').dialog('close');      // close the dialog
				    $('#rbac-stores-dg').datagrid('reload');    // reload the stores data
				}
			    }
		    });
		}
		
		function deletestores() {
			var rows = $('#rbac-stores-dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('删除用户', '您要删除所选用户吗?', function(r){  
					if (r){
						var storesIds = new Array();
						for (var i = 0; i < rows.length; i++) {
							storesIds[i] = rows[i].id;
						}
						$.ajax({
							type: "post",
							url: "${ctx}/manager/stores_delete.do",
							data: {storesIds:storesIds.join(',')},	
							success:function (data, textStatus) {
								$('#rbac-stores-dg').datagrid('reload');
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
			$('#rbac-stores-dlg').dialog('close');
			$('#rbac-stores-role-dlg').dialog('close');
		}
		
		$('#rbac-stores-dg-query-ok-button').click(function() {
			$('#rbac-stores-dg').datagrid('load', $('#rbac-stores-query-form').serializeObject());
		});
		
		
		$('#rbac-stores-dg-query-cancel-button').click(function() {
			$('#rbac-stores-query-form').form('reset');
			$('#rbac-stores-dg').datagrid('load', {});
		});
		
		
		
		$.fn.serializeObject = function () {
			            var a,o,h,i,e;  
			    a=this.serializeArray();  
			    o={};  
			    h=o.hasOwnProperty;  
			    for(i=0;i<a.length;i++){  
			        e=a[i];  
			        if(!h.call(o,e.name)){  
			            o[e.name]=e.value;  
			        }  
			    }  
			   
			    return o;  
        };
		
	});
	
</script>
<div class="easyui-layout" data-options="fit:true">
<div region="north" border="false" class="easyui-panel" title="" style="padding: 2px;">

<form id="rbac-stores-query-form"  method="post" action="#">
<table class="datagrid-toolbar" style="">
	<tr>
		<td>门店名称: </td><td><input name="name" class="easyui-textbox" style="width:110px"></td>
		<td>门店地址:</td><td> <input name="address" class="easyui-textbox" style="width:110px"></td>
		<td>店铺类型</td>
							<td>
								<select name="type" class="easyui-combobox" data-options="required:true" style="width:100%" panelHeight="auto">
									<option value=0>所有店铺</option>
									<option value=1>芝麻开花</option>
									<option value=2>警营厅</option>
								</select>
							</td>
		<td>
	 	<a href="#" id="rbac-stores-dg-query-ok-button" class="easyui-linkbutton" iconCls="icon-search">查询</a>
		<a href="#" id="rbac-stores-dg-query-cancel-button" class="easyui-linkbutton" iconCls="icon-search">重置</a>
		</td>
	</tr>
</table>

</form>

	</div>
	<div region="center" border="false">
	    <table id="rbac-stores-dg"></table>
	</div>
</div>
<div id="rbac-stores-dlg" class="easyui-dialog" style="width:500px;height:400px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>
<div id="rbac-stores-role-dlg" class="easyui-dialog" style="width:630px;height:450px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>
</body>
</html>
