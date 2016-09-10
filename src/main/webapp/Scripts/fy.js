$(document).ready(function() {

 //setInterval("exe()",60*1000);
	//exe();
	
	
	$("#page").change(function(e){
	
		$("input[name='page']").val($("#page").val());
		
		 $("#page_form").submit();
		
	});
	
	$("#pagesize").change(function(e){
		$("input[name='pageSize']").val($("#pagesize").val());
		 $("#page_form").submit();
	});
	
	
});

function base_search(){
	$("#page_form").submit();
}




function exe(){

	
 
  
  $("div[class='content-pagenation'] li").click(function(e){
  		alert("OK"+e.value);
	});
  
  
  
  
}

function fyck(pageNo,param){

	
	$("input[name='page']").val(pageNo);
		

	 $("#page_form").submit();
	
	/**
	var pathurl=$("input[name='pagepathurl']").val();
	var url=pathurl+"?page="+pageNo+"&"+param;
	location.href=url;
	**/
}

var argflag=1;
function changeTypeCss(arg){
	if(argflag==1){
		$("#jtxw").removeClass("active");
	}else if(argflag==2){
		$("#fgsdt").removeClass("active");
	}else if(argflag==3){
		$("#ygfc").removeClass("active");
	}else if(argflag==4){
		$("#mtbd").removeClass("active");
	}
	
	if(arg==1){
		$("#jtxw").addClass("active");
	}else if(arg==2){
		$("#fgsdt").addClass("active");
	}else if(arg==3){
		$("#ygfc").addClass("active");
	}else if(arg==4){
		$("#mtbd").addClass("active");
	}
	
	argflag=arg;
	
}

function changeType(obj,arg){
	changeTypeCss(arg);
	
	$("input[name='mytype']").val(arg);
	
	pathurl=$("input[name='pagepathurl']").val();
	var url=pathurl+"?page="+1+"&type="+$("input[name='mytype']").val();
	location.href=url;
	
	
}


function getRandom(n){
        return Math.floor(Math.random()*n+1)
 }