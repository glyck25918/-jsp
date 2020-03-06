<%@page import="entity.Material"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>">
	
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bk.css"/>
	</head>
	<style>
		.dh{
	margin-top:25px ;
	width: 100%;
	height: 40px;
	position: absolute;
	z-index: 5;
}
.dh div{
	float: left;
}
.iframe{
	margin-top: 25px;
	width: 100%;
	height: 35px;
	position: absolute;
	border: none;
}
.top-left{
	width: 300px;
	height: 30px;
	margin-left:70% ;
	margin-top:3px ;
}
.top-left a{
	text-decoration: none;
	color: white;
}

.top-right{
	margin-left:8% ;
}
.top-right span{
	width: 50px;
	height: 30px;
	color: white;
	font-size: 30px;
}
.top-left span{
	margin: 10px;
	font-size: 15px;
}
		
	</style>
	<body>
		
		<div class="dh">
				<div class="top-right"><span>LFY</span></div>
				<div class="top-left"><span><a href="Query">主页</a></span><span><c:if test="${userykwadmin eq null }"><a href="addlist.jsp">登录</a></c:if><c:if test="${userykwadmin ne null }"><a href="messageykw?admin=${userykwadmin}">${userykwadmin}</a>&nbsp;&nbsp;&nbsp;<a href="addlist.jsp">切换账户</a></c:if></span></div>
			</div>
		
		<img src="img/qf3cu.jpg" class="bj"/>
		<div class="ys"></div>
		<div id="wai">
			<div id="nei">
				<c:forEach items="${eList}" var="a">
				<div class="dy">
					
					<div class="t1"><img src="img/2.png" ></div>
					<h2 class="nc" ><span>${a.admin}:</span></h2>
					<div class="zd"><p>${a.yu }</p></div>
					<div class="t2">
						<div>
							<img src="img/未标题-1 副本.PNG"/>
						</div>
						<div>
							
							<a href="querys?id=${a.id }" name="id">详情</a>
							
						</div>
						<div class="t3">
							<img src="img/1e494a4118f8d30e37a54f1ada6f35ca 副本.png"/>
						</div>
						<div class="zd1">
							<a>${a.date}</a>
						</div>
					</div>
				</div>
				</c:forEach>
				
			</div>	
		</div>
		
		
	</body>
	
	<script src="js/jquery-3.3.1.js"></script>
	<script>
		$(document).ready(function(){
			$(".dy").animate({"margin-left":"13%"},1000);
		});
	</script>
</html>
