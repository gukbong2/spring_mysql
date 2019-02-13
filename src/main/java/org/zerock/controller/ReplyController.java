package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import com.mysql.fabric.Response;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> regsiter(@RequestBody ReplyVO vo) {
		ResponseEntity<String> entity = null;
			
		try {
			replyService.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list (@PathVariable("bno") Integer bno) {
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(replyService.listReply(bno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH} )
	public ResponseEntity<String> update (@PathVariable("rno") Integer rno, @RequestBody ReplyVO vo) {
		ResponseEntity<String> entity = null;
		try {
			vo.setRno(rno);
			replyService.modifyReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
}


/*
 *	REST 방식의 처리에서 사용하는 애노테이션
 *		@PathVariable - URI의 경로에서 원하는 데이터를 추출하는 용도로 사용
 *		@RequestBody - 전송된 JSON 데이터를 객체로 변환해주는 애노테이션
 *			@ModelAttribute와 유사한 역할이지만, JSON에서 사용된다.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
