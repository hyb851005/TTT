<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function login(){
	alert("login");
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var form=document.getElementById("loginForm");
	form.action="LoginServlet?username="+username+"&password="+password;
	alert(form.action);
	form.submit();
}

function add(){
	alert("add");
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var uid=document.getElementById("uid").value;
	var form=document.getElementById("loginForm");
	form.action="AddServlet?username="+username+"&password="+password+"&uid="+uid;
	alert(form.action);
	form.submit();
}
</script>
</head>
<body>
<form id="loginForm" action="" method="post">
用户名：<input type="text" name="username" id="username">
密码：<input type="password" name="password" id="password">
id：<input type="text" name="uid" id="uid">
<input type="button" value="确认" onclick="login()">
<input type="button" value="新增" onclick="add()">
</form>
</body>
</html>