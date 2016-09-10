<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/StockManage/GoodsClass.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmGoodsClass" >
    <input type="hidden" id="share"  />
    
   
    
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td style="width: 100%;">
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
                                            <input id="Button1" type="button" value="新增类别" class="common_Button" 
                                                onclick="javascript:GoodsClassAdd(0)"  visible="false" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                            class="tableStyle">
                            <tr>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right" style="width: 500px;">
                                  <%--  <select id="sltShopList"  class="selectWidth" />--%>
                                  
                                         <select id="sltShop"  class="selectWidth">
                                         	<utils:shoplist shopid="${goodsclassFormBean.goodclassshopid}"/>
                                        </select>
                                         

                                         <input  id="HDsltshop"  type="hidden" />
                                         <input id="HDsshopid" name="goodclassshopid" type="hidden" value="${goodsclassFormBean.goodclassshopid}"/>
                                         

                                </td>
                                <td class="tableStyle_right">
                                    <input  id="btnGoodsClassQuery" type="submit"  value="查   询" class="common_Button common_ServiceButton"
                                        OnClick="btnGoodsClassQuery_Click" />
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                            
                                        <tr class="th">
                                            <th>
                                                类别名称
                                            </th>
                                            <th>
                                                类别备注
                                            </th>
                                            <%--                                            <th>
                                                商品折扣说明
                                            </th>--%>
                                            <th>
                                                详细操作
                                            </th>
                                        </tr>
                                    <c:forEach items="${goodsclassFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td style="text-align: left; padding-left: 2px;">
                                            ${s.classname}
                                        </td>
                                        <td style="text-align: left; padding-left: 2px;">
                                            ${s.classremark}
                                        </td>
                                        <%--                                        <td  id="tdDiscoundExplanation" style="word-break: keep-all; white-space: nowrap;
                                            overflow: hidden; text-overflow: ellipsis; width: 50%; text-align: left; padding-left: 2px;">
                                        </td>--%>
                                        <td class="listtd" style="width: 90px;">
                                            <a  visible="false" id="ClassEdit"  href='#' onclick='GoodsClassEdit(${s.classid},1) '>
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" /></a>
                                                <a id="ClassSync"  visible="false"  href='#' onclick='GoodsClassSync(ClassID,CurShopID)'>
                                                <img src="../images/Gift/system.png" alt="共享到所有店铺" title="共享到所有店铺" /></a>
                                                 <a visible="false"  id="ClassDel" 
                                                    href='#' onclick='GoodsClassDel("${s.classname}",${s.classid},1)'>
                                                    <img src="../images/Gift/del.png" alt="删除" title="删除" /></a>
                                        </td>
                                    </tr>
                               </c:forEach>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
    </table>
   <jsp:include  page="../Controls/QuickSearch.jsp"/>
    </form>
</body>
</html>
