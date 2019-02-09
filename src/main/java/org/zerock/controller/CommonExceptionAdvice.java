package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errorModelAndView(Exception e) {
		logger.info(e.toString());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/error_common");
		mav.addObject("exception", e);
		
		return mav;
		
		/*
		 * 	@ControllerAdvice - 호출되는 메소드에서 발생된 Excpetion을 모두 처리하는 역할
		 * 	
		 */
	}
	
}
