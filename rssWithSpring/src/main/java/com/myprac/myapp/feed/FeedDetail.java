package com.myprac.myapp.feed;

import java.sql.Date;

//�� �������� ����ڰ� Rss �ּҸ� ����ϰ� ���� �������� rss�� �ش��ϴ� �ǵ���� �����ͼ� ������Ѿ��Ѵ�.
//�׷� Ŀ�ǵ� ��ü�� ���� �ʿ䰡 ���°� �ƴѰ�?
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
