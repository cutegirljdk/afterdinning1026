package org.kosta.myproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front Controller Design Pattern  : 클라이언트의 요청을 하나의 진입점으로 모아서 처리
 * 										 공통 정책 ( 인코딩 ,예외 처리, 인증.. 등 )	을 효과적으로 처리 할 수 있다 
 * 										 (ex-은행 콜센터 , 키오스크 )
 *																								 
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				String servletPath=request.getServletPath();
				String controllerName=servletPath.substring(1,servletPath.length()-3); // 1부터는 /슬래쉬 가 빠져서..
				//System.out.println(getServletName()+"controllerName:"+controllerName); 
				
				//Controller Interface 로 캡슐화 , 계층구조 형성하였으므로 다양한 하위 컨트롤러 객체 들을 
				//단일한 소통 방식으로 제어할 수 있다 -> 다형성 지원 
				Controller controller=HandlerMapping.getInstance().create(controllerName); // 담당 컨트롤러 객체를 생성하는 controllerName을 넘겨줘서 핸들러 맵핑에서 객체를 생성해주는 역할 상위 Controller 인터페이스에게넘겨준다
				//System.out.println(getServletName()+"개별 컨트롤러 구현체:"+controller);
				
				String viewPath=controller.handleRequest(request,response);
				//해당 컨트롤러의 (checkidcontroller)핸들 리퀘스트를 실행해서 path를 여기다가 반환한다. 
 				if(viewPath.startsWith("redirect:")) {  //이방식일 때는 redirect 으로 응답 (기존 request,response 유지하지 않는다 )
						response.sendRedirect(viewPath.substring(9));
				}else { // 나머지는 forward 방식으로 응답 (기존 request, response  유지한다)
					request.getRequestDispatcher(viewPath).forward(request, response);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp"); // 공통정책 예외 처리 .. 예외가 났을때 일루보냄
						
			}
				
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doDispatch(request,response);
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					request.setCharacterEncoding("utf-8");
					doDispatch(request, response);
	}
}
