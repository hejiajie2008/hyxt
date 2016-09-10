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
    <script src="../Scripts/Module/Mem/SetLevel.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmSetLevel" runat="server">
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
                        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                            class="tableStyle">
                            <tr>
                                <td class="user_List_styleLeft">
                                    快捷操作：
                                </td>
                                <td class="user_List_styleRight">
                                    <input id="btnAddLevel" type="button" value="新增等级" class="common_Button"   visible="false"/>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                           
                               
                                 
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                等级名称
                                            </th>
                                            <th>
                                                所需积分
                                            </th>
                                            <th>
                                                快速消费等级折扣
                                            </th>
                                            <th>
                                                快速消费积分比率
                                            </th>
                                            <th>
                                                 会员充值积分比率
                                            </th>
                                            <th>
                                                升级机制
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                
                              
                               <c:forEach items="${memlevelFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                           ${status.index+1}
                                        </td>
                                        <td>
                                            ${s.levelname}
                                            
                                            
                                        </td>
                                        <td style="text-align: right">
                                             ${s.levelpoint}
                                        </td>
                                        <td style="text-align: right">
                                             ${s.leveldiscountpercent}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.levelpoint}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.levelpointpercent}
                                        </td>
                                        <td>
                                             ${s.levelllock==0?"等级锁定 ":"正常升级 "}
                                        </td>
                                        <td class="listtd" style="width: 60px;">
                                            <a href="#" onclick='EditLevel(${s.levelid},"");'
                                                id="hyLevelEdit"  visible="false">
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                            </a><a href="#" onclick='DeleteLevel(${s.levelid},(${s.levelname}+""));'
                                                id="hyLevelDelete"  visible="false">
                                                <img src="../images/Gift/del.png" alt="删除" title="删除" />
                                            </a>
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
