package com.java.s1.board.notice.noticeReply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/noticeReply/**")
public class NoticeReplyController {

	@Autowired
	private NoticeReplyService noticeReplyService;
	
	//@RequestMapping(value="add", method=RequestMethod.POST)
	@PostMapping("add")
	public ModelAndView add(NoticeReplyDTO noticeReplyDTO) throws Exception {
		int result = noticeReplyService.add(noticeReplyDTO);
		System.out.println("add");
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;//"redirect:../notice/list";
	}
	
	@GetMapping("list")
	public ModelAndView list(NoticeReplyDTO noticeReplyDTO) throws Exception {
		System.out.println("List");
		System.out.println(noticeReplyDTO.getNum());
		List<NoticeReplyDTO> ar = noticeReplyService.list(noticeReplyDTO);
		
		System.out.println(ar);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("noticeReply", ar);
		mv.setViewName("common/noticeReply");
		
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView delete(NoticeReplyDTO noticeReplyDTO) throws Exception {
//		System.out.println("delete");
//		System.out.println(noticeReplyDTO.getReplyNum());
		int result = noticeReplyService.delete(noticeReplyDTO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(NoticeReplyDTO noticeReplyDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(noticeReplyDTO.getContents());
		System.out.println(noticeReplyDTO.getReplyNum());
		int result = noticeReplyService.update(noticeReplyDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}
