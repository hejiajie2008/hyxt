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
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/StockManage/EditGoodLevel.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmGoodsClass" >
    <div class="system_Info box_right">
        <div class="system_Top">
            <div class="user_regist_title">
               主页  >  商品管理  >  商品分类  >  商品类别编辑 
            </div>
        </div>
        <%-- <div id="divSyncShopSelectPanel" style="display:none">
            <table class="table-style table-hover user_List_txt">
                
                            <tr class="th">
                                <th style="width:60px">
                                    选择
                                </th>
                                <th>
                                    店铺名称
                                </th>
                            </tr>
                        
                   
                        <tr class="td">
                            <td style="text-align: center; padding-left: 2px;">
                                <input type="checkbox"  value='" />
                            </td>
                            <td style="text-align: left; padding-left: 10px;">
                                ShopName
                            </td>
                        </tr>
                   
                <tr>
                    <td colspan="2" style="text-align: center; height: 36px">
                        <input type="button" id="btnShareShopOK" class="common_Button" style="float:inherit" value="确  认" />
                    </td>
                </tr>
            </table>
        </div>--%>
        <div id="divSyncShopSelectPanel" style="display: none">
            <table class="table-style table-hover user_List_txt">
                <tr class="th">
                    <th style="width: 60px">
                        选择
                    </th>
                    <th>
                        店铺名称
                    </th>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="height: 380px; width: 280px; overflow: auto;">
                            <table class="table-style table-hover user_List_txt">
                               
                                   
                                        <tr class="td">
                                            <td style="text-align: center; width: 58px; padding-left: 0px">
                                                <input type="checkbox"  value="ShopID" />
                                                
                                                
                                               
                                            </td>
                                            <td style="text-align: center; width: 58px; padding-left: 5px">
                                                ShopName
                                            </td>
                                        </tr>
                                   
                               
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; height: 36px">
                        <input type="button" id="btnShareShopOK" class="common_Button" style="float: inherit"
                            value="确  认" />
                    </td>
                </tr>
            </table>
        </div>
        <div class="user_regist_Allleft" id="divAddLevel">
            <div class="user_regist_left">
                <div class="user_regist_infor" style="text-align: left">
                    商品分类设置
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                    id="divGoodsClassAddOreEdit">
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>所属分类：
                        </td>
                        <td class="tableStyle_right">
                            <select id="sltGoodsClass" name="parentid"  class="selectWidth" style="float: left">
                            		<option value="-1">总分类</option>
                            	<c:forEach items="${goodsclassFormBean.rows}" var="s" varStatus="status">
                            		<option value="${s.classid }"> ${s.classname}</option>
                            	</c:forEach>
                            </select>
                            <label id="lblShowSync"  class="lbsetCk" style="vertical-align: middle;
                                float: left;">
                                &nbsp;&nbsp;
                                <input id="chkSyncOtherShop" type="checkbox"  onclick="javascript:SelectAllShop()" />
                                同步到全部店铺 &nbsp;</label>
                            <label id="lblShowSyncPartial"  class="lbsetCk" style="vertical-align: middle;
                                float: left;">
                                &nbsp;&nbsp;
                                <input id="chkSyncPartialShop" type="checkbox"  onclick="javascript:SelectPartailShop()" />
                                同步到部分店铺 &nbsp;</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>创建店铺：
                        </td>
                        <td class="tableStyle_right">
                            <select id="sltShop"  class="selectWidth" >
                             <utils:shoplist shopid="${goodsclassFormBean.goodclassshopid}"/>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>类别名称：
                        </td>
                        <td class="tableStyle_right">
                            <input type="text" id="txtClassName"  class="border_radius" name="classname" value="${goodsclass.classname}" />
                            <input type="hidden" id="txtClassID"  />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            备注：
                        </td>
                        <td class="tableStyle_right">
                            <textarea id="txtGoodsClassRemark" rows="3" name="classremark"  style="width: 90%; word-wrap: break-word;
                                outline: none; resize: none;">${goodsclass.classremark}</textarea>
                        </td>
                    </tr>
                </table>
                <div class="user_regist_infor" style="text-align: left">
                    商品分类等级折扣设置
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_left">
                            等级名称
                        </td>
                        <td class="tableStyle_right">
                            商品消费折扣设置
                        </td>
                        <td class="tableStyle_left">
                        </td>
                        <td class="tableStyle_right">
                            商品消费积分设置
                        </td>
                    </tr>
                  
                      <c:forEach items="${goodsClassList}" var="s" varStatus="status">
                      
                      <input type="hidden" name="goodsClassRabatList[${status.index}].classdiscountid" value="${goodsclass.classid}"/>
                           	<input type="hidden" name="goodsClassRabatList[${status.index}].shopid" value="1"/>
                           	<input type="hidden" name="goodsClassRabatList[${status.index}].memlevelid" value="${s.memlevelid}"/>
                           	<input type="hidden" id="levelname${status.index}" value="${s.levelname}"/>
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>
                                    ${s.levelname}
                                   
                                </td>
                                <td class="tableStyle_right">
                                    <label style="vertical-align: text-bottom;">
                                        <input   value="${s.classdiscountpercent}" 
                                             type="text" class="input_txt border_radius"
                                            id='txtDiscountPercent${status.index}' name="goodsClassRabatList[${status.index}].classdiscountpercent" />
                                        <label style="vertical-align: middle;">
                                            % <a href="#" title='即：会员在此等级时，商品消费所能享受的消费折扣'>参数说明</a>
                                        </label>
                                    </label>
                                </td>
                                <td class="tableStyle_left">
                                </td>
                                <td class="tableStyle_right">
                                    <label style="vertical-align: text-bottom;">
                                        <input  value='${s.classpointpercent}' 
                                            name="goodsClassRabatList[${status.index}].classpointpercent" type="text" class="input_txt border_radius"
                                            id="txtPointPercent${status.index}" />
                                        <label style="vertical-align: middle;">
                                            <a href="#" onclick="btnClassSave();" title='即：会员在此等级时，商品消费时自动兑换的积分比率，如：消费10元得1积分|消费20元得1积分|消费50元得1积分。' style="margin-left: 13px;">
                                                参数说明</a>
                                        </label>
                                    </label>
                                </td>
                            </tr>
                       </c:forEach>
                   
                    <tr>
                        <td colspan="4" style="text-align: center; height: 36px">
                            <input type="button"  id="btnGoodsClassSave" class="buttonColor" OnClick="savegoodsclass()"
                                value="保   存"  />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
