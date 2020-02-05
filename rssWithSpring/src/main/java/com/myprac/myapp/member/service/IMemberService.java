package com.myprac.myapp.member.service;

import com.myprac.myapp.member.Member;

public interface IMemberService {
	void memberRegister(Member member);
	Member memberSearch(Member member);
	Member memberModify(Member member);
	void memberDelete(Member member);
}
