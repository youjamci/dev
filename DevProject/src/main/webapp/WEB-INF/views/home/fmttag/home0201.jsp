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
	<p>coin : ${coin }</p>
<%-- 	<p><fmt:parseNumber value="${coin }" var="coinNum" type="currency"/> --%>
	<p><fmt:parseNumber value="${coin }" var="coinNum" type="percent"/>
	<p>coinNum : ${coinNum }</p>
</body>
</html>