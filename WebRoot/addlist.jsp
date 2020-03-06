<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/new_file.css"/>
		<script src="js/jquery-3.3.1.js"></script>
  </head>
  <style type="text/css">
		body{
			width: 100%;
			height: 100%;
			overflow: hidden;
		}
		.form p{
			margin: 25px;
		}
	</style>
  <body>
    <img src="img/qf3cu.jpg"/ class="beijing-1">
		<div class="se"></div>
		
		<div class="addlist">
			<div class="form">
					<p><input type="text" name="id" id="id" placeholder="用户名"></p>
					<p><input type="password" name="password" id="password" placeholder="密码"></p>
			</div>
			<div class="tijiao"><span>确认登录</span></div>
			<div id="addtop">
				<div class="zhuche"><span><a href="addlist2.jsp">注册</a></span></div>
				<div class="fanhui"><span><a href="index.jsp">返回</a></span></div>
			</div>	
		</div>
  </body>
  <script type="text/javascript">
		$(function(){
			$(".tijiao").click(function(){
				var admin = $("#id").val();
				var password1 = $("#password").val();
				
				if (admin.length < 1) {
					alert("请输入用户名")
					return;
				}
				if (password1.length < 1) {
					alert("请输入密码")
					return;
				}
				
				$.getJSON("dengluykw",{"admin":admin,"password":password1},function(a){
				    if(a == true){
					 	alert("登录成功");
					 	window.location.href = "index.jsp";
					}
					else{
						alert("登录失败，用户名或密码错误");
						window.location.href = "index.jsp";
					}
				})
			})
		})
		
	</script>
</html>
