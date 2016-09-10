<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
<title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/PointManage/PointChange.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Print.js" type="text/javascript"></script>


</head>
<body>
    <form id="frmPointChange" >
    <div class="system_Info box_right">

    <%--打印份数--%>
        <input type="hidden" value="" id="PointNum" />

        <div class="system_Top">
            <div class="user_regist_title">
               <utils:title/>
            </div>
        </div>
        <div>
            <jsp:include page="../Controls/MemberSearch.jsp"/>
        </div>
        <div class="user_regist_Allleft">
            <div class="user_regist_left">
                <div class="user_regist_infor" style="text-align: left">
                    积分变动
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_left">
                            变动单号：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblPointChange"  style="font-size: 14px; font-weight: bold;">
                            <utils:order type="4"/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            变动日期：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblPointChangeTime"  style="font-size: 14px; font-weight: bold;">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            操作人员：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblPointChangeUser"  style="font-size: 14px; font-weight: bold;
                                margin-left: 5px">
                                <shiro:principal />
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            积分数量：
                        </td>
                        <td class="tableStyle_right">
                            <span id="SpanCurrentPoint" style="font-size: 14px; font-weight: bold; color: Red;
                                margin-left: 5px"></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            操作类型：
                        </td>
                        <td class="tableStyle_right">
                            <label style="vertical-align: text-bottom;">
                                <input type="radio" name="radPointType" value="0" checked="checked" />
                                <label style="vertical-align: middle;">
                                    增加积分
                                </label>
                            </label>
                            &nbsp;&nbsp;
                            <label style="vertical-align: text-bottom;">
                                <input type="radio" name="radPointType" value="1" />
                                <label style="vertical-align: middle;">
                                    扣除积分
                                </label>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            变动数量：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtChangeNumber" type="text"  class="border_radius" maxlength="5" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            备注：
                        </td>
                        <td class="tableStyle_right">
                            <textarea id="txtChangeRemark" rows="3"  style="width: 90%; word-wrap: break-word;
                                resize: none; outline: none;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center; height: 36px">
                            <% if (com.jfxy.listener.MemoryListener.sysparameter.getSms() == 1 && com.jfxy.listener.MemoryListener.sysparameter.getIsautosendsmsbymempointchange()==1)
                               { %>
                            <label class="lbsetCk" style="vertical-align: middle;">
                                <label style="vertical-align: middle;">
                                    <input id="chkSMS"  type="checkbox" />
                                    发送短信</label></label>&nbsp;&nbsp;
                            <%} %>
                            <% if (com.jfxy.listener.MemoryListener.sysparameter.getAutoprint()==1)
                               {%>
                            <label class="lbsetCk" style="vertical-align: middle;">
                                <label style="vertical-align: middle;">
                                    <input id="chkPrint"  type="checkbox" />
                                    打印小票</label></label>&nbsp;&nbsp;
                            <% } %>
                            <input id="btnChangeSave" type="button" value="保   存" class="buttonColor" />&nbsp;
                            <input id="btnChangeReset" type="button" class="buttonRest" value="重   置" />
                            <label ID="lblPrintTitle" Style="display: none"  Text=""></label>
                            <label ID="lblPrintFoot" Style="display: none"  Text=""></label>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
