<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="service.TblCommyService"%>
<%@page import="dao.TblCommyDao"%>
<%@page import="model.TblCommy"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function returnHome(){
	alert("returnHome");
	var form=document.getElementById("commyForm");
	form.action="HomeServlet";
	alert(form.action);
	form.submit();
}

function quest(){
	alert("quest");
	var form=document.getElementById("commyForm");
	form.action="QuestServlet";
	alert(form.action);
	form.submit();
}

function resett(){
	alert("resett");
	var form=document.getElementById("commyForm");
	form.action="InitServlet";
	alert(form.action);
	form.submit();
}

function add(){
	alert("add");
	var form=document.getElementById("commyForm");
	form.action="CommyAddServlet?flag=newForm";
	alert(form.action);
	form.submit();
}

function update(){
	alert("update");
	alert(event.target.name);
	var form=document.getElementById("commyForm");
	form.action="UpdateServlet?cardNo="+event.target.name+"&flag=newForm";
	alert(form.action);
	form.submit();
}

function deletee(){
	alert("deletee");
	alert(event.target.name);
	var form=document.getElementById("commyForm");
	form.action="DeleteServlet?cardNo="+event.target.name;
	alert(form.action);
	form.submit();
}

</script>
</head>
<body>
<form id="commyForm" action="" method="post">
<input type="button" value="首页" onclick="returnHome()">
<h1>党员管理</h1>
身份证号码：<input type="text" id="cardNo" name="cardNo">
<input type="button" value="查询" onclick="quest()">
<input type="button" value="重置" onclick="resett()">
<input type="button" value="新增" onclick="add()">
<table>
	<%
	ArrayList<TblCommy> commyList=new ArrayList<TblCommy>();
	commyList=(ArrayList<TblCommy>)request.getAttribute("list");
	System.out.println("得到"+commyList.size()+"条结果"); 
	%>
	<tr>
		<th>党员ID</th>
		<th>党组织ID</th>
		<th>姓名</th>
		<th>身份证号</th>
		<th>手机号</th>
		<th>地址</th>
		<th>状态</th>
		<th>性别</th>
		<th>生日</th>
		<th>年龄</th>
		<th>备注</th>
	</tr>
	<%
	for(int i=0;i<commyList.size();i++){
		TblCommy commy=commyList.get(i);
	%>
	<tr>
		<td><%=commy.getUserId()%></td>
		<td><%=commy.getOrgId()%></td>
		<td><%=commy.getName()%></td>
		<td><%=commy.getCardNo()%></td>
		<td><%=commy.getPhone()%></td>
		<td><%=commy.getAddr()%></td>
		<%
		String status="";
		if(commy.getStatuss().equals("10"))
			status="入党积极分子";
		else if(commy.getStatuss().equals("20"))
			status="发展对象";
		else if(commy.getStatuss().equals("30"))
			status="预备党员";
		else if(commy.getStatuss().equals("40"))
			status="正式党员";
		%>
		<td><%=status%></td>
		<%
		String sex="";
		if(commy.getSexx().equals("10"))
			sex="男";
		else if(commy.getSexx().equals("20"))
			sex="女";
		%>
		<td><%=sex%></td>
		<%
		String birthday="";
		birthday=new SimpleDateFormat("yyyy-MM-dd").format(commy.getBirthday());
		%>
		<td><%=birthday%></td>
		<td><%=commy.getAge()%></td>
		<td><%=commy.getBakk()%></td>
		<td><input type="button" value="修改" name="<%=commy.getCardNo()%>" onclick="update()"></td>
		<td><input type="button" value="删除" name="<%=commy.getCardNo()%>" onclick="deletee()"></td>
	</tr>
	<%}%>
</table>
</form>
</body>
</html>