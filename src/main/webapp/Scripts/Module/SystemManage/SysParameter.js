$(document).ready(function () {

    AutoPrint();

    $("#chkAutoPrint").bind("click", AutoPrint);
    //统一打印小票标题和脚注
    $("#chkAccordPrint").bind("click", AccordPrint);
    $("#chkStaff").bind("click", chkStaff);
    $("#saveParameter").bind("click",saveSysParameter)

    function saveSysParameter(){
    	doAjax("SystemManager/",
    	           "saveSysParameter.do",
    	           {"parameterid":_parameter.parameterid,
    				
    				"pwd":$("#chkPwd").attr("checked")?1:0,
    				"iseditpwdneedoldpwd":$("#chkIsNeedPwd").attr("checked")?1:0,
    				"moneyandpoint":$("#chkMoneyAndPoint").attr("checked")?1:0,
    				"autolevel":$("#chkAutoLevel").attr("checked")?1:0,
    				"degradelevel":$("#chkDegradeLevel").attr("checked")?1:0,
    						"pasttime":$("#chkPastTime").attr("checked")?1:0,
    				       "pointlevel":$("#chkPointLevel").attr("checked")?1:0,
    				    		   "ismustslotcard":$("#chkIsMustSlotCard").attr("checked")?1:0,
    				    	"recommendpoint":$("#txtRecommendPoint").val(),
    				        "drawmoneypercent":$("#txtDrawMoneyPercent").val(),
    				        "pointperiod":$("#txtPointPeriod").val(),
    				       "stockcount":$("#txtStockCount").val(),
    				      "unitlist":$("#txtUnitList").val(),
    				      "ispaycard":$("#chkPayCard").attr("checked")?1:0,
    				    		  "ispaycash":$("#chkPayCash").attr("checked")?1:0,
    				    				  "ispaybink":$("#chkPayBink").attr("checked")?1:0,
    				         "ispaycoupon":$("#chkPayCoupon").attr("checked")?1:0,
    				        		 "ismemregisterstaff":$("#chkMemRegisterStaff").attr("checked")?1:0,
    				         "isstaff":$("#chkStaff").attr("checked")?1:0,
    						"stafftype":$("#rdStaff").attr("checked")?1:0,
    							"autoprint":$("#chkAutoPrint").attr("checked")?1:0,
    						"printpreview":$("#PrintPreview").attr("checked")?1:0,
    						    	"printpapertype":
    						    		function (){
    						    		
    						    		if($("#A4ShiZhi").attr("checked")){
    						    			return 0;
    						    		}else if($("#SanLianShiZhi").attr("checked")){
    						    			return 1;
    						    		}else if($("#POs58ShiZhi").attr("checked")){
    						    			return 2;
    						    		}else{
    						    			return 3;
    						    		}
    						    	},
    						    "accordprint":$("#chkAccordPrint").attr("checked")?1:0,
    						    	"printtitle":$("#txtPrintTitle").val(),
    						    	"printfootnote":$("#txtPrintFootNote").val(),
    						    	"pointnumstr":function(){
    						    	 var ss= $("#Txthycz").val()+"$"+
    						    	 $("#Txtjfbd").val()+"$"+
    						    	 $("#Txtjfdh").val()+"$"+
    						    	 $("#Txtsprk").val()+"$"+
    						    	 $("#Txtspxf").val()+"$"+
    						    	 $("#Txtjcxf").val()+"$"+
    						    	 $("#Txtksxf").val()+"$"+
    						    	 $("#Txthycc").val()+"$"+
    						    	 $("#Txthycs").val()+"$"+
    						    	 $("#Txtxfjl").val()+"$"+
    						    	 $("#AccountsToMoney").val()+"$"+
    						    	 $("#Txthyczbb").val()+"$"+
    						    	 $("#Txtjfbdbb").val()+"$"+
    						    	 $("#Txtjfdhbb").val()+"$"+
    						    	 $("#Txtckrkmx").val();
    						    	 return ss;
    						    	},
    						    	"selleraccount":$("#txtSellerAccount").val(),
    						    	"partnerid":$("#txtPartnerID").val(),
    						    	 "partnerkey":$("#txtPartnerKey").val(),
    						    	"isautosendsmsbymempast":$("#chkIsAutoSendSMSByMemPast").attr("checked")?1:0,
    						    	 "autosendsmsbymempastforday":$("#txtAutoSendSMSByMemPastForDay").val(),
    						    	 "isautosendsmsbymembirthday":$("#chksAutoSendSMSByMemBirthday").attr("checked")?1:0,
    						    	 "autosendsmsbymembirthdayforday":$("#txtAutoSendSMSByMemBirthdayForDay").val(),
    						    	 "autobackupdb":$("#CKautoBackup").attr("checked")?1:0,
    						    	"autobackupday":$("#TBautoBackupDay").val(),
    						    	 "isstartweixin":$("#chkIsStartWeiXin").attr("checked")?1:0,
    						    	 "isstarttimingproject":$("#chkIsStartTimingProject").attr("checked")?1:0,
    						    	 "isstartmemcount":$("#chkIsStartMemCount").attr("checked")?1:0,
    						    	 "shopsettlement": $("#chkIsSettlement").attr("checked")?1:0,
    						    	 "issendcard":$("#chkIsSendCard").attr("checked")?1:0,
    						    	 "shopsmsmanage":$("#chkShopSmsManage").attr("checked")?1:0,
    						    	 "shoppointmanage":$("#chkShopPointManage").attr("checked")?1:0
    						    	
    	           },
    	           "json",
    	           function (json) {
    		switch (json) {
            case 0:
                art.dialog
                     ({
                         title: '系统提示',
                         time: 4,
                         content: ("系统异常，未保存数据，请再次点击保存！"),
                         lock: true
                     });
                break;
            case -3:
                art.dialog
                     ({
                         title: '系统提示',
                         time: 4,
                         content: ("系统错误 请与系统管理员联系！"),
                         lock: true
                     });
                break;
           
            default:
                art.dialog
                       ({
                           title: '系统提示',
                           time: 0.5,
                           content: '保存成功！',
                           close: function () { location.href = window.location.reload(); },
                           lock: true
                       });
                break;
       
    	           }
    	}
    	    )
    }

    //感应式IC卡初始化 按钮响应函数
    $("#btnSenseICCardInit").bind("click", btnSenseICCardInit)
    //接触式IC卡初始化 按钮响应函数
    $("#btnContactICCardInit").bind("click", btnContactICCardInit);
    //感应式IC卡复选框点击事件     感应式IC卡和接触式IC卡只能二选一或不选
    $("#chkSenseiccard").bind("click", chkSenseiccardClick);
    //接触式IC卡复选框点击事件     感应式IC卡和接触式IC卡只能二选一或不选
    $("#chkContacticcard").bind("click", chkContacticcardClick);

    //标准打印机  A4试纸     三者只可选择一种试纸
    $("#A4ShiZhi").bind("click", A4ShiZhi_Click);
    //三联打印机   打印试纸
    $("#SanLianShiZhi").bind("click", SanLianShiZhi_Click);
    //pos58打印机  打印试纸
    $("#POs58ShiZhi").bind("click", POs58ShiZhi_Click);
    $("#POs80ShiZhi").bind("click", POs80ShiZhi_Click);

    $("#chkPwd").bind("click", PwdCheck);


    if ($("#chkPwd").attr("checked")) {
        $("#chkIsNeedPwd").attr("disabled", false);
    }
    else {
        $("#chkIsNeedPwd").attr("disabled", true);
    }


    $("#chkAutoLevel").bind("click", LevelUpdown);


    if ($("#chkAutoLevel").attr("checked")) {
        $("#chkDegradeLevel").attr("disabled", false);
    }
    else {
        $("#chkDegradeLevel").attr("disabled", true);
    }


    if (!$("#chkStaff").attr("checked")) {
        $('#rdStaff').attr("disabled", "disabled");
        $('#rdGoods').attr("disabled", "disabled");
    }
    if (!$("#chkAccordPrint").attr("checked")) {
        $('#txtPrintTitle').css("background-color", "#eee");
        $('#txtPrintTitle').attr("readonly", true);
        $('#txtPrintFootNote').css("background-color", "#eee");
        $('#txtPrintFootNote').attr("readonly", true);
    }
    var strEmailPwd = $("#lblEmailPwd").html();
    if (strEmailPwd != "") {
        $("#txtEmailPwd").val(strEmailPwd);
    }
    var strPartnerKey = $("#lblPartnerKey").html();
    if (strPartnerKey != "") {
        $("#txtPartnerKey").val(strPartnerKey);
    }

    if (!$("#chkSenseiccard").bind("click", chkSenseiccard).attr("checked")) {
        $("#btnSenseICCardInit").attr("disabled", true);
    }

    function load(){
    	SysParameter();
    	
    	//  启用密码验证
    	$("#chkPwd").attr("checked",_parameter.pwd==1);
    	PwdCheck();
    	//  会员重置密码时验证原始密码
    	$("#chkIsNeedPwd").attr("checked",_parameter.iseditpwdneedoldpwd==1);
    	//启用会员登记赠送余额及积分
    	$("#chkMoneyAndPoint").attr("checked",_parameter.moneyandpoint==1);
    	//启用积分转换等级
    	$("#chkAutoLevel").attr("checked",_parameter.autolevel==1);
    	//会员等级允许降级
        $("#chkDegradeLevel").attr("checked",_parameter.degradelevel==1);
        // 设置会员过期时间
        $("#chkPastTime").attr("checked",_parameter.pasttime==1);
    	// 启用会员多级积分提成
        $("#chkPointLevel").attr("checked",_parameter.pointlevel==1);
        // 启用会员必须刷卡消费
        $("#chkIsMustSlotCard").attr("checked",_parameter.ismustslotcard==1);
        //推荐会员获得积分
        $("#txtRecommendPoint").val(_parameter.recommendpoint);
        //账户提现折损比率
        $("#txtDrawMoneyPercent").val(_parameter.drawmoneypercent);
        //积分清零提醒周期
        $("#txtPointPeriod").val(_parameter.pointperiod);
        //商品库存报警数量
        $("#txtStockCount").val(_parameter.stockcount);
        // 商品单位
        $("#txtUnitList").val(_parameter.unitlist);
        
        
        
        //启用余额支付
        $("#chkPayCard").attr("checked",_parameter.ispaycard==1);
        //启用现金支付
        $("#chkPayCash").attr("checked",_parameter.ispaycash==1);
        //启用银联支付
        $("#chkPayBink").attr("checked",_parameter.ispaybink==1);
        //启用优惠券
        $("#chkPayCoupon").attr("checked",_parameter.ispaycoupon==1);
        //启用会员登记员工提成功能
    	$("#chkMemRegisterStaff").attr("checked",_parameter.ismemregisterstaff==1);
    	// 启用会员消费员工提成功能
    	$("#chkStaff").attr("checked",_parameter.isstaff==1);
    	if(_parameter.stafftype==1){
    		$("#rdStaff").attr("checked",true);
    		$("#rdGoods").attr("checked",false);
    	}else{
    		$("#rdStaff").attr("checked",false);
    		$("#rdGoods").attr("checked",true);
    	}
    	chkStaff();
    	
    	//启用打印功能
    	$("#chkAutoPrint").attr("checked",_parameter.autoprint==1);
    	//是否启用打印预览
    	$("#PrintPreview").attr("checked",_parameter.printpreview==1);
    	
    	if(_parameter.printpapertype==0){
    		$("#A4ShiZhi").attr("checked",true);
    	}else if(_parameter.printpapertype==1){
    		$("#SanLianShiZhi").attr("checked",true);
    	}else if(_parameter.printpapertype==2){
    		$("#POs58ShiZhi").attr("checked",true);
    	}else{
    		$("#POs80ShiZhi").attr("checked",true);
    	}
    	AutoPrint();
    	// 各店铺打印小票标题和脚注都一致
    	$("#chkAccordPrint").attr("checked",_parameter.accordprint==1);
    	// 打印小票标题
    	 $("#txtPrintTitle").val(_parameter.printtitle);
    	 //打印小票脚注
    	 $("#txtPrintFootNote").val(_parameter.printfootnote);
    	 var ss=_parameter.pointnumstr.split("$");
    	 
    	 //设置会员充值打印份数Txthycz
    	 $("#Txthycz").val(ss[0]);
    	 //设置积分变动打印份数
    	 $("#Txtjfbd").val(ss[1]);
    	 //设置积分兑换打印份数
    	 $("#Txtjfdh").val(ss[2]);
    	 //设置商品入库打印份数
    	 $("#Txtsprk").val(ss[3]);
    	 //设置商品消费打印份数
    	 $("#Txtspxf").val(ss[4]);
    	 //设置计次消费打印份数
    	 $("#Txtjcxf").val(ss[5]);
    	 //设置快速消费打印份数
    	 $("#Txtksxf").val(ss[6]);
    	 // 设置会员充次打印份数
    	 $("#Txthycc").val(ss[7]);
    	 //设置会员充时打印份数
    	 $("#Txthycs").val(ss[8]);
    	 //设置消费记录打印份数
    	 $("#Txtxfjl").val(ss[9]);
    	 //设置账户提现打印份数
    	 $("#AccountsToMoney").val(ss[10]);
    	 //设置会员充值报表打印份数
    	 $("#Txthyczbb").val(ss[11]);
    	 // 设置积分变动报表打印份数
    	 $("#Txtjfbdbb").val(ss[12]);
    	//  设置积分兑换报表打印份数
    	 $("#Txtjfdhbb").val(ss[13]);
    	//  设置商品出入库明细打印份数
    	 $("#Txtckrkmx").val(ss[14]);
    	 //商家支付宝账户
    	 $("#txtSellerAccount").val(_parameter.selleraccount);
    	 //合作者身份(PID)
    	 $("#txtPartnerID").val(_parameter.partnerid);
    	 // 交易安全检验码
    	 $("#txtPartnerKey").val(_parameter.partnerkey);
    	 //会员到期自动发送短信
    	 $("#chkIsAutoSendSMSByMemPast").attr("checked",_parameter.isautosendsmsbymempast==1);
    	 //会员到期提醒提前
    	 $("#txtAutoSendSMSByMemPastForDay").val(_parameter.autosendsmsbymempastforday);
    	 //会员生日自动发送短信
    	 $("#chksAutoSendSMSByMemBirthday").attr("checked",_parameter.isautosendsmsbymembirthday==1);
    	 //会员生日提醒提前 
    	 $("#txtAutoSendSMSByMemBirthdayForDay").val(_parameter.autosendsmsbymembirthdayforday);
    	 //启用系统自动备份数据库
    	 $("#CKautoBackup").attr("checked",_parameter.autobackupdb==1);
    	 //间隔多久备份一次
    	 $("#TBautoBackupDay").val(_parameter.autobackupday);
    	 //启用微信
    	 $("#chkIsStartWeiXin").attr("checked",_parameter.isstartweixin==1);
    	 //启用计时服务
    	 $("#chkIsStartTimingProject").attr("checked",_parameter.isstarttimingproject==1);
    	 //启用会员充次
    	 $("#chkIsStartMemCount").attr("checked",_parameter.isstartmemcount==1);
    	 //启用店铺结算功能
    	 $("#chkIsSettlement").attr("checked",_parameter.shopsettlement==1);
    	 //启用店铺购卡
    	 $("#chkIsSendCard").attr("checked",_parameter.issendcard==1);
    	 //启用联盟商短信管理
    	 $("#chkShopSmsManage").attr("checked",_parameter.shopsmsmanage==1);
    	 //启用联盟商积分管理
    	 $("#chkShopPointManage").attr("checked",_parameter.shoppointmanage==1);
    	 //启用感应式IC卡
    	 $("#chkSenseiccard").attr("checked",_parameter.senseiccard==1);
    }
    load();
    
  
    

});


