package com.java.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.s1.MyJunitTest;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void check() {
		assertNotNull(noticeDAO);
	}
	
	//@Test
	public void listTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.list();
		assertEquals(0, ar.size());
	}
	
	//@Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("title");
		noticeDTO.setContents("contents");
		noticeDTO.setWriter("writer");
		
		int result = noticeDAO.add(noticeDTO);
		
		assertNotEquals(0, result);
	}
	
	@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(3L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	//@Test
	public void deleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(4L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}

}
