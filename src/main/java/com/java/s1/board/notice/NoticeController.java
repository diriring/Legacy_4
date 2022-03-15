package com.java.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java.s1.board.BoardDTO;
import com.java.s1.board.BoardFileDTO;
import com.java.s1.board.qna.QnaDTO;
import com.java.s1.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	
	@RequestMapping(value="photoDown", method=RequestMethod.GET)
	public ModelAndView photoDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardFileDTO = noticeService.detailFile(boardFileDTO);
		mv.addObject("file", boardFileDTO);
		mv.setViewName("fileDown");
		return mv;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, MultipartFile [] files) throws Exception {
		int result = noticeService.add(noticeDTO, files);
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "board/add";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, Pager pager) throws Exception {
		List<BoardDTO> ar = noticeService.list(pager);
		model.addAttribute("list", ar);
		return "board/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(Model model, NoticeDTO noticeDTO) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		//자식 타입으로 만든 것을 부모 타입에 담은 것
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
		return "redirect:./list";
	}

}
