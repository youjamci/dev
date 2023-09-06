package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	/*
	 * 5장 컨트롤러 요청 처리
	 * 
	 * 1. 컨트롤러 메서드 매개변수
	 * 
	 * 		Model
	 * 		- 이동 대상에 전달할 데이터를 가지고 있는 인터페이스
	 * 		RedirectAttributes
	 * 		- 리다이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
	 * 		자바빈즈 클래스
	 * 		- 요청 파라미터를 가지고 있는 자바빈즈 클래스
	 * 		MultipartFile
	 * 		- 멀티파트 요청을 사용해 업로드된 파일 정보를 가지고 있는 인터페이스
	 * 		BindingResult
	 * 		- 도메인 클래스의 입력값 검증을 가지고 있는 인터페이스
	 * 		java.security.Principal
	 * 		- 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스
	 */
	
	/*
	 * 5장 컨트롤러 요청 처리 시작 컨트롤러 메소드
	 * - 페이지를 요청해 테스트 진행한다.
	 */
	@RequestMapping(value="/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm() 실행...!");
		return "member/registerForm";
	}
	
	// 1) URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerByParameter(String userId, String password) {
		log.info("registerByParameter() 실행...!");
		log.info("userId : " + userId);
		log.info("password : " + password);
		return "success";
	}
	
	// 2) URL 경로 상의 경로 변수로부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value="/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable String userId) {
		// userId가 기본적인 파라미터 형태로 받게 될 경우에는 null로 들어온다.
		// 경로상에 포함되어 있는 값은 @PathVariable을 꼭 붙여주어야 값을 바인딩할 수 있다.
		log.info("registerByPath() 실행...!");
		log.info("userId : " + userId);
		return "success";
	}
	
	// 3) HTML Form 필드가 여러개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@RequestMapping(value="/register01", method = RequestMethod.POST)
	public String register01(String userId, String password) {
		log.info("register01() 실행...!");
		log.info("userId : " + userId);
		log.info("password : " + password);
		return "success";
	}
	
	// 4) HTML 폼 필드가 여러 개일 경우에 컨트롤러 매개변수의 위치는 상관없다.
	@RequestMapping(value="/register02", method = RequestMethod.POST)
	public String register02(String password, String userId, int coin) {
		log.info("register02() 실행...!");
		log.info("password : " + password);
		log.info("userId : " + userId);
		log.info("coin : " + coin);
		return "success";
	}
	
	// 5) HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청 데이터를 취득한다.
	@RequestMapping(value="/register03", method = RequestMethod.POST)
	public String register03(String userId, String password, String coin) {
		log.info("register03() 실행...!");
		log.info("userId : " + userId);
		log.info("password : " + password);
		log.info("coin : " + coin);
		return "success";
	}
	
	/*
	 * 3. 요청 데이터 처리 어노테이션
	 * 
	 * 		@PathVariable
	 * 		- URL에서 경로 변수 값을 가져오기 위한 어노테이션
	 * 		@RequestParam
	 * 		- 요청 파라미터 값을 가져오기 위한 어노테이션
	 * 		@RequestHeader
	 * 		- 요청 헤더 값을 가져오기 위한 어노테이션
	 * 		@RequestBody
	 * 		- 요청 본문 내용을 가져오기 위한 어노테이션
	 * 		@CookieValue
	 * 		- 쿠키 값을 가져오기 위한 어노테이션
	 */
	
	// 1) URL 경로 상의 경로 변수가 여러 개일 경우, @PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정해준다.
	@RequestMapping(value="/register/{userId}/{coin}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable String userId, @PathVariable int coin) {
		log.info("registerByPath() 실행...!");
		log.info("userId : " + userId);
		log.info("coin : " + coin);
		return "success";
	}
	
	// 2) HTML Form 필드명과 컨트롤러 매개변수명이 일치(대소문자 구분)하지 않으면 요청을 처리할 수 없다.
	@RequestMapping(value="/register0201", method = RequestMethod.POST)
	public String register0201(String username) {
		log.info("register0201() 실행...!");
		log.info("username : " + username);
		return "success";
	}
	
	// 3) @RequestParam 어노테이션을 사용하여 특정한 HTML Form의 필드명을 지정하여 요청을 처리한다.
	@RequestMapping(value="/register0202", method = RequestMethod.POST)
	public String register0202(@RequestParam("userId") String username) {
		log.info("register0202() 실행...!");
		log.info("username : " + username);
		return "success";
	}
	
	/*
	 * 4. 요청 처리 자바빈즈
	 */
	// 1) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value="/beans/register01", method = RequestMethod.POST)
	public String registerJavaBeans01(Member member) {
		log.info("registerJavaBeans01() 실행...!");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());
		return "success";
	}
	
	// 2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다.
	@RequestMapping(value="/beans/register02", method = RequestMethod.POST)
	public String registerJavaBeans02(Member member, int coin) {
		log.info("registerJavaBeans02() 실행...!");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());
		log.info("coin : " + coin);
		return "success";
	}
	
	/*
	 * 5. Date 타입 처리
	 * - 스프링 MVC Date 타입의 데이터를 처리하는 여러 방법을 제공한다.
	 * - 따로 지정하지 않으면 변환에 적합한 날짜 문자열 형식은 yyyy/MM/dd이다.
	 */
	@RequestMapping(value="/registerByGet01", method = RequestMethod.GET)
	public String registerByGet01(String userId, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth) {
		log.info("registerByGet01() 실행...!");
		log.info("userId : " + userId);
		log.info("dateOfBirth : " + dateOfBirth);
		return "success";
	}
	
	@RequestMapping(value="/registerByGet02", method = RequestMethod.GET)
	public String registerByGet02(Member member) {
		log.info("registerByGet01() 실행...!");
		log.info("member.getUserId : " + member.getUserId());
		log.info("member.getDateOfBirth : " + member.getDateOfBirth());
		return "success";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(Member member) {
		log.info("register() 실행...!");
		log.info("member.getUserId : " + member.getUserId());
		log.info("member.getPassword : " + member.getPassword());
		log.info("member.getDateOfBirth : " + member.getDateOfBirth());
		return "success";
	}
	
	/*
	 * 6. @DateTimeFormat 어노테이션
	 * - @DateTimeFormat 어노테이션의 pattern 속성값에 원하는 날짜형식을 지정할 수 있다.
	 * 
	 *  테스트는 /registerByGet02 를 요청하고 파라미터로 받아 줄, Member 클래스의 날짜를 받는 멤버 변수에 어노테이션을 설정합니다.
	 */
	
	/*
	 * 7. 폼 방식 요청 처리
	 */
	// 1) 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerUserId", method = RequestMethod.POST)
	public String registerUserId(String userId) {
		log.info("registerUserId() 실행...!");
		log.info("userId : " + userId);
		return "success";
	}
	
	// 2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value="/registerMemberUserId", method = RequestMethod.POST)
	public String registerMemberUserId(Member member) {
		log.info("registerMemberUserId() 실행...!");
		log.info("member.getUserId : " + member.getUserId());
		return "success";
	}
	
	// 3) 폼 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value="/registerPassword", method = RequestMethod.POST)
	public String registerPassword(String password) {
		log.info("registerPassword() 실행...!");
		log.info("password : " + password);
		return "success";
	}
	
	// 4) 폼 라디오버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerRadio", method = RequestMethod.POST)
	public String registerRadio(String gender) {
		log.info("registerRadio() 실행...!");
		log.info("gender : " + gender);
		return "success";
	}
	
	// 5) 폼 셀렉트박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerSelect", method = RequestMethod.POST)
	public String registerSelect(String nationality) {
		log.info("registerSelect() 실행...!");
		log.info("nationlity : " + nationality);
		return "success";
	}
	
	// 6) 복수 선택이 가능한 폼 셀렉트박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerMultipleSelect01", method = RequestMethod.POST)
	public String registerMultipleSelect01(String cars) {
		log.info("registerMultipleSelect01() 실행...!");
		log.info("cars : " + cars);
		return "success";
	}
	
	// 7) 복수 선택이 가능한 폼 셀렉트박스 요소값을 문자열 배열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerMultipleSelect02", method = RequestMethod.POST)
	public String registerMultipleSelect02(String[] carArray) {
		log.info("registerMultipleSelect02() 실행...!");
		
		if(carArray != null) {
			log.info("carArray.length : " + carArray.length);
			for(int i = 0; i < carArray.length; i++) {
				log.info("carArray["+i+"] : " + carArray[i]);
			}
		}else {
			log.info("carArray == null");
		}
		
		return "success";
	}
	
	// 8) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerMultipleSelect03", method = RequestMethod.POST)
	public String registerMultipleSelect03(ArrayList<String> carList) {
		// 리스트로는 셀렉트 박스 값을 가져올 수 없다.
		// 배열 형태를 이용하여 받아오거나 객체로 받아온다.
		log.info("registerMultipleSelect03() 실행...!");
		
		if(carList != null && carList.size() > 0){
			log.info("carList.size() : " + carList.size());
			for(int i = 0; i < carList.size(); i++) {
				log.info("carList["+i+"] : " + carList.get(i));
			}
		}else {
			log.info("carList == null");
		}
		return "success";
	}
	
	// 9) 폼 체크박스 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerCheckbox01", method = RequestMethod.POST)
	public String registerCheckbox01(String hobby) {
		log.info("registerCheckbox01() 실행...!");
		log.info("hobby : " + hobby);
		return "success";
	}
	
	// 10) 폼 체크박스 요소 값을 문자열 배열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerCheckbox02", method = RequestMethod.POST)
	public String registerCheckbox02(String[] hobbyArray) {
		log.info("registerCheckbox02() 실행...!");
		
		if(hobbyArray != null) {
			log.info("hobbyArray.length : " + hobbyArray.length);
			for(int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray["+i+"] : " + hobbyArray[i]);
			}
		}else {
			log.info("hobbyArray == null");
		}
		
		return "success";
	}
	
	// 11) 폼 체크 박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerCheckbox03", method = RequestMethod.POST)
	public String registerCheckbox03(ArrayList<String> hobbyList) {
		// 받는 타입을 List하게 되면 No primary or default constructor found for interface java.util.List] 에러 발생
		// List로는 데이터를 받는게 불가능하다!
		// 리스트와 같은 형태의 값을 받으려면 String[] 또는 String 기본 타입으로 데이터를 받아온다.
		log.info("registerCheckbox03() 실행...!");
		
		if(hobbyList != null && hobbyList.size() > 0) {
			log.info("hobbyList.size() : " + hobbyList.size());
			
			for(int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList["+i+"] : " + hobbyList.get(i));
			}
		}else {
			log.info("hobbyList == null");
		}
		return "success";
	}
	
	// 12) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerCheckbox04", method = RequestMethod.POST)
	public String registerCheckbox04(String developer) {
		log.info("registerCheckbox04() 실행...!");
		log.info("developer : " + developer);
		return "success";
	}
	
	// 13) 폼 체크박스 요소값을 기본 데이터 타입인 불리언 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerCheckbox05", method = RequestMethod.POST)
	public String registerCheckbox05(boolean foreigner) {
		log.info("registerCheckbox05() 실행...!");
		log.info("foreigner : " + foreigner);
		return "success";
	}
	
	// 14) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value="/registerAddress", method = RequestMethod.POST)
	public String registerAddress(Address address) {
		log.info("registerAddress() 실행...!");
		if(address != null) {
			log.info("address.getPostCode : " + address.getPostCode());
			log.info("address.getLocation : " + address.getLocation());
		}else {
			log.info("address == null");
		}
		
		return "success";
	}
	
	// 15) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value="/registerUserAddress", method = RequestMethod.POST)
	public String registerUserAddress(Member member) {
		log.info("registerUserAddress() 실행...!");
		
		Address address = member.getAddress();
		if(address != null) {
			log.info("address.getPostCode() : " + address.getPostCode());
			log.info("address.getLocation() : " + address.getLocation());
		}else {
			log.info("address == null");
		}
		
		return "success";
	}
	
	// 16) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value="/registerUserCardList", method = RequestMethod.POST)
	public String registerUserCardList(Member member) {
		log.info("registerUserCardList() 실행...!");
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			log.info("cardList.size() : " + cardList.size());
			
			for(int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() : " + card.getNo());
				log.info("card.getValidMonth() : " + card.getValidMonth());
			}
		}else {
			log.info("cardList == null");
		}
		
		return "success";
	}
	
	// 17) 폼 텍스트 영역 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerTextArea", method = RequestMethod.POST)
	public String registerTextArea(String introduction) {
		log.info("registerTextArea() 실행...!");
		log.info("introduction : " + introduction);
		return "success";
	} 
	
	// 18) 폼 텍스트 영역 요소값을 Date 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerDate01", method = RequestMethod.POST)
	public String registerDate01(Date dateOfBirth) {
		// yyyy/MM/dd 형식으로 데이터를 전송해야한다.
		log.info("registerDate01() 실행...!");
		log.info("dateOfBirth : " + dateOfBirth);
		return "success";
	}
	
	// 19) 폼 텍스트 영역 요소값을 @DateTimeFormat 어노테이션을 지정하여 Date 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerDate02", method = RequestMethod.POST)
	public String registerDate02(@DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth) {
		log.info("registerDate02() 실행...!");
		log.info("dateOfBirth : " + dateOfBirth);
		return "success";
	}
	
	/*
	 * 폼 데이터 양식을 활용한 전체 문제
	 * - 아래 작성한 메소드가 시작페이지
	 */
	@RequestMapping(value="/registerAllForm", method = RequestMethod.GET)
	public String registerAllForm() {
		log.info("registerAllForm() 실행...!");
		return "member/registerAllForm";
	}
	
	// 회원가입 기능을 요청하는 처리부
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String registerUser(Member member, Model model) {
		// 문제 결과 ) 결과 출력하기 위한 로직 구성
		String gender = "";
		if(member.getGender().equals("male")) 
			gender = "남자";
		else if(member.getGender().equals("female"))
			gender = "여자";
		else
			gender = "기타";
		
		String developer = "일반";
		if(member.getDeveloper().equals("Y"))
			developer = "개발자";
		
		String nationality = "";
		if(member.getNationality().equals("Korea"))
			nationality = "대한민국";
		if(member.getNationality().equals("Germany"))
			nationality = "독일";
		if(member.getNationality().equals("Austrailia"))
			nationality = "호주";
		if(member.getNationality().equals("Canada"))
			nationality = "캐나다";
		
		String[] carArray = member.getCarArray();
		String cars = "";
		if(carArray != null && carArray.length > 0) {
			for(String car : carArray) {
				if(car.equals("volvo"))
					cars += car.toUpperCase() + " ";
				if(car.equals("jeep"))
					cars += car.toUpperCase() + " ";
				if(car.equals("bmw"))
					cars += car.toUpperCase() + " ";
				if(car.equals("audi"))
					cars += car.toUpperCase() + " ";
			}
		}else {
			cars = "소유차량 없음";
		}
		
		String[] hobbyArray = member.getHobbyArray();
		String hobby = "";
		if(hobbyArray != null && hobbyArray.length > 0) {
			for(String hobbys : hobbyArray) {
				if(hobbys.equals("Sports"))
					hobby += "운동 ";
				if(hobbys.equals("Music"))
					hobby += "음악감상";
				if(hobbys.equals("Movie"))
					hobby += "영화시청 ";
			}
		}else {
			hobby = "취미없음";
		}
		
		// 회원 정보에 새롭게 추가
		member.setGender(gender);
		member.setDeveloper(developer);
		member.setNationality(nationality);
		member.setCars(cars);
		member.setHobby(hobby);
		model.addAttribute("member", member);

		return "member/registerAllResult";
	}
}























