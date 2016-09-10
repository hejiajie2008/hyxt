<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>用户列表</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
	
		
		
		$('#rbac-images-dg').datagrid({
			url:'${ctx}/manager/queryImagesPage.do',
			fit:true,
			pagination:true,
			striped:true,
			pageSize:10,
			loadMsg:"正在拼命加载数据",
			toolbar:[
		    {text: '新增', iconCls: 'icon-add', handler: newimages},
		    {text: '编辑', iconCls: 'icon-edit', handler: editimages},
		    {text: '删除', iconCls: 'icon-remove', handler: deleteimages},
			'-',
			{text: '帮助', iconCls: 'icon-help'}
		    ],
			columns:[[
				{field:'ck',checkbox:true},
				{field:'id',title:'ID',width:50,align:'center'},
				{field:'imageSrc',title:'图片一地址',width:200,align:'center'},
				
				{field:'imageDesc',title:'图片一描述',width:100,align:'center'},
				{field:'imageSrc2',title:'图片二地址',width:200,align:'center'},
				
				{field:'imageDesc2',title:'图片二描述',width:100,align:'center'},
				{field:'imageSrc3',title:'图片三地址',width:200,align:'center'},
				
				{field:'imageDesc3',title:'图片三描述',width:100,align:'center'},
				
				{field:'storeName',title:'所属门店',width:100,align:'center'},
				{field:'creator',title:'创建人',width:50,align:'center'},
				{field:'createtm',title:'创建时间',width:100,align:'center',formatter:formatDatebox},
				{field:'updator',title:'修改人',width:50,align:'center'},
				{field:'updatetm',title:'修改时间',width:100,align:'center' ,formatter:formatDatebox}
			]]
		});

		function lockedFormat(val){
			if(val==1){
				return "<font color='green'>集团新闻</font>";
			}else if(val==2){
				return "<font color='red'>分公司动态新闻</font>";
			}else if(val==3){
				return "<font color='orange'>员工风采</font>";
			}else if(val==4){
				return "<font color='blue'>媒体报道</font>";
			}
		
			return val;
		}
		
		 // 分配用户角色
		function editRoles(){
			var rows = $('#rbac-images-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-images-role-dlg').dialog({
					title: '分配角色',
					href: '${ctx}/manager/images_editRole.do',
					onLoad:function() {
						$('#rbac-images-editRole-form').form('load', rows[0]);
	            				$('#rbac-images-editRole-save-button').click(correlationRoles);
					}
				});
				$('#rbac-images-role-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function correlationRoles(){
			var role = $('#rbac-images-role-dg').datagrid('getSelections');
			var images = $('#rbac-images-dg').datagrid('getSelections');
			var roleIds = new Array();
			for (var i = 0; i < role.length; i++) {
				roleIds[i] = role[i].id;
			}
			$.post('${ctx}/manager/images_correlationRoles.do', {imagesId:images[0].id,roleIds:roleIds.join(',')}, function(result){
				
				if (!result.success) {
					$.messager.show({title: '错误提示',msg: result.message});
				} else {
				
					$.messager.show({title: '成功',msg: "保存成功!"});
					$('#rbac-images-role-dlg').dialog('close'); // close the dialog
				}
			});
		}

		function newimages() {
			$('#rbac-images-dlg').dialog({
				title: '创建用户',
				href: '${ctx}/manager/images_new.do',
				onLoad: function() {
					
					$('#rbac-images-new-ok-button').click(saveimages);
					$('#rbac-images-new-cancel-button').click(closeDialog);
				}
			});
		 	$('#rbac-images-dlg').dialog('open');
		}
		
		
		function editimages() {
			var rows = $('#rbac-images-dg').datagrid('getSelections');
			if (rows.length == 1) {
			
				UE.delEditor('edit_container');
				
				$('#rbac-images-dlg').dialog({
					title: '编辑用户',
					href: '${ctx}/manager/images_edit.do',
					onLoad:function() {
					
				
					
						var rowdata=rows[0];
					
						$('#rbac-images-edit-form').form('load', rowdata);
	            				$('#rbac-images-edit-ok-button').click(updateimages);
						$('#rbac-images-edit-cancel-button').click(closeDialog);
						
						
						
					}
				});
				$('#rbac-images-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function saveimages() {
			$('#rbac-images-new-form').form('submit', {
				url: '${ctx}/manager/images_create.do',
				success: function(result) {
				
					result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show({title: '错误提示',msg: result.message});
					} else {
						
						$('#rbac-images-dlg').dialog('close'); // close the dialog
						$('#rbac-images-dg').datagrid('reload'); // reload the images data
					}
				}
			});
		}
		
		function updateimages(){
		
		
		    $('#rbac-images-edit-form').form('submit', {
		    	url: '${ctx}/manager/images_update.do',
			success: function(result){
				result = eval('('+result+')');
				if (!result.success){
				    $.messager.show({title: '错误提示',msg: result.message});
				} else {
				    $('#rbac-images-dlg').dialog('close');      // close the dialog
				    $('#rbac-images-dg').datagrid('reload');    // reload the images data
				}
			    }
		    });
		}
		
		function deleteimages() {
			var rows = $('#rbac-images-dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('删除用户', '您要删除所选用户吗?', function(r){  
					if (r){
						var imagesIds = new Array();
						for (var i = 0; i < rows.length; i++) {
							imagesIds[i] = rows[i].id;
						}
						$.ajax({
							type: "post",
							url: "${ctx}/manager/images_delete.do",
							data: {imagesIds:imagesIds.join(',')},	
							success:function (data, textStatus) {
								$('#rbac-images-dg').datagrid('reload');
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
			$('#rbac-images-dlg').dialog('close');
			$('#rbac-images-role-dlg').dialog('close');
		}
		
		$('#rbac-images-dg-query-ok-button').click(function() {
	
			
			
			$('#rbac-images-dg').datagrid('load', $('#rbac-images-query-form').serializeObject());
			
			
		});
		
		
		$('#rbac-images-dg-query-cancel-button').click(function() {
			$('#rbac-images-query-form').form('reset');
			$('#rbac-images-dg').datagrid('load', {});
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
<div region="north" border="false" class="easyui-panel" title="" style="padding: 2px">

<form id="rbac-images-query-form"  method="post" action="#">
<table class="datagrid-toolbar" style="">
	<tr>
		<td>门店名称: </td><td><input name="title" class="easyui-textbox" style="width:110px"></td>
		<td>店铺类型</td>
							<td>
								<select name="type" class="easyui-combobox" data-options="required:true" style="width:100%" panelHeight="auto">
									<option value=0>所有店铺</option>
									<option value=1>芝麻开花</option>
									<option value=2>警营厅</option>
								</select>
							</td>
			<td>
	 	<a href="#" id="rbac-images-dg-query-ok-button" class="easyui-linkbutton" iconCls="icon-search">查询</a>
		<a href="#" id="rbac-images-dg-query-cancel-button" class="easyui-linkbutton" iconCls="icon-search">重置</a>
		</td>
	</tr>
</table>

</form>




	</div>
	<div region="center" border="false">
	    <table id="rbac-images-dg"></table>
	</div>
</div>

<div id="rbac-images-dlg" class="easyui-dialog" style="width:1000px;height:500px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>

</body>
</html>
