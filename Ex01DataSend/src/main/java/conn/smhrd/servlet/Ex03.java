package conn.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	요청 데이터 num1,num2받기
		String num1 = request.getParameter("num1");
//		String-> int타입으로 변환
//		Integer : int의 클래스 타입 -> 이 안에는 기능들이 있음
//		그중 parseInt(String) : 문자열을 순자로 바꿔즘
//		주의할 점 : parseInt("ㄱㄴㄷ")면 오류가 남 따라서 문자열 안에 숫자만 있도록!
		int int_num1 = Integer.parseInt(num1);
		
//		String num2 = request.getParameter("num2");
//		int int_num2 = Integer.parseInt(num2);
		int int_num2 = Integer.parseInt(request.getParameter("num2"));
		
//		응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	   out.print(int_num1+"+"+int_num2+"="+(int_num1+int_num2));
				
		
		
		
		
	}

}
