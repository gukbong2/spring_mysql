package org.zerock.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	
	
	private String userid, userpw, username, email;
	private Date regdate, updatedate;
}
