<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" />
    
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/SystemManage/GroupAuthority.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmGroupAuthority" method="post" action="AuthoritySave.do">
    <input type="hidden" id="PID" value='<%=request.getParameter("PID") %>'/>
	<input type="hidden" name="parentidstr" value="${sysgroup.parentidstr }"/>
    
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title/>
                        </div>
                    </div>
                    <div class="user_List_All">
                        <div>
                            <table style="width: 100%; height: 100%;" border="1" cellpadding="0" cellspacing="0"
                                bordercolor="#434343" class="tableStyle">
                                <tr>
                                    <td class="tableStyle_left">
                                        <span style="color: #ff4800; vertical-align: middle">*</span>角色名称：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtGroupName" name="groupname" type="text" class="border_radius" style="line-height: " value="${sysgroup.groupname}" />
                                        <label for="lbltesttest" style="vertical-align: text-bottom;">
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <label id="lblIsPublic" class="lbsetCk" style="vertical-align: middle;">
                                                <input name="ispublic" id="chkIsPublic" type="checkbox" 
                                                ${sysgroup.ispublic==1?"checked='true'":""}
                                                 />所有店铺可用</label>
                                        </label>
                                        <input id="txtGroupID" type="hidden" name="groupid" value="${sysgroup.groupid}"/>
                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        <span style="color: #ff4800; vertical-align: middle">*</span>继承于：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select name="parentgroupid" id="sltParentGroup" type="input" class="selectWidth" onchange="javascript:changeParentGroupp()"
                                        ${sysgroup.groupid!=null?"disabled='disabled'":""}
                                        >
                                        	<c:forEach items="${sysgroups}" var="s" varStatus="status">
                                        		
                                        		<option value="${s.groupid }" ${s.groupid==sysgroup.parentgroupid?"selected='selected'":""}
                                        		
                                        		
                                        		>${s.groupname } </option>
                                        	</c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        <span style="color: #ff4800; vertical-align: middle">*</span>说&nbsp;&nbsp;&nbsp;&nbsp;明：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtGroupRemark" name="groupremark" type="text" class="border_radius"  value="${sysgroup.groupremark }"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="table-style table-hover user_List_txt" id="tbChick">
                            
                                
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                菜单名称
                                            </th>
                                            <th>
                                                菜单权限
                                            </th>
                                        </tr>
                                    
                               
                                        <utils:groupAuthorityTag sysgroup="${sysgroup }" listSysmoduleandaction="${listmoduleaction}"/>
                                  
                        </table>
                        <div style="text-align: center; padding-top: 8px">
                            <label style="vertical-align: text-bottom;">
                                <input id="chkAll" type="checkbox" />
                                <label style="vertical-align: middle;">
                                    全选 &nbsp;&nbsp;
                                </label>
                            </label>
                            <label style="vertical-align: text-bottom;">
                                <input id="Invert" type="checkbox" />
                                <label style="vertical-align: middle;">
                                    反选 &nbsp;&nbsp;
                                </label>
                            </label>
                            <input type="button" id="btnAuthoritySave"  value="保   存"
                                class="buttonColor" />
                            <input type="button" ID="btnAuthorityCancel" value="取   消" OnClick="btnAuthorityCancel_Click"
                                class="buttonRest" />
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <input type="hidden" id="HidGid" />
    <input type="hidden" id="HidAcction" />
    </form>
</body>
</html>
