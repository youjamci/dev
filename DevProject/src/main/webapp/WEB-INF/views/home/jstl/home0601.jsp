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
	<p>�迭, List�� ���������� ó���Ѵ�. (c:forEach)</p>
	<c:forEach items="${member.hobbyArray }" var="hobby">
		${hobby }<br>
	</c:forEach>
</body>
</html>