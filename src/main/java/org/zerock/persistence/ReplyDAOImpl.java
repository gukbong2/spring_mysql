package org.zerock.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession mybatis;
	private static String namespace ="org.zerock.mapper.ReplyMapper";
	
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectList(namespace + ".list", bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		mybatis.insert(namespace + ".create", vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		mybatis.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		mybatis.delete(namespace + ".delete", rno); 
	}

}
