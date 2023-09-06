package kr.or.ddit.controller.noticeboard.view;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.view.AbstractView;

// AbstractView 클래스를 상속받아 renderMergedOutputModel 메소드를 재정의하여 사용하면 해당 클래스가 View의 역할을 하는 페이지의 형태가 된다.
public class NoticeDownloadView extends AbstractView{

	@Override /// renderMergedOutputModel : 뷰의 역할을 할 수 있게 만들어주는 친구
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> noticeFileMap = (Map<String, Object>) model.get("noticeFileMap");
		
		File saveFile = new File(noticeFileMap.get("fileSavepath").toString());
		String fileName = noticeFileMap.get("fileName").toString();
		
		// 요청 Header 정보들 중, User-Aget 영역 안에 여러 키워드 정보들을 가지고 특정 키워드가 포함되어 있는지를 체크해서 파일명의 출력 인코딩 부분을 설정한다.
		// 사용 브라우저 또는 현상에 따라 발생하는 알고리즘이므로, 내가 사용하게 되는 브라우저의 버전이나 얻어온 header 정보들의 값에 따라 차이가 발생할 수 있다.
		String agent = request.getHeader("User-Agent"); /// jsp에서 사용했던 여기에 네가 사용하고 있는 기기가 뭐냐 - 그런 정보들을 알 수 있음
		if(StringUtils.containsIgnoreCase(agent, "msie") || StringUtils.containsIgnoreCase(agent, "trident")) { // IE, Chrome ///- 우리가 쓰는 웹 브라우저가? 뭐가? 크롬인 경우가 많음
			fileName = URLEncoder.encode(fileName, "utf-8");
		}else { // filefox, chrome(소문자 c)
			fileName = new String(fileName.getBytes(), "ISO-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
		response.setHeader("Content-Length", noticeFileMap.get("fileSize").toString());

		// try with resource
		// ()안에 명시한 객체는 finally로 최종 열린 객체에 대한 close()를 처리하지 않아도 자동 close()가 이루어진다.
		try(
				OutputStream os = response.getOutputStream();
				) {
			FileUtils.copyFile(saveFile, os);
		} 
		
	}

}