<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="<%=request.getContextPath()%>/Inc/Style/Style.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/Module/SystemManage/SysParameter.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/Module/Common/Tab.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/Inc/Style/uploadify.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/Scripts/jquery.uploadify.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/jquery.uploadify.swfobject.js" type="text/javascript"></script>
    <object style='display: none;' id='CardReader' classid='clsid:27DD3937-FA54-45B2-9A51-64D58826AC01'>
    </object>
    <script type="text/jscript">
        $(document).ready(function () {
            var exchangeTab = new CommonTab("RemindTab", "", function (index) { });
            $("#chkIsStartGood").bind("click", function () {
                var status = $(this).attr("checked");
                if (status) {
                    $("#chkIsStartTimingProject,#chkIsStartMemCount").attr("disabled", false);
                } else {
                    $("#chkIsStartTimingProject,#chkIsStartMemCount").attr("disabled", true);
                }
            });
            // 图片上传处理
            //if (location.href.toLowerCase().indexOf("SysParameter.aspx") != -1) {
            $("#MainPhoto_Uploadify").uploadify({
                'uploader': "../images/swf/uploadify.swf",
                'script': project_name+"util/uploadImg.do?WebImage=main",
                'cancelImg': "../images/member/cancel.png",
                'folder': "../Upload/WebImage/",
                'queueID': 'Main_fileQueue',
                'buttonImg': "../images/member/selectImg.jpg",
                'height': 25,
                'width': 71,
                'fileExt': "*.jpg;*.jpeg;*.gif;*.png;*.bmp",
                'fileDesc': "请选择格式为PNG的图片",
                'auto': false,
                'multi': false,
                'sizeLimit': 512000,
                'onError': function (event, ID, fileObj, errorObj) {
                    if (errorObj.type == "File Size")
                        alert("对不起，上传的图片不能超过500K");
                    else
                        alert(errorObj.type + ' Error: ' + errorObj.info);
                },
                'onComplete': function (event, ID, fileObj, response, data) {
                  var json=jQuery.parseJSON(response);
                  if(json.result==1){
	                	  
                	  $("#imgMainPhoto").attr("src", project_name+json.newfile+  "?temp=" + Math.random());
                      
                      $("#txtMainPhoto").val(json.newfile);
                  }
                  
                	
                }
            });

            $("#MainLogin_Uploadify").uploadify({
                'uploader': "../images/swf/uploadify.swf",
                'script': project_name+"util/uploadImg.do?WebImage=MainLogin",
                'cancelImg': "../images/member/cancel.png",
                'folder': "../Upload/WebImage/",
                'queueID': 'MainLogin_fileQueue',
                'buttonImg': "../images/member/selectImg.jpg",
                'height': 25,
                'width': 71,
                'fileExt': "*.png;",
                'fileDesc': "请选择格式为PNG的图片",
                'auto': false,
                'multi': false,
                'sizeLimit': 512000,
                'onError': function (event, ID, fileObj, errorObj) {
                    if (errorObj.type == "File Size")
                        alert("对不起，上传的图片不能超过500K");
                    else
                        alert(errorObj.type + ' Error: ' + errorObj.info);
                },
                'onComplete': function (event, ID, fileObj, response, data) {
                	   var json=jQuery.parseJSON(response);
                       if(json.result==1){
                        $("#imgMainLogin").attr("src", project_name+json.newfile+  "?temp=" + Math.random());
                        $("#txtMainLogin").val(json.newfile);
                    }
                }
            });




            $("#SelfPhoto_Uploadify").uploadify({
                'uploader': "../images/swf/uploadify.swf",
                'script': project_name+"util/uploadImg.do?WebImage=self",
                'cancelImg': "../images/member/cancel.png",
                'folder': "../Upload/WebImage/",
                'queueID': 'Self_fileQueue',
                'buttonImg': "../images/member/selectImg.jpg",
                'height': 25,
                'width': 71,
                'fileExt': "*.png;",
                'fileDesc': "请选择格式为PNG的图片",
                'auto': false,
                'multi': false,
                'sizeLimit': 512000,
                'onError': function (event, ID, fileObj, errorObj) {
                    if (errorObj.type == "File Size")
                        alert("对不起，上传的图片不能超过500K");
                    else
                        alert(errorObj.type + ' Error: ' + errorObj.info);
                },
                'onComplete': function (event, ID, fileObj, response, data) {
                	 var json=jQuery.parseJSON(response);
                     if(json.result==1){
                    	 alert(project_name+json.newfile+"?temp=" + Math.random());
                    	 $("#imgSelfPhoto").attr("src", project_name+json.newfile+"?temp=" + Math.random());
                        
                        $("#txtSelfPhoto").val(json.newfile);
                    }
                }
            });



            $("#SelfLogin_Uploadify").uploadify({
                'uploader': "../images/swf/uploadify.swf",
                'script': project_name+"util/uploadImg.do?WebImage=SelfLogin",
                'cancelImg': "../images/member/cancel.png",
                'folder': "../Upload/WebImage/",
                'queueID': 'SelfLogin_fileQueue',
                'buttonImg': "../images/member/selectImg.jpg",
                'height': 25,
                'width': 71,
                'fileExt': "*.png;",
                'fileDesc': "请选择格式为PNG图片",
                'auto': false,
                'multi': false,
                'sizeLimit': 512000,
                'onError': function (event, ID, fileObj, errorObj) {
                    if (errorObj.type == "File Size")
                        alert("对不起，上传的图片不能超过500K");
                    else
                        alert(errorObj.type + ' Error: ' + errorObj.info);
                },
                'onComplete': function (event, ID, fileObj, response, data) {
                		
                	var json=jQuery.parseJSON(response);
                     if(json.result==1){
                        	
                    	 $("#imgSelfLogin").attr("src", project_name+json.newfile+"?temp=" + Math.random());
                        $("#txtSelfLogin").val(json.newfile);
                    }
                }
            });


        })
    </script>
    <style type="text/css">
        .tableStyle_left
        {
            width: 200px;
            text-align: left;
            padding-left: 5px;
        }
        
        .border_radius
        {
            float: none;
        }
    </style>
