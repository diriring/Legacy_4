package com.java.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.s1.board.BoardDTO;
import com.java.s1.board.notice.NoticeDTO;
import com.java.s1.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//요청이 발생할 때 마다 실행됨
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO, ModelAndView mv) throws Exception {
		mv.addObject("dto", qnaDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.reply(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);
		
		return "board/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.add(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() throws Exception {
		return "board/add";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}

}
