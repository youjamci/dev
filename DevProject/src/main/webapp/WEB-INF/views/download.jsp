<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
document.getElementById("downloadButton").addEventListener("click", function () {
    // 텍스트 영역의 내용을 가져옵니다.
    const text = document.getElementById("textArea").value;

    // PDF 문서를 생성합니다.
    const pdfDoc = new jsPDF();
    
    // 텍스트를 PDF에 추가하고 줄 바꿈을 유지합니다.
    pdfDoc.text(text, 10, 10);

    // PDF를 다운로드합니다.
    pdfDoc.save("다운로드된_문서.pdf");
});
    