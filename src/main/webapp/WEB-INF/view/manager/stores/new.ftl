<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'">
		<form id="rbac-stores-new-form" method="post" action="#">
			<div class="easyui-tabs" data-options="border:false">
				<div title="基本信息" style="padding:10px">
					<table width="100%">
						<tr>
							<td width="100">名称</td>
							<td ><input name="name" class="easyui-validatebox" data-options="required:true" style="width:100%"/></td>
						</tr>
						
						<tr>
							<td>街道地址</td>
							<td>
								<input name="address"  class="easyui-validatebox" data-options="required:true" style="width:100%"/>
							</td>
						</tr>
						
						<tr>
							<td>图片地址</td>
							<td>
								<input name="imageURL"  class="easyui-validatebox" data-options="required:true" style="width:100%"/>
							</td>
						</tr>
						
						<tr>
							<td>电话</td>
							<td>
								<input name="phone"  class="easyui-validatebox" data-options="required:true" style="width:100%"/>
							</td>
						</tr>
						<tr>
							<td>店铺类型</td>
							<td>
								<select name="type" class="easyui-combobox" data-options="required:true" style="width:100%" panelHeight="auto">
									<option value=1>芝麻开花</option>
									<option value=2>警营厅</option>
								</select>
							</td>
						</tr>
					</table>
				</div>
				</div>
			</form>
		</div>
	<div data-options="region:'south',border:false" style="text-align: right; padding: 5px 0 0;">
		<a id="rbac-stores-new-ok-button" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)">确定</a>
		<a id="rbac-stores-new-cancel-button" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)">取消</a>
	</div>
</body>
</html>
