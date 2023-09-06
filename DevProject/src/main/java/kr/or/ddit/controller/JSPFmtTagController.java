package kr.or.ddit.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/fmttag")
public class JSPFmtTagController {
	/*
	 * 7. 숫자 및 날짜 포멧팅 처리 태그
	 * - 숫자 및 날짜의 포멧팅과 관련된 태그입니다.
	 * 
	 * 	1) <fmt:formatNumber>
	 * 	- 숫자를 형식화한다.
	 *     속성            |    이름                         |  설명
	 *     __________________________________________________________
	 *     value	| String of Number  | 서식에 맞춰 출력할 숫자
	 *     type	    | String 			| 어떤 서식으로 출력할지를 정한다.
	 *     pattern  | String			| 직접 숫자를 출력할 서식을 지정한다.
	 *     var 		| String 			| 포멧팅한 결과를 지정할 변수 이름
	 *     __________________________________________________________
	 *  	type 속성 : number일 경우 숫자 형식으로, percent 일 경우 %형식으로, currency일 경우 통화 형식으로 출력된다.
	 *  	기본값은 number이다.
	 *  
	 *     2) <fmt:parseNumber>
	 *     - 문자열을 숫자로 변환한다.
	 *        속성              |    이름                          |  설명
	 *     __________________________________________________________
	 *     value		| String   			| 파싱할 문자열
	 *     type	    	| String 			| value 속성의 문자열 타입을 지정
	 *     pattern  	| String			| 파싱할 때 직접 사용할 서식을 지정한다.
	 *     var 			| String 			| 파싱한 결과를 저장할 변수 이름을 지정한다.
	 *     __________________________________________________________
	 *  	type 속성 : number, currency, percent가 올 수 있다.
	 *  	기본값은 number이다.
	 *  
	 *  	3) <fmt:formatDate>
	 *  	- Date 객체를 문자열로 변환한다.
	 *  	   속성              |    이름                          |  설명
	 *     __________________________________________________________
	 *     value		| String   			| 파싱할 문자열
	 *     type	    	| String 			| value 속성의 문자열 타입을 지정
	 *     pattern  	| String			| 파싱할 때 직접 사용할 서식을 지정한다.
	 *     var 			| String 			| 파싱한 결과를 저장할 변수 이름을 지정한다.
	 *     __________________________________________________________
	 */
	
	// 1) type 속성을 지정하거나 pattern 속성을 지정하여 숫자를 형식화한다.
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		int coin = 100;
		model.addAttribute("coin", coin);
		return "home/fmttag/home0101";
	}
	
	// 2) type 속성이 지정되지 않으면 기본값은 number이다.
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
//		int coin = 1000;
//		String coin = "￦1000";
		String coin = "1000%";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0201";
	}
	

	// 3) pattern 속성을 사용해 직접 사용할 서식을 지정한다.
	@RequestMapping(value = "/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		String coin = "1,000.25";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0202";
	}
	
	
	// 4) type 속성을 date로 지정하여 날짜 포멧팅을 한다.
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0301";
	}
	
	// 5) type 속성을 both로 지정하여 날짜 및 시간을 포멧팅을 한다.
	public String home0303(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0303";
	}
	
	// 6) dateStyle 속성을 short로 지정하여 문자열을 Date 객체로 변환한다.
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		String dateValue = "20. 2. 1";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0401";
	}
	
	@RequestMapping(value = "/home0402", method = RequestMethod.GET)
	public String home0402(Model model) {
		String dateValue = "2019년 2월 1일 (금)";
		model.addAttribute("dateValue" , dateValue);
		return "home/fmttag/home0402";
	}
}
