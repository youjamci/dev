<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home</title>
</head>
<body>
	<p>dateStyle �Ӽ��� short�� �����Ͽ� ���ڿ��� Date ��ü�� ��ȯ�Ѵ�.</p>
	<p>dateValue : ${dateValue }</p>
	<fmt:parseDate value="${dateValue }" type="date" dateStyle="short" var="date"/>
	<p>date : ${date }</p>
</body>
</html>