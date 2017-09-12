$("#types").click(function(){
	$("#type").toggle(200);
});
		/*var ContStr="";
		for(var i=0;i<7;i++){
			ContStr=ContStr+'<div class="content" style="background: url(../images/group_program/bg.png) no-repeat;"><div class="intro"><h1>软件工程师</h1><p>主导人：李彩</p><p>参与人：潘葛&nbsp;赵勇</p><p>类型：软件工程师</p></div></div>';
		}
		$("#contents").append(ContStr);
	
*/
		
		//获取组员作品的请求
		$.ajax({
			async : false,
	    	type : 'POST',
				dataType : 'json',
				url : 'getAllWorkInfo.do',
				error : function(request) {
	 				bootbox.alert({
	         			  message: "请求异常",
	         			  size: 'small'
	         		  });
	 			},
				success : function(data) {
					//alert(data[0].length);
					var ContStr="";
					for(var i=0;i<data[0].length;i++){
						ContStr=ContStr+'<div class="content" style="background: url('+data[0][i].photo_address+') no-repeat;"><div class="intro"><h1>'+data[0][i].project_name+'</h1><p>主导人：'+data[0][i].sid+'</p><p>参与人：'+data[0][i].participants+'</p><p>类型：'+data[0][i].work_name+'</p></div></div>';
					}
					$("#contents").append(ContStr);
				}
	    
	    });		
		
		
		
		$(document).on("click",".content",function(){
			$("#Login").modal('show');
		});
		