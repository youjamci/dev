<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>RegisterRedirectAttributeForm</title>
</head>
<body>
	<h3>RegisterRedirectAttributeForm</h3>
	
	<form action="/redirectattribute/register" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>