function chkSenseiccard() {
    if (!$("#chkSenseiccard").attr("checked")) {
        $("#btnSenseICCardInit").attr("disabled", true);
    }
    else {
        $("#btnSenseICCardInit").attr("disabled", false);
    }
}

function PwdCheck() {
    if ($("#chkPwd").attr("checked")) {
        $("#chkIsNeedPwd").attr("checked", false).attr("disabled", false);
    }
    else
    {
        $("#chkIsNeedPwd").attr("checked", false).attr("disabled", true);
    }
}

function LevelUpdown() {
    if ($("#chkAutoLevel").attr("checked")) {
        $("#chkDegradeLevel").attr("checked", false).attr("disabled", false);
    }
    else {
        $("#chkDegradeLevel").attr("checked", false).attr("disabled", true);
    }
}

/*************************************************************************
*统一打印小票标题和脚注
*************************************************************************/
function AccordPrint() {
    if ($('#chkAccordPrint').attr("checked")) {
        $('#txtPrintTitle').css("background-color", "");
        $('#txtPrintTitle').attr("readonly", false);

        $('#txtPrintFootNote').css("background-color", "");
        $('#txtPrintFootNote').attr("readonly", false);
    }
    else {
        $('#txtPrintTitle').val("");
        $('#txtPrintTitle').css("background-color", "#eee");
        $('#txtPrintTitle').attr("readonly", true);

        $('#txtPrintFootNote').val("");
        $('#txtPrintFootNote').css("background-color", "#eee");
        $('#txtPrintFootNote').attr("readonly", true);
    }
}
/*************************************************************************
*启动员工提成响应事件
*************************************************************************/
function chkStaff() {
    if ($("#chkStaff").attr("checked")) {
        $('#rdStaff').attr("disabled", "");
        $('#rdGoods').attr("disabled", "");
    }
    else {
        $('#rdStaff').attr("disabled", "disabled");
        $('#rdGoods').attr("disabled", "disabled");
    }
}

