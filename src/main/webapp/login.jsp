<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>欢迎登陆会员管理系统</title>
     <link href="Inc/Style/Style.css" rel="stylesheet" type="text/css" />
 
<link  href="Inc/Style/login.css" rel="stylesheet" type="text/css" />
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

<body>
<div class="main-login">
  <div class="login-logo"> </div>
  <div class="login-content">
    <input type="hidden" id="path" value="" />
    <form action="" method="post" id="login-form" name="login-form">
      <div class="login-info"> <span class="user">&nbsp;</span>
        <input name="username" id="txtAccount" type="text"   placeholder="请输入手机号/会员卡号" value="" class="login-input"/>
         </div>
      <div class="login-info"> <span class="pwd">&nbsp;</span>
        <input name="password" id="txtPassword" type="password"  placeholder="请输入密码" value="" class="login-input"/>
        </div>
        
      <div class="login-info1">
        <input  id="txtValCode" type="text"  placeholder="验证码" maxlength="4" class="login-input1"/>
        
      </div>
      <div>
       <a href="javascript:void(0);" onclick="javascript:Login_ChangeValImg();">
        <img id="Login_ValImg" src="util/code.do" style="height: 40px; width: 90px; border: 0" alt=""
                                    title="看不清？换一个" align="top" /></a>
      </div>                              
       <div class="clear"> </div>                             
      <div class="login-oper">
       <input name="" type="checkbox" value="" checked="checked" />
        记住密码          &nbsp &nbsp &nbsp &nbsp       <span>忘记密码>></span> </div>
      <div class="login-oper">
        <input  type="button" value="登 录" class="login-btn"  onclick="javascript:Login_Submit();" />
        <input  type="button" value="重 置" class="login-reset"/>
      </div>
      <div class="login-zizu"  >
    
    <a>    &nbsp &nbsp &nbsp &nbsp &nbsp  进入会员自自助平台>></a>
      
       
      </div>
    </form>
  </div>
  <div class="bottom">技术支持：深圳市芝麻开花信息技术有限公司&nbsp;&nbsp;</div>
</div>
</body>
</html>
