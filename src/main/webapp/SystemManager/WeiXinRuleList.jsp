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
    <link href="<%=request.getContextPath()%>/Inc/Style/Style.css" rel="stylesheet" />
    
    <link href="<%=request.getContextPath()%>/Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/Inc/Style/uploadify.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/jquery.uploadify.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/jquery.uploadify.swfobject.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/Module/Common/Tab.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/Module/SystemManage/WeiXinRuleList.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/Scripts/Module/WeiXin/ckeditor/ckeditor.js" type="text/javascript"></script>
    <style type="text/css">
        #btnNewsPicUploadUploader
        {
            float: left;
            margin-left: 30px;
        }
        .th-child th{text-align: center;height: 24px; border-top:0; }
    </style>
</head>
<body>

	${type}
    <form id="frmWeiXinRuleList" >
    <input type="text"  id="txtSystemDomain" style="display: none" />
    <div class="system_Info box_right" style="width: 99%;">
        <div class="system_Top">
            <div class="user_regist_title">
               	<utils:title/>
            </div>
        </div>
        <div class="user_List_All">
            <div class="user_regist_infor" style="width: 100%">
                微信规则设置
                <div style="float:right;"><input class="common_Button" style="letter-spacing:normal;margin-right: 12px;" type="button" value="参数设置" onclick="javascript:location.href='WeiXinConfig.jsp'" /></div>
            </div>
            <div style="text-align: left;">
                <div class="tabBox" id="RemindTab">
                    <ul class="tab">
                        <li id="tab0" class="on">文本消息</li>
                        <li id="tab1">图文消息</li>
                        <li id="tab2">自定义菜单</li>
                        <div id="btnAddRule" style="float: right; margin-right: 10px;">
                            <input type="button" id="btnAdd" value="添　加" class="common_Button" /></div>
                    </ul>
                </div>
                <div style="margin: 5px 10px 10px 0px;" id="MainContent0">
                    <table class="table-style table-hover">
                      
                            <HeaderTemplate>
                                <thead class="thead">
                                    <tr class="th">
                                        <th>
                                            回复序号
                                        </th>
                                        <th>
                                            规则描述
                                        </th>
                                        <th>
                                            回复内容
                                        </th>
                                        <!--
                                        <th>
                                            操作员
                                        </th>
                                        <th>
                                            创建时间
                                        </th>
                                        -->
                                        <th>
                                            操 作
                                        </th>
                                    </tr>
                                </thead>
                            </HeaderTemplate>
                            <c:forEach items="${weixinruleFormBean.rows}" var="s" varStatus="status">
                                <tr class="td">
                                    <td>
                                         ${s.rulenumber}
                                    </td>
                                    <td style="text-align: left;">
                                        ${s.ruledesc}
                                    </td>
                                    <td style="text-align: left;">
                                         ${s.rulecontent}
                                    </td>
                                    <!--
                                    <td>
                                         Eval("UserName") 
                                    </td>
                                    <td>
                                         
                                         
                                         <fmt:formatDate value="${s.rulecreatetime}" pattern="yyyy-MM-dd"/> 
                                    </td>
                                    -->
                                    <td class="listtd" style="width: 60px;">
                                        <a  id="edit" href="#" onclick='"textRuleEdit("+Eval("RuleID")+")"'>
                                            <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                        </a><a  id="del" href="#" onclick='"delRule("+Eval("RuleID")+","+"1)" '>
                                            <img src="../images/Gift/del.png" alt="删除" title="删除" /></a>
                                    </td>
                                </tr>
                         </c:forEach>     
                    </table>
                </div>
                <div id="textRuleDialog" style="display: none;">
                    <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 600px; margin: auto">
                        <tr>
                            <td colspan="2" style="color: #DB9944; text-align: center;" class="tableStyle_right">
                                提示：发送内容的长度最好不要超过200个长度
                            </td>
                        </tr>
                        <tr>
                            <td class="tableStyle_left">
                                <span style="color: #ff4800; vertical-align: middle">*</span>回复序号：
                            </td>
                            <td class="tableStyle_right">
                                <input type="text" id="txtNumber" class="border_radius" />
                                <input type="text" id="textRuleType" style="display: none;" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tableStyle_left">
                                <span style="color: #ff4800; vertical-align: middle">*</span>规则描述：
                            </td>
                            <td class="tableStyle_right">
                                <input id="txtDescRule" class="border_radius" type="text" style="width: 433px;" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tableStyle_left">
                                <span style="color: #ff4800; vertical-align: middle">*</span>发送内容：
                            </td>
                            <td class="tableStyle_right">
                                <textarea id="txtSendContent" rows="3"  style="width: 433px; word-wrap: break-word;"
                                    class="border_radius"></textarea>
                            </td>
                        </tr>
                        <tr style="text-align: center;">
                            <td colspan="2" class="tableStyle_right " style="text-align: center;">
                                <input id="btnTextRuleSave" type="button" class="buttonColor" value="保   存 " />
                                &nbsp
                                <input id="btnTextRuleReset" type="button" class="buttonRest" value="重   置 " />
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="MainContent1" style="margin: 5px 10px 10px 0px; display: none;">
                   
                        <HeaderTemplate>
                            <table class="table-style table-hover" cellspacing="0" cellpadding="2" style="width: 100%;"
                                id='rptNewsRuleTable'>
                        </HeaderTemplate>
                        <ItemTemplate>
                        <thead class="thead">
                            <tr class="th">
                                <th style="text-align: left;">
                                    <%--<div style="background: url(../Inc/Style/images/plus.gif) no-repeat; float: left;
                                        width: 19px; height: 19px;">
                                    </div>
                                    <div class="parent" style="float: left; cursor: pointer; color: #AF0081">
                                        Eval("RuleNUmber")</div>
                                        回复序号:Eval("RuleNUmber")%>
                                </th>
                                <th style="text-align: left;">
                                    规则描述:Eval("RuleDesc")%>
                                </th>
                                <%--<th style="text-align: center;">
                                    消息个数:Eval("NewsThisCount")%>
                                </th>--%>
                                <th class="listtd" style="width: 90px;">
                                    <a  id="add" href=' string.Format("WeiXinRule.aspx?PID=107&RuleID={0}", Eval("RuleID"))%>'>
                                        <img src="../images/Gift/add.png" alt="添加" title="添加" />
                                    </a><a  id="edit" href='"javascript:newsRuleEdit("+Eval("RuleID")+")" %>'>
                                        <img src="../images/Gift/eit.png" alt="编辑" title="编辑" />
                                    </a><a  id="del" href='"javascript:delRule("+Eval("RuleID")+",2)" %>'>
                                        <img src="../images/Gift/del.png" alt="删除" title="删除" />
                                    </a>
                                </th>
                            </tr>
                        </thead>
                            <tr>
                                <td colspan="6">
                                  
                                       
                                            <table class="table-style table-hover" cellspacing="0" cellpadding="2" style="width: 92%; margin:3px 0 15px 20px;">
                                                <tr class="th th-child">
                                                    <th>
                                                        图文标题
                                                    </th>
                                                    <th>
                                                        图文描述
                                                    </th>
                                                    <th>
                                                        图片
                                                    </th>
                                                    <th>
                                                        跳转链接
                                                    </th>
                                                    <th>
                                                        创建时间
                                                    </th>
                                                    <th>
                                                        操作
                                                    </th>
                                                </tr>
                                        
                                         <c:forEach items="${weixinnewsFormBean.rows}" var="s" varStatus="status">
                                            <tr class="td">
                                                <td style="text-align: left;">
                                                    ${s.newstitle}
                                                </td>
                                                <td style="text-align: left;">
                                                    ${s.newsdesc}
                                                </td>
                                                <td style="text-align: center;">
                                                    <img id="Img1" 
                                                         width="30" height="30" />
                                                </td>
                                                <td style="text-align: left;">
                                                    ${s.newsurlsecond}
                                                </td>
                                                <td style="text-align: center;">
                                                   
                                                    
                                                    <fmt:formatDate value="${s.newscreatetime}" pattern="yyyy-MM-dd"/> 
                                                </td>
                                                <td class="listtd" style="width: 60px;">
                                                    <a  id="edit" href=' string.Format("WeiXinRule.aspx?PID=107&NewsID={0}", Eval("NewsID"))'>
                                                        <img src="../images/Gift/eit.png" alt="编辑" title="编辑" /></a> <a  id="newsDel"
                                                            href='"javascript:newsDel("+Eval("NewsID")+")" '>
                                                            <img src="../images/Gift/del.png" alt="删除" title="删除" /></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        
                                            </table>
                                       
                                </td>
                            </tr>
                        </ItemTemplate>
                        <FooterTemplate>
                            </table>
                        </FooterTemplate>
                    
                </div>
                <div id="newsRuleDialog" style="display: none;">
                    <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 720px;">
                        <tr>
                            <td colspan="2" style="color: #DB9944; text-align: center;" class="tableStyle_right ">
                                提示：图文描述内容的长度最好不要超过200个长度
                            </td>
                        </tr>
                        <tr>
                            <td class="tableStyle_left">
                                <span style="color: #ff4800; vertical-align: middle">*</span>回复序号：
                            </td>
                            <td class="tableStyle_right">
                                <input type="text" id="txtNewsNumber" class="border_radius" />
                                <input type="text" id="txtNewsType" style="display: none;" />
                                <input type="text" id="txtNewsRule" style="display: none;" />
                            </td>
                            <td rowspan="6" style="width: 250px; text-align: center; vertical-align: top;">
                                <div>
                                    <img src="" width="180" height="150" id="imgNewsPhoto" /><br />
                                    <span style="color: #DB9944; font-size: 12px;">图片支持大小为180*150</span>
                                </div>
                                <div style="text-align: center; width: 180px">
                                    <input id="btnNewsPicUpload" type="file" class="buttonColor" style="display: none;" />
                                    <input type="button" value="上传图片" class="common_Button" style="float: right;" onclick="javascript:$('#btnNewsPicUpload').uploadifyUpload();" />
                                </div>
                                <div id="divNewsPic_fileQueue" style="height: 60px;">
                                </div>
                            </td>
                        </tr>
                        <tr id="trNewsRuleDescAdd">
                            <td class="tableStyle_left">
                                <span style="color: #ff4800; vertical-align: middle">*</span>规则描述：
                            </td>
                            <td class="tableStyle_right">
                                <input id="txtNewsRuleDescAdd" class="border_radius" type="text" style="width: 300px;" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tableStyle_left">
                                图文标题：
                            </td>
                            <td class="tableStyle_right">
                                <input id="txtNewsTitle" class="border_radius" type="text" style="width: 300px;" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tableStyle_left">
                                图文描述：
                            </td>
                            <td class="tableStyle_right">
                                <textarea id="txtNewsDesc" rows="3"  class="border_radius" style="width: 300px;
                                    word-wrap: break-word; height: 50px;"></textarea>
                            </td>
                        </tr>
                        <tr style="display: none;">
                            <td class="tableStyle_left">
                                图片链接：
                            </td>
                            <td class="tableStyle_right">
                                <input id="txtPicUrl" type="text" class="border_radius" style="width: 300px; display: none;" />
                                <input type="text" id="txtNewsID" class="border_radius" style="display: none;" />
                            </td>
                        </tr>
                        <tr style="display: none;">
                            <td class="tableStyle_left">
                                跳转链接：
                            </td>
                            <td class="tableStyle_right">
                                <input id="txtUrl" class="border_radius" type="text" style="width: 300px;" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea id="txtLinkContent" name="txtLinkContent" class="ckeditor"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center; height: 36px">
                                <input id="btnNewsRuleSave" type="submit" class="buttonColor" value="保   存 " />
                                &nbsp
                                <input id="btnNewsRuleReset" type="button" class="buttonRest" value="重   置 " />
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="newsRuleDialogByRuleNUmber" style="display: none;">
                    <table class="tableStyle" cellspacing="0" cellpadding="2" style="width: 600px; margin: auto">
                        <tr>
                            <td class="tableStyle_left">
                                <span style="color: #ff4800; vertical-align: middle">*</span>回复序号：
                            </td>
                            <td class="tableStyle_right">
                                <input type="text" id="txtUpdateNewRuleByRuleNUmber" class="border_radius" />
                                <input type="text" id="txtNewsRuleID" style="display: none;" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tableStyle_left">
                                <span style="color: #ff4800; vertical-align: middle">*</span>规则描述：
                            </td>
                            <td class="tableStyle_right">
                                <input id="txtNewsDescRule" type="text" class="border_radius" style="width: 433px;" />
                            </td>
                        </tr>
                        <tr style="text-align: center;">
                            <td colspan="2" class="tableStyle_right " style="text-align: center;">
                                <input id="btnUpdateNewRuleByRuleNUmber" type="button" class="buttonColor" value="保   存 " />
                            </td>
                        </tr>
                    </table>
                </div>

                <div id="MainContent2" style="margin: 5px 10px 10px 0px; display: none;">
                    <table class="table-style table-hover user_List_txt">
                        
                       
                            <thead class="thead">
                                <tr class="th">
                                    <th>
                                        菜单名称
                                    </th>
                                    <th>
                                        子菜单个数
                                    </th>
                                    <th>
                                        菜单类型
                                    </th>
                                    <th>
                                        Key
                                    </th>
                                    <th>
                                        Url
                                    </th>
                                </tr>
                            </thead>
                        
                      <c:forEach items="${weixinmenuFormBean.rows}" var="s" varStatus="status">
                            <tr class="td">
                                <td style="text-align:left;">
                                    ${s.menuname}
                                </td>
                                <td style="text-align:center;">
                                    ${s.childnum}
                                </td>
                                <td style="text-align:center;">
                                     ${s.menutype}
                                </td>
                                <td style="text-align:left;">
                                   ${s.menukey}
                                </td>
                                <td style="text-align:left;">
                                    ${s.menuurl}
                                </td>
                            </tr>
                       </c:forEach>
               
                    </table>
                </div>

            </div>
        </div>
    </div>
    </form>
</body>
</html>
