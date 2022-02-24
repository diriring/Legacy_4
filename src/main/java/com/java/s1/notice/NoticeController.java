package com.java.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//DB에 업데이트
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:./list";
	}
	
	//update 페이지 이동
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.add(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.list();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(Model model, NoticeDTO noticeDTO) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}

}
