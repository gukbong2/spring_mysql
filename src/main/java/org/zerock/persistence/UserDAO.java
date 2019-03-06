package org.zerock.persistence;

import org.zerock.domain.UserVO;
import org.zerock.dto.loginDTO;

public interface UserDAO {
	
	public UserVO login(loginDTO dto) throws Exception;
	
}
