package com.myprac.myapp.member;

public class Member {

	private String memId;
	private String memPw;
	private String memNickname;
	private String memMail;
	private Number memIdx;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public Number getMemIdx() {
		return memIdx;
	}
	public void setMemIdx(Number memIdx) {
		this.memIdx = memIdx;
	}
}
