package org.zerock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class loginDTO {
	private String uid;
	private String upw;
	private boolean useCookie;
	
	
}
