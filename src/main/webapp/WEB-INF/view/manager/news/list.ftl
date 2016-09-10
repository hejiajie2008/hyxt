<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>用户列表</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
	
		
		
		$('#rbac-news-dg').datagrid({
			url:'${ctx}/manager/queryNewsPage.do',
			fit:true,
			pagination:true,
			striped:true,
			pageSize:10,
			loadMsg:"正在拼命加载数据",
			toolbar:[
		    {text: '新增', iconCls: 'icon-add', handler: newnews},
		    {text: '编辑', iconCls: 'icon-edit', handler: editnews},
		    {text: '删除', iconCls: 'icon-remove', handler: deletenews},
			'-',
			{text: '帮助', iconCls: 'icon-help'}
		    ],
			columns:[[
				{field:'ck',checkbox:true},
				{field:'id',title:'ID',width:50,align:'center'},
				{field:'title',title:'标题',width:400,align:'center'},
				{field:'hitCount',title:'点击次数',width:40,align:'center'},
				{field:'src',title:'来源',width:100,align:'center'},
				{field:'type',title:'类型',width:60,align:'center',formatter:lockedFormat},
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
			var rows = $('#rbac-news-dg').datagrid('getSelections');
			if (rows.length == 1) {
				$('#rbac-news-role-dlg').dialog({
					title: '分配角色',
					href: '${ctx}/manager/news_editRole.do',
					onLoad:function() {
						$('#rbac-news-editRole-form').form('load', rows[0]);
	            				$('#rbac-news-editRole-save-button').click(correlationRoles);
					}
				});
				$('#rbac-news-role-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function correlationRoles(){
			var role = $('#rbac-news-role-dg').datagrid('getSelections');
			var news = $('#rbac-news-dg').datagrid('getSelections');
			var roleIds = new Array();
			for (var i = 0; i < role.length; i++) {
				roleIds[i] = role[i].id;
			}
			$.post('${ctx}/manager/news_correlationRoles.do', {newsId:news[0].id,roleIds:roleIds.join(',')}, function(result){
				
				if (!result.success) {
					$.messager.show({title: '错误提示',msg: result.message});
				} else {
				
					$.messager.show({title: '成功',msg: "保存成功!"});
					$('#rbac-news-role-dlg').dialog('close'); // close the dialog
				}
			});
		}

		function newnews() {
			$('#rbac-news-dlg').dialog({
				title: '创建用户',
				href: '${ctx}/manager/news_new.do',
				onLoad: function() {
					UE.delEditor('new_container');
					var ue = UE.getEditor('new_container',{
					autoHeight: true
					});
					$('#rbac-news-new-ok-button').click(savenews);
					$('#rbac-news-new-cancel-button').click(closeDialog);
				}
			});
		 	$('#rbac-news-dlg').dialog('open');
		}
		
		
		function editnews() {
			var rows = $('#rbac-news-dg').datagrid('getSelections');
			if (rows.length == 1) {
			
				UE.delEditor('edit_container');
				
				$('#rbac-news-dlg').dialog({
					title: '编辑用户',
					href: '${ctx}/manager/news_edit.do',
					onLoad:function() {
					
				
					
						var rowdata=rows[0];
					
						$('#rbac-news-edit-form').form('load', rowdata);
	            				$('#rbac-news-edit-ok-button').click(updatenews);
						$('#rbac-news-edit-cancel-button').click(closeDialog);
						
						
						var ue = UE.getEditor('edit_container');
					
						ue.ready(function() {
						    //设置编辑器的内容
						    ue.setContent(rowdata.content);
						   
						});
					}
				});
				$('#rbac-news-dlg').dialog('open');
			} else if (rows.length == 0) {
				$.messager.show({title: '操作提示',msg: '请选择需要操作的数据'});
			} else {
				$.messager.show({title: '操作提示',msg: '只能选择一行数据'});
			}
		}

		function savenews() {
			$('#rbac-news-new-form').form('submit', {
				url: '${ctx}/manager/news_create.do',
				success: function(result) {
				
					result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show({title: '错误提示',msg: result.message});
					} else {
						
						$('#rbac-news-dlg').dialog('close'); // close the dialog
						$('#rbac-news-dg').datagrid('reload'); // reload the news data
					}
				}
			});
		}
		
		function updatenews(){
		    $('#rbac-news-edit-form').form('submit', {
		    	url: '${ctx}/manager/news_update.do',
			success: function(result){
				result = eval('('+result+')');
				if (!result.success){
				    $.messager.show({title: '错误提示',msg: result.message});
				} else {
				    $('#rbac-news-dlg').dialog('close');      // close the dialog
				    $('#rbac-news-dg').datagrid('reload');    // reload the news data
				}
			    }
		    });
		}
		
		function deletenews() {
			var rows = $('#rbac-news-dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('删除用户', '您要删除所选用户吗?', function(r){  
					if (r){
						var newsIds = new Array();
						for (var i = 0; i < rows.length; i++) {
							newsIds[i] = rows[i].id;
						}
						$.ajax({
							type: "post",
							url: "${ctx}/manager/news_delete.do",
							data: {newsIds:newsIds.join(',')},	
							success:function (data, textStatus) {
								$('#rbac-news-dg').datagrid('reload');
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
			$('#rbac-news-dlg').dialog('close');
			$('#rbac-news-role-dlg').dialog('close');
		}
		
		$('#rbac-news-dg-query-ok-button').click(function() {
	
			
			
			$('#rbac-news-dg').datagrid('load', $('#rbac-news-query-form').serializeObject());
			
			
		});
		
		
		$('#rbac-news-dg-query-cancel-button').click(function() {
			$('#rbac-news-query-form').form('reset');
			$('#rbac-news-dg').datagrid('load', {});
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

<form id="rbac-news-query-form"  method="post" action="#">
<table class="datagrid-toolbar" style="">
	<tr>
		<td>标题: </td><td><input name="title" class="easyui-textbox" style="width:110px"></td>
		<td>来源:</td><td> <input name="src" class="easyui-textbox" style="width:110px"></td>
		<td>类型: </td><td> <select name="type" class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="0">所有新闻</option>
				<option value="1">集团新闻</option>
				<option value="2">分公司动态</option>
				<option value="3">员工风采</option>
				<option value="4">媒体报道</option>
				</select>
			</td>
			<td>
	 	<a href="#" id="rbac-news-dg-query-ok-button" class="easyui-linkbutton" iconCls="icon-search">查询</a>
		<a href="#" id="rbac-news-dg-query-cancel-button" class="easyui-linkbutton" iconCls="icon-search">重置</a>
		</td>
	</tr>
</table>

</form>




	</div>
	<div region="center" border="false">
	    <table id="rbac-news-dg"></table>
	</div>
</div>

<div id="rbac-news-dlg" class="easyui-dialog" style="width:1000px;height:500px;padding:5px" data-options="iconCls:'icon-save',modal:true,closed:true,cache:false"></div>

</body>
</html>
