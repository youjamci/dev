<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home</title>
</head>
<body>
	<h3>7�� JSP</h3>
	<p>JSTL �±׵��� Exam</p>
	<p>3) value �Ӽ��� ������ ���� �������� ������ default �Ӽ��� ������ ���� ��µȴ�</p>
	
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${member.userId}</td>
		</tr>
		<tr>
			<td>member.userId</td>
			<td><c:out value="${member.userId }"/></td>
		</tr>
		<tr>
			<td>member.userId</td>
			<td><c:out value="${member.userId }" default="hongkildong"/></td>
		</tr>
	</table>
</body>
</html>