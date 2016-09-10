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
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/RptMemCount.js" type="text/javascript"></script>
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
    <form id="frmRptMemCount" >
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
                                            <input type="button"  ID="btnMemCountExcel"  OnClientClick="return btQuery();"
                                                OnClick="btnMemCountExcel_Click" value="导   出" class="common_Button"  visible="false" />
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
                                    充次单号：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtCountAccount" type="text"  class="border_radius radius2"
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
                                      <input  id="HDsltshop"  type="hidden" />
                                </td>
                                <td class="tableStyle_left">
                                    充次金额：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltMoney"  style="height: 25px; outline: none; resize: none;">
                                        <option selected="selected" value="&gt;=">>=</option>
                                        <option value="&lt;="><=</option>
                                        <option value="=">=</option>
                                    </select>
                                    <input id="txtMoney" type="text"  class="border_radius radius2" style="width: 60px;
                                        float: none; clear: both;" />
                                </td>
                            </tr>
                            <tr>
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
                                <td style=" border:none">
                                </td>
                                <td class="tableStyle_right" style=" border:none">
                                    <div class="user_List_Button">
                                        <input type="button"  ID="btnRptMemCountQuery" OnClientClick="return btQuery();" 
                                            value="查   询" class="common_Button" OnClick="btnRptMemCountQuery_Click" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="tableStyle" id="tbtongji" style="width: 100%;">
                            <tr>
                                <th align="left">
                                    &nbsp;&nbsp;&nbsp;&nbsp; <font color="#00000">会员充次统计：<b>充次总金额： <font color="red">
                                        <label id="lblMoney">0</label></font>元,&nbsp;&nbsp;折后总金额：
                                        <font color="red">
                                            <label id="lblDiscountMoney">0</label></font>元,&nbsp;&nbsp;充次总积分：
                                        <font color="red">
                                            <label id="lblTotalPoint">0</label></font>元,&nbsp;&nbsp;充次总次数：
                                        <font color="red">
                                            <label id="lblToalCount">0</label></font>次
                                    </font>,&nbsp;&nbsp;剩余总次数： <font color="red">
                                        <label id="lblRemainCount">0</label></font>次
                                    </font>
                                </th>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                           
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                充次单号
                                            </th>
                                            <th>
                                                会员卡号
                                            </th>
                                            <th>
                                                会员姓名
                                            </th>
                                            <th>
                                                充次金额
                                            </th>
                                            <th>
                                                折后金额
                                            </th>
                                            <th>
                                                所得积分
                                            </th>
                                            <th>
                                                充次备注
                                            </th>
                                            <th>
                                                充次店铺
                                            </th>
                                            <th>
                                                充次时间
                                            </th>
                                            <th>
                                                操作员
                                            </th>
                                        </tr>
                                   
                              
                                <c:forEach items="${memcountFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td style="width: 50px;">
                                            <label id="lblNumber">${status.index+1}</label>
                                        </td>
                                        <td style="text-align: left">
                                            <img id="img${s.countid}" alt="" src="../Inc/Style/images/plus.gif"
                                                style="vertical-align: text-bottom" onload="javascript:IsShow('${s.countid}','3')" />
                                            <a href="javascript:ShowDetail('${s.countid}','3')" title="展开/收起详情">
                                                ${s.countaccount}</a>
                                        </td>
                                        <td>
                                            ${s.memcard}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.memname}
                                        </td>
                                        <td style="text-align: right; color: Red">
                                            ${s.counttotalmoney}
                                        </td>
                                        <td style="text-align: right; color: Red">
                                           ${s.countdiscountmoney}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.countpoint}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.countremark}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${s.countcreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                    </tr>
                                   
                                    <tr style="display: none;" id="data${s.countid}">
                                        <td colspan="10">
                                           
                                                    <div style="padding-left: 55px;">
                                                        <table class="table-style table-hover user_List_txt" cellspacing="0" cellpadding="2"
                                                            style="width: 50%;">
                                                            
                                                                <tr class="th">
                                                                    <th>
                                                                        序号
                                                                    </th>
                                                                    <th>
                                                                        服务项目
                                                                    </th>
                                                                    <th>
                                                                        次数
                                                                    </th>
                                                                    <th>
                                                                        实付金额
                                                                    </th>
                                                                    <th>
                                                                        所得积分
                                                                    </th>
                                                                </tr>
                                                            
                                                 <c:forEach items="${s.details}" var="ds" varStatus="dstatus">
                                                    <tr class="td">
                                                        <td>
                                                            <label id="lblDetailNumber">${dstatus.index+1}</label>
                                                        </td>
                                                        <td>
                                                            ${ds.name}
                                                        </td>
                                                        <td>
                                                            ${ds.countdetailtotalnumber}
                                                            <td>
                                                                ${ds.countdetaildiscountmoney}
                                                            </td>
                                                            <td>
                                                                ${ds.countdetailpoint}
                                                            </td>
                                                    </tr>
                                                </c:forEach>
                                                    </table> 
                                               </div>
                                              
                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                        <page:page pageIndex="${memcountFormBean.page}" pageCount="${memcountFormBean.pages}" rowCount="${memcountFormBean.total}" 
                           					 pageSize="${memcountFormBean.pageSize}" 
                           					  path="RptMemCount.do" param="type=1"/>
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
