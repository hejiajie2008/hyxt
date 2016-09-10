<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <title></title>
    <link href="../Inc/Style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="frmNoticeShow" runat="server">
    <div class="divContentBox">
        <div style="width: 100%; text-align: center;">
            <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 600px; margin: auto">
                <tr>
                    <td colspan="4">
                        <span id="spNoticeTitle"  style="font-weight: bold;">
                        	${sysnotice.sysnoticetitle}
                        </span>
                    </td>
                </tr>
                <tr>
                    <td>
                        发布人：&nbsp;&nbsp; <span id="spRelaseName"  style="font-weight: bold;">${sysnotice.sysnotiecename}
                        </span>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;发布时间：&nbsp;&nbsp; <span id="spRelaseTime"
                             style="font-weight: bold;"><fmt:formatDate value="${sysnotice.sysnoticetime}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                <tr>
                    <td colspan="4" align="left" valign="top" style="height:300px;">
                        <font size="4">${sysnotice.sysnoticedetail }</font>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    </form>
</body>
</html>
