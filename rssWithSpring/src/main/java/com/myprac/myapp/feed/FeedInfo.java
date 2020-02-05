package com.myprac.myapp.feed;

//import java.util.List;

public class FeedInfo {

	private String siteTitle;
	private String rssAddress;
	private String desc;
	private int id;
	//private List<FeedDetail> feedDetail;
	
	public String getSiteTitle() {
		return siteTitle;
	}
	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}
	public String getRssAddress() {
		return rssAddress;
	}
	public void setRssAddress(String rssAddress) {
		this.rssAddress = rssAddress;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public List<FeedDetail> getFeedDetail() {
//		return feedDetail;
//	}
//	public void setFeedList(List<FeedDetail> feedDetailLists) {
//		this.feedDetail = feedDetailLists;
//	}
}
