package org.zerock.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserVO {

  private String uid;
  private String upw;
  private String uname;
  private int upoint;

}
