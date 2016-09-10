<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/MemRechageMoney.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
    <script type="text/javascript" Src="../Scripts/Module/Report/Print.js"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmRechargeMoney" >
    <div class="system_Info box_right">
        <%--打印的次数 --%>
        <input type="hidden" value="" id="PointNum" />
        <div class="system_Top">
            <div class="user_regist_title">
                <utils:title/>
            </div>
        </div>
        <div>     
        
         <jsp:include page="../Controls/MemberSearch.jsp"/>
        </div>
        <div class="user_regist_Allleft">
            <div class="user_regist_left">
                <div class="user_regist_infor" style="text-align: left">
                    充值信息
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_left">
                            充值单号：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblAccount"  style="font-size: 14px; font-weight: bold;">
                            
                            <utils:order type="1"/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            充值日期：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblRechargeTime"  style="font-size: 14px; font-weight: bold;">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            操作人员：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblRechargeUSer"  style="font-size: 14px; font-weight: bold;">
                             <shiro:principal/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            充值金额：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtMoney" type="text"  class="border_radius" value="0" maxlength="8" />
                            &nbsp;&nbsp;
                            <label style="vertical-align: text-bottom;">
                                <label class="lbsetCk" style="vertical-align: middle;">
                                    <input id="chkBank" type="checkbox" title="若为银联卡充值行为时请勾选此项,系统统计收入时将单独统计此项" />
                                    银联充值
                                </label>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            赠送金额：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtGiveMoney" type="text"  class="border_radius" value="0"
                                maxlength="8" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            充值合计：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtTotal" type="text"  class="border_radius" value="0" maxlength="8" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            可得积分：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtPoint" type="text"  class="border_radius" value="0" maxlength="8" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            备注：
                        </td>
                        <td class="tableStyle_right" colspan="3">
                            <textarea id="txtRechangeRemark" rows="3"  style="width: 90%; word-wrap: break-word;
                                resize: none; outline: none;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" style="text-align: center; height: 36px; border:none; " >
                            <label id="lblIsSMS" style="vertical-align: text-bottom;" >
                                <label class="lbsetCk" style="vertical-align: middle;">
                                    <input id="chkSMS" type="checkbox"  />
                                    <input id="chkIsSMS"  type="checkbox" style="display: none" />
                                    发送短信 &nbsp;
                                </label>
                            </label>
                            <label id="lblIsPrint" style="vertical-align: text-bottom;">
                                <label class="lbsetCk" style="vertical-align: middle;">
                                    <input id="chkPrint" type="checkbox"  />
                                    打印小票 &nbsp;</label></label>
                            <input id="btnRechageSave" type="button" value="保   存" class="buttonColor" />
                            &nbsp
                            <input id="btnRechargeReset" type="button" class="buttonRest" value="重   置" />
                        </td>
                    </tr>
                </table>
                
                <input id="MemCard" type="hidden"  />
            </div>
        </div>
    </div>
    </form>
</body>
</html>
