<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home</title>
</head>
<body>
	<p>1) type �Ӽ��� �����ϰų� pattern �Ӽ��� �����Ͽ� ���ڸ� ����ȭ�Ѵ�.</p>
	<p>now : ${now }</p>
	<p>date default : <fmt:formatDate value="${now }" type="date" dateStyle="default"/></p>
	<p>date short : <fmt:formatDate value="${now }" type="date" dateStyle="short"/></p>
	<p>date medium : <fmt:formatDate value="${now }" type="date" dateStyle="medium"/></p>
	<p>date long : <fmt:formatDate value="${now }" type="date" dateStyle="long"/></p>
	<p>date full : <fmt:formatDate value="${now }" type="date" dateStyle="full"/></p>
	<!-- 
		dateStyle�� �� 5������ �� ��Ÿ�Ͽ� ���� ��� ���°� �������ִ�.
		������ ��� ���¿� ���� parsing�� ����, �ش� �������� ������ ���ڿ��̶�� ���� ��Ÿ���� ���� Date Ÿ�� ������ �����ͷ� �Ľ��� �����ϴ�.
	 -->
</body>
</html>