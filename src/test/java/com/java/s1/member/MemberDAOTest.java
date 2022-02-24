package com.java.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.s1.MyJunitTest;

public class MemberDAOTest extends MyJunitTest{
	
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void joinTest() throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID2");
		memberDTO.setPw("pw2");
		memberDTO.setName("name2");
		memberDTO.setPhone("010-2222-2222");
		memberDTO.setEmail("id2@gmail.com");
		
		int result = memberDAO.join(memberDTO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID2");
		memberDTO.setPw("wrongpw");
		
		memberDTO = memberDAO.login(memberDTO);
		
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void mypageTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID2");
		
		memberDTO = memberDAO.mypage(memberDTO);
		
		assertNotNull(memberDTO);
	}
	
	@Test
	public void updateTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("test1");
		memberDTO.setName("name4");
		memberDTO.setPhone("010-4444-4444");
		memberDTO.setEmail("name4@gmail.com");
		
		int result = memberDAO.update(memberDTO);
		
		assertEquals(1, result);
	}
	
}
