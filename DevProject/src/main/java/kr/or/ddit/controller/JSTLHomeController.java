package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/jstl")
public class JSTLHomeController {

	/*
	 * 5. 표준 태그 라이브러리(JSTL)
	 * - 많은 개발자들이 JSP에서 코드를 깔끔하게 작성하기 위해서 커스틈 태그를 만들어왔는데, 이런 중복되는 노력을 없애기 위해서 나온것이 바로 JSTL이다.
	 * 
	 * 		1) core 태그 라이브러리
	 * 		
	 * 			요소              |            설명
	 * 		__________________________________________________________
	 * 		 c:out        | JspWriter에 값을 적절하게 처리한 후에 출력한다.
	 * 		 c:set		  | JSP에서 사용할 변수를 설정한다.
	 * 		 c:remove     | 설정한 변수를 제거한다.
	 *   	 c:catch      | 예외를 처리한다.
	 *   	 c:if         | 조건을 지정하고 지정된 조건과 일치하는 처리 내용을 구현한다.
	 *       c:choose     | 여러 조건을 처리할 때 사용한다.
	 *       c:when       | 여러 조건을 지정하고 지정한 조건과 일치하는 처리 내용을 구현한다. c:choose 요소에서 사용한다.
	 *       c:otherwise  | c:when 요소에서 지정한 조건에 모두 일치하지 않을 때 처리할 내용을 구현한다. c:choose 요소에서 사용한다.
	 *       c:forEach    | 컬렉션이나 배열의 각 항목을 처리할 때 사용한다.
	 *       c:forTokens  | 구분자로 구분된 각각의 토큰을 처리할 때 사용한다.
	 *       c:import     | URL을 사용하여 다른 자원을 삽입한다.
	 *       c:url        | URL을 재작성한다.
	 *       c:redirect   | 지정한 URL에 리다이렉트한다.
	 *       c:param      | 파리미터를 지정한다.
	 *       __________________________________________________________
	 *       # taglib 지시자 사용 모습 ::: <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 *       	> 인터페이스에 해당하는 core url를 꼭 잘 확인하고 넣어야 한다.
	 *       
	 *       2) fmt 태그 라이브러리 
	 *           요소                                |           설명
	 *           _________________________________________________________
	 *           fmt:formatNumber   | 숫자를 형식화한다
	 *           fmt:parseNumber    | 문자열을 숫자로 변환한다
	 *           fmt:formatDate     | Date 객체를 문자열로 변환한다.
	 *           fmt:parseDate      | 문자열을 Date 객체로 변환한다.
	 *           _________________________________________________________
	 *           # taglib 지시자 사용 모습 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	 *           	> 인터페이스에 해당하는 fmt uri를 꼭 잘 확인하고 넣어야한다.
	 *           
	 *		3) function 태그 라이브러리
	 *           요소                                        |           설명
	 *           _________________________________________________________
	 *           fmt:contains           | 지정한 문자열이 포함되어 있는지 판단한다.
	 *           fmt:containsIgnoreCase | 지정한 문자열이 대문자/소문자를 구분하지 않고 포함되어 있는지 판단한다.
	 *           fmt:startsWtih         | 지정한 문자열로 시작하는지 판단한다.
	 *           fmt:endWith            | 지정한 문자열로 끝나는지 판단한다.
	 *           fmt:indexOf            | 지정한 문자열이 처음으로 나왔을 때의 인덱스를 구한다.
	 *           fmt:length             | 컬렉션 또는 배열의 요소 개수, 문자열 길이를 구한다.
	 *           fmt:escapeXml          | 지정한 문자열을 XMl 구문으로 해석되지 않도록 이스케이프한다.
	 *           fmt:replace            | 문자열을 치환한다.
	 *           fmt:toLowerCase        | 문자열을 소문자로 변환한다.
	 *           fmt:toUpperCase        | 문자열을 대문자로 변환한다.
	 *           fmt:trim               | 문자열을 trim한다. (공백제거)
	 *           fmt:substring          | 지정한 범위에 해당하는 문자열을 잘라낸다.
	 *           fmt:substringAter      | 지정한 문자열에 일치하는 이후의 문자열을 잘라낸다.
	 *           fmt:substringBefore    | 지정한 문자열에 일치하는 이전의 문자열을 잘라낸다.
	 *           fmt:join               | 문자열 배열을 결합해서 하나의 문자열을 만든다.
	 *           fmt:split              | 문자열을 구분자로 분할해서 문자열 배열을 만든다.
	 *           _________________________________________________________
	 *           # taglib 지시자 사용 모습 ::: <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %> 
	 *           	> prefix에 설정한 내용은 자동 생성이긴 하지만, 내가 원하는 prefix명이 있다면 작성 가능(기본 fn, coutom function으로 설정)
	 *           
	 *      6. 코어 태그
	 *      - 조건분기나 반복처리 그리고 변수의 지정 등과 같이 논리적인 처리를 위해 사용되는 스크립트 코드를 대체하기 위한 태그를 제공한다.
	 *      	
	 *      	1) <c:out>
	 *      	- JspWriter에 값을 적절하게 처리한 후에 출력한다.
	 *      	    속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 value     | Object        | 출력할 값
	 *      	 escapeXml | boolean       | 특수 문자를 변환할지의 여부
	 *      	 default   | Object        | value의 결과값이 null인 경우 출력할 값
	 *          __________________________________________________________
	 *          
	 *          2) <c:set>
	 *      	- JSP에서 사용할 변수를 설정한다.
	 *      	    속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 var       | String        | EL 변수 이름
	 *      	 value     | Object        | 변수에 할당할 값
	 *      	 scope     | String        | 변수를 생성할 영역, 기본값은 page
	 *      	 target    | Object        | 프로퍼티 값을 설정할 객체 지정
	 *      	 property  | String        | 프로퍼티 이름
	 *          __________________________________________________________
	 *          
	 *          3) <c:remove>
	 *      	- 설정한 변수를 제거한다.
	 *      	    속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 var       | String        | 삭제할 EL 변수 이름
	 *      	 scope     | String        | 삭제할 변수가 포함된 영역
	 *          __________________________________________________________
	 *          
	 *          4) <c:catch>
	 *      	- 설정한 변수를 제거한다.
	 *      	    속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 var       | String        | 예외를 저장할 EL 변수 이름
	 *          __________________________________________________________
	 *          
	 *          5) <c:if>
	 *      	- 설정한 변수를 제거한다.
	 *      	    속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 test      | boolean       | 검사 조건
	 *      	 var       | String        | 검사 조건의 계산 결과값을 저장할 EL 변수
	 *      	 scope     | String        | 삭제할 변수가 포함된 영역
	 *          __________________________________________________________
	 *          
	 *          6) <c:choose>
	 *          - 여러 조건을 처리할 때 사용한다.
	 *          - c:when, c:otherwise가 사용된다.
	 *          
	 *          7) <c:when>
	 *          - 여러 조건을 지정하고 지정한 조건과 일치하는처리 내용을 구현한다. <c:choose> 요소에서 사용한다.
	 *              속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 test        | boolean       | 본문 내용을 처리할지 여부를 결정하는 테스트 조건
	 *          __________________________________________________________
	 *          
	 *          8) <c:otherwise>
	 *          - <c:when> 요소에서 지정한 조건에 모두 일치하지 않을 때 처리할 내용을 구현한다. <c:choose> 요소에서 사용한다.
	 *          
	 *          9) <c:forEach>
	 *          - 컬렉션이나 배열의 각 항목을 처리할 때 사용한다.
	 *               속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 var          | boolean       | 몸체에서 사용할 EL 변수 이름
	 *      	 items        | Colection,    | 반복 처리할 데이터
	 *      	              | Iterator,     | 
	 *      	              | Enumeration   | 
	 *      	 varStatus    | String        | 루프 상태를 저장할 EL 변수 이름 
	 *      	 begin        | int           | 시작 인덱스 값 
	 *      	 end          | int           | 끝 인덱스 값 
	 *      	 step         | int           | 인덱스 증분 값 
	 *          __________________________________________________________
	 *          
	 *          10) <c:froTokens>
	 *          - 구분자로 구분된 각각의 토큰을 처리할 때 사용한다.
	 *               속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 var          | String        | 몸체에서 사용할 EL 변수 이름
	 *      	 items        | String        | 반복할 토큰의 문자열
	 *      	 delims       | String        | 구분자
	 *      	 varStatus    | String        | 루프 상태를 저장할 EL 변수 이름 
	 *      	 begin        | int           | 시작 인덱스 값 
	 *      	 end          | int           | 끝 인덱스 값 
	 *      	 step         | int           | 인덱스 증분 값 
	 *          __________________________________________________________
	 *          
	 *          11) <c:import>
	 *          - URL을 사용하여 다른 자원을 삽입한다.
	 *               속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 url          | String        | 읽어 올 URL
	 *      	 var          | String        | 읽어온 결과를 저장할 변수 이름
	 *      	 scope        | String        | 변수를 저장할 영역
	 *      	 charEncoding | String        | 결과를 읽어올 때 사용할 캐릭터 인토딩 
	 *          __________________________________________________________
	 *          RUL 속성값이 두 가지 타입
	 *          - 절대 URL : 완전한 URL입니다. ex) https://news.naver.com/mian/123
	 *          - 상대 URL :
	 *          	> 웹 애플리케이션 내에서의 절대 경로 : '/'(슬래시)로 시작한다. ex) /board/list.jsp
	 *          	> 현재 JSP에 대한 상대 겨올 : '/'(슬래스)로 시작하지 않는다. ex) ../board/list.jsp
	 *          
	 *          12) <c:url>
	 *          - URL을 재작성한다.
	 *               속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 value        | String        | 읽어 올 URL
	 *      	 var          | String        | 읽어온 결과를 저장할 변수 이름
	 *      	 scope        | String        | 변수를 저장할 영역
	 *          __________________________________________________________
	 *          value 속성 값의 두 가지 타입
	 *          - 절대 URL : 완전한 URL입니다. ex) https://news.naver.com/mian/123
	 *          - 상대 URL : 
	 *          	> 웹 애플리케이션 내에서의 절대 경로 : '/'(슬래시)로 시작한다. ex) /board/list.jsp
	 *          	> 현재 JSP에 대한 상대 겨올 : '/'(슬래스)로 시작하지 않는다. ex) ../board/list.jsp
	 *          웹 애플리케이션 내에서의 절대 경로를 사용할 경우 실제로 생성되는 URL은 컨텍스트 경로를 포함한다.
	 *          
	 *          13) <c:redirect>
	 *          - 지정한 URL에 리다이렉트한다.
	 *               속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 url          | String        | 리다이렉트 할 URL
	 *      	 context      | String        | 컨텍스트 경로
	 *          __________________________________________________________
	 *          
	 *          14) <c:param>
	 *          - 파라미터를 지정한다.
	 *                속성            |      타입            |        설명
	 *      	__________________________________________________________
	 *      	 name          | String        | 파라미터 이름
	 *      	 value         | String        | 파라미터 값
	 *          __________________________________________________________
	 *         
	 */
	// 1) c:out value 속성에 지정한 값을 출력한다.
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		Member member = new Member();
		member.setUserId("hongkd");
		model.addAttribute("member", member);
		return "home/jstl/home0101";
	}
	
	// 2) c:out escapeXml 속성의 기본값은 true이므로 특수문자를 변환한다.
	//		escapeXml 속성값을 false로 지정하면 특수문자를 변환하지 않는다. (태그가 태그의 형태를 띄도록 한다.)
	@RequestMapping(value = "/home0102", method = RequestMethod.GET)
	public String home0102(Model model) {
		Member member = new Member();
		// 테스트 1
		//member.setUserId("<p>hongkd<>&$0102</p>");
		// 테스트 2
		member.setUserId("<script type='text/javascript'>alert(1);</script>");
		model.addAttribute("member", member);
		return "home/jstl/home0102";
	}
	
	// 3) value 속성에 지정한 값이 존재하지 않으면 default 속성에 지정한 값이 출력된다
	@RequestMapping(value = "/home0103", method = RequestMethod.GET)
	public String home0103(Model model) {
		Member member = new Member();
		member.setUserId(null);
		model.addAttribute("member", member);
		return "home/jstl/home0103";
	}
	
	// c:set
	// 1) JSP에서 사용할 변수를 설정하지 않고 자바빈즈 프로퍼티 값을 바로 표시한다.
	// 2) JSP에서 사용할 변수 memberId를 설정하여 사용한다. / 태그의 몸체를 값을 사용한다.
	// 3) member 객체의 userId 프로퍼티 값을 활용하여 값을 설정한다.
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		Member member = new Member();
		member.setUserId("hongkd0201");
		model.addAttribute("member", member);
		return "home/jstl/home0201";
	}
	
	// c:set 태그로 지정한 변수 memberId를 삭제한다.
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		Member member = new Member();
		member.setUserId("hongkd0301");
		model.addAttribute("member", member);
		return "home/jstl/home0301";
	}
	
	// EL식 내부에 발생한 예외는 EL식 내부에서 처리하므로 catch 변수 'ex'에 저장되지 않는다.
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		Member member = new Member();
		String[] hobbyArray = {"Music", "Movie"};
		member.setHobbyArray(hobbyArray);
		model.addAttribute("member", member);
		return "home/jstl/home0401";
	}
	
	// JSP 표현식에서 발생한 예외는 catch 변수 "ex"에 저장된다.
	@RequestMapping(value = "/home0402", method = RequestMethod.GET)
	public String home0402(Model model) {
		return "home/jstl/home0402";
	}
	
	// 모든 c:when 태그의 test 결과값이 false이면 c:otherwise가 실행된다.
	@RequestMapping(value = "/home0501", method = RequestMethod.GET)
	public String home0501(Model model) {
		Member member = new Member();
		member.setGender("M");
		model.addAttribute("member", member);
		return "home/jstl/home0501";
	}
	
	// 배열, List를 순차적으로 처리한다. (c:forEach)
	@RequestMapping(value = "/home0601")
	public String home6701(Model model) {
		Member member = new Member();
		String[] hobbyArray = {"Music", "Movie"};
		member.setHobbyArray(hobbyArray);
		model.addAttribute("member", member);
		return "home/jstl/home0601";
	}
	
	
	// delims 속성에 지정된 구분자를 사용하여 items 속성에 전달된 문자열을 나누고 var 속성에 명시한 변수에 나눠진 문자열을 지정한다.
	@RequestMapping(value = "/home0701", method = RequestMethod.GET)
	public String home0701(Model model) {
		Member member = new Member();
		String hobby = "Music, Movie";
		member.setHobby(hobby);
		model.addAttribute("member", member);
		
		return "home/jstl/home0701";
	}
	
	// c:import
	@RequestMapping(value = "/home0801", method = RequestMethod.GET)
	public String home0801() {
		return "home/jstl/home0801";
	}
	
	// c:redirect
	// 지정한 페이지로 리다이렉트시킨다.
	@RequestMapping(value = "/home0901", method = RequestMethod.GET)
	public String home0901() {
		return "home/jstl/home0901";
	}
	
}
