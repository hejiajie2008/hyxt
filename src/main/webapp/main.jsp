<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>连锁会员管理系统 专业版 </title>
    <link href="Inc/Style/Style.css" rel="stylesheet" />    
    <link href="Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script type="text/javascript">

        //iframe高度自适应
        function IFrameReSize(iframename) {
            var pTar = document.getElementById(iframename);
            if (pTar) {  //ff
                if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight) {
                    pTar.height = pTar.contentDocument.body.offsetHeight;
                } //ie
                else if (pTar.Document && pTar.Document.body.scrollHeight) {
                    pTar.height = pTar.Document.body.scrollHeight;
                }
            }
        }
        //iframe宽度自适应
        function IFrameReSizeWidth(iframename) {
            var pTar = document.getElementById(iframename);
            if (pTar) {  //ff
                if (pTar.contentDocument && pTar.contentDocument.body.offsetWidth) {
                    pTar.width = pTar.contentDocument.body.offsetWidth;
                }  //ie
                else if (pTar.Document && pTar.Document.body.scrollWidth) {
                    pTar.width = pTar.Document.body.scrollWidth;
                }
            }
        }

        var text = document.title
        var timerID

//        newtext();

//        function newtext() {
//            clearTimeout(timerID)
//            document.title = text.substring(1, text.length) + text.substring(0, 1)
//            text = document.title.substring(0, text.length)
//            timerID = setTimeout("newtext()", 1000)
//        }
        //onload = "setHeight();"
    </script>
</head>
<frameset rows="102,*,30" border="0">
    <frame src="top.jsp" noresize="noresize" frameborder="0" name="top" scrolling="no" marginwidth="0" marginheight="0" />
    <frameset cols="160,*" border="0" id="MainFrameset">
       <frame src="leftMenu.jsp" id="menu" name="menu" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" noresize="noresize" />
       <frame src="startPage.do" name="mainFrame" id="mainFrame" frameborder="0" scrolling="auto" noresize="noresize" onload="Javascript:IFrameReSize(this)" />
    </frameset>
    <frame src="foot.jsp" noresize="noresize" frameborder="0" name="foot" scrolling="no" marginwidth="0" marginheight="0" />
  
    <noframes>
      <body> 本系统需要IE8+、Firefox3.0+、Opera9+或者Chrome浏览器支持。
      </body>
    </noframes>
  </frameset>
</html>
    