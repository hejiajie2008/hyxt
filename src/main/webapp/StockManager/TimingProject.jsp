<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<head >
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
    
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Mem/TimingProject.js" type="text/javascript"></script>
</head>
<body>
    <form id="form1" >
    <div id="TimingProjectEdit" style="display: none;">
        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 400px; margin: auto">
            <tr>
                <td class="tableStyle_left">
                    <span style="color: #ff4800; vertical-align: middle">*</span>服务名称：
                </td>
                <td class="tableStyle_right">
                    <input id="txtProjectName" type="text" class="border_radius" maxlength="20" />
                </td>
            </tr>
            <tr>
                <td class="tableStyle_left">
                    <span style="color: #ff4800; vertical-align: middle">*</span>服务规则：
                </td>
                <td class="tableStyle_right">
                    <select id="sltProjectRulesID"  class="selectWidth">
                    	<c:forEach items="${timingrules}" var="s" varStatus="status">
                    		<option value="${s.rulesid }">${s.rulesname }</option>
                    	</c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="tableStyle_left">
                    备注：
                </td>
                <td class="tableStyle_right">
                    <textarea id="txtProjectRemark" rows="3" style="width: 90%; word-wrap: break-word;
                        outline: none; resize: none;" title="请输入会员的备注"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding-top: 2px; padding-bottom: 2px;">
                    <input id="btnSaveform" type="button" onclick="SaveForm()" class="buttonColor" value="保  存" />
                    <input type="hidden" id="txtProjectID" value="" />
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
                                            <input id="btnTimingProject" type="button" value="新增服务"  class="common_Button" visible="false"  />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                            class="tableStyle">
                            <tr>
                                <td class="tableStyle_left">
                                    服务名称：
                                </td>
                                <td class="tableStyle_right" style=" width:200px;">
                                    <input id="txtQuerProjectName" type="text"  class="border_radius" maxlength="20" />
                                </td>
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" ID="btnUserSearch"  value="查   询" class="common_Button"
                                            OnClick="btnUserSearch_Click1" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                            
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                服务名称
                                            </th>
                                            <th>
                                                计时规则
                                            </th>
                                            <th>
                                                添加时间
                                            </th>
                                            <th>
                                                操作员
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                   
                                
                                
                                  <c:forEach items="${timingprojectFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                            ${status.index+1}
                                        </td>
                                        <td>
                                            ${s.projectname}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.rulesname}
                                        </td>
                                        <td style="text-align: center">
                                             <fmt:formatDate value="${s.projectaddtime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        <td class="listtd" style="width: 100px;">
                                            <a href="javascript:void(0);" onclick='EditTimingProject(${s.projectid})'
                                                id="hyLevelEdit"   >
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                            </a><a href="javascript:void(0);" onclick='DeleteTimingProject(${s.projectid},"${s.projectname}")'
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
                                       			<page:page pageIndex="${timingprojectFormBean.page}" pageCount="${timingprojectFormBean.pages}" rowCount="${timingprojectFormBean.total}" 
                           					 pageSize="${timingprojectFormBean.pageSize}" 
                           					  path="TimingProject.do" param="type=1"/>
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
