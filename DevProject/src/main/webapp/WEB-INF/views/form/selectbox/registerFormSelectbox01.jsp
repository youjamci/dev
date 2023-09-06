<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form Tag</title>
</head>
<body>
	<h2>Spring Form Tag</h2>
	<form:form method="post" action="/formtag/selectbox/result" modelAttribute="member">
		<table>
			<tr>
				<td>국적</td>
				<td>
					<form:select path="nationality" items="${nationalityCodeMap }"/>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>