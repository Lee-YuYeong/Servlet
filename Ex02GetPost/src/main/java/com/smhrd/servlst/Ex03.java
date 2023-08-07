package com.smhrd.servlst;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getParameter()는 여러 개의 파라미터 중 한 개만 가져옴
//		getParameterValues() 여러 개의 파라마터 가지고 올 수 있음
		
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
//		String hobby = request.getParameter("hobby");
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println(job);
		System.out.println(gender);
		
		System.out.println(Arrays.toString(hobby));
		
		
	}

}
