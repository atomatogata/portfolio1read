<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.SnowBean" %>

<%
List<SnowBean> list = (List<SnowBean>)session.getAttribute("list");
int alterId = Integer.parseInt(request.getParameter("alterId"));
int primaryId = list.get(alterId -1).getId();
session.setAttribute("primaryId", primaryId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>snowAlter</p>
<%= session.getAttribute("primaryId") %>
<form action="/matsuhama/SnowUpdate" method="GET">
<input type="submit" value="削除">
</form>
<form action="/matsuhama/SnowUpdate" method="POST">
名前：
<input type="text" name="name" value="<%= list.get(alterId - 1).getName() %>">
内容：
<input type="text" name="text" value="<%= list.get(alterId - 1).getText() %>">
<input type="submit" value="変更">
</form>





</body>
</html>