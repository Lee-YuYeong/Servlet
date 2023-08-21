package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *.do 요청을 모두 받아줄 컨트롤러(프론트 컨트롤러)
//web.xml에서 매핑 값 *.do로 수정해줘야 함!!
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String,Command> list =null;
	public void init(ServletConfig config) throws ServletException {
		
		list = new HashMap<>(); //실제 구현은 HashMap형태로
		list.put("/join.do", new JoinController());
		list.put("/login.do" ,new LoginController());
		list.put("/logout.do" ,new LogoutController());
		list.put("/update.do" ,new UpdateController());
		list.put("/delete.do" ,new DeleteController());
		
		
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqUri = request.getRequestURI(); //전체 경로
		String contextPath = request.getContextPath(); // 서비스 경로
		String key = reqUri.substring(contextPath.length()); //  /*.do
		
		Command controller = list.get(key); 
		String desUrl = controller.process(request, response);
		System.out.println(desUrl);
		
		if(desUrl.equals("joinSuccess.jsp")) {
			//forwarding
			RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			rd.forward(request,response);	
		}else {
			response.sendRedirect(desUrl);
		}
		
	
		
		
	}

}
