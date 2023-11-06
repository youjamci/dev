package kr.or.ddit.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@ControllerAdvice /// 예외처리에 사용할 클래스임을 명시
public class CommonExceptionHandler {

//	@ExceptionHandler(Exception.class)
//	public String handle(Exception e, Model model) {
//		log.info("handle() 실행...!");
//		log.info("Exception Info : " + e.toString());
//		
//		model.addAttribute("exception", e);
//		return "error/errorCommon";
//	}
	
	// 404에러 페이지 처리
	// web.xml에서 NoHandlerFoundException 처리 활성화 true로  설정하과 왔나요?
//	@ExceptionHandler(NoHandlerFoundException.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	public String handle404(Exception e) {
//		log.info("Exception : " + e.toString());
//		return "error/custom404";
//	}
}
