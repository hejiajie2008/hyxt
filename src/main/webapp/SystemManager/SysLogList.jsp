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
    <script src="../Scripts/Module/SystemManage/SysLog.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
     <script src="../Scripts/fy.js" type="text/javascript"></script>
</head>
<body>
    <form id="page_form" action="SysLogList.do" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title />
                        </div>
                    </div>
                    <div class="user_List_All">
                        <div class="user_List_top" style="height: 34px;">
                            <table class="tableStyle" style="width: 100%">
                                <tr style="color: #333333; background-color: #F7F6F3;">
                                    <td class="user_List_styleLeft">
                                        快捷操作：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <div class="user_List_Button">
                                            <select id="sltCleanTime"  class="selectWidth" style="width: 120px;">
                                                <option value="7">7天前日志</option>
                                                <option value="30">一个月前日志</option>
                                                <option value="90">三个月前日志</option>
                                            </select>
                                            <input type="button"  id="btnCleanSysLog" class="common_Button" value="清理日志"
                                                style="clear: both; float: none;"  visible="false" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                            class="tableStyle">
                            <tr>
                                <td class="tableStyle_left">
                                    关键字：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtkeywords" type="text"  class="border_radius radius2"
                                        maxlength="20" />
                                </td>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltShop"  class="selectWidth" name="logshopid">
                                     <utils:shoplist shopid="${syslogFormBean.logshopid }"/>
                                    </select>
                                </td>
                                <td class="tableStyle_left">
                                    操作员：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltSysUserID"  class="selectWidth" name="loguserid">
                                    	<utils:userlist userid="${syslogFormBean.loguserid }"/>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    操作时间：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtStartTime" type="text"  class="Wdate border_radius" />
                                </td>
                                <td class="tableStyle_left">
                                    &nbsp;至&nbsp;&nbsp;&nbsp;
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtEndTime" type="text"  class="Wdate border_radius" />
                                </td>
                                <td style="border: none">
                                </td>
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" id="btnsysLogListQuery"  value="查   询" class="common_Button"
                                             />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                            
                                   
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                用户账号
                                            </th>
                                            <th>
                                                用户姓名
                                            </th>
                                            <th>
                                                操作类型
                                            </th>
                                            <th>
                                                日志详情
                                            </th>
                                            <th>
                                                IP地址
                                            </th>
                                            <th>
                                                所属店铺
                                            </th>
                                            <th>
                                                操作时间
                                            </th>
                                        </tr>
                                <c:forEach items="${syslogFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                            <label id="lblNumber">
                                            ${status.index+1 }</label>
                                        </td>
                                        <td>
                                            ${s.useraccount}
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        <td>
                                            ${s.logtype}
                                        </td>
                                        <td style="text-align: left;">
                                            ${s.logdetail}
                                        </td>
                                        <td>
                                            ${s.logipadress}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${s.logcreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                        </td>
                                    </tr>
                               </c:forEach>

                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                        <page:page pageIndex="${syslogFormBean.page}" pageCount="${syslogFormBean.pages}"
                                          rowCount="${syslogFormBean.total}" 
                           					 pageSize="${syslogFormBean.pageSize}" 
                           					  path="ExpenseHistory.do" param="type=1"/>
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
