<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<title>Home</title>
</head>
<body>
	<h1>9. Ajax ��� ��û ó��</h1>
	
	<h3>Ajax ��� ��û ó��</h3>
	<hr>
	
	<form>
		userId : <input type="text" name="userId" value="hongkd" id="userId">
		password : <input type="text" name="password" value="1111" id="password">
	</form>
	
	<p>1) URL ��� ���� ���� ���� ��� ���������� @PathVariable ������̼��� �����Ͽ� ���� ���� ���ڿ� �Ű������� ó���Ѵ�.</p>
	<button id="registerBtn01">Register01</button> 
	
	<p>2) ��ü Ÿ���� JSON ��û �����͸� @RequestBody ������̼��� ������ �ڹٺ��� �Ű������� ó���Ѵ�.</p>
	<button id="registerBtn02">Register02</button>
	
	<p>3) ��ü Ÿ���� JSON ��û �����ʹ� ���ڿ� �Ű������� ó���� ��  [����.]</p>
	<button id="registerBtn03">Register03</button>
	
	<p>4) ��ü Ÿ���� JSON ��û �����͸� @PathVariable ������̼��� ������ ���ڿ� �Ű������� @RequestBody ������̼��� ������ �ڹٺ��� �Ű������� ó���Ѵ�.</p>
	<button id="registerBtn04">Register04</button>
	
	<p>5) ��ü �迭 Ÿ���� JSON ��û �����͸� �ڹٺ��� ��Ҹ� ���� ����Ʈ �÷��� �Ű������� @RequestBody ������̼��� �����Ͽ� ó���Ѵ�.</p>
	<button id="registerBtn05">Register05</button>
	
	<p>6) ��ø�� ��ü Ÿ���� JSON ��û ���̤��͸� @RequestBody ������̼��� �����Ͽ� ��ø�� �ڹٺ��� �Ű������� ó���Ѵ�.</p>
	<button id="registerBtn06">Register06</button>
	
	<p>7) ��ø�� ��ü Ÿ���� JSON ��û �����͸� @RequestBody ������̼��� �����Ͽ� ��ø�� �ڹٺ��� �Ű������� ó���Ѵ�.</p>
	<button id="registerBtn07">Register07</button>
</body>
<script type="text/javascript">
$(function(){
	var registerBtn01 = $("#registerBtn01");
	var registerBtn02 = $("#registerBtn02");
	var registerBtn03 = $("#registerBtn03");
	var registerBtn04 = $("#registerBtn04");
	var registerBtn05 = $("#registerBtn05");
	var registerBtn06 = $("#registerBtn06");
	var registerBtn07 = $("#registerBtn07");
	
	// 01)
	registerBtn01.on("click", function(){
		$.ajax({
			type : "post",
			url : "/ajax/register/hongkd/pw01",
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result == "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 2)
	registerBtn02.on("click", function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register02",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 3)
	registerBtn03.on("click", function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register03",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 4)
	registerBtn04.on("click", function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register04/hongkildong",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 5)
	registerBtn05.on("click", function(){
		var userObjectArray = [
			{userId : "name01", password : "pw01"},
			{userId : "name02", password : "pw02"}
		]
		
		$.ajax({
			type : "post",
			url : "/ajax/register05",
			data : JSON.stringify(userObjectArray),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 6)
	registerBtn06.on("click", function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
				userId : userId,
				password : password,
				address : {
					postCode : "010908",
					location : "Daejeon"
				}
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register06",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 7)
	registerBtn07.on("click", function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
				userId : userId,
				password : password,
				cardList : [
					{no : "23456", validMonth : "29221018"},
					{no : "12342", validMonth : "29221019"}
				]
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register07",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
});
</script>
</html>