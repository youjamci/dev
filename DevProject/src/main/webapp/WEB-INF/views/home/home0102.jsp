<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home0102</title>
</head>
<body>
	<h3>4. ǥ�����(EL)</h3>
	<p>2) �ڹٺ��� ������Ƽ�� ��ȸ�ϴ� ��� "�Ӽ���.������Ƽ��"�� �����Ѵ�.</p>
	<table border="1"> 
		<tr>
			<td>\${memberMap.userId }</td>
			<td>${memberMap["userId"] }</td>
		</tr>
		<tr>
			<td>\${memberMap.password }</td>
			<td>${memberMap["password"]}</td>
		</tr>
		<tr>
			<td>\${memberMap.email }</td>
			<td>${memberMap["email"]}</td>
		</tr>
		<tr>
			<td>\${memberMap.userName }</td>
			<td>${memberMap["userName"]}</td>
		</tr>
	</table>
</body>
</html>