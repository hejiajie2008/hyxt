﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
    
    <script src="../Scripts/Module/SystemManage/ShopAuthority.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="page_form" action="ShopList.do"   >
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
                                            <input id="btnShopAuthority" type="button" value="保   存" class="common_Button" />&nbsp;
                                            <input id="btnShopReset" type="button" value="取   消" class="common_Button" />
                                            <input type="hidden" id="mydata" value="${data}"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <table class="table-style table-hover user_List_txt" id="tbChick">
                            
                                        <tr class="th">
                                            <th>
                                                <input type="checkbox" id="chkAll" class="chkAll" onclick="SelectAll()" />
                                            </th>
                                            <th>
                                                序号
                                            </th>
                                            <th>
                                                店铺名称
                                            </th>
                                            <th>
                                                联系人
                                            </th>
                                            <th>
                                                联系电话
                                            </th>
                                            <th>
                                                详细地址
                                            </th>
                                            <th>
                                                备注
                                            </th>
                                        </tr>
                                  <c:forEach items="${sysshopFormBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                       
                                        
                                          <input type="checkbox" class="chk" value='${s.shopid}'
                                         ${s.ischeck?"checked='true'":"" }
                                           id="chkitem"  />
                                           
                                        </td>
                                        <td>
                                            ${status.index+1}
                                        </td>
                                        <td>
                                            ${s.shopname}
                                        </td>
                                        <td>
                                            ${s.shopcontactman}
                                        </td>
                                        <td>
                                            ${s.shoptelephone}
                                        </td>
                                        <td style="text-align: left; padding-left: 4px;">
                                            ${s.shopaddress}
                                        </td>
                                        <td>
                                            ${s.shopremark}
                                        </td>
                                    </tr>
                              </c:forEach>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
    </table>
  
    <input type="hidden" id="ShopID" name="shopid" value="${sysshopFormBean.shopid }"/>
    </form>
</body>
</html>
