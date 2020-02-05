package com.myprac.myapp.feed.service;

import java.util.List;

import com.myprac.myapp.feed.FeedInfo;

public interface IFeedService {
	void feedRegister(FeedInfo feedInfo, Number memIdx);
	List<FeedInfo> feedSearch(Number memIdx);
	void feedModify(FeedInfo feedInfo);
	void feedRemove(int urlIdx);
}
