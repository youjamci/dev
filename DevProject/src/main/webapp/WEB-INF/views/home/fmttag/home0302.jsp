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
	<p>1) type �Ӽ��� time���� �����ؾ� �ð� �������� �Ѵ�..</p>
	<p>now : ${now }</p>
	<p>time default : <fmt:formatDate value="${now }" type="time" timeStyle="default"/></p>
	<p>time short : <fmt:formatDate value="${now }" type="time" timeStyle="short"/></p>
	<p>time medium : <fmt:formatDate value="${now }" type="time" timeStyle="medium"/></p>
	<p>time long : <fmt:formatDate value="${now }" type="time" timeStyle="long"/></p>
	<p>time full : <fmt:formatDate value="${now }" type="time" timeStyle="full"/></p>
</body>
</html>