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
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/highcharts.js" type="text/javascript"></script>
    <script src="../Scripts/grid.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/RptMemExpense.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            document.onkeydown = function (event) {
                e = event ? event : (window.event ? window.event : null);
                if (e.keyCode == 13) {
                    return false;
                }
            };
        });


        function ShowDetails(id, arg2) {
            if ($("#data" + id).css("display") == "none") {
                $("#data" + id).css("display", "");
                $("#detail" + id).css("display", "");
                $("#img" + id).attr("src", "../Inc/Style/images/minus.gif")
            }
            else {
                $("#data" + id).css("display", "none");
                $("#detail" + id).css("display", "none");
                $("#img" + id).attr("src", "../Inc/Style/images/plus.gif")
            }
        }
    </script>
</head>
<body style="overflow-x: hidden;">
    <form id="frmMemExpense" >
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
                                            消费时间：
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
                                        <td class="tableStyle_right">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            会员信息：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input id="txtMemInfo" type="text"  class="border_radius radius2" title="会员卡号/卡面号码/姓名/手机号" />
                                        </td>
                                        <td class="tableStyle_left">
                                            所属店铺：
                                        </td>
                                        <td class="tableStyle_right">
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
                                                <input type="button" id="btshowchart" value="统 计 图" class="common_Button" />
                                                <input type="button" id="btnMemExpenseExcel"  value="导   出" class="common_Button"
                                                    OnClick="BtnMemExpenseExcel_Click" visible="false" />
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
                                        消费时间：
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
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        所属店铺：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltShop"  class="selectWidth">
                                        <utils:shoplist shopid=""/>
                                        </select>
                                        <input  id="HDsltshop"  type="hidden" />
                                    </td>
                                    <td colspan="3" style=" border:none">
                                    </td>
                                    <td class="tableStyle_right">
                                        <div class="user_List_Button">
                                            <input type="button" id="btnMemExpenseSearch"  value="查   询" class="common_Button"
                                                OnClick="BtnMemExpenseSearch_Click" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="tableStyle" id="tbtongji" style="width: 100%;">
                            <tr>
                                <th align="left">
                                    &nbsp;&nbsp;&nbsp;&nbsp; <font color="#00000">会员消费统计：<b>消费总人数： <font color="red">
                                        <label ID="lblTotalNumber"  Text="0"></label></font>人,&nbsp;&nbsp;消费总金额：
                                        <font color="red">
                                            <label ID="lblTotalMoney"  Text="0"></label></font>元
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
                                                    会员卡号
                                                </th>
                                                <th>
                                                    会员姓名
                                                </th>
                                                <th>
                                                    所属店铺
                                                </th>
                                                <th>
                                                    实际支付总额
                                                </th>
                                            </tr>
                                       
                                        <c:forEach items="${rptMemFormBean.rows}" var="s" varStatus="status">
                                       
                                        <tr class="td">
                                            <td style="width: 50px;">
                                                <label id="lblNumber"  >${status.index+1}</label>
                                            </td>
                                            <td style="text-align: left">
                                                <img id="img${s.memid}" alt="" src="../Inc/Style/images/plus.gif"
                                                    style="vertical-align: text-bottom"  />

                                                <a id="a${s.memid}" href="javascript:ShowDetails('${s.memid}','${s.discountmoney}')"
                                                    title="展开/收起详情">
                                                    ${s.memcard}</a>

                                                 <%--    <img id="img1" alt="" src="../Inc/Style/images/plus.gif"
                                                    style="vertical-align: text-bottom" onload="javascript:IsShow('$\{s.MemID}','$\{s.DiscountMoney}')" />

                                                <a id="a1" href="javascript:ShowDetail('$\{s.MemID}','$\{s.DiscountMoney}')"
                                                    title="展开/收起详情">
                                                    $\{s.MemCard}</a>--%>


                                            </td>
                                            <td style="text-align: left">
                                                ${s.memname}
                                            </td>
                                            <td style="text-align: left">
                                                 ${s.shopname}
                                            </td>
                                            <td style="text-align: right; color: Red">
                                                 ${s.discountmoney}
                                            </td>
                                        </tr>
                                        <tr style="display: none;" id="data${s.memid}">
                                            <td colspan="4">
                                                <div style="padding-left: 50px;">
                                                    <table class="table-style table-hover user_List_txt" cellspacing="0" cellpadding="2"
                                                        style="width: 80%;">
                                                     
                                                                    <tr class="th">
                                                                        <th>
                                                                            序号
                                                                        </th>
                                                                        <th>
                                                                            订单编号
                                                                        </th>
                                                                        <th>
                                                                            消费店铺
                                                                        </th>
                                                                        <th>
                                                                            消费类型
                                                                        </th>
                                                                        <th>
                                                                            消费总额
                                                                        </th>
                                                                        <th>
                                                                            折后总价
                                                                        </th>
                                                                        <th>
                                                                            优惠券金额
                                                                        </th>
                                                                        <th>
                                                                            获得积分
                                                                        </th>
                                                                        <th>
                                                                            卡内余额
                                                                        </th>
                                                                        <th>
                                                                            卡内积分
                                                                        </th>
                                                                        <th>
                                                                            消费时间
                                                                        </th>
                                                                    </tr>
                                                                
                                                             <c:forEach items="${s.orderlogList}" var="sd" varStatus="dstatus">
                                                                <tr class="td" id="drDataDetail${s.memid}">
                                                                    <td>
                                                                        <label id="lblDetailNumber"  >${dstatus.index+1}</label>
                                                                    </td>
                                                                    <td>
                                                                        ${sd.orderaccount}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.shopname}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.ordertype}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.ordertotalmoney}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.orderdiscountmoney}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.orderpaycoupon}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.orderpoint}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.ordercardbalance}
                                                                    </td>
                                                                    <td>
                                                                        ${sd.ordercardpoint}
                                                                    </td>
                                                                    <td>
                                                                        <fmt:formatDate value="${sd.ordercreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                    </table>
                                                </div>
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
