<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home0401</title>
</head>
<body>
	<h3>4. ǥ�����(EL)</h3>
	<p>�� �����ڸ� �̿�(���� ��)</p>
	<table border="1"> 
		<tr>
			<td>\${coin == 1000 && userId == "hongkd" }</td>
			<td>${coin == 1000 && userId == "hongkd" }</td>
		</tr>
		<tr>
			<td>\${coin == 1000 and userId == "hongkd" }</td>
			<td>${coin == 1000 and userId == "hongkd" }</td>
		</tr>
		<tr>
			<td>\${not empty member && userId eq "hongkd" }</td>
			<td>${not empty member && userId eq "hongkd" }</td>
		</tr>
		<tr>
			<td>\${! empty member && userId eq "hongkd" }</td>
			<td>${! empty member && userId eq "hongkd" }</td>
		</tr>
		
		
	</table>
</body>
</html>