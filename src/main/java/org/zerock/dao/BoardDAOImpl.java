package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.BoardVO;
import org.zerock.vo.PagingVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession mybatis;
	
	private static String namespace = "org.zerock.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		mybatis.insert(namespace+".insertBoard", vo);
	}

	@Override
	public BoardVO readBoard(Integer bno) throws Exception {
		return mybatis.selectOne(namespace+".readBoard", bno);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		mybatis.update(namespace+".updateBoard", vo);
	}

	@Override
	public void deleteBoard(Integer bno) throws Exception {
		mybatis.delete(namespace+".deleteBoard", bno);
	}

	@Override
	public List<BoardVO> listBoard() throws Exception {
		return mybatis.selectList(namespace+".listBoard");
	}

	@Override
	public List<BoardVO> listPageBoard(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		return mybatis.selectList(namespace+".listPageBoard", page);
	}

	@Override
	public List<BoardVO> listPageBoardPaging(PagingVO page) {
		return mybatis.selectList(namespace+".listPageBoardPaging", page);
	}

	@Override
	public int countPaging(PagingVO page) throws Exception {
		return mybatis.selectOne(namespace+".countPaging", page);
	}

	

}
