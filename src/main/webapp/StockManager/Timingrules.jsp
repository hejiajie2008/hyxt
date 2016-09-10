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
    
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/Timingrules.js" type="text/javascript"></script>
</head>
<body>
    <form id="form1" >
    <div id="TimingrulesEdit" style="display: none;">
        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 400px; margin: auto">
            <tr>
                <td class="tableStyle_left">
                    <span style="color: #ff4800; vertical-align: middle">*</span>规则名称：
                </td>
                <td class="tableStyle_right">
                    <input id="txtRulesName" type="text"  class="border_radius" maxlength="20" />
                </td>
            </tr>
            <tr>
                <td class="tableStyle_left">
                    <span style="color: #ff4800; vertical-align: middle">*</span>单位计时规则：
                </td>
                <td class="tableStyle_right">
                    &nbsp;&nbsp;每<input id="txtRulesInterval" type="text"  class="border_radius"
                        style="width: 60px; float: none; clear: both;" />分钟
                    <input id="txtRulesUnitPrice" type="text"  class="border_radius" style="width: 60px;
                        float: none; clear: both;" />元
                </td>
            </tr>
            <tr>
                <td class="tableStyle_left">
                    <span style="color: #ff4800; vertical-align: middle">*</span>不足单位计费：
                </td>
                <td class="tableStyle_right">
                    超过<input id="txtRulesExceedTime" type="text"  class="border_radius"
                        style="width: 60px; float: none; clear: both;" />分钟算一次计费
                </td>
            </tr>
            <tr>
                <td class="tableStyle_left">
                    规则描述：
                </td>
                <td class="tableStyle_right">
                    <textarea id="txtRulesRemark" rows="3" style="width: 90%; word-wrap: break-word;
                        outline: none; resize: none;" title="请输入会员的备注"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding-top: 2px; padding-bottom: 2px;">
                    <input id="btnSaveform" type="button" onclick="SaveForm()" class="buttonColor" value="保  存" />
                    <input type="hidden" id="txtRulesID" value="" />
                </td>
            </tr>
        </table>
    </div>
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title/>
                        </div>
                    </div>
                    <div class="user_List_All">
                        <div class="user_List_top">
                            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                class="tableStyle">
                                <tr style="color: #333333; background-color: #F7F6F3;">
                                    <td class="user_List_styleLeft">
                                        快捷操作：
                                    </td>
                                    <td class="user_List_styleRight">
                                        <div class="user_List_Button">
                                            <input id="btnAddTimingRules"  type="button" value="新增规则" class="common_Button" visible="false"  />
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
                                                规则名称
                                            </th>
                                            <th>
                                                单位计费时间
                                            </th>
                                            <th>
                                                单位计费价格
                                            </th>
                                            <th>
                                                添加时间
                                            </th>
                                            <th>
                                                规则描述
                                            </th>
                                            <th>
                                                操作员
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                   
                              
                                 <c:forEach items="${timingrulesFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                             ${status.index+1}
                                        </td>
                                        <td>
                                            ${s.rulesname}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.rulesinterval}分钟
                                        </td>
                                        <td style="text-align: right">
                                            ${s.rulesunitprice}
                                        </td>
                                        <td style="text-align: center">
                                         <fmt:formatDate value="${s.rulesaddtime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                        </td>
                                        <td style="text-align: left">
                                            ${s.rulesremark}
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        <td class="listtd" style="width: 60px;">
                                            <a href="#" onclick='EditTimingrules(${s.rulesid})'
                                                id="hyLevelEdit"   >
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                            </a><a href="#" onclick='DeleteTimingrules(${s.rulesid},"${s.rulesname}")'
                                                id="hyLevelDelete"    >
                                                <img src="../images/Gift/del.png" alt="删除" title="删除" />
                                            </a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                             
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                        	<page:page pageIndex="${timingrulesFormBean.page}" pageCount="${timingrulesFormBean.pages}" rowCount="${timingrulesFormBean.total}" 
                           					 pageSize="${timingrulesFormBean.pageSize}" 
                           					  path="Timingrules.do" param="type=1"/>
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
