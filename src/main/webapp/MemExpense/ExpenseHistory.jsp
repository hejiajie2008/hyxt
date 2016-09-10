<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../Inc/Style/Style.css" rel="stylesheet" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/Module/MemExpense/ExpenseHistory.js" type="text/javascript"></script>
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
     <script src="../Scripts/fy.js" type="text/javascript"></script>
    <style type="text/css">


p.MsoNormal{
margin-bottom:.0001pt;
text-align:justify;
text-justify:inter-ideograph;
font-family:Calibri;
font-size:10.5000pt;
            margin-left: 0pt;
            margin-right: 0pt;
            margin-top: 0pt;
        }

    </style>
</head>
<body>
    <form id="page_form" action="ExpenseHistory.do">
    <input type="hidden"  id="txtUser" />
    <input type="hidden"  id="txtShopid" />
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                 
                 <input type="hidden" value="" id="PointNum" />
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
                                        <input id="txtQueryMem" type="text"  class="border_radius radius2"
                                            title="会员卡号/卡面号码/姓名/手机号" />
                                        <div class="user_List_Button">
                                            <input type="button" id="Button1" OnClientClick="return btQuery();"  value="查   询"
                                                class="common_Button" OnClick="btnRptExpenseQuery_Click" />
                                            <input id="btnhigthSearch" type="button" class="common_Button" value="高级查询" />
                                            <input type="button" id="btnExpenseExcel" OnClientClick="return btQuery();" 
                                                value="导   出" TabIndex="0" class="common_Button" OnClick="btnExpenseExcel_Click"  visible="false"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="divHightSearch" style="display: none">
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr>
                                    <td class="tableStyle_left">
                                        订单编号：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtOrderAccount" type="text"  class="border_radius radius2"
                                            title="订单编号" />
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
                                    <td class="tableStyle_left">
                                        消费店铺：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltConsumptionShop"  class="selectWidth">
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        实收金额：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltDiscountMoney"  style="height: 25px; outline: none;
                                            resize: none;">
                                            <option selected="selected" value="&gt;=">>=</option>
                                            <option value="&lt;="><=</option>
                                            <option value="=">=</option>
                                        </select>
                                        <input id="txtDiscountMoney" type="text"  class="border_radius radius2"
                                            style="width: 122px; float: none;" />
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
                                        消费类型：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltOrderType"  class="selectWidth">
                                            <option value="">===== 请选择 =====</option>
                                            <option value="-1">散客消费</option>
                                            <option value="0">快速消费</option>
                                            <option value="1">计时消费</option>
                                            <option value="7">计次消费</option>
                                            <option value="2">商品消费</option>
                                            <option value="4">商品撤单</option>
                                            <option value="6">商品退货</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        应收金额：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select id="sltTotalMoney"  style="height: 25px; outline: none; resize: none;">
                                            <option selected="selected" value="&gt;=">>=</option>
                                            <option value="&lt;="><=</option>
                                            <option value="=">=</option>
                                        </select>
                                        <input id="txtTotalMoney" type="text"  class="border_radius radius2"
                                            style="width: 122px; float: none;" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        备注查询：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtRemark" type="text"  class="border_radius radius2" title="输入备注关键字查询" />
                                    </td>
                                    <td colspan="3">
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="btnMemReset" type="button" value="重   置" class="common_Button" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="table-style table-hover user_List_txt" cellspacing="0" cellpadding="2"
                            style="width: 100%;">
                            
                               
                                    <tr class="th">
                                        <th>
                                            序号
                                        </th>
                                        <th style="width: 170px">
                                            订单编号
                                        </th>
                                        <th>
                                            会员姓名
                                        </th>
                                        <th>
                                            会员卡号
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
                                            消费时间
                                        </th>
                                        <th>
                                            消费店铺
                                        </th>
                                        <th>
                                            操作人员
                                        </th>
                                        <th>
                                            备注
                                        </th>
                                        <th>
                                            操&nbsp;&nbsp;作
                                        </th>
                                    </tr>
                                    <c:forEach  items="${orderlogFormBean.rows}" var="s" varStatus="status">
                              
                                    <tr class="td">
                                        <td style="width: 50px;">
                                            ${status.index+1}
                                        </td>
                                        <td style="text-align: left; width: 170px">
                                            <img id="img${s.orderid}" alt="" src="../Inc/Style/images/plus.gif"
                                                style="vertical-align: text-bottom" 
