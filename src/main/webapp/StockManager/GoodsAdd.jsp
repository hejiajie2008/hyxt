<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
    <title>商品登记</title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    
    <link href="../Inc/Style/uploadify.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.uploadify.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.uploadify.swfobject.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/StockManage/GoodsInfo.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript">
    </script>
</head>
<body>
    <form id="frmGoodsAdd" >
    <div class="system_Info box_right">
        <div class="system_Top">
            <div class="user_regist_title">
                <utils:title/>
            </div>
        </div>
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
                        <div style="height: 380px; width:280px; overflow:scroll;">
                            <table class="table-style table-hover user_List_txt">
                                
                                        <tr class="td">
                                            <td style="text-align: center; width: 58px; padding-left: 0px">
                                                <input type="checkbox" name="SyncShop" value="1" />
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
        <div class="user_regist_Allleft">
            <div class="user_regist_left">
                <div class="user_regist_infor">
                    商品信息
                </div>
                <table width="720" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                    class="tableStyle">
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>商品编码：
                        </td>
                        <td colspan="3" class="tableStyle_right">
                            <input id="txtGoodsCode" name="goodscode" type="text"  class="border_radius" 
                             title="商品编号是唯一的,有条件的商家最好使用商品条码编号"
                                maxlength="25"  />
                            <input id="txtGoodsID" type="hidden" name="goodsid" value="${goodsinfo.goodsid}"  />
                            <input id="txtCode" type="hidden" value="${goodsinfo.goodscode}" />
                            <%--                            <label id="lblAutoGoodsCode"  style="vertical-align: text-bottom;">
                                &nbsp;&nbsp;
                                <label class="lbsetCk" style="vertical-align: middle;">
                                    <input id="chkAutoGoodsCode" type="checkbox" />
                                    自动创建商品编码</label>
                                
                            </label>--%>
                            <label for="chkService" style="vertical-align: text-bottom;">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label class="lbsetCk" style="vertical-align: middle;">
                                    <input id="chkService" type="checkbox" name="goodstype"  ${goodsinfo.goodstype==1?"checked":""}  />
                                    服务项目</label></label>
                            <label for="chkSyncOtherShop" style="vertical-align: text-bottom;">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label id="lblShowSync"  class="lbsetCk" style="vertical-align: middle;" visible="false" >
                                    <input id="chkSyncOtherShop" type="checkbox"  onclick="javascript:SelectAllShop()"  />
                                    同步到所有店铺</label></label>
                            <label for="chkSyncPartialShop" style="vertical-align: text-bottom;">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <label id="lblShowSyncPartial"  class="lbsetCk" style="vertical-align: middle;" visible="false">
                                    <input id="chkSyncPartialShop" type="checkbox"  onclick="javascript:SelectPartailShop()"   />
                                    同步到部分店铺</label></label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>商品名称：
                        </td>
                        <td class="tableStyle_right" style="width: 270px">
                            <input id="txtGoodsName" name="name" value="${goodsinfo.name}" type="text" class="border_radius"  title="请输入商品名称"
                                maxlength="20" />
                        </td>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>商品简码：
                        </td>
                        <td class="tableStyle_right" style="width: 270px">
                            <input id="txtGoodsNameCode" name="namecode" value="${goodsinfo.namecode}" type="text" class="border_radius"  title="请输入商品简码"
                                maxlength="20" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            商品分类：
                        </td>
                        <td class="tableStyle_right">
                            <select id="sltGoodsClass" name="goodsclassid"  class="selectWidth">
                            	<c:forEach items="${goodsclassFormBean.rows}" var="s" varStatus="status">
                            		<c:choose>
		                                        	<c:when test="${s.classid==goodsinfo.goodsclassid}">
		                                        		<option value="${s.classid }" selected = "selected">${s.classname } </option>
		                                        	</c:when>
	                                        		
	                                        		<c:otherwise>
	                                        			<option value="${s.classid }">${s.classname }</option>
	                                        		</c:otherwise>
	                                        		
	                                </c:choose>
                            			
                            	</c:forEach>
                            </select>
                        </td>
                        <td class="tableStyle_left">
                            计量单位：
                        </td>
                        <td class="tableStyle_right">
                            <select id="sltjldw" name="unit"  class="selectWidth">
                            	<utils:unitlist/>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>零售单价：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtGoodsPrice" name="price" value="${goodsinfo.price }" type="text"  class="border_radius" maxlength="10" value="0" title="商品销售零售单价 最小值0.01 最大值 9999999.99" />
                        </td>
                        <td class="tableStyle_left">
                            参考进价：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtGoodsBidPrice" name="goodsbidprice" type="text" value="${goodsinfo.goodsbidprice}"  class="border_radius" title="商品入库时使用参考进价 最小值0.01 最大值 9999999.99"   maxlength="10" value="0"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            特价折扣：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtGoodsSalePercent" type="text" name="salepercet" value="${goodsinfo.salepercet==null?0:goodsinfo.salepercet}"  class="border_radius"
                                title="输入特价折扣，则商品消费时商品折扣按照（商品拥有的特价折扣和会员拥有的登记折扣两者较低的那个）计算,输入1则此商品不打折,输入0，则按照会员折扣计算"
                                 />
                        </td>
                        <td class="tableStyle_left">
                            最低折扣：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtGoodsMinPercent" type="text" name="minpercent" value="${goodsinfo.minpercent}" class="border_radius" title="输入最低折扣，则商品消费时商品折扣按照（商品拥有的特价折扣和会员拥有的登记折扣两者较高的那个）计算,输入1则此商品不打折,输入0，则按照会员折扣计算。保价折扣"
                                value="0" />
                        </td>
                    </tr>
                    <tr id="trCommission" >
                        <td class="tableStyle_left">
                            提成类型：
                        </td>
                        <td class="tableStyle_right">
                            <select id="sltCommissionType" name="commissiontype"  class="selectWidth">
                                <option selected="selected" value="0">===== 请选择 =====</option>
                                <option value="1">按商品固定比例提成</option>
                                <option value="2">按商品固定金额提成</option>
                            </select>
                        </td>
                        <td class="tableStyle_left">
                            <span id="spCommission">提成系数：</span>
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtCommissionNumber" type="text" name="commissionnumber" value="${goodsinfo.commissionnumber}"  class="border_radius"
                                value="0" title="通过商品的提成类型，输入提成的规则。" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            所属店铺：
                        </td>
                        <td class="tableStyle_right">
                            <select id="sltShopList" name="createshopid"  class="selectWidth">
                            	<option value="0">总公司</option>
                            </select>
                            <input id="txtShopID"  type="hidden" />
                        </td>
                        <td class="tableStyle_left">
                            积分数量：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtGoodsPoint" type="text" name="point" value="${goodsinfo.point}" class="border_radius" title="输入积分数量，则商品消费时获得的积分按照商品拥有的积分计算；如果积分数量为0，按照商品的折后价格*会员的积分比例计算积分，如果积分数量为空，则该商品不积分"
                                value="0" />
                        </td>
                    </tr>
                    <tr id="trGoodsNumber"  style="display: none">
                        <td class="tableStyle_left">
                            商品库存：
                        </td>
                        <td class="tableStyle_right" colspan="3">
                            <input id="txtGoodsNumber" type="text" name="goodsnumber"  class="border_radius" title="商品的库存数量" />
                            <input id="hdShopID" type="hidden"  />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            商品简介：
                        </td>
                        <td class="tableStyle_right" colspan="3">
                            <textarea id="txtGoodsRemark" rows="3" name="goodsremark" style="width: 90%; word-wrap: break-word;
                                outline: none; resize: none;" title="请输入商品简介">${goodsinfo.goodsremark}</textarea>
                        </td>
                    </tr>
                </table>
                <div class="user_regist_left">
                    <div class="user_regist_infor">
                        商品自定义属性
                    </div>
                    <table width="720" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                        class="tableStyle">
                       
                            <utils:customfield type="1" map="${goodsinfo.map}"/>
                        
                    </table>
                    <div style="text-align: center; height: 36px">
                        <input id="btnGoodsSave" type="button" class="buttonColor" value="保　存" />
                        <input id="btnGoodsReset" type="button" class="buttonRest" value="重　置" />
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
