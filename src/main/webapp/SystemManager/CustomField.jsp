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
    <script src="../Scripts/Module/SystemManage/CustomField.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmCustomField" >
    <input type="hidden" id="txtCustomID"  />
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">
                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title />
                        </div>
                    </div>
                    <div id="CustomFieldAddOrEdit" style="display: none;">
                        <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 600px; margin: auto">
                            <tr>
                                <td class="tableStyle_left">
                                    请&nbsp;&nbsp;选&nbsp;&nbsp;择：
                                </td>
                                <td class="tableStyle_right">
                                    <label style="vertical-align: text-bottom;">
                                        <input id="MemCustom" type="radio" value="1" name="radCustomType" />
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            会员表自定义属性</label></label>
                                    <label style="vertical-align: text-bottom;">
                                        <input id="GoodCustom" type="radio" value="2" name="radCustomType" />
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            产品表自定义属性</label></label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>属性名称：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" class="border_radius" id="txtCustomName"  />
                                    <label style="vertical-align: text-bottom;">
                                        &nbsp;
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            <input type="checkbox" id="chkIsNull" />值可以为空</label>
                                    </label>
                                    <label style="vertical-align: text-bottom;">
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            <input type="checkbox" id="chkIsShow" />显示到列表</label>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    <span style="color: #ff4800; vertical-align: middle">*</span>属性代码：
                                </td>
                                <td class="tableStyle_right">
                                    <label style="vertical-align: text-bottom;">
                                        <input type="text" class="border_radius" id="txtCustomCode"  />
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            &nbsp;&nbsp;属性英文名，用于系统识别
                                        </label>
                                    </label>
                                </td>
                            </tr>
                            <tr>
                                <td class="tableStyle_left">
                                    数据类型：
                                </td>
                                <td id="trCustomFieleType"  class="tableStyle_right">
                                    <label style="vertical-align: text-bottom;">
                                        <input id="radText"  type="radio" name="radCustomFieldType" value="text" />
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            文本</label></label>&nbsp;
                                    <label style="vertical-align: text-bottom;">
                                        <input id="radDate"  type="radio" name="radCustomFieldType" value="date" />
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            日期</label></label>&nbsp;
                                    <label style="vertical-align: text-bottom;">
                                        <input id="radSelect"  type="radio" name="radCustomFieldType" value="select" />
                                        <label class="lbsetCk" style="vertical-align: middle;">
                                            选择项</label></label>
                                </td>
                            </tr>
                            <tr id="trCustomSelectData"  style="display: none;">
                                <td class="tableStyle_left">
                                    属&nbsp;&nbsp;性&nbsp;&nbsp;值：
                                </td>
                                <td class="tableStyle_right">
                                    <input type="text" id="txtCustomSelectData" class="border_radius"  />&nbsp;&nbsp;多个选项以<b>“|”</b>分隔
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="tableStyle_right">
                                    <div class="buton" style="text-align: center;">
                                        <input type="button" id="btnCustomSave" class="buttonColor" value="保   存" />
                                        &nbsp
                                        <input type="button" id="btnCustomReset" class="buttonRest" value="重   置" />
                                        <input id="CustomEditOrAdd" type="hidden" />
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
                                            <input id="btnCustomFieldAdd" type="button" value="新增属性" class="common_Button"  visible="false" />
                                            &nbsp;&nbsp;
                                            <input type="button" id="btnIsShowAll"  value="显示全部" class="common_Button" OnClick="btnIsShowAll_Click"  />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="table-style table-hover user_List_txt">
                            
                                    
                                        <tr class="th">
                                            <th>
                                                显示到列表
                                            </th>
                                            <th>
                                                自定义字段名称
                                            </th>
                                            <th>
                                                自定义字段
                                            </th>
                                            <th>
                                                数据类型
                                            </th>
                                            <th>
                                                属性详情
                                            </th>
                                            <th>
                                                会员/商品
                                            </th>
                                            <th>
                                                允许为空
                                            </th>
                                            <th>
                                                日期
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
                                        
                                        <c:forEach items="${memcustomfieldFormBean.rows}" var="s" varStatus="status">
                                
                                    <tr class="td">
                                        <td>
                                            <input type="checkbox" id="ckbCustomFieldShow" AutoPostBack="True"  OnCheckedChanged="ckbCustomFieldShow_CheckedChanged"
                                                Checked='${s.customfieldisshow}' />
                                            <Literal  id="ltrID" value='${s.customfieldid}' 
                                                Visible="false"></Literal>
                                        </td>
                                        <td style="text-align: left">
                                            ${s.customfieldname}
                                        </td>
                                        <td style="text-align: left; padding-left: 2px;">
                                            ${s.customfield}
                                        </td>
                                        <td>
                                            ${s.customfieldtype}
                                        </td>
                                        <td style="text-align: left">
                                            ${s.customfieldinfo}
                                        </td>
                                        <td ${s.customtype==1 ? "style='color:Red'" : "style='color:Blue'"}>
                                            ${s.customtype== 1 ? "会员" : "产品"}
                                        </td>
                                        <td>
                                            ${s.customfieldisnull==1 ? "是" : "否"}
                                            <%--<input type="checkbox" ID="ckbCustomFieldIsNull" AutoPostBack="false"  Checked='$\{s.CustomFieldIsNull")%>' />--%>
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${s.customfieldcreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                            ${s.username}
                                        </td>
                                        <td class="listtd" style="width: 60px;">
                                            <a href="#" onclick=' btnCustomFieldEdit("${s.customfieldname}",${s.customfieldid})'
                                                id="hyCustomEdit"  visible="false">
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                            </a><a href="#" id="hyCustomDel"  visible="false" onclick='return btnCustomFieldDel("${s.customfieldname}",${s.customfieldid});'>
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
