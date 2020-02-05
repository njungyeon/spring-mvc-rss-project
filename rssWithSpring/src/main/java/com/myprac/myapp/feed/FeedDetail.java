package com.myprac.myapp.feed;

import java.sql.Date;

//이 정보들은 사용자가 Rss 주소를 등록하고 나서 서버에서 rss에 해당하는 피드들을 가져와서 저장시켜야한다.
//그럼 커맨드 객체로 만들 필요가 없는거 아닌가?
public class FeedDetail {
	private String feedTitle;
	private String feedLink;
	private String content;
	Date date;
	
	public String getTitle() {
		return feedTitle;
	}
	public void setTitle(String title) {
		this.feedTitle = title;
	}
	public String getlink() {
		return feedLink;
	}
	public void setlink(String link) {
		this.feedLink = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
