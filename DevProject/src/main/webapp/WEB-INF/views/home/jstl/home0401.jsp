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
	<!-- 
		EL�ȿ��� �߻��ϴ� ���� ������ EL�ȿ��� ó���ϹǷ� var �Ӽ��� ������ ������ ���������� Ȯ���� �� �ִ�.
	 -->
	<c:catch var="ex">
		${member.hobbyArray[3] }
	</c:catch>
	<p>
		<c:if test="${ex != null }">
			${ex }
		</c:if>
	</p>
	
</body>
</html>