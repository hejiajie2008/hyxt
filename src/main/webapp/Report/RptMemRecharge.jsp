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
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/highcharts.js" type="text/javascript"></script>
    <script src="../Scripts/grid.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Tab.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/RptMemRecharge.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
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
    <form id="frmRptMemRecharge" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <%--打印的次数 --%>
                    <input type="hidden" value="" id="PointNum"  />
                    <input type="hidden" value="R" id="Export"  />
                    <input type="hidden" value="" id="Revokable"  />
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
                                            充值时间：
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
                                                <input type="button" id="btshowchart" value="统 计 图" class="common_Button"  />
                                                <input type="button" ID="btnMemRechargeExcel"  value="导   出" class="common_Button"
                                                    OnClick="btnMemRechargeExcel_Click" visible="false" />
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <!--菜单-->
                        <div class="tabBox" id="ExchangeTab" style="margin-top: 10px;">
                            <ul class="tab">
                                <li id="tab0" class="on">充值记录报表</li>
                                <li id="tab1">会员充值汇总</li>
                                <li id="tab2">店铺充值汇总</li>
                            </ul>
                        </div>
                        <!--数据统计-->
                        <table class="tableStyle" id="tbtongji" style="width: 100%; margin-top: 10px;">
                            <tr>
                                <th align="left">
                                    &nbsp;&nbsp;&nbsp;&nbsp; <font color="#00000">本月充值金额统计：<b>充值总金额： <font color="red">
                                        <label ID="lblczMoney"  Text="0"></label></font>元,&nbsp;&nbsp;赠送总金额：
                                        <font color="red">
                                            <label ID="lbzsMoney"  Text="0"></label></font>元 </font>
                                </th>
                            </tr>
                        </table>
                        <!--充值报表-->
                        <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent0">
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
                                        充值单号：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtRechargeAccount" type="text"  class="border_radius radius2"
                                            title="充值单号" />
                                    </td>
                                    <td class="tableStyle_left">
                                        备注查询：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtRemark" type="text"  class="border_radius radius2" title="输入备注关键字查询" />
                                    </td>
                                    <td class="tableStyle_right">
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
                                        充值类型：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltRecharge"  name="D1" class="selectWidth">
                                            <option selected="selected" value="">=====请选择=====</option>
                                            <option value="1">初始充值</option>
                                            <option value="2">现金充值</option>
                                            <option value="3">银联充值</option>
                                            <option value="4">撤单充值</option>
                                            <option value="6">微信充值</option>
                                            
                                            <option value="5">支付宝充值</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        所属店铺：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltShop"  class="selectWidth">
                                        	<utils:shoplist shopid=""/>
                                        </select>
                                        <input id="HDsltshop"  type="hidden" />
                                    </td>
                                    <td class="tableStyle_right">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        充值金额：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltMoney"  style="height: 25px; outline: none; resize: none;">
                                            <option selected="selected" value="&gt;=">>=</option>
                                            <option value="&lt;="><=</option>
                                            <option value="=">=</option>
                                        </select>&nbsp;
                                        <input id="txtMoney" type="text"  class="border_radius radius2" style="float: none;
                                            clear: both; width: 60px;" />
                                    </td>
                                    <td class="tableStyle_left">
                                        充值时间：
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
                                    <td class="tableStyle_right">
                                        <div class="user_List_Button">
                                            <input type="button" OnClientClick="return btQuery();" id="btnRptMemRechargeQuery" 
                                                value="查   询" class="common_Button" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <!--列表-->
                            <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                                style="width: 100%;" id="RechargeList">
                                <tr>
                                    <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                        colspan="6" type="LoadingBar">
                                        <script type="text/javascript">
                                            ListLoading();
                                        </script>
                                    </td>
                                </tr>
                            </table>
                            <!--分页-->
                            <div id="divRechargeListPage" style="margin: 0px; border: solid 1px #ccc; height: 30px;">
                                <div class="listTablePage_simple">
                                </div>
                            </div>
                        </div>
                        <!--会员充值报表-->
                        <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent1">
                            <!--查询条件-->
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr>
                                    <td class="tableStyle_left">
                                        会员信息：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMRMem" type="text"  class="border_radius radius2" title="会员卡号/姓名" />
                                    </td>
                                    <td class="tableStyle_left">
                                        充值类型：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltMRType"  name="D1" class="selectWidth">
                                            <option selected="selected" value="">=====请选择=====</option>
                                            
                                            <option value="1">初始充值</option>
                                            <option value="2">现金充值</option>
                                            <option value="3">银联充值</option>
                                            <option value="4">撤单充值</option>
                                            <option value="6">微信充值</option>
                                            
                                            <option value="5">支付宝充值</option>

                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        所属店铺：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltMRShop"  class="selectWidth">
                                        </select>
                                    </td>
                                    <td class="tableStyle_right">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        充值时间：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMRStart" type="text"  class="Wdate border_radius" />
                                    </td>
                                    <td class="tableStyle_left">
                                        至&nbsp;&nbsp;
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMREnd" type="text"  class="Wdate border_radius" />
                                    </td>
                                    <td class="tableStyle_left">
                                        排序规则：
                                    </td>
                                    <td class="tableStyle_right">
                                        <%--余额  历史充值总额  历史充值总金额 历史赠送总金额  总充值次数  最后充值时间--%>
                                        <select id="sltOrderBy"  name="D1" class="selectWidth">
                                            <option selected="selected" value="">=====请选择=====</option>
                                            <option value="1">卡内余额升序</option>
                                            <option value="2">卡内余额降序</option>
                                            <option value="3">总充值次数升序</option>
                                            <option value="4">总充值次数降序</option>
                                            <option value="5">最后充值时间升序</option>
                                            <option value="6">最后充值时间降序</option>
                                            <option value="7">历史充值总额升序</option>
                                            <option value="8">历史充值总额降序</option>
                                            <option value="9">历史充值总金额升序</option>
                                            <option value="10">历史充值总金额降序</option>
                                            <option value="11">历史赠送总金额升序</option>
                                            <option value="12">历史赠送总金额降序</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_right">
                                        <input type="button" id="btnMRQuery" value="查   询" class="common_Button" />
                                    </td>
                                </tr>
                            </table>
                            <!--列表-->
                            <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                                style="width: 100%;" id="MemRechargeList">
                                <tr>
                                    <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                        colspan="6" type="LoadingBar">
                                        <script type="text/javascript">
                                            ListLoading();
                                        </script>
                                    </td>
                                </tr>
                            </table>
                            <!--分页-->
                            <div id="divMemRechargeListPage" style="margin: 0px; border: solid 1px #ccc; height: 30px;">
                                <div class="listTablePage_simple">
                                </div>
                            </div>
                        </div>
                        <!--店铺充值报表-->
                        <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent2">
                            <!--查询条件-->
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr>
                                    <td class="tableStyle_left">
                                        充值类型：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltSRType"  name="D1" class="selectWidth">
                                            <option selected="selected" value="">=====请选择=====</option>
                                            <option value="1">初始充值</option>
                                            <option value="2">现金充值</option>
                                            <option value="3">银联充值</option>
                                            <option value="4">撤单充值</option>
                                            <option value="6">微信充值</option>
                                            
                                            <option value="5">支付宝充值</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        所属店铺：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltSRShop"  class="selectWidth">
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        排序规则：
                                    </td>
                                    <td class="tableStyle_right">
                                        <%--充值总额  充值总金额 赠送总金额  总充值次数--%>
                                        <select id="sltSROrderBy"  name="D1" class="selectWidth">
                                            <option selected="selected" value="">=====请选择=====</option>
                                            <option value="1">充值总额升序</option>
                                            <option value="2">充值总额降序</option>
                                            <option value="3">充值总金额升序</option>
                                            <option value="4">充值总金额降序</option>
                                            <option value="5">赠送总金额升序</option>
                                            <option value="6">赠送总金额降序</option>
                                            <option value="7">总充值次数升序</option>
                                            <option value="8">总充值次数降序</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        充值时间：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtSRStart" type="text"  class="Wdate border_radius" />
                                    </td>
                                    <td class="tableStyle_left">
                                        至&nbsp;&nbsp;
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtSREnd" type="text"  class="Wdate border_radius" />
                                    </td>
                                    <td class="tableStyle_right">
                                    </td>
                                    <td class="tableStyle_right">
                                        <input type="button" id="btnSRQuery" value="查   询" class="common_Button" />
                                    </td>
                                </tr>
                            </table>
                            <!--列表-->
                            <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                                style="width: 100%;" id="ShopRechargeList">
                                <tr>
                                    <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                        colspan="6" type="LoadingBar">
                                        <script type="text/javascript">
                                            ListLoading();
                                        </script>
                                    </td>
                                </tr>
                            </table>
                            <!--分页-->
                            <div id="divShopRechargeListPage" style="margin: 0px; border: solid 1px #ccc; height: 30px;">
                                <div class="listTablePage_simple">
                                </div>
                            </div>
                        </div>
                    </div>
            </td>
        </tr>
    </table>
    <label id="lblPrintTitle" Style="display: none"  Text="Label"></label>
    <label id="lblPrintFoot" Style="display: none"  Text="Labe2"></label>
     <jsp:include  page="../Controls/QuickSearch.jsp"/>
    </form>
</body>
</html>
