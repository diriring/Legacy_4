package com.java.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
	
	//list
	public List<NoticeDTO> list() throws Exception {
		List<NoticeDTO> ar = noticeDAO.list();
		return ar;
	}
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.detail(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

}
