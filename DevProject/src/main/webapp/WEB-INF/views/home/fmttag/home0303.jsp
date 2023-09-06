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
	<p>1) type 속성을 both으로 지정해야 시간 포멧팅을 한다..</p>
	<p>now : ${now }</p>
	<p>time default : <fmt:formatDate value="${now }" type="both" dateStyle="" timeStyle="default"/></p>
	<p>time short : <fmt:formatDate value="${now }" type="both" timeStyle="short"/></p>
	<p>time medium : <fmt:formatDate value="${now }" type="both" timeStyle="medium"/></p>
	<p>time long : <fmt:formatDate value="${now }" type="both" timeStyle="long"/></p>
	<p>time full : <fmt:formatDate value="${now }" type="both" timeStyle="full"/></p>
</body>
</html>