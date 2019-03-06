package org.zerock.service;

import org.zerock.domain.UserVO;
import org.zerock.dto.loginDTO;

public interface UserService {
	public UserVO login(loginDTO DTO) throws Exception;
}
