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
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/MemDelay.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmMemDelay" >
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
                    延期信息
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_left">
                            当前有效期：
                        </td>
                        <td class="tableStyle_right">
                            <span id="txtMemPastTime" style="font-size: 14px; font-weight: bold; color: Red;">
                            </span>
                            <label id="lblIsPast" style="display: none">
                                <input id="chkIsPast"  type="checkbox" checked="checked" /></label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            延长月数：
                        </td>
                        <td class="tableStyle_right">
                            <label id="lblIsMMS" style="vertical-align: text-bottom;">
                                <input id="txtDelayTime" type="text" class="input_txt border_radius" maxlength="2"
                                onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
                                    title="如填写数为12（以月为单位），则12个月后此卡到期" />
                                <label style="vertical-align: middle; font-size: 12px; color: #C3C0B7">
                                    &nbsp;&nbsp; 延期最长为36个月
                                </label>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            延长后有效期：
                        </td>
                        <td class="tableStyle_right">
                            <span id="spNewPastTime" style="font-size: 14px; font-weight: bold; color: Red;">
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            备注：
                        </td>
                        <td class="tableStyle_right" colspan="3">
                            <textarea id="txDelayRemark" rows="3"  style="width: 90%; word-wrap: break-word;
                                outline: none; resize: none;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" style="text-align: center; height: 36px; border:none;">
                            <input id="btnDelaySave" type="button" value="保   存" class="buttonColor" />
                            &nbsp
                            <input id="btnDelayReset" type="button" class="buttonRest" value="重   置" />
                        </td>
                    </tr>
                </table>
            </div>
            <input id="MemCard" type="hidden"  />
            <input id="IsYongJiu" type="hidden"  />
        </div>
    </div>
    </form>
</body>
</html>
