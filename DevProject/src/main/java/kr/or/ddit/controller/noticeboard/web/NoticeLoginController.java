package kr.or.ddit.controller.noticeboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.noticeboard.service.INoticeService;
import kr.or.ddit.vo.DDITMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeLoginController {

	@Inject
	private INoticeService noticeService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String noticeLogin(Model model) {
		model.addAttribute("bodyText", "login-page");
		return "conn/login";
	}

	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest req, DDITMemberVO member, Model model) {
		String goPage = "";
		Map<String, String> errors = new HashMap<String, String>();

		if (StringUtils.isBlank(member.getMemId())) {
			errors.put("memId", "아이디를 입력해주세요.");
		}
		if (StringUtils.isBlank(member.getMemPw())) {
			errors.put("memPw", "비밀번호를 입력해주세요.");
		}
		if (errors.size() > 0) { // 에러 발생
			model.addAttribute("errors", errors);
			model.addAttribute("member", member);
			model.addAttribute("bodyText", "login-page");
			goPage = "conn/login";
		} else {
			DDITMemberVO memberVO = noticeService.loginCheck(member);
			if (memberVO != null) { // 로그인 성공
				// 로그인 성공 후, 세션 처리
				HttpSession session = req.getSession();
				session.setAttribute("SessionInfo", memberVO);
				goPage = "redirect:/notice/list.do";
			} else {
				model.addAttribute("message", "서버에러, 로그인 정보를 정확하게 입력해주세요.");
				model.addAttribute("member", member);
				model.addAttribute("bodyText", "login-page");
				goPage = "conn/login";
			}
		}
		return goPage;
	}

	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String noticeSignupForm(Model model) {
		model.addAttribute("bodyText", "register-page"); /// 바디텍스트 추가해야 안 깨짐
		return "conn/register";
	}

	@ResponseBody
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	public ResponseEntity<ServiceResult> idCheck(@RequestBody Map<String, String> map) {
		/*
		 * 단일 데이터를 꺼낼 때, 1) ajax 설정에서 ContentType 설정을 하지 않고 데이터만 {memId : id} 설정해서 넘길 때
		 * - String memId로 데이터를 꺼낼 수 있다.
		 * 
		 * 2) ajax 설정에서 ContentType 설정을 하지 않고, 데이터만 JSON.stringify일 때 - @RequestBody로
		 * String memId를 꺼내면 '%7B%22memId%22%3A...' 이런 데이터가 넘어옴
		 * 
		 * 3) ajax 설정에서 ContentType 설정을 하고, 데이터만 JSON.stringify일 때 (데이터 JSON 객체로 넘어감)
		 * - @RequestParam으로 String memId를 꺼내면 400에러가 발생한다.
		 * 
		 * 4) ajax 설정에서 ContentType 설정을 하고, 데이터만 JSON.stringify일 떄(데이터 JSON 객체로 넘어감)
		 * - @ReqeustBody Map<String, String> map으로 꺼내면 'a001'데이터가 넘어온다.
		 */
		String id = map.get("memId").toString();
		log.info("넘겨받은 아이디 : " + map.get("memId"));
		ServiceResult result = noticeService.idCheck(id);
		return new ResponseEntity<ServiceResult>(result, HttpStatus.OK); /// 페이지가 아닌 데이터 리턴 그래서 @ResponseBody가 필요함
	}

	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String singup(HttpServletRequest req, DDITMemberVO memberVO, Model model, RedirectAttributes ra) {
		String goPage = "";

		Map<String, String> errors = new HashMap<String, String>();
		if (StringUtils.isBlank(memberVO.getMemId())) {
			errors.put("memId", "아이디를 입력해주세요.");
		}
		if (StringUtils.isBlank(memberVO.getMemPw())) {
			errors.put("memPw", "비밀번호를 입력해주세요.");
		}
		if (StringUtils.isBlank(memberVO.getMemName())) {
			errors.put("memName", "이름 입력해주세요.");
		}

		if (errors.size() > 0) { // 에러가 발생
			model.addAttribute("bodyText", "register-page");
			model.addAttribute("errors", errors);
			model.addAttribute("member", memberVO);
			goPage = "conn/register";
		} else {
			ServiceResult result = noticeService.signup(req, memberVO);
			if (result.equals(ServiceResult.OK)) {
				ra.addFlashAttribute("message", "회원가입을 완료하였습니다!"); // 일회성 메세지
				goPage = "redirect:/notice/login.do";
			} else {
				model.addAttribute("bodyText", "register-page");
				model.addAttribute("message", "서버에러, 다시 시도해주세요!");
				model.addAttribute("member", memberVO);
				goPage = "conn/register";
			}
		}
		return goPage;
	}

	@RequestMapping(value = "/forget.do", method = RequestMethod.GET)
	public String noticeForget(Model model) {
		model.addAttribute("bodyText", "register-page");
		return "conn/forget";
	}

	@RequestMapping(value = "/findId.do")
	public String findId(HttpServletRequest request, Model model,
			@RequestParam(required = false, value = "memEmail") String memEmail,
			@RequestParam(required = false, value = "memName") String memName, DDITMemberVO member) {
		log.info("findId 실행");
		model.addAttribute("bodyText", "register-page");
		member.setMemEmail(memEmail);
		member.setMemName(memName);
		DDITMemberVO memberVO = noticeService.findId(member);
		model.addAttribute("member", memberVO);
		log.info(memberVO.toString());
		return "conn/forget";
	}

	@RequestMapping(value = "/findPw.do")
	public String findPw(HttpServletRequest request, Model model,
			@RequestParam(required = true, value = "memId") String memId,
			@RequestParam(required = true, value = "memEmail") String memEmail,
			@RequestParam(required = true, value = "memName") String memName, DDITMemberVO member) {
		model.addAttribute("bodyText", "register-page");
		member.setMemId(memId);
		member.setMemEmail(memEmail);
		member.setMemName(memName);
		DDITMemberVO memberVO = noticeService.findPw(member);
		model.addAttribute("member", memberVO);
		log.info(memberVO.toString());
		return "conn/forget";
	}

// @RequestMapping(value = "/findId.do", method = RequestMethod.POST)
// public String findId(DDITMemberVO memberVO, Model model) {
//	   log.info("findid실행");
//	   String goPage = "";
//	   Map<String, String> errors = new HashMap<String, String>();
//		
//		if(StringUtils.isBlank(memberVO.getMemEmail())) {
//			errors.put("memEmail", "이메일 입력해주세요.");
//		}
//		if(StringUtils.isBlank(memberVO.getMemName())) {
//			errors.put("memName", "이름을 입력해주세요.");
//		}
//	   
//		if(errors.size() > 0) { // 에러 발생
//			model.addAttribute("errors", errors);
//			model.addAttribute("memberVO", memberVO);
//			goPage = "conn/forget";
//		}else {
//		   DDITMemberVO member = noticeService.findId(memberVO);
//
//		   if(member == null) {
//			   model.addAttribute("check", 1);
//		   }else {
//			   model.addAttribute("check", 0);
//			   model.addAttribute("id", member.getMemId());
//		   }
//		   goPage = "conn/forget";
//		}
//		
//	   
//	   
//	   return goPage;
// }

}