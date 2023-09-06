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
	<h3>7장 JSP</h3>
	<p>JSTL 태그들의 Exam</p>
	<p>배열, List를 순차적으로 처리한다. (c:forEach)</p>
	<c:forEach items="${member.hobbyArray }" var="hobby">
		${hobby }<br>
	</c:forEach>
</body>
</html>