</head>
<body>
    <form id="frmSysParameter" >
   
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title />
                        </div>
                    </div>
                    <div class="user_List_All">
                        <table class="table-style table-hover user_List_txt">
                            <div>
                                <div class="tabBox" id="RemindTab" style="width: 95%">
                                    <ul class="tab">
                                        <li id="tab0" class="on">会员参数设置</li>
                                        <%-- <li id="tab1">单号前缀设置</li>--%>
                                        <li id="tab1">付费找零设置</li>
                                        <li id="tab2">员工提成设置</li>
                                        <li id="tab3">打印设置</li>
                                        <%-- <li id="tab5">系统邮箱设置</li>--%>
                                        <li id="tab4">网上支付设置</li>
                                        <li id="tab5">功能开关设置</li>
                                        <li id="tab6">IC卡设置</li>
                                        <li id="tab7" >系统图片</li>
                                    </ul>
                                </div>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 95%;" id="MainContent0">
                                    <tr style="display:none">
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align:middle">
                                                    <input id="ckbRegNullPwd"  type="checkbox" />
                                                    允许会员卡密码为空
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员[登记]时密码可以为空
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkPwd"  type="checkbox" />
                                                    启用密码验证
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员[登记]时强制设定密码,[商品消费][会员换卡]时必须输入密码确认行为
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkIsNeedPwd"  type="checkbox" />
                                                    会员重置密码时验证原始密码
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员[密码重置]强制设定输入原始密码,保证会员账户安全性
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkMoneyAndPoint"  type="checkbox" />
                                                    启用会员登记赠送余额及积分
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            登记会员信息时可录入赠送给会员的初始余额和积分（默认为0）
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkAutoLevel"  type="checkbox" />
                                                    启用积分转换等级
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员积分发生异动时，是否根据会员等级积分设定进行转换等级
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <input type="checkbox" id="chkDegradeLevel"  />
                                                会员等级允许降级
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员积分发生扣减异动时，是否根据会员等级积分设定进行降级检查（此项需【启用积分转换等级】参数生效,且发生扣减积分行为会员所属等级处于未锁定状态）
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkPastTime"  type="checkbox" />
                                                    设置会员过期时间
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可设定会员账户过期时间,会员若过期则无法进行相关操作
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkPointLevel"  type="checkbox" />
                                                    启用会员多级积分提成
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项可设定多级推荐会员制度,最高可设定15级推荐制
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <input id="chkIsMustSlotCard"  type="checkbox" />
                                                启用会员必须刷卡消费
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启动该选项则可设定会员只允许刷卡进行消费
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            推荐会员获得积分&nbsp;<input type="text" id="txtRecommendPoint" class="border_radius" 
                                                style="width:80px;" maxlength="8" />
                                        </td>
                                        <td class="tableStyle_right">
                                            会员注册时，推荐人可获得积份数
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            账户提现折损比率&nbsp;<input type="text" id="txtDrawMoneyPercent" class="border_radius" 
                                                style="width:80px;"/>
                                        </td>
                                        <td class="tableStyle_right">
                                            如0.5表示10元账户余额可以折现5元，1表示余额可全额折现
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            积分清零提醒周期&nbsp;<input type="text" id="txtPointPeriod" class="border_radius" 
                                                style="width:80px;" value="0"/>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员在多少天没来消费，系统进行积分清零提醒（单位天）
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            商品库存报警数量&nbsp;<input type="text" id="txtStockCount"  class="border_radius"
                                                style="width:80px;" value="0"/>
                                        </td>
                                        <td class="tableStyle_right">
                                            店铺商品库存不足多少时，系统进行提醒库存不足
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            商品单位
                                            <input type="text"  class="border_radius" id="txtUnitList" style="width:80px;" />
                                        </td>
                                        <td class="tableStyle_right">
                                            商品单位（每个单位之间以“|”隔开）
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent98">
                                    <tr>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            商品入库单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtGoodsInPrefix" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            商品调拨单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtGoodsAllotPrefix" class="border_radius"  />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            快速消费单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtExpensePrefix" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            商品消费单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtGoodsExpensePrefix" class="border_radius"  />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            计时消费单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtTimeExpensePrefix" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            会员充时单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtStorageTimingPrefix" class="border_radius"  />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            会员充次单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtMemCountPrefix" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            会员充值单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtMemRechargePrefix" class="border_radius"  />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            会员提现单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtMemDrawMoneyPrefix" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            兑换礼品单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtGiftExchangePrefix" class="border_radius"  />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            积分变动单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtMemPointChangePrefix" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_left" style="text-align: right; width: 150px;">
                                            计次消费单号前缀：
                                        </td>
                                        <td class="tableStyle_right">
                                            <input type="text" ID="txtMemCountExpensePrefix" class="border_radius"  />
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent1">
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkPayCard"  type="checkbox" />
                                                    启用余额支付
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            该选项可开启支付找零时的余额支付功能
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkPayCash"  type="checkbox" />
                                                    启用现金支付
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            该选项可开启支付找零时的现金支付功能
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkPayBink"  type="checkbox" />
                                                    启用银联支付
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            该选项可开启支付找零时的银联支付功能
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkPayCoupon"  type="checkbox" />
                                                    启用优惠券
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            该选项可开启支付找零时的优惠券功能
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent2">
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkMemRegisterStaff"  type="checkbox" />
                                                    启用会员登记员工提成功能
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则在会员[登记]时为员工进行提成
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" colspan="2">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkStaff"  type="checkbox" />
                                                    启用会员消费员工提成功能
                                                </label>
                                            </label>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input type="radio" name="staff" id="rdStaff" checked="true"  />
                                                    按员工提成比例提成
                                                </label>
                                            </label>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input type="radio" name="staff" id="rdGoods"  />
                                                    按商品提成类型提成
                                                </label>
                                            </label>
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent3">
                                    <tr>
                                        <td class="tableStyle_left" style="width: 25%">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkAutoPrint"  type="checkbox" />
                                                    启用打印功能
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            如具备打印设备,可启用该选项进行相关单据的打印
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="width: 25%">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="PrintPreview"  type="checkbox" />
                                                    是否启用打印预览
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            如果启用打印预览，点击打印时，先弹出预览界面，再次点击才打出小票！不启用预览点击一次直接打出小票
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="width: 25%">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <span>
                                                    <label style="vertical-align: middle; display: none;">
                                                        <input id="A4ShiZhi"  type="checkbox" />
                                                        A4纸张
                                                    </label>
                                                </span>
                                                <label style="vertical-align: middle;">
                                                    <input id="SanLianShiZhi"  type="checkbox" />
                                                    三联纸张
                                                </label>
                                                <label style="vertical-align: middle; margin-left: 4px;">
                                                    <input id="POs58ShiZhi"  type="checkbox" />
                                                    58mm纸张
                                                </label>
                                                <label style="vertical-align: middle; margin-left: 4px;">
                                                    <input id="POs80ShiZhi"  type="checkbox" />
                                                    80mm纸张
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            三联打印纸张，58mm纸张和80mm纸张3种打印纸张供选择！（3种纸张只能同时使用一种！）
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkAccordPrint"  type="checkbox" />
                                                    各店铺打印小票标题和脚注都一致
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则系统中所有打印单据的标题和脚注都保持一致
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            打印小票标题：<input type="text" id="txtPrintTitle" class="border_radius" Width="150"  />
                                        </td>
                                        <td class="tableStyle_right">
                                            若启用打印标题和脚注一致功能，则打印此处设定的小票标题
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            打印小票脚注：<input type="text" id="txtPrintFootNote" class="border_radius" Width="150"  />
                                        </td>
                                        <td class="tableStyle_right">
                                            若启用打印标题和脚注一致功能，则打印此处设定的小票脚注
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置会员充值打印份数：<input type="text" id="Txthycz" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' onpaste="this.value=this.value.replace(/[\W]/g,'')" />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为会员充值，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置积分变动打印份数：<input type="text" id="Txtjfbd" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为积分变动，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置积分兑换打印份数：<input type="text" id="Txtjfdh" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为积分兑换，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置商品入库打印份数：<input type="text" id="Txtsprk" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为商品入库，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置商品消费打印份数：<input type="text" id="Txtspxf" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为商品消费，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置计次消费打印份数：<input type="text" id="Txtjcxf" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为计次消费，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置快速消费打印份数：<input type="text" id="Txtksxf" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为快速消费，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置会员充次打印份数：<input type="text" id="Txthycc" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为会员充次，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置会员充时打印份数：<input type="text" id="Txthycs" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为会员充时，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置消费记录打印份数：<input type="text" id="Txtxfjl" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为消费记录，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置账户提现打印份数：<input type="text" id="AccountsToMoney" class="border_radius"  style="width:30px;" value="1" onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为账户提现，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置会员充值报表打印份数：<input type="text" id="Txthyczbb" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为会员充值报表，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置积分变动报表打印份数：<input type="text" id="Txtjfbdbb" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为积分变动报表，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置积分兑换报表打印份数：<input type="text" id="Txtjfdhbb" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为积分兑换报表，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            设置商品出入库明细打印份数：<input type="text" id="Txtckrkmx" class="border_radius" style="width:30px;" value="1"
                                                 onkeyup='this.value=this.value.replace(/\D/gi,"")' />
                                        </td>
                                        <td class="tableStyle_right">
                                            设置后，当为商品出入库明细，就会打出你设置的份数！
                                        </td>
                                    </tr>
                                </table>
                                <%--    <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle"
                                    id="tableWeiXin" style="display: none;">
                                    <tr>
                                        <th class="tableStyle_left" style="text-align: center;">
                                            上传照片
                                        </th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div>
                                                <img alt="" id="weixinPhoto" src="../images/member/nophoto.gif" width="320" height="160" /><br />
                                                <span style="color: Red">相片支持大小为640*320</span>
                                            </div>
                                            <div style="margin-top: 10px; height: 30px;">
                                                <div style="width: 83px; height: 25px; float: right; margin-left: 20px;">
                                                    <input id="weixinPhoto_Uploadify" type="file" style="display: none;" class="buttonColor" />
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </table>--%>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent99">
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label style="vertical-align: text-bottom;">
                                                <label class="lbsetCk" style="vertical-align: middle;">
                                                    <input id="chkEmail"  type="checkbox" onclick="IsMoneyEmail()" />
                                                    启用系统邮件功能
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            如具备企业邮箱，可启用该选项进行相关系统发送邮件功能
                                        </td>
                                    </tr>
                                    <tr style="display: none;">
                                        <td class="tableStyle_left">
                                            <label style="vertical-align: text-bottom;">
                                                <label class="lbsetCk" style="vertical-align: middle;">
                                                    <input id="chkMoneyEmail"  type="checkbox" />
                                                    启用系统邮件自动发送功能
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启动该选项则在会员账户信息变动时自动为登记邮件的会员发送邮件，如[消费][充值][积分变动]
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="width: 30%;">
                                            企业邮箱用户：<input type="text" id="txtEmailUserName" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要会员能够进行邮箱找回密码或者发送邮件，则此处设定企业邮箱的用户名
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="width: 30%;">
                                            企业邮箱账号：<input type="text" id="txtEmailAdress" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要会员能够进行邮箱找回密码或者发送邮件，则此处设定企业邮箱的账号
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            企业邮箱密码：<input type="text" id="txtEmailPwd" textmode="Password" class="border_radius"/>
                                                
                                            <label id="lblEmailPwd"  Style="display: none;" />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要会员能够进行邮箱找回密码或者发送邮件，则此处设定企业邮箱的密码
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            SMTP&nbsp;服务器：
                                            <input type="text" id="txtEmailSMTP"  class="border_radius" />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要会员能够进行邮箱找回密码或者发送邮件，则此处设定SMTP服务器
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="width: 30%">
                                            企业邮箱端口：<input type="text" id="txtEnterpriseEmailPort" class="border_radius common_ServiceButton"
                                                 value="25" />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要可以发送电子邮件，则此处设定商家企业邮箱端口（默认为25）
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="width: 30%">
                                            发件人姓名：&nbsp;&nbsp;<input type="text" ID="txtEnterpriseEmailDisplayName" class="border_radius common_ServiceButton"
                                                 />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要可以发送电子邮件，则此处设定商家企业邮箱发件人邮箱
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkEnterpriseEmailEnableSSL"  type="checkbox" />
                                                    启用企业邮箱SSL加密
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则企业邮箱使用SSL加密(默认为不打勾)
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkEnterpriseEmailUseDefaultCredentials"  type="checkbox" />
                                                    启用企业邮箱默认凭据
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则企业邮箱使用默认凭据(默认为不打勾)
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent4">
                                    <tr>
                                        <td class="tableStyle_left" style="width: 30%">
                                            商家支付宝账户：&nbsp;<input type="text" id="txtSellerAccount" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要会员可以在自助平台使用支付宝网上支付，则此处设定商家支付宝账户
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            合作者身份(PID)：<input type="text" id="txtPartnerID" class="border_radius"  />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要会员可以在自助平台使用支付宝网上支付，则此处设定合作者身份
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            交易安全检验码：&nbsp;<input type="text" id="txtPartnerKey" class="border_radius" textmode="Password"
                                                />*
                                            <label id="lblPartnerKey"  style="display: none;" />
                                        </td>
                                        <td class="tableStyle_right">
                                            若要会员可以在自助平台使用支付宝网上支付，则此处设定交易安全检验码
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent5">
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkIsAutoSendSMSByMemPast"  type="checkbox" />
                                                    会员到期自动发送短信
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员到期提醒提前&nbsp;
                                            <input type="text"  class="border_radius" id="txtAutoSendSMSByMemPastForDay"
                                                Width="40px" value="0"/>&nbsp;天
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chksAutoSendSMSByMemBirthday"  type="checkbox" />
                                                    会员生日自动发送短信
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            会员生日提醒提前&nbsp;
                                            <input type="text"  class="border_radius" id="txtAutoSendSMSByMemBirthdayForDay"
                                                Width="40px" value="0"/>&nbsp;天
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="CKautoBackup"  type="checkbox" />
                                                    启用系统自动备份数据库
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            间隔多久备份一次&nbsp;
                                            <input type="text"  class="border_radius" id="TBautoBackupDay" Width="40px"
                                                vlaue="1" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
                                            &nbsp;天 &nbsp;&nbsp;注意：本系统最多可备份3个文件，当启用自动备份功能后，系统会自动删除最早备份的那个文件，然后备份！
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkIsStartWeiXin"  type="checkbox" />
                                                    启用微信
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可以使用系统的微信功能 (需刷新系统生效)
                                        </td>
                                    </tr>
                                    <tr  id="lblIsStartTiming">
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkIsStartTimingProject"  type="checkbox" />
                                                    启用计时服务
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可以使用系统的计时服务功能 (需刷新系统生效)
                                        </td>
                                    </tr>
                                    <tr  id="lblIsStartMemCount">
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkIsStartMemCount"  type="checkbox" />
                                                    启用会员充次
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可以使用对服务项目的充次功能 (需刷新系统生效)
                                        </td>
                                    </tr>
                                    <tr  id="lblIsSettlement">
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkIsSettlement"  type="checkbox" />
                                                    启用店铺结算功能
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可以使用系统的店铺结算功能
                                        </td>
                                    </tr>
                                    <tr  id="lblIsStartSendCard">
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkIsSendCard"  type="checkbox" />
                                                    启用店铺购卡
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可以使用系统的店铺购卡功能
                                        </td>
                                    </tr>
                                    <tr  id="lblIsStartShopSmsMenage">
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkShopSmsManage"  type="checkbox" />
                                                    启用联盟商短信管理
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可以设置联盟商所能使用的短信数量的上限
                                        </td>
                                    </tr>
                                    <tr  id="lblIsStartShopPointMenage">
                                        <td class="tableStyle_left">
                                            <label class="lbsetCk" style="vertical-align: middle;">
                                                <label style="vertical-align: middle;">
                                                    <input id="chkShopPointManage"  type="checkbox" />
                                                    启用联盟商积分管理
                                                </label>
                                            </label>
                                        </td>
                                        <td class="tableStyle_right">
                                            启用该选项则可以设置联盟商的积分上限，不启用则不限制联盟商所能支配的积份数量
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%; display: none;"
                                    id="MainContent6">
                                    <tr>
                                        <th style="text-align: center; font-weight: bold; height: 25px" class="th" colspan="2">
                                            IC卡设置
                                        </th>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="width:100px" >
                                           <input type="checkbox" id="chkSenseiccard" />启用感应式IC卡 
                                        </td>
                                        <td class="tableStyle_right">
                                           <span style="color: #ff4800; font-weight:bold"> 启用该选项可用感应式IC卡读写机读取会员卡中的会员卡号 此功能必须使用IE浏览器并安装相应插件才可正常使用</span>
                                        </td>
                                    </tr>
                                    <tr style="display: none">
                                        <td class="tableStyle_left">
                                            <input type="checkbox" id="chkContacticcard"  value="启用接触式IC卡" />启用接触式IC卡
                                        </td>
                                        <td class="tableStyle_left">
                                            启用该选项可用接触式IC卡读写机读取会员卡中的会员卡号
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" >
                                          <input type="button" id="btnSenseICCardInit" value="感应式IC卡初始化" />
                                           <input type="button" style="display: none" id="btnContactICCardInit"
                                                value="接触式IC卡初始化" />
                                        </td>
                                        <td class="tableStyle_right">
                                           功能：此功能是将已发卡的IC卡重新初始化到初始状态，以便对其重新发卡。<br />
                                           注意：IC卡初始化之后，此卡对应的旧的相关记录任保存在软件中，无用的信息请手动删除。<br />
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="3" style="width: 90%; display: none;"
                                    id="MainContent7">
                                    <tr>
                                        <th style="text-align: left; font-weight: bold; height: 25px" class="th" colspan="3">
                                            系统LOGO 图片格式：*.png 分辨率600*55
                                        </th>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="height: 80px; background: url(../Inc/Style/images/head_top.png);
                                            background-repeat: repeat; background-size: contain">
                                            <div>
                                                <img alt="" id="imgMainPhoto" src="../Upload/WebImage/main.png" style="width: 380px;
                                                    height: 55px"  /><br />
                                                <input type="hidden" id="txtMainPhoto"  />
                                            </div>
                                        </td>
                                        <td class="tableStyle_left">
                                            <input id="MainPhoto_Uploadify" type="file" class="common_Button common_ServiceButton" />
                                            <input id="btnMainPhotoUpload" style="margin-left: 16px;" type="button" class="common_Button"
                                                value="上传图片" onclick="javascript: $('#MainPhoto_Uploadify').uploadifyUpload();" />
                                        </td>
                                        <td class="tableStyle_left">
                                            <div id="Main_fileQueue">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: left; font-weight: bold; height: 25px" class="th" colspan="3">
                                            系统登录背景 图片格式：*.png 分辨率1440*768
                                        </th>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="height: 400px;">
                                            <div>
                                                <img alt="" id="imgMainLogin" src="../Upload/WebImage/MainLogin.png" style="width: 100%;
                                                    height: 400px"  /><br />
                                                <input type="hidden" id="txtMainLogin"  />
                                            </div>
                                        </td>
                                        <td class="tableStyle_left">
                                            <input id="MainLogin_Uploadify" type="file" class="common_Button common_ServiceButton" />
                                            <input id="btnMainLoginUpload" style="margin-left: 16px;" type="button" class="common_Button"
                                                value="上传图片" onclick="javascript: $('#MainLogin_Uploadify').uploadifyUpload();" />
                                        </td>
                                        <td class="tableStyle_left">
                                            <div id="MainLogin_fileQueue">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: left; font-weight: bold; height: 25px" class="th" colspan="3">
                                            会员自助LOGO  分辨率600*55
                                        </th>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="height: 80px; background: url(../Inc/Style/images/head_top.png);
                                            background-repeat: repeat; background-size: contain">
                                            <div>
                                                <img alt="" id="imgSelfPhoto" src="../Upload/WebImage/self.png" style="width: 380px;
                                                    height: 55px"  /><br />
                                                <input type="hidden" id="txtSelfPhoto"  />
                                            </div>
                                        </td>
                                        <td class="tableStyle_left">
                                            <input id="SelfPhoto_Uploadify" type="file" class="common_Button common_ServiceButton" />
                                            <input id="btnSelfPhotoUpload" style="margin-left: 16px;" type="button" class="common_Button"
                                                value="上传图片" onclick="javascript: $('#SelfPhoto_Uploadify').uploadifyUpload();" />
                                        </td>
                                        <td class="tableStyle_left">
                                            <div id="Self_fileQueue">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: left; font-weight: bold; height: 25px" class="th" colspan="3">
                                            系统登录背景 图片格式：*.png 分辨率1440*768
                                        </th>
                                    </tr>
                                    <tr>
                                        <td class="tableStyle_left" style="height: 400px;">
                                            <div>
                                                <img alt="" id="imgSelfLogin" src="<%=request.getContextPath()%>/Upload/WebImage/SelfLogin.png" style="width: 100%;
                                                    height: 400px"  /><br />
                                                <input type="hidden" id="txtSelfLogin"  />
                                            </div>
                                        </td>
                                        <td class="tableStyle_left">
                                            <input id="SelfLogin_Uploadify" type="file" class="common_Button common_ServiceButton" />
                                            <input id="btnSelfLoginUpload" style="margin-left: 16px;" type="button" class="common_Button"
                                                value="上传图片" onclick="javascript: $('#SelfLogin_Uploadify').uploadifyUpload();" />
                                        </td>
                                        <td class="tableStyle_left">
                                            <div id="SelfLogin_fileQueue">
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                                <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 90%;">
                                    <tr>
                                        <td style="text-align: center; height: 36px" colspan="2">
                                            <input type="button" id="saveParameter"  value="保   存" class="buttonColor" onclick="return  checkPayType();"
                                              />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
