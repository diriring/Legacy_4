package com.java.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.s1.board.BoardDTO;
import com.java.s1.board.BoardFileDTO;
import com.java.s1.board.BoardService;
import com.java.s1.util.FileManager;
import com.java.s1.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	public BoardFileDTO detailFile(BoardFileDTO boardFileDTO) throws Exception {
		return noticeDAO.detailFile(boardFileDTO);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(noticeDAO.total(pager));
		return noticeDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
//		long num = noticeDAO.seqNum();
//		boardDTO.setNum(num);
		int result = noticeDAO.add(boardDTO);
		//1. HDD에 저장
		for(int i=0;i<files.length;i++) {
			if(files[i].isEmpty()) {
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/notice/"); // 저장 경로 끝에 꼭 /
			//2. DB에 저장
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setNum(boardDTO.getNum());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriName(files[i].getOriginalFilename());
			result = noticeDAO.addFile(noticeFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.update(boardDTO);
	}
	
	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		// num으로 HDD에 저장된 파일 조회
		List<BoardFileDTO> ar = noticeDAO.listFile(boardDTO);
		int result = noticeDAO.delete(boardDTO);
		
		if(result > 0) {
			//for(Collection에서 꺼낼 타입명 변수명: Collection의 변수명) {}
			for(BoardFileDTO dto:ar) {				
				boolean check = fileManager.remove("resources/upload/notice/", dto.getFileName());
			}
		}
		
		return result;
	}
	
}
