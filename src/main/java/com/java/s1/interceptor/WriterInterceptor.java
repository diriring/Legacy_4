package com.java.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.java.s1.board.BoardDTO;
import com.java.s1.board.qna.QnaDAO;
import com.java.s1.board.qna.QnaDTO;
import com.java.s1.member.MemberDTO;

@Component
public class WriterInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("WriterInterceptor");
		
		boolean check = true;
		
		Long num = Long.parseLong(request.getParameter("num"));
		BoardDTO boardDTO = new QnaDTO();
		boardDTO.setNum(num);
		boardDTO = qnaDAO.detail(boardDTO);
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(!boardDTO.getWriter().equals(memberDTO.getId())) {
			check = false;
			request.setAttribute("message", "작성자가 아닙니다");
			request.setAttribute("path", "../qna/list");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return check;
	}
	
}
