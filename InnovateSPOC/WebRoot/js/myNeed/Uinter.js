var tag = true;
var obj=[];
var applytable;
$(document).ready(
		function() {
			// 分页表格
				var stuId=location.href;
				var num=stuId.lastIndexOf("?")+1;
				stuId=stuId.substring(num);
				$("#sid1").val(stuId);
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
							"url" : "query_Uinternship.do",
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
							"mData" : "practice_location",
							"orderable" : true, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",

						},{
							"mData" : "begin_time",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",

						},{
							"mData" : "end_time",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",

						},{
							"mData" : "practice_description",
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
							"data" : "id",
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
				//学生列表
				 $.ajax({
		  				type : 'POST',
		  				dataType : 'json',
		  				url : 'get_group.do',
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
										"<option value="+data[0][i].gid+">"
												+ data[0][i].gname + "</option>");
							}
		  					for ( var i=0;i<data[0].length;i++){
								$("#Select").after(
										"<option value="+data[0][i].gid+">"
												+ data[0][i].gname + "</option>");
							}
		  				}
		  			}); 
		});

//修改操作
$(document).on("click", "#checkdetale1", function() {	
	var index=$(this).val();	
	$("#display1").html("");
	tag1=true;
	$("#id").val(obj[index].id);
	$("#sid").val(obj[index].sid);
	$("#sname").val(obj[index].sname);
	$("#address").val(obj[index].practice_location);
	$("#begin").val(obj[index].begin_time);
	$("#end").val(obj[index].end_time);
	$("#description").val(obj[index].practice_description);
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
							url : 'delInternship.do',
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

		if($("#studentId").val()==""){
				bootbox.alert({
				message : "请填写学生姓名",
				size : 'small'
			});	
			return;
		}else if($("#address1").val()==""){
				bootbox.alert({
				message : "请填写地点",
				size : 'small'
				});	
				return;
		}					
		else if($("#begin1").val()==""){
				bootbox.alert({
				message : "请填写开始时间",
				size : 'small'
				});	
				return;
		}
		else if($("#end1").val()==""){
				bootbox.alert({
				message : "请填写结束时间",
				size : 'small'
				});	
				return;
		}else if($("#description1").val()==""){
				bootbox.alert({
				message : "请填写实习内容",
				size : 'small'
				});	
				return;
		}
		$("#applyaddform").submit();				
});

//修改
$("#saverun").click(function(){
	if ($("#begin").val() == "") {
		bootbox.alert({
			message : "请填写开始时间",
			size : 'small'
		});
		return;
	} else if ($("#end").val() == "") {
		bootbox.alert({
			message : "请填写结束时间",
			size : 'small'
		});
		return;
	} else if ($("#description").val() == "") {
		bootbox.alert({
			message : "请填写实习内容",
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

//图片的显示与修改
function previewImage(file)
{
  var MAXWIDTH  = 120; 
  var MAXHEIGHT = 120;
  var div = document.getElementById('preview');
  if (file.files && file.files[0])
  {
      div.innerHTML ='<img id=imghead>';
      var img = document.getElementById('imghead');
      img.onload = function(){
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, 120, 120);
        img.width  =  rect.width;
        img.height =  rect.height;
//         img.style.marginLeft = rect.left+'px';
        img.style.marginTop = rect.top+'px';
      };
      var reader = new FileReader();
      reader.onload = function(evt){img.src = evt.target.result;};
      reader.readAsDataURL(file.files[0]);
  }
  else //兼容IE
  {
    var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
    file.select();
    var src = document.selection.createRange().text;
    div.innerHTML = '<img id=imghead>';
    var img = document.getElementById('imghead');
    img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
    status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
    div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
  }
}

function clacImgZoomParam( maxWidth, maxHeight, width, height ){
    var param = {top:0, left:0, width:width, height:height};
    if( width>maxWidth || height>maxHeight )
    {
        var rateWidth = width / maxWidth;
        var rateHeight = height / maxHeight;
         
        if( rateWidth > rateHeight )
        {
            param.width =  maxWidth;
            param.height = Math.round(height / rateWidth);
        }else
        {
            param.width = Math.round(width / rateHeight);
            param.height = maxHeight;
        }
    }
    param.left = Math.round((maxWidth - param.width) / 2);
    param.top = Math.round((maxHeight - param.height) / 2);
    return param;
}



