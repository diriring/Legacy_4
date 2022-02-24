package com.java.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.s1.util.Pager;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//update 이동
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.detail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	//DB에 update
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.update(bankBookDTO);
		return "redirect:./list";
	}
	
	//DB에 insert
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.add(bankBookDTO);
		return "redirect:./list";
	}
	
	//insert
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() {
		
	}

	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		List<BankBookDTO> ar = bankBookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("bankbook/list");
		return mv;
	}
	
	//detail
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.detail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	//delete
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.delete(bankBookDTO);
		return "redirect:./list";
	}
	
}
