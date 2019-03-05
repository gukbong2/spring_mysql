package org.zerock.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class MessageVO {

	private Integer mid;
	private String targetid;
	private String sender;
	private String message;
	private Date opendate;	
	private Date senddate;
	
	
}


 
