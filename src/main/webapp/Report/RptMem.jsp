<%@ page language="java" contentType="text/html; charset=UTF-8"
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
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/highcharts.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/RptMem.js" type="text/javascript"></script>
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
    <form id="page_form" action="RptMem.do" method="get" >
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
                        <div id="ChartShow" style="display: none; width: 800px;">
                            <div id="ChartSerch">
                                <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                    class="tableStyle">
                                    <tr>
                                        <td class="tableStyle_left">
                                            时间段：
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
                                                <input type="button" value="统 计 图" id="btshowchart" class="common_Button" visible="false" />
                                                <input type="button" id="btnRptMemExcel"  value="导   出" class="common_Button"
                                                    OnClick="btnRptMemExcel_Click" visible="false" />
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr>
                                    <td class="tableStyle_left">
                                        会员信息：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtQueryMem" type="text"  class="border_radius radius2"
                                            title="会员卡号/卡面号码/姓名/手机号" />
                                    </td>
                                    <td class="tableStyle_left">
                                        会员等级：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltMemLevelID" name="memlevelid"  class="selectWidth">
                                        	
                                        	<utils:memlevel levelid="${memFormBean.memlevelid }"/>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        所属店铺：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltShop" name="memshopid"  class="selectWidth" autocomplete="off">
                                        	<utils:shoplist shopid="${memFormBean.memshopid }"/>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        会员将近：
                                    </td>
                                    <td class="tableStyle_right" colspan="4">
                                        <input id="txtDay" type="text"  class="border_radius radius2" style="width: 100px" />
                                        <label style="line-height: 30px; height: 30px;">
                                            &nbsp;天没来消费</label>
                                    </td>
                                    <td class="tableStyle_right">
                                        <div class="user_List_Button">
                                            <input type="button" id="btnRptMemQuery"  value="查   询" class="common_Button"
                                                OnClick="btnRptMemQuery_Click" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="tableStyle" id="tbtongji" style="width: 100%;">
                            <tr class="th">
                                <td align="left" style="font-size:3;font-weight:bold">
                                   会员信息统计：会员总数量： <font color="red">
                                        <label id="lblMemCount"   >0</label></font>人
                                        会员余额汇总： <font color="red">
                                        <label id="lblMemMoney"   >0</label></font>元
                                        会员积分汇总： <font color="red">
                                        <label id="lblMemPoint"   >0</label></font>

                                        
                                </td>
                            </tr>
                        </table>
                        <div id="report">
                            <table class="table-style table-hover user_List_txt" cellspacing="0" cellpadding="2">
                                
                                            <tr class="th">
                                                <th>
                                                    序号
                                                </th>
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
                                                    账户余额
                                                </th>
                                                <th>
                                                    账户积分
                                                </th>
                                                <th>
                                                    会员等级
                                                </th>
                                                <th>
                                                    累计消费
                                                </th>
                                                <th>
                                                    上次消费日期
                                                </th>
                                                <th>
                                                    店铺
                                                </th>
                                                <th>
                                                    办卡日期
                                                </th>
                                                <th>
                                                    操作员
                                                </th>
                                            </tr>
                                        
                                    <c:forEach items="${memFormBean.rows}" var="s" varStatus="status">
                                        <tr class="td">
                                            <td style="width: 50px;">
                                                <label id="lblNumber"  >${status.index+1}</label>
                                            </td>
                                            <td>
                                                ${s.memcard}
                                            </td>
                                            <td style="text-align: left">
                                                ${s.memname}
                                            </td>
                                            <td>
                                                
                                                ${s.memmobile }
                                            </td>
                                            <td style="text-align: right">
                                                ${s.memmoney}
                                            </td>
                                            <td style="text-align: right">
                                                ${s.mempoint}
                                            </td>
                                            <td>
                                                ${s.levelname}
                                            </td>
                                            <td>
                                                ${s.memconsumemoney}
                                            </td>
                                            <td>
                                                 <fmt:formatDate value="${s.memconsumelasttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </td>
                                            <td>
                                                ${s.shopname}
                                            </td>
                                            <td>
                                               
                                                
                                                 <fmt:formatDate value="${s.memcreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
                                            <page:page pageIndex="${memFormBean.page}" pageCount="${memFormBean.pages}" rowCount="${memFormBean.total}" 
                           					 pageSize="${memFormBean.pageSize}" 
                           					  path="memList.do" param="type=1"/>
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
