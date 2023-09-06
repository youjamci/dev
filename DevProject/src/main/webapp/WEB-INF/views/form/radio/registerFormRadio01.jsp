<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring From Tag</title>
</head>
<body>
	<h3>Spring From Tag</h3>
	<form:form method="post" action="/formtag/radio/result2" modelAttribute="member">
		<table>
			<tr>
				<td>성별</td>
				<td>
					<form:radiobutton path="gender" value="male" label="Male"/><br>
					<form:radiobutton path="gender" value="female" label="Female"/><br>
					<form:radiobutton path="gender" value="other" label="Other"/><br>
				</td>				
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>