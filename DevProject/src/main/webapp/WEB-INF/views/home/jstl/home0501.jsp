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
	<p>��� c:when �±��� test ������� false�̸� c:otherwise�� ����ȴ�.</p>
	<c:choose>
		<c:when test="${member.gender == 'M' }">
			<p>male</p>
		</c:when>
		<c:when test="${member.gender == 'F' }">
			<p>female</p>
		</c:when>
		<c:otherwise>
			<p>others</p>
		</c:otherwise>
	</c:choose>
</body>
</html>