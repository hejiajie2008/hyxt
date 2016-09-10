/*global _comma_separated_list_of_variables_*/
var project_name="/hyxt/";


$.extend({
	getnowdate:function(){
		var now = new Date();
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日
        return year+"-"+(month<10?"0":"")+month+"-"+(day<10?"0":"")+day;
	},
	getnowtime:function(){
		var now = new Date();
	    var year = now.getFullYear();       //年
	    var month = now.getMonth() + 1;     //月
	    var day = now.getDate();            //日
	    var hours=now.getHours();           //时
	    var minutes=now.getMinutes();		//分
	    var seconds=now.getSeconds();       //秒
	    return year+"-"+(month<10?"0":"")+month+"-"+(day<10?"0":"")+day+" "+hours+":"+minutes+":"+seconds;
	},
	getpid:function(){
		return $("#PID").val();
	},
	getgoodscode:function(){
		var now = new Date();
	    var year = now.getFullYear();       //年
	    var month = now.getMonth() + 1;     //月
	    var day = now.getDate();            //日
	    var hours=now.getHours();           //时
	    var minutes=now.getMinutes();		//分
	    var seconds=now.getSeconds();       //秒
	   
		return year+""+(month<10?"0":"")+month+(day<10?"0":"")+day+""+hours+""+minutes+seconds;
	},
	
	
	getNoticeCode:function(){
		var now = new Date();
	    var year = (now.getFullYear()+"").substr(2, 2);       //年
	    var month = now.getMonth() + 1;     //月
	    var day = now.getDate();            //日
	    var hours=now.getHours();           //时
	    var minutes=now.getMinutes();		//分
	    var seconds=now.getSeconds();       //秒
	   
		return year+""+(month<10?"0":"")+month+(day<10?"0":"")+day+""+hours+""+minutes+seconds;
	}
});
var isok=false;
$(document).ready(function () {
    $("#tdbox").css({ height: document.body.scrollHeight - 4 });
    
    
    
    $("#btnMemTemplate").click(function(){
    	
    		
    		location.href=project_name+"util/doloadExcl.do?type=Members";
    	});
    	
    	$("#btnMemCheck").click(function(){
    		isok=false;
    		if($("#fileUploadMem").val()==""){
    			alert("对不起！上传内容不能为空");
    		}else{
    			
    			//alert("OK");
    	    	v_uploadfile();
    		}
    		
    		
    		
    	});
    	$("#btnMemImport").click(function(){
    	
    		if($("#strPath").val()==""){
    			alert("对不起，请先验证通过之后再上传");
    		}else if(isok==false){
    			alert("未验证成功，不能导入会员！");
    		}
    		else{
    			import_updatefile();
    		}
    	
    		
    	});
    	
    	
    	
    	
    	
});


function v_uploadfile(){
	
$.ajaxFileUpload({
                url:project_name+'util/uploadExcel.do?type=0',
                fileElementId:'fileUploadMem',
                type: 'post',
                dataType: 'json',
                success: function(data) {
                	 var heads=data.customfields;
                    var html="<tr class=\"th\" style=\"font-weight: bold; height: 20px;\">";
                    html+="<th cope=\"col\">提示</th>";
                    html+="<th cope=\"col\">会员卡号</th>";
                    html+="<th cope=\"col\">姓名</th>";
                    html+="<th cope=\"col\">性别</th>";
                    html+="<th cope=\"col\">身份证号码</th>";
                    html+="<th cope=\"col\">手机号码</th>";
                    html+="<th cope=\"col\">固定电话</th>";
                    html+="<th cope=\"col\">生日</th>";
                    html+="<th cope=\"col\">积分</th>";
                    html+="<th cope=\"col\">余额</th>";
                    html+="<th cope=\"col\">电子邮箱</th>";
                    html+="<th cope=\"col\">地址</th>";
                    html+="<th cope=\"col\">会员等级ID</th>";
                    html+="<th cope=\"col\">开卡店铺ID</th>";
                    html+="<th cope=\"col\">办卡日期</th>";
                    html+="<th cope=\"col\">备注</th>";
                    for (var i=0;i<heads.length;i++){
                    	html+="<th cope=\"col\">"+heads[i].customfieldname+"</th>";
                    }
                    html+="</tr>";
                    
                    if(data.success==1){
                    	
                    	isok=true;
                    	$.each(data.rows,function(index,item){
                    		var excelFields=(item.excelFields);
                    		html+="<tr class=\"td\" style=\"color: #333333; background-color: #F7F6F3;\">";
                    		html+="<td align=\"left\" style=\"color: Red; width: 60px;\">"+item.validate+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.memcard+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.memname+"</td>";
                    		html+="<td align=\"center\" style=\"width: 40px;\">"+(item.memsex==1?"男":"女")+"</td>";
                    		html+="<td align=\"center\" style=\"width: 40px;\">"+item.memidentitycard+"</td>";
                    		html+="<td align=\"center\" style=\"width: 40px;\">"+item.memmobile+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.memtelephone+"</td>";
                    		html+="<td align=\"left\" style=\"width: 60px;\">"+item.membirthday+"</td>";
                    		html+="<td align=\"left\" style=\"width: 60px;\">"+item.mempoint+"</td>";
                    		html+="<td align=\"right\" style=\"width: 40px;\">"+item.memmoney+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.mememail+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.memaddress+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.memlevelid+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.memshopid+"</td>";
                    		html+="<td align=\"center\" style=\"width: 40px;\">"+item.memcreatetimeStr+"</td>";
                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.memremark+"</td>";
                    		for (var i=0;i<excelFields.length;i++){
                    			html+="<td align=\"left\" style=\"width: 40px;\">"+excelFields[i].fieldvalue+"</td>";
                    		}
                    		
                    		
                    		html+="</tr>";
                    		
                    		if(item.validate!='success'){
                    			isok=false;
                    		}
                    		
                    	});
                    	
                    }
                    
                    var filepath=data.filepath;
                   
                    	
                    	 
                    	 $("#strPath").val(filepath);
                    	
                    $("#resultTable").html(html);
                    
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("上传失败，请检查网络后重试");
                }
            });
}

