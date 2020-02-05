package com.myprac.myapp.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myprac.myapp.member.Member;
import com.myprac.myapp.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memService;
	
	@ModelAttribute("cp") //ModelAttribute를 설정하면 다른 함수들을 부를때도 함께 호출된다. 또한 view 단에서는 여기에 설정한 이름으로 값을 호출가능하다.
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	// Join
	@RequestMapping("/joinForm")
	public String joinForm(Member member) {
		return "/member/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinFunc(Member member) {
		
		memService.memberRegister(member);
		
		return "/member/memJoinOk";
	}
	
	//login
	@RequestMapping("/loginForm")
	public String loginForm(Member member) {
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginFunc(Member member, HttpSession session) {
		
		Member mem = memService.memberSearch(member);
		if(mem == null)
			return "/member/loginForm";
		
		session.setAttribute("nickname", mem.getMemNickname());
		session.setAttribute("memId", mem.getMemId());
		session.setAttribute("member", mem);
		
		return "/feed/main";
	}
	
	// Logout
	@RequestMapping("/logout")
	public String memLogout(Member member, HttpSession session) {
		
		session.invalidate();
		
		return "/member/logoutOk";
	}
	
	
}
