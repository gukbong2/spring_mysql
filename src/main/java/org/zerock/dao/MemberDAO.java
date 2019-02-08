package org.zerock.dao;

import org.zerock.vo.MemberVO;

public interface MemberDAO {

	public String getTime();
	
	public void isnertMember(MemberVO vo);
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
