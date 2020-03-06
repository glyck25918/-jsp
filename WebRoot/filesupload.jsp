<%@page import="entity.Material"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Object gObject = request.getSession().getAttribute("userykwadmin");
	if(gObject == null){
		response.sendRedirect("addlist.jsp");
	}
 %>>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'filesupload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	*{
	margin: 0px;
	padding: 0px;
}
::-webkit-scrollbar{
	display:none;
}
.bj{
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0px;
	left: 0px;
}
#main{
	width: 100%;
	position: absolute;
}
#li{
	width: 1800px;
	height: 100%;
	margin: auto;
	margin-top: 100px;
	
}
form h1{
	color: white;
	margin-left: -100px;
}
form{
	margin: auto 0px;
	margin-left: 600px;
}
</style>

  </head>
  
  <body>
  	<img src="img/qf3cu.jpg" class="bj"/>
    <div id="main">
    	<div id="li">
    		<div id="tp">
    			<form action="wenjian" method="post" enctype="multipart/form-data">
    				
    				<div>
    					<h1>名称：</h1>
    					<input type="text" name="admin" id="admin" disabled  value="${mList[0].admin}" style="height: 30px;width:300px;margin-top: -30px;"/>
    				</div><br/>
    				<div>
    					<h1>性别：</h1><input type="radio" name="gender" id="gender" value="1" <c:if test="${mList[0].gender eq 1}"> checked="checked"</c:if>  style="height: 30px;width:30px;margin-top: -20px;"/>男
    												<input type="radio" name="gender" id="gender" value="2" <c:if test="${mList[0].gender eq 2}"> checked="checked"</c:if>style="height: 30px;width:50px;margin-top: -30px;"/>女
    				</div><br/>
    				<div>
    					<h1>日期：</h1><input type="text" name="birthday" id="birthday" value="${mList[0].birthday}"  style="height: 30px; width: 300px; margin-top: -30px;"/>
    				</div>
    				
    				<div>
    					<h1>地址</h1><input type="text" name="location" id="location" value="${mList[0].location}" style="height: 30px; width: 300px; margin-top: -30px;"/>
    				</div>
    				<div>
    					<h1>email：</h1><input type="text" name="email" id="email" value="${mList[0].email}" style="height: 30px; width: 300px; margin-top: -30px;"/>
    				</div><br/>
    				<input type="submit" value="保存" style="margin-left:100px;"/>
    				
    				<div>
    				<input type="file" value="上传文件" name="img" id="title"/>
    				<img src="upload/${mList[0].img}" id="pro" style="width: 100px;height: 120px; border: 1px solid black;"/>
    				</div>
    				
    				<input type="hidden" name="wa" id="wa" value="${userykwadmin}"/>
    				
    			</form>
    		</div>
    	</div>
    </div>
  </body>
  	<script src="js/jquery-3.3.1.js"></script>
  	<script>
  	document.getElementById("title").onchange = function(e){
  		
  	
  		var file = document.getElementById("title").files[0];
  		var fileName = document.getElementById("title").value;
  		var index = fileName.lastIndexOf('.');
  		var fileLastName = fileName.substr(index+1);
  		
  		var filesArray = ['jpg','png','jpeg','PNG'];
  		
  		var findResult = $.inArray(fileLastName,filesArray);
  		if(findResult == -1){
  			alert("只接受：jsp、jpeg、png ");
  		}
  		else{
  			
  		var reader = new FileReader();
  		
  		reader.onload = function(){
  		
  				$("#pro").attr("src",this.result); 
  		}
  		reader.readAsDataURL(file);
  		}
  		}
  		
  		$(function(){
  			
  		
  		$("form").submit(function(){
  			//提取需要判断数据
  			var admin = $("#admin").val();
  			var gender = $("#gender").val();
  			var birthday = $("#birthday").val();
  			var img = $("#img").val();
  			var location = $("#location").val();
  			var email = $("#email").val();
  			var title = $("#title").val();
  			
  			//非空判断
  			if(admin.length < 1){
  				alert("昵称，不能为空！")
  				return false;
  			}
  			if(birthday.length < 1){
  				alert("日期，不能为空！")
  				return false;
  			}
  			if(location == -1){
  				alert("地址，不能为空！")
  				return false;
  			}
  			if(email.length < 1){
  				alert("email，不能为空！")
  				return false;
  			}
  			var reg=/^\d{4}-\d{2}-\d{2}$/;
  			if(reg.test(birthday) == false){
  				alert("日期格式不正确！")
  				return false;
  			}
  			if(title.length < 1){
  				alert("请选择图片");
  				return false;
  			}
  			
  			return true;
  		})
  		})
  		
  	</script>
</html>