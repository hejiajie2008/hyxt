<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
    <script src="../Scripts/Module/Mem/MemDrawMoney.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
<script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
<script type="text/javascript" Src="../Scripts/Module/Report/Print.js"></script>
    </head>
<body>
    <form id="frmDrawMoney" >
    <div class="system_Info box_right">
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
                    提现信息
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <th style="text-align: center; font-weight: bold; border:none;" class="th" colspan="4">
                            会员提现信息
                        </th>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            会员提现单号：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblMemDrawMoney"  style="font-size: 14px; font-weight: bold;"><utils:order type="5"/></label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            会员提现日期：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblDrawMoneyTime"  style="font-size: 14px; font-weight: bold;">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            当前折损比率：
                        </td>
                        <td class="tableStyle_right">
                            <span id="spanDrawPercent"  style="font-size: 14px; font-weight: bold;
                                color: Red;"></span>
                            <input id="txtDrawPercent" type="hidden"  />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            当前账户余额：
                        </td>
                        <td class="tableStyle_right">
                            <span id="spanCurrentMoney" style="font-size: 14px; font-weight: bold; color: Red;">
                            
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            此次提取金额：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtDrawMoney" type="text"  class="border_radius" maxlength="8" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            实际扣除金额：
                        </td>
                        <td class="tableStyle_right">
                            <input id="txtAccountMoney" type="text"  class="border_radius" maxlength="8" readonly="readonly" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            备注：
                        </td>
                        <td class="tableStyle_right" colspan="3">
                            <textarea id="txtDrawRemark" rows="3"  style="width: 90%; word-wrap: break-word;
                                outline: none; resize: none;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" style="text-align: center; height: 36px; border:none;">
                            <label id="lblIsSMS"  style="vertical-align: text-bottom;">
                                <label class="lbsetCk" style="vertical-align: middle;">
                                    <input id="chkSMS" type="checkbox"  />
                                    发送短信 &nbsp;
                                </label>
                            </label>

                              <label id="lblIsPrint" style="vertical-align: text-bottom;"  >
                            <label class="lbsetCk" style="vertical-align: middle;">
                                <input id="chkPrint" type="checkbox"  />
                                打印小票 &nbsp;</label></label>


                            <input id="chkIsSMS"  type="checkbox" style="display: none" />
                            <input id="btnDrawSave" type="button" class="buttonColor" value="保    存" />
                            &nbsp
                            <input id="btnDrawMoneyReset" type="button" class="buttonRest" value="重   置" />
                                 <input id="lblOrderUSers" type="hidden" class="border_radius"  value="0" />
                       
                        </td>
                    </tr>
                </table>
            </div>
            <input id="MemCard" type="hidden"  />
        </div>
    </div>
    <%--打印的次数--%>
        <label id="lblPrintTitle" Style="display: none" >Label</label>
        <label id="lblPrintFoot" Style="display: none" >Labe2</label>
        <input type="hidden" value="" id="PointNum"  />
    </form>
</body>
</html>
