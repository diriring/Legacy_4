package com.java.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.s1.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(Model model, Pager pager) throws Exception {
		List<NoticeDTO> ar = noticeService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(Model model, NoticeDTO noticeDTO) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}

}
