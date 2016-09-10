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
    <script src="../Scripts/Module/SystemManage/StaffClassList.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/fy.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmStaffClassList" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                             <utils:title/>
                        </div>
                    </div>
                    <div id="divStaffClass" style="display: none">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 700px; margin: auto">
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>部门名称：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtClassName" type="text"  class="border_radius" />
                                    <input id="txtClassID" type="hidden"  />
                                </td>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right">
                                    <select id="sltClassShopID"  class="selectWidth">
                                      <option value ="-1">==请选择==</option>
                                      <utils:shoplist shopid="${staffclassFormBean.classshopid }"/>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    是否提成：
                                </td>
                                <td class="tableStyle_right">
                                    <label style="vertical-align: text-bottom;">
                                        <input type="radio" name="radType" id="radTypeYes"  value="0" />
                                        <label style="vertical-align: middle;">
                                            提成</label></label>&nbsp;&nbsp;
                                    <label style="vertical-align: text-bottom;">
                                        <input type="radio" name="radType" id="radTypeNo"  value="1" />
                                        <label style="vertical-align: middle;">
                                            不提成</label>
                                    </label>
                                </td>
                                <td class="tableStyle_left">
                                    提成比例：
                                </td>
                                <td class="tableStyle_right">
                                    <input id="txtClassPercent" type="text"  class="input_txt border_radius"
                                        title="提成比例必须是0～1之间的小数" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    备注：
                                </td>
                                <td class="tableStyle_right" colspan="3">
                                    <textarea id="txtClassRemark" rows="3"  style="width: 520px; word-wrap: break-word;
                                        outline: none; resize: none;"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tableStyle_right">
                                    <div class="buton" style="text-align: center;">
                                        <input id="btnClssSave" type="button" class="buttonColor" value="保   存 " />
                                        <input id="btnClassReset" type="button" class="buttonRest" value="重   置 " />
                                    </div>
                                </td>
                            </tr>
                        </table>
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
                                            <input id="btnClassAdd" type="button" value="新增部门"  class="common_Button"   visible="false"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                            class="tableStyle">
                            <tr>
                                <td class="tableStyle_left">
                                    所属店铺：
                                </td>
                                <td class="tableStyle_right" style="width: 400px;">
                                 <input id="HDsltshop"  type="hidden" />
                                    <select id="sltShop"  class="selectWidth">
                                    </select>
                                </td>
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" ID="btnStaffClassQuery"  value="查   询" class="common_Button"
                                            OnClick="btnStaffClassQuery_Click" />
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
                                                部门名称
                                            </th>
                                            <th>
                                                提成比例
                                            </th>
                                            <th>
                                                所属店铺
                                            </th>
                                            <th>
                                                备注
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                    </thead>
                              <c:forEach items="${staffclassFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                            <label id="lblNumber">${status.index+1}</label>
                                        </td>
                                        <td style="text-align: left">
                                            ${s.classname}
                                        </td>
                                        <td style="text-align: right">
                                            ${s.classpercent}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td style="text-align: left; padding-left: 4px;">
                                            ${s.classremark}
                                        </td>
                                        <td class="listtd" style="width: 60px;">
                                            <a href="#" onclick='StaffClassEdit(${s.classid})'
                                                id="aStaffClassEdit"   visible="false">
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                            </a><a href="#" onclick='StaffClassDelete(${s.classid},"${s.classname}")'
                                                id="aStaffClassDelete"   visible="false">
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
                                        <page:page pageIndex="${staffclassFormBean.page}" pageCount="${staffclassFormBean.pages}" rowCount="${staffclassFormBean.total}" 
                           					 pageSize="${staffclassFormBean.pageSize}" 
                           					  path="StaffClassList.do" param="type=1"/>
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
   <jsp:include  page="../Controls/QuickSearch.jsp"/>
    </form>
</body>
</html>
