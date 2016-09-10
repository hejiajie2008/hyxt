<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/SystemManage/ShopInfo.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/fy.js" type="text/javascript"></script>
    <style>
    .user_List_top label.tips { position: absolute; top:70px;_top:22px; right: 130px;*top: 22px; color:#767676}
   
    </style>
</head>
<body>
    <form id="page_form" action="ShopList.do"   >
    <input id="hidWeiXin" type="hidden" value="1"  />
    
    <input id="txtIsSendCard" type="hidden"  />
    
    <input id="txtSmsManage" type="hidden"  />
    <input id="txtPointManage" type="hidden"  />
    <input id="txtIsSettlement" type="hidden"  />
    <input type="hidden" id="hdShopID"  />
    <input type="hidden" id="union"  />
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title/>
                        </div>
                    </div>
                    <div id="ShopSms" style="display: none;">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 300px; margin: auto">
                            <tr>
                                <td class="tableStyle_left">
                                    店铺名称：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="txtSmsShopName">
                                    </label>
                                    <input type="hidden" id="hdSmsShopID" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    店铺剩余短信量：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="txtSmsNumber">
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    操作类型：
                                </td>
                                <td class="tableStyle_right">
                                    <label>
                                        <input type="radio" name="radSmsType" value="0" checked="checked" />增加</label>&nbsp;&nbsp;
                                    <label>
                                        <input type="radio" name="radSmsType" value="1" />扣除</label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    短信数量：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" class="input_txt border_radius" id="txtSmsCount" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center;">
                                    <input id="btSaveSms" type="button" class="buttonColor" value="确   定" />
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="divForeverTicketUrl" style="display: none;">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 500px; margin: auto">
                            <tr>
                                <td id="tdForeverTicketUrl" class="tableStyle_right">
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="ShopPoint" style="display: none;">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 300px; margin: auto">
                            <tr>
                                <td class="tableStyle_left">
                                    店铺名称：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="txtShopPointName">
                                    </label>
                                    <input type="hidden" id="hdPointShopID" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    店铺剩余积分量：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="txtShopPointNumber">
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    操作类型：
                                </td>
                                <td class="tableStyle_right">
                                    <label>
                                        <input type="radio" name="radPointType" value="0" checked="checked" />增加</label>&nbsp;&nbsp;
                                    <label>
                                        <input type="radio" name="radPointType" value="1" />扣除</label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    积分数量：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" class="input_txt border_radius" id="txtcount" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center;">
                                    <input id="btSavePoint" type="button" class="buttonColor" value="确   定" />
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="ShopInfo" style="display: none">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 700px; margin: auto">
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>店铺名称：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtShopName" type="text"  class="border_radius" />
                                    <input id="txtShopID" type="hidden"  />
                                </td>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>店铺联系人：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtShopContactMan" type="text"  class="border_radius" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    联系电话：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtShopTelephone" type="text"  class="border_radius" />
                                </td>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>短信后缀：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtShopSmsName" type="text"  class="border_radius" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    打印标题：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtShopPrintTitle" type="text"  class="border_radius" />
                                </td>
                                <td class="tableStyle_left">
                                    打印脚注：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtShopPrintFoot" type="text"  class="border_radius" />
                                </td>
                            </tr>
                            <tr  id="trSettlement">
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>结算周期：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtSettlementInterval" type="text" title="总店与分店多少天进行一次结算" 
                                        class="border_radius" />
                                </td>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>提成比例：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtShopProportion" type="text"  title="请输入0~1之间的数值" class="border_radius" />
                                </td>
                            </tr>
                            <tr id="trAlliance" >
                                <td class="tableStyle_left">
                                    店铺类型：
                                </td>
                                <td class="tableStyle_right">
                                    <label>
                                        <input type="radio" name="isLms" id="rdislms"  value="1" />联盟商</label><label>
                                            <input type="radio" name="isLms" id="rdisnotlms"  value="0" />店铺</label>
                                </td>
                                <td colspan="2" style="text-align: left;">
                                    <font style="color: Red;">（此设置保存之后将无法更改）</font>
                                </td>
                            </tr>
                            <tr  id="trSltShop">
                                <td class="tableStyle_left">
                                    选择联盟商：
                                </td>
                                <td class="tableStyle_right">
                                    <select  id="sltShopList" class="selectWidth">
                                    </select>
                                </td>
                                <td colspan="2" style="text-align: left;">
                                    <font style="color: Red;">（此设置保存之后将无法更改 不选择则默认为独立店铺）</font>
                                </td>
                            </tr>
                            <tr  id="trShopSms">
                                <td class="tableStyle_left">
                                    短信不足发送应按：
                                </td>
                                <td colspan="3" class="tableStyle_right">
                                    <label>
                                        <input type="radio" id="rbbzfs" name="SmsType" value="1"  enableviewstate="True" />不准发送</label>
                                    <label>
                                        <input type="radio" id="rbkytz" name="SmsType" value="2"  />短信透支（短信量变负数）</label>
                                </td>
                            </tr>
                            <tr  id="trShopPoint">
                                <td class="tableStyle_left">
                                    积分不足消费应按：
                                </td>
                                <td colspan="3" class="tableStyle_right">
                                    <label>
                                        <input type="radio" id="rdbzxf" value="1" name="PointType"  />不准消费</label>
                                    <label>
                                        <input type="radio" id="rdjfgl" value="2" name="PointType"  />会员消费时，积分给零</label>
                                    <label>
                                        <input type="radio" id="rdtz" value="3" name="PointType"  />积分透支（积分量变负数）</label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    是否锁定：
                                </td>
                                <td colspan="3" class="tableStyle_right">
                                    <label style="vertical-align: text-bottom;">
                                        <input type="radio" name="radChooseYesOrNo" id="radChooseYes"  value="1" />
                                        <label style="vertical-align: middle;">
                                            暂时锁定</label></label>
                                    <label style="vertical-align: text-bottom;">
                                        <input type="radio" name="radChooseYesOrNo" id="radChooseNo"  value="0" />
                                        <label style="vertical-align: middle;">
                                            不锁定<font color="red">&nbsp;&nbsp;&nbsp;(锁定则该店铺的所有员工不能登录)</font></label></label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    联系地址：
                                </td>
                                <td class="tableStyle_right" colspan="3">
                                    <input id="txtShopAddress" type="text"  class="border_radius" style="width: 520px;" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    备注：
                                </td>
                                <td class="tableStyle_right" colspan="3">
                                    <textarea id="txtShopRemark" rows="3"  style="width: 520px; word-wrap: break-word;
                                        outline: none; resize: none;"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tableStyle_right ">
                                    <div class="buton" style="text-align: center;">
                                        <input id="btnShopSave" type="button" class="buttonColor" value="保   存 " />
                                        <input id="btnShopReset" type="button" class="buttonRest" value="重   置 " />
                                        <input id="ShopAddOrEdit" type="hidden" />
                                        <input id="chkSMS" type="checkbox"  style="display: none" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="ShopBuyCard" style="display: none">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 300px; margin: auto">
                            <tr>
                                <td class="tableStyle_left">
                                    购卡店铺：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="lblShopName">
                                    </label>
                                    <input type="hidden" id="hdCardShopID" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    卡片起始号：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" class="input_txt border_radius" id="txtStartCardNumber" title="请输入6位数字" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    卡片截止号：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" class="input_txt border_radius" id="txtEndCardNumber" title="请输入6位数字" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    购卡总金额：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" class="input_txt border_radius" id="txtBuyCardMoney" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    备注：
                                </td>
                                <td class="tableStyle_right">
                                    <textarea id="txtRemark" class="input_txt border_radius" rows="3" 
                                        style="height: 40px; word-wrap: break-word; outline: none; resize: none;"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center;" class="tableStyle_right ">
                                    <input id="btSaveCardLog" type="button" class="buttonColor" value="确   定" />
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="user_List_All">
                    <div class="user_List_top" style="height: 34px;">
                            <table class="tableStyle" style="width: 100%">
                                <tr style="color: #333333; background-color: #F7F6F3;">
                                    <td class="tableStyle_left">
                                        快捷操作：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="btnShopAdd" type="button" value="新增店铺" class="common_Button"  visible="false" />&nbsp;&nbsp;
                                        <input id="btnPointRecord" type="button" value="积分记录" class="common_Button"  />
                                        <input id="btnMsgRecord" type="button" value="短信记录" class="common_Button"  />
                                    </td>
                                    <td class="tableStyle_left" style="width: 120px">
                                        <label id="lblsearch" for="txtSearch" class="tips">
                                            店铺名称/联系人/联系电话/店铺地址</label>
                                        <input type="text" id="txtSearch" name="searchcontent" class="border_radius" Width="220px"/>
                                    </td>
                                    <td class="tableStyle_right" style="width: 80px">
                                        <input type="button" id="btnSearch"  value="查询" class="common_Button" 
                                            OnClick="btnSearch_Click" />
                                    </td>
                                </tr>
                            </table>
                        </div>
            <table class="table-style table-hover user_List_txt">
               
                   
                       
                            <tr class="th">
                                <th>
                                    序号
                                </th>
                                <th>
                                    店铺名称
                                </th>
                                <th>
                                    联系人
                                </th>
                                <th>
                                    联系电话
                                </th>
                                <th>
                                    店铺地址
                                </th>
                                <th>
                                    是否锁定
                                </th>
                                <th>
                                    备注
                                </th>
                                <th>
                                    操作
                                </th>
                            </tr>
                        
                    <c:forEach items="${sysshopFormBean.rows}" var="s" varStatus="status">
                        <tr class="td">
                            <td>
                                 ${status.index+1}
                            </td>
                            <td style="text-align: left">
                                ${s.shopname}
                            </td>
                            <td>
                                ${s.shopcontactman}
                            </td>
                            <td>
                                ${s.shoptelephone}
                            </td>
                            <td style="text-align: left; padding-left: 4px;">
                                ${s.shopaddress}
                            </td>
                            <td>
                                ${s.shopstate==1 ? "是" : "否"}
                            </td>
                            <td style="text-align: left; padding-left: 4px;">
                                ${s.shopremark}
                            </td>
                            <td class="listtd" style="width: 100px;">
                              
                                <a href="#" onclick='javascript:ShopEdit("","${s.shopid}");'
                                      >
                                    <img src="../images/Gift/eit.png" alt="编辑" title="编辑" /></a> 
                                    <a id="hyAuthority"   href="ShopAuthority.do?PID=38&shopid=${s.shopid}" > 
                                        <img src="../images/Gift/system.png" alt="权限设定" title="权限设定" />
                                        </a>
                                        <shiro:hasPermission name="shopList:weixin"> 
 
    												<a href="#" onclick='' class="weiXin"> 二维码</a>
 
									</shiro:hasPermission>
                                    
                            </td>
                        </tr>
                    </c:forEach>
                    
                    
            </table>
            <div class="user_List_page">
               <page:page pageIndex="${sysshopFormBean.page}" pageCount="${sysshopFormBean.pages}" rowCount="${sysshopFormBean.total}" 
                           					 pageSize="${sysshopFormBean.pageSize}" 
                           					  path="memList.do" param="type=1"/>
                              				<div class="clear"></div>
            </div>
            </div> 
                </div> 
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
