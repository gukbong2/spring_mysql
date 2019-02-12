package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}

/* HTTP 상태 코드 
 * 		===========================================현재 데이터의 처리 중인 상태
 * 		100 : 데이터의 일부를 서버가 받은 상태
 * 		
 *      ===========================================정상적인 응답
 * 		200 : 에러 없이 정상 처리
 * 		
 * 		204 : 정상 처리 되었으나 서버에서 보내 줄 데이터가 없음
 *  	
 *  	===========================================다른 URL 처리
 *  	301 : 요청된 페이지가 새 URL로 변경되었음
 *  
 *  	304 : 이미 기존의 데이터와 변경된 것이 없음
 *  
 *  	===========================================서버에서 인식 할 수 없음
 *  	400 : 전송된 Request에 문제가 있어서 서버가 인식할 수 없음
 * 			
 * 		403 : 서버에서 허락하지 않음
 * 
 * 		404 : URL에 해당하는 자원을 찾을 수 없음
 * 
 * 		406 : 전송 방식이 허락되지 않음(REST에서 자주 발생)
 * 		
 * 		===========================================서버 내부의 문제
 * 		500 : 서버에서 처리 시 문제가 발생
 * 		
 * 		502 : 게이트웨이나 프록시 상태의 문제(과부하 등)
 * 
 * 		503 : 일시적인 과부하나 서비스 중단 상태
 * 	
 * 		504 : 지정된 처리시간이 지나서 처리되지 못함
 * 		=================================================================
 *		
 * 
 * 
 * 
 * 
 * 
 */
