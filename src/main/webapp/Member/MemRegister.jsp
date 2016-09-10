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
    <title>会员登记</title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/Style/uploadify.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/Style/calendar.css" rel="stylesheet" type="text/css" />
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.uploadify.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.uploadify.swfobject.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/MemRegister.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Area.js" type="text/javascript"></script>
    <object style='display: none;' id='CardReader' classid='clsid:27DD3937-FA54-45B2-9A51-64D58826AC01'>
    </object>
    <style type="text/css">
        #MemPhoto_UploadifyUploader
        {
            float: left;
        }
    </style>
</head>
<body>
    <form id="frmMemRegister"  name="user_form" method="post">
    <input id="txtMemID" type="hidden" class="input_txt border_radius" name="memid" value="${mem.memid}"  />
    <div class="system_Info box_right">
        <div class="system_Top">
            <div class="user_regist_title">
             	<utils:title/>
            </div>
        </div>
        <div style="padding-left: 10px;">
            <table border="0">
                <tr>
                    <td style="width: 800px;">
                        <div style="width: 800px; font-size: 14px;">
                            <div class="user_regist_infor">
                                会员信息
                            </div>
                            <table width="720" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr>
                                    <td class="tableStyle_left">
                                        <span style="color: #ff4800; vertical-align: middle">*</span>会员卡号：
                                    </td>
                                    <td class="tableStyle_right" style="width: 270px">
                                        <input id="txtMemCard" name="memcard" type="text" value="${mem.memcard}" class="border_radius" title="请输入会员卡号"
                                            maxlength="20" />
                                        <label style="vertical-align: text-bottom; padding-left: 2px;">
                                           
                                        </label>
                                    </td>
                                    <td class="tableStyle_left">
                                        会员姓名：
                                    </td>
                                    <td class="tableStyle_right" style="width: 270px">
                                        <input id="txtMemName" name="memname" value="${mem.memname}" type="text" class="border_radius" title="请输入会员姓名"
                                            maxlength="20" />
                                    </td>
                                </tr>
                                <tr id="trMemPassword" >
                                    <td class="tableStyle_left">
                                        <span  id="sppwd1" style="color: #ff4800; vertical-align: middle">*</span>会员密码：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemPassword"  type="password" class="border_radius" title="请输入会员密码"
                                            maxlength="20" />
                                        <input type="checkbox"  style="display: none;"  id="RegNullPwd" />
                                        <input type="hidden" name="mempassword" id="mempassword"/>
                                    </td>
                                    <td class="tableStyle_left">
                                        <span  id="sppwd2" style="color: #ff4800; vertical-align: middle">*</span>
                                        确认密码：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemPasswordCheck"  type="password" class="border_radius"
                                            title="请重复输入会员密码" maxlength="20" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        手机号码：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemMobile"  type="text" class="border_radius" title="请输入手机号码"
                                            maxlength="20" name="memmobile" value="${mem.memmobile}"/>
                                    </td>
                                    <td class="tableStyle_left">
                                        会员状态：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select name="memstate" id="sltMemState"  class="selectWidth" >
                                            <option value="0" ${mem.memstate==0?"selected = \"selected\"":"" }>正常</option>
                                            <option value="1" ${mem.memstate==1?"selected = \"selected\"":"" }>锁定</option>
                                            <option value="2" ${mem.memstate==2?"selected = \"selected\"":"" }>挂失</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        会员等级：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select name="memlevelid" id="sltMemLevelID"  class="selectWidth">
                                        
                                        
                                        <c:forEach items="${memlevelList}" var="s" varStatus="status">
	                                        	<c:choose>
		                                        	<c:when test="${mem.memlevelid==s.levelid}">
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
                                    <td class="tableStyle_right">
                                        <select id="sltShop"   class="selectWidth">
                                        	<utils:shoplist shopid="${memFormBean.memshopid }"/>
                                        </select>
                                        <input id="HDsltshop"  type="hidden" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        会员生日：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemBirthday"  type="text" class="Wdate border_radius" name="membirthday" value="${mem.membirthday}"
                                        
                                        
                                            title="请输入会员生日" maxlength="20" />
                                    </td>
                                    <td class="tableStyle_left">
                                        会员性别：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select name="memsex" id="sltMemSex"  class="selectWidth">
                                            <option value="0">男士</option>
                                            <option value="1">女士</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        赠送积分：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemPoint"  type="text" class="border_radius" title="请输入赠送积分(可在全局参数设置是否可以输入赠送积分)" 
                                            maxlength="8" />
                                    </td>
                                    <td class="tableStyle_left">
                                        赠送金额：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemMoney"  type="text" class="border_radius" title="请输入赠送余额(可在全局参数设置是否可以输入赠送余额)"
                                            maxlength="8" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        电子邮箱：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemEmail"  type="text" class="border_radius" name="mememail" value="${mem.mememail}" title="请输入会员电子邮箱" />
                                    </td>
                                    <td class="tableStyle_left">
                                        固定电话：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtTelephone"  type="text" class="border_radius" name="memtelephone" value="${mem.memtelephone}" title="请输入会员固定电话" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        身份证号：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemIdentityCard"  type="text" class="border_radius" name="memidentitycard" value="${mem.memidentitycard}" title="请输入会员身份证" />
                                    </td>
                                    <td class="tableStyle_left">
                                        办卡日期：
                                    </td>
                                    <td class="tableStyle_right">
                                        <input id="txtMemCreateTime"  value="${mem.memcreatetime}"  type="text" class="Wdate border_radius" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        办卡人员：
                                    </td>
                                    <td class="tableStyle_right">
                                        <select name="memuserid" id="sltMemUserID"  class="selectWidth">
                                        	<utils:userlist userid="${mem.memuserid }"/>
                                        </select>
                                    </td>
                                    <td class="tableStyle_left">
                                        推荐人卡号：
                                    </td>
                                    <td class="tableStyle_right" colspan="1">
                                        <input id="txtMemRecommendCard" type="text" class="border_radius" value="${mem.memrecommendid }"
                                            style="width: 120px" title="输入推荐人‘卡号’ 或‘姓名’ 或‘手机号码’，按回车键，可自定提取到推荐人信息；" />
                                        <label style="vertical-align: middle;">
                                            <span id="txtMemRecommendMsg"  style="margin-top: 0px; margin-left: 5px;
                                                margin-right: 0px"></span>
                                        </label>
                                        <input type="hidden" id="txtMemRecommendID"  name="memrecommendid" value="${mem.memrecommendid }"
                                            class="border_radius" />
                                        <input type="hidden" id="txtMemRecommendName" 
                                            class="border_radius" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        过期时间：
                                    </td>
                                    <td colspan="3" class="tableStyle_right">
                                        <input id="txtMemPastTime" name="mempasttime" value="${mem.mempasttime }" type="text" class="Wdate border_radius"  />
                                        <label style="vertical-align: text-bottom; padding-left: 6px">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <input  id="chkMemIsPast" type="checkbox" ${mem.mempasttime==''?"checked=\"checked\"":"" }  />
                                                
                                                
                                                永久有效（不设置过期时间）
                                            </label>
                                        </label>
                                        <label id="lblIsPast" style="display: none; vertical-align: middle">
                                            <input id="chkIsIsPast"  type="checkbox" checked="checked" />
                                            <input type="hidden" name="memispast" id="memispastId" value="${mem.memispast}"/>
                                            </label>
                                    </td>
                                </tr>
                                <tr id="Tr1" >
                                    <td class="tableStyle_left" id="tdStaff">
                                        员工提成：
                                    </td>
                                    <td class="tableStyle_right" id="tddStaff">
                                        <select id="sltStaff"  class="selectWidth" style="width: 120px">
                                        </select>
                                        <input id="txtRegisterStaffMoney" type="text" class="border_radius" 
                                            title="请输入提成金额"  style="clear: both; float: none; width: 140px" />
                                        <input id="chkRegisterStaff"  type="checkbox" style="display: none"  />
                                    </td>
                                    <td class="tableStyle_left" id="tdCardNumber">
                                        卡面号码：
                                    </td>
                                    <td class="tableStyle_right" id="tddCardNumber">
                                        <input id="txtCardNumber"  type="text" class="border_radius" title="请输入会员卡面号码" name="memcardnumber" value="${mem.memcardnumber}"
                                            maxlength="20" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        联系地址：
                                    </td>
                                    <td colspan="3" class="tableStyle_right">
                                        
                                        <utils:area memcity="${mem.memcity}" memcounty="${mem.memcounty}" 
                                        memvillage="${mem.memvillage}" memprovince="${mem.memprovince}" areaName="ucSysArea_"/>
                                        
                                        <input id="txtMemAddress" type="text" name="memaddress" value="${mem.memaddress}" class="border_radius" style="width: 520px;"
                                             />
                                             <br/><br/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tableStyle_left">
                                        备 注：
                                    </td>
                                    <td colspan="3" class="tableStyle_right">
                                        <textarea id="txtMemRemark" rows="3" 
                                        name="memremark" 
                                         style="width: 90%; word-wrap: break-word;outline: none; resize: none;" title="请输入会员的备注">${mem.memremark}</textarea>
                                    </td>
                                </tr>
                            </table>
                            <div class="user_regist_infor">
                                会员自定义属性
                            </div>
                            <table width="720" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tbody id="tbCustomField" >
                                    
                                    <utils:customfield type="0" map="${mem.map}"/>
                                    
                                </tbody>
                            </table>
                            <div style="text-align: center; height: 36px">
                                
                                <label id="lblIsSMS" style="vertical-align: text-bottom;">
                                    <label class="lbsetCk" style="vertical-align: middle;">
                                        <input id="chkSMS" type="checkbox"  />
                                        发送短信 &nbsp;&nbsp;</label></label>
                               
                                
                                
                                <input id="chkIsSMS"  type="checkbox" style="display: none" />
                                <input id="btnMemSave" type="button" class="buttonColor" value="保　存" />
                                <input id="btnMemReset" type="button" class="buttonRest" value="重　置" />
                            </div>
                        </div>
                    </td>
                    <td style="text-align: left;">
                        <div style="height: 600px; width: 224px; margin-left: 10px;">
                            <div class="user_regist_pic">
                                <img alt="" id="imgMemPhoto" src="../images/member/nophoto.gif" width="220"  /><br />
                                <input type="hidden" id="txtMemPhoto" name="memphoto" value="${mem.memphoto}" />
                            </div>
                            <p style="color: #DB9944; font-size: 12px;">
                                相片支持大小为200*200</p>
                            <div class="common_Button_all">
                                <input id="MemPhoto_Uploadify" type="file" class="common_Button" />
                                <input id="btnMemPhotoUpload" style="margin-left: 2px;" type="button" class="common_Button"
                                    value="上传照片" onclick="javascript:$('#MemPhoto_Uploadify').uploadifyUpload();" />
                                <input id="Button1" type="button" style="margin-left: 2px;" class="common_Button"
                                    value="在线拍摄" onclick="javascript:ShowOnlinePhoto();" />
                            </div>
                            <div id="MemRegister_fileQueue">
                            </div>
                            <div class="user_Notice" style="width: 210px; height: auto;">
                                注：<b>*</b> 号为系统必填项<br />
                                <span  id="isSendRWM">若要发送二维码，请启动服务参数中的"开启系统彩信功能"。</span>
                            </div>
                            <div id="trTitle" >
                                <p>
                                    二维码卡号</p>
                            </div>
                            <div id="trQrCode" >
                                <p>
                                    <img alt="" src="" id="imgQRCode" style="width: 140px; height: 140px"  />
                                    <input id="hidImgSrc" type="hidden" class="border_radius"  />
                                </p>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <jsp:include  page="../Controls/QuickSearch.jsp"/>
    </form>
</body>
</html>
