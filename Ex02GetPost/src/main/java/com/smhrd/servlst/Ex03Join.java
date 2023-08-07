package com.smhrd.servlst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03Join")
public class Ex03Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String pwright= request.getParameter("pwright");
		String gender=request.getParameter("gender");
		String bd=request.getParameter("bd");
		String birth=request.getParameter("birth");
		String[] hb = request.getParameterValues("hb");
		String color=request.getParameter("color");
		String content=request.getParameter("content");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("아이디 : "+id+"<br>");
		out.println("비밀번호 : "+pw+"<br>");
		
		if(pw.equals(pwright)) {
		
		}else {
		out.println("비밀번호가 일치하지 않습니다<br>");
				}
		out.println("성별 : "+gender+"<br>");
		out.println("혈액형 : "+bd+"<br>");
		out.println("생일 : "+birth+"<br>");
		out.print("취미:");
		for(int i=0; i<hb.length; i++) {
		out.print(hb[i]+" ");
		}
		out.println("<br>좋아하는 색 : "+color+"<br>");
		out.println("남기고 싶은 말 : "+content+"<br>");
	}

}
