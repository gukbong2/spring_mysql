package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.UserVO;
import org.zerock.dto.loginDTO;


@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession mybatis;
	
	private static String namespace = "org.zerock.mapper.UserMapper";
	
	@Override
	public UserVO login(loginDTO dto) throws Exception {
		return mybatis.selectOne(namespace + ".login", dto);
	}

}
