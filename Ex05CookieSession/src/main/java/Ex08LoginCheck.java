

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8"); // 전송 방식이 post일 때
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	     
		
		 //응답 데이터 형식지정
		response.setContentType("text/html; charset=UTF-8");
		
		if(id.equals("test")&&pw.equals("12345")){
			// 세션 객체생성
			HttpSession session = request.getSession();
		   // 세션 값 설정
			session.setAttribute("id",id);
			// main.jsp이동
			//forwarding : 데이터를 포함해서 이동하고 싶다
			//Redirecting : 이동하고 싶다
			//이 경우 이미 세션에 id가 있으므로 둘 중 아무 방식 사용해도 됨
			response.sendRedirect("Ex08Main.jsp");
		}else {
			response.sendRedirect("Ex08Logout");
		}
		
		
	}

}
