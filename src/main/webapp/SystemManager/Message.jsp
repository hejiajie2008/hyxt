<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/SystemManage/Message.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmMessage" >
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
                        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                            class="tableStyle">
                            <tr>
                                <td class="tableStyle_left">
                                    会员信息：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtQueryMem" type="text"  class="border_radius" title="会员卡号/姓名/手机号" />
                                </td>
                                <td class="tableStyle_left">
                                    留言时间：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtStartTime" type="text"  class="Wdate border_radius" style="float: none;
                                        clear: both;" />
                                </td>
                                <td class="tableStyle_left">
                                    &nbsp;至&nbsp;
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtEndTime" type="text"  class="Wdate border_radius" style="float: none;
                                        clear: both;" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltShop"  class="selectWidth" name="D2">
                                    	<utils:shoplist shopid=""/>
                                    </select>
                                </td>
                                <td colspan="3" style="border: none">
                                </td>
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" id="btQueryMemSearch"  value="查   询" class="common_Button"
                                            OnClick="btQueryMemSearch_Click" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                            
                                        <tr class="th">
                                            <th>
                                                会员卡号
                                            </th>
                                            <th>
                                                会员姓名
                                            </th>
                                            <th>
                                                手机号码
                                            </th>
                                            <th>
                                                所属店铺
                                            </th>
                                            <th>
                                                留言日期
                                            </th>
                                            <th>
                                                留言总数
                                            </th>
                                            <th>
                                                是否留言
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                  <c:forEach items="${messageFormBean.rows}" var="s" varStatus="status">
                                        <tr class="td">
                                            <td>
                                                ${s.memcard}
                                            </td>
                                            <td>
                                                ${s.memname}
                                            </td>
                                            <td>
                                                ${s.memmobile}
                                                
                                            </td>
                                            <td>
                                                $\{s.shopname") %>
                                            </td>
                                            <td>
                                                <fmt:formatDate value="${s.messagetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </td>
                                            <td style="text-align: right">
                                                $\{s.messagecount}
                                            </td>
                                            <td>
                                                $\{s.messageisreply}
                                            </td>
                                            <td class="listtd" style="width: 60px;">
                                                <a href="#" onclick='btnMessageReply(${s.messagememid})'
                                                    id="hyMessageReply" >
                                                    <img src="../images/Gift/manage.png" title="管理" alt="管理" />
                                                </a><a href="#"  id="hyMessageDel" onclick='btnMessageDel(${s.messagememid},${s.memname})'>
                                                    <img alt="删除" title="删除" src="../images/Gift/del.png" />
                                                </a>
                                            </td>
                                        </tr>
                                  </c:forEach>
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                        <page:page pageIndex="${messageFormBean.page}" pageCount="${messageFormBean.pages}" rowCount="${messageFormBean.total}" 
                           					 pageSize="${messageFormBean.pageSize}" 
                           					  path="memList.do" param="type=1"/>
                              				<div class="clear"></div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
