<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="Inc/Style/Style.css" rel="stylesheet" />    
    <link href="Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="Scripts/jquery-common.js" type="text/javascript"></script>    
    <script src="Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="Scripts/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
    <script src="Scripts/Module/System/Top.js" type="text/javascript"></script>
   
    

    
    
</head>
<body style="padding: 0px; margin: 0px;">
  
    
    <div id="top">
        <!-- 头部-->
        <div class="head">
            <div class="logo">
                <a href="StartPage.aspx" target="mainFrame">
                    <img id="topLogo"  alt=""   src="Upload/WebImage/main.png" />
                   
                </a>
            </div>
            <div class="userInfo">
                <span>欢迎</span> <a id="EditUser" style="color: #FFF; font-weight: bolder" 
                    href="javascript:void(0);">
                     <shiro:principal/>
                     
                     
                    </a>| <a class="top_caller"  id="topCaller">
                        来电弹屏未启用</a> | <a href="#" id="top_hidefrm">隐藏菜单</a> | <a id="showrcode"  href="#" style="color: #FFF; font-weight: bolder" >微信二维码</a><a href="#" onclick="LoginOut()">
                            退出系统</a>
            </div>
        </div>
        <!-- 导航条-->
       <div class="navBar">
            
            
<utils:menu />
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            //用titCell和mainCell 处理
            jQuery(".navBar").slide({
                titCell: ".nav .m", // 鼠标触发对象
                mainCell: ".subNav", // 切换对象包裹层
                delayTime: 0, // 效果时间
                triggerTime: 150, //鼠标延迟触发时间
                returnDefault: false  //返回默认状态
            });
            var cWidth = document.body.clientWidth;
            
            jQuery(".nav .m").each(function () {
           
                var x = $(this).offset().left-50;
                
               
                var element = $("#" + $(this).attr('target'));
                if (cWidth - x < element.width()) {
                var left=cWidth - element.width() - 50;
                    element.css("left",left);
                }
                else {
                
                    element.css("left", x);
                }
            });
        });
    </script>
    
</body>
</html>
