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
    <script src="../Scripts/Module/MemExpense/TimeList.js" type="text/javascript"></script>
    <script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
</head>
<body>
    <form id="frmTiemExpense" >
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
                        <div class="user_List_top">
                            <div class="user_List_top">
                                <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                                    class="tableStyle">
                                    <tr style="color: #333333; background-color: #F7F6F3;">
                                        <td class="user_List_styleLeft">
                                            快捷操作：
                                        </td>
                                        <td class="user_List_styleRight">
                                            <div class="user_List_Button">
                                                <input id="btnAddTiming" type="button" value="新增计时"  class="common_Button"  visible="false" />
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>                            
                        </div>
                        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#434343"
                            class="tableStyle">
                            <tr>
                                <td class="tableStyle_left">
                                    请输入卡号：
                                </td>
                                <td class="tableStyle_right" style=" width:200px;">
                                    <input id="txtQueryTiming" type="text"  class="border_radius" maxlength="20" title="会员卡号/令牌"/>
                                </td>
                                <td class="tableStyle_right">
                                    <div class="user_List_Button">
                                        <input type="button" id="btnQueryTiming"  value="查   询" class="common_Button"
                                            OnClick="btnQueryTiming_Click" /> 
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="table-style table-hover user_List_txt">
                          
                                        <tr class="th">
                                            <th>
                                                订单编号
                                            </th>
                                            <th>
                                                消费类型
                                            </th>
                                            <th>
                                                消费服务
                                            </th>
                                            <th>
                                                会员姓名
                                            </th>
                                            <th>
                                                卡号/令牌
                                            </th>
                                            <th>
                                                开始操作员
                                            </th>
                                            <th>
                                                消费状态
                                            </th>
                                            <th>
                                                预定时长
                                            </th>
                                            <th>
                                                剩余时长
                                            </th>
                                            <th>
                                                开始时间
                                            </th>
                                            <th>
                                                结束时间
                                            </th>
                                            <th>
                                                消费详情
                                            </th>
                                            <th>
                                                结束操作员
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                   
                                <c:forEach  items="${memstoragetimingBean.rows}" var="s" varStatus="status">
                                    <tr class="td">
                                        <td>
                                            ${s.storagetimingaccount}
                                            <label  ID="ltOrderTimeID" Visible="false" Text='$\{s.OrderTimeID}'></label>
                                            <label  ID="ltProjectName" Visible="false" Text='$\{s.ProjectName}'></label>
                                        </td>
                                        <td>
                                            ${s.storagetimingmemid=="0"?"散客消费":"会员消费"}
                                        </td>
                                        <td>
                                            ${s.projectname}
                                        </td>
                                        <td style="text-align: left;">
                                            ${s.memname}
                                        </td>
                                        <td>
                                            $\{s.OrderToken}
                                        </td>
                                        <td>
                                            ${s.startUserName}
                                        </td>
                                        <td>
                                            ${s.orderState==1 ? "<p style='color:red;'>消费结束</p>" : "正在消费"}
                                        </td>
                                        <td>
                                        
                                         
                                         <c:if test="s.storageresiduetime==0">
                                         	未设置
                                         </c:if>
                                          <c:if test="s.storageresiduetime==1">
                                         	${s.storageresiduetime}分钟
                                         </c:if>
                                        
                                           
                                        </td>
                                        <td style="width: 120px;"><!---- *********************剩余时间*******************---->
                                            ${s.orderState}
                                        </td>
                                        <td>
                                            $\{s.OrderMarchTime}
                                        </td>
                                        <td>
                                            $\{s.OrderOutTime}
                                        </td>
                                        <td style="text-align: left;">
                                            ${s.storagetimingremark}
                                        </td>
                                        <td>
                                            ${s.endUserName}
                                        </td>
                                        <td class="listtd" style="width: 40px; text-align: center;">
                                        
                                         <c:if test="s.orderState==1">
                                         <p style='color:red;'><img src="../images/Gift/isok.png" title="已结算" alt="已结算" />
                                         </p>
                                         </c:if>
                                           
                                            <input type="button"  name="SettleAccounts" id="hyEndExpense"  />&nbsp;
                                            <img src="../images/Gift/goexpense.png" title="转到结算"
                                                    alt="转到结算" />
                                        </td>
                                    </tr>
                                </c:forEach>
                        </table>
                        <div class="user_List_page">
                            <table style="width: 100%" id="tabPager">
                                <tr>
                                    <td>
                                            	<page:page pageIndex="${memstoragetimingBean.page}" pageCount="${memstoragetimingBean.pages}"
                                          rowCount="${memstoragetimingBean.total}" 
                           					 pageSize="${memstoragetimingBean.pageSize}" 
                           					  path="ExpenseHistory.do" param="type=1"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <label ID="lblPrintTitle" Style="display: none"  value=""></label>
    <label ID="lblPrintFoot" Style="display: none"  value=""></label>
    </form>
</body>
</html>
