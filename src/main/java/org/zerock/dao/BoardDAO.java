package org.zerock.dao;

import java.util.List;

import org.zerock.vo.BoardVO;

public interface BoardDAO {
	public void insertBoard(BoardVO vo) throws Exception;
	
	public BoardVO readBoard(Integer bno) throws Exception;
	
	public void updateBoard(BoardVO vo) throws Exception;
	
	public void deleteBoard(Integer bno) throws Exception;
	
	public List<BoardVO> listBoard() throws Exception;
}
