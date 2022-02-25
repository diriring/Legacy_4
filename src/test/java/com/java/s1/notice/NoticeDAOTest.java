package com.java.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.s1.MyJunitTest;
import com.java.s1.util.Pager;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void check() {
		assertNotNull(noticeDAO);
	}
	
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<NoticeDTO> ar = noticeDAO.list(pager);
		System.out.println(ar.get(0).getNoticeNum());
		assertEquals(10, ar.size());
	}
	
	//@Test
	public void addTest() throws Exception {
		for(int i=3;i<150;i++) {
			
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("title"+i);
			noticeDTO.setContents("contents"+i);
			noticeDTO.setWriter("writer"+i);
			
			int result = noticeDAO.add(noticeDTO);
			
			if(i%10==0) {
				Thread.sleep(1000); //1초동안 멈추라는 뜻				
			}
		}
		
		System.out.println("Insert Finish");
		
		//assertNotEquals(0, result);
	}
	
	//@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(3L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	//@Test
	public void deleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(3L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}

}
