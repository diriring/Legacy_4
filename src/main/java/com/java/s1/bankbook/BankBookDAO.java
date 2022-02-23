package com.java.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESAPCE="com.java.s1.bankbook.BankBookDAO.";

	//detail
	public BankBookDTO detail(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.selectOne(NAMESAPCE+"detail", bankBookDTO);
	}
	
	//list
	public List<BankBookDTO> list() throws Exception {
		return sqlSession.selectList(NAMESAPCE+"list");
	}
	
	//insert
	public int add(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.insert(NAMESAPCE+"add", bankBookDTO);
	}
	
	//delete
	public int delete(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESAPCE+"delete", bankBookDTO);
	}
	
	//update
	public int update(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESAPCE+"update", bankBookDTO);
	}
	
}
