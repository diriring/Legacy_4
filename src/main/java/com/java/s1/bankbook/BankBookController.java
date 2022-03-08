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
	public String detail(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.detail(bankBookDTO);
		
		//조회가 성공하면 출력
		//조회가 실패하면 alert로 없는 번호입니다 -> list로 이동
		//common/result.jsp 활용
		
		String path = "common/result";

		if(bankBookDTO != null) {
			path = "bankbook/detail";
			model.addAttribute("dto", bankBookDTO);
		}else {
			model.addAttribute("path", "./list");
			model.addAttribute("message", "조회에 실패했습니다");
		}		
		
		return path;
	}
	
	//delete
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO, Model model) throws Exception {
		int result = bankBookService.delete(bankBookDTO);
		String path = "common/result";
		
		if(result != 0) {
			model.addAttribute("message", "삭제 성공했습니다");
			model.addAttribute("path", "./list");
		}else {
			model.addAttribute("message", "삭제 실패했습니다");
			model.addAttribute("path", "./list");
		}
		return path;
	}
	
}
