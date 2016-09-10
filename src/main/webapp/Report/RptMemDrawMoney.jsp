﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
<title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/highcharts.js" type="text/javascript"></script>
    <script src="../Scripts/grid.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/RptMemDrawMoney.js" type="text/javascript"></script>
    <script src="../Scripts/fy.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            document.onkeydown = function (event) {
                e = event ? event : (window.event ? window.event : null);
                if (e.keyCode == 13) {
                    return false;
                }
            };
        });
    </script>
</head>
<body>
    <form id="frmMemDrawMoney" >
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
                        <div id="ChartShow" style="width: 800px; display: none;">
                            <div id="ChartSerch">
                                <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                    class="tableStyle">
                                    <tr>
                                        <td class="tableStyle_left">
                                            提现时间：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input id="txtMemStartTime"  type="text" class="Wdate border_radius" />
                                        </td>
                                        <td class="tableStyle_left">
                                            至&nbsp;&nbsp;
                                        </td>
                                        <td class="tableStyle_right">
                                            <input id="txtMemEndTime"  type="text" class="Wdate border_radius" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            所属店铺：
                                        </td>
                                        <td class="tableStyle_right" colspan="2">
                                            <select id="sltShopChart"  class="selectWidth">
                                            	<utils:shoplist shopid=""/>
                                            </select>
                                            
  <input  id="HDsltshop"  type="hidden" />
                                        </td>
                                        <td class="tableStyle_right">
                                            <div class="user_List_Button">
                                                <input id="btSerch" type="button" value="查   询" class="common_Button" />
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div id="chart">
                                <div id="container" style="width: 800px;">
                                </div>
                            </div>
                        </div>
                        <div id="ReportSerch">
                            <div class="user_List_top">
                                <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                    class="tableStyle">
                                    <tr style="color: #333333; background-color: #F7F6F3;">
                                        <td class="user_List_styleLeft">
                                            快捷操作：
                                        </td>
                                        <td class="user_List_styleRight">
                                            <div class="user_List_Button">
                                                <input type="button" id="btshowchart" value="统 计 图" class="common_Button" />
                                                <input type="button" id="btnMemDrawMoneyExcel"  OnClientClick="return btQuery();"
                                                    value="导   出" class="common_Button" OnClick="btnMemDrawMoneyExcel_Click"  visible="false" />
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr>
                                    <td class="tableStyle_left">
                                        快速查找：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtQueryMem" type="text"  class="border_radius radius2"
                                            title="会员卡号/卡面号码/姓名/手机号" />
                                    </td>
                                    <td class="tableStyle_left">
                                        提现单号：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtRechargeAccount" type="text"  class="border_radius radius2"
                                            title="会员卡号/姓名/手机号" />
                                    </td>
                                    <td class="tableStyle_left">
                                        备注查询：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtRemark" type="text"  class="border_radius radius2" title="输入备注关键字查询" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        会员等级：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltMemLevelID"  class="selectWidth">
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        所属店铺：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltShop"  class="selectWidth">
                                        	<utils:shoplist shopid=""/>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        提现金额：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltMoney"  style="height: 25px; outline: none; resize: none;">
                                            <option selected="selected" value="&gt;=">>=</option>
                                            <option value="&lt;="><=</option>
                                            <option value="=">=</option>
                                        </select>&nbsp;<input id="txtDrawMoney" type="text"  class="border_radius radius2"
                                            style="width: 122px; float: none; clear: both;" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        提现时间：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtStartTime" type="text"  class="Wdate border_radius" />
                                    </td>
                                    <td class="tableStyle_left">
                                        至&nbsp;&nbsp;
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtEndTime" type="text"  class="Wdate border_radius" />
                                    </td>
                                    <td style="border: none">
                                    </td>
                                    <td class="tableStyle_right">
                                        <div class="user_List_Button">
                                            <input type="button" id="btnRptMemDrawQuery" OnClientClick="return btQuery();" 
                                                value="查   询" class="common_Button" OnClick="btnRptMemDrawQuery_Click" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="tableStyle" id="tbtongji" style="width: 100%;">
                            <tr>
                                <th align="left">
                                    &nbsp;&nbsp;&nbsp;&nbsp; <font color="#00000">会员提现统计：<b>提现总金额： <font color="red">
                                        <label id="lblDrawTotalMoney">0</label></font>元,&nbsp;&nbsp;实际扣除总金额：
                                        <font color="red">
                                            <label id="lblDrawActualMoney" >0</label></font>元
                                    </font>
                                </th>
                            </tr>
                        </table>
                        <div  id="report">
                            <table class="table-style table-hover user_List_txt" cellspacing="0" cellpadding="2">
                             
                                      
                                            <tr class="th">
                                                <th>
                                                    序号
                                                </th>
                                                <th>
                                                    提现单号
                                                </th>
                                                <th>
                                                    会员卡号
                                                </th>
                                                <th>
                                                    会员姓名
                                                </th>
                                                <th>
                                                    提现金额
                                                </th>
                                                <th>
                                                    实际扣除金额
                                                </th>
                                                <th>
                                                    操作详情
                                                </th>
                                                <th>
                                                    日期
                                                </th>
                                                <th>
                                                    店铺
                                                </th>
                                                <th>
                                                    操作员
                                                </th>
                                            </tr>
                                       
                                  
                                  <c:forEach items="${memdrawmoneyFormBean.rows}" var="s" varStatus="status">
                                        <tr class="td">
                                            <td>
                                                ${status.index+1}
                                            </td>
                                            <td>
                                                ${s.drawmoneyaccount}
                                            </td>
                                            <td>
                                                ${s.memcard}
                                            </td>
                                            <td style="text-align: left">
                                                ${s.memname}
                                            </td>
                                            <td style="text-align: right; color: Red">
                                                ${s.drawmoney}
                                            </td>
                                            <td style="text-align: right">
                                                ${s.drawactualmoney}
                                            </td>
                                            <td style="text-align: left;">
                                                ${s.drawmoneyremark}
                                            </td>
                                            <td>
                                                <fmt:formatDate value="${s.drawmoneycreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                            </td>
                                            <td>
                                                ${s.shopname}
                                            </td>
                                            <td>
                                                ${s.username}
                                            </td>
                                        </tr>
                                   
								</c:forEach>
                            </table>
                            <div class="user_List_page">
                                <table style="width: 100%" id="tabPager">
                                    <tr>
                                        <td>
                                           <page:page pageIndex="${memdrawmoneyFormBean.page}" 
                                           pageCount="${memdrawmoneyFormBean.pages}" 
                                           rowCount="${memdrawmoneyFormBean.total}" 
                           					 pageSize="${memdrawmoneyFormBean.pageSize}" 
                           					  path="memList.do" param="type=1"/>
                              				<div class="clear"></div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
   <jsp:include  page="../Controls/QuickSearch.jsp"/>
    </form>
</body>
</html>
