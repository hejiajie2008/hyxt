<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
    <script src="../Scripts/Module/SystemManage/GroupAuthority.js" type="text/javascript"></script>
    <script type="text/javascript">
        function GroupAdd() {
            window.location.href = project_name+"/SystemManager/GroupAuthority.do?PID=36&goupid=0&parentgroupid=";
        }
    </script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmGroup" >
    <input type="hidden" id="PID" value='<%=request.getParameter("PID") %>'/>
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
                                            <input id="btnGroupAdd" type="button" class="common_Button" value="新增角色" onclick="GroupAdd()"
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
                                                角色名称
                                            </th>
                                            <th>
                                                说明
                                            </th>
                                            <th>
                                                有效范围
                                            </th>
                                            <th>
                                                创建者
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                   
                               
                                <c:forEach items="${sysgroupFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                           ${status.index+1 }
                                        </td>
                                        <td style="text-align: left">
                                            ${s.groupname}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.groupremark}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.ispublic==1?"所有店铺":"本店铺"}
                                           
                                        </td>
                                        <td style="text-align: left">
                                            ${s.username}
                                        </td>
                                        <td class="listtd" style="width: 60px;">
                                       
                                       
                                            <a href='GroupAuthority.do?PID=36&groupid=${s.groupid}&parentgroupid=${s.parentgroupid}'
                                                id="hyGroupPermission"  visible="false"  title="权限设定">
                                                <img src="../images/Gift/system.png" title="权限设定" alt="权限设定" />
                                            </a><a href="#" id="hyGroupel"  width="30px" visible="false" onclick='btnGroupDel("${s.groupname}","${s.groupid}")'>
                                                <img src="../images/Gift/del.png" alt="删除" title="删除" /></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                          
                        </table>
                         
                    </div>
                </div>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
