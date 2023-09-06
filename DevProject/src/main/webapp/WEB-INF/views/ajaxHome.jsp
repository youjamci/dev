<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>HOME</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var putBtn = $("#putBtn");
	var putHeaderBtn = $("#putHeaderBtn");
	
	var postBtn = $("#postBtn");
	var putJsonBtn = $("#putJsonBtn");
	var putXmlBtn = $("#putXmlBtn");

	var getBtn = $("#getBtn");
	var getJsonBtn = $("#getJsonBtn");
	var getXmlBtn = $("#getXmlBtn");

	putBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNo,
				title : title,
				content : content,
				writer : writer
		};
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				// '==' Equals Operator, '===' Strice Equals Operator�� '==='�� ���� �� �����ϰ� ���� �� ����Ѵ�.
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	putHeaderBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNo,
				title : title,
				content : content,
				writer : writer
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNo,
			headers : {
				// ��� Ű : ��
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	postBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNo,
				title : title,
				content : content,
				writer : writer
		}
		
		$.ajax({
			type : "post",
			url : "/board/" + boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	putJsonBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
	
		var boardObject = {
				boardNo : boardNo,
				title : title,
				content : content,
				writer : writer
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	putXmlBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
	
		var xmlData = "<Board>";
		xmlData += "<boardNo>" + boardNo + "</boardNo>";
		xmlData += "<title>" + title + "</title>";
		xmlData += "<content>" + content + "</content>";
		xmlData += "<writer>" + writer + "</writer>";
		xmlData += "<regDate>2018-12-19</regDate>";
		xmlData += "</Board>";
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNo,
			data : xmlData,
			// ��û�� ContentType ��� ���� "application/xml"�� �����Ѵ�.
			contentType : "application/xml; charset = utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result == "SUCCESS"){
					alert(result);
				}
			} 
		});
	});
	
	getBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		
		console.log(boardNo);
		
		// GET ��� �񵿱� HTTP ��û ����
		$.get("/board/" + boardNo, function(data){
			console.log(data);
			alert(JSON.stringify(data));
		});
	});
	
	/////////�����ϱ� ��ȣ �ȳ���
	getJsonBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNo,
			// ��û�� Accept ��� ���� "application/json" �̵�� Ÿ������ �����Ѵ�.
			headers : {
				"Accept" : "application/json"
			},
			success : function(result){
				console.log(result);
				alert(JSON.stringify(result));
			}
		});
	});
	
	getXmlBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNo,
			headers : {
				"Accept" : "application/xml"
			},
			success : function(result){
				console.log(result);
				alert(xmlToString(result));
			}
		});
	});
});

function xmlToString(xmlData){
	var xmlString;
	
	// xml �����͸� ����� �� ���������� ��� �������� ���ݾ� �ٸ���
	// window.ActiveObject�� ActiveXObject�� �����ϴ� �������� Object�� �����ϰ� �׷��� �ʴ� ��� null�� �����Ѵ�
	if(window.ActiveObject){ // IE��� �� Ÿ ������ ���� ����
		xmlString = xmlData.xml;
	}else{
		// �Ľ̵� XML �����͸� String���� ��ȯ
		xmlString = (new XMLSerializer()).serializeToString(xmlData);
	}
	return xmlString;
}
</script>
<body>
	<h1>Ajax Home</h1>
	
	<form>
		<p>boardNo : <input type="text" name="boardNo" value="" id="boardNo"/> </p>
		<p>title : <input type="text" name="title" value="" id="title"/> </p>
		<p>content : <input type="text" name="content" value="" id="content"/> </p>
		<p>writer : <input type="text" name="writer" value="" id="writer"/> </p>
	</form>
	
	<div>
		<button id="putBtn">MODIFY(PUT)</button>
		<button id="putHeaderBtn">MODIFY(PUT with Header)</button>

		<button id="postBtn">MODIFY(POST)</button>
		<button id="putJsonBtn">MODIFY(PUT Json)</button>
		<button id="putXmlBtn">MODIFY(PUT xml)</button>

		<button id="getBtn">READ</button>
		<button id="getJsonBtn">READ(JSON)</button>
		<button id="getXmlBtn">READ(XML)</button>
	</div>
</body>
</html>