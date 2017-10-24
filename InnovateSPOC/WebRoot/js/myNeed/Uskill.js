var tag = true;
var obj=[];
var applytable;
$(document).ready(
		function() {
			// 分页表格
				var stuId=location.href;
				var num=stuId.lastIndexOf("?")+1;
				stuId=stuId.substring(num);
				$("#deptSelectOne").val(stuId);
				applytable = $('#major').DataTable(
					{
						"processing" : true,
						"serverSide" : true,
						"bSort" : false,
						"ordering" : true,
						"aLengthMenu" : [ 5, 10, 20, 30 ], // 动态指定分页后每页显示的记录数。
						"lengthChange" : true, // 是否启用改变每页显示多少条数据的控件
						"iDisplayLength" : 10, // 默认每页显示多少条记录
						"bfilter" : true,
						"dom" : 'ftipr<"bottom"l>',
						"ajax" : {
							"url" : "UskillStudent.do",
							"data":{
								"Usid":stuId
							},
							"type" : "POST"
						},
						"aoColumns" : [ {
							"mData" : "id",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "2%",

						}, { // aoColumns设置列时，不可以任意指定列，必须列出所有列。
							"mData" : "sid",
							"orderable" : true, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",
						}, {
							"mData" : "sname",
							"orderable" : true, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "2%",

						}, {
							"mData" : "skill_name",
							"orderable" : true, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",

						},{
							"mData" : "skill_exp",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",

						},{
							"mData" : "kid",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
							"visible":false,
						// "sWidth" : "5%",

						},
						{
							"mData" : "id",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
							"render":function(data,type,row){					
								obj.push(row);							
								return data="<button type='button' class='btn btn-warning btn-xs' value='"+(obj.length-1)
											+ "' id='checkdetale1'>修改</button>";
							}
						}
						],

						"columnDefs" : [ {
							"orderable" : false, // 禁用排序
							"targets" : [ 0 ], // 指定的列
							"data" : "sid",
							"render" : function(data, type, row) {
								return '<input type="checkbox" value="' + data
										+ '" name="idname" class="ck"  />';
							}
						} ],

						"language" : {
							"lengthMenu" : "每页 _MENU_ 条记录",
							"zeroRecords" : "没有找到记录",
							"info" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
							"infoEmpty" : "无记录",
							"infoFiltered" : "(从 _MAX_ 条记录过滤)",
							"sSearch" : "模糊查询：",
							"oPaginate" : {
								"sFirst" : "首页",
								"sPrevious" : " 上一页 ",
								"sNext" : " 下一页 ",
								"sLast" : " 尾页 "
							}
						}
					});
				 //技能列表
				 $.ajax({
		  				type : 'POST',
		  				dataType : 'json',
		  				url : 'get_skill.do',
		  				async : false,
		  				cache : false,
		  				error : function(request) {
		  					bootbox.alert({
		  	     			  message: "请求异常",
		  	     			  size: 'small'
		  	     		  });
		  				},
		  				success : function(data) {
		  					for ( var i=0;i<data[0].length;i++){
								$("#deptSelect1").after(
										"<option value="+data[0][i].kid+">"
												+ data[0][i].skill_name + "</option>");
							}
		  				}
		  			}); 
				 //学生列表
				 $.ajax({
		  				type : 'POST',
		  				dataType : 'json',
		  				url : 'get_sname.do',
		  				async : false,
		  				cache : false,
		  				error : function(request) {
		  					bootbox.alert({
		  	     			  message: "请求异常",
		  	     			  size: 'small'
		  	     		  });
		  				},
		  				success : function(data) {
		  					for ( var i=0;i<data[0].length;i++){
								$("#deptSelect").after(
										"<option value="+data[0][i].sid+">"
												+ data[0][i].sname + "</option>");
							}
		  				}
		  			}); 
		});

//修改操作
$(document).on("click", "#checkdetale1", function() {	
	var index=$(this).val();	
	$("#display1").html("");
	tag1=true;
	$("#id").val(obj[index].id)
	$("#sid").val(obj[index].sid);
	$("#sname").val(obj[index].sname);
	$("#kname").val(obj[index].skill_name);
	$("#exp").val(obj[index].skill_exp);
	$("#edit").modal('show');
	
});

//删除
var flag=0;
$("#delete").click(function(){
	flag = 0;
	$("#major input[name='idname']").each(function () {
		if($(this).prop("checked")==true){
			flag=1;
		}
	});
	if(flag==0){
		bootbox.alert({
			  message: "您还没有选择任何内容",
			  size: 'small'
		  });
	}else{
		bootbox.confirm({
			message: "确定删除？",
			size: 'small',
			buttons: {
				confirm: {
					label: '确定',
					className: 'btn-success'
				},
				cancel: {
					label: '取消',
					className: 'btn-danger'
				},
			},
			callback: function (result) {									
				if(result){									
					var deletstr = "('";//删除记录的格式(1,2,3,4,5)									
					var i=0;
					$("input[type='checkbox'][name='idname']:checked").each(function() {															
											if (i != 0) {
												deletstr = deletstr+ "','"+ $(this).val();
											}
											else{
												deletstr = deletstr+ $(this).val();
												}
											i++;
										});
						deletstr = deletstr + "')";
						$.ajax({
							url : 'delSkillstudent.do',
							type : 'post',
							dataType : 'json',
							data : {
								"deletstr" : deletstr
							},
							success : function(msg) {
								bootbox.alert({
									message : msg.str,
									size : 'small'
								});
								applytable.draw(false);
							}
						});//end

				}
			}
		});

	}
});
//全选
$("#ck1").on("click", function () {
	if ($(this).prop("checked") === true) {
		$("#major input[name='idname']").prop("checked", true);
		
	} else {
		$("#major input[name='idname']").prop("checked", false);
		
	}					
 });
//新增
$("#save").click(function(){
		if(!tag){		
			 bootbox.alert({
					message : "该学生id不存在，请重新输入",
					size : 'small'
				});
			 return;
		}
		if($("#deptSelectOne").val()==""){
				bootbox.alert({
				message : "请填写学生名称",
				size : 'small'
			});	
			return;
		}else if($("#deptSelectOne1").val()==""){
				bootbox.alert({
				message : "请填写技能名",
				size : 'small'
				});	
				return;
		}					
		else if($("#exp1").val()==""){
				bootbox.alert({
				message : "请填写技能值",
				size : 'small'
				});	
				return;
		}
		
		$("#applyaddform").submit();				
});

//修改
$("#saverun").click(function(){
	if($("#exp").val()==""){
		bootbox.alert({
		message : "请填写技能值",
		size : 'small'
		});	
		return;
	}
	bootbox.confirm({
		message: "是否确认修改",
		buttons: {
				confirm: {
						label: 'Yes',
						className: 'btn-success'
						},
				cancel: {
						label: 'No',
						className: 'btn-danger'
						},
					},
				callback: function (result) {
						if(result){
							$("#majoreditform").submit();
							}
						}
					});
});
////点击增加清空数据
//$("#ZJ").click(function(){
//	$("#display1").html("");
//	$("#display2").html("");
//});


