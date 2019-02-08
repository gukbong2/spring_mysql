package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.BoardService;
import org.zerock.vo.BoardVO;

@Controller
//@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard", method = RequestMethod.GET)
	public String registerGET(BoardVO vo, Model model) throws Exception {
		logger.info("register get~~~");
		return "/board/insertBoard";
	}
	
	@RequestMapping(value="/insertBoard", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, Model model) throws Exception {
		logger.info("register post~~~");
		logger.info(vo.toString());
		boardService.insertBoardService(vo);
		model.addAttribute("result", "success");
		
		return "redirect:/board/success";
	}
	
}


// GET 방식과 POST방식

// GET : 항상 사용자가 직접 브라우저에서 접근이 가능할 때 사용.

//POST : 항상 외부에서 많은 정보를 입력하는 경우에서 사용.
//		브라우저상에서 주소창에 보여지면 안 되는 정보를 전송하는데 처리!!