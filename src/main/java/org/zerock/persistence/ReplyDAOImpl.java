package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

  @Inject
  private SqlSession mybatis;

  private static String namespace = "org.zerock.mapper.ReplyMapper";

  @Override
  public List<ReplyVO> list(Integer bno) throws Exception {

    return mybatis.selectList(namespace + ".list", bno);
  }

  @Override
  public void create(ReplyVO vo) throws Exception {

	  mybatis.insert(namespace + ".create", vo);
  }

  @Override
  public void update(ReplyVO vo) throws Exception {

	  mybatis.update(namespace + ".update", vo);
  }

  @Override
  public void delete(Integer rno) throws Exception {

	  mybatis.update(namespace + ".delete", rno);
  }

  @Override
  public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {

    Map<String, Object> paramMap = new HashMap<>();

    paramMap.put("bno", bno);
    paramMap.put("cri", cri);

    return mybatis.selectList(namespace + ".listPage", paramMap);
  }

  @Override
  public int count(Integer bno) throws Exception {

    return mybatis.selectOne(namespace + ".count", bno);

  }

  @Override
  public int getBno(Integer rno) throws Exception {

    return mybatis.selectOne(namespace + ".getBno", rno);
  }
  
  
}
