package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("member");
			
			//session.invalidate(); 전체 삭제
		}catch(Exception e){
			e.printStackTrace();
		}
		return "index.jsp";
	}

}
