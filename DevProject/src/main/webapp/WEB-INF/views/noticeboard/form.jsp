<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<section class="content-header">
	<c:set value="등록" var="name"/>
	<c:if test="${status eq 'u' }">
		<c:set value="수정" var="name"/>
	</c:if>
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6">
         <h1>공지사항  ${name}</h1>
       </div>
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item"><a href="#">DDIT HOME</a></li>
           <li class="breadcrumb-item active">공지사항 ${name}</li>
         </ol>
       </div>
     </div>
   </div><!-- /.container-fluid -->
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="card card-primary">
				<form action="/notice/insert.do" method="post" id="noticeForm" enctype="multipart/form-data">
					<c:if test="${status eq 'u' }">
						<input type="hidden" name="boNo" id="boNo" value="${notice.boNo }">
					</c:if>
					<div class="card-header">
						<h3 class="card-title">공지사항 ${name}</h3>
						<div class="card-tools"></div>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="inputName">제목을 입력해주세요</label> <input type="text"
								id="boTitle" name="boTitle" value="${notice.boTitle }" class="form-control" placeholder="제목을 입력해주세요">
						</div>
						<div class="form-group">
							<label for="inputDescription">내용을 입력해주세요</label>
							<textarea id="boContent" name="boContent" class="form-control" rows="14"> ${notice.boContent }</textarea>
						</div>
						<div class="form-group">
							<div class="custom-file">
	
								<input type="file" class="custom-file-input" id="boFile" name="boFile" multiple="multiple"> 
								<label class="custom-file-label" for="boFile">파일을 선택해주세요</label>
							</div>
						</div> 
					</div>
					<sec:csrfInput/>
				</form>
				
				<!--
					<i class="fas fa-file-alt"></i>
					<i class="fas fa-file-excel"></i>
					<i class="far fa-file-pdf"></i>
					<i class="far fa-file-word"></i>
					<i class="far fa-file-powerpoint"></i>
					
				-->
				<c:if test="${status eq 'u' }">
					<div class="card-footer bg-white">
						<ul class="mailbox-attachments d-flex align-items-stretch clearfix">
							<c:if test="${not empty notice.noticeFileList }">
								<c:forEach items="${notice.noticeFileList }" var="noticeFile" varStatus="vs">
									<li>
										<span class="mailbox-attachment-icon">
											<i class="far fa-file-pdf"></i>
										</span>
		
										<div class="mailbox-attachment-info">
											<a href="#" class="mailbox-attachment-name">
											<i class="fas fa-paperclip"></i> ${noticeFile.fileName }</a> 
											<span class="mailbox-attachment-size clearfix mt-1"> <span>${noticeFile.fileFancysize }</span> 
											<span class="btn btn-default btn-sm float-right attachmentFileDel" id="span_${noticeFile.fileNo }">
												<i class="fas fa-times"></i>
											</span>
											</span>
										</div>
									</li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</c:if>
				<div class="card-footer bg-white">
					<div class="row">
						<div class="col-12">
						<!-- 
							등록일 때는 목록, 등록 버튼이 나타나야하고
							수정일 때는 수정, 수정 버튼이 나타나야함
						 -->
							<input type="button" value="${name}" id="insertBtn"class="btn btn-primary float-right">
							<c:if test="${status eq 'u' }">
								<input type="button" value="취소" id="cancelBtn" class="btn btn-success float-right"> 
							</c:if>
							<c:if test="${status ne 'u' }">
								<input type="button" value="목록" id="listBtn" class="btn btn-success float-right">
							</c:if> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
$(function(){ 
	CKEDITOR.replace("boContent", {
		filebrowserUploadUrl : "/imageUpload.do?${_csrf.parameterName}=${_csrf.token}"
	});
	
	var listBtn = $("#listBtn");
	var insertBtn = $("#insertBtn");
	var cancelBtn = $("#cancelBtn");
	var noticeForm = $("#noticeForm");
	
	listBtn.on("click", function(){
		location.href = "/notice/list.do";
	});
	
	insertBtn.on("click", function(){
		var title = $("#boTitle").val();
// 		var title = $("#boContent").val() // 일반 textarea.val() 를 이용해서 데이터를 가져옴
		var content = CKEDITOR.instances.boContent.getData(); // 내용 데이터
		
		if(title == null || title == ""){
			alert("제목을 입력해주세요");
			return false;
		}
		
		if(content == null || content == ""){
			alert("내용을 입력해주세요");
			return false;
		}
		
		if($(this).val() == "수정"){
			noticeForm.attr("action", "/notice/update.do");
		}
		
		noticeForm.submit();
	});
	
	cancelBtn.on("click", function(){
		var boNo = $("#boNo").val();
		location.href = "/notice/detail.do?boNo=" + boNo;
	});
	
	$(".attachmentFileDel").on("click", function(){
		var id = $(this).prop("id");
		var idx = id.indexOf("_");
		var noticeFileNo = id.substring(idx + 1);
		var ptrn = "<input type='text' name='delNoticeNo' value='%V' hidden='hidden'/>";
		$("#noticeForm").append(ptrn.replace("%V", noticeFileNo));
		$(this).parents("li:first").hide();
	});
});
</script>