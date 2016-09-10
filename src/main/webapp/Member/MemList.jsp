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
    <script src="../Scripts/Module/Mem/MemList.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
 	<script src="../Scripts/fy.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Area.js" type="text/javascript"></script>
</head>
<body style="padding-right: 1px">
    <form id="page_form" action="memList.do" method="get" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7" >
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                          <utils:title/>
                        </div>
                    </div>
                    <div class="user_List_All">
                        <div class="user_List_top" style="height: 67px;">
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr style="color: #333333; background-color: #F7F6F3;">
                                    <td class="user_List_styleLeft" style="width: 10%">
                                        快速查找：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <input id="txtQueryMem"  type="text" class="border_radius radius2"
                                            title="请输入卡号/卡面号码/姓名/手机号" maxlength="20" />
                                        <div class="user_List_Button">
                                           <input id="btnMemListQuery" type="submit" value="查   询" class="common_Button"
                                                 />
                                            <input id="btnhigthSearch" type="button" class="common_Button" value="高级查询" />
                                            
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="user_List_styleLeft">
                                        快捷操作：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <div class="user_List_Button">
                                            <input id="btnMemRecharge"  cls="4" type="button" class="common_Button"
                                                value="会员充值"  visible="false" />
                                            <input id="btnMemChangeCard"  cls="6" type="button" class="common_Button"
                                                value="会员换卡"  visible="false" />
                                            <input id="btnMemDelay"  cls="7" type="button" class="common_Button"
                                                value="会员延期"  visible="false" />
                                            <input id="btnMemLock"  cls="8" type="button" class="common_Button"
                                                value="挂失锁定"   visible="false"/>
                                            <input id="btnMemChangePwd" cls="9"  type="button" class="common_Button"
                                                value="修改密码"  visible="false" />
                                            <input id="btnMemDrawMoney" cls="10"  type="button" class="common_Button"
                                                value="帐户提现"  visible="false"/>
                                            <input id="btnSenndSMS" cls="46"  type="button" class="common_Button"
                                                value="发送短信"  visible="false" />
                                            <input id="btnMemPointReset"  type="button" class="common_Button" value="积分清零"  visible="false" />
                                            <input id="btnAllMemPointReset"  type="button" class="common_Button"
                                                value="全分清零" visible="false" />
                                            <input id="btnCoupon"  type="button" class="common_Button" value="发优惠券"  visible="false" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        
                        <div id="divCoupon" style='display: none; width: 600px; height: 300px'>
                            <table class="tableStyle">
                                <tr>
                                    <th style="text-align: center; font-weight: bold; height: 25px" class="th" colspan="4">
                                        优惠券信息
                                    </th>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        优惠券名称：
                                    </td>
                                    <td class="tableStyle_right" colspan="3">
                                        <select id="sltCoupon"  class="selectWidth" onchange="CouponChange();">
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        优惠有效期：
                                    </td>
                                    <td class="tableStyle_right" colspan="3">
                                        <Label id="lblCouponTime" >永久有效</Label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        最低消费：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblCouponMinMoney"  >0</Label>&nbsp;
                                    </td>
                                    <td class="tableStyle_left">
                                        单日限用：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblCouponDayNum"  >0</Label>&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        已发数量：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblCouponYF"  >0</Label>&nbsp;
                                    </td>
                                    <td class="tableStyle_left">
                                        剩余数量：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblCouponNu" >0</Label>&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <th style="text-align: center; font-weight: bold; height: 25px" class="th" colspan="4">
                                        会员信息
                                    </th>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        已选会员：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblChoosedMem"  >0</Label>&nbsp;
                                    </td>
                                    <td class="tableStyle_left">
                                        挂失锁定会员：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblLockMem"  >0</Label>&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        无手机号码：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblNoMobile" >0</Label>&nbsp;
                                    </td>
                                    <td class="tableStyle_left">
                                        预发会员数量：
                                    </td>
                                    <td class="tableStyle_right">
                                        <Label id="lblSendNumber"  >0</Label>&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4" align="center">
                                        <input type="button" id="btnSendCoupon"  value="发送" class="buttonColor" />
                                        <input type="button" id="btnCloseCoupon"  value="关闭" class="buttonRest" />
                                        <input id="counponType" type="hidden" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="divHightSearch" style='${memFormBean.isShow==0?"display: none;":""}'>
                            <table class="tableStyle" style="width: 100%;">
                                <tr>
                                    <td class="tableStyle_left">
                                        会员等级：<input type="hidden" id="isShow" name="isShow" value="${memFormBean.isShow}"/>
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemLevelID" name="memlevelid" class="selectWidth">
                                        	<c:forEach items="${memlevelList}" var="s" varStatus="status">
	                                        	<c:choose>
		                                        	<c:when test="${memFormBean.memlevelid==s.levelid}">
		                                        		<option value='${s.levelid}' selected = "selected">${s.levelname} </option>
		                                        	</c:when>
	                                        		
	                                        		<c:otherwise>
	                                        			<option value='${s.levelid}'>${s.levelname} </option>
	                                        		</c:otherwise>
	                                        		
	                                        	</c:choose>
                                        		
                                        	</c:forEach>
                                        	
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        所属店铺：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltShop" name="memshopid"  class="selectWidth" name="D8">	
                                        	<utils:shoplist shopid="${memFormBean.memshopid }"/>
                                        </select>
                                        
                                    </td>
                                    <td class="tableStyle_left">
                                        会员积分：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemPoint"  name="D7" style="outline: none;">
                                            <option selected="selected" value="&gt;=">>=</option>
                                            <option value="&lt;="><=</option>
                                            <option value="=">=</option>
                                        </select>
                                        <input id="txtMemPoint" type="text"  class="border_radius" style="width: 100px;
                                            clear: both; float: none" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        办卡人员：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemUserID"  class="selectWidth" name="D6">
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        生日会员：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemBirthday"  class="selectWidth" name="D3">
                                            <option value="">===== 请选择 =====</option>
                                            <option value="0">本日生日会员</option>
                                            <option value="1">本周生日会员</option>
                                            <option value="2">本月生日会员</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        会员余额：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemMoney"  style="outline: none;">
                                            <option selected="selected" value="&gt;=">>=</option>
                                            <option value="&lt;="><=</option>
                                            <option value="=">=</option>
                                        </select>
                                        <input id="txtMemMoney" type="text"  class="border_radius" style="width: 100px;
                                            clear: both; float: none" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        会员状态：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemState"  class="selectWidth" name="D1">
                                            <option value="">===== 请选择 =====</option>
                                            <option value="0">正常</option>
                                            <option value="1">锁定</option>
                                            <option value="2">挂失</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        过期时间：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemPastTime"  class="selectWidth" name="D2">
                                            <option value="">===== 请选择 =====</option>
                                            <option value="0">已过期</option>
                                            <option value="1">未来7天</option>
                                            <option value="2">未来30天</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        累计消费：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltConsumeMoney"  name="D5" style="outline: none;">
                                            <option selected="selected" value="&gt;=">>=</option>
                                            <option value="&lt;="><=</option>
                                            <option value="=">=</option>
                                        </select>
                                        <input id="txtConsumeMoney" type="text"  class="border_radius" style="width: 100px;
                                            clear: both; float: none" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        自定义属性：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltCustomField"  class="selectWidth">
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        属&nbsp;&nbsp;性&nbsp;&nbsp;值：
                                    </td>
                                    <td id="Custom" class="user_List_styleRight">
                                        <asp:Literal id="ltCustom" >
                                        </asp:Literal>
                                        <%-- <input id="txtCustomField" type="text"  class="input_txt border_radius" />--%>
                                    </td>
                                    <td class="tableStyle_left">
                                        未&nbsp;&nbsp;消&nbsp;&nbsp;费：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <select id="sltMemConsume"  class="selectWidth" name="D4">
                                            <option value="">===== 请选择 =====</option>
                                            <option value="0">三个月未消费会员</option>
                                            <option value="1">半年未消费会员</option>
                                            <option value="2">一年未消费会员</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        登记时间：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <input id="txtMemStartTime" type="text" class="Wdate border_radius"  />
                                    </td>
                                    <td class="tableStyle_left">
                                        至
                                    </td>
                                    <td class="user_List_styleRight">
                                        <input id="txtMemEndTime" type="text" class="Wdate border_radius"  />
                                    </td>
                                    <td class="tableStyle_left">
                                        推&nbsp;&nbsp;荐&nbsp;&nbsp;人：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <input id="txtMemRecommendCard" type="text"  class="border_radius"
                                            style="clear: both; float: none" />
                                    </td>
                                    <td colspan="3">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        所属区域：
                                    </td>
                                    <td colspan="5" class="user_List_styleRight" style="vertical-align: text-bottom;">
                                        
                                        <utils:area memcity="${memFormBean.memcity}" memcounty="${memFormBean.memcounty}" 
                                        memvillage="${memFormBean.memvillage}" memprovince="${memFormBean.memprovince}" areaName="ucSysArea_"/>
                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        微信绑定：
                                    </td>
                                    <td class="user_List_styleRight" style="vertical-align: text-bottom;">
                                        <select id="selMemWeiXinCard"  class="selectWidth" name="D4">
                                            <option value="0">===== 请选择 =====</option>
                                            <option value="1">已绑定</option>
                                            <option value="2">未绑定</option>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        微信关注：
                                    </td>
                                    <td class="user_List_styleRight" style="vertical-align: text-bottom;">
                                        <select id="selMemAttention"  class="selectWidth" name="D4">
                                            <option value="0">===== 请选择 =====</option>
                                            <option value="1">已关注</option>
                                            <option value="2">未关注</option>
                                        </select>
                                    </td>
                                    <td colspan="2">
                                        <input id="btnMemReset" type="button" value="重   置" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                    <div style="height:500px; overflow-x:scroll" id="divmemlist">
                        <table class="table-style table-hover user_List_txt" style="width:1500px;table-layout:fixed">
                          
                                <tr class="th">
                                    <th style="width:50px">
                                        序号
                                    </th>
                                    <th style="width:15px">
                                        <input id="chkAll"  type="checkbox" class="chkAll" onclick="SelectAll()" />
                                    </th>
                                    <th style="width:145px">
                                        会员卡号
                                    </th>
                                    <th style="width:60px">
                                        会员姓名
                                    </th>
                                     <th style="width:80px">
                                        手机号码
                                    </th>
                                    <th style="width:60px">
                                        会员金额
                                    </th>
                                     <th style="width:60px">
                                        账户积分
                                    </th>
                                     <th style="width:60px">
                                        剩余计次
                                    </th>
                                     <th style="width:80px">
                                        历史消费
                                    </th>
                                    <th style="width:80px">
                                        会员等级
                                    </th>
                                     <th style="width:60px">
                                        会员状态
                                    </th>
                                     <th style="width:80px">
                                        会员生日
                                    </th>
                                     <th style="width:120px">
                                        所属店铺
                                    </th>
                                     <th style="width:80px">
                                        办卡日期
                                    </th>
                                    <th style="width:60px">
                                        办卡人员
                                    </th>
                                    <th id="thMemWeiXinCard"  visible="false"  style="width:60px">
                                        微信绑定
                                    </th>
                                    <th id="thMemAttention"  visible="false" style="width:60px">
                                        微信关注
                                    </th>
                                    
                                    <utils:customTable type="0" />
                                   
                                    <th style="width:60px">
                                        操作
                                    </th>                                  
                                </tr>
                           
                            
                             <c:forEach items="${memFormBean.rows}" var="s" varStatus="status">
                            
                            
                              
                                    <tr class="td">
                                        <td>
                                        	${status.index+1}
                                            
                                        </td>
                                        <td>
                                            <input id="chkItem"  type="checkbox" class="chk" />
                                        </td>
                                        <td>
                                            <a href='MemInfo.do?memcard= ${s.memcard}' >
                                                ${s.memcard}
                                            </a>
                                        </td>
                                        <td style="text-align: left">
                                            ${s.memname}
                                        </td>
                                        <td>
                                            ${s.memmobile}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.memmoney}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.mempoint}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.memcountnumber}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.consumemoney}
                                        </td>
                                        <td>
                                            ${s.levelname}
                                        </td>
                                        <td>
                                           ${s.memstate==0?"未":"己"}锁定
                                        </td>
                                        <td>
                                        
                                        ${s.membirthday}
                                           
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                         <fmt:formatDate value="${s.memcreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                           
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        
                                        
                                        <td  id="tdMemWeiXinCard" >   
                                        
                                                                    
                                            ${s.memweixincard==""?"未":"已"}绑定
                                        </td>
                                        <td  id="tdMemAttention" >
                                             ${s.memattention==1?"已":"未"}关注
                                        </td>
                                        <utils:customTable type="0" map="${s.map }"/>
                                        <td class="listtd" style="width: 60px;">
                                            <a href='memRegister.do?PID=140&memid=${s.memid}' id="hyEdit"  visible="false">
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                            </a><a href="#" id="hyDel"  visible="false" onclick='DeleteMem("${s.memname}",${s.memid});'>
                                                <img src="../images/Gift/del.png" alt="删除" title="删除" /></a>
                                        </td>
                                    </tr>
                                
							 </c:forEach>                            

                        </table>
                         
                     </div> 
                     	
                        <div class="user_List_page">
                        			<div width="100%" border="0" cellpadding="0" cellspacing="0">
                        	  
                           					 <page:page pageIndex="${memFormBean.page}" pageCount="${memFormBean.pages}" rowCount="${memFormBean.total}" 
                           					 pageSize="${memFormBean.pageSize}" 
                           					  path="memList.do" param="type=1"/>
                              				<div class="clear"></div>
								</div>
                           
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
