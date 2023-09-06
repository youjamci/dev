<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item3 Modify</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<body>
	<h2>MODIFY</h2>
	<form action="/item3/modify" method="post" id="item" enctype="multipart/form-data">
		<input type="hidden" name="itemId" value="${item.itemId }">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="itemName" id="itemName" value="${item.itemName }"/></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" id="price" value="${item.price }"/></td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" id="inputFile"/>
					<div class="uploadedList"></div>
				</td>
			</tr>
			<tr>
				<td>게요</td>
				<td><textarea rows="10" cols="30" name="description">${item.description }</textarea></td>
			</tr>
		</table>
		<div>
			<button type="submit">수정</button>
			<button type="button" onclick="javascript:location.href='/item3/list'">목록</button>
		</div>
	</form>
</body>
<script type="text/javascript">
$(function(){
	var inputFile = $("#inputFile"); // input type file element
	var item = $("#item");
	
	var itemId = ${item.itemId};
	console.log("itemId : " + itemId);
	
	$.getJSON("/item3/getAttach/" + itemId, function(list){
		$(list).each(function(){
			console.log("list : " + list);
			console.log("this : " + this);
			var data = this;
			var str = "";
			if(checkImageType(data)){ // 이미지면 이미지태그를 이용하여 출력
				str = "<div>";
				str += "	<a href='/item3/displayFile?fileName=" + data + "'>"; /// 원본파일명
				str += "		<img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>" ; /// s_가 붙은 녀석, 가로 세로 100 100
				str += "	</a>";
				str += "	<span>X<span>";
				str += "</div>"
			}else{ // 파일이면 파일명에 대한 링크로만 출력
				str = "<div>";
				str += "	<a href='/item3/displayFile?fileName=" + data + "'>"+ getOriginalName(data) + "</a>";
				str += "	<span>X<span>";
				str += "</div>"
			}
			$(".uploadedList").append(str);
		});
	});
	
	inputFile.on("change", function(){
		console.log("change...!");
		
		var files = event.target.files;
		var file = files[0];
		
		console.log(file);
		
		var formData = new FormData();
		formData.append("file", file);
		
		$.ajax({
			type : "post",
			url : "/item3/uploadAjax",
			data : formData,
			dataType : "text", /// text라는 데이터 타입으로 받겠다
			processData : false, /// 쿼리스트링 구성 안 함(비활성화)
			contentType : false, /// defaul로 넘어가면 json형식임, json형식 말고 multipart-formdata mimetype로 넘기려고 false 시킴
			success : function(data){
				console.log(data); /// 원본파일명
				
				var str = "";
				if(checkImageType(data)){ // 이미지면 이미지태그를 이용하여 출력
					str = "<div>";
					str += "	<a href='/item3/displayFile?fileName=" + data + "'>"; /// 원본파일명
					str += "		<img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>" ; /// s_가 붙은 녀석, 가로 세로 100 100
					str += "	</a>";
					str += "	<span>X<span>";
					str += "</div>"
				}else{ // 파일이면 파일명에 대한 링크로만 출력
					str = "<div>";
					str += "	<a href='/item3/displayFile?fileName=" + data + "'>"+ getOriginalName(data) + "</a>";
					str += "	<span>X<span>";
					str += "</div>"
				}
				$(".uploadedList").append(str);
			}
		});
	});
	
	
	// 업로드 한 이미지 'X' 클릭
	$(".uploadedList").on("click", "span", function(){
		$(this).parent("div").remove();
	});
	
	item.submit(function(){
		var that = $(this); // form
		var str = "";
		$(".uploadedList a").each(function(index){/// uploadedList안에 있는 a태그, a태그 개수만큼 만들어짐
			var value = $(this).attr("href");
			value = value.substr(28); // '?fileName=' 다음부터 나오는 값
					
			str += "<input type='hidden' name='files[" + index + "]' value='" + value + "'>";
		});
		
		console.log("str : " + str);
		that.append(str);
		that.get(0).submit(); // form의 첫 번째를 가져와서 submit() 처리
	});
	
	// 임시 파일로 썸네일 이미지 만들기
	function getThumbnailName(fileName){
		var front = fileName.substr(0, 12); // 2023/09/04 폴더
		var end = fileName.substr(12); // 뒤 파일명
		
		console.log("front : " + front);
		console.log("end : " + end);
		
		return front + "s_" + end;
	}
	
	function getOriginalName(fileName){
		if(checkImageType(fileName)){
			return;
		}
		
		var idx = fileName.indexOf("_") + 1; /// 언더바를 기준으로 왼쪽은 년월일, 오른쪽은 원본파일명
		return fileName.substr(idx);
	}
	
	// 이미지 파일인지 확인
	function checkImageType(fileName){
		var pattern = /jpg|gif|png|jpeg/i; /// 이 확장자가 포함되어있으면 ↓
		return fileName.match(pattern); // 패턴과 일치하면 true(이미지구나?)
	}
});
</script>
</html>