/*************************************************************************************************************
商品批量导入页面JS处理
**************************************************************************************************************/

var isok=false;
var isokgoodsnumber=false;
$(document).ready(function () {
	$("#btnGoodsTemplate").bind("click",btnGoodsTemplate);
	function btnGoodsTemplate(){
		location.href=project_name+"util/doloadExcl.do?type=Goods";
	}
	
	$("#btnGoodsNumberTemplate").bind("click",btnGoodsNumberTemplate);
	function btnGoodsNumberTemplate(){
		location.href=project_name+"util/doloadExcl.do?type=GoodsNumber";
	}
	$("#btnGoodsCheck").bind("click",btnGoodsCheck);
	function btnGoodsCheck(){
		
		if($("#fileUploadGoods").val()==""){
			alert("对不起！上传内容不能为空");
		}else{
	    	v_uploadfile();
		}
	}
	
	$("#btnGoodsNumberCheck").bind("click",btnGoodsNumberCheck);
	function btnGoodsNumberCheck(){
		if($("#fileUploadGoodsnumber").val()==""){
			alert("对不起！上传内容不能为空");
		}else{
		 v_uploadnumberfile();
		}
	}
	
	$("#btnGoodsImport").bind("click",btnGoodsImport);
	
	function btnGoodsImport(){
		
		
		if($("#strPath").val()==""){
			alert("对不起，请先验证通过之后再上传");
		}else if(isok==false){
			alert("未验证成功，不能导入商品信息！");
		}
		else{
			import_updatefile();
		}
		
	}
	
	function import_updatefile(){
		doAjax("util/",
		           "importgoodsExcel.do",
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
	
	
	$("#btnGoodsNumberImport").bind("click",btnGoodsNumberImport);
	function btnGoodsNumberImport(){
		if($("#path").val()==""){
			alert("对不起，请先验证通过之后再上传");
		}else if(isokgoodsnumber==false){
			alert("未验证成功，不能导入商品库存！");
		}else{
			doAjax("util/","importgoodsnumberExcel.do",
					{
	               "strPath": $("#path").val()
	               
	           },
	           "json",
	           function (json) {
	        	   alert("上传成功！");
	        	   window.location.href= window.location.href;
	           }
	           );
					
		}
		
	}
});


function v_uploadfile(){
	isok=false;
	$.ajaxFileUpload({
			
	                url:project_name+'util/uploadExcel.do?type=1',
	                fileElementId:'fileUploadGoods',
	                type: 'post',
	                dataType: 'json',
	                success: function(data) {
	                	
	                	
	                	 var heads=data.customfields;
	                	
	                    var html="<tr class=\"th\" style=\"font-weight: bold; height: 20px;\">";
	                    html+="<th cope=\"col\">提示</th>";
	                    html+="<th cope=\"col\">商品编码</th>";
	                    html+="<th cope=\"col\">商品名称</th>";
	                    html+="<th cope=\"col\">商品简码</th>";
	                    html+="<th cope=\"col\">商品分类ID</th>";
	                    html+="<th cope=\"col\">计量单位</th>";
	                    html+="<th cope=\"col\">参考进价</th>";
	                    html+="<th cope=\"col\">零售单价</th>";
	                    html+="<th cope=\"col\">商品积分</th>";
	                    html+="<th cope=\"col\">商品类型</th>";
	                    html+="<th cope=\"col\">最低折扣</th>";
	                    html+="<th cope=\"col\">提成类型</th>";
	                    html+="<th cope=\"col\">提成金额(比例)</th>";
	                    html+="<th cope=\"col\">商品简介</th>";
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
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.goodscode+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.name+"</td>";
	                    		html+="<td align=\"center\" style=\"width: 40px;\">"+item.namecode+"</td>";
	                    		html+="<td align=\"center\" style=\"width: 40px;\">"+item.goodsclassid+"</td>";
	                    		html+="<td align=\"center\" style=\"width: 40px;\">"+item.unit+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.goodsbidprice+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 60px;\">"+item.price+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 60px;\">"+item.point+"</td>";
	                    		html+="<td align=\"right\" style=\"width: 40px;\">"+item.goodstype+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.minpercent+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.commissiontype+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.commissionnumber+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.goodsremark+"</td>";
	                    
	                    		for (var i=0;i<excelFields.length;i++){
	                    			html+="<td align=\"left\" style=\"width: 40px;\">"+excelFields[i].fieldvalue+"</td>";
	                    		}
	                    		html+="</tr>";
	                    		if(item.validate!='success'){
	                    			isok=false;
	                    		}
	                    		
	                    	});
	                    	
	                    }
	                   
	                    $("#strPath").val(data.filepath);
	                    $("#resultgoodsTable").html(html);
	                    
	                },
	                error: function(XMLHttpRequest, textStatus, errorThrown) {
	                    alert("上传失败，请检查网络后重试");
	                }
	            });
	}


function v_uploadnumberfile(){
	isokgoodsnumber=false;
	$.ajaxFileUpload({
			
	                url:project_name+'util/uploadExcel.do?type=2',
	                fileElementId:'fileUploadGoodsnumber',
	                type: 'post',
	                dataType: 'json',
	                success: function(data) {
	                	isokgoodsnumber=true;
	                    var html="<tr class=\"th\" style=\"font-weight: bold; height: 20px;\">";
	                    html+="<th cope=\"col\">提示</th>";
	                    html+="<th cope=\"col\">商品编码</th>";
	                    html+="<th cope=\"col\">商品名称</th>";
	                    html+="<th cope=\"col\">商品库存</th>";
	                    html+="</tr>";
	                    
	                    if(data.success==1){
	                    	isokgoodsnumber=true;
	                    	
	                    	$.each(data.rows,function(index,item){
	                    		var excelFields=(item.excelFields);
	                    		html+="<tr class=\"td\" style=\"color: #333333; background-color: #F7F6F3;\">";
	                    		html+="<td align=\"left\" style=\"color: Red; width: 60px;\">"+item.validate+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.goodscode+"</td>";
	                    		html+="<td align=\"left\" style=\"width: 40px;\">"+item.name+"</td>";
	                    		html+="<td align=\"center\" style=\"width: 40px;\">"+item.goodsnumber+"</td>";
	                    		
	                    
	                    		
	                    		
	                    		
	                    		html+="</tr>";
	                    		if(item.validate!='success'){
	                    			isok=false;
	                    		}
	                    		
	                    	});
	                    	
	                    }

	                    $("#resultgoodsnumberTable").html(html);
	                    $("#path").val(data.filepath);
	                    
	                },
	                error: function(XMLHttpRequest, textStatus, errorThrown) {
	                    alert("上传失败，请检查网络后重试");
	                }
	            });
	}
	
   