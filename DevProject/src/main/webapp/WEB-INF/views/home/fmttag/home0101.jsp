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
	<p>1) type 속성을 지정하거나 pattern 속성을 지정하여 숫자를 형식화한다.</p>
	<p>coin : ${coin }</p>
	<p>currency : <fmt:formatNumber value="${coin }" type="currency"/>
	<p>percent : <fmt:formatNumber value="${coin }" type="percent"/>
	<p>pattern : <fmt:formatNumber value="${coin }" type="00000.00"/>
</body>
</html>