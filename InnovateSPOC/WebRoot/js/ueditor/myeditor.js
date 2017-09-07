$(document).ready(function() {
	/*$('#msglx_list').val('1');
	$("#msglx_list").change(function() {
		if ($(this).val() == '1'){
			$("#part").hidden();
			$("#sendMessage").hidden();
		}else{
			$("#part").show();
			$("#sendMessage").show();
		}
		$("#part").toggle(100);
		$("#sendMessage").toggle(100);
		$('#sendNotifitation').toggle(100);
		$('#titleform').toggle(100);
		//$('#titletext').toggle(100);

	});*/


	

	$(document).on("click", "#sendNotifitation", function() {
		
		$("#majoreditform").submit();
//		var message = $("#Newcontent").val();
//		alert(message);
//		var title = '';
//		title =  $("#title").val();
//		alert(title);
//		var photo = $("#file").val();
//		alert(photo);
//
//		$.ajax({
//			type : 'POST',
//			dataType : 'text',
//			url : 'saveNotification.do',// ��̨�޸�
//			data : {
//				data : message,
//				title: title
//			},
//			async : false,
//			cache : false,
//			error : function() {
//				bootbox.alert({
//					message : "发布失败!",
//					size : 'small'
//				});
//			},
//			success : function() {
//				bootbox.alert({
//					message : "发布成功!",
//					size : 'small'
//				});
//			}
//		});
	  });



});
