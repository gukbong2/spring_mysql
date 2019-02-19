package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.domain.MessageVO;
import org.zerock.persistence.MessageDAO;
import org.zerock.persistence.PointDAO;

public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private PointDAO pointDAO;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		messageDAO.create(vo);
		pointDAO.updatePoint(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String uid, Integer mno) throws Exception {
		messageDAO.updateState(mno);
		pointDAO.updatePoint(uid, 5);
		return messageDAO.readMessage(mno);
	}

}
