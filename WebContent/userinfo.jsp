<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function info(){
	alert("userinfo");
	var form=document.getElementById("infoForm");
	form.action="UserInfoServlet";
	alert(form.action);
	form.submit();
}
function logout(){
	alert("logout");
	var form=document.getElementById("infoForm");
	form.action="LogOutServlet";
	alert(form.action);
	form.submit();
}
</script>
</head>
<body>
<form id="infoForm" action="" method="post">
<input type="button" value="测试" onclick="info()">
<input type="button" value="注销" onclick="logout()">
${desc}
</form>
</body>
</html>