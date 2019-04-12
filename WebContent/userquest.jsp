<%@page import="dao.TblUserDao"%>
<%@page import="model.TblUser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<%
TblUserDao userDao=new TblUserDao();
ArrayList<TblUser> userlist = userDao.daoLogin();
%>
<tr>
<td>用户名<td>
<td>密码<td>
<td>ID<td>
<tr>
<%
for(int i=0; i<userlist.size(); i++){
	TblUser user=(TblUser)userlist.get(i);
%>
<tr>
<td><%=user.getUsername()%><td>
<td><%=user.getPassword()%><td>
<td><%=user.getId()%><td>
<tr>
<%}%>
</table>
</body>
</html>