<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
	<link rel="stylesheet" type="text/css" href="css/new_file.css" />
	<script src="js/jquery-3.3.1.js"></script>
  </head>
  <style type="text/css">
			span{
				opacity: 0;
			}
			body{
				overflow: hidden;
			}
			#gequ{
				position: absolute;
				z-index: 5;
				width: 30px;
				height: 30px;
				left:95% ;
				top: 20px;
			}
			#gequ img {
				width: 100%;
				height: 100%;
			}

		</style>
  <body>
  	
  	<audio src="img/纯音乐 - Canon In D Major (钢琴).mp3">浏览器不正常</audio>
			<div id="gequ"><img src="img/开始.png"/></div>

  	
   <img src="img/qf3cu.jpg"/ class="beijing-1">
			<div class="se"></div>
			
			<div class="dh">
				<div class="top-right"><span>LFY</span></div>
				<div class="top-left"><span><a href="Query">主页</a></span><span><c:if test="${userykwadmin eq null }"><a href="addlist.jsp">登录</a></c:if><c:if test="${userykwadmin ne null }"><a href="messageykw?admin=${userykwadmin}">${userykwadmin}</a>&nbsp;&nbsp;&nbsp;<a href="addlist.jsp">切换账户</a></c:if></span></div>
			</div>
			
			<div class="statement ">
				<div class="statement-r"><span>『</span></div>
				<div class="statement-z"><span>海内存知己，天涯若比邻</span></div>
				<div class="statement-l"><span>』</span></div>
				<div class="statement-t"><span>-「网络」</span></div>
			</div>
			<div class="ban"><span>©2019~2019&nbsp;&nbsp;&nbsp;蜀ICP备00000000号</span></div>
  </body>
  <script>
  	var o =0;
		$(function(){
			$("span").animate({"opacity":"1"},500);
			setInterval("scdd()",9500)
			setInterval("doudong()",10000)
			$("#gequ").click(function(){
				if (o==0) {
					$("audio")[0].play();
					$("#gequ img").remove();
					$("#gequ").append("<img src='img/停止.png'/>");
					o++;
				}
				else if(o==1) {
					$("audio")[0].pause();
					$("#gequ img").remove();
					$("#gequ").append("<img src='img/开始.png'/>");
					o = 0;
				}
			})

		})
		
		function doudong(){
			$.getJSON("indexykw",{},function(s){
				var le = s.length;
				var m = Math.floor(Math.random()*le); 
			$(".statement-z").children().remove();
			$(".statement-t").children().remove();
			var a = "<span style='opacity: 1;'>"+s[m].yu+"</span>";
			var b = "<span style='opacity: 1;'> -「"+s[m].source+"」</span>";
			$(".statement-z").append(a);
			$(".statement-t").append(b);
			$(".statement").addClass("doudon");
			})
		}
		function scdd(){
			$(".statement").removeClass("doudon");
		}
	</script>
</html>
