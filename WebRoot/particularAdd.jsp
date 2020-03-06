<%@page import="entity.Add"%>
<%@page import="entity.Jmj"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
Object object=request.getAttribute("list");
List<Jmj> list=null;
if(object==null){
	response.sendRedirect("add");
	return;
}
else{
	list=(List<Jmj>)object;
}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>评论</title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="js/bootstrap.min.js"></script>
		<link href="css/particularAdd.css" rel="stylesheet">
	</head>
	<style>
.dh{
	margin-top:0px ;
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
<div id="main">
<form action="addp" method="post">
	<div id="reju">
	<img class="reju1" src="img/96cf6924b913890fbcd6affda239ab10.png">
		<p class="re">热句:</p>
		<ul class="re1">
			<li>——"只要坚持，就是成功"</li>
			<li>——"只要坚持，就是成功"</li>
			<li>——"只要坚持，就是成功"</li>
			<li>——"只要坚持，就是成功"</li>
		</ul>
	</div>
		<div id="head">
		
		<div id="head_top">
		<%
			for(Jmj jmj:list){
		%>
		<ul class="name" >
			<li><%=jmj.getAdmin() %></li>
			<li><img src="img/xrz1.png"></li>
		</ul>
		<p class="neir"><%=jmj.getYu() %></p>
		<%
			}
		%>
		</div>
		<div id="head_center">
			<ul class="pinl">
			<li><a href="#">♡<span>比心</span></a></li>
			<li><a href="#">☆<span>收藏</span></a></li>
			<li><a href="#">⊕<span>评论</span></a></li>
			</ul>
			
		<div class="head_center_1">
			<div class="head_center_2">
				<ul class="pinglun">
					<li>&nbsp;&nbsp;&nbsp;</li>
				</ul>
				<input type="hidden"  name="admin" value="${userykwadmin}">
				<input type="text" class="text1" name="comment" id="comment">
				<input type="submit" value="评论" class="ti">
			<hr/>
			
			<c:forEach items="${aList}" var="c">
				<ul class="pinglun">
					<li>${c.admin}</li>
					<li><img src="img/xrz1.png"></li>
				</ul>
				<p class="pinglun_1">${c.comment}</p>
				<ul class="pinglun_2">
					<li>♡<span>比心</span></li>
					<li>⊕<span>评论</span></li>
				</ul>
			<hr/>
			</c:forEach>
			
			</div>
		</div>
		</div>
		<br/>
		</div>
		</form>
		
		
	</div>
	
	</body>
</html>
<script src="js/jquery-3.3.1.js"></script>
<script>
var isok="${userykwadmin}";
	$(function(){
	    $("form").submit(function(){
	    	var comment = $("#comment").val();
	    	if(comment.length < 1 ){
	    			alert("文本不能为空！");
	    			
	    			return false;
	    	}
	    	
		if(isok==""){
			alert("登录后才能评论哦！");
			location.href = "addlist.jsp";
			return false;
		}
		else{
			return true;
		}
	    })
	    
	})
</script>