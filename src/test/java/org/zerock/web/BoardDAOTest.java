package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.BoardDAO;
import org.zerock.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testInsert() throws Exception {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("jnuit테스트");
		vo.setContent("junit테스트");
		vo.setWriter("junit테스트");
		dao.insertBoard(vo);
	}
	
	@Test
	public void testRead() throws Exception {
		System.out.println(dao.readBoard(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		
		vo.setBno(2);
		vo.setTitle("junit에서 수정");
		vo.setContent("junit에서 수정");
		dao.updateBoard(vo);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.deleteBoard(36);
	}
}
