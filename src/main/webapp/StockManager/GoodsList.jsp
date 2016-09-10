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

    <script src="../Scripts/Module/StockManage/GoodsList.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
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
    <form id="page_form" action="GoodsList.do" method="get" >
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
                                            <input type="button" id="btnOut"  value="导   出"  UseSubmitBehavior="false"   visible="false"  class="common_Button" OnClick="btnOut_Click" />
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
                                    <input id="txtQueryGoods" type="text"  class="border_radius radius2"
                                        title="商品名称/编码/简码" />
                                </td>
                                <td class="tableStyle_left">
                                    自定义属性：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltCustomField"  class="selectWidth">
                                    </select>
                                </td>
                                <td class="tableStyle_left">
                                    属性值：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtCustomField" type="text"  class="border_radius radius2" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    商品分类：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltGoodsClass" name="sltGoodsClass" class="selectWidth" />
                                    <input id="txtGoodsClass"  type="hidden" />
                                </td>
                                <td class="tableStyle_left">
                                    商品类型：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltGoodsType" name="goodstype" class="selectWidth">
                                        <option selected="selected" value="">===== 请选择 =====</option>
                                        <option value="0">普通商品</option>
                                        <option value="1">服务商品</option>
                                    </select>
                                </td>
                                <td class="tableStyle_left">
                                    商品单价：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltGoodsPriceSymbols"  style="height: 25px; outline: none;
                                        resize: none;">
                                        <option selected="selected" value="&gt;=">>=</option>
                                        <option value="&lt;="><=</option>
                                        <option value="=">=</option>
                                    </select>
                                    <input id="txtGoodsPrice" type="text" style="float: none; width: 60px;" 
                                        class="Wdate border_radius" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right">
                                   <%-- <select id="sltShopList"  class="selectWidth"  />--%>

                                      <select id="sltShop"  class="selectWidth" autocomplete="off">
                                        </select>
                                  <input  id="HDsltshop"  type="hidden" />
                                                 
                                </td>
                                <td colspan="3">
                                </td>
                                <td class="tableStyle_right" colspan="4">
                                    <div class="user_List_Button">
                                        <input type="button" id="btnGoodsListQuery"  value="查   询" class="common_Button"
                                            OnClick="btnGoodsListQuery_Click" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                            <thead class="thead">
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
                                        商品简码
                                    </th>
                                    <th>
                                        商品类型
                                    </th>
                                    <th>
                                        计量单位
                                    </th>
                                    <th>
                                        商品单价
                                    </th>
                                    <th>
                                        所属分类
                                    </th>
                                   <utils:customTable type="1"/>
                                    <th>
                                        操作
                                    </th>
                                </tr>
                            </thead>
                          <c:forEach items="${goodsFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                           ${status.index+1}
                                           
                                        </td>
                                        <td>
                                            ${s.goodscode}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.name}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.namecode}
                                        </td>
                                        <td>
                                            ${s.goodstype==0?"普通商品":"<span style='color:red;'>服务商品</span>"}
                                        </td>
                                        <td>
                                            ${s.unit}
                                        </td>
                                        <td style="text-align: right;">
                                          ${s.price}
                                        </td>
                                        <td>
                                            ${s.classname}
                                        </td>
                                       <utils:customTable type="1" map="${s.map }"/>
                                        <td class="listtd" style="width: 90px;">
                                            <a href='GoodsAdd.do?PID=61&goodsid=${s.goodsid}'
                                                  visible="false" id="hyEdit">
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                            </a><a href="#" onclick='SyncGoods(GoodsID,CurShopID)'
                                                id="hySync"   visible="false">
                                                <img src="../images/Gift/system.png" alt="同步到所有店铺" title="同步到所有店铺" />
                                            </a><a href="#" onclick='DeleteGoods(${s.goodsid},1)'
                                                id="hyDel"   visible="false" >
                                                <img src="../images/Gift/del.png" alt="删除" title="删除" />
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                         <page:page pageIndex="${goodsFormBean.page}" pageCount="${goodsFormBean.pages}"
                                          rowCount="${goodsFormBean.total}" 
                           					 pageSize="${goodsFormBean.pageSize}" 
                           					  path="GoodsList.do" param="type=1"/>
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
