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
  
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" />    
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    <script src="../Scripts/Module/StockManage/GoodsLog.js" type="text/javascript"></script>
    
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>    
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
     <script src="../Scripts/fy.js" type="text/javascript"></script>
</head>
<body>


    <form id="page_form" action="GoodsLog.do" method="get" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">

                    <%--打印的次数 --%>
                    <input type="hidden" value="" id="PointNum" />


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
                                            <input type="button" id="btnRptExpenseExcel"  value="导   出" UseSubmitBehavior="false"
                                                class="common_Button" OnClick="btnRptExpenseExcel_Click"   visible="false"/>
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
                                    商品信息：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtQuery" type="text"  class="input_txt border_radius" title="账单号/商品名称" />
                                </td>
                                <td class="tableStyle_left">
                                    操作人员：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltUserID"  class="selectWidth">
                                    </select>
                                </td>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltShop"  class="selectWidth">
                                    </select>
                                    <input  id="HDsltshop"  type="hidden" />
                                </td>
                                <td class="tableStyle_right">
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    时间：
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
                                <td class="tableStyle_left">
                                    出入库类型：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltChangeType" class="selectWidth" >
                                    </select>
                                </td>
                                <td class="tableStyle_right" colspan="2">
                                    <div class="user_List_Button">
                                        <input type="button" id="btnGoodsLogQuery"  value="查   询" class="common_Button"
                                            OnClick="btnGoodsLogQuery_Click" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                            
                                    <table class="tableStyle" id="tbGoodsLog" cellspacing="0" cellpadding="2" style="width: 100%;">
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                单号
                                            </th>
                                            <th>
                                                出入库方式
                                            </th>
                                            <th>
                                                总价格
                                            </th>
                                            <th>
                                                备注
                                            </th>
                                            <th>
                                                时间
                                            </th>
                                            <th>
                                                变更店铺
                                            </th>
                                            <th>
                                                操作店铺
                                            </th>
                                            <th>
                                                操作人员
                                            </th>
                                            <th>
                                                操&nbsp;&nbsp;&nbsp;&nbsp;作
                                            </th>
                                        </tr>
                                
                                 <c:forEach items="${goodslogFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td style="width: 50px;">
                                            <Label ID="lblNumber"  Text="1"></Label>
                                        </td>
                                        <td style="text-align: left">
                                            <img id="img${s.id}" alt="" src="../Inc/Style/images/plus.gif" style="vertical-align: text-bottom"
                                                onload="javascript:IsShowPic('${s.id}','${s.type}')" />
                                            <a id="a${s.id}" href="javascript:ShowGoodsLogDetail('${s.id}','${s.type}')"
                                                title="展开/收起详情">
                                                ${s.goodsaccount}</a>
                                        </td>
                                        <td style="color: Red;">
                                            <c:choose>
													<c:when test="${s.type==1}">入库</c:when>
													<c:otherwise>未找到</c:otherwise>

												</c:choose>

											</td>
                                        <td style="text-align: right">
                                            
                                            ${s.totalprice}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.remark}
                                        </td>
                                        <td>
                                            ${s.createtime}
                                        </td>
                                        <td>
                                            ${s.changeshopname}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                           ${s.username}
                                        </td>
                                        <td class="listtd" style="width: 40px;">
                                            <a id="aPrint"   visible="false"  href='#' onclick='# string.Format(" GoodsLogPrint(\"{0}\",\"{1}\")",Eval("ID"),Eval("Type")) %>'>
                                                <img src="../images/Gift/print.png" alt="重打小票" title="重打小票" />
                                            </a><a id="aGoodsRevoke"  visible='# Convert.ToInt32(Eval("Type"))==1%>'
                                                href="#"  onclick='# string.Format("aGoodsRevoke(\"{0}\",\"{1}\")", Eval("ID"), Eval("ChangeShopID"))%>'>
                                                <img src="../images/Gift/revoke.png" alt="入库撤单" title="入库撤单" />
                                            </a>
                                        </td>
                                    </tr>
                                    <tr style="display: none;" id="data${s.id}">
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
                                                                    商品入库单价
                                                                </th>
                                                                <th>
                                                                    商品出库单价
                                                                </th>
                                                                <th>
                                                                    商品数量
                                                                </th>
                                                            </tr>
                                               
                                               <c:forEach items="${s.details}" var="sd" varStatus="dstatus">
                                                    <tr class="td" id="drDataDetail${sd.goodslogdetailid}">
                                                        <td>
                                                            <Label ID="lblDetailNumber"  >
                                                            ${dstatus.index+1 }
                                                            </Label>
                                                        </td>
                                                        <td>
                                                            ${sd.goodscode}
                                                        </td>
                                                        <td style="text-align: left">
                                                            ${sd.name}
                                                        </td>
                                                        <td style="text-align: right">
                                                            ${sd.goodsinprice}
                                                        </td>
                                                        <td style="text-align: right">
                                                            ${sd.goodsoutprice}
                                                        </td>
                                                        <td style="text-align: right">
                                                            <%--# Math.Abs(int.Parse(Eval("GoodsNumber").ToString()))%>--%>
                                                            ${sd.goodsnumber}
                                                        </td>
                                                    </tr>
                                                
                                               </c:forEach>
                                                    </table></div>
                                               
                                            
                                        </td>
                                    </tr>
                               
                            </c:forEach>
                        </table>
                        <div class="user_List_page">
                        <page:page pageIndex="${goodslogFormBean.page}" pageCount="${goodslogFormBean.pages}"
                                          rowCount="${goodslogFormBean.total}" 
                           					 pageSize="${goodslogFormBean.pageSize}" 
                           					  path="Goodslog.do" param="type=1"/>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <Label ID="lblPrintTitle" Style="display: none"  Text="Label"></Label>
    <Label ID="lblPrintFoot" Style="display: none"  Text="Labe2"></Label>
    
       <jsp:include  page="../Controls/QuickSearch.jsp"/>
    </form>
</body>
</html>
