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
    <link href="/Inc/Style/uploadify.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.uploadify.min.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.uploadify.swfobject.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/PointManage/GiftInfo.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="../Scripts/Module/PointManage/GiftClass.js" type="text/javascript"></script>
    <script src="../Scripts/fy.js" type="text/javascript"></script>
    <script type="text/javascript">
        function ShowPic(path) {
            if (path != "") {
                var image = "<img src='" + path + "' width=\"379\" height=\"500\" />";
            }
            else {
                var image = "<img src='../images/Gift/nogift.jpg' width=\"379\" height=\"500\" />";
            }
            art.dialog({
                padding: 0,
                title: '照片',
                content: image,
                lock: true,
                width: 300,
                height: 300
            });
        }      

    </script>
    <style type="text/css">
        #GiftPhoto_UploadifyUploader
        {
            float: left;
            margin-left: 12px;
        }
        .uploadifyQueueItem
        {
            width:auto;
            }
    </style>
</head>
<body style="padding-right: 1px">
    <form id="page_form" action="GiftList.do" method="get" >
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr>
            <td colspan="2" style="width: 100%;">
                <div class="system_Info">

                    <div class="system_Top">
                        <div class="user_regist_title">
                            <utils:title/>
                        </div>
                    </div>

                    <div id="DiveGiftInfo" style="display: none;">
                        <div class="user_regist_Allleft" style="width: 620px">
                            <div class="user_regist_left" style="width: auto">
                                <table class="tableStyle" cellspacing="0" cellpadding="0" style="width: 620px;">
                                    <tr>
                                        <td style="width: 400px">
                                            <table class="tableStyle" cellspacing="0" cellpadding="0" style="width: 100%; margin: auto;
                                                border: 0px" rules="none">
                                                <tr>
                                                    <td class="tableStyle_left" style="border: 0px; background-color: White">
                                                        <span style="color: #ff4800; vertical-align: middle">*</span>礼品名称：
                                                    </td>
                                                    <td class="tableStyle_right" style="border: 0px">
                                                        <input id="txtGiftName" type="text" runat="server" class="border_radius" />
                                                        <input id="txtGiftID" type="hidden" runat="server" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="tableStyle_left" style="border: 0px; background-color: White">
                                                        <span style="color: #ff4800; vertical-align: middle">*</span>礼品简码：
                                                    </td>
                                                    <td class="tableStyle_right" style="border: 0px">
                                                        <input id="txtGiftCode" type="text" runat="server" class="border_radius" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="tableStyle_left" style="border: 0px; background-color: White">
                                                        <span style="color: #ff4800; vertical-align: middle">*</span>礼品分类：
                                                    </td>
                                                    <td class="tableStyle_right" style="border: 0px">
                                                        <select id="sltGiftClass"  class="selectWidth">
                                                        <%--    <option value='' selected = "selected">${s.levelname}</option>--%>

                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="tableStyle_left" style="border: 0px; background-color: White">
                                                        <span style="color: #ff4800; vertical-align: middle">*</span>库存数量：
                                                    </td>
                                                    <td class="tableStyle_right" style="border: 0px">
                                                        <input id="txtGiftStockNumber" type="text" runat="server" class="border_radius" maxlength="8" />
                                                        <input id="txtGiftExchangeNumber" type="hidden" runat="server"  maxlength="8"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="tableStyle_left" style="border: 0px; background-color: White">
                                                        <span style="color: #ff4800; vertical-align: middle">*</span>所需积分：
                                                    </td>
                                                    <td class="tableStyle_right" style="border: 0px">
                                                        <input id="txtGiftExchangePoint" type="text" runat="server" class="border_radius" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="tableStyle_left" style="border: 0px; background-color: White">
                                                        备注：
                                                    </td>
                                                    <td class="tableStyle_right" colspan="2" style="vertical-align: top; border: 0px">
                                                        <textarea id="txtGiftRemark" rows="4" runat="server" style="width: 250px; word-wrap: break-word;
                                                            outline: none; resize: none;"></textarea>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td style="width: 200px; background-color: #edf2f6; text-align: center;vertical-align: top; height:270px;">
                                            <div style="width: 180px;margin-left: auto; margin-right: auto; margin-top:0px;">
                                                <div class="user_regist_pic" style="height: 130px; border: 0px; width: 180px;">
                                                    <img alt="" id="imgGiftPhoto" src="../images/Gift/nogift.jpg" style=" height:130px; width:180px;" runat="server" />
                                                    <input type="hidden" id="txtGiftPhoto" runat="server" />
                                                </div>
                                                <p>
                                                    <span style="color: #DB9944; font-size: 12px; font-weight:bold;">相片支持大小为160*120</span>
                                                </p>
                                                <div class="common_Button_all" style="text-align: center; margin-top:2px;">
                                                    <input id="GiftPhoto_Uploadify" type="file" class="common_Button common_ServiceButton" />
                                                    <input id="btnGiftPhotoUpload" style="margin-left: 16px;" type="button" class="common_Button"
                                                        value="上传图片" onclick="javascript:$('#GiftPhoto_Uploadify').uploadifyUpload();" />
                                                </div>
                                                <div id="Gift_fileQueue">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="4" style="text-align: center; height: 36px">
                                            <input id="btnGiftSave" type="button" value="保   存" class="buttonColor" />&nbsp;
                                            <input id="btnGiftReset" type="button" class="buttonRest" value="重   置" />
                                            <input id="GiftAddOrEdit" type="hidden" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
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
                                            <input id="btnGiftAdd" type="button" value="新增礼品" onclick="GiftAdd()" class="common_Button"
                                                runat="server" visible="false" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="table-style table-hover user_List_txt">
                                    <thead class="thead">
                                        <tr class="th">
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                礼品名称
                                            </th>
                                            <th>
                                                礼品简码
                                            </th>
                                            <th>
                                                所属分类
                                            </th>
                                            <th>
                                                所需积分
                                            </th>
                                            <th>
                                                礼品缩略图
                                            </th>
                                            <th>
                                                库存数量
                                            </th>
                                            <th>
                                                兑换数量
                                            </th>
                                            <th>
                                                店铺名称
                                            </th>
                                            <th>
                                                礼品备注
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                    </thead>
                            <%int i=0;%>
                         <c:forEach items="${pointgiftFormBean.rows}" var="p" varStatus="status">
                             <%i++;%>
                                    <tr class="td">
                                        <td>
                                            <%=i%>
                                        </td>
                                        <td style="text-align: left">
                                                ${p.giftname}
                                        </td>
                                        <td style="text-align: left">
                                                ${p.giftcode}
                                        </td>
                                        <td>
                                                ${p.giftclassname}
                                        </td>
                                        <td style="text-align: right">
                                                ${p.giftexchangepoint}
                                        </td>
                                        <td>
                                            <span onclick='return ShowPic("");' style="cursor: pointer;">
                                                <img id="imgPhoto" alt=""  src=''
                                                    style="width: 30px; height: 30px;" />
                                            </span>
                                        </td>
                                        <td style="text-align: right">
                                                ${p.giftstocknumber}
                                        </td>
                                        <td style="text-align: right">
                                                ${p.giftexchangenumber}
                                        </td>
                                        <td>
                                                ${p.shopname}
                                        </td>
                                        <td style="text-align: left">
                                                ${p.giftremark}
                                        </td>
                                       <td class="listtd" style="width: 60px;">
                                            <a href="#" onclick='btnGiftEdit("${p.giftname}",${p.giftid});'
                                                id="hyGiftEdit"  visible="false">
                                                <img src="../images/Gift/eit.png" alt="编辑" title="编辑" /></a> <a href="#" visible="false" id="hyGiftDel"
                                                    runat="server" onclick='btnGiftDel("${p.giftname}",${p.giftid});'>
                                                    <img src="../images/Gift/del.png" alt="删除" title="删除" />
                                                </a>
                                        </td>
                                    </tr>
                         </c:forEach>
                        </table>
                        <div class="user_List_page">
                            <div width="100%" border="0" cellpadding="0" cellspacing="0">

                                <page:page pageIndex="${pointgiftFormBean.page}" pageCount="${pointgiftFormBean.pages}" rowCount="${pointgiftFormBean.total}"
                                           pageSize="${pointgiftFormBean.pageSize}"
                                           path="GiftList.do" param="type=1"/>
                                <div class="clear"></div>
                            </div>

                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