function import_updatefile(){
	doAjax("util/",
	           "importExcel.do",
	           {
	               "strPath": $("#strPath").val()
	               
	           },
	           "json",
	           function (json) {
	        	   alert("上传成功！");
	        	   window.location.href= window.location.href;
	           }
	           );
	
}


function getPageSize() {
    var xScroll, yScroll;
    if (window.innerHeight && window.scrollMaxY) {
        xScroll = window.innerWidth + window.scrollMaxX;
        yScroll = window.innerHeight + window.scrollMaxY;
    } else if (document.body.scrollHeight > document.body.offsetHeight) {
        // all but Explorer Mac  
        xScroll = document.body.scrollWidth;
        yScroll = document.body.scrollHeight;
    } else {
        // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari  
        xScroll = document.body.offsetWidth;
        yScroll = document.body.offsetHeight;
    }
    var windowWidth, windowHeight;
    if (self.innerHeight) {
        // all except Explorer  
        if (document.documentElement.clientWidth) {
            windowWidth = document.documentElement.clientWidth;
        } else {
            windowWidth = self.innerWidth;
        }
        windowHeight = self.innerHeight;
    } else if (document.documentElement && document.documentElement.clientHeight) {
        // Explorer 6 Strict Mode  
        windowWidth = document.documentElement.clientWidth;
        windowHeight = document.documentElement.clientHeight;
    } else if (document.body) {
        // other Explorers  
        windowWidth = document.body.clientWidth;
        windowHeight = document.body.clientHeight;
    }
    // for small pages with total height less then height of the viewport  
    if (yScroll < windowHeight) {
        pageHeight = windowHeight;
    } else {
        pageHeight = yScroll;
    }
    // for small pages with total width less then width of the viewport  
    if (xScroll < windowWidth) {
        pageWidth = xScroll;
    } else {
        pageWidth = windowWidth;
    }
    arrayPageSize = new Array(pageWidth, pageHeight, windowWidth, windowHeight);
    return arrayPageSize;
};
window.onresize = function () {

    //  $("#tdbox").css({ height: document.body.clientWidth - 4 });
}

//// 检测文本框输入只能是正数Float类型
//function isFloatPositive(jQuerySelector) {

//    var numFloatPositive = /^\d+(\.\d+)?|[0-9]*[1-9][0-9]*$/; //^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$正浮点数(8位小数)^\d+(\.\d+)?$

//    //确保用户输入的是正实数
//    if (isNaN($(jQuerySelector).val())) { $(jQuerySelector).val(''); return false; }
//    if (!numFloatPositive.test($(jQuerySelector).val()) && $(jQuerySelector).val() != '') {
//        document.execCommand('undo'); //确保用户输入的是正实数
//        return false;
//    }
//    return true;
//}

 


//判读是否为正整数 
function isIntPositive(jQuerySelector) {
    var num = /^[0-9]*[1-9][0-9]*$/;
    return num.test(jQuerySelector);
}

