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
	<p>Ư�� URL�� ����� �о�ͼ� ���� ��ġ�� �����Ѵ�.</p><hr>
	
	<p>���� URL</p>
	<c:import url="http://localhost/board/list"/>
	<c:import url="http://localhost/board/search">
		<c:param name="keyword" value="orange"/>
	</c:import>
	<br><hr>
	
	<p>��� URL - ���� ���</p>
	<c:import url="http://localhost/board/list"/>
	<c:import url="http://localhost/board/search">
		<c:param name="keyword" value="orange"/>
	</c:import>
	
	<p>��� URL - ��� ���</p>
	<c:import url="../../board/list.jsp"/>
	<c:import url="../../board/search.jsp"/>
</body>
</html>