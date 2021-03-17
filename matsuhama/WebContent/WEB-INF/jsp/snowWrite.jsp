<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
snowWrite
<form action="/matsuhama/SnowWriter" method="POST">
名前：
<input type="text" name="name">
内容：
<input type="text" name="text">
<input type="submit" value="投稿する">
</form>
</body>
</html>