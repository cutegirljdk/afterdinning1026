package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  client의 요청을 처리할 실제 컨트롤러 구현체를 캡슐화하는 인터페이스 -> 계층구조 형성을 통한 다형성 지원 
 */
public interface Controller {
	//인터페이스이므로 public abstract 자동 삽입 
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
