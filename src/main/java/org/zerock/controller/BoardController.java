package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
		return "/board/boardInsert";
	}
	
	@RequestMapping(value="/insertBoard", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("register post~~~");
		logger.info(vo.toString());
		boardService.insertBoardService(vo);
		//model.addAttribute("result", "SUCCESS");
		
		rttr.addFlashAttribute("msg", "success");	
		//리다이렉트 어트리부트를 사용하면 uri상에서 데이터가 숨겨져서 표시된다.
		return "redirect:/listBoard";
	}
	
	@RequestMapping(value="/listBoard", method=RequestMethod.GET)
	public String listBoardGET(Model model) throws Exception {
		logger.info("show boardList ...");
		model.addAttribute("BoardList", boardService.listBoardService());
		return "/board/boardList";
	}
	
	@RequestMapping(value="/readBoard", method=RequestMethod.GET) 
	public String readBoardGET(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(boardService.readBoardService(bno));
		//addAttribute 할 때 이름없이 데이터를 넣으면 자동으로 클래스의 이름을 소문자로 시작해서 사용하게 됨.
		//위의 코드에 들어가는 데이터는 BoardVO 클래스의 객체이므로, 'boardVO'라는 이름으로 저장하게 됨.
		return "/board/boardRead";
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteBoardPOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		boardService.deleteBoardService(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/listBoard";
	}
	
	@RequestMapping(value="/updateBoard", method=RequestMethod.GET) 
	public String updateBoardGET(int bno, Model model) throws Exception {
		model.addAttribute(boardService.readBoardService(bno));
		return "/board/boardUpdate";
	}
	
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST) 
	public String updateBoardPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("updateBoard Post...");
		boardService.updateBoardService(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/listBoard";
	}
	
}


// GET 방식과 POST방식

// GET : 항상 사용자가 직접 브라우저에서 접근이 가능할 때 사용.

//POST : 항상 외부에서 많은 정보를 입력하는 경우에서 사용.
//		브라우저상에서 주소창에 보여지면 안 되는 정보를 전송하는데 처리!!