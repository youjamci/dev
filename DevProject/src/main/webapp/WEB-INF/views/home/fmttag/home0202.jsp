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
	<p><fmt:parseNumber value="${coin }" var="coinNum" pattern="0,000.00"/>
	<p>coinNum : ${coinNum }</p>
	
	<!-- 
		parseNumber�� ������ ���� ���ڿ��� pattern �Ӽ��� ��ġ���� ���ڷ� ��ȯ�Ѵ�.
		parseNumber�� ������ ���� ���ڿ��� type �Ӽ��� ��ġ���� ���ڷ� ��ȯ�Ѵ�.
			- currency�� ���� ��ȭ��ȣ�� ���Ե� ���ڿ��� �Ľ�
			- percent�� ���� %�� ���Ե� ���ڿ��� �Ľ� 
	 -->
</body>
</html>