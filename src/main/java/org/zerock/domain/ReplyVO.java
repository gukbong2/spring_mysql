package org.zerock.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class ReplyVO {

  private Integer rno;
  private Integer bno;
  private String replytext;
  private String replyer;

  private Date regdate;
  private Date updatedate;

 
}
