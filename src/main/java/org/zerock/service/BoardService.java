package org.zerock.service;

import java.util.List;

import org.zerock.vo.BoardVO;

public interface BoardService {
	
	public void insertBoardService(BoardVO vo) throws Exception;
	
	public BoardVO readBoardService(Integer bno) throws Exception;
	
	public void updateBoardService(BoardVO vo) throws Exception;
	
	public void deleteBoardService(Integer bno) throws Exception;
	
	public List<BoardVO> listBoardService() throws Exception;
	
	
}
