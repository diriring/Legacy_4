package com.java.s1.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.s1.MyJunitTest;

public class QnaDAOTest extends MyJunitTest {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
	public void addTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title");
		qnaDTO.setContents("contents");
		qnaDTO.setWriter("writer");
		
		int result = qnaDAO.add(qnaDTO);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void detailTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(1L);
		
		assertNotNull(qnaDAO.detail(qnaDTO));
	}

}
