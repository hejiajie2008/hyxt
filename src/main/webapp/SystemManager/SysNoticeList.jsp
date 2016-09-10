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
    <link href="../Inc/Style/Style.css" rel="stylesheet" />
    
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/SystemManage/SysNotice.js" type="text/javascript"></script>
    <script src="../Scripts/Module/WeiXin/ckeditor/ckeditor.js" type="text/javascript"></script>
    <script>
        CKEDITOR.editorConfig = function (config) {
            config.toolbar_Full = [
                    ['Source'],
                    ['Bold', 'Italic', 'Underline', 'Strike', '-', 'Subscript', 'Superscript'],
                    ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
                    ['Undo', 'Redo']
            //                    ['Link', 'Unlink', 'Anchor']
                ];
        };   
    </script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmNoticeList" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                             <utils:title/>
                        </div>
                    </div>
                    <div class="user_List_All">
                        <div class="user_List_top" style="height: 34px;">
                            <table class="tableStyle" style="width: 100%">
                                <tr style="color: #333333; background-color: #F7F6F3;">
                                    <td class="user_List_styleLeft">
                                        快捷操作：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <div class="user_List_Button">
                                            <input id="btnNoticeAdd" type="button" value="新增公告" class="common_Button" onclick="NoticeAdd()"
                                                 visible="false" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="table-style table-hover user_List_txt">
                            
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                公告号码
                                            </th>
                                            <th>
                                                发布人
                                            </th>
                                            <th>
                                                公告标题
                                            </th>
                                            <th>
                                                发布时间
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                   
                               
                               
                               <c:forEach items="${sysnoticeFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                            <label id="lblNumber"  > ${status.index+1}</label>
                                        </td>
                                        <td>
                                            ${s.sysnoticecode}
                                        </td>
                                        <td>
                                            ${s.sysnotiecename}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.sysnoticetitle}
                                        </td>
                                        <td>
                                           
                                             <fmt:formatDate value="${s.sysnoticetime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                        </td>
                                        <td class="listtd" style="width: 60px;">
                                            <a href="#" onclick='NoticeEdit(${s.sysnoticeid});'
                                                id="hyNoticeEdit"   >
                                                <img src="../images/Gift/eit.png" title="编辑" alt="编辑" />
                                            </a><a href="#" id="hyNoticeDel"     onclick='NoticeDel("${s.sysnoticeid}")'>
                                                <img src="../images/Gift/del.png" title="删除" alt="删除" />
                                            </a>
                                        </td>
                                    </tr>
                               </c:forEach>
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                         <page:page pageIndex="${sysnoticeFormBean.page}" pageCount="${sysnoticeFormBean.pages}" rowCount="${sysnoticeFormBean.total}" 
                           					 pageSize="${sysnoticeFormBean.pageSize}" 
                           					  path="memList.do" param="type=1"/>
                              				<div class="clear"></div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
