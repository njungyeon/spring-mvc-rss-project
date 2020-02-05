package com.myprac.myapp.feed.dao;

import java.util.List;

import com.myprac.myapp.feed.FeedInfo;

public interface IFeedDao {
	int feedInsert(FeedInfo feedInfo, Number memIdx);
	List<FeedInfo> feedSelect(Number memIdx);
	int feedUpdate(FeedInfo feedInfo);
	int feedDelete(int urlIdx);
}
