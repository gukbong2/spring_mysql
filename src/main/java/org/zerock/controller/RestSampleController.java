package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

@RestController
@RequestMapping("/sample")
public class RestSampleController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setFirstName("방");
		sample.setLastName("국봉");
		sample.setMno(1);
		
		return sample;
	}
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			SampleVO sample = new SampleVO();
			sample.setFirstName("방");
			sample.setLastName("국봉");
			sample.setMno(1);
			list.add(sample);
		}
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> map = new HashMap<>();
		
		
		for (int i = 0; i < 10; i++) {
			SampleVO sample = new SampleVO();
			sample.setFirstName("방");
			sample.setLastName("국봉");
			sample.setMno(i);
			map.put(i, sample);
		}
		return map;
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/sendErrorNot") 
	public ResponseEntity<List<SampleVO>> sendListNot() {
		List<SampleVO> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				SampleVO sample = new SampleVO();
				sample.setFirstName("방");
				sample.setLastName("국봉");
				sample.setMno(i);
				list.add(sample);
		}
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
}
/* REST = Representational State Transfer의 약어
 * 		하나의 URI는 하나의 고유한 리소스를 대표하도록 설계된다는 개념
 * 		서버에 접근하는 기기의 종류가 다양해 지면서 다양한 기기에서 공통으로 데이터를 처리할 수 있는 규칙을 만드는 개념
 * 		REST 방식 : 특정한 URI는 반드시 그에 상응하는 데이터 자체라는 것을 의미
 * 			ex) '/boards/123'은 게시물 중에서 123번 이라는 고유의 의미를 가지도록 설계하고, 이에 대한 처리는 GET, POST 방식과 같이 추가적인 정보를 통해서 결정
 * 
 * REST API = 외부에서 위와 같은 방식으로 특정 URI를 통해 사용자가 원하는 정보를 제공하는 방식
 * 		pen API에서 많이 사용 되면서 REST 방식으로 제공되는 외부 연결 URI를 REST API라고 하고, REST 방식의 서비스 제공이 가능한 것을 'Restful' 하다고 표현한다.
 * 
 * @RestController = 기존의 특정한 JSP와 같은 뷰를 만들어 내는 것이 목적이 아닌 REST 방식의 데이터를 처리하기 위한 애노테이션
 * 		스프링3에서는 컨트롤러 = @Controller를 사용하고, 데이터 자체를 서비스 하려면 해당 메소드나 리턴 타입에 @ResponseBody 애노테이션을 추가하는 형태로 작성
 * 		스프링4에서는 이러한 불편함과, 컨트롤러 자체의 용도를 지정한다는 애노테이션인 @RestController가 생김
 * 			ps : @RestController = @Controller + @ResponseBody	
 * 
 * @RestController 용도 = 문자열, JSON, XML등의 데이터를 반환하는 역할
 * 
 * 		ps2 : pom.xml 추가 : jackson-databind
 * 
 * 	
 * 
 * 
 * 
 */ 
