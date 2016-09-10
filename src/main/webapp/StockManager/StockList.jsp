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
     <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />

  
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/StockManage/StockList.js" type="text/javascript"></script>
     <script src="../Scripts/fy.js" type="text/javascript"></script>
    <style type="text/css">
        .fenye
        {
            background-position: initial initial;
            background-repeat: initial initial;
        }
        .mytree
        {
        }
        .mytree img
        {
            padding-right: 4px;
        }
    </style>
</head>
<body>
	<!-- id="frmStaffList" -->
    <form  id="page_form" action="StockList.do" method="get">
    <input type="hidden" id="otherStock"  />
    <Label  ID="lbValue" Visible="false"></Label>
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
                                <tr>
                                    <td class="user_List_styleLeft">
                                        快速查找：
                                    </td>
                                    <td class="user_List_styleRight" style="text-align: left;">
                                        <input id="txtQuery" type="text" title=" 商品编码 / 姓名 / 简码" class="border_radius"  onkeypress="getKey()"  
                                            style="float: left;" />&nbsp;
                                        <input type="button" id="btnUserSearch"  value="查   询" class="common_Button common_ServiceButton"
                                            OnClick="btnUserSearch_Click" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="main" style="width: 100%;">
                            <div id="main_left" style="width: 15%; float: left; vertical-align: top; text-align: left;">
                                <div id="StockList_ClassTree">
                                    <asp:TreeView  ID="tvGoodsClass" CssClass="mytree" NoExpandImageUrl="~/images/ico/dot.gif"
                                        CollapseImageUrl="~/images/ico/open.png" ExpandImageUrl="~/images/ico/close.png"
                                        Width="20" ForeColor="#4f4e4e"  OnSelectedNodeChanged="tvGoodsClass_SelectedNodeChanged"
                                        Font-Bold="False" ExpandDepth="1">
                                        <LevelStyles>
                                            <asp:TreeNodeStyle HorizontalPadding="0" VerticalPadding="0" ChildNodesPadding="1"
                                                Font-Size="13px" />
                                        </LevelStyles>
                                    </asp:TreeView>
                                </div>
                            </div>
                            <div id="main_right" style="float: left; width: 85%;">
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 100%;" class="table-style table-hover user_List_txt">
                                    
                                            
                                                <tr class="th">
                                                    <th style="width: 20%;">
                                                        商品编码
                                                    </th>
                                                    <th>
                                                        商品名称
                                                    </th>
                                                    <th style="width: 20%;">
                                                        商品简码
                                                    </th>
                                                    <th style="width: 20%;">
                                                        库存数量
                                                    </th>
                                                    <th>
                                                        操作
                                                    </th>
                                                </tr>
                                            
                                       
                                       <c:forEach items="${goodsFormBean.rows}" var="s" varStatus="status">
                                            <tr class="td">
                                                <td align="left">
                                                    ${s.goodscode}
                                                </td>
                                                <td style="text-align: left">
                                                    ${s.name}
                                                </td>
                                                <td style="text-align: left">
                                                    <b>${s.namecode}</b>
                                                </td>
                                                <td style="text-align: right">
                                                    ${s.goodsnumber}
                                                </td>
                                                <td class="listtd" style="width: 40px;">
                                                    <a    id="aStock" href="#" onclick='GetGoodsAllStock(\"{0}\",\"{1}\")", Eval("GoodsID"), Eval("Name"))%>'>
                                                        <img src="../images/Gift/show.png" alt="查看异店库存" title="查看异店库存" />
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                       
                                    <tr>
                                        <td colspan="5" style="line-height: 30px; height: 30px; padding-top: 5px;">
                                       
                                            <page:page pageIndex="${goodsFormBean.page}" pageCount="${goodsFormBean.pages}"
                                          rowCount="${goodsFormBean.total}" 
                           					 pageSize="${goodsFormBean.pageSize}" 
                           					  path="StockList.do" param="type=1"/>
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
    <table id="tbAllStock" border="0" cellpadding="0" cellspacing="1" class="table-style table-hover user_List_txt"
        width="600px" style="display: none">
        <tr>
            <td>
                <script type="text/javascript">
                    ListLoading();
                </script>
            </td>
        </tr>
    </table>
    <input id="shopID" type="hidden"  />
    </form>
</body>
</html>
