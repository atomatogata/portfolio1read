<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.SnowBean" %>

<%
List<SnowBean> list = (List<SnowBean>)session.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
snow
<a href="/matsuhama/WelcomServlet">書き込む</a><br>
<form action="/matsuhama/SnowUpdateControll" method="POST">
<input type="submit" value="削除/変更する">
<% for(int i = 0;i < list.size();i++) { %>
<table>
<tr>
<th>
<input type="radio" name="alterId" value="<%= i + 1 %>">
<%= i + 1 %></th>
<td><%= list.get(i).getName() %></td>
<td><%= list.get(i).getText() %></td>
<td><%= list.get(i).getCreated() %></td>
</tr>
</table>
<% } %>
</form>
</body>
</html>