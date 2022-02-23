package com.java.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	//Controller -> Service -> DAO
	//DAO로 Data를 보내기 전에 전처리 작업
	//DAO에서 return받은 Data를 Controller로 보내기 전 후처리 작업
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//method는 DAO의 method와 거의 동일
	
	//add
	public int add(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.add(bankBookDTO);
	}
	
	//detail
	public BankBookDTO detail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.detail(bankBookDTO);
	}
	
	//list
	public List<BankBookDTO> list() throws Exception {
		//DAO 메서트 호출 전 전처리 작업
		//호출 후 후처리 작업
		List<BankBookDTO> ar = bankBookDAO.list();
		
		return ar;
		
	}
	
	//delete
	public int delete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.delete(bankBookDTO);
	}
	
	//update
	public int update(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.update(bankBookDTO);
	}
	
}
