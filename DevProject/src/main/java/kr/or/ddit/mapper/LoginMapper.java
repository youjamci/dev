package kr.or.ddit.mapper;

import kr.or.ddit.vo.DDITMemberVO;

public interface LoginMapper {
	public DDITMemberVO loginCheck(DDITMemberVO member);
	public DDITMemberVO idCheck(String memId);
	public int signup(DDITMemberVO memberVO);
//	public DDITMemberVO findId(DDITMemberVO memberVO);
	public DDITMemberVO findId(DDITMemberVO member);
	public DDITMemberVO findPw(DDITMemberVO member);
}
