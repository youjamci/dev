<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>REGISTER</title>
</head>
<body>
	<h1>REGISTER</h1>
	
	<form action="/board/post" method="post">
		<input type="submit" name="register" value="Register">
	</form>
	
	<a href="/board/get?list">List</a>
</body>
</html>