<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理后台</title>
	
	
	<link rel="stylesheet" type="text/css" href="${ctx}/script/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/script/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/script/easyui/themes/color.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/script/easyui/demo.css">
	<link href="${ctx}/script/dt/mapsed.css" rel="stylesheet">
	<link href="${ctx}/script/dt/dt.css" rel="stylesheet">
	
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Fugaz+One' rel='stylesheet' type='text/css'>
	<script src="http://maps.google.cn/maps/api/js?libraries=places&sensor=false"></script>
	
	
	<script type="text/javascript" src="${ctx}/script/easyui/jquery.min.js"></script>
	
	<script type="text/javascript" src="${ctx}/script/easyui/locale/easyui-lang-zh_CN.js"></script>   
	<script type="text/javascript" src="${ctx}/script/easyui/jquery.easyui.min.js"></script>
	
	
	<!-- 配置文件 -->
	<script type="text/javascript" src="${ctx}/script/ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="${ctx}/script/ueditor/ueditor.all.js"></script>
	
	<script type="text/javascript" src="${ctx}/script/js/date.js"></script>
	


<script type="text/javascript">

    

	$(function() {
	
		
	
	
		$.fn.calendar.defaults.firstDay = 1; // set the day Monday as the first day in a datebox
		$.fn.datagrid.defaults.loadFilter = function(data) {
			if (typeof(data.total) == 'undefined') {
				$.messager.alert('错误提示',data.message,'error');
				return {total:0,rows:[]};
			}
			return data;
		};
		$.fn.datagrid.defaults.onLoadError = function() {
			$.messager.alert('错误提示','请确认您访问的地址是否正确，并且是否拥有访问的权限!','error');
		};
		
		
		
		$('#captcha-image').click(function() {
			reloadCaptcha();
			$('#captcha').select();
		});
		
	});
	function getRandomTime(){
			return new Date().getTime();
		}
	
	function open1(title,url){
		
		if ($('#tt').tabs('exists',title)){
			$('#tt').tabs('select', title);
		} else {
			$('#tt').tabs('add',{
				title:title,
				href:url,
				closable:true
			});
		}
	}
	
	
	function clearLoginForm() {
		
	}
	function logout(reload) {
		location.href="logout";
		
	}
</script>

<!-- The template to display files available for upload -->
</head>
<body class="easyui-layout" style="text-align: left">


 <div data-options="region:'north'"  style="text-align: center">
		<div id="header-inner">
			<table cellpadding="0" cellspacing="0" style="width: 100%;">
				<tr>
					<td rowspan="2" style="width: 20px;"></td>
					<td style="height: 52px;">
						<div style="font-size: 22px; font-weight: bold;">
							管理后台
						</div>
					</td>
					<td style="padding-right: 5px; text-align: right; vertical-align: bottom;">
						<div id="topmenu">
							<a href="#" class="easyui-menubutton" data-options="menu:'#mm1',iconCls:'icon-edit'">系统登录</a>  
        					<div id="mm1" style="width:150px;">
        						<div>个人信息</div>
        						<div class="menu-sep"></div>
        						<div onclick="logout()">重新登录</div>
        						<div onclick="logout(true)">退出系统</div>
        					</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div data-options="region:'west',split:true"  title="功能菜单" style="width: 250px; padding: 5px;">
		<div id="left" class="easyui-panel"  fit="true" border="false">
			<ul class="easyui-tree">
			
				<li iconCls="icon-base">
					<span>权限管理</span>
					<ul>
					<#list permissionMenu as menu>
					
						<li iconCls="icon-gears"><a href="#" onclick="open1('${menu.description}','${ctx}${menu.permission}')">${menu.description}</a></li>
					</#list>
					
							
					</ul>
				</li>
	
				<li iconCls="icon-base">
					<span>主页功能修改</span>
					<ul>
							<li iconCls="icon-gears"><a href="#" onclick="open1('地图信息列表','${ctx}/manager/maps_list.do')">地图信息列表</a></li>
							<li iconCls="icon-gears"><a href="#" onclick="open1('门店信息列表','${ctx}/manager/stores_list.do')">门店信息列表</a></li>
							<li iconCls="icon-gears"><a href="#" onclick="open1('新闻信息列表','${ctx}/manager/news_list.do')">新闻信息列表</a></li>
							<li iconCls="icon-gears"><a href="#" onclick="open1('图片信息列表','${ctx}/manager/images_list.do')">图片信息列表</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	
	<div data-options="region:'center'"  border="false">
		<div id="tt" class="easyui-tabs" fit="true" border="false">
			
		</div>
		
	</div>
	
</body>
</html>
