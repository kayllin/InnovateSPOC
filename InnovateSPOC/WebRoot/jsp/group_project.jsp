<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
		<meta name="renderer" content="webkit">
        <meta http-equiv="x-ua-compatible" content="IE=edge, chrome=1"/>
        <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>思博客创新实验室作品</title>
		<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
		<link href="../css/group_program.css" type="text/css" rel="stylesheet" />
		<link href="../css/common.css" type="text/css" rel="stylesheet"/>
    
  </head>
  
  <body>
		<div class="header">

			<div class="Indextitle" id="J_m_nav">
					<div class="cc_c">
					  <div class="logo">
						<div class="logo_bg">						  
							<img src="../images/index/logo.png" width="200px">						
						</div>
					  </div>
					  <div class="menu">
						<ul>
						<li>
						  <a href="index.html">
							<span class="name_ch">首页</span>
						  </a>
						</li>
                         <li>
							<a href="#">
							  <span class="name_ch">程序组</span>
							</a>
						  </li>
                         <li>
							<a href="#">
							  <span class="name_ch">UI组</span>
							</a>
						  </li>
						<li>
							<a href="#">
							  <span class="name_ch">3D组</span>
							</a>
						  </li>							
							 <li>
							<a href="#">
						  	  <span class="name_ch">CG特效组</span>
							</a>
						  </li>
							 <li>
							<a href="#">
						  	  <span class="name_ch">企业招聘</span>
							</a>
						  </li>
						  <li>
							<a  class="nav_stop" href="#">
						  <span class="name_ch">团队作品</span>
							</a>
						  </li>
						  <li data-toggle="modal" data-target="#Login">
							<a href="#">
						  <span class="name_ch">登录</span>
							</a>
						  </li>						 
						</ul>
					  </div>
					  <div class="clear"></div>
					</div>
				</div>
		</div>
	
		<div class="wrap">
			<div id="head">
				<div id="types"><span class="c">类型</span></div>
				<div id="type"></div>
				<div id="search_author">作者<input id="searh"/> </div>
			</div>
			<div id="contents">
				
			</div>
		</div>
	</body>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/group_program.js"></script>
</html>
