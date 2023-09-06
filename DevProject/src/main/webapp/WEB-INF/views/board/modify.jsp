<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>MODIFY</title>
</head>
<body>
	<h1>MODIFY</h1>
	
	<form action="/board/post" method="post">
		<input type="submit" name="modify" value="Modify">
	</form>
	
	<a href="/board/get?list">List</a>
</body>
</html>