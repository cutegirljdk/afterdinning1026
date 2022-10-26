package org.kosta.myproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Ajax 요청에 대한 응답을 담당하는 서블릿 
 *  페이지 응답이 아니라 필요한 데이터(String or JSON)만 응답하므로
 *  JSP 가 아니라 서블릿으로 구현한다 
 *  ex) 개별 컨트롤러 사용 예 
 *       request.setAttribute("responsebody","응답데이터");
 *       return "AjaxView"
 *       
 */
@WebServlet("/AjaxView")
public class AjaxViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(getServletName());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		// Ajax 응답이므로 필요한 데이터만 클라이언트로 전송하면 된다 
		out.print(request.getAttribute("responsebody"));
		out.close();
	}
}







