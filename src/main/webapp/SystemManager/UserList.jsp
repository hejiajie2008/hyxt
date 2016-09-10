<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
<title></title>
<link href="../Inc/Style/Style.css" rel="stylesheet" />

<link href="../Inc/artDialogskins/blue.css" rel="stylesheet"
	type="text/css" />
<script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="../Scripts/jquery-common.js" type="text/javascript"></script>
<script src="../Scripts/jquery.artDialog.basic.js"
	type="text/javascript"></script>
<script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
<script src="../Scripts/Module/SystemManage/UserInfo.js"
	type="text/javascript"></script>
<script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
 <script src="../Scripts/fy.js" type="text/javascript"></script>
</head>
<body>
	<form id="page_form" action="UserList.do">
		<table style="width: 100%; height: 100%; word-wrap: break-word;"
			cellspacing="7">
			<tr>
				<td colspan="2" style="width: 100%;">
					<div class="system_Info">
						<div class="system_Top">
							<div class="user_regist_title">
								<utils:title />
							</div>
						</div>
						<div id="EditPwd" style="display: none;">
							<table class="tableStyle" cellspacing="0" cellpadding="2"
								style="width: 400px; margin: auto">
								<tr>
									<td class="tableStyle_left">新密码：</td>
									<td class="tableStyle_right"><input id="txtPwdOne"
										type="password" class="border_radius" /></td>
								</tr>
								<tr>
									<td class="tableStyle_left">确定密码：</td>
									<td class="tableStyle_right"><input id="txtPwdTwo"
										type="password" class="border_radius" /></td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: center;"><input
										type="button" id="btnSavePwd" class="buttonColor" value="确  定" />
									</td>
								</tr>
							</table>
						</div>
						<div id="UserInfo" style="display: none;">
							<table class="tableStyle" cellspacing="0" cellpadding="2"
								style="width: 700px; margin: auto">
								<tr>
									<td class="tableStyle_left"><span
										style="color: #ff4800; vertical-align: middle">*</span>用户账号：</td>
									<td class="tableStyle_right"><input id="txtUserAccount"
										type="text" class="border_radius" /></td>
									<td class="tableStyle_left"><span
										style="color: #ff4800; vertical-align: middle">*</span>用户名称：</td>
									<td class="tableStyle_right"><input id="txtUserName"
										type="text" class="border_radius" /> <input id="txtUserID" 
										type="hidden" /></td>
								</tr>
								<tr id="userInfoPwd">
									<td class="tableStyle_left"><span
										style="color: #ff4800; vertical-align: middle">*</span>登录密码：</td>
									<td class="tableStyle_right"><input type="password"
										id="txtPwd" class="border_radius" maxlength="20" /> <input
										id="txtPassword" type="hidden" /></td>
									<td class="tableStyle_left"><span
										style="color: #ff4800; vertical-align: middle">*</span>确认密码：</td>
									<td class="tableStyle_right"><input type="password"
										id="txtRepwd" class="border_radius" maxlength="20" /></td>
								</tr>
								<tr>
									<td class="tableStyle_left"><span
										style="color: #ff4800; vertical-align: middle">*</span>用户编号：</td>
									<td class="tableStyle_right"><input id="txtUserNumber"
										type="text" class="border_radius" maxlength="20" /></td>
									<td class="tableStyle_left">联系电话：</td>
									<td class="tableStyle_right"><input id="txtUserTel"
										type="text" class="border_radius" /></td>
								</tr>
								<tr>
									<td class="tableStyle_left">所属店铺：</td>
									<td class="tableStyle_right"><select id="sltShopInfo"
										name="sltShop" class="selectWidth">
										<utils:shoplist shopid=""/>
									</select> <input type="text" id="txtShopId"
										style="width: 33px; display: none" /></td>
									<td class="tableStyle_left">管理权限：</td>
									<td class="tableStyle_right"><select id="sltGroupID"
										name="sltGroupID" class="selectWidth">
										
									</select><input type="text" id="txtGroupID"
										style="width: 33px; display: none" /> <input type="text"
										id="txtEditGroupID" style="width: 33px; display: none" /></td>
								</tr>
								<tr>
									<td class="tableStyle_left">是否锁定：</td>
									<td colspan="3" class="tableStyle_right"><label
										style="vertical-align: text-bottom;"> <input
											type="radio" name="radChooseYesOrNo" id="radChooseYes"
											value="1" /> <label style="vertical-align: middle;">
												暂时锁定</label></label> <label style="vertical-align: text-bottom;"> <input
											type="radio" name="radChooseYesOrNo" id="radChooseNo"
											value="0" /> <label style="vertical-align: middle;">
												不锁定<font color="red">&nbsp;&nbsp;&nbsp;(锁定则该员工不能登录)</font>
										</label></label></td>
								</tr>
								<tr>
									<td class="tableStyle_left">备注：</td>
									<td class="tableStyle_right" colspan="3"><textarea
											id="txtUserRemark" rows="3"
											style="width: 520px; word-wrap: break-word; outline: none; resize: none;"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="4" class="tableStyle_right">
										<div class="buton" style="text-align: center;">
											<input type="button" id="btnUserSave" class="buttonColor"
												value="保   存" /> &nbsp <input type="button"
												id="btnUserReset" class="buttonRest" value="重   置" /> <input
												id="UserAddOrEdit" type="hidden" />
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="user_List_All">
							<div class="user_List_top" style="height: 34px;">
								<table width="100%" border="1" cellpadding="0" cellspacing="0"
									bordercolor="#434343" class="tableStyle">
									<tr style="color: #333333; background-color: #F7F6F3;">
										<td class="user_List_styleLeft">快捷操作：</td>
										<td class="user_List_styleRight">
											<div class="user_List_Button">
												<input id="btnSysUserAdd" type="button" value="新增用户"
													class="common_Button" onclick="UserAdd()" visible="false" />
											</div>
										</td>
									</tr>
								</table>
							</div>
							<table width="100%" border="1" cellpadding="0" cellspacing="0"
								bordercolor="#434343" class="tableStyle">
								<tr>
									<td class="tableStyle_left">所属店铺：</td>
									<td class="tableStyle_right"><select name="usershopid" id="sltShop"
										class="selectWidth">
										<utils:shoplist shopid="${sysuserFormBean.usershopid}"/>
									</select></td>
									<td class="tableStyle_left">所属权限组：</td>
									<td class="tableStyle_right"><select id="sltUserGroupID" name="usergroupid"
										class="selectWidth">
										<c:forEach items="${sysgroupList}" var="s"
									varStatus="status">
											
											<option value="${s.groupid }"
											<c:if test="${sysuserFormBean.usergroupid==s.groupid}">
											selected="selected"
											</c:if>
											>${s.groupname }</option>
										
										</c:forEach>
									</select></td>
									<td class="tableStyle_right">
										<div class="user_List_Button">
											<input type="button" id="btnUserSearch" value="查   询"
												class="common_Button"  />
										</div>
									</td>
								</tr>
							</table>
							<table class="table-style table-hover user_List_txt">


								<thead class="thead">
									<tr class="th">
										<th>序号</th>
										<th>用户账号</th>
										<th>用户名称</th>
										<th>用户编号</th>
										<th>联系方式</th>
										<th>所属店铺</th>
										<th>所属权限组</th>
										<th>是否锁定</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								<c:forEach items="${sysuserFormBean.rows}" var="s"
									varStatus="status">
									<tr class="td">
										<td>${status.index+1}</td>
										<td>${s.useraccount}</td>
										<td style="text-align: left">${s.username}</td>
										<td>${s.usernumber}</td>
										<td>${s.usertelephone}</td>
										<td>${s.shopname}</td>
										<td>${s.groupname}</td>
										<td>${s.userlock==0?"否":"是"}</td>
										<td style="text-align: left;">${s.userremark}</td>
										<td class="listtd" style="width: 90px;"><a href="#"
											onclick="UserEdit('${s.username}','${s.userid}')"
											id="hyUserEdit" visible="false"> <img
												src="../images/Gift/eit.png" title="编辑" alt="编辑" />
										</a><a href="#"
											onclick="UserEditPwd('${s.username}','${s.userid}');"
											id="hyEditPwd" visible="false"> <img
												src="../images/Gift/password.png" alt="修改密码" title="修改密码" />
										</a><a href="#" id="hyUserDel" width="30px" visible="false"
											onclick="return UserDel('${s.username}','${s.userid}')">
												<img src="../images/Gift/del.png" title="删除" alt="删除" />
										</a></td>
									</tr>
								</c:forEach>

							</table>
							<div class="user_List_page">
								<table style="width: 100%" id="tabPager">
									<tr>
										<td>
										<page:page pageIndex="${sysuserFormBean.page}" pageCount="${sysuserFormBean.pages}"
                                          rowCount="${sysuserFormBean.total}" 
                           					 pageSize="${sysuserFormBean.pageSize}" 
                           					  path="ExpenseHistory.do" param="PID=100"/>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
    <jsp:include page="../Controls/QuickSearch.jsp"/>

	</form>
</body>
</html>