//乘法函数，用来得到精确的乘法结果
//说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
//调用：accMul(arg1,arg2)
//返回值：arg1乘以arg2的精确结果
function accMul(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try { m += s1.split(".")[1].length } catch (e) { }
    try { m += s2.split(".")[1].length } catch (e) { }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
}

//除法函数，用来得到精确的除法结果
//说明：javascript的除法结果会有误差，在两个浮点数相除的时候会比较明显。这个函数返回较为精确的除法结果。
//调用：accDiv(arg1,arg2)
//返回值：arg1除以arg2的精确结果
function accDiv(arg1, arg2) {
    var t1 = 0, t2 = 0, r1, r2;
    try { t1 = arg1.toString().split(".")[1].length } catch (e) { }
    try { t2 = arg2.toString().split(".")[1].length } catch (e) { }
    with (Math) {
        r1 = Number(arg1.toString().replace(".", ""));
        r2 = Number(arg2.toString().replace(".", ""));
        var result = (r1 / r2) * pow(10, t2 - t1);
        if (result == Infinity) {
            result = 0;
        }
        return result;
    }
}

//加法函数，用来得到精确的加法结果
//说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
//调用：accAdd(arg1,arg2)
//返回值：arg1加上arg2的精确结果
function accAdd(arg1, arg2) {
    var r1, r2, m;
    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
    m = Math.pow(10, Math.max(r1, r2));
    return accDiv(accMul(arg1, m) + accMul(arg2, m), m);
}

// 减法函数
function accSub(arg1, arg2) {
    return accAdd(arg1, accMul(arg2, -1));
}
////將得到的值四捨五入，去小數點后兩位
////arg1：參數
//function accMath(arg1)
//{
//    return accMath(Math.round(arg1,2));
//}

//function GetGoodsClassParentID(ParentID)
//{
//var isParent;
//   doAjax(
//            "../",
//            "GetGoodsClass",
//            {"class": ParentID},
//            "json",
//            function (json) 
//            {
//                isParent=json.IsParent;
//            }
//       ) 
//}

//读取会员等级小心 供js调用
var memLevel;
function GetCommonDate(callback) {
    doAjax(
            "../",
            "GetCommonData",
            "json",
            function (json) {
                memLevel = json;
                if (typeof (callback) == "function")
                    callback();
            }
    )
}

// 取得某等级的打折比例
function LevelIDToPercent(levelID) {
    var lPercent = 1;
    if (typeof (memLevel) != "undefined") {
        $.each(memLevel, function (index, obj) {
            if (obj.LevelID == levelID) {
                lPercent = parseFloat(obj.Percent);
            }
        });
    }
    return lPercent;
}

//取得当前时间
function GetDataTimeNow() {
    var nowData = "";

    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var day = now.getDate();
    var hour = now.getHours();
    var minute = now.getMinutes();
    var second = now.getSeconds();

    nowdate = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    return nowdate;
}

//计算两个时间相差的天数
function DateDiff(sDate1, sDate2) { //sDate1和sDate2是2002-12-18格式 
    var aDate, oDate1, oDate2, iDays
    aDate = sDate1.split("-")
    oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0] + " 01:00:00") //转换为12-18-2002格式 
    aDate = sDate2.split("-")
    oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0] + " 00:00:00")
    iDays = parseInt(Math.floor(oDate1 - oDate2) / 1000 / 60 / 60 / 24) //把相差的毫秒数转换为天数 
    return iDays
}

function dateValid(StartDate, EndDate) {
    var beginDate = new Date(StartDate.replace(/-/g, "/"));
    var endDate = new Date(EndDate.replace(/-/g, "/"));
    if (beginDate > endDate) {
        return false;
    }
    else {
        return true;
    }
}

//字符串数组转换为整形数组
function strtoint(arrayObj) {
    var Mydata = new Array(arrayObj.length);
    for (var i = 0; i < arrayObj.length; i++) {
        Mydata[i] = parseInt(arrayObj[i]);
    }
    return Mydata;
}

//字符串数组转换为浮点型数组
function strtofloat(arrayObj) {
    var Mydata = new Array(arrayObj.length);
    for (var i = 0; i < arrayObj.length; i++) {
        Mydata[i] = parseFloat(arrayObj[i]);
    }
    return Mydata;
}

