<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function commyM(){
	alert("commyM");
	var form=document.getElementById("indexForm");
	form.action="InitServlet";
	alert(form.action);
	form.submit();
}
</script>
</head>
<body>
<form id="indexForm" action="" method="post">
<h1>这是主页</h1>
<input type="button" value="党员管理" onclick="commyM()">
<input type="button" value="用户管理" onclick="userM()">
</form>
</body>
</html>