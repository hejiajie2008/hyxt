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
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
        <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    
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
    <form  id="page_form" action="RptPointRankList.do"  >
    
    
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
                                            <input type="button" ID="btnPointRankExcel"  value="导   出" class="common_Button"
                                                OnClick="btnPointRankExcel_Click" visible="false" />
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
                                    会员等级：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltMemLevelID"  class="selectWidth">
                                    	<utils:memlevel levelid="0"/>
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
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" id="btnUserSearch"  value="查   询" class="common_Button"
                                            OnClick="btnUserSearch_Click" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                           
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                积分
                                            </th>
                                            <th>
                                                会员卡号
                                            </th>
                                            <th>
                                                会员姓名
                                            </th>
                                            <th>
                                                消费总金额
                                            </th>
                                            <th>
                                                会员储存金额
                                            </th>
                                            <th>
                                                会员等级
                                            </th>
                                            <th>
                                                所属店铺
                                            </th>
                                        </tr>
                                    
                                <c:forEach items="${memFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                            <label id="lblNumber"  >${status.index+1 }</label>
                                        </td>
                                        <td style="text-align: right; color: Red">
                                            ${s.mempoint}
                                        </td>
                                        <td>
                                            ${s.memcard}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.memname}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.memconsumemoney}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.memmoney}
                                        </td>
                                        <td>
                                            ${s.levelname}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                    </tr>
                             </c:forEach>
                        </table>
                        <div class="user_List_page">
                             <page:page pageIndex="${memFormBean.page}" pageCount="${memFormBean.pages}"
                                          rowCount="${memFormBean.total}" 
                           					 pageSize="${memFormBean.pageSize}" 
                           					  path="ExpenseHistory.do" param="PID=100"/>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <jsp:include page="../Controls/QuickSearch.jsp"/>
    </form>
</body>
</html>
