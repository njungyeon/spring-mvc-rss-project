package com.myprac.myapp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprac.myapp.member.Member;
import com.myprac.myapp.member.dao.MemberDao;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	MemberDao dao;

	@Override
	public void memberRegister(Member member) {
		int result = dao.memberInsert(member);
		
		if(result == 0) {
			System.out.println("Join Fail...");
		}else {
			System.out.println("Join success!!");
		}
		
	}

	@Override
	public Member memberSearch(Member member) {
		
		Member mem = dao.memberSelect(member);
		
		if(mem == null) {
			System.out.println("login fail...");
		}else {
			System.out.println("login success!!!");
		}
		
		return mem; 
		
	}

	@Override
	public Member memberModify(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberDelete(Member member) {
		// TODO Auto-generated method stub
		
	}

}
