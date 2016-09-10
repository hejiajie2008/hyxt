﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/MemSendCard.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmDataExcelIn" >
    <div class="system_Info box_right">
        <div class="system_Top">
            <div class="user_regist_title">
                 	<utils:title/>
            </div>
        </div>
        <div id="Sendloading" style="display: none;">
            <img src="../images/ico/loading.gif" />
        </div>
        <div class="user_regist_Allleft">
            <div class="user_regist_left">
                <div class="user_regist_infor">
                    注意事项
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_right">
                            （1）如果批量发卡中有一张卡号已存在系统中，则不影响其它卡的发行。
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_right">
                            （2）如果批量发卡的数量过多，请耐心等待提示成功之后才可离开本页面。
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_right">
                            （3）排除数字以英文逗号隔开。（如：4,7,2 则发出的卡号将不会出现这些数字）
                        </td>
                    </tr>
                </table>
                <div class="user_regist_infor">
                    批量发卡
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>起始卡号：
                        </td>
                        <td class="tableStyle_right">
                            <input type="text" id="txtStart" class="border_radius" maxlength="20" />
                        </td>
                        <td class="tableStyle_left">
                            <span style="color: #ff4800; vertical-align: middle">*</span>结束卡号：
                        </td>
                        <td class="tableStyle_right">
                            <input type="text" id="txtEnd" class="border_radius" maxlength="20" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            <span id="pw1"  style="color: #ff4800; vertical-align: middle">*</span>会员密码：
                        </td>
                        <td class="tableStyle_right">
                            <input type="password" id="txtPwd1" class="border_radius" maxlength="20" />
                            <input  type="hidden" id="YesOrNoPwd"  />
                        </td>
                        <td class="tableStyle_left">
                            <span id="pw2"  style="color: #ff4800; vertical-align: middle">*</span>确定密码：
                        </td>
                        <td class="tableStyle_right">
                            <input type="password" id="txtPwd2" class="border_radius" maxlength="20" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            会员等级：
                        </td>
                        <td class="tableStyle_right">
                            <select name="user_Level" id="sltMemLevelID"  class="selectWidth">
                            	<utils:memlevel levelid=""/>
                            </select>
                        </td>
                        <td class="tableStyle_left">
                            卡号状态：
                        </td>
                        <td class="tableStyle_right">
                            <select id="sltMemNewState" class="selectWidth">
                                <option value="0">正常</option>
                                <option value="1">锁定</option>
                                <option value="2">挂失</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            卡片余额：
                        </td>
                        <td class="tableStyle_right">
                            <input type="text" id="txtMenMoney" class="border_radius" maxlength="20" />
                        </td>
                        <td class="tableStyle_left">
                            积分数量：
                        </td>
                        <td class="tableStyle_right">
                            <input type="text" id="txtMemPoint" class="border_radius" maxlength="20" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            排除数字：
                        </td>
                        <td class="tableStyle_right" colspan="3">
                            <textarea id="txtDelCard" rows="2"  style="width: 90%; word-wrap: break-word;
                                outline: none; resize: none;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_left">
                            备注：
                        </td>
                        <td class="tableStyle_right" colspan="3">
                            <textarea id="txtRemark" rows="2"  style="width: 90%; word-wrap: break-word;
                                outline: none; resize: none;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input id="btnSendCardSave" type="button" class="buttonColor" value="保    存" />
                            &nbsp
                            <input id="btnSendCardReset" type="button" class="buttonRest" value="重   置" />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
