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
	<p>JSP���� ����� ������ �������� �ʰ� �ڹٺ��� ������Ƽ ���� �ٷ� ǥ���Ѵ�.</p>
	<c:set var="memberId" value="${member.userId }"/>
	<table border="1">
		<tr>
			<td>memberId</td>
			<td>${memberId}</td>
		</tr>
	</table><br><hr>

	<c:remove var="memberId"/>

	<c:set var="memberId" value="${member.userId }"></c:set>
	<table border="1">
		<tr>
			<td>memberId</td>
			<td>${memberId}</td> <!-- ���� �ȵ� -->
		</tr>
	</table><br><hr>

	
</body>
</html>