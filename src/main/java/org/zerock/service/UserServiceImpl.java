package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.dto.loginDTO;
import org.zerock.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	
	private UserDAO dao;
	
	@Override
	public UserVO login(loginDTO dto) throws Exception {
		return dao.login(dto);
	}

}
