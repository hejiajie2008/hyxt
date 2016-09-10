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
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />    
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/StockManage/GoodsIn.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script type=text/javascript src="../Scripts/Module/Report/Print.js"></script>
</head>
<body>
    <form id="frmGoodsIn" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <%--打印的次数 --%>
                    <input type="hidden" value="1" id="PointNum"  />
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title/>
                        </div>
                    </div>
                    <div class="user_List_All">
                        <table style="width: 44.5%; height: 100%; border: 1px #6eb5fb solid; text-align: center;
                            float: left;" cellpadding="0" cellspacing="0">
                            <tr>
                                <td class="tableStyle_left">
                                    商品名称或简码：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" id="txtGoodsCode" style="width: 120px;" class="border_radius"
                                        onkeypress="getKey();" />
                                    <div class="user_List_Button">
                                        <input type="button" value="搜索" class="common_Button button_style" id="btnGoodsSearch"
                                             />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    扫描枪快速定位：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" id="txtCode" style="width: 120px" class="border_radius" />&nbsp;&nbsp;
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="tab-body">
                                        <div class="tab-pal">
                                            <table class="table-style table-hover" style="width: 100%">
                                                <thead class="thead">
                                                    <tr class="th">
                                                        <th>
                                                            商品名称
                                                        </th>
                                                        <th>
                                                            商品编码
                                                        </th>
                                                        <th>
                                                            参考进价
                                                        </th>
                                                        <th>
                                                            商品库存
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody id="tbGoodsProduct">
                                                    <tr class="td">
                                                        <td colspan="4" style="height: 25px; text-align: center; line-height: 25px; background-color: #FFF;">
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="page_detail">
                                    <div id="GoodsProductPage" style="margin: 0px; border: solid 1px #ccc; height: 30px;">
                                        <div class="listTablePage_simple">
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="background: #e0f0ff; height: 26px; border-top: 1px solid #adadad;
                                    color: #d38117;">
                                    点击商品即可轻松选定，同时也可以通过简码、名称进行搜索或条码直接定位！
                                </td>
                            </tr>
                        </table>
                        <table style="width: 55%; height: 100%; border: 1px #6eb5fb solid; text-align: center;
                            float: right;" cellpadding="0" cellspacing="0">
                            <tr>
                                <td class="tableStyle_left">
                                    入库单号：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="spGoodsAccounte"  style="font-size: 14px; font-weight: bold;"><utils:order type="3"/></label>
                                </td>
                                <td class="tableStyle_left">
                                    操作人员：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="lblUSer"  style="font-size: 14px; font-weight: bold;">
                                    <shiro:principal/>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    入库日期：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtCreteTime" type="text" class="Wdate border_radius"  />
                                </td>
                                <td class="tableStyle_left">
                                    入库店铺：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltShop"  class="selectWidth">
                                    	<utils:shoplist shopid="${shopid}"/>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <table class="table-style user_List_txt" style="width: 100%">
                                        <thead class="thead">
                                            <tr class="th">
                                                <th>
                                                    商品名称
                                                </th>
                                                <th>
                                                    入库价格
                                                </th>
                                                <th>
                                                    入库数量
                                                </th>
                                                <th>
                                                    单项合计
                                                </th>
                                                <th>
                                                    操&nbsp;作
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody id="tbOrderTable">
                                            <tr class="td">
                                                <td colspan="5" style="height: 25px; text-align: center; line-height: 25px; background-color: #FFF;">
                                                    &nbsp;&nbsp;&nbsp;&nbsp;请点击左侧商品列表，选择需要入库的商品！
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    入库总数量：
                                </td>
                                <td class="tableStyle_right">
                                    <div class="sum_num">
                                        <label id="lblTotalNumber"  style="font-size: 14px; font-weight: bold;">
                                        </label>
                                    </div>
                                </td>
                                <td class="tableStyle_left">
                                    入库总金额：
                                </td>
                                <td class="tableStyle_right">
                                    <div class="sum_num">
                                        <label id="lblTotalMoney"  style="font-size: 14px; font-weight: bold;">
                                        </label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    入库备注：
                                </td>
                                <td colspan="5" class="tableStyle_right">
                                    <input type="text" id="txtExRemark" class="border_radius border_radius4" maxlength="50" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="5" style="text-align: center; height: 36px">
                                    <div class="submit_detail" style="text-align: center">
                                        <% if(com.jfxy.listener.MemoryListener.sysparameter.getAutoprint()==1)
                                           {%>
                                        <Label style="vertical-align: text-bottom;">
                                            <Label class="lbsetCk" style="vertical-align: middle;">
                                                <input id="chkPrint"  type="checkbox" />
                                                打印小票</Label></Label>&nbsp;&nbsp;
                                        <% } %>
                                        <input id="btnGoodsSave" type="button" class="buttonColor" value="马上入库" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <Label id="lblPrintTitle" Style="display: none"  Text="Label"></Label>
                    <Label id="lblPrintFoot" Style="display: none"  Text="Labe2"></Label>
                </div>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
