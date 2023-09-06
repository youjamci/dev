<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home0102</title>
</head>
<body>
	<h3>4. 표현언어(EL)</h3>
	<p>산술 연산자를 이용</p>
	<table border="1"> 
		<tr>
			<td>\${coin }</td>
			<td>${coin }</td>
		</tr>
		<tr>
			<td>\${coin + 100}</td>
			<td>${coin + 100 }</td>
		</tr>
		<tr>
			<td>\${coin - 100}</td>
			<td>${coin - 100 }</td>
		</tr>
		<tr>
			<td>\${coin * 100}</td>
			<td>${coin * 100 }</td>
		</tr>
		<tr>
			<td>\${coin / 100}</td>
			<td>${coin / 100 }</td>
		</tr>
		<tr>
			<td>\${coin / 100}</td>
			<td>${coin div 100 }</td>
		</tr>
		<tr>
			<td>\${coin % 100}</td>
			<td>${coin % 100 }</td>
		</tr>
		<tr>
			<td>\${coin % 100}</td>
			<td>${coin mod 100 }</td>
		</tr>

	</table>
</body>
</html>