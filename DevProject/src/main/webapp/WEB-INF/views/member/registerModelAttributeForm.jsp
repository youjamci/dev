<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>registerModelAttributeForm</title>
</head>
<body>
	<h3>3. @ModelAttribute</h3>
	
	<p>1) �⺻ �ڷ����� �Ű������� �����ϴ��� �⺻������ ���޵��� �ʴ´�.</p>
	<form action="/modelattribute/register01" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="����">
	</form>
	
	<p>2) �⺻ �ڷ����� �Ű������� @ModelAttribute ������̼��� �����Ͽ� �����͸� �����Ѵ�.</p>
	<form action="/modelattribute/register02" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="����">
	</form>
	
	<p>3) �⺻ �ڷ����� �Ű������� ���� ���� ��쿡 ������ �Ű������� @ModelAttribute ������̼��� �����Ͽ� �����͸� �����Ѵ�.</p>
	<form action="/modelattribute/register03" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		<input type="submit" value="����">
	</form>
	
	<p>4) �ڹٺ��� ��Ģ�� �´� ��ü�� �Ű������� �����ϸ� �⺻������ ���޵ȴ�.</p>
	<form action="/modelattribute/register04" method="post">
		userId : <input type="text" name="userId" value="hongkd"><br>
		password : <input type="text" name="password" value="1234"><br>
		postCode : <input type="text" name="address.postCode" value="12345"><br>
		location : <input type="text" name="address.location" value="Daejeon"><br>
		<input type="submit" value="����">
	</form>
</body>
</html>