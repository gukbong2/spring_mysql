package org.zerock.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BoardVO {
	private Integer bno;
	private int viewcnt;
	private String title, content, writer;
	private Date regdate;
	
}
