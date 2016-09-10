<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>智络连锁店会员管理系统_连锁店会员积分系统—在线免费试用地址</title>
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <meta name="keywords" content="连锁会员管理系统 专业版" />
    <link href="Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    <link href="Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="Scripts/Module/System/Login.js" type="text/javascript"></script>
    <script src="Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    
    <script>
   	if (top.location !== self.location) {
    top.location=self.location;
	}
   </script>
    
   
</head>
<body  id="loginBody" style="overflow-y: hidden">
    <ul class="s-skin-container" id="bg-container">
        <li id="bg0" style="background-image: url(Upload/WebImage/MainLogin.png)"></li>
    </ul>
    <div class="wrapper">
        <div class="logo-bar">
            <a class="logo" id="imgLogo" >连锁会员管理软件--专业版</a></div>
        <div class="content">
            <div class="content-bg">
            </div>
            <div class="line-bg">
            </div>
            <div class="main">
                <div class="login-mod">
                    <div class="title1">
                        用户登录</div>
                    <div class="loginbox">
                        <label id="AccountLabel" for="txtAccount" class="tips">
                            登录账号</label>
                        <input id="txtAccount" type="text" maxlength="20" class="user-text" 
                            value="" />
                        <input id="txtIsType" type="hidden"  />
                        <input id="txtISCheckKey" type="hidden"  />
                        <label id="passwordLabel" for="txtPassword" class="tips ptips">
                            登录密码</label>
                        <input id="txtPassword" name="txtPassword" type="password" maxlength="20" autocomplete="off"
                            class="user-text" value=""  />
                        <label id="valcodeLabel" for="txtValCode" class="tips2">
                            验证码</label>
                        <input id="txtValCode" type="text" class="user-text2" value="" maxlength="4" />
                        <div class="check">
                            <a href="javascript:void(0);" onclick="javascript:Login_ChangeValImg();">
                                <img id="Login_ValImg" src="" style="height: 30px; width: 90px; border: 0" alt=""
                                    title="看不清？换一个" align="top" /></a>
                        </div>
                        <p>
                            <input id="btnSubmit" type="button" value="登录" class="login-btn" onclick="javascript:Login_Submit();" />&nbsp;&nbsp;
                            <input id="btnReset" type="button" value="重置" class="login-btn2" />
                        </p>
                    </div>
                </div>
            </div>
            <div class="aside">
                <div class="title2">
                    <a id="aSelf"  target="_blank">点击进入会员自助平台</a></div>
                <p>
                    <a href="Common/Exec.aspx?todo=shortcut">添加快捷桌面</a>| <a href='javascript:bookmark()'>
                        加入收藏</a>
                </p>
                <div class="title_pic">
                    会员越来越多，生意越来越好！</div>
            </div>
        </div>
    </div>
    <div id="divFoot"  class="footer-nav-box">
        <div class="footer-nav">
            <div class="copyright">
                <span id="spCompName" >Copyright © 智络科技 2012-2014</span> <span id="spBeiAn"
                    ><a id="aBeiAnName"  href="http://www.miitbeian.gov.cn"
                        target="_blank"></a></span><span id="spEdition" ></span><span id="spDesc"
                             style="display: none"></span>
            </div>
            <p  id="pHelpInfo">
                <a href="http://www.liansuohuiyuan.net/" target='_blank'>公司网址</a>|<a href="http://kchelp.vip5968.net/"
                    target='_blank'>帮助文档</a>|<a href="http://www.liansuohuiyuan.net/about-664.html" target='_blank'>联系方式</a>|<a>热线4000-525-526</a>
            </p>
        </div>
    </div>
</body>
</html>
