<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="Inc/Style/Style.css" rel="stylesheet" />  
    <link href="Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="Scripts/jquery-common.js" type="text/javascript"></script>
   
    <script src="Scripts/grid.js" type="text/javascript"></script>    
    <script src="Scripts/FusionCharts/FusionCharts.js" type="text/javascript"></script>
    <script src="Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="Scripts/Module/System/StartPage.js" type="text/javascript"></script>
    <script src="Scripts/Module/Common/Tab.js" type="text/javascript"></script>
    <script src="Scripts/Module/Common/Common.js" type="text/javascript"></script>
    <script src="Scripts/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
     <script src="Scripts/chats/js/highcharts.js" type="text/javascript"></script>
    
</head>
<body>
    <form id="form1" >
    <input type="hidden" id="txtMemStartTime"  />
    <input type="hidden" id="txtMemEndTime"  />
    <input type="hidden" id="sltShop"  />
    <table style="width: 100%; height: 100%; word-wrap: break-word;" cellspacing="7">
        <tr style="">
            <td colspan="2" style="width: 100%; text-align: left;">
                <!--系统信息-->
                <div class="system_Info">
                    <div class="system_Top system_detail">
                        系统信息
                    </div>
                    <div class="system_user">
                    
                    </div>
                    
                    <div class="user_Info" style="margin-top:2px;height:100%" >
                        <p class="admin">
                            <b>
                             		    ${shopname}&nbsp;&nbsp;
                            </b>操作权限：<b> ${groupname}</b>
                        </p>
                        <p class="cash" >
                            新增会员：<b>今日 <span>
                                 </span>
                                人/昨日 <span>
                                     10</span>
                                人</b> 充值金额：<b> 
                                     今日 <span>
                                     8</span>
                                    元/昨日 <span>
                                         1</span>
                                    元</b> 现金收入：<b>今日 <span>
                                         2</span>
                                        元/昨日 <span>
                                             3</span>
                                        元</b>
                                       <br /> 银联收入：<b>今日 <span>
                                         123</span>
                                        元/昨日 <span>
                                            123</span>
                                        元</b>
                        </p>                       
                        <p class="contact" style="margin-top:25px">                    
                           
                            联系人：<b>${shopcontactman} </b>&nbsp; 
                            电话：<b> ${shoptelephone} </b>&nbsp; 
                            地址：<b> ${shopaddress }</b>
                        </p>                  
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td style="width: 50%;">
                <!--系统公告-->
                <div class="system_Info system_Announce" style="width: 100%;">
                    <div class="system_Top system_notice">
                        系统公告
                    </div>
                    <div>
                        <table>
                            <tr>
                                <td>
                                    <div class="system_user system_pic" >
                                    </div>
                                </td>
                                <td valign="top">
                                    <div class="user_Info announce_list" style="float: none; height:100%;">
                                       <c:forEach items="${sysnoticeFormBean.rows}" var="s" varStatus="status">
                                           
                                                <div class="announce_text">
                                                    <div class="number">
                                                         ${status.index+1}</div>
                                                    <a id="SysNoticeShow" href="javascript:void(0);" onclick="javascript:NoticeShow(${s.sysnoticeid})">
                                                        ${s.sysnoticetitle} </a>
                                                    <div class="date">
                                                         <fmt:formatDate value="${s.sysnoticetime}" pattern="yyyy-MM-dd HH:mm:ss"/> </div>
                                                </div>
                                        </c:forEach>
                                                
                                            
                                        
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </td>
            <td style="width: 50%">
                <!--会员趋势图-->
                <div class="system_Info system_Announce uder_Trend">
                    <div class="system_Top system_trend">
                        会员趋势图
                    </div>
                    <div id="container" style="width: auto; height: 182px; overflow: hidden;">
                    </div>
                </div>
            </td>
        </tr>
        <tr style="vertical-align: top">
            <td colspan="2" style="width: 100%; vertical-align: top">
                <!--系统提醒-->
                <div class="system_Info notice">
                    <div class="system_Top tab-hd" style="padding-left: 0px;">
                        <ul class="tab-nav">
                            <li>会员生日提醒</li><b>|</b>
                            <li>会员期限提醒</li><b>|</b>
                            <li>积分清零提醒</li><b>|</b>
                            <li>库存不足提醒</li><b>|</b>
                            <li>自定义提醒</li>
                        </ul>
                        <div style="float: right; margin-right: 10px; font-size: 12px; margin-top: 5px;">
                            <a href="Common/TodayRemind.aspx?PID=93">
                                <img src="Inc/Style/images/more.gif" alt="更多" title="更多" /></a>
                        </div>
                    </div>
                    <div class="tab-bd">
                        <div class="tab-pal">
                            <table class="table-style table-hover">
                                
                                            <tr class="th">
                                                <th>
                                                    序号
                                                </th>
                                                <th>
                                                    会员卡号
                                                </th>
                                                <th>
                                                    会员姓名
                                                </th>
                                                <th>
                                                    会员等级
                                                </th>
                                                <th>
                                                    手机号码
                                                </th>
                                                <th>
                                                    生日
                                                </th>
                                                <th>
                                                    积分
                                                </th>
                                                <th>
                                                    所属店铺
                                                </th>
                                            </tr>
                                      
                                        <tr class="td">
                                            <td>
                                                 1
                                            </td>
                                            <td>
                                                <b>
                                                    1</b>
                                            </td>
                                            <td>
                                                 1
                                            </td>
                                            <td>
                                                 1
                                            </td>
                                            <td>
                                                 1
                                            </td>
                                            <td>
                                                 yyyy-MM-dd
                                            </td>
                                            <td>
                                               MemPoint
                                            </td>
                                            <td>
                                               ShopName
                                            </td>
                                        </tr>
                                   
                            </table>
                        </div>
                        <div class="tab-pal">
                            <table class="table-style table-hover">
                               
                                    
                                            <tr class="th">
                                                <th>
                                                    序号
                                                </th>
                                                <th>
                                                    会员卡号
                                                </th>
                                                <th>
                                                    会员姓名
                                                </th>
                                                <th>
                                                    会员等级
                                                </th>
                                                <th>
                                                    手机号码
                                                </th>
                                                <th>
                                                    过期时间
                                                </th>
                                                <th>
                                                    积分
                                                </th>
                                                <th>
                                                    所属店铺
                                                </th>
                                            </tr>
                                      
                                   
                                        <tr class="td">
                                            <td>
                                                 lblNumber
                                            </td>
                                            <td>
                                                <b>
                                                     MemCard</b>
                                            </td>
                                            <td>
                                                 MemName")
                                            </td>
                                            <td>
                                                 LevelName")
                                            </td>
                                            <td>
                                                 MemMobile")
                                            </td>
                                            <td>
                                                 MemPastTime","{0:yyyy-MM-dd}")
                                            </td>
                                            <td>
                                                 MemPoint")
                                            </td>
                                            <td>
                                                 ShopName")
                                            </td>
                                        </tr>
                                    </ItemTemplate>
                               
                            </table>
                        </div>
                        <div class="tab-pal">
                            <table class="table-style table-hover">
                                 
                                            <tr class="th">
                                                <th>
                                                    序号
                                                </th>
                                                <th>
                                                    会员卡号
                                                </th>
                                                <th>
                                                    会员姓名
                                                </th>
                                                <th>
                                                    会员等级
                                                </th>
                                                <th>
                                                    手机号码
                                                </th>
                                                <th>
                                                    积分
                                                </th>
                                                <th>
                                                    最后一次消费时间
                                                </th>
                                                <th>
                                                    消费总次数
                                                </th>
                                                <th>
                                                    所属店铺
                                                </th>
                                            </tr>
                                       
                                        <tr class="td">
                                            <td>
                                                 lblNumber
                                            </td>
                                            <td>
                                                <b>
                                                     MemCard</b>
                                            </td>
                                            <td>
                                                 MemName
                                            </td>
                                            <td>
                                                 LevelName
                                            </td>
                                            <td>
                                                 MemMobile
                                            </td>
                                            <td>
                                                 MemPoint
                                            </td>
                                            <td>
                                                 MemConsumeLastTime yyyy-MM-dd
                                            </td>
                                            <td>
                                                 MemConsumeCount
                                            </td>
                                            <td>
                                                 ShopName
                                            </td>
                                        </tr>
                                   
                               
                            </table>
                        </div>
                        <div class="tab-pal">
                            <table class="table-style table-hover">
                                
                                            <tr class="th">
                                                <th>
                                                    序号
                                                </th>
                                                <th>
                                                    商品名称
                                                </th>
                                                <th>
                                                    商品编码
                                                </th>
                                                <th>
                                                    商品简码
                                                </th>
                                                <th>
                                                    库存数量
                                                </th>
                                                <th>
                                                    创建时间
                                                </th>
                                                <th>
                                                    单价
                                                </th>
                                                <th>
                                                    所属店铺
                                                </th>
                                            </tr>
                                      
                                        <tr class="td">
                                            <td>
                                                 lblNumber
                                            </td>
                                            <td>
                                                <b>
                                                     Name</b>
                                            </td>
                                            <td>
                                                 GoodsCode
                                            </td>
                                            <td>
                                                 NameCode
                                            </td>
                                            <td>
                                                 Number
                                            </td>
                                            <td>
                                                 GoodsCreateTime :yyyy-MM-dd
                                            </td>
                                            <td>
                                                 Price 0:F2 
                                            </td>
                                            <td>
                                                 ShopName 
                                            </td>
                                        </tr>
                                   
                                
                            </table>
                        </div>
                        <div class="tab-pal">
                            <table class="table-style table-hover">
                                
                                    
                                            <tr class="th">
                                                <th>
                                                    序号
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
                                                    发布提醒时间
                                                </th>
                                                <th>
                                                    发布提醒店铺
                                                </th>
                                                <th>
                                                    发布提醒操作员
                                                </th>
                                            </tr>
                                      <c:forEach items="${syscustomremindFormBean.rows}" var="s" varStatus="status">
                                        <tr class="td">
                                            <td>
                                                 ${status.index+1}
                                            </td>
                                            <td>
                                                <b>${s.customremindtitle }</b>
                                            </td>
                                            <td>
                                                 ${s.customreminddetail}
                                            </td>
                                            <td> 
                                       ${s.customremindtime}
                                            </td>
                                            <td>
                                            <fmt:formatDate value="${s.customremindcreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>  
                                                 
                                            </td>
                                            <td>
                                                 ${s.shopname} 
                                            </td>
                                            <td>
                                                 ${s.username} 
                                            </td>
                                        </tr>
                                  </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <script type="text/javascript">
        jQuery(".system_Info").slide({ titCell: ".tab-hd li", mainCell: ".tab-bd", delayTime: 0 });
    </script>
    </form>
</body>
</html>