function checkPayType() {
    if (!$("#chkPayCard").attr("checked") && !$("#chkPayCash").attr("checked") && !$("#chkPayBink").attr("checked") && !$("#chkPayCoupon").attr("checked")) {
        art.dialog({
            title: '系统提示',
            icon: 'error', //图标
            content: '请选择付费找零方式，否则无法进行付费！',
            lock: true
        });
        return false;
    }
}

/******************************************************************
*不选择“启用系统邮件功能”时，不能选择“启用系统邮件(账户变动信息)自动发送功能”
******************************************************************/
function IsMoneyEmail() {
    if ($("#chkEmail").attr("checked") == false) {
        $('#chkMoneyEmail').attr("checked", false);
        $('#chkMoneyEmail').attr("disabled", true);

        $('#chkEnterpriseEmailEnableSSL').attr("checked", false);
        $('#chkEnterpriseEmailEnableSSL').attr("disabled", true);

        $('#chkEnterpriseEmailUseDefaultCredentials').attr("checked", false);
        $('#chkEnterpriseEmailUseDefaultCredentials').attr("disabled", true);

        $('#txtEmailAdress').attr("readonly", "readonly");
        $('#txtEmailPwd').attr("readonly", "readonly");
        $('#txtEmailSMTP').attr("readonly", "readonly");
        $('#txtEnterpriseEmailPort').attr("readonly", "readonly");
        $('#txtEnterpriseEmailDisplayName').attr("readonly", "readonly");

        $('#txtEmailAdress').val("");
        $('#txtEmailPwd').val("");
        $('#txtEmailSMTP').val("");
        $('#txtEnterpriseEmailPort').val("25");
        $('#txtEnterpriseEmailDisplayName').val("");

        $('#txtEmailAdress').attr("disabled", "disabled");
        $('#txtEmailPwd').attr("disabled", "disabled");
        $('#txtEmailSMTP').attr("disabled", "disabled");
        $('#txtEnterpriseEmailPort').attr("disabled", "disabled");
        $('#txtEnterpriseEmailDisplayName').attr("disabled", "disabled");
    }
    else {
        $('#chkMoneyEmail').attr("disabled", false);
        $('#chkEnterpriseEmailEnableSSL').attr("disabled", false);
        $('#chkEnterpriseEmailUseDefaultCredentials').attr("disabled", false);

        $('#txtEmailAdress').attr("readonly", "");
        $('#txtEmailPwd').attr("readonly", "");
        $('#txtEmailSMTP').attr("readonly", "");
        $('#txtEnterpriseEmailPort').attr("readonly", "");
        $('#txtEnterpriseEmailDisplayName').attr("readonly", "");

        $('#txtEmailAdress').attr("disabled", "");
        $('#txtEmailPwd').attr("disabled", "");
        $('#txtEmailSMTP').attr("disabled", "");
        $('#txtEnterpriseEmailPort').attr("disabled", "");
        $('#txtEnterpriseEmailDisplayName').attr("disabled", "");
    }
}


