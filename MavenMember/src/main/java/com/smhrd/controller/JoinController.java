package com.smhrd.controller;



import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class JoinController implements Command {

	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String url = "";
		try {
			request.setCharacterEncoding("UTF-8");
			
			String email = request.getParameter("email");
			String pw= request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			
			WebMember member = new WebMember(email,pw,tel,address);
			
			// 데이터 베이스와 연동해서 값 넣어주기!(myBatis 활용)
			WebMemberDAO dao = new WebMemberDAO(); // SqlSessionFactory생성
			int cnt = dao.join(member); // 회원가입 기능
						
			if(cnt>0) {
			//회원가입 성공
			// request영역애 회원가입 시 입력한 이메일 추가 저장
			request.setAttribute("joinEmail", email);
			System.out.println("회원가입 성공");
			url = "joinSuccess.jsp";
			}else {
			System.out.println("회원가입 실패");
			url = "index.jsp";
			}
				
			
			
		}catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 방식 잘못 지정");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return url;
	}

}
