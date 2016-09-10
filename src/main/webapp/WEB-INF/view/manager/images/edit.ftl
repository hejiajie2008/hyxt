<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<script>
	$('#edit_images_zydp').combogrid({
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
		<form id="rbac-images-edit-form" method="post" action="#">
			<div class="easyui-tabs" data-options="border:false">
				<div title="基本信息" style="padding:10px">
					<table width="100%">
						<input name="id" type="hidden" class="easyui-validatebox" data-options="required:true"/>
						<tr>
							<td width="100">图片一地址</td>
							<td><input name="imageSrc" class="easyui-validatebox" data-options="required:true"/></td>
						</tr>
						<tr>
							<td>图片一描述</td>
							<td>
								<input name="imageDesc" class="easyui-validatebox" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td width="100">图片二地址</td>
							<td><input name="imageSrc2" class="easyui-validatebox" data-options="required:true"/></td>
						</tr>
						<tr>
							<td>图片二描述</td>
							<td>
								<input name="imageDesc2" class="easyui-validatebox" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td width="100">图片三地址</td>
							<td><input name="imageSrc3" class="easyui-validatebox" data-options="required:true"/></td>
						</tr>
						<tr>
							<td>图片三描述</td>
							<td>
								<input name="imageDesc3" class="easyui-validatebox" data-options="required:true"/>
							</td>
						</tr>
						
						<tr>
							<td>所属店铺</td>
							<td>
								<input  id="edit_images_zydp" name="sid" style="width:150px"></input>
							</td>
						</tr>
					</table>
				</div>
				</div>
			</form>
		</div>
	<div data-options="region:'south',border:false" style="text-align: right; padding: 5px 0 0;">
		<a id="rbac-images-edit-ok-button" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)">确定</a>
		<a id="rbac-images-edit-cancel-button" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)">取消</a>
	</div>
</body>
</html>
