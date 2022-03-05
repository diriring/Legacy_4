package com.java.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//list
	public List<QnaDTO> list() throws Exception {
		return qnaDAO.list();
	}
	
	//detail
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.detail(qnaDTO);
	}
	
	//insert
	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}
	
	//update
	public int update(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.update(qnaDTO);
	}
	
	//delete
	public int delete(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.delete(qnaDTO);
	}

}
