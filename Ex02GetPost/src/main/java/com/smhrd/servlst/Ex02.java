package com.smhrd.servlst;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		GET/POST 한글 인코딩 방식
//		POST : 패킷의 바디부분에 실어져서 전송
//		따라서 패킷이 넘어올 떄마다 인코딩 방식을 지정해줘야 함 
//		즉 요청이 들어올 떄마다 지정해줘야 함
//		setCharacterEncoding()은 getParameter()전에 해줘야 함
		request.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩=>POST사용 시 필수
		
		
//		GET : GET방식은 URL에 실어서 데이터 전송
//		따라서 파라미터를 인코딩하고 싶다면 URI를 인코딩해줘야 함
//		Servers/server.xml->URIEncoding이 UTF-8
//		URIEncoding이 UTF-8로 되어있기 때문에 생략 가능
		
		String name = request.getParameter("name");
		
		System.out.println(name);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(name);
		
		
	}

}
