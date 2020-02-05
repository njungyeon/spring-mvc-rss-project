package com.myprac.myapp.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprac.myapp.feed.FeedInfo;
import com.myprac.myapp.feed.dao.FeedDao;

@Service
public class FeedService implements IFeedService {
	
	@Autowired
	FeedDao dao;
	
	@Override
	public void feedRegister(FeedInfo feedInfo, Number memIdx) {
		int result = dao.feedInsert(feedInfo, memIdx);
		
		if(result == 0) {
			System.out.print("insert feed fail..");
		}else {
			System.out.print("insert feed success!");
		}
	}

	@Override
	public List<FeedInfo> feedSearch(Number memIdx) {
		List<FeedInfo> result = dao.feedSelect(memIdx);
		
		return result;
	}

	@Override
	public void feedModify(FeedInfo feedInfo) {
		
		int result = dao.feedUpdate(feedInfo);
		if(result == 0) {
			System.out.print("modify feed fail..");
		}else {
			System.out.print("modify feed success!");
		}
	}

	@Override
	public void feedRemove(int urlId) {
		//printMembers(dao.feedDelete(feedInfo));
		
		int result = dao.feedDelete(urlId);
		
		if(result == 0) {
			System.out.print("delete feed fail..");
		}else {
			System.out.print("delete feed success!");
		}
	}
	

}
