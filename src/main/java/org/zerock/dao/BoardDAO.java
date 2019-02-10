package org.zerock.dao;

import java.util.List;

import org.zerock.vo.BoardVO;
import org.zerock.vo.PagingVO;

public interface BoardDAO {
	public void insertBoard(BoardVO vo) throws Exception; //create
	
	public BoardVO readBoard(Integer bno) throws Exception; //read
	
	public void updateBoard(BoardVO vo) throws Exception; //update
	
	public void deleteBoard(Integer bno) throws Exception; //delete
	
	public List<BoardVO> listBoard() throws Exception; //listAll
	
	public List<BoardVO> listPageBoard(int page) throws Exception;

	public List<BoardVO> listPageBoardPaging(PagingVO page);
	
	public int countPaging(PagingVO page) throws Exception;
	
}