//打印小票算出省的金额
function accountPay(totalMoney, totalDiscount) {
    var sbPay = "";
    var payMoney = (parseFloat(totalMoney) - parseFloat(totalDiscount)).toString();
    if (payMoney <= 0 || totalMoney == "") {
        sbPay = "";
    } else {

        var moneys = parseFloat(totalMoney) - parseFloat(totalDiscount);
        sbPay = "节省金额：" + parseFloat(moneys).toFixed(2) + "";
    }
    return sbPay;
}
//打印时不同支付方式的金额
function PayInfos(parameter) {
    var strPayInfo = "";
    //现金付款 算出找零的金额 
    if (parameter[0].IsCash || parameter[0].IsCard || parameter[0].IsBink) {
        if (parameter[0].IsCash) {
            strPayInfo += "现金付款：" + parseFloat(parameter[0].CashMoney).toFixed(2) + "<br/>";
        }
        if (parameter[0].IsCard) {
            strPayInfo += "余额付款：" + parseFloat(parameter[0].CardMoney).toFixed(2) + "<br/>";
        }

        if (parameter[0].IsBink) {
            strPayInfo += "银联付款：" + parseFloat(parameter[0].BinkMoney).toFixed(2) + "<br/>";
        }
        if (parameter[0].CouponMoney != "0") {
            strPayInfo += "优惠券优惠：" + parseFloat(parameter[0].CouponMoney).toFixed(2) + "<br/>";
        }

    }
    var strChange = parameter[0].ChangeMoney;
    strPayInfo += "实付金额：" + parseFloat(accAdd(accSub(parameter[0].DiscountMoney, parameter[0].CouponMoney), strChange)).toFixed(2) + "<br/>" + "找零金额：" + parseFloat(strChange).toFixed(2) + "";
    return strPayInfo;
}


// 取得中文汉字拼音首字母
function getPYCode(str, id) {
    var result = "";
    /**
    doAjax(
            "../",
            "GetPinYin",
            { "strpinyin": str },
            "json",
            function (json) {
                $("#" + id).val(json.result.toString());
            });
            **/
    var result = "";
    for (var i = 0; i < str.length; i++) {
        result += getPY(str.charAt(i).toString())
    }
    $("#" + id).val(result);

}
function getPY(s) {
    if (s != "") {
        execScript("tmp=asc(\"" + s + "\")", "vbscript");
        tmp = 65536 + tmp;
        var py = "";
        if (tmp >= 45217 && tmp <= 45252) {
            py = "A"
        } else if (tmp >= 45253 && tmp <= 45760) {
            py = "B"
        } else if (tmp >= 45761 && tmp <= 46317) {
            py = "C"
        } else if (tmp >= 46318 && tmp <= 46825) {
            py = "D"
        } else if (tmp >= 46826 && tmp <= 47009) {
            py = "E"
        } else if (tmp >= 47010 && tmp <= 47296) {
            py = "F"
        } else if ((tmp >= 47297 && tmp <= 47613) || (tmp == 63193)) {
            py = "G"
        } else if (tmp >= 47614 && tmp <= 48118) {
            py = "H"
        } else if (tmp >= 48119 && tmp <= 49061) {
            py = "J"
        } else if (tmp >= 49062 && tmp <= 49323) {
            py = "K"
        } else if (tmp >= 49324 && tmp <= 49895) {
            py = "L"
        } else if (tmp >= 49896 && tmp <= 50370) {
            py = "M"
        } else if (tmp >= 50371 && tmp <= 50613) {
            py = "N"
        } else if (tmp >= 50614 && tmp <= 50621) {
            py = "O"
        } else if (tmp >= 50622 && tmp <= 50905) {
            py = "P"
        } else if (tmp >= 50906 && tmp <= 51386) {
            py = "Q"
        } else if (tmp >= 51387 && tmp <= 51445) {
            py = "R"
        } else if (tmp >= 51446 && tmp <= 52217) {
            py = "S"
        } else if (tmp >= 52218 && tmp <= 52697) {
            py = "T"
        } else if (tmp >= 52698 && tmp <= 52979) {
            py = "W"
        } else if (tmp >= 52980 && tmp <= 53688) {
            py = "X"
        } else if (tmp >= 53689 && tmp <= 54480) {
            py = "Y"
        } else if (tmp >= 54481 && tmp <= 62289) {
            py = "Z"
        } else {
            py = s.charAt(0)
        }
        return py
    }
}

//获取优惠券详情
function GetCouponDetail() {
    art.dialog({
        title: '电子优惠券详情',
        fixed: true,
        left: '90%',
        top: '70%',
        content: document.getElementById('divCouponDetail'),
        id: 'divCouponDetail'
    });
}
