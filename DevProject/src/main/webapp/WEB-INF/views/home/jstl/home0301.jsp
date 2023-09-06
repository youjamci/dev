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
	<p>JSP에서 사용할 변수를 설정하지 않고 자바빈즈 프로퍼티 값을 바로 표시한다.</p>
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
			<td>${memberId}</td> <!-- 삭제 안됨 -->
		</tr>
	</table><br><hr>

	
</body>
</html>