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
	<p>delims �Ӽ��� ������ �����ڸ� ����Ͽ� items �Ӽ��� ���޵� ���ڿ��� ������ var �Ӽ��� ����� ������ ������ ���ڿ��� �����Ѵ�.</p>
	<c:forTokens items="${member.hobby }" delims="," var="hobby">
		${hobby }<br>
	</c:forTokens>
</body>
</html>