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
	<p>2) c:out escapeXml 속성의 기본값은 true이므로 특수문자를 변환한다.</p>
	
	<!-- 
		EL 표현문 그대로를 출력할 경우, 태그는 태그 역할 그대로 출력된다. (CKEditor를 활용해봐서 결과는 확인됐을거에요!)
		Core 태그 out을 활용 시, 스크립트 코드로 웹 공격을 방지할 수 있습니다. (HTML 코드 해석 불가)
		기본적으로 default가 true이면 문자열 형태로 출력된다.
		escapeXml 속성이 false가 되면 EL문이 출력되는 형태처럼 스크립트와 같은 html태그가 해석되어 실행된다.
	 -->
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
			<td>member.userId(escapeXml=false)</td>
			<td><c:out value="${member.userId }" escapeXml="false"/></td>
		</tr>
	</table>
</body>
</html>