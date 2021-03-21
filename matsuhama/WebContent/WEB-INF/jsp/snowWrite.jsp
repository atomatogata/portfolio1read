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
種類：
<select name="type">
<option value="1">なんとかしたいと思っている </option>
<option value="2">危険な場所なので注意して！</option>
<option value="3">急がないけれど、助けて欲しい！ </option>
<option value="4">ボランティアを募集しています！ </option>
<option value="5">重大！すぐに助けて！</option>
<option value="6"> その他  </option>
</select>
名前：
<input type="text" name="name">
内容：
<input type="text" name="text">
<input type="submit" value="投稿する">
</form>
</body>
</html>