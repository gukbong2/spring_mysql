package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dao.BoardDAO;
import org.zerock.vo.BoardVO;
import org.zerock.vo.PagingVO;
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void insertBoardService(BoardVO vo) throws Exception {
		dao.insertBoard(vo);
	}

	@Override
	public BoardVO readBoardService(Integer bno) throws Exception {
		return dao.readBoard(bno);
	}

	@Override
	public void updateBoardService(BoardVO vo) throws Exception {
		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoardService(Integer bno) throws Exception {
		dao.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> listBoardService() throws Exception {
		return dao.listBoard();
	}

	@Override
	public List<BoardVO> listPageBoardPagingService(PagingVO page) {
		return dao.listPageBoardPaging(page);
	}

	@Override
	public int listCountWithPagingVO(PagingVO page) throws Exception {
		return dao.countPaging(page);
	}
	
}