function AutoPrint() {
    if ($('#chkAutoPrint').attr("checked")) {
        $('#chkAccordPrint').attr("disabled", false);
        $('#PrintPreview').attr("disabled", false);

        
        //打印纸类型
        $('#SanLianShiZhi').attr("disabled", false);
        $('#POs58ShiZhi').attr("disabled", false);
        $('#POs80ShiZhi').attr("disabled", false);
        //打印份数
        $('#Txthycz').attr("disabled", false);
        $('#Txtjfbd').attr("disabled", false);
        $('#Txtjfdh').attr("disabled", false);
        $('#Txtsprk').attr("disabled", false);
        $('#Txtspxf').attr("disabled", false);
        $('#Txtjcxf').attr("disabled", false);
        $('#Txtksxf').attr("disabled", false);
        $('#Txthycc').attr("disabled", false);
        $('#Txthycs').attr("disabled", false);
        $('#Txtxfjl').attr("disabled", false);
        $('#Txthyczbb').attr("disabled", false);
        $('#Txtjfbdbb').attr("disabled", false);
        $('#Txtjfdhbb').attr("disabled", false);
        $('#Txtckrkmx').attr("disabled", false);
        $('#AccountsToMoney').attr("disabled", false);        
    }
    else {
        $('#chkAccordPrint').attr("checked", false);
        $('#chkAccordPrint').attr("disabled", true);
        $('#PrintPreview').attr("checked", false).attr("disabled", true);
        //打印纸类型
        $('#SanLianShiZhi').attr("disabled", true);
        $('#POs58ShiZhi').attr("disabled", true);
        $('#POs80ShiZhi').attr("disabled", true);
        //打印份数
        $('#Txthycz').attr("disabled", true);
        $('#Txtjfbd').attr("disabled", true);
        $('#Txtjfdh').attr("disabled", true);
        $('#Txtsprk').attr("disabled", true);
        $('#Txtspxf').attr("disabled", true);
        $('#Txtjcxf').attr("disabled", true);
        $('#Txtksxf').attr("disabled", true);
        $('#Txthycc').attr("disabled", true);
        $('#Txthycs').attr("disabled", true);
        $('#Txtxfjl').attr("disabled", true);
        $('#Txthyczbb').attr("disabled", true);
        $('#Txtjfbdbb').attr("disabled", true);
        $('#Txtjfdhbb').attr("disabled", true);
        $('#Txtckrkmx').attr("disabled", true);
        $('#AccountsToMoney').attr("disabled", true);
    }
    AccordPrint();
}

