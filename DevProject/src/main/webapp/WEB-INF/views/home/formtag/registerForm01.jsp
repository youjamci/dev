<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>RegisterForm01</title>
</head>
<body>
	<h2>Spring Form Tag</h2>
	<!-- modelAttribute="member" 서버와 연결하기 위한 속성으로, 페이지에서 소스보기 하면 안 보임 -->
	<!-- modelAttribute에 member를 설정하면 서버와 클라이언트간의 필드들이 하나로 묶여 값이 자동으로 들어감 -->
<%-- 	<form:form action="/formtag/register" method="post" modelAttribute="member"> --%>
	<form:form action="/formtag/register" method="post" modelAttribute="user">
		<table>
			<tr>
				<td>유저ID</td>
				<td>
					<form:input path="userId"/>
					<font color="red"> 
						<form:errors path="userId"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName"/>
					<font color="red"> 
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>