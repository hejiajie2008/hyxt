<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<script>
	$('#zydp').combogrid({
                panelWidth:500,
                url: '/pp/manager/queryStoresPage.do',
                
                idField:'id',
                textField:'name',
                mode:'remote',
                fitColumns:true,
                pagination : true,//是否分页  
                columns:[[
                    {field:'id',title:'ID',width:120,align:'center'},
					{field:'name',title:'名称',width:120,align:'center'},
					{field:'address',title:'地址',width:200,align:'center'},
                ]]
            });
</script>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'">
		<form id="rbac-maps-new-form" method="post" action="#">
			<div class="easyui-tabs" data-options="border:false">
				<div title="基本信息" style="padding:10px">
					<table width="100%">
						<tr>
							<td width="100">地图显示名称</td>
							<td><input name="name" class="easyui-validatebox" data-options="required:true"/></td>
						</tr>
						<tr>
							<td>图片地址</td>
							<td>
								<input name="jfphoto" class="easyui-validatebox" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td>地址</td>
							<td>
								<input name="street"  class="easyui-validatebox" data-options="required:true" style="width:100%"/>
							</td>
						</tr>
						<tr>
							<td>经纬度</td>
							<td>
								(<input name="lat"  class="easyui-validatebox" data-options="required:true" style="width:30%"/>,
								<input name="lng"  class="easyui-validatebox" data-options="required:true" style="width:30%"/>)
							</td>
						</tr>
						
						<tr>
							<td>所属店铺</td>
							<td>
							
							<input  id="zydp" name="sid" style="width:150px"></input>
								
							</td>
						</tr>
					</table>
				</div>
				</div>
			</form>
		</div>
	<div data-options="region:'south',border:false" style="text-align: right; padding: 5px 0 0;">
		<a id="rbac-maps-new-ok-button" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)">确定</a>
		<a id="rbac-maps-new-cancel-button" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)">取消</a>
	</div>
</body>
</html>