//感应式IC卡初始化
//需要调用浏览器插件的初始化方法，然后等待数毫秒，输出浏览器插件的方法调用结果
//如果出现找不到对象等错误，可能是因为浏览器插件没有正确安装、浏览器插件没有执行权限等原因
//插件为智络公司根据刷卡器厂商提供的接口编写
function btnSenseICCardInit() {
    art.dialog({
        title: '系统提示',
        content: "确定要初始化感应式IC卡吗?",
        lock: true,
        ok: function () {
            this.close();
            CardReader.IniCard(); //初始化
            setTimeout("showMsg()", 500);
        },
        cancelVal: '关闭',
        cancel: true
    })
}
function showMsg() {
    var aa = CardReader.errMsg;
    art.dialog({
        title: '系统提示',
        content: aa,
        time: 1.5,
        lock: true
    })
}


function btnContactICCardInit() {
    art.dialog({
        title: '系统提示',
        content: "确定要初始化接触式IC卡吗?",
        lock: true,
        ok: function () {
            this.close();
            setTimeout("InitContacticcard()", 200);
        },
        cancelVal: '关闭',
        cancel: true
    })
}
//接触式IC卡初始化
//需要调用机器厂商提供的浏览器插件的方法，并且必须按顺序执行厂商提供的一系列方法并检查执行结果
//出现错误 第一时间检查是否是浏览器插件没有正确安装、浏览器插件没有执行权限、机器没有连接等
function InitContacticcard() {
    var status = null;
    var setValue = "";
    MWReaderCtl.MWic_init(0, 9600);
    status = MWReaderCtl.LastRet;
    if (status == 0) {
        MWReaderCtl.MWcsc_4442(6, "ffffff");
        status = MWReaderCtl.LastRet;
        if (status != 0) {
            art.dialog({
                title: '系统提示',
                content: '密码验证错误，请检查设备的LED灯是否处于绿色状态，若不是请将IC卡插好，否则请与管理员联系！！',
                time: 3
            })
            MWReaderCtl.MWic_exit();
            return;
        }
        for (var i = 0; i < 20; i++) {
            setValue += "F";
        }
        MWReaderCtl.MWswr_4442(60, 20, setValue);
        status = MWReaderCtl.LastRet;
        if (status == 0) {
            art.dialog({
                title: '系统提示',
                content: '接触式IC卡初始化成功！！',
                time: 3
            })
        }
        else {
            art.dialog({
                title: '系统提示',
                content: '接触式IC卡初始化失败，请与管理员联系！！',
                time: 3
            })
            MWReaderCtl.MWic_exit();
            return;
        }
        MWReaderCtl.MWic_exit();
    }
    else {
        art.dialog({
            title: '系统提示',
            content: '接触式IC卡设备打开失败，请检查设备连接！',
            time: 3
        });
    }
}

