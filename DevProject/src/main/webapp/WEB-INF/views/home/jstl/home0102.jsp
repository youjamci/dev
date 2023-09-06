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
	<p>2) c:out escapeXml �Ӽ��� �⺻���� true�̹Ƿ� Ư�����ڸ� ��ȯ�Ѵ�.</p>
	
	<!-- 
		EL ǥ���� �״�θ� ����� ���, �±״� �±� ���� �״�� ��µȴ�. (CKEditor�� Ȱ���غ��� ����� Ȯ�ε����ſ���!)
		Core �±� out�� Ȱ�� ��, ��ũ��Ʈ �ڵ�� �� ������ ������ �� �ֽ��ϴ�. (HTML �ڵ� �ؼ� �Ұ�)
		�⺻������ default�� true�̸� ���ڿ� ���·� ��µȴ�.
		escapeXml �Ӽ��� false�� �Ǹ� EL���� ��µǴ� ����ó�� ��ũ��Ʈ�� ���� html�±װ� �ؼ��Ǿ� ����ȴ�.
	 -->
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${member.userId}</td>
		</tr>
		<tr>
			<td>member.userId</td>
			<td><c:out value="${member.userId }"/></td>
		</tr>
		<tr>
			<td>member.userId(escapeXml=false)</td>
			<td><c:out value="${member.userId }" escapeXml="false"/></td>
		</tr>
	</table>
</body>
</html>