package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {

	  private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);

	  @Before("execution(* org.zerock.service.MessageService*.*(..))")
	  public void startLog(JoinPoint jp) {

	    logger.info("----------------------------");
	    logger.info("----------------------------");
	    logger.info(Arrays.toString(jp.getArgs()));
	    logger.info("----------------------------");
	    logger.info("----------------------------");
	  }
	  
	  @Around("execution(* org.zerock.service.MessageService*.*(..))")
	  public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		  
		  
		  
		  long startTime = System.currentTimeMillis();
		  logger.info(Arrays.toString(pjp.getArgs()));
		  
		  Object result = pjp.proceed();
		  
		  long endTime = System.currentTimeMillis();
		  
		  logger.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
		  
		  logger.info("=============================================================");
		  return result;
	  }

  }
	

/*
 * 	JoinPoint 기능 
 * 		1. Object[ ] getArgs() - 전달되는 모든 파라미터들을 Object의 배열로 가져온다
 * 		2. String getKind() - 해당 Advice의 타입을 알아낸다
 * 		3. Signature getSignature() - 실행하는 대상 객체의 메소드에 대한 정보를 알아 낼 때 사용
 * 		4. Object getTarget() - target객체를 알아낼 때 사용
 * 		5. Object getThis() - Advice를 행하는 객체를 알아낼 때 사용
 * 
 * 	Around
 * 		 - Advice의 종류에서 가장 강력하게 사용 할 수 있음.
 * 			다른 타입과 달리 메소드 실행에 직접 관여함.
 * 			메소드의 실행 전체르,ㄹ 앞, 뒤로 감싸서 특정한 기능을 실행할 수 있는 가장 강력한 타입
 * 			Around 타입의 기능은 파라미터로 ProceedingJoinPoint타입을 사용할 수 있음.
 * 				ProceedingJoinPoint - JoinPoint의 하위 인터페이스. JoinPoint의 모든 메소드를 가지면서
 * 				직접 target의 객체의 메소드를 실행할 수 있는 기능이 추가됨.
 * 
 * 				- Object proceed() - 다음 Advice를 실행하거나, 실제 target 객체의 메소드를 실행하는 기능
 * 
 *
 *
 */

