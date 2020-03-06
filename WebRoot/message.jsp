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
    
    <title>My JSP 'MyJsp3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/new_file.css"/>
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
  </head>
  <style type="text/css">
			::-webkit-scrollbar{
				display:none;
				}
			a{
				color: white;
			}	
			a:hover{
				color: white;
				text-decoration: none;
			}
			
		</style>
  <body>
   <img src="img/qf3cu.jpg"/ class="beijing-1">
			<div class="se"></div>
			
			<div id="outer">
				<div id="head">
					<div><img src="img/1.png"/></div>
					<p>『<span>${userykwadmin}</span>』</p>
				</div>
				<div class="stodop">
					<div class="stodop_top">
						<div class="chakan stodop_top_color" id="chakan"><span>已发心语</span></div>
						<div class="fabu" id="fabu"><span>发送心语</span></div>
						<div class="caozuo" id="caozuo"><span>操作心语</span></div>
					</div>
					<div id="xiangshi">
					<c:forEach items="${list }" var="a">
						<div class="qiehuan">
							<p>${a.yu }</p>
							<span>-「${a.source }」</span>
							<a>${a.date }</a>
						</div>
					</c:forEach>
						<!--<div class="addxinyu">
							<span id="a">心语：</span><textarea name="yu" id="yu" cols="30" rows="1" ></textarea>
							<p>作者：<input type="text" id="laiyuan"/></p>
							<div class="addxinyutijiao"><span>提交</span></div>-->
						<!--<div class="xiugai">
							<table class="table" >
								<tr>
									<th>心语</th>
									<th>作者</th>
									<th>操作</th>
								</tr>
								<tr>
									<td>犹豫就会败北，果断就会白给</td>
									<td>lfy</td>
									<td><a>修改</a></td>
								</tr>
								<tr>
									<td>犹豫就会败北</td>
									<td>lfy</td>
									<td><a>修改</a></td>
								</tr>
							</table>
						</div>-->
					</div>
				</div>
					<div class="ann" >
						<span>©2019~2019&nbsp;&nbsp;&nbsp;蜀ICP备00000000号</span>
					</div>
					<div class="di"></div>
				</div>
				
			<div class="dh">
				<div class="top-right"><span>LFY</span></div>
				<div class="top-left"><span><a href="Query">主页</a></span><span><c:if test="${userykwadmin eq null }"><a href="addlist.jsp">登录</a></c:if><c:if test="${userykwadmin ne null }"><a href="messageykw?admin=${userykwadmin}">${userykwadmin}</a>&nbsp;&nbsp;&nbsp;<a href="addlist.jsp">切换账户</a></c:if></span></div>
			</div>
  </body>
  <script type="text/javascript">
		
				$("#fabu").click(function(){
				$("#xiangshi").children().remove();
				$("#fabu").addClass("stodop_top_color");
				$("#chakan").removeClass("stodop_top_color");
				$("#caozuo").removeClass("stodop_top_color");
				
				var a ="<div class=\"addxinyu\"><span id=\"a\">心语：</span><textarea name=\"yu\" id=\"yu\" cols=\"30\" rows=\"1\" ></textarea><p>作者：<input type=\"text\" id=\"laiyuan\"/></p><div class=\"addxinyutijiao\" onclick='tijiao()'><span >提交</span></div></div>"
				$("#xiangshi").append(a);
			})
			
			$("#chakan").click(function(){
				$("#xiangshi").children().remove();
				$("#chakan").addClass("stodop_top_color");
				$("#fabu").removeClass("stodop_top_color");
				$("#caozuo").removeClass("stodop_top_color");
				
				
				$.getJSON("messageajax",{"admin":"${userykwadmin}"},function(a){
					var $d = $("#xiangshi");
					for (var i = 0;i<a.length;i++) {
						var $div = $("<div class=\"qiehuan\"></div>");
						var $p = $("<p></p>").text(a[i].yu);
						var $span = $("<span></span>").text("-「"+a[i].source+"」");;
						var $a = $("<a></a>").text(a[i].date);
						
						$div.append($p);
						$div.append($span);
						$div.append($a);
						
						$d.append($div);
					}
					
				})
			})
			$("#caozuo").click(function(){
				$("#xiangshi").children().remove();
				$("#caozuo").addClass("stodop_top_color");
				$("#fabu").removeClass("stodop_top_color");
				$("#chakan").removeClass("stodop_top_color");
				
				var a = "<div class=\"xiugai\"><table class=\"table\"><tr><th>心语</th><th>作者</th><th>时间</th><th>操作</th></tr></table></div>"
				$("#xiangshi").append(a);
				
				$.getJSON("messageajax",{"admin":"${userykwadmin}"},function(a){
					var $tab = $(".xiugai>table")
					for (var i = 0;i<a.length;i++) {
						var $tr = $("<tr></tr>");
						var $yu = $("<td></td>").text(a[i].yu);
						var $zz = $("<td></td>").text(a[i].source);
						var $sj = $("<td></td>").text(a[i].date);
						var $sc = $("<td></td>").html("<a onclick=\"sc1("+a[i].id+")\">删除</a>");
						
						$tr.append($yu);
						$tr.append($zz);
						$tr.append($sj);
						$tr.append($sc);
						
						$tab.append($tr);
						
					}
				})
				
				
			})
		
		function tijiao(){
			var yu = $("#yu").val();
			var name = $("#laiyuan").val();
			if (yu.length<1 || name.length<1){
				alert("都不能为空");
				return;
			}
			$.getJSON("tianjia",{"yu":yu,"name":name,"admin":"${userykwadmin}"},function(a){
				    if(a == true){
					 	alert("添加成功");
					 	window.location.reload();
					}
					else{
						alert("添加失败");
						window.location.reload();
					}
				})
		}
		function sc1(id){
			var isok = confirm("你确认要删除吗？");
			if(isok == true){
				$.getJSON("deleteykw",{"id":id},function(a){
				    if(a == true){
					 	alert("删除成功");
					 	window.location.reload();
					}
					else{
						alert("删除失败");
						window.location.reload();
					}
				})
			}
		}
		$(function(){
			$.getJSON("fen",{"id":"${userykwadmin}"},function(a){
					
					if(a[0].img != null){
							$("#head div img").remove();
							var c = "<img src=upload/"+ a[0].img+">"
							$("#head div").append(c);
							}
					
			})
			
			$("#head div").click(function(){
			window.location.href = "qadd?id=${userykwadmin}";
		})
		})
		
	</script>
</html>
