var tag = true;
var obj=[];
var applytable;
$(document).ready(
		function() {
			// 分页表格
				applytable = $('#groupManage').DataTable(
					{
						"processing" : true,
						"serverSide" : true,
						"bSort" : false,
						"ordering" : true,
						"aLengthMenu" : [ 5, 10, 20, 30 ], // 动态指定分页后每页显示的记录数。
						"lengthChange" : true, // 是否启用改变每页显示多少条数据的控件
						"iDisplayLength" : 5, // 默认每页显示多少条记录
						"bfilter" : true,
						"dom" : 'ftipr<"bottom"l>',
						"ajax" : {
							"url" : "query_group.do",
							"type" : "POST"
						},
						"aoColumns" : [ {
							"mData" : "id",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "2%",

						}, { // aoColumns设置列时，不可以任意指定列，必须列出所有列。
							"mData" : "gid",
							"orderable" : true, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",
						}, {
							"mData" : "gname",
							"orderable" : true, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "2%",

						}, {
							"mData" : "uid",
							"orderable" : true, // 禁用排序
							"sDefaultContent" : "",
						// "sWidth" : "5%",

						},{
							"mData" : "uname",
							"orderable" : false, // 禁用排序
							"sDefaultContent" : "",
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
				
				 
		});

//修改操作
$(document).on("click", "#checkdetale1", function() {	
	var index=$(this).val();	
	$("#display1").html("");
	tag1=true;
	$("#gid").val(obj[index].gid);
	$("#gname").val(obj[index].gname);
	$("#uid").val(obj[index].uid);
	$("#uname").val(obj[index].uname);
	$("#edit").modal('show');
	
});

//修改
$("#saverun").click(function(){
	bootbox.confirm({
		message: "是否确认修改",
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
							$("#majoreditform").submit();
							}
						}
					});
});