//感应式IC卡复选框
//选择感应式IC卡时要关闭接触式IC卡，2种卡不能同时使用
function chkSenseiccardClick() {
    if ($(this).attr("checked")) { $("#chkContacticcard").attr("checked", false); }
}

//接触式IC卡复选框
//选择接触式IC卡时要关闭感应式IC卡，2种卡不能同时使用
function chkContacticcardClick() {
    if ($(this).attr("checked")) { $("#chkSenseiccard").attr("checked", false); }
}

//A4
function A4ShiZhi_Click() {
    if ($(this).attr("checked")) { $("#SanLianShiZhi").attr("checked", false); $("#POs58ShiZhi").attr("checked", false); $("#POs80ShiZhi").attr("checked", false); }
    else { $(this).attr("checked", true); }
}
//三联
function SanLianShiZhi_Click() {
    if ($(this).attr("checked")) { $("#A4ShiZhi").attr("checked", false); $("#POs58ShiZhi").attr("checked", false); $("#POs80ShiZhi").attr("checked", false); }
    else { $(this).attr("checked", true); }
}
//POS 58
function POs58ShiZhi_Click() {
    if ($(this).attr("checked")) { $("#SanLianShiZhi").attr("checked", false); $("#A4ShiZhi").attr("checked", false); $("#POs80ShiZhi").attr("checked", false); }
    else { $(this).attr("checked", true); }
}

//POS 80
function POs80ShiZhi_Click() {
    if ($(this).attr("checked")) { $("#SanLianShiZhi").attr("checked", false); $("#A4ShiZhi").attr("checked", false); $("#POs58ShiZhi").attr("checked", false); }
    else { $(this).attr("checked", true); }
}