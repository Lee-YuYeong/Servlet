package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class UpdateController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url ="";
		try {
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			WebMember member = (WebMember)session.getAttribute("member"); // 수정 전
			String email = member.getEmail();
			
			// 수정 후 정보
			String pw = request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			
			WebMember updateMember = new WebMember(email,pw,tel,address);
			
			WebMemberDAO dao = new WebMemberDAO();
			int cnt = dao.update(updateMember);
			
			if(cnt>0) {
				//수정 성공 시
				//세션 값 바꾸기
				session.setAttribute("member", updateMember);
				url = "index.jsp";
			}else {
				// 수정 실패시
				url = "update.jsp";
			}
			
		}catch(UnsupportedEncodingException e ){
			System.out.println("인코딩 방식 잘못 지정");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}

}
