package com.java.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.s1.MyJunitTest;
import com.java.s1.util.Pager;

public class BankBookDAOTest extends MyJunitTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	
	//List
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		List<BankBookDTO> ar = bankBookDAO.list(pager);
		
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(4).getBookNumber());
		
		assertEquals(5, ar.size());
	}
	
	//Insert
	//@Test
	public void addTest() throws Exception {
		
		for(int i=0;i<200;i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName" + i);
			bankBookDTO.setBookContents("Contents" + i);
			
			double rate = Math.random(); //0.0이상 1.0 미만의 double return
			rate = rate*1000;
			int r = (int)rate;
			rate = r/100.0;
			
			bankBookDTO.setBookRate(rate);
			bankBookDTO.setBookSale(1);
			int result = bankBookDAO.add(bankBookDTO);
			
			if(i%10==0) {
				Thread.sleep(1000); //1초동안 멈추라는 뜻				
			}
			
		}
		
		System.out.println("Insert Finish");
		
		//assertEquals(1, result);	
	}
	
	//Detail
//	@Test
//	public void detailTest() throws Exception {
//		
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO = bankBookDAO.detail(1L);
//		
//		assertNotNull(bankBookDTO);
//		
//	}
	
	//Delete
	//@Test
	public void deleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}

}
