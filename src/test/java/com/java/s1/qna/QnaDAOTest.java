package com.java.s1.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.s1.MyJunitTest;

public class QnaDAOTest extends MyJunitTest {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void addTest() throws Exception {
		
		for(int i=3;i<250;i++) {
			QnaDTO qnaDTO = new QnaDTO();

			qnaDTO.setTitle("title"+i);
			qnaDTO.setContents("contents"+i);
			qnaDTO.setWriter("writer"+i);
			
			int result = qnaDAO.add(qnaDTO);
			
			if(i%10==0) {
				Thread.sleep(1000); //1초동안 멈추라는 뜻				
			}
		}
		
		System.out.println("Insert Finish");
		
		//assertEquals(1, result);
		
	}
	
	//@Test
	public void detailTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(1L);
		
		assertNotNull(qnaDAO.detail(qnaDTO));
	}

}