onload="javascript:IsShowPic('${s.orderid}','${s.count}')" />
                                            <a id="a${s.orderid}" 
                                                title="展开/收起详情"
                                                href="javascript:ShowExpenseDetail('${s.orderid}','${s.count}')"
                                                >
                                                ${s.orderaccount}</a>
                                        </td>
                                        <td style="text-align: left">
                                            ${s.memname}
                                        </td>
                                        <td>
                                            ${s.memcard}
                                        </td>
                                        <td style="color: Red">
                                        
                                       
                                        <c:choose>
                                        <c:when test="${s.ordertype==-1}">
                                        	散客消费
                                        </c:when>
                                        <c:when test="${s.ordertype==0}">
                               			         快速消费	
                                        </c:when>
                                        <c:when test="${s.ordertype==1}">
                               			         计时消费
                                        </c:when>
                                        <c:when test="${s.ordertype==2}">
                               			         商品消费
                                        </c:when>
                                        <c:when test="${s.ordertype==4}">
                               			         消费撤单
                                        </c:when>
                                         <c:when test="${s.ordertype==5}">
                               			         消费原单
                                        </c:when>
                                        <c:when test="${s.ordertype==6}">
                               			         商品退货
                                        </c:when>
                                        <c:when test="${s.ordertype==7}">
                               			         计次消费
                                        </c:when>
                                        <c:otherwise>
                                        	类型异常
                                        </c:otherwise>
                                        </c:choose>
                                           
                                        </td>
                                        <td style="text-align: right">
                                            ${s.ordertotalmoney}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.orderdiscountmoney}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.orderpaycoupon}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.orderpoint}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.ordercardbalance}
                                        </td>
                                        <td>
                                            
                                            <fmt:formatDate value="${s.ordercreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        <td>
                                            <a href="#" title='OrderRemark'>备注详情</a>
                                        </td>
                                        <td class="listtd" style="width: 60px;">
                                            <label id="tdUser"  visible='OrderType'>
                                                <span id="print" ><a href="javascript:Print('OrderID',OrderType,OrderMemID)" visible="false">
                                                    <img src="../images/Gift/print.png" alt="重打小票" />
                                                </a></span><span id="spRevoke"  visible='OrderAccount'>
                                                    <a href="javascript:Revoke('OrderID','OrderMemID','OrderShopid')"
                                                        title="撤销整单"  visible="false">
                                                        <img src="../images/Gift/revoke.png" alt="撤单" title="撤单" />
                                                    </a></span>
                                            </label>
                                        </td>
                                    </tr>
                                    <tr style="display: none;" id="data${s.orderid}">
                                        <td colspan="15">
                                            
                                                    <div style="padding-left: 50px;">
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
                                                                    获得积分
                                                                </th>
                                                                <th>
                                                                    折后总价
                                                                </th>
                                                                <th>
                                                                	利润
                                                                </th>
                                                            </tr>
                                               <c:forEach items="${s.details}" var="sd" varStatus="dstatus">
                                                    <tr class="td" id="drDataDetailOrderID">
                                                        <td>
                                                            ${dstatus.index+1}
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
                                                            ${sd.orderdetailprice}4
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
                                                        	<td>
                                                        	1
                                                        	</td>
                                                    </tr>
                                               </c:forEach>
                                                    </table></div>
                                                
                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                           
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                        <page:page pageIndex="${orderlogFormBean.page}" pageCount="${orderlogFormBean.pages}"
                                          rowCount="${orderlogFormBean.total}" 
                           					 pageSize="${orderlogFormBean.pageSize}" 
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
   
    </form>
</body>
</html>
