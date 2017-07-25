// JavaScript Document
var obj = [];
var tag1=true;
var XN=0;
$(document).ready(function() { 	
var page = $('#employmentManage').DataTable(
									{
										
										"processing" : true,
										"serverSide" : true,
										"bSort" : false,
										"aLengthMenu" : [ 5, 10, 20, 30 ], // 动态指定分页后每页显示的记录数。
										"lengthChange" : true, // 是否启用改变每页显示多少条数据的控件
										"iDisplayLength" : 10, // 默认每页显示多少条记录
										"ordering":true,
										"filter" : true,
										"dom" : 'ftipr<"bottom"l>',
										"ajax" : {
											"url" : "sendEmployinfo.do",
											"type" : "POST"
										},
										"aoColumns" : [
												{ // aoColumns设置列时，不可以任意指定列，必须列出所有列。
													
													"mData" : "id",
													"orderable" : false, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "4%"
												},
												{ // aoColumns设置列时，不可以任意指定列，必须列出所有列。
													
													"mData" : "sid",
													"orderable" : false, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "10%"
												},
												{
													"mData" : "company",
													"orderable" : true, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "10%",

												},
												{ // aoColumns设置列时，不可以任意指定列，必须列出所有列。
													"mData" : "salary",
													"orderable" : false, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "10%"
												},
												{ // aoColumns设置列时，不可以任意指定列，必须列出所有列。
													"mData" : "workin",
													"orderable" : false, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "8%"
												},
												{
													"mData" : "graduation_year",
													"orderable" : false, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "10%",

												},
												{
													"mData" : "excellence",
													"orderable" : false, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "6%"
												} ,
												{
													"mData" : "id",
													"orderable" : false, // 禁用排序
													"sDefaultContent" : "",
													"sWidth" : "8%",
													"render" : function(data,type, row) {
														obj.push(row);														
														return data = '<span id="updateDetail" class="icon-edit edit-color" value="'
																+ (obj.length - 1)
																+ '"></span>';

													}
												} ],

										"columnDefs" : [ {
											"orderable" : false, // 禁用排序
											"targets" : [ 0 ], // 指定的列
											"data" : "id",
											"render" : function(data, type, row) {	
												
												return '<label><input type="checkbox" name="recordcheck" value="'
														+ data
														+ '" class="ck" id="checkHa"></label>';
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

							//增加框的js控制
							$(document).on("click", "#submit0", function() {
								alert("aaaaaaa");	
								/*var tag=1;
								var sid = $("#sid").val;
								var company = $("#company").val;
								var salary = $("#salary").val;
								var workin = $("#workin").val;
								var graduation_year = $("#graduation_year").val;
								var excellence = $("#excellence").find("option:selected").text();
								if(!tag){		
									 bootbox.alert({
											message : "该学生编号已存在，请重新输入",
											size : 'small'
										});
									 return;
								}	
								if(company==""){
									 bootbox.alert({
											message : "请填写所在公司",
											size : 'small'
										});
									 return;
								}
								if(salary==""){
									 bootbox.alert({
											message : "请填写年薪",
											size : 'small'
										});
									 return;
								}
								if(workin==""){
									 bootbox.alert({
											message : "请填写从事工作",
											size : 'small'
										});
									 return;
								}
								if(graduation_year==""){
									 bootbox.alert({
											message : "请填写毕业年份",
											size : 'small'
										});
									 return;
								}
								if(excellence==""){
									 bootbox.alert({
											message : "请填写是否优秀",
											size : 'small'
										});
									 return;
								}*/
								
								$("#myForm").submit();
							});



});