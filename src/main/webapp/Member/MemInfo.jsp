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
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/MemInfo.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Tab.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Report/Report.js" type="text/javascript"></script>
    
    <script type="text/javascript">
        $(document).ready(function () {
            $("#findTable").removeAttr("style");
            $("#trTitle").css("display", "none");
            $("#divMemberInfo").css("display", "none");
        });
    </script>
</head> 
<body>
    <form id="frmMemInfo" >
    <div class="system_Info box_right">
        <div class="system_Top">
            <div class="user_regist_title">
               	<utils:title/>
            </div>
        </div>
        <div class="user_List_All" style="margin-bottom: 0px">    
             <jsp:include page="../Controls/MemberSearch.jsp"/>
        </div>
        <div class="user_regist_Allleft" style="clear: both; float: none;">
            <div class="user_regist_left">
                <div class="user_regist_infor" style="text-align: left">
                    快速菜单
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="user_List_styleRight">
                            <div class="user_List_Button">
                                <input id="btnEditMem"  cls="64" type="button" value="会员编辑" class="common_Button" />
                                <input id="btnExpense"  cls="17" type="button" value="快速消费" class="common_Button" />
                                <input id="btGoodsExpense" cls="67"  type="button" value="商品消费" class="common_Button" />
                                <input id="btTimeExpense" cls="87"  type="button" value="计时消费" class="common_Button" />
                                <input id="btConsumeMemCount" cls="118"  type="button" value="计次消费" class="common_Button" />
                                <input id="btnRechargeMoney" cls="4"  type="button" value="会员充值" class="common_Button" />
                                <input id="btnRechargCount" cls="66"  type="button" value="会员充次" class="common_Button" />
                                <input id="btnExchangeGift" cls="14"  type="button" value="兑换礼品" class="common_Button" />
                                <input id="btnSendSMS" cls="46"  type="button" value="发送短信" class="common_Button" />
                            </div>
                        </td>
                    </tr>
                </table>

                <div style="padding-top: 3px">
                    <!--菜单-->
                    <div class="tabBox" id="ExchangeTab">
                        <ul class="tab">
                            <li id="tab0" class="on">会员基本资料</li>
                            <li id="tab1">会员消费记录</li>
                            <li id="tab2">会员充值记录</li>
                            <li id="tab3">会员充次记录</li>
                            <li id="tab4">礼品兑换记录</li>
                            <li id="tab5">会员优惠券记录</li>
                            <li id="tab6">会员来电记录</li>
                        </ul>
                    </div>
                    <!--会员资料-->
                    <div>
                        <table id="MainContent0" style="margin: 10px 10px 10px 2px;">
                            <tr>
                                <td style="vertical-align: top">
                                    <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                                        style="width: 600px;">
                                        <tr>
                                            <td class="tableStyle_left">
                                                会员卡号：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemCard"  />
                                            </td>
                                            <td class="tableStyle_left">
                                                会员姓名：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemName"  />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                卡面号码：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemCardNumber" ></Label>
                                            </td>
                                            <td class="tableStyle_left">
                                                手机号码：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemMobile" ></Label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                会员余额：
                                            </td>
                                            <td class="tableStyle_right">
                                                <font color="red">
                                                    <Label id="txtMemMoney" ></Label></font>
                                            </td>
                                            <td class="tableStyle_left">
                                                会员积分：
                                            </td>
                                            <td class="tableStyle_right">
                                                <font color="red">
                                                    <Label id="txtMemPoint" ></Label></font>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                会员等级：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemLevel"  ></Label>
                                            </td>
                                            <td class="tableStyle_left">
                                                会员状态：
                                            </td>
                                            <td class="tableStyle_right">
                                                <font color="red">
                                                    <Label id="txtMemState"  ></Label></font>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                所属店铺：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemShop"  ></Label>
                                            </td>
                                            <td class="tableStyle_left">
                                                过期时间：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemPastTime"  ></Label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                会员生日：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemBirthday"  ></Label>
                                            </td>
                                            <td class="tableStyle_left">
                                                会员性别：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemSex"  ></Label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                身份证号：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemIdentityCard" ></Label>
                                            </td>
                                            <td class="tableStyle_left">
                                                电子邮箱：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemEmail"  ></Label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                办卡时间：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemCreateTime" ></Label>
                                            </td>
                                            <td class="tableStyle_left">
                                                办卡人员：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label ID="txtMemUserName"  ></Label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                固定电话：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtTelephone"  ></Label>
                                            </td>
                                            <td class="tableStyle_left">
                                                推荐人卡号：
                                            </td>
                                            <td class="tableStyle_right">
                                                <Label id="txtMemRecommendCard"  ></Label>
                                            </td>
                                        </tr>
                                        <tr id="trIsPast">
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                联系地址：
                                            </td>
                                            <td class="tableStyle_right" colspan="3">
                                                <Label id="txtMemAddress" ></Label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tableStyle_left">
                                                备注：
                                            </td>
                                            <td class="tableStyle_right" colspan="3">
                                                <%--<Label ID="txtMemRemark"  Text=""></Label>--%>                                                
                                                <textarea id="txtMemRemark" rows="3"  style="width: 100%; word-wrap: break-word;outline: none; resize: none;"  readonly="readonly"></textarea>
                                                <input id="MemCard" type="hidden"  />
                                            </td>
                                            <td style="display: none">
                                                <input id="chkIsPast"  type="checkbox" />
                                            </td>
                                        </tr>
                                        <tbody id="MemInfoCustomField" >
                                            <tr>
                                                <td class="tableStyle_right" colspan="4" style="padding: 5px;">
                                                    正在加载自定义属性，请稍候……
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                                <td align="left" valign="top">
                                    <table class="tableStyle" cellspacing="0" cellpadding="2">
                                        <tr>
                                            <td>
                                                <img alt="" id="imgMemPhoto" src="../images/member/nophoto.gif" width="180"  />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <!--消费记录-->
                    <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent1">
                        <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                            style="width: 100%;" id="MemInfoExpense">
                            <tr>
                                <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                    colspan="6" type="LoadingBar">
                                    <script type="text/javascript">
                                        ListLoading();
                                    </script>
                                </td>
                            </tr>
                        </table>
                        <div id="MemInfoExpenseListPage" style="margin: 0px; border: solid 1px #ccc; height: 30px;">
                            <div class="listTablePage_simple">
                            </div>
                        </div>
                    </div>
                    <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent2">
                        <table border="0" cellpadding="0" cellspacing="1" class="table-style table-hover user_List_txt"
                            width="100%" id="MemInfoRecharge">
                            <tr>
                                <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                    colspan="6" type="LoadingBar">
                                    <script type="text/javascript">
                                        ListLoading();
                                    </script>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent3">
                        <table border="0" cellpadding="0" cellspacing="1" class="table-style table-hover user_List_txt"
                            width="100%" id="MemInfoRechargeCount">
                            <tr>
                                <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                    colspan="6" type="LoadingBar">
                                    <script type="text/javascript">
                                        ListLoading();
                                    </script>
                                </td>
                            </tr>
                        </table>
                        <div id="MemInfoRechargeCountListPage" style="margin: 0px; border: solid 1px #ccc;
                            height: 30px;">
                            <div class="listTablePage_simple">
                            </div>
                        </div>
                    </div>
                    <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent4">
                        <table border="0" cellpadding="0" cellspacing="1" class="table-style table-hover user_List_txt"
                            width="100%" id="MemInfoExchangeGift">
                            <tr>
                                <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                    colspan="6" type="LoadingBar">
                                    <script type="text/javascript">
                                        ListLoading();
                                    </script>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent5">
                        <table border="0" cellpadding="0" cellspacing="1" class="table-style table-hover user_List_txt"
                            width="100%" id="MemInfoCoupon">
                            <tr>
                                <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                    colspan="6" type="LoadingBar">
                                    <script type="text/javascript">
                                        ListLoading();
                                    </script>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div style="margin: 10px 10px 10px 2px; display: none;" id="MainContent6">
                        <table border="0" cellpadding="0" cellspacing="1" class="table-style table-hover user_List_txt"
                            width="100%" id="MemInfoMobile">
                            <tr>
                                <td style="height: 20px; line-height: 50px; padding-left: 20px; background-color: #fff;"
                                    colspan="6" type="LoadingBar">
                                    <script type="text/javascript">
                                        ListLoading();
                                    </script>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
