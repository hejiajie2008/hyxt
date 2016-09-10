<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'">
		<form id="rbac-news-new-form" method="post" action="#">
			<div class="easyui-tabs" data-options="border:false">
				<div title="基本信息" style="padding:10px">
					<table width="100%">
						<tr>
							<td >标题</td>
							<td><input name="title" class="easyui-validatebox" data-options="required:true"/></td>
						</tr>
						<tr>
							<td>来源</td>
							<td>
								<input name="src"  class="easyui-validatebox" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td>类型</td>
							<td>
								<select name="type" class="easyui-combobox" data-options="required:true" style="width:100%">
									<option value=1>集团新闻</option>
									<option value=2>分公司动态新闻</option>
									<option value=3>员工风采</option>
									<option value=4>媒体报道</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td style="width:50px"> 内容</td>
							<td>
								<script id="new_container" name="content" type="text/plain">
								</script>	
								    
								     
								    
							</td>
						</tr>
						
					</table>
				</div>
				</div>
			</form>
		</div>
	<div data-options="region:'south',border:false" style="text-align: right; padding: 5px 0 0;">
		<a id="rbac-news-new-ok-button" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)">确定</a>
		<a id="rbac-news-new-cancel-button" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)">取消</a>
	</div>
</body>
</html>
