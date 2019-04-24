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
	var form=document.getElementById("commyUpdateForm");
	form.action="InitServlet";
	alert(form.action);
	form.submit();
}

function update(){
	alert("update1");
	//alert(${cardNo});
	//alert(<%=request.getAttribute("cardNo")%>);
	alert(document.getElementById("cardNo").value);
	var cardNo=document.getElementById("cardNo").value;
	var form=document.getElementById("commyUpdateForm");
	form.action="UpdateServlet?flag=inForm&cardNo="+cardNo;
	alert(form.action);
	form.submit();
}
</script>
</head>
<body>
<form id="commyUpdateForm" action="" method="post">
<input type="button" value="返回" onclick="returnn()"></br>
修改身份证号：${cardNo}</br>
<input type="text" id="cardNo" name="cardNo" value="${cardNo}" hidden="true">
党员ID：<input type="text" id="userId" name="userId"></br>
党组织ID：<input type="text" id="orgId" name="orgId"></br>
姓名：<input type="text" id="name" name="name"></br>
身份证号：<input type="text" id="newCardNo" name="newCardNo"></br>
电话：<input type="text" id="phone" name="phone"></br>
地址：<input type="text" id="addr" name="addr"></br>
状态：<input type="text" id="statuss" name="statuss"></br>
性别：<input type="text" id="sexx" name="sexx"></br>
生日：<input type="text" id="birthday" name="birthday"></br>
年龄：<input type="text" id="age" name="age"></br>
备注：<input type="text" id="bakk" name="bakk"></br>
<input type="button" value="修改" onclick="update()"></br>
</form>
${msg}
</body>
</html>