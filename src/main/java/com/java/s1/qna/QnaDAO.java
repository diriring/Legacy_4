package com.java.s1.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.java.s1.qna.QnaDAO.";
	
	//list
	public List<QnaDTO> list() throws Exception {
		return sqlSession.selectList(NAMESPACE+"list");
	}
	
	//detail
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail", qnaDTO);
	}
	
	//insert
	public int add(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", qnaDTO);
	}
	
	//update
	public int update(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", qnaDTO);
	}
	
	//delete
	public int delete(QnaDTO qnaDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", qnaDTO);
	}
	
}
