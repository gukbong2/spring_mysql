package org.zerock.web;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.dao.BoardDAO;
import org.zerock.service.BoardService;
import org.zerock.vo.BoardVO;
import org.zerock.vo.PagingVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;
	@Autowired
	private BoardService boardService;
	
//	@Test
//	public void testInsert() throws Exception {
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("jnuit테스트");
//		vo.setContent("junit테스트");
//		vo.setWriter("junit테스트");
//		dao.insertBoard(vo);
//	}
//	
//	@Test
//	public void testRead() throws Exception {
//		logger.info(dao.readBoard(1).toString());
//	}
//	
//	@Test
//	public void testUpdate() throws Exception {
//		BoardVO vo = new BoardVO();
//		
//		vo.setBno(2);
//		vo.setTitle("junit에서 수정");
//		vo.setContent("junit에서 수정");
//		dao.updateBoard(vo);
//	}
//	
//	@Test
//	public void testDelete() throws Exception {
//		dao.deleteBoard(36);
//	}
//	
//	@Test
//	public void tesetLisgPage() throws Exception {
//		int page = 0;
//		List<BoardVO> list = dao.listPageBoard(page);
//		
//		System.out.println("==========================");
//		for (BoardVO boardVO : list) {
//			System.out.println(boardVO.getBno() + " : " + boardVO.getTitle());
//		}
//		System.out.println("==========================");
//	}
//	
//	@Test
//	public void listPageBoardPaging() throws Exception {
//		PagingVO p = new PagingVO();
//		p.setPage(0);
//		p.setPerPageNum(10);
//		
//		List<BoardVO> list = boardService.listPageBoardPagingService(p);
//		
//		System.out.println("PagingVO==========================");
//		for (BoardVO boardVO : list) {
//			logger.info(boardVO.getBno() + " : " + boardVO.getTitle());
//		}
//		System.out.println("PagingVO==========================");
//	}
//
//	@Test
//	public void testURI() throws Exception {
//		
//		UriComponents uriComponents = UriComponentsBuilder.newInstance()
//				.path("/board/boardRead")
//				.queryParam("bno", 12)
//				.queryParam("perPageNum", 20)
//				.build();
//		
//		logger.info("/board/boardRead?bno=12&perPageNum=20");
//		logger.info(uriComponents.toString());
//	}
	
	@Test
	public void testURI2() throws Exception {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/{module/{page}")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("board", "boardRead")
				.encode();
		
		logger.info("/board/boardRead?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	
}
