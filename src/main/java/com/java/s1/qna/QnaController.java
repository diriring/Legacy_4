package com.java.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//list 페이지
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(Model model) throws Exception {
		List<QnaDTO> ar = qnaService.list();
		model.addAttribute("qna", ar);
	}
	
	//detail
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
	}
	
	//insert 페이지
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() throws Exception {
		
	}
	
	//DB에 insert
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.add(qnaDTO);
		return "redirect:./list";
	}
	
	//update 페이지
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
	}
	
	//DB에 update
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:./list";
	}
	
	//delete
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
	
}
