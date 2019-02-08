package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.MemberDAO;
import org.zerock.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime()throws Exception{
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setEmail("test06@gmail.com");
		vo.setUserid("test06");
		vo.setUserpw("test06");
		vo.setUsername("test06");
		dao.insertMember(vo);
	}
	
	@Test
	public void readMember() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setUserid("test00");
		String userid = vo.getUserid();
		dao.readMember(userid);
		System.out.println(dao.readMember(userid));
	}
}
