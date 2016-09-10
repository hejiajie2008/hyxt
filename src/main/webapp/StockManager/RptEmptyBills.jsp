<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/StockManage/GoodsEmptyBills.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
     <script src="../Scripts/fy.js" type="text/javascript"></script>
</head>
<body>
    <form id="page_form" action="RptEmptyBills.do">
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
                            <table class="tableStyle" style="width: 100%">
                                <tr style="color: #333333; background-color: #F7F6F3;">
                                    <td class="user_List_styleLeft">
                                        快捷操作：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <div class="user_List_Button">
                                            <input type="button" id="btnRptEmptyBillsExcel"  value="导   出" UseSubmitBehavior="false"
                                                class="common_Button" OnClick="btnRptEmptyBillsExcel_Click"  visible="false" />
                                            <input id="txtUser" type="hidden" class="input_txt border_radius"  />
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
                                    订单编号：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtOrderAccount" type="text"  class="border_radius radius2"
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
                                    </select>
                                      <input  id="HDsltshop"  type="hidden" />
                                </td>
                                <td colspan="3">
                                </td>
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" id="btnRptEmptyBillsQuery"  value="查   询" class="common_Button"
                                            OnClick="btnRptEmptyBillsQuery_Click" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt" cellspacing="0" cellpadding="2"
                            style="width: 100%;">
                            
                                    <tr class="th">
                                        <th>
                                            序号
                                        </th>
                                        <th>
                                            订单编号
                                        </th>
                                        <th>
                                            会员卡号
                                        </th>
                                        <th>
                                            会员姓名
                                        </th>
                                        <th>
                                            应付金额
                                        </th>
                                        <th>
                                            实付金额
                                        </th>
                                        <th>
                                            应获积分
                                        </th>
                                        <th>
                                            挂单备注
                                        </th>
                                        <th>
                                            挂单店铺
                                        </th>
                                        <th>
                                            操作人员
                                        </th>
                                        <th>
                                            挂单时间
                                        </th>
                                        <th>
                                            操&nbsp;&nbsp;&nbsp;&nbsp;作
                                        </th>
                                    </tr>
                               
                                <c:forEach  items="${orderlogFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td style="width: 50px;">
                                            <label ID="lblNumber"  >
                                            ${status.index+1 }
                                            </label>
                                        </td>
                                        <td style="text-align: left">
                                            <img id="img${s.orderid}" alt="" src="../Inc/Style/images/plus.gif" style="vertical-align: text-bottom"
                                                onload="javascript:IsShow(${s.orderid},3)" />
                                            <a href="javascript:ShowDetail(${s.orderid},3)" title="展开/收起详情">
                                                ${s.orderaccount}</a>
                                        </td>
                                        <td>
                                            ${s.memcard}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.memname}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.ordertotalmoney}
                                        </td>
                                        <td style="text-align: right">
                                           ${s.orderdiscountmoney}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.orderpoint}
                                        </td>
                                        <td style="text-align: left">
                                           ${s.orderremark}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        <td>
                                          
                                            <fmt:formatDate value="${s.ordercreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                        </td>
                                        <td class="listtd" style="width: 90px;">
                                            <a id="aEditExpense"  visible="false"  href='/hyxt/StockManager/GoodsExpense.do?orderid=${s.orderid}&memcard=${s.memcard}'>
                                                <img src="../images/Gift/eit.png" title="编辑" alt="编辑" />
                                            </a>
                                            <a id="submint"  visible="false"  href='javascript:void(0);' 
                                            onClick='javascript:SubmitEmptyBills("${s.memcard}",${s.orderid},"${s.orderaccount}",${s.orderdiscountmoney})'>
                                                <img src="../images/Gift/settle.png" alt="结算" title="结算" /></a> 
                                                <a id="Cancel" 
                                                    href='#'  visible="false" onclick='CancelEmptyBills(${s.orderid},${s.ordermemid})'>
                                                    <img src="../images/Gift/del.png" alt="撤销" title="撤销" /></a>
                                        </td>
                                    </tr>
                                    <tr style="display: none;" id="data${s.orderid}">
                                        <td colspan="12">
                                            
                                                    <div style="padding-left: 55px;">
                                                        <table class="table-style table-hover user_List_txt" cellspacing="0" cellpadding="2"
                                                            style="width: 80%;">
                                                            <tr class="th">
                                                                <th>
                                                                    序号
                                                                </th>
                                                                <th>
                                                                    商品编码
                                                                </th>
                                                                <th>
                                                                    商品名称
                                                                </th>
                                                                <th>
                                                                    商品类型
                                                                </th>
                                                                <th>
                                                                    商品单价
                                                                </th>
                                                                <th>
                                                                    商品数量
                                                                </th>
                                                                <th>
                                                                    商品积分
                                                                </th>
                                                                <th>
                                                                    折后总价
                                                                </th>
                                                            </tr>
                                               <c:forEach items="${s.details}" var="sd" varStatus="dstatus">
                                                    <tr class="td">
                                                        <td>
                                                            <label id="lblDetailNumber" >${dstatus.index+1}</label>
                                                        </td>
                                                        <td>
                                                            ${sd.goodscode}
                                                        </td>
                                                        <td>
                                                            ${sd.name}
                                                        </td>
                                                        <td>
                                                            <c:choose>
                                        						<c:when test="${sd.goodstype==1}">
                                        						服务项目 
                                        						</c:when>
                                        						<c:when test="${sd.goodstype==0}">
                                        						普通商品 
                                        						</c:when>
                                        						<c:otherwise>
                                        							未找到
                                        						</c:otherwise>
                                        					</c:choose>
                                                        </td>
                                                        <td>
                                                             ${sd.orderdetailprice}
                                                        </td>
                                                        <td>
                                                            ${sd.orderdetailnumber}
                                                        </td>
                                                        <td>
                                                            ${sd.orderdetailpoint}
                                                        </td>
                                                        <td>
                                                            ${sd.orderdetaildiscountprice}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                    </table> </div>
                                               
                                            
                                        </td>
                                    </tr>
                                </ItemTemplate>
                                <FooterTemplate>
                                </FooterTemplate>
                            </c:forEach>
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                       <page:page pageIndex="${orderlogFormBean.page}" pageCount="${orderlogFormBean.pages}"
                                          rowCount="${orderlogFormBean.total}" 
                           					 pageSize="${orderlogFormBean.pageSize}" 
                           					  path="RptEmptyBills.do" param="type=1"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <input id="chkAllowPwd" type="checkbox" style="display: none"  />
    <jsp:include page="../Controls/Pay.jsp">
    	<jsp:param value="ucPay_" name="pay"/>
    </jsp:include>
    <jsp:include page="../Controls/QuickSearch.jsp"/>
    
    </form>
</body>
</html>
