<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/new_file.css" charset="UTF-8"/>
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
		#yanzheng{
			position: absolute;
			width: 20px;
			height: 20px;
			margin-left: 240px;
			margin-top:40px;
		}
		#yanzheng img{
			position: absolute;
			width: 20px;
			opacity: 0;
		}
		</style>
  <body>
    <img src="img/qf3cu.jpg"/ class="beijing-1">
		<div class="se"></div>
		
		<div class="addlist2">
			<div class="form">
					<p><input type="text"  id="id1" placeholder="用户名"></p>
					<p><input type="password"  id="password1" placeholder="密码"></p>
					<p><input type="password"  id="password2" placeholder="确认密码"></p>
					<div id="yanzheng"><img src="img/gou.png" id="gou"><img src="img/ca.png" id="ca"></div>
			</div>
			<div class="tijiao"><span>注册</span></div>
			<div id="addtop">
				<div class="zhuche"><span><a href="addlist.jsp">登录</a></span></div>
				<div class="fanhui"><span><a href="index.jsp">返回</a></span></div>
			</div>	
		</div>
  </body>
  <script type="text/javascript">
		var isok;
		$(function(){
			$("#id1").blur(function(){
				var id = $("#id1").val();
				$.getJSON("zhucheajax",{"id":id},function(a){
					if(a == true){
					$("#ca").css("opacity","1");
					$("#gou").css("opacity","0");
					isok = false;
					}
					else{
					$("#gou").css("opacity","1");
					$("#ca").css("opacity","0");
					isok = true;
					}
				})
			})
			$(".tijiao").click(function(){
				var id = $("#id1").val();
				var password1 = $("#password1").val();
				var password2 = $("#password2").val();
				
				if (isok == false) {
					alert("名称不可用")
					return;
				}
				if(id.length < 1 )
				{
					alert("用户名不能为空")
					return;
				}
				if(password1.length < 1 )
				{
					alert("密码名不能为空")
					return;
				}
				if(password2.length < 1 )
				{
					alert("确认密码不能为空")
					return;
				}
				if(password2 != password1)
				{
					alert("两次输入的密码不一致")
					return;
				}
				
				$.getJSON("zhuche",{"id":id,"password":password1},function(a){
				    if(a == true){
					 	alert("注册成功");
					 	window.location.href = "index.jsp";
					}
					else{
						alert("注册失败");
						window.location.href = "index.jsp";
					}
				})
				
			})
		})
		
	</script>
</html>
