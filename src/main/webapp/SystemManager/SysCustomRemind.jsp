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
    <script src="../Scripts/Module/SystemManage/CustomRemind.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <style type="text/css">
        #tdauttable table tr td
        {
            border: 0px;
        }
    </style>
</head>
<body>
    <form id="frmCustomRemind" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title/>
                        </div>
                    </div>
                    <div style="width: 100%; text-align: center; display: none;" id="DIVCustomRemind">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 450px;">                            
                            <tr>
                                <td class="tableStyle_left">
                                    操作人员：
                                </td>
                                <td class="tableStyle_right">
                                    <label id="lblCustomRemindUSer"  style="font-size: 14px; font-weight: bold;
                                        margin-left: 5px"><shiro:principal/>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>提醒日期：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtCustomRemindTime" type="text" class="border_radius"  />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>提醒标题：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtCustomRemindTitle" type="text" class="border_radius"  />
                                    <input id="txtCustomRemindID" type="hidden"  />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>提醒用户：
                                </td>
                                <td class="tableStyle_right" id="tdauttable">
                                    
                                    <utils:sysusercheck userid=""/>
                                </td> 
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    提醒详情：
                                </td>
                                <td class="tableStyle_right" colspan="3">
                                    <textarea id="txtCustomRemindDetail" class="border_radius" rows="3" 
                                        style="width: 90%; height: 40px; word-wrap: break-word;"></textarea>
                                </td>
                            </tr>
                            <tr align="center">
                                <td colspan="4" class="tableStyle_right ">
                                    <div class="buton" style="text-align: center;">
                                        &nbsp;<input id="btnCustomRemindSave" type="submit" class="buttonColor" value="保   存"
                                             />
                                        &nbsp;<input id="btnCustomRemindReset" type="button" class="buttonRest" value="重   置" />
                                    </div>
                                </td>
                            </tr>
                        </table>
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
                                            <input id="btnCustomRemindAdd" type="button"  value="新增提醒" class="common_Button"
                                                onclick="CustomRemind(0)"  visible="false"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="table-style table-hover user_List_txt">
                            

                                        <tr class="th">
                                            <th>
                                                提醒人
                                            </th>
                                            <th>
                                                提醒标题
                                            </th>
                                            <th>
                                                提醒详情
                                            </th>
                                            <th>
                                                提醒时间
                                            </th>
                                            <th>
                                                店铺
                                            </th>
                                            <th>
                                                操作员
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                    <c:forEach items="${syscustomremindFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                            ${s.customreminder}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.customremindtitle}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.customreminddetail}
                                        </td>
                                        <td>
                                            ${s.customremindtime}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        <td class="listtd" style="width: 40px;">
                                            <a id="hyCustomRemindDel" visible="false"  href="#" onclick='btnCustomRemindDel(${s.customremindtitle},${s.customremindid})'>
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
