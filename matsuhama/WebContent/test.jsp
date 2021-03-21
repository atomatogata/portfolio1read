<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
<select name="type">
<%
String name1 = "";
String name2 = "";
String name3 = "";
String name4 = "";
String name5 = "";
String name6 = "";
switch(6){
case 1:
	name1 = "selected";
	break;
case 2:
	name2 = "selected";
	break;
case 3:
	name3 = "selected";
	break;
case 4:
	name4 = "selected";
	break;
case 5:
	name5 = "selected";
	break;
case 6:
	name6 = "selected";
	break;
}


%>
<option value="1"<%= name1 %>>なんとかしたいと思っている </option>
<option value="2"<%= name2 %>>危険な場所なので注意して！</option>
<option value="3"<%= name3 %>>急がないけれど、助けて欲しい！ </option>
<option value="4"<%= name4 %>>ボランティアを募集しています！ </option>
<option value="5"<%= name5 %>>重大！すぐに助けて！</option>
<option value="6"<%= name6 %>>その他</option>
</form>
</body>
</html>