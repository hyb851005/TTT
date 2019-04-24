<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function returnn(){
	alert("returnn");
	var form=document.getElementById("commyAddForm");
	form.action="InitServlet";
	alert(form.action);
	form.submit();
}

function add(){
	alert("add");
	var form=document.getElementById("commyAddForm");
	form.action="CommyAddServlet?flag=inForm";
	alert(form.action);
	form.submit();
}
</script>
</head>
<body>
<form id="commyAddForm" action="" method="post">
<input type="button" value="返回" onclick="returnn()"></br>
ID：<input type="text" id="id" name="id"></br>
创建者：<input type="text" id="createUser" name="createUser"></br>
党员ID：<input type="text" id="userId" name="userId"></br>
党组织ID：<input type="text" id="orgId" name="orgId"></br>
姓名：<input type="text" id="name" name="name"></br>
身份证号：<input type="text" id="cardNo" name="cardNo"></br>
电话：<input type="text" id="phone" name="phone"></br>
地址：<input type="text" id="addr" name="addr"></br>
状态：<input type="text" id="statuss" name="statuss"></br>
性别：<input type="text" id="sexx" name="sexx"></br>
生日：<input type="text" id="birthday" name="birthday"></br>
年龄：<input type="text" id="age" name="age"></br>
备注：<input type="text" id="bakk" name="bakk"></br>
<input type="button" value="新增" onclick="add()"></br>
</form>
${msg}
</body>
</html>