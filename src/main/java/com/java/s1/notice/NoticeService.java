package com.java.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.s1.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
	
	//list
	public List<NoticeDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = noticeDAO.total(pager);
		pager.makeNum(totalCount);
		List<NoticeDTO> ar = noticeDAO.list(pager);
		
		return ar;
	}
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.detail(noticeDTO);
	}

}
