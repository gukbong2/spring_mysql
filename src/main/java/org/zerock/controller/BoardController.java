package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService boardService;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void registerGET(BoardVO board, Model model) throws Exception {

    logger.info("register get ...........");
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

    logger.info("regist post ...........");
    logger.info(board.toString());

    boardService.regist(board);

    rttr.addFlashAttribute("msg", "success");
    return "redirect:/board/listPage";
  }


  

  @RequestMapping(value = "/remove", method = RequestMethod.POST)
  public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

    boardService.remove(bno);

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:/board/listAll";
  }

  @RequestMapping(value = "/listCri", method = RequestMethod.GET)
  public void listAll(Criteria cri, Model model) throws Exception {

    logger.info("show list Page with Criteria......................");

    model.addAttribute("list", boardService.listCriteria(cri));
  }

  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
  public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {

    logger.info(cri.toString());

    model.addAttribute("list", boardService.listCriteria(cri));
    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);
    // pageMaker.setTotalCount(131);

    pageMaker.setTotalCount(boardService.listCountCriteria(cri));

    model.addAttribute("pageMaker", pageMaker);
  }

  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
  public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {

    model.addAttribute(boardService.read(bno));
  }

  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
  public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {

    boardService.remove(bno);

    rttr.addAttribute("page", cri.getPage());
    rttr.addAttribute("perPageNum", cri.getPerPageNum());
    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:/board/listPage";
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
  public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)
      throws Exception {

    model.addAttribute(boardService.read(bno));
  }

  @RequestMapping(value="/modifyPage", method=RequestMethod.POST) 
	public String updateBoardPOST(BoardVO vo, RedirectAttributes rttr, Criteria cri) throws Exception {
		logger.info("updateBoard Post...");
		boardService.modify(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
  
}

/*================================================================================================================
 * GET 방식과 POST방식
 *
 * GET : 항상 사용자가 직접 브라우저에서 접근이 가능할 때 사용.
 *
 * POST : 항상 외부에서 많은 정보를 입력하는 경우에서 사용.
 *		브라우저상에서 주소창에 보여지면 안 되는 정보를 전송하는데 처리!!
 *
 *================================================================================================================
 * 페이징 처리의 원칙
 * 	
 * 1.페이징 처리는 반드시 GET방식!!
 *  	1-1. 다른사람에게 URL로 전달하는 경우가 많기에 GET방식으로 해야함.
 *  		(사실 모든 조회는 GET방식을 사용해야 한다!!!)
 *  
 * 2.페이징 처리가 되면 조회 화면에서 반드시 '목록으로 가기' 필요
 *  	ex)3페이지를 보다가 특정게시물을 보았다면, 다시 '목록으로 가기' 버튼을 눌러서 3페이지로 이동하는 기능 구현
 *  
 *  
 * 
 * 
 * 
 *
 */
