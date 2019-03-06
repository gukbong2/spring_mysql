package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession mybatis;
	
	private static String namespace ="org.zerock.mapper.MessageMapper";	
	
	@Override
	public void create(MessageVO vo) throws Exception {
		
		mybatis.insert(namespace+".create", vo);
	}

	@Override
	public MessageVO readMessage(Integer mid) throws Exception {

		return mybatis.selectOne(namespace+".readMessage", mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {

		mybatis.update(namespace+".upldateState", mid);

	}

}


