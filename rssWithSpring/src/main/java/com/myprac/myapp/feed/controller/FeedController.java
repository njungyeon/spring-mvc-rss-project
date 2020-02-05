package com.myprac.myapp.feed.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myprac.myapp.feed.FeedInfo;
import com.myprac.myapp.feed.service.FeedService;
import com.myprac.myapp.member.Member;

@Controller
@RequestMapping("/feed")
public class FeedController {
	
	@Autowired
	FeedService feedService;
	
	@ModelAttribute("cp") //ModelAttribute를 설정하면 다른 함수들을 부를때도 함께 호출된다. 또한 view 단에서는 여기에 설정한 이름으로 값을 호출가능하다.
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	
	@RequestMapping("/")
	public String mainPage(FeedInfo feedInfo) {
		System.out.println("is mainPage here?");
		return "/feed/main";
	}
	
	@RequestMapping("/showForm")
	public String showForm(FeedInfo feedInfo) {
		System.out.println("is showForm here?");
		return "/feed/feedForm";
	}	
	
	
	@RequestMapping(value = "/addRssUrl", method = RequestMethod.POST)
	public ModelAndView addRssUrl(FeedInfo feedInfo, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		feedService.feedRegister(feedInfo, member.getMemIdx());
		
		mav.setViewName("redirect:/feed/showFeed");
		mav.addObject("nickname", member.getMemNickname());
		
		return mav;
	}
	
	@RequestMapping(value = "/showFeed")
	public ModelAndView showFeed(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		List<FeedInfo> feedInfos = feedService.feedSearch(member.getMemIdx());
		
		mav.addObject("nickname", member.getMemNickname());
		mav.addObject("feedInfos", feedInfos);
		mav.setViewName("/feed/showFeeds");
		
		return mav;
	}
	
	@RequestMapping(value = "/showDetail")
	public ModelAndView showDetail(HttpServletRequest request) throws IOException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		List<FeedInfo> feedInfos = feedService.feedSearch(member.getMemIdx());
	
		mav.addObject("nickname", member.getMemNickname());
		mav.addObject("feedInfos", feedInfos);
		mav.setViewName("/feed/showFeeds");
		
		return mav;
	}
	

	@RequestMapping(value = "/urlDelete", method = RequestMethod.POST)
	public ModelAndView urlDelete(FeedInfo feedInfo,
			@RequestParam("rowIdx") int rowIdx) {

		ModelAndView mav = new ModelAndView();
		System.out.println("rowIdx : " + rowIdx);
		System.out.println("feedInfo.getId : " + feedInfo.getId());
		System.out.println("feedInfo.getDesc : " + feedInfo.getDesc());
		
		//이부분 추후에는 model값 자체로 가져올 수 있도록 jsp 파일 수정하자....힘들다....
		
		feedService.feedRemove(rowIdx);
		
		mav.setViewName("redirect:/feed/showFeed");
		
		return mav;
	}
	
	@RequestMapping(value = "/modifyForm", method = RequestMethod.POST)
	public ModelAndView modifyForm(HttpServletRequest request,
			@RequestParam(value="rowIdx", required=false) int rowIdx) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		List<FeedInfo> feedInfos = feedService.feedSearch(member.getMemIdx());
		
		mav.addObject("feedInfo", feedInfos.get(rowIdx-1));
		mav.setViewName("/feed/modifyForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/urlModify", method = RequestMethod.POST)
	public ModelAndView urlModify(FeedInfo feedInfo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();		
		feedService.feedModify(feedInfo);
		mav.setViewName("redirect:/feed/showFeed");
		
		return mav;
	}
	
}
