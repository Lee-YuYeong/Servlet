package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class LoginController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			
			WebMember member = new WebMember(email,pw,tel,address);
			System.out.println(member.getEmail());
			System.out.println(member.getAddress());
			WebMemberDAO dao = new WebMemberDAO();
			WebMember member2 = dao.login(member);
			//만약  없는 정보 입력 -> null값
			//System.out.println("닉네임 : "+member2.getNick());
			
			if(member!=null) {// 로그인 성공
				// 세션에 member2를 저장하고
				HttpSession session = request.getSession(); //세션 생성
				session.setAttribute("member",member2); //세션에 저장
				System.out.println("로그인 성공");
				
				url = "index.jsp";
				//System.out.println(member2.getEmail()+"님 환영합니다");
				
			}else {// 로그인 실패
				//login.html로 이동
				url = "index.jsp";
			}
			
		}catch(UnsupportedEncodingException e) {
			System.out.println("인코딩방식 잘못 지정함!");
		}catch(IOException e) {
			System.out.println("리다이렉팅경로 잘못 지정함!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
