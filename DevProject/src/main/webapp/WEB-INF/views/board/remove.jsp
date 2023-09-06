<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>REMOVE</title>
</head>
<body>
	<h3>REMOVE</h3>
	
	<form action="/board/post" method="post">
		<input type="submit" name="remove" value="Remove">
	</form>
	
	<a href="/board/get?list">List</a>
</body>
</html>