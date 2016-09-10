<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/EditLevel.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmSetLevel" >
    <div class="system_Info box_right" style="width: 1000px">
        <div class="system_Top">
            <div class="user_regist_title">
                主页  >  会员管理  >  会员等级  >  会员等级设置 
            </div>
        </div>
        <div class="user_regist_Allleft" id="divAddLevel" style="width: 1000px">
            <div class="user_regist_left">
                <div class="user_regist_infor" style="text-align: left; width: 1000px">
                    等级信息
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                    style="width: 1200px">
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>等级名称：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtLevelName" name="levelname" value="${memlevel.levelname}" type="text" class="border_radius"  />
                            <input id="txtLevelID" type="hidden" name="levelid" value="${memlevel.levelid}" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>所需积分：
                        </td>
                        <td class="tableStyle_right">
                            <label style="vertical-align: text-bottom;">
                                <input id="txtLevelPoint" name="levelpoint" value="${memlevel.levelpoint}" type="text" class="border_radius"  maxlength="6"
                                    onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
                                <span style="color: #ff4800; vertical-align: middle">&nbsp;此等级的最低积分标准 设置0-999999之间</span>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            升级机制：
                        </td>
                        <td class="tableStyle_right">
                           
                            <span style="float: left">
                                <input id="chkLevellLock" name="levelllock" value="${memlevel.levelllock}" type="checkbox"  />等级锁定</span> <span style="color: #ff4800;
                                    vertical-align: middle; float: none">即：启用等级锁定则此会员等级不受自动升级机制影响,保持等级不变 适用于 只积分不打折
                                    类型会员等级</span>
                        </td>
                    </tr>
                </table>
                <div class="user_regist_infor" style="text-align: left; width: 1200px">
                    会员充值等级信息
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                    style="width: 1200px">
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>充值积分：
                        </td>
                        <td class="tableStyle_right" style="width: 250px">
                            <label style="vertical-align: text-bottom;">
                                <input id="txtLevelRechargePointRate" name="levelrechargepointrate" value="${memlevel.levelrechargepointrate}" type="text" class="border_radius" 
                                    maxlength="6" />
                            </label>
                            <label style="vertical-align: middle;">
                            </label>
                        </td>
                        <td class="tableStyle_left">
                            参数说明：
                        </td>
                        <td class="tableStyle_right">
                       会员充值积分设置 0-999999之间 如：充值0.5元得1积分|充值10元得1积分   <font style="font-weight:bold;font-style:italic; color:#ff4800" >0为不积分</font> 
                        </td>
                    </tr>
                </table>
                <div class="user_regist_infor" style="text-align: left; width: 1200px">
                    快速消费会员等级信息
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                    style="width: 1200px">
                    <tr>
                        <td class="tableStyle_left">
                        </td>
                        <td class="tableStyle_right" style="color: #ff4800; width: 250px">
                            快速消费折扣设置 1-100之间
                        </td>
                        <td class="tableStyle_left">
                        </td>
                        <td class="tableStyle_right">
                            快速消费积分设置 0-999999之间 如：消费0.5元得1积分|消费10元得1积分  <font style="font-weight:bold;font-style:italic; color:#ff4800" >0为不积分</font> 
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>快速消费：
                        </td>
                        <td class="tableStyle_right">
                            <label style="vertical-align: text-bottom;">
                                <input id="txtLevelDiscountPercent" name="leveldiscountpercent" value="${memlevel.leveldiscountpercent}" type="text" class="border_radius" 
                                    maxlength="3" />
                            </label>
                            <label style="vertical-align: middle;">
                                %
                            </label>
                        </td>
                        <td class="tableStyle_left">
                            积分设置：
                        </td>
                        <td class="tableStyle_right">
                            <label style="vertical-align: text-bottom;">
                                <input id="txtLevelPointPercent" name="levelpointpercent" value="${memlevel.levelpointpercent}" type="text" class="border_radius" 
                                    maxlength="6" />
                            </label>
                        </td>
                    </tr>
                </table>
                <div id="divEnableGoodsSet"  style="width: 1200px">
                    <div class="user_regist_infor" style="text-align: left; width: 1200px">
                        商品类别对应商品消费折扣
                    </div>
                    <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                        <tr>
                            <td class="tableStyle_left">
                                比例设置：
                            </td>
                            <td class="tableStyle_right" style="color: #ff4800; width: 250px">
                                商品消费折扣设置 1-100之间
                            </td>
                            <td class="tableStyle_left">
                                积分设置：
                            </td>
                            <td class="tableStyle_right" >
                                商品消费积分设置 0-999999之间 如：消费0.5元得1积分|消费10元得1积分  <font style="font-weight:bold;font-style:italic; color:#ff4800" >0为不积分</font> 
                            </td>
                        </tr>
                       
                           <c:forEach items="${goodsClassList}" var="s" varStatus="status">
                          
                           	<input type="hidden" name="goodsClassRabatList[${status.index}].classid" value="${s.classid}"/>
                           	
                           	
                           	<input type="hidden" name="goodsClassRabatList[${status.index}].classdiscountid" value="${s.classdiscountid}"/>
                           	<input type="hidden" name="goodsClassRabatList[${status.index}].shopid" value="1"/>
                           	<input type="hidden" name="goodsClassRabatList[${status.index}].memlevelid" value="${memlevel.levelid}"/>
                                <tr>
                                    <td class="tableStyle_left">
                                        <span style="color: #ff4800; vertical-align: middle">*</span>${s.classname}：
                                        
                                       
                                        
                                        
                                    </td>
                                    <td class="tableStyle_right">
                                        <label style="vertical-align: text-bottom;">
                                         
                                            <input  
                                                type="text" class="border_radius" id='txtDiscountPercent' name="goodsClassRabatList[${status.index}].classdiscountpercent"  value="${s.classdiscountpercent}" maxlength="3" />
                                            <label style="vertical-align: middle;">
                                                %
                                            </label>
                                        </label>
                                    </td>
                                    <td class="tableStyle_left">
                                        积分设置：
                                    </td>
                                    <td class="tableStyle_right">
                                        <label style="vertical-align: text-bottom;">
                                            <input    type="text"  value="${s.classpointpercent}"  name="goodsClassRabatList[${status.index}].classpointpercent"
                                                class="border_radius" id="txtPointPercent" maxlength="6" />
                                        </label>
                                    </td>
                                </tr>
                           </c:forEach>
                      
                    </table>
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td colspan="4" style="text-align: center; height: 36px; border: none">
                            <input type="button"  id="btnSetLevel" OnClick="saveLevel();"
                                value="保   存" class="buttonColor" />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
