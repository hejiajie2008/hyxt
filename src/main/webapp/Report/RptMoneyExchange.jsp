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

    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
     <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
     <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
     <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
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
    <form id="frm" >
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
                        <div class="user_List_top">
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr style="color: #333333; background-color: #F7F6F3;">
                                    <td class="user_List_styleLeft">
                                        快捷操作：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <div class="user_List_Button">
                                            <input type="button" ID="btnMoneyExchangeExcel"  value="导   出" class="common_Button"
                                                OnClick="btnMoneyExchangeExcel_Click"  visible="false" />
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
                                    <input id="txtQueryMem" type="text"  class="border_radius" title="会员卡号/卡面号码/姓名/手机号" />
                                </td>
                                <td class="tableStyle_left">
                                    订单编号：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtMoneyExchangeCode" type="text"  class="border_radius" />
                                </td>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltShop"  class="selectWidth">
                                    </select>
                                    <input  id="HDsltshop"  type="hidden" />
                                </td>
                                <td style="border: none">
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    消费时间：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtStartTime" type="text"  class="Wdate border_radius" />
                                </td>
                                <td class="tableStyle_left" style="text-align: right;">
                                    至&nbsp;&nbsp;
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtEndTime" type="text"  class="Wdate border_radius" />
                                </td>
                                <td class="tableStyle_left">
                                    变动类型：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltdMoneyChangeType"  class="selectWidth">
                                    </select>
                                </td>
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" ID="btnMoneyExchangeSearch"  value="查   询" class="common_Button"
                                            OnClick="btnMoneyExchangeSearch_Click" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <%-- <table class="tableStyle" id="tbtongji" style="width: 100%;">
                            <tr>
                                <th align="left">
                                    &nbsp;&nbsp;<font color="#00000">金额变动统计：<b>变动总金额： <font color="red">
                                        <label ID="lbllMoney"  value="0"></label></font>元,&nbsp;&nbsp;现金变动：
                                        <font color="red">
                                            <label ID="lblCashMoney"  value="0"></label></font>元,&nbsp;&nbsp;余额变动：
                                        <font color="red">
                                            <label ID="lblCardMoney"  value="0"></label></font>元 ,&nbsp;&nbsp;银联变动：
                                        <font color="red">
                                            <label ID="lblBankMoney"  value="0"></label></font>元,&nbsp;&nbsp;赠送：
                                        <font color="red">
                                            <label ID="lblGiveMoney"  value="0"></label></font>元
                                    </font>
                                </th>
                            </tr>
                            <tr>
                                <th align="left">
                                </th>
                            </tr>
                        </table>--%>
                        <table class="table-style table-hover user_List_txt">
                            <asp:Repeater  ID="gvMoneyExchange">
                                <HeaderTemplate>
                                    <thead class="thead">
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                订单编号
                                            </th>
                                            <th>
                                                变动类型
                                            </th>
                                            <th>
                                                会员卡号
                                            </th>
                                            <th>
                                                会员姓名
                                            </th>
                                            <th>
                                                变动后余额
                                            </th>
                                            <th>
                                                变动金额
                                            </th>
                                            <th>
                                                现金变动
                                            </th>
                                            <th>
                                                余额变动
                                            </th>
                                            <th>
                                                银联变动
                                            </th>
                                            <th>
                                                赠送金额
                                            </th>
                                            <th>
                                                变动时间
                                            </th>
                                            <th>
                                                店铺
                                            </th>
                                            <th>
                                                操作员
                                            </th>
                                        </tr>
                                    </thead>
                                </HeaderTemplate>
                                <ItemTemplate>
                                    <tr class="td">
                                        <td>
                                            <label ID="lblNumber"  value="1"></label>
                                        </td>
                                        <td>
                                           $\{MoneyChangeAccount")%>
                                        </td>
                                        <td>
                                            <label ID="Label1"  Text='$\{MoneyChangeType")) %>'></label>
                                        </td>
                                        <td>
                                           $\{MemCard")%>
                                        </td>
                                        <td style="text-align: left">
                                           $\{MemName")%>
                                        </td>
                                        <td style="text-align: right">
                                           $\{MemMoney","{0:F2}")%>
                                        </td>
                                        <td style="text-align: right">
                                           $\{MoneyChangeMoney", "{0:F2}")%>
                                        </td>
                                        <td style="text-align: right">
                                           $\{MoneyChangeCash", "{0:F2}")%>
                                        </td>
                                        <td style="text-align: right">
                                           $\{MoneyChangeBalance", "{0:F2}")%>
                                        </td>
                                        <td style="text-align: right">
                                           $\{MoneyChangeUnionPay", "{0:F2}")%>
                                        </td>
                                        <td style="text-align: right">
                                           $\{MoneyChangeGiveMoney", "{0:F2}")%>
                                        </td>
                                        <td>
                                           $\{MoneyChangeCreateTime", "{0:yyyy-MM-dd HH:mm:ss}")%>
                                        </td>
                                        <td>
                                           $\{ShopName")%>
                                        </td>
                                        <td>
                                           $\{UserName")%>
                                        </td>
                                    </tr>
                                </ItemTemplate>
                            </asp:Repeater>
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                        	分页
                                    </td>
                                </tr>
                            </table>
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
