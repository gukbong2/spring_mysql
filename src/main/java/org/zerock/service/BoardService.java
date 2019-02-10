package org.zerock.service;

import java.util.List;

import org.zerock.vo.BoardVO;
import org.zerock.vo.PagingVO;

public interface BoardService {
	
	public void insertBoardService(BoardVO vo) throws Exception; //create
	
	public BoardVO readBoardService(Integer bno) throws Exception; //read
	
	public void updateBoardService(BoardVO vo) throws Exception; //update
	
	public void deleteBoardService(Integer bno) throws Exception; //delete
	
	public List<BoardVO> listBoardService() throws Exception; //listAll
	
	public List<BoardVO> listPageBoardPagingService(PagingVO page);
	
	public int listCountWithPagingVO(PagingVO page) throws Exception;
	
